package learning.javacore;

import java.time.LocalDate;
import java.time.Month;
import java.util.Calendar;
import java.util.function.Predicate;

public class Polimorfizm {

    public static void main(String[] args) {
        Object ff=null;
        String g = (String)ff;


        Parent test = new SanC();
        System.out.println(6^3);
        System.out.println(test.b);
        System.out.println(test.methodpublic());

        System.out.println(LocalDate.of(2015, Calendar.APRIL, 1));
        System.out.println(LocalDate.of(2015, Month.APRIL, 1));
//        System.out.println(LocalDate.of(2015, 3, 1));
        System.out.println(LocalDate.of(2015, 4, 1));
//        System.out.println(new LocalDate(2015, 3, 1));
//        System.out.println(new LocalDate(2015, 4, 1));
    }
}
class Parent {
//    public static String a = "parent statik field";
//    private static String a1 = "parent statik 1 field";

    public String b = "parent public field";
    private String c = "parent private field";

//    static String method(){
//        System.out.println("parent statik method " + a);
//        return a;
//    }
    public String methodpublic(){
        System.out.println("parent public method");
        return b;
    }
    private String methodPrivate(){
        System.out.println("parent Private method");
        return c;
    }
}
class SanC extends Parent{
    //static String a = "SanC statik field";
    public String b = "SanC public field";
    private String c = "SanC private field";

//    static String method(){
//        System.out.println("SanC statik method");
//        return a;
//    }
//    static String methodddd(){
//        method();
//        System.out.println("SanC statik method");
//        return a;
//    }


    public String methodpublic(){
        System.out.println("SanC public method");
        return b;
    }

    private String methodPrivate(){
        System.out.println("SanC Private method");
        return c;
    }

}



class T{
    public static void main(String[] args) {
        A q = new B();
        q.b();

    }
}

class A {
    int a = 1;

    public static void dosome(){
        System.out.println("1");
    }

    void a() {
        System.out.println("A-a");
    }

    void b() {
        System.out.println("A-b " + a);
        this.a();
    }
}

class B extends A {
    int a = 2;

    public static void dosome(){
        dosome();
        System.out.println("2");
    }
    void a() {
        System.out.println("B-a " + a);
    }

    void b() {
        System.out.println("B-b");
        super.b();
    }
}



