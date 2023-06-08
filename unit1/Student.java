package unit1;

public class Student {
    public String name = "Nga";
    public int age = 30;

    public Student(int i, String hoang, String haNoi) {
    }

    public  void  showStudent(){
        System.out.println("Name " + name );
        System.out.println("Tuoi " + age);
    }

    public  int addNumber(int a, int b){
        int sum = a+b;
        return sum;
    }

    public static void main(String[] args) {
        Student s1=new Student(101,"Hoang","HaNoi");
        Student s2=new Student(102,"Thanh","HaiPhong");

        System.out.println(s1.toString());//compiler se viet o day la s1.toString()
        System.out.println(s2);//compiler se viet o day la s2.toString()
    }
}
