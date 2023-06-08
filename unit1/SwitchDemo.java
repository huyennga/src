package unit1;

public class SwitchDemo {

    public static void main(String[] args) {
        int age = 10;
        switch (age) {
            case 0:
                System.out.println("Zero");
                break;
            case 10:
                 System.out.println("Ten");
                break;
            case 20:
                 System.out.println("Twenty");
                 break;
            default:
                System.out.println("default");
                 break;
        }
    }
}
