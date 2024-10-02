package forkjoinpool;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

public class ForkJoinFibonacci {
    public static void main(String[] args) {
        ForkJoinPool pool = ForkJoinPool.commonPool();
        ForkJoinTask<Integer> task = pool.submit(new Fibo(10));

        try {
            Integer fiboNumber = task.get();
            System.out.println(fiboNumber);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        pool.shutdown();
    }
}

class Fibo extends RecursiveTask<Integer> {
    private Integer n;

    public Fibo(Integer n) {
        this.n = n;
    }

    @Override
    protected Integer compute() {
        if (n <= 1) return n;
        Fibo f1 = new Fibo(n - 1);
        Fibo f2 = new Fibo(n - 2);
        f1.fork();
        f2.fork();
        Integer result = f1.join() + f2.join();
        System.out.println(result);
        return result;
    }
}
