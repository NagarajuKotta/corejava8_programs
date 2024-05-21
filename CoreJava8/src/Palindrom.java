import java.util.stream.IntStream;

public class Palindrom {
    public static void main(String[] args) {
        String str = "maddama";
        withjava8(str);
        withoutjava8(str);
    }

    public static void withjava8(String str) {
        System.out.println("***** In Java8 ******");
        Boolean palindrom = IntStream.range(0, str.length()/2).allMatch(i->str.charAt(i) == str.charAt(str.length()-1-i));
        System.out.println(palindrom ? "Given string is a palindrom" : "Given string is not a palindrom");
        System.out.println("----------------------------------------------------------------");
    }

    public static void withoutjava8(String str) {
        System.out.println("***** Before Java8 ******");
        boolean palindrom =  false;
        for(int i=0; i<str.length()/2; ++i){
            if(str.charAt(i) == str.charAt(str.length()-1-i)){
                palindrom = true;
            }else{
                palindrom = false;
                break;
            }
        }
        System.out.println(palindrom? "Given string is a palindrom" : "Given string is not a palindrom");
        System.out.println("----------------------------------------------------------------");
    }

}
