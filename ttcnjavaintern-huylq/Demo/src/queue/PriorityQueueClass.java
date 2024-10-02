package queue;

import model.Student;

import java.util.*;

public class PriorityQueueClass {
    public static void main(String[] args) {
//        PriorityQueue<Integer> integers = new PriorityQueue<>();
//        integers.add(1);
//        integers.addAll(Arrays.asList(3, 6, -34, 4, 10));
//        System.out.println(integers);
//
//        Iterator<Integer> iterator = integers.iterator();
//        while(iterator.hasNext()) {
//            Integer next = iterator.next();
//            if(next.equals(-34)) {
//                integers.remove(next);
//            }
//        }

        /* Student Queue */
        Queue<Student> students = new PriorityQueue<>(Comparator.comparing(Student::getName));
        students.add(new Student(1L, "Huy"));
        students.add(new Student(2L, "Thomas"));
        students.add(new Student(3L, "Michael"));

        System.out.println(students.remove());
//
//        while (!integers.isEmpty()){
//            System.out.println(integers.remove());
//        }
//        System.out.println(integers.peek());
//        System.out.println(integers.element());;
//        System.out.println(integers);
    }
}
