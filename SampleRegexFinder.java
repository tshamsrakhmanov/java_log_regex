import java.io.*;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SampleRegexFinder {

    @SuppressWarnings("ResultOfMethodCallIgnored")
    public void run(String input_regex, String input_path, String input_filename) throws IOException {

        SampleLogger sampleLogger = new SampleLogger();
        File folder = new File(input_path);
        File[] listOfFiles = folder.listFiles();



        if (listOfFiles != null) {

            int applicable_files_scanned = 0;

            // run through files in folder, if they even present
            for (File listOfFile : listOfFiles) {

                int applicable_strings = 0;
                String name_of_file = listOfFile.getName();

                // create folder right beside of inspected files
                File theDir = new File(input_path + "/regex_passed/");
                if (!theDir.exists()){
                    theDir.mkdirs();
                }

                // create temp file, where we'll store all positive regex results (mode - append to the end)
                File temp_file = new File(theDir + "/" + input_filename);
                Writer output_internal = new BufferedWriter(new FileWriter(temp_file, true));

                // if there is file, and it goes with .log extension - so scan it
                if (listOfFile.isFile() && isCorrectExtension(name_of_file).equals("log")) {

                    FileInputStream fis = new FileInputStream(listOfFile.getAbsolutePath());
                    Scanner sc = new Scanner(fis);

                    // scanning process of file line-by-line
                    while (sc.hasNextLine()) {

                        String temp_string = sc.nextLine();

                        Pattern pattern = Pattern.compile(input_regex);
                        Matcher matcher = pattern.matcher(temp_string);

                        boolean isRegexPass = matcher.matches();

                        // if Regex is OK - so add line so new file
                        if (isRegexPass) {
                            output_internal.append(matcher.group(0));
                            output_internal.append("\n");
                            applicable_strings += 1;
                        }
                    }

                    output_internal.close();

                    // need to count how many times (files) have been inspected
                    if (applicable_strings > 0) {
                        applicable_files_scanned += 1;
                    }
                }
            }

            //
            if (applicable_files_scanned > 0) {
                sampleLogger.success();
            } else {
                // remove redundant files, which were created during program run - just because i don't know how to manage it in a more clever way, duh
                File myObj = new File(input_path + "/regex_passed/" + input_filename);
                File myObj2 = new File(input_path + "/regex_passed/");
                myObj.delete();
                myObj2.delete();
                sampleLogger.error_no_files_detected();
            }

        } else {
            sampleLogger.error_no_files_detected();
        }

    }

    public static String isCorrectExtension(String input_filename) throws IllegalArgumentException {

        if (input_filename.length() == 3) {
            return input_filename;
        } else if (input_filename.length() > 3) {
            return input_filename.substring(input_filename.length() - 3);
        } else {
            // whatever is appropriate in this case
            throw new IllegalArgumentException("word has fewer than 3 characters!");
        }
    }

}
