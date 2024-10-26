import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SampleRegexFinder {

    public void run(String input_regex, String input_path, String input_filename) throws FileNotFoundException {

        SampleLogger sampleLogger = new SampleLogger();

        System.out.println("First arg:  |" + input_regex);
        System.out.println("Second arg: |" + input_path);
        System.out.println("Third ard:  |" + input_filename);

        File folder = new File(input_path);
        File[] listOfFiles = folder.listFiles();

        if (listOfFiles != null) {

            int applicable_files_scanned = 0;

            for (File listOfFile : listOfFiles) {

                int applicable_strings = 0;

                String name_of_file = listOfFile.getName();
                if (listOfFile.isFile() && isCorrectExtension(name_of_file).equals("log")) {
                    // sample sout of filename for example
                    System.out.println("\\ File " + listOfFile.getName());

                    FileInputStream fis = new FileInputStream(listOfFile.getAbsolutePath());
                    Scanner sc = new Scanner(fis);

                    while (sc.hasNextLine()) {

                        String temp_string = sc.nextLine();

                        Pattern pattern = Pattern.compile(input_regex);
                        Matcher matcher = pattern.matcher(temp_string);
                        boolean isRegexPass = matcher.matches();

                        if (isRegexPass) {
                            System.out.println(matcher.group(0));
                            applicable_strings += 1;
                        }
                    }


                    // need to count how many times (files) have been inspected

                    if (applicable_strings > 0) {
                        applicable_files_scanned += 1;
                    }
                }
            }

            if (applicable_files_scanned > 0) {
                sampleLogger.success();
            } else {
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
