package learning.javacore;

import java.math.BigInteger;
import java.util.HashMap;

//факториал 3, значит результат предидущего шага умножаем на следующее число
// 1*1=1
// 1*2=2
// 2*3=6
public class Factorial {

    public static void main(String[] args) {
// почему с 66 елемента 0? пореполняется на столько что с права в бинарном представлении все знаки 0 и в целом печатает 0
//        factorial(Integer.MAX_VALUE);

                    factorial(100000L);
//        factorialRecursiya(100000L);

//        factorialHabr(1000);
    }

    private static long factorial(long factor){
        long sum = 1;
        for(long i = 1; i<=factor ; i++){
            sum = sum * i;
            System.out.println(i + " + " + sum);
        }
        return sum;
    }

    private static Long factorialRecursiya(Long factor){
        if(factor == 0){
            return 1L;
        }else{
            Long res = factor * factorialRecursiya(factor -1);
            System.out.println(factor + " + " + res);
            return res;
        }
    }


//---с хабра ------------------------------------------------------------------------
    public static BigInteger factorialHabr(int n) {
        BigInteger ret = BigInteger.ONE;
        for (int i = 1; i <= n; ++i)
            ret = ret.multiply(BigInteger.valueOf(i));
        return ret;
    }
}
