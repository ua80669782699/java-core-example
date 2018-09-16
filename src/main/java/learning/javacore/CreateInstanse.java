package learning.javacore;

public class CreateInstanse {
    public static void main(String[] args) {
        San san = null;
        System.out.println(san);
        San san1 = new San();
    }
}

 class Base{
    static {
        System.out.println("1");
    }

     {
         System.out.println("3");
     }

     public Base() {
         System.out.println("4");
     }
 }
class San extends Base{
    static {
        System.out.println("2");
    }

    {
        System.out.println("5");
    }

    public San() {
        System.out.println("6");
    }
}