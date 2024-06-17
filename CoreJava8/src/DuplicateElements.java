import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class DuplicateElements {

    public static void main(String[] args) {
        List<Integer> integerList = new ArrayList<>();
        integerList.add(10);
        integerList.add(20);
        integerList.add(30);
        integerList.add(70);
        integerList.add(50);
        integerList.add(20);
        integerList.add(80);
        integerList.add(70);
        System.out.println("Given list of Integers : " + integerList);
        System.out.println("---------------------------------------");
        System.out.println("Duplicate List of Integers");
        System.out.println("=======================================");
        Set<Integer> duplicateList = integerList.stream().filter(l -> Collections.frequency(integerList, l) > 1).collect(Collectors.toSet());
        System.out.println(duplicateList);

        System.out.println("---------------------------------------");

        Map<Integer, Long> frequencyMap = integerList.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        Set<Integer> duplicateSet = frequencyMap.entrySet().stream().filter(entry -> entry.getValue() > 1).map(Map.Entry::getKey).collect(Collectors.toSet());
        System.out.println(duplicateSet);

        System.out.println("---------------------------------------");
        Set<Integer> dupSet = new HashSet<>();
        Set<Integer> duplicateElements = integerList.stream().filter(n -> !dupSet.add(n)).collect(Collectors.toSet());
        System.out.println(duplicateSet);

    }
}
