import java.util.ArrayList;

public class Help {

    public static void printHelp() {

        // array list of instructions 
        ArrayList < String > help = new ArrayList < String > ();
        
        // adding intructions to the array list of help
        help.add("\nThis is the information to assist you in using this program.");
        help.add("\n");
        help.add("Possile Arguments: ");
        help.add("\n-Help:Prints help and guide for this program:");
        help.add("\nHttpRequest [URL] example:"); 
        help.add("java sak -HttpRequest https://www.cnn.com/");
        help.add("java sak -HttpRequest https://www.lewisu.edu/");
        help.add("\nHttpRequestIndex [URL] example:");
        help.add("java sak -HttpRequestIndex https://thunderbird-index.azurewebsites.net/w0a6zk195d.json");
        
        help.add("\n-Sleep:goes to sleep for 1 second and calculates elapsed time" );
        help.add(" java sak -Sleep");
        help.add("\n-SleepFast: Threaded Sleep and non-threaded sleep- extending thread" );
        help.add(" java sak -SleepFast");
        help.add("\n-SleepFastImplementsRunnable: Threaded Sleep and non-threaded sleep- implementing Runnable" );
        help.add(" java sak -SleepFastImplementsRunnable");

        // print out help message
        for (String helpMessage: help) {
            System.out.println(helpMessage);

        }
    }

}