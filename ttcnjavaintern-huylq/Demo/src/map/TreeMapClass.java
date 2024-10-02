package map;

import model.Student;

import java.util.Map;
import java.util.TreeMap;

public class TreeMapClass {
    public static void main(String[] args) {
        Map<String, Student> stringStudentMap = new TreeMap<>();
        stringStudentMap.put("Phong", new Student(4L, "Phong"));
        stringStudentMap.put("Duy", new Student(2L, "Duy"));
        stringStudentMap.put("Huy", new Student(1L, "Huy"));
        stringStudentMap.put("Long", new Student(3L, "Long"));
//        for (Map.Entry<Long, Student> student : stringStudentMap.entrySet()) {
//            System.out.println(student.getKey() + " " + student.getValue());
//        }
        stringStudentMap.forEach((aLong, student) -> System.out.println("Key: " + aLong + " | Value: " + student));
    }
}
