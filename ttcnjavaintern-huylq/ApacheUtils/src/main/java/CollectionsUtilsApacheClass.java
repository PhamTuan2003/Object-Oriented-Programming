import org.apache.commons.collections4.CollectionUtils;

import java.util.*;

public class CollectionsUtilsApacheClass {
    public static void main(String[] args) {
        List<Integer> integers = new ArrayList<Integer>();
        CollectionUtils.addAll(integers, Arrays.asList(3, 12, 32, 362, 6542));
//        Collections.sort(integers, Collections.<Integer>reverseOrder());
//        List<Integer> collate = CollectionUtils.collate(integers, new ArrayList<Integer>(Arrays.asList(1, 32, 362, 4235)), Collections.<Integer>reverseOrder(), false);
//        System.out.println(collate);
        Collection<Integer> disjunction = CollectionUtils.disjunction(integers, new ArrayList<Integer>(Arrays.asList(1, 32, 362, 4235)));
        System.out.println(disjunction);
    }
}
