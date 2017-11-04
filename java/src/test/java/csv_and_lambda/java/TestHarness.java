package csv_and_lambda.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import csv.utils.ErrorTranslatorException;



public class TestHarness {
    public static final String EXIT_COMMAND = "exit";
    public static void main(final String[] args) throws ErrorTranslatorException {
        try {
          BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
          String input = null;
          System.out.println("Enter File Location, or '" + EXIT_COMMAND + "' to quit");
          input = br.readLine();
          CSVLoader.loadErrorTranslator(input);
          // System.out.println(CSVLoader.getErrorDetails());
          while (true) {
            System.out.println(
                "Enter Error Translator input params separated via ',' in format (system, coreCode, coreDescription, "
                    + "facadeCode, facadeDescription, httpCode, processFlow, processStep). "
                    + "Enter null or give blank space for skipping attribute");
            System.out.print("> ");
            input = br.readLine();
            String[] inputParams = input.split(",");
            for(int i =0; i < inputParams.length; i++){
              if(inputParams[i].equals("null")){
                inputParams[i] = null;
              }
              if(inputParams[i].equals("\"\"")){
                inputParams[i] = "";
              }
            }
            if (input.length() == EXIT_COMMAND.length() && input.toLowerCase().equals(EXIT_COMMAND)) {
              System.out.println("Exiting.");
              return;
            }
          }
        } catch (IOException e) {
          e.printStackTrace();
        }
       // System.out.println("...response goes here...");
      }
}
