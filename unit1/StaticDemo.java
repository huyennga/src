package unit1;

public class StaticDemo {
    public static void main(String[] args) {
        Room r1 = new Room();
        r1.number = 10;
        System.out.println("R1 number:" + r1.number);
        System.out.println("Area:" + r1.area);

        Room r2 = new Room();
        r2.number = 20;
        Room.area = 300;
        System.out.println("R1 number:" + r2.number);
        System.out.println("Area:" + r2.area);

        Room r3 = new Room();
        r3.number = 30;
        System.out.println("R1 number:" + r3.number);
        System.out.println("Area:" + r3.area);

        // Voi phuong thuc co static, co the goi ham truc tiep, ko can khai bao
        Room.show();

    }
}
class Room{
    int number;
    static int area = 200;

    public static void show(){
        System.out.println("Show");
        area = 500;
        // ko the khai bao number here, vi no ko phai la static
        //number = 100;
    }

}
