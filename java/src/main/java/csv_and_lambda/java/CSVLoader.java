package csv_and_lambda.java;

import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.opencsv.CSVReader;

import csv.data.ErrorDetail;
import csv.utils.ConstantsFile;
import csv.utils.ErrorTranslatorException;


public class CSVLoader extends ConstantsFile {
    
    private static final Logger LOG = LoggerFactory.getLogger(CSVLoader.class);

    private static Set<ErrorDetail> errorDetails;

    public static void loadErrorTranslator(final String fileLocation) throws IOException, ErrorTranslatorException {

      CSVReader reader = null;
      InputStreamReader fis = null;

      try {
        if (!fileLocation.toLowerCase().endsWith(ENDSWITH_FILENAME)) {
          throw new ErrorTranslatorException(INVALID_FILENAME);
        }
        FileReader fileReader = null;
        Resource resource = new ClassPathResource(fileLocation);
        if (resource.exists()) {
          LOG.info("Inside if when resource exists ");
          String filename = resource.getFilename();
          LOG.info("File contents " + filename);
          fis = new InputStreamReader(resource.getInputStream());
          //fileReader = new FileReader(resource.getInputStream());
        } else {
          throw new IOException();
        }
        /*
         * InputStreamReader fis = null; File file = new File(fileLocation);
         * LOG.info("Absolute file path form library is " + file.getAbsolutePath());
         * LOG.info("Complete file path form library is " + file.getPath()); LOG.info("File path form library with . is "
         * + file.getCanonicalPath()); ClassLoader classLoader = CSVLoader.class.getClassLoader(); //ClassLoader
         * classLoader = ClassLoader.getSystemClassLoader(); InputStream resource =
         * classLoader.getResourceAsStream(fileLocation); if (resource != null) { // File file = new
         * File(resource.getFile()); fis = new InputStreamReader(resource);
         *
         * // fileReader = new FileReader(file); } else { // File file = new File(fileLocation); InputStream inputStream =
         * new FileInputStream(fileLocation); fis = new InputStreamReader(inputStream); // fileReader = new
         * FileReader(fileLocation); }
         */

        reader = new CSVReader(fis, ',');
        List<String[]> csvRows = reader.readAll();
        // Add condition for empty file
        if (csvRows.isEmpty()) {
          throw new ErrorTranslatorException(NO_RECORDS_FOUND);
        }

        // Processing Records upto header field
        boolean isHeaderRow = false;
        for (String[] headerRow : csvRows) {
          if (headerRow[0].startsWith(COMMENTED_LINE)) {
            continue;
          }

          String header = String.join(",", headerRow).replaceAll(" ", "");
          if (StringUtils.isBlank(header) || !header.equals(HEADER_ROW)) {
            throw new ErrorTranslatorException(INVALID_HEADER_ROW);
          } else {
            isHeaderRow = true;
            csvRows.remove(headerRow);
            break;
          }
        }

        if (!isHeaderRow) {
          throw new ErrorTranslatorException(NO_RECORDS_FOUND);
        }

        // Processing Records after Header field
        errorDetails = new TreeSet<ErrorDetail>();
        int count = 1, duplicateRows = 0, invalidRows = 0;
        for (String[] row : csvRows) {
          count++;
          if (row[0].startsWith(COMMENTED_LINE)) {
            // LOG.warn(INCOMPLETE_RECORDS + count + DUPLICATES_RECEIVED_MESSAGE1 + String.join(",", row));
            continue;
          } else if (row.length != ROW_LENGTH) {
            invalidRows++;
            LOG.warn(INVALID_RECORDS + count + DUPLICATES_RECEIVED_MESSAGE1 + String.join(",", row));
            continue;
          } else if (StringUtils.isBlank(row[DOMAIN_INDEX]) || StringUtils.isBlank(row[SYSTEM_INDEX])
              || StringUtils.isBlank(row[RESULT_INDEX])) {
            invalidRows++;
            LOG.warn(INCOMPLETE_RECORDS + count + DUPLICATES_RECEIVED_MESSAGE1 + String.join(",", row));
            continue;
          } else if (!row[RESULT_INDEX].trim().toUpperCase().matches(VALID_RESULT_VALUES)) {
            invalidRows++;
            LOG.warn(INVALID_RESULT + count + DUPLICATES_RECEIVED_MESSAGE1 + String.join(",", row));
            continue;
          } else if (!errorDetails.add(new ErrorDetail(row[DOMAIN_INDEX].trim().toUpperCase(), row[SYSTEM_INDEX].trim(),
              row[HTTP_CODE_INDEX].trim(), row[FACADE_CODE_INDEX].trim(), row[FACADE_MESSAGE_INDEX].trim(),
              row[CORE_CODE_INDEX].trim(), row[CORE_MESSAGE_INDEX].trim(), row[PROCESS_FLOW_INDEX].trim(),
              row[PROCESS_STEP_INDEX].trim(), row[RESULT_INDEX].trim(), row[UPSTEAM_CODE_INDEX].trim(),
              row[UPSTEAM_DESCRIPTION_INDEX].trim()))) {
            LOG.warn(DUPLICATES_RECEIVED_MESSAGE + count + DUPLICATES_RECEIVED_MESSAGE1 + String.join(",", row));
            duplicateRows++;

          }
        }

        LOG.info("Number of successfully Loaded Rows::" + errorDetails.size());
        LOG.info("Number of invalid Rows::" + invalidRows);
        LOG.info("Number of duplicate Rows::" + duplicateRows);

        if (errorDetails.size() > RECORD_LIMIT) {
          throw new ErrorTranslatorException(RECORD_LIMIT_EXCEPTION);
        }
      } catch (ErrorTranslatorException e) {
        LOG.error("ErrorTranslatorException during CSV Loading and Parsing ", e);
        throw e;
      } catch (IOException e) {
        LOG.error("IOException during CSV Loading and Parsing ", e);
        throw e;
      } finally {
        if (reader != null) {
          reader.close();
        }
      }
    }

    public static Set<ErrorDetail> getErrorDetails() {
      return errorDetails;
    }

}
