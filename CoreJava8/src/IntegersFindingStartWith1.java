import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class IntegersFindingStartWith1 {
    public static void main(String[] args) {
        int arr[] = {23, 11, 34, 15, 55, 67, 18, 80};
        startWith1Java8(arr);
        startWith1BeforeJava8(arr);
    }

    static public void startWith1Java8(int arr[]) {
        List<String> startingWith = Arrays.stream(arr).mapToObj(Integer::toString).filter(x -> x.startsWith("1")).collect(Collectors.toList());
        System.out.println(startingWith);
    }

    public static void startWith1BeforeJava8(int arr[]) {
        System.out.println("---------------------------------");
        for (int i = 0; i < arr.length; ++i) {
            String str = String.valueOf(arr[i]);
            if (str.length() > 0 && str.charAt(0) == '1') {
                System.out.print(" " + str);
            }
        }
    }
}
