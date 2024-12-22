package javaBasic;

import java.util.ArrayList;

public class ArrayList_Vector {
    public static void main(String[] args) {
        ArrayList al = new ArrayList();
        al.add("Nga");
        al.add("Hoang");
        // al.add(new Integer(10));
        // al.add(new Integer(5));
        al.remove(al.get(3));
        System.out.println(al);

        for (int i = 0; i < al.size(); i++){
            System.out.println(al.get(i));
        }
    }
}
