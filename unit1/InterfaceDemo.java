package unit1;

public class InterfaceDemo {
    public static void main(String[] args) {
        Manager man = new Manager();
        man.show();
    }


}
interface Human{
    public static final int AVG_AGE = 100;
    int AVG_WEIGHT = 60;
   // int AVG_WEIGHT = 60;

    // du khai bao co public abstract ha int hay ko, thi no cung hieu la co abstract, int
    public abstract void show();
    void study();
}

class  Manager implements Human{
    @Override
    public void show() {
        System.out.println("Age " + AVG_AGE);

    }

    @Override
    public void study() {

    }
}
