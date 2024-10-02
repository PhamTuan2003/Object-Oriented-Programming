package passby;

import java.util.Arrays;
import java.util.stream.Collectors;

public class PassByValueMutableObjectDemoClass {
    public static void main(String[] args) {
        StringBuilder companyName = new StringBuilder("Viettel Digital Services");
        abbreviate(companyName);
        System.out.println(companyName);
    }

    private static void abbreviate(StringBuilder companyName) {
        String[] words = companyName.toString().split(" ");
        companyName.delete(0, companyName.length())
                .append(Arrays.stream(words)
                        .map(word -> Character.toString(word.charAt(0)))
                        .collect(Collectors.joining(".")));
    }
}
