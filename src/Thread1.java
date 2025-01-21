


public class Thread1 extends Thread{


    // Whatever needs to be executed by this thread is written inside run method
    @Override
    public void run(){

        System.out.println("Entering Thread1.");

        for(int i=0;i<5;i++){
            System.out.println("Executing thread1 for i - " + i);
        }

        System.out.println("Exiting Thread1.");

    }
}
