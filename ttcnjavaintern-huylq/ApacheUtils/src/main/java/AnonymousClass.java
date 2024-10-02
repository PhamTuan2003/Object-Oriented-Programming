import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

public class AnonymousClass {
    public static void main(String[] args) {
        List<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(34);
        integers.add(10);
        integers.add(13);

        Comparator<Integer> integerComparator= new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        };

        Collections.sort(integers, integerComparator);
//        Function
    }
}
