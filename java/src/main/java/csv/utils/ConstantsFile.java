package csv.utils;

public class ConstantsFile {

    public static final String HEADER_ROW = "DOMAIN,SYSTEM,HTTP_CODE,FACADE_CODE,FACADE_MESSAGE,CORE_CODE,CORE_MESSAGE,"
            + "PROCESS_FLOW,PROCESS_STEP,RESULT,UPSTREAM_CODE,UPSTREAM_DESCRIPTION";
        public static final String INVALID_FILE_STRUCTURE = "Error in parsing CSV file. "
            + "File structure does not contain mandatory fields";
        public static final String INVALID_HEADER_ROW = "Header row is missing or not in correct format";
        public static final String NO_RECORDS_FOUND = "No content specified in the Error Mapping File";
        public static final String DUPLICATES_RECEIVED_MESSAGE = "Duplicates are present in csv file at line: ";
        public static final String DUPLICATES_RECEIVED_MESSAGE1 = " for record: ";
        public static final String INCOMPLETE_RECORDS = "Mandatory attributes (DOMAIN, SYSTEM, RESULT) are missing at line: ";
        public static final String INVALID_RECORDS = "Invalid record found  at line: ";
        public static final String RECORD_LIMIT_EXCEPTION = "CSV File contain more than 1000 valid records.";
        public static final String INVALID_RESULT = "Result field does not contain "
            + "valid (SUCCESS | FAIL) value at line: ";
        public static final String INVALID_FILENAME = "Error loading CSV file";
        public static final String COMMENTED_LINE = "##";
        public static final String ENDSWITH_FILENAME = ".csv";
        public static final String DOMAIN = "DOMAIN";
        public static final String SYSTEM = "SYSTEM";
        public static final String HTTP_CODE = "HTTP_CODE";
        public static final String FACADE_CODE = "FACADE_CODE";
        public static final String FACADE_MESSAGE = "FACADE_MESSAGE";
        public static final String CORE_CODE = "CORE_CODE";
        public static final String CORE_MESSAGE = "CORE_MESSAGE";
        public static final String PROCESS_FLOW = "PROCESS_FLOW";
        public static final String PROCESS_STEP = "PROCESS_STEP";
        public static final String RESULT = "RESULT";
        public static final String UPSTEAM_CODE = "UPSTEAM_CODE";
        public static final String UPSTEAM_DESCRIPTION = "UPSTEAM_DESCRIPTION";
        public static final String VALID_RESULT_VALUES = "SUCCESS|FAIL";
        public static final String RESULT_UNDEFINED = "UNDEFINED";
        public static final int DOMAIN_INDEX = 0;
        public static final int SYSTEM_INDEX = 1;
        public static final int HTTP_CODE_INDEX = 2;
        public static final int FACADE_CODE_INDEX = 3;
        public static final int FACADE_MESSAGE_INDEX = 4;
        public static final int CORE_CODE_INDEX = 5;
        public static final int CORE_MESSAGE_INDEX = 6;
        public static final int PROCESS_FLOW_INDEX = 7;
        public static final int PROCESS_STEP_INDEX = 8;
        public static final int RESULT_INDEX = 9;
        public static final int UPSTEAM_CODE_INDEX = 10;
        public static final int UPSTEAM_DESCRIPTION_INDEX = 11;
        public static final int ROW_LENGTH = 12;
        public static final long RECORD_LIMIT = 1000;

}
