import java.io.File;

public class SampleRegexFinder {

    public void run(String input_regex, String input_path, String input_filename) {

        SampleLogger sampleLogger = new SampleLogger();

        System.out.println("First arg:  |" + input_regex);
        System.out.println("Second arg: |" + input_path);
        System.out.println("Third ard:  |" + input_filename);

        File folder = new File(input_path);
        File[] listOfFiles = folder.listFiles();

        if (listOfFiles != null) {

            int counter = 0;

            for (File listOfFile : listOfFiles) {
                String name_of_file = listOfFile.getName();
                if (listOfFile.isFile() && isCorrectExtension(name_of_file).equals("log")) {
                    // sample sout of filename for example
                    System.out.println("File " + listOfFile.getName());
                    counter += 1;
                }
            }

            if (counter > 0) {
                System.out.printf("job performed on %s files\n", counter);
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
