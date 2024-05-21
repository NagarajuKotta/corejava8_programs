import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StringToMap {
    public static void main(String[] args) {
        String str = "Orange,Apple,Banana,Apple,Jackfruit,Watermelon,Orange,Apple,Banana,Dragonfruit";
        stringToMapJava8(str.split(","));
        stringToMapBeforeJava8(str.split(","));
    }

    public static void stringToMapJava8(String str[]) {
        System.out.println("stringToMapJava8");
        Map<String, Long> strMap = Arrays.stream(str).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(strMap);
    }

    public static void stringToMapBeforeJava8(String str[]) {
        System.out.println("stringToMapBeforeJava8");
        Map<String, Integer> strMap = new HashMap<>();
        for (String st : str) {
            /*if (strMap.containsKey(st)) {
                strMap.put(st, strMap.get(st) + 1);
            } else {
                strMap.put(st, 1);
            }*/

            strMap.put(st, strMap.getOrDefault(st, 0) + 1);
        }
        System.out.println(strMap);
    }
}
