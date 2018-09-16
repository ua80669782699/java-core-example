package learning.javacore;

import java.util.function.*;

public class FunctionInterface {
// есть огромное количество функциональных интерфейсов, самые распрастраненные... можно делать свои
    public static void main(String[] args) {
        Predicate<Integer> pre = x -> x>5; //
        pre.test(6);
        Consumer<Integer> cons = x -> System.out.println(x);
        Function<Integer, String> function = x -> x.toString();
        Supplier<Integer> supplier = () -> new Integer(5);
        UnaryOperator<Integer> unaryOperator = x -> x * x;

        MyInter<Integer> myInter = x -> System.out.println(x);
        MyInter<Integer> myInter2 = System.out::println;
    }
}
interface MyInter<T> {
    void doSome(T var);
}
