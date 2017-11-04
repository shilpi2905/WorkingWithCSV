How to use java-error-translator library:

This is the generic CSV translator component that is packaged as a java  library which expects the translation mapping csv file into a defined directory location, which exists in the class path of the library.


Run a maven build to install the dependency.
mvn clean compile

CSVLoader.loadErrorTranslator(final String filePath)

This method loads and parses the provided Translator Mapping (CSV) file.
This api should be invoked during application initialization. This method loads and parses the CSV file passed as filename or relative filePath. Please make sure the mapping CSV file is in the classpath of your application. 
Eg,
CSVLoader.loadErrorTranslator(“src/main/resources/Mapping-Test.csv”) or
CSVLoader.loadErrorTranslator(“Mapping-Test.csv”)

If the file is not found, then method will throw IOException. Also, if the csv file is not in correct format (like header row missing or not in correct order), the api would throw ErrorTranslatorException to the calling application.  


Test Harness: 

A simple java program as Test Harness is created for showing the usage of csv library. 

