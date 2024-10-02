package map;

import model.Student;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class HashMapClass {
    public static void main(String[] args) {
        Map<Long, Student> longStudentMap = new HashMap<>();
        longStudentMap.put(4L, new Student(4L, "Phong"));
        longStudentMap.put(2L, new Student(2L, "Duy"));
        longStudentMap.put(1L, new Student(1L, "Huy"));
        longStudentMap.put(3L, new Student(3L, "Long"));
//        for (Map.Entry<Long, Student> student : longStudentMap.entrySet()) {
//            System.out.println(student.getKey() + " " + student.getValue());
//        }
        System.out.println(longStudentMap.get(2L));
        longStudentMap.forEach((aLong, student) -> System.out.println("Key: " + aLong + " | Value: " + student));
    }
}
