package learning.javacore;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class ThrowExaption {

    public static void main(String[] args) {
        try {
            someFoo();
        } catch (IOException e) {
            System.out.println("main " + e.getMessage());
        }
    }

    static void someFoo() throws IOException {
//                new ArrayList<>()
        String dd = "dd";
        String dd1 = "dd";
        try {
            System.out.println("1");
            throw new IOException("1");
        }catch (Exception e){
            System.out.println("2");
            throw new IOException("2");
        }finally {
            System.out.println("3");
            throw new IOException("3");
        }
    }
}
