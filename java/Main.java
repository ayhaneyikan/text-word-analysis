import java.util.concurrent.ThreadLocalRandom;

public class Main {

    public static int[] list;

    public static void main(String[] args) {
        if (args.length != 1) {  // one additional
            System.out.println("Error: single integer argument expected");
            System.exit(1);
        }

        // create list of random integers
        list = new int[Integer.parseInt(args[0])];
        for (int i = 0; i < list.length; i++)
            list[i] = ThreadLocalRandom.current().nextInt(0, 10001);
        
        // create threads
        SumThread r = new SumThread();
        Thread t = new Thread(r, "Thread");
        t.start();

        try {
            t.join();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        for (int i = 0; i < list.length; i++)
            System.out.println(list[i]);

    }
}