import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CompletableFutureTest {
    private static List<Employee> employees;

    @BeforeAll
    public static void setUp() {
        employees = new LinkedList<>();
        employees.add(new Employee(1, "Huy", Employee.Gender.MALE, LocalDate.of(1998, Month.OCTOBER, 2)));
        employees.add(new Employee(2, "Jack", Employee.Gender.MALE, LocalDate.of(1975, Month.MAY, 2)));
        employees.add(new Employee(3, "Mike", Employee.Gender.MALE, LocalDate.of(1999, Month.JANUARY, 2)));
        employees.add(new Employee(4, "Thomas", Employee.Gender.MALE, LocalDate.of(1996, Month.OCTOBER, 2)));
        employees.add(new Employee(5, "Arthur", Employee.Gender.MALE, LocalDate.of(2002, Month.OCTOBER, 2)));
        employees.add(new Employee(6, "John", Employee.Gender.MALE, LocalDate.of(2000, Month.OCTOBER, 2)));
    }

    @Test
    public void supplyAsyncTest() throws ExecutionException, InterruptedException {
        CompletableFuture<Integer> completableFuture = CompletableFuture.supplyAsync(() -> "0")
                .thenApply(Integer::parseInt)
                .completeAsync(() -> 10).orTimeout(1, TimeUnit.NANOSECONDS);
        assertEquals(0, completableFuture.get());
    }

    @Test
    public void flatCompletableFutureTest() throws ExecutionException, InterruptedException {
        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> "supplyAsync").thenCompose(CompletableFuture::completedFuture);
        assertEquals("supplyAsync", completableFuture.get());
    }

    @Test
    public void completableFutureTimeoutTest() throws ExecutionException, InterruptedException {
        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> {
            sleep(2000);
            return "supplyAsync";
        }).completeOnTimeout("Timeout", 1000, TimeUnit.MILLISECONDS);
        assertEquals("Timeout", completableFuture.get());
    }

    private void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Employee {
    private int id;
    private String name;
    private Gender gender;
    private LocalDate dob;

    enum Gender {MALE, FEMALE}

    public Employee(int id, String name, Gender gender, LocalDate dob) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.dob = dob;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Gender getGender() {
        return gender;
    }

    public int getAge() {
        return Period.between(dob, LocalDate.now()).getYears();
    }
}
