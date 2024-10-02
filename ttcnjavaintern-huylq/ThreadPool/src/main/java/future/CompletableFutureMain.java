package future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinWorkerThread;

public class CompletableFutureMain {
    public static void main(String[] args) {
        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> "Future").thenCompose(CompletableFuture::completedFuture);

        try {
            completableFuture.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread());
        System.out.println(Thread.currentThread() instanceof ForkJoinWorkerThread);
    }
}
