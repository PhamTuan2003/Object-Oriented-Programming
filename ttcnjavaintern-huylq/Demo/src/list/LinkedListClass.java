package list;

import java.util.*;

public class LinkedListClass {
    public static void main(String[] args) {
        LinkedList<String> stringLinkedList = new LinkedList<>(Arrays.asList("Huy", "Duy", "Long", "Phong", "Duc", "Thang"));
//        ListIterator<String> stringListIterator = stringLinkedList.listIterator();
//        while(stringListIterator.hasNext()){
//            String name = stringListIterator.next();
//            if("Phong".equals(name)){
//                stringLinkedList.remove(name);
//            }
//        }
        stringLinkedList.forEach(System.out::println);
        System.out.println("Get third element: " + stringLinkedList.get(3));
        System.out.println("Peek first: " + stringLinkedList.peekFirst());
        System.out.println("Peek: " + stringLinkedList.peek());
        System.out.println("Peek last: " + stringLinkedList.peekLast());
//        System.out.println("Poll first:" + stringLinkedList.poll());
//        System.out.println("Pop: " + stringLinkedList.pop());
//        System.out.println("Remove first: " + stringLinkedList.remove());

    }
}
