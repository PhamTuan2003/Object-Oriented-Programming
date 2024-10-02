package set;

import model.Student;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class HashSetClass {
    public static void main(String[] args) {
        Set<Integer> integerSet = new HashSet<>(IntStream.range(0, 10).boxed().collect(Collectors.toSet()));
        integerSet.add(23);
        integerSet.addAll(Arrays.asList(23, 13));
        System.out.println(integerSet);
//        integerSet.forEach(i -> System.out.println(i.hashCode()));

        /* Fail-Fast */
//        Iterator<Integer> iterator = integerSet.iterator();
//        while(iterator.hasNext()) {
//            Integer current = iterator.next();
//            if(current == 3) {
//                integerSet.remove(current);
//            }
//        }
    }

}
