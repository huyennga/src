package javaOOP;

public class Overload {
    public static void main(String[] args) {
       Overload u = new Overload();
        System.out.println(u.add(3,5));
        System.out.println(u.add(3.5f,5));
        System.out.println(u.add(5, 4));
    }

    public int add(int a, int b){
        return a+b;
    }

    public float add(float a, int b){
        return  a+b;
    }
}
class Tutorial {
    String add(String str1, String str2){
        return str1 + str2;
    }
}
