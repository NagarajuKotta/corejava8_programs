import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SortStringBasedOnLength {
    public static void main(String[] args){

        //Sorting based on string length
        String str[] = {"sunday","monday", "tuesday", "wednesday","thursday","friday","saturday"};

        //1
        List<String> lengthSorting = Arrays.asList(str).stream().sorted((s1, s2)->Integer.compare(s1.length(),s2.length())).collect(Collectors.toList());
        lengthSorting.forEach(System.out::println);

        //2
        List<String> lengthSort = Arrays.stream(str).sorted(Comparator.comparingInt(String::length)).collect(Collectors.toList());
        lengthSort.forEach(System.out::println);

    }
}
