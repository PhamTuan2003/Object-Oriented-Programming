import org.apache.commons.collections4.MapUtils;

import java.util.HashMap;
import java.util.Map;

public class MapUtilsApache {
    private static final String[][] color2DArray = new String[][]{
            {"RED", "#FF0000"},
            {"GREEN", "#00FF00"},
            {"BLUE", "#0000FF"}
    };
    private static final String[] color1DArray = new String[]{
            "RED", "#FF0000",
            "GREEN", "#00FF00",
            "BLUE", "#0000FF"
    };
    private static Map<String, String> colorMap;

    public static void main(String[] args) {
        colorMap = MapUtils.putAll(new HashMap<>(), color1DArray);
        MapUtils.verbosePrint(System.out, "Color Map", colorMap);

        Map<String, String> invertMap = MapUtils.invertMap(colorMap);
        MapUtils.verbosePrint(System.out, "Invert Color Map", invertMap);
    }

}
