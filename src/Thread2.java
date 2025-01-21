
// If we implement this way , we don't have any constraint
// If we extends it with Thread class , we cannot extend it with any other class because multiple
// inheritance is not supported in java
public class Thread2 implements Runnable{

    @Override
    public void run() {

        System.out.println("Entering Thread2.");

        for(int i=0;i<5;i++){
            System.out.println("Executing thread2 for i - " + i);
        }

        System.out.println("Exiting Thread2.");

    }
}
