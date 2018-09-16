package learning.javacore;

import jdk.nashorn.internal.ir.annotations.Immutable;

import java.util.*;

public class Collection {

    public static void main(String[] args) {
//        LinkedList<Object> objects = new LinkedList<>();
//        objects.get(1);
//
//        ArrayList arrayList = new ArrayList();
//        arrayList.get(1);
//        arrayList.add(5);

//        Pasport pasport = new Pasport("some");
//
//         Object peopleValue = new Object();
//
//        HashMap<Pasport, Object> objectObjectHashMap = new HashMap<>();
//        objectObjectHashMap.put(pasport, peopleValue);
//
//        pasport.nomber = "jjj";
//        objectObjectHashMap.get(pasport);

        HashMap oMap = new HashMap<>();
        oMap.put(null, "ee");
        oMap.put(null, "e1e");
        System.out.println(oMap.get(null));


    }

}


class Pasport {

    public Pasport(String nomber) {
        this.nomber = nomber;
    }

    private String nomber;

    public String getNomber() {
        return nomber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Pasport pasport = (Pasport) o;
        return Objects.equals(nomber, pasport.nomber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nomber);
    }


}