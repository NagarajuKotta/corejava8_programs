public class BlockExecutions {
    static {
        System.out.println("static block");
    }

    {
        System.out.println("Instance block");
    }

    public static void main(String[] args) {
        BlockExecutions blockExecutions = new BlockExecutions();
        System.out.println("main");
    }
}
