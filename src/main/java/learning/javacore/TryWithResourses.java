package learning.javacore;

public class TryWithResourses {
    public static void main(String[] args) {

        try(WithTry withTry = new WithTry(new InnerWithTry())){
            System.out.println("try");
        }finally {
            System.out.println("finally");
        }

    }
}

class WithTry implements AutoCloseable{

    InnerWithTry innerWithTry;
    public WithTry(InnerWithTry innerWithTry) {
        this.innerWithTry = innerWithTry;
    }

    @Override
    public void close(){
        System.out.println("close");
        innerWithTry.close();
    }
}
class InnerWithTry implements AutoCloseable{
    @Override
    public void close(){
        System.out.println("Inner close");
    }
}