package list;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ArrayListClass {
    public static void main(String[] args) {
        List<Integer> integerArrayList = new ArrayList<>();
        integerArrayList.add(0, 1);
        integerArrayList.add(2);
        integerArrayList.addAll(2, Arrays.asList(3, 4, 5));
        integerArrayList.removeIf(i -> i == 2);
        integerArrayList.forEach(System.out::println);
    }
}
