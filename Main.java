import java.io.File;
import java.util.regex.Pattern;

public class Main {


    public static final String REGEX_PATTERN = "^[\\w,\\s-]+\\.[A-Za-z]{3}$";

    public static void main(String[] args) {

        SampleLogger sampleLogger = new SampleLogger();

        // count of arguments OR help command: check
        if (args.length < 1) {
            sampleLogger.error_no_arguments();
            return;
        } else if (args[0].equals("-help") || args[0].equals("--help") || args[0].equals("help")) {
            sampleLogger.help();
            return;
        } else if (args.length != 3) {
            sampleLogger.error_count_of_args();
            return;
        }

        // arguments validity: check
        if (!isRegexValid(args[0]) || !isPathValid(args[1]) || !isNameValid(args[2])) {
            sampleLogger.error_invalid_flags();
            return;
        }

        SampleRegexFinder sampleRegexFinder = new SampleRegexFinder();

        try {
            sampleRegexFinder.run(args[0], args[1], args[2]);
        } catch (Exception e) {
            //noinspection ThrowablePrintedToSystemOut
            System.out.println(e);
        }
    }

    public static boolean isRegexValid(String input_regex) {
        boolean answer = true;

        try {
            Pattern.compile(input_regex);
        } catch (Exception e) {
            answer = false;
        }
        return answer;
    }

    public static boolean isPathValid(String path_to_folder) {
        boolean answer = false;

        File file = new File(path_to_folder);

        if (file.isDirectory()) {
            answer = true;
        }
        return answer;
    }

    public static boolean isNameValid(String input_filename) {

        if (input_filename == null) {
            return false;
        }
        return input_filename.matches(REGEX_PATTERN);

    }


}
