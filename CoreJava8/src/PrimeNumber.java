import java.util.stream.IntStream;

public class PrimeNumber {

    public static void main(String[] args) {
        int n = 7;
        boolean prime = primeOrNot(n);
        if (prime) {
            System.out.println("Given number is a prime number");
        } else {
            System.out.println("Given number is not a primenumber");
        }
    }

    private static boolean primeOrNot(int n) {

        if (n == 0 || n == 1) {
            return false;
        } else if (n == 2) {
            return true;
        } else {
            return IntStream.range(2, n / 2).noneMatch(i -> n % i == 0);
        }
    }
}
