package javaBasic;
import  java.lang.String;
public class Replace {

    public static void main(String[] args) {
        String a = 301 + " Hoang Nga";
        a.replaceAll("\\d", " a");
        a.replaceAll("\\s", "123");
        System.out.println(a);
    }
}
