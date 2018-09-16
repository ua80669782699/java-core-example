package learning.javacore;

public class ChangeVars {

    public static void main(String[] args) {
//        Меняем местами переменные без введения третей! Побитовый ^ XOR
        int a = 1;
        int b = 2;
        a= a^b;
        b= a^b;
        a= a^b;
        System.out.println("a " +a);//2
        System.out.println("b " +b);//1
    }
}
