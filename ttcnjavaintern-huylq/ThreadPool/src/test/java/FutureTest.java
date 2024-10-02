import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.util.concurrent.*;

import static org.junit.jupiter.api.Assertions.*;

public class FutureTest {
    private ExecutorService executorService;

    @BeforeEach
    public void setUp() {
        executorService = Executors.newCachedThreadPool();
    }

    @AfterEach
    public void cleanUp() {
        executorService.shutdown();
    }

    @Test
    public void testFutureGet() throws ExecutionException, InterruptedException {
        Future<String> future = executorService.submit(() -> "Future");
        String resource = future.get();
        assertEquals("Future", resource);
    }

    @Test
    public void testFutureCancelInterruptRunningTrue() {
        Future<String> future = executorService.submit(() -> {
            sleep(3000);
            return "Task is done";
        });
        sleep(1000);
        assertTrue(future.cancel(true));
    }

    @Test
    public void testFutureCancelInterruptRunningFalse() {
        executorService.submit(() -> {
            sleep(3000);
            return "Future";
        });
    }

    private void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
