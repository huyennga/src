package javaBasic;

import  java.lang.String;
public class Math {


    public static void main(String[] args) {
        int a = 0;
        int b = 3;
        int result;
         result = a+b;
        // a +=b; // a = a +b

        System.out.println("a " + a);
        System.out.println("a%b"  + a%b);  // lấy số dư 10/3  là 1

        String name = "Nga";
        name = name + "18+";
        System.out.println(name);  // in ra Nga18+

        if((a++ <10) || (b-- <5))
        {
            System.out.println("a: " + a +" b: " +b);
        }
        else{
            System.out.println("a2: " + a +" b2: " +b);
        }
    }
}
