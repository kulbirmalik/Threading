
public class Main {


    // Main thread --> whatever needs to be executed by main thread is written inside main method
    public static void main(String[] args) {

        System.out.println("Entering Main Thread.");

        // defining thread using lambda function in java
        Thread thread3 = new Thread(() -> {
            for(int i=0;i<5;i++){
                System.out.println("Executing " + Thread.currentThread() + " for i - " + i);
            }
        }, "thread3");


        System.out.println("Exiting Main Thread.");

    }
}