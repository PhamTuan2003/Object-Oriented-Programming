package map;

import model.Student;

import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapClass {
    public static void main(String[] args) {
        LinkedHashMap<Integer, Student> integerStudentMap = new LinkedHashMap<>();
        integerStudentMap.put(4, new Student(4L, "Phong"));
        integerStudentMap.put(2, new Student(2L, "Duy"));
        integerStudentMap.put(1, new Student(1L, "Huy"));
        integerStudentMap.put(3, new Student(3L, "Long"));

//        integerStudentMap.forEach((integer, student) -> System.out.println("ID: " + integer + " " + student));
        integerStudentMap.compute(7, (integer, student) -> new Student(5L, "Thomas"));
//        integerStudentMap.forEach((integer, student) -> System.out.println("ID: " + integer + " " + student));
        integerStudentMap.forEach((integer, student) -> System.out.println("ID: " + integer + " " + student));
    }
}
