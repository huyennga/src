package javaBasic;

public class AccessModifierDemo {

    public static void main(String[] args) {
        Boss b1  = new Boss();
        System.out.println(b1.address);
        System.out.println(b1.name);
        System.out.println( b1.age);

        // báo lỗi khi dùng private attribute
        //b1.numberOfWifes

        b1.showAddress();
        b1.showWifes();
        b1.showName();
        // error here
       // b1.showAge();
    }


}

class Boss {
    // every where
    public int age;
    //same package, its subclass
    protected String name;
    // Same class
    String address;
    //Only for it
    private int numberOfWifes;

    private void  showAge(){
        System.out.println(age);
    }

    void showName(){
        System.out.println(name);
    }

    public void showAddress(){
        System.out.println(address);
    }

    public void showWifes(){
        System.out.println(numberOfWifes);
    }
}
