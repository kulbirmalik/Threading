import java.util.concurrent.*;

public class CompletableFutureMain {

    public static void main(String[] args) {

        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                3,
                5,
                10,
                TimeUnit.MINUTES,
                new ArrayBlockingQueue<>(5),
                Executors.defaultThreadFactory(),
                new ExecutorServiceMain.CustomRejectPolicy()
        );

        CompletableFuture<String> asyncTask1 = CompletableFuture.supplyAsync(
                () -> {
                    System.out.println("Thread Name of supply Async - " + Thread.currentThread().getName());
                    // doing some task
                    return "Task Completed.";
                }
                , executor);

        asyncTask1.thenApply((String val) -> {
            System.out.println("Thread Name of then Apply - " + Thread.currentThread().getName());
            return val + "With then apply";
        });


        try {
            System.out.println(asyncTask1.get());
        } catch (Exception e){
            // catch exception here
        }

    }

}
