import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.RecursiveTask;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ForkJoinPoolTest {
    private ForkJoinPool forkJoinPool;

    @BeforeEach
    public void setUp() {
        forkJoinPool = ForkJoinPool.commonPool();
    }

    @AfterEach
    public void cleanUp() {
        forkJoinPool.shutdown();
    }

    @Test
    public void amountOfWorkerThreadsTest() {
        int workerThreads = forkJoinPool.getParallelism();
        int logicalProcessors = Runtime.getRuntime().availableProcessors();
        assertEquals(logicalProcessors - 1, workerThreads);
    }

    @Test
    public void recursiveActionTest() {
        List<RecursiveAction> tasks = new LinkedList<>();

        for (int i = 0; i < 5; i++) {
            RecursiveAction task = new RecursiveAction() {
                @Override
                protected void compute() {
                    Double result = performComplexComputation();
                    System.out.println(Thread.currentThread().getName() + " | " + result);
                }
            };
            forkJoinPool.execute(task);
            task.join();
        }

        System.out.println(forkJoinPool.getParallelism());
        System.out.println(ForkJoinPool.getCommonPoolParallelism());
    }

    @Test
    public void recursiveTaskTest() throws ExecutionException, InterruptedException {
        RecursiveTask<Double> task = new RecursiveTask<>() {
            @Override
            protected Double compute() {
                System.out.println(Thread.currentThread().getName());
                return performComplexComputation();
            }
        };

        task.fork();
        assertEquals(performComplexComputation(), task.get());
    }

    public Double performComplexComputation() {
        double result = 0;
        for (int n = 1; n <= 10000; n++) {
            for (int m = 1; m <= 10000; m++) {
                result += Math.sqrt(n) * Math.sqrt(m);
            }
        }
        return result;
    }
}
