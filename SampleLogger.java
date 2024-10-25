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
        System.out.println("// JAVA_LOG_REGEX [ HELP ]");
    }

}
