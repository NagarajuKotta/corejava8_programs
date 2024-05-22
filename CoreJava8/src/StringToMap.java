import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StringToMap {
    public static void main(String[] args) {
        String str = "Orange,Apple,Banana,Apple,Jackfruit,Watermelon,Orange,Apple,Banana,Dragonfruit";
        Map<String, Long> strMap = stringToMapJava8(str.split(","));
        stringToMapBeforeJava8(str.split(","));
        sortMap(strMap);
    }

    public static Map<String, Long> stringToMapJava8(String str[]) {
        System.out.println("stringToMapJava8");
        Map<String, Long> strMap = Arrays.stream(str).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(strMap);
        return strMap;
    }

    public static Map<String, Integer> stringToMapBeforeJava8(String str[]) {
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
        return strMap;
    }

    /*
    Sorting based on highest string repeated.
     */
    public static void sortMap(Map<String, Long> strMap) {
        System.out.println("Sorting Order based on value then key");
        strMap = strMap.entrySet().stream().sorted(Map.Entry.<String, Long>comparingByValue(Comparator.reverseOrder())
                .thenComparing(Map.Entry.comparingByKey())).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (o, n) -> n, LinkedHashMap::new));
        strMap.forEach((k, v) -> System.out.println(k + "--->" + v));
    }
}
