import junit.framework.TestCase;
import org.apache.commons.collections4.MapUtils;

import java.util.HashMap;
import java.util.Map;

public class MapUtilsApacheTest extends TestCase {
    private final String[][] color2DArray = new String[][]{
            {"RED", "#FF0000"},
            {"GREEN", "#00FF00"},
            {"BLUE", "#0000FF"}
    };
    private final String[] color1DArray = new String[]{
            "RED", "#FF0000",
            "GREEN", "#00FF00",
            "BLUE", "#0000FF"
    };
    private Map<String, String> colorMap;

    public void testPutAllWith1DArray() {
        colorMap = MapUtils.putAll(new HashMap<>(), color1DArray);
        assertTrue(colorMap.containsKey("RED"));
        assertTrue(colorMap.containsKey("GREEN"));
        assertTrue(colorMap.containsKey("BLUE"));
        assertTrue(colorMap.containsValue(color1DArray[1]));
        assertTrue(colorMap.containsValue(color1DArray[3]));
        assertTrue(colorMap.containsValue(color1DArray[5]));
    }

    public void testPutAllWith2DArray() {
        colorMap = MapUtils.putAll(new HashMap<>(), color2DArray);
        assertTrue(colorMap.containsKey("RED"));
        assertTrue(colorMap.containsKey("GREEN"));
        assertTrue(colorMap.containsKey("BLUE"));
        assertTrue(colorMap.containsValue(color2DArray[0][1]));
        assertTrue(colorMap.containsValue(color2DArray[1][1]));
        assertTrue(colorMap.containsValue(color2DArray[2][1]));
    }

    public void testSafeAdd(){
        colorMap = MapUtils.putAll(new HashMap<>(), color1DArray);
    }
}