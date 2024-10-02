import junit.framework.TestCase;
import org.apache.commons.collections4.CollectionUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CollectionUtilsApacheTest extends TestCase {

    public void testAddIgnoreNull() {
        List<Integer> integers = IntStream.range(0, 10).boxed().collect(Collectors.toList());
        CollectionUtils.addIgnoreNull(integers, null);
        assertFalse(integers.contains(null));
    }

    public void testCollate() {
        List<Integer> integers = IntStream.range(0, 10).boxed().collect(Collectors.toList());
        List<Integer> collate = CollectionUtils.collate(integers, new ArrayList<>(Arrays.asList(-23, 11, 23)));
        assertEquals(collate.size(), 13);
        assertEquals(-23, (int) collate.get(0));
        assertEquals(23, (int) collate.get(collate.size() - 1));
    }

    public void testFilter() {
        List<Integer> integers = IntStream.range(0, 10).boxed().collect(Collectors.toList());
        CollectionUtils.filter(integers, integer -> integer >= 5);
        assertEquals(integers.size(), 5);
    }

    public void testSubtract() {
        List<Integer> integers = IntStream.range(0, 10).boxed().collect(Collectors.toList());
        Collection<Integer> subtract = CollectionUtils.subtract(integers, Arrays.asList(1, 2, 3, 4, 5));
        assertFalse(subtract.contains(2));
    }

    public void testIntersection() {
        List<Integer> integers = IntStream.range(0, 10).boxed().collect(Collectors.toList());
        Collection<Integer> intersection = CollectionUtils.intersection(integers, Arrays.asList(1, 2, 3, 4, 5));
        assertEquals(intersection.size(), 5);
    }
}