package learning.javacore;

public class Test {
    public static void main(String[] args) {
        long freeMemory = Runtime.getRuntime().freeMemory();
        long availableProcessors = Runtime.getRuntime().availableProcessors();
        System.out.println("freeMemory - " + freeMemory + "\navailableProcessors - " + availableProcessors);
    }
}
