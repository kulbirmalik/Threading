import java.util.concurrent.*;

public class ExecutorServiceMain {

    public static void main(String[] args) {

        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                3,
                5,
                10,
                TimeUnit.MINUTES,
                new ArrayBlockingQueue<>(5),
                Executors.defaultThreadFactory(),
                new CustomRejectPolicy()
        );

        for(int i=1;i<=15;i++){

            executor.submit(() -> {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    // write exception here
                }
                System.out.println("Task Processed by : " + Thread.currentThread().getName());
            });

        }

        executor.shutdown();

    }


    static class CustomRejectPolicy implements RejectedExecutionHandler {

        @Override
        public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
            System.out.println("Task Rejected : " + r.toString());
        }
    }

}
