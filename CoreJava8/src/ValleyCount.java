import java.util.concurrent.atomic.AtomicInteger;

public class ValleyCount {
    public static void main(String[] args) {
        String str = "DUDUUUUUUUUDUDDUUDUUDDDUUDDDDDUUDUUUUDDDUUUUUUUDDUDUDUUUDDDDUUDDDUDDDDUUDDUDDUUUDUUUDUUDUDUDDDDDDDDD";
        int valleyCount = valleyCount(str);
        System.out.println("Valley Count = " + valleyCount);
        int vCount = valleyCountJava8(str);
        System.out.println("Valley Count = " + vCount);
    }

    public static int valleyCount(String str) {
        int valley = 0;
        int level = 0;
        for (char ch : str.toCharArray()) {
            if (ch == 'U') {
                level++;
                if (level == 0)
                    valley++;
            } else {
                if (ch == 'D')
                    level--;
            }
        }
        return valley;
    }

    public static int valleyCountJava8(String str) {
        AtomicInteger valley = new AtomicInteger(0);
        AtomicInteger level = new AtomicInteger(0);
        str.chars().forEach(ch -> {
                    if (ch == 'U') {
                        if (level.incrementAndGet() == 0)
                            valley.incrementAndGet();
                    } else if (ch == 'D') {
                        level.decrementAndGet();
                    }
                }
        );

        return valley.get();
    }
}
