package future;

import java.util.concurrent.*;

public class FutureMain {
    /**
     * cancel(true) -> cancel future, interrupt thread -> can handle interrupt exception
     * cancel(false) -> cancel future, not interrupt thread
     */
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        Future<String> future = executorService.submit(() -> {
            sleep(3000);
            for (int i = 0; i < 5; i++) {
                System.out.println("Task is running...");
                sleep(1000);
            }
            return "Future";
        });

        sleep(100);
        System.out.println(future.cancel(true));
        System.out.println("isDone: " + future.isDone() + " | isCancelled: " + future.isCancelled());
//        try {
//            System.out.println(future.get());
//        } catch (InterruptedException | ExecutionException e) {
//            e.printStackTrace();
//        }

        executorService.shutdown();

    }

    private static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
