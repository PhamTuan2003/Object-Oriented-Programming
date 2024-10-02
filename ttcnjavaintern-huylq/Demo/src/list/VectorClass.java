package list;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class VectorClass {
    public static void main(String[] args) {
//        Vector<Integer> integers = new Vector<>();
//        integers.add(1);
//        integers.addElement(2);
//        integers.removeAllElements();
//        integers.addAll(Arrays.asList(3, 4, 5, 6));
//        integers.removeElement(4);
//        System.out.println("First element: " + integers.firstElement());
//        System.out.println("Last element: " + integers.lastElement());
//        Enumeration<Integer> elements = integers.elements();
//        while (elements.hasMoreElements()) {
//            System.out.println(elements.nextElement());
//        }


        Stack<String> strings = new Stack<>();
        strings.add("Thomas");
        strings.add("John");
        strings.add("Arthur");
        System.out.println("Top element of the stack: " + strings.peek());

        strings.push("Shelby");
        System.out.println("Top element of the stack: " + strings.pop());
        Enumeration<String> enumeration = strings.elements();
        while (enumeration.hasMoreElements()) {
            System.out.println(enumeration.nextElement());
        }
//        System.out.println(strings.empty());
//        System.out.println(strings.isEmpty());
//        System.out.println(strings.search("John"));
//        System.out.println(strings.peek());
//        strings.add(0, "Hung");
//        System.out.println(strings.peek());
//        System.out.println(strings.get(0));;
    }
}
