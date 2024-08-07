import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FrequencyOfEachCharacter {
    public static void main(String[] args){
        String str = "Iamajavaprogrammer";
        Map<Character, Long> charFrequency = str.chars().mapToObj(c->(char)c).collect(Collectors.groupingBy(
                Function.identity(), LinkedHashMap::new, Collectors.counting()
        ));

    }
}
