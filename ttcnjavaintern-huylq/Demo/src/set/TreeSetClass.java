package set;

import model.Student;

import java.util.*;

public class TreeSetClass {
    public static void main(String[] args) {
        /* Sorted by natural order */
        Set<Integer> integerSet = new TreeSet<>();
        integerSet.addAll(Arrays.asList(5, 3, 2, 1, 4, 7));
        integerSet.add(23);
        integerSet.add(-2);
        System.out.println(integerSet);

        /* Sorted by Comparator */
//        Set<Student> students = new TreeSet<>(Comparator.comparing(Student::getName));
//        students.add(new Student(1L, "Huy"));
//        students.add(new Student(2L, "Alex"));
//        students.add(new Student(2L, "Alex"));
//        students.add(new Student(2L, "Alex"));
//        students.add(new Student(26L, "asfdioahsdlkhflasdlhriowqy234235@$#@!"));
//        students.forEach(System.out::println);

        /* Navigable Set */
        TreeSet<Integer> times = new TreeSet<>();
        times.add(1205); // add some departure times
        times.add(1505);
        times.add(1600);
        times.add(2000);
        times.add(1545);
        times.add(1830);
        times.add(2010);
        times.add(2100);
        System.out.println(times);

//
//        TreeSet<Integer> integers = (TreeSet<Integer>) times.headSet(1600);
//        System.out.println("Head set: " + integers);
//        TreeSet<Integer> tailSet = (TreeSet<Integer>) times.tailSet(2000);
//        System.out.println("Tail set: " + tailSet);
//        System.out.println(times);

//        System.out.println("Last before 4pm is: " + times.floor(1600));
//        System.out.println("Last after 6pm is: " + times.higher(2000));
//
//        System.out.println("Poll first: " + times.pollFirst());
//        System.out.println("Poll last: " + times.pollLast());
//
//        System.out.println(times);
    }
}
