package javaBasic;

public class Overwrite extends Tutorial35{
    public static void main(String[] args) {
        Overwrite o = new Overwrite();
        o.show();
        System.out.println(o.sum(10,5));
    }
        void show(){
            System.out.println("Nga Hoang");
        }

        int sum(int a, int b){
            return a-b;
        }
    }


 class Tutorial35{
    void show(){
        System.out.println("Hoang Nga 18 tuoi roi");
    }

    int sum(int a, int b){
        return a+b;
    }
 }