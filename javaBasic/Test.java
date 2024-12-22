package javaBasic;

import java.util.ArrayList;
import java.util.List;
import  java.lang.String;

public class Test {

    public static void main(String args[]) {
        Integer x = 5;
       String a = "Nga";
      List list = new ArrayList();
        list.add("a");
        list.add("b");
        ArrayList<String> ar = new ArrayList<>();
        ar.addAll(list);

        ArrayList nga = new ArrayList<>();

        System.out.println(x.toString());
        System.out.println(Integer.toString(12));
        System.out.println(a.toString());
//        System.out.println(abc.toString());
        System.out.println(list.toString());
        System.out.println(ar.toString());
//        System.out.println(one.toString());
    }


}
