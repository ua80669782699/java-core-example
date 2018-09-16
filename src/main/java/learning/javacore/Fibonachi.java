package learning.javacore;

//каждое последующее число равно сумме двух предыдущих чисел
public class Fibonachi {

    public static void main(String[] args) {
        System.out.println(fibonachiRekurs(6));
//        fibonachi(6);
    }

    private static int fibonachiRekurs(int i) {
        if(i <= 2){
            return 1;
        }else{
            return fibonachiRekurs( i -2 ) + fibonachiRekurs( i -1 );
        }
    }

    private static int fibonachi(int fibo) {
        int temp = 0;
        int last = 1;
        int preLast = 0;
        System.out.println(last);
        for(int i = 1; i < fibo ; i++){
            temp = last + preLast;
            preLast = last;
            last = temp;
            System.out.println(temp);
        }
        return last;
    }
}
