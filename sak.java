/* Diya Patel
Object Oriented Programming
Sprint 6 : Command Line Application , SwissAmryKnife2

Credits: Professor Eric Pogue for HttpRequest.java and SleepFast.java
*/

import java.util.ArrayList;

public class sak {
    public static void main(String[] args) {
        
        if ((args.length < 1) || (args[0].equalsIgnoreCase("-Help"))) {

            long start = System.currentTimeMillis();
            if (args.length < 1) {
             
              
                System.out.println("Please enter one argument to utilize this application. Please use the \"-Help\"argument for" + "more information. Help section is printed below");
                Help.printHelp();
                long end = System.currentTimeMillis();
                long elapsedTime = end - start;
                System.out.println("Elapsed time: "+ elapsedTime);
           
            }
        
            System.exit(0);      
        }

        // Responding to the -HttpRequest [URL]” and "-HttpRequestIndex [URL]" command-line parameter assuming case insensitivity
        else if (((args[0].equalsIgnoreCase("-HttpRequest")) || (args[0].equalsIgnoreCase("-HttpRequestIndex"))) && (args.length != 2)) {

            long start = System.currentTimeMillis();
            System.out.println("The argumennt provided is not a valid input. Please use the -Help argument for a guide");
            long end = System.currentTimeMillis();
            long elapsedTime = end - start;
            System.out.println("Elapsed time: "+ elapsedTime);
            System.exit(0);

        }
       

        // responsing the httprequest and printing the data to the command line
        if (args[0].equalsIgnoreCase("-HttpRequest")) {

            String url = args[1];
            long start = System.currentTimeMillis();
            HttpRequest request = new HttpRequest();
            System.out.println("-executing request");
            
            if (request.readURL(url)) {
                
                System.out.println(request);
                
                   
            } else {
                System.out.format("Unable to access", url);
            } 

            long end = System.currentTimeMillis();
            long elapsedTime = end - start;
            System.out.println("Elapsed time: "+ elapsedTime);
            
           
        }

        // responding to -httprequestindex and printing the data 
        
        if (args[0].equalsIgnoreCase("-HttpRequestIndex")) {

            String url = args[1];
            long start = System.currentTimeMillis();
            HttpRequestIndex requestIndex = new HttpRequestIndex();
             System.out.println("-executing HttpRequestIndex");

            if (requestIndex.readURL(url)) {
                System.out.println(requestIndex);
            
            
                }
             else {
                System.out.format("Unable to access requested URL: ", url); 
            }
            long end = System.currentTimeMillis();
            long elapsedTime = end - start;
            System.out.println("Elapsed time: "+ elapsedTime);
        }
        String url2 = args[0];
        if (args[0].equalsIgnoreCase("-Sleep")){
            
            System.out.println("Starting Sleep...");

            OneSecondSleeper sleeper0 = new OneSecondSleeper(0);
            OneSecondSleeper sleeper1 = new OneSecondSleeper(1);

            System.out.println("\nSleep");
            long start = System.currentTimeMillis();
            sleeper0.sleep();
            sleeper1.sleep();
            System.out.println("Elapsed time = " + (System.currentTimeMillis() - start) + "\n");

         }   

         if(args[0].equalsIgnoreCase("-SleepFastImplementsRunnable")){

            System.out.println("Starting sleep....");

            OneSecond sleeper0 = new OneSecond(0); // create onee sec sleeper
            OneSecond sleeper1 = new OneSecond(1); // create onee sec sleeper

            System.out.println("\nNon-Threded Sleep");
            long start = System.currentTimeMillis(); // grab the current time

            sleeper0.sleep(); // tired... sleeping
            sleeper1.sleep(); // tired... sleeping

            System.out.println("Elapsed time = " + (System.currentTimeMillis() - start)); // calculate elapsed time

            System.out.println("\nThreaded Sleep");
            start = System.currentTimeMillis(); // grab the current time
        
            Thread t0 = new Thread(sleeper0);
            Thread t1 = new Thread(sleeper1);

            t0.start(); //calls run on a separate thrread
            t1.start(); // starts without waiting

        //joins threads togetjer when they are done
            try {
                t0.join();
                t1.join();

            } catch (Exception e) {
                System.out.println("Exception" + e);
        }
            System.out.println("Elapsed time = " + (System.currentTimeMillis() - start)); // calculate elapsed time

        //sleeping arrayloist 2 through 11 
            ArrayList < OneSecond > sleeperList = new ArrayList < OneSecond > ();
            for (int i = 2; i < 12; i++) {
                sleeperList.add(new OneSecond(i));
        }

            System.out.println("\nNon-Threaded ArrayList Sleep:");
            start = System.currentTimeMillis();
            for (OneSecond s: sleeperList) {
                s.sleep();
        }

            System.out.println("Elapsed time = " + (System.currentTimeMillis() - start));

            System.out.println("\nThreaded ArrayList Sleep:");

            ArrayList < Thread> threadList = new ArrayList <Thread>();
            for (OneSecond s: sleeperList) {
                threadList.add(new Thread(s));
        }
            start = System.currentTimeMillis();
            for (Thread t: threadList) {
                t.start();
        }

            try {
                for (Thread t: threadList) {
                    t.join();
            }
        }   catch (Exception e) {
                System.out.println("Exception" + e);
        }
            System.out.println("Elapsed time = " + (System.currentTimeMillis() - start));


    }

        if (args[0].equalsIgnoreCase("-SleepFast")){
            System.out.println("Starting Sleep...");

            OneSec sleeper0 = new OneSec(0);
            OneSec sleeper1 = new OneSec(1);

            System.out.println("\nNon-threaded Sleep");
            long start = System.currentTimeMillis();
            sleeper0.sleep();
            sleeper1.sleep();
            System.out.println("Elapsed time = " + (System.currentTimeMillis() - start) + "\n");

            System.out.println("\nThreaded Sleep");
            start = System.currentTimeMillis();
            sleeper0.start();
            sleeper1.start();

            try {
                sleeper0.join();
                sleeper1.join();
            } catch (Exception e) {
                System.out.println("Exception" + e);
    }
            System.out.println("Elapsed time = " + (System.currentTimeMillis() - start) + "\n");

    // Sleeping ArrayList
            ArrayList<OneSec> sleeperList = new ArrayList<OneSec>();
            for (int i=2; i<12; i++) {
                sleeperList.add(new OneSec(i));
    }

            System.out.println("\nNon-threaded ArrayList sleep:");
            start = System.currentTimeMillis();
            for (OneSec s: sleeperList) {
                s.sleep();
    }
            System.out.println("Elapsed time = " + (System.currentTimeMillis() - start));

            System.out.println("\nThreaded ArrayList sleep:");
            start = System.currentTimeMillis();
            for (OneSec s: sleeperList) {
                s.start();
    }

            try {
                for (OneSec s: sleeperList) {
                    s.join();
        }
            }catch (Exception e) {
                System.out.println("Exception: " + e);
    }
            System.out.println("Elapsed time = "+(System.currentTimeMillis()-start));
    }

    
}
}
   
       
class OneSecondSleeper {
    private int sleepNumber;
    OneSecondSleeper(int sleepNumberIn) {
        sleepNumber = sleepNumberIn;
    }

    public void sleep() {
        System.out.println(sleepNumber + " - Going to sleep");
        try {
            Thread.sleep(1000); // Sleep for one second. 
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }

        System.out.println("... " + sleepNumber + " - Done sleeping");
    }
}

class OneSecond implements Runnable {

    private int sleepNumber;

    // takes sleep number in 
    OneSecond(int sleepNumberIn) {
        sleepNumber = sleepNumberIn;
    }

    public void sleep() {
        System.out.println(sleepNumber + " - going to sleep");
        try {
            Thread.sleep(1000); //sleep for one second

        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }

        System.out.println("...." + sleepNumber + "- Done sleeping");

    }

    // run as threads
    public void run() {
        sleep();
    }
}

class OneSec extends Thread {
    private int sleepNumber;
    OneSec(int sleepNumberIn) {
        sleepNumber = sleepNumberIn;
    }

    public void sleep() {
        System.out.println(sleepNumber + " - Going to sleep");
        try {
            Thread.sleep(1000); // Sleep for one second. 
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }

        System.out.println("... " + sleepNumber + " - Done sleeping");
    }

    public void run() {
        sleep();
    }
}









        




           

