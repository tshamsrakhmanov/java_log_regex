public class SampleLogger {
    public void error_no_arguments (){
        System.out.println("// JAVA_LOG_REGEX [ ERROR ]");
        System.out.println("// No arguments provided");
        System.out.println("// Please verify your input. More instructions by --help or -help");
    }

    public void error_count_of_args(){
        System.out.println("// JAVA_LOG_REGEX [ ERROR ]");
        System.out.println("// Count of arguments are not valid");
        System.out.println("// Please verify your input. More instructions by --help or -help");
    }

    public void error_invalid_flags(){
        System.out.println("// JAVA_LOG_REGEX [ ERROR ]");
        System.out.println("// Invalid arguments provided.");
        System.out.println("// Please verify your input. More instructions by --help or -help");
    }

    public void help(){
        System.out.println("JAVA_LOG_REGEX [ HELP ]");
        System.out.println("Usage: java -jar <jar filename> [REGEX] [PATH] [FILE NAME]");
        System.out.println("[REGEX]{mandatory}");
        System.out.println("    Regular expression by which each string of log file(s) will be matched");
        System.out.println("    Matching process performed based on partly-matches, not a full-string");
        System.out.println("    Correct regex must be provide");
        System.out.println("[PATH]{mandatory}");
        System.out.println("    Path to a folder, where log files reside");
        System.out.println("    In case of missing .log files - program will exit with no result");
        System.out.println("[FILE NAME]");
        System.out.println("    Name of a file - with or without extention based on your desires - where to save regex match results");
        System.out.println("    Multiple runs of the program with the same input - .log files - will lead to fill of the same file with same match results (append mode)");
        System.out.println();
        System.out.println("Author: Timur Shamsrakhmanov");
        System.out.println("Autumn 2024");
    }

    public void error_no_files_detected(){
        System.out.println("// JAVA_LOG_REGEX [ ERROR ]");
        System.out.println("// No files or no regex applicable strings are detected by path.");
    }

    public void success(){
        System.out.println("// JAVA_LOG_REGEX [ INFO ]");
        System.out.println("// Success!");
    }

}
