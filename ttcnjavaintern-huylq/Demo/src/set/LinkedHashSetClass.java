package set;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

public class LinkedHashSetClass {
    public static void main(String[] args) {
        LinkedHashSet<Integer> integerSet = new LinkedHashSet<>();
        integerSet.addAll(Arrays.asList(2, 3, 5, 7, 13));
        integerSet.add(23);
        integerSet.add(-2);
        integerSet.remove(5);
        System.out.println(integerSet);
    }
}
