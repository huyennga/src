package unit1;

public class ArrayDemo {
    public static void main(String[] args) {
        //có 2 cách để khai báo mảng như bên dưới
        int [] arrInt1 = new int[10];
        int [] arrInt2 =  {2,3,4,5};



        // mảng 2 chiều
        int [][] arrInt3 = new int[2][3];
      //  int [][] arrInt4 = {10,11,12}{15,16,17,18};

        // mang 1 chiều
        for (int i =0; i < arrInt2.length; i++){
            System.out.println(arrInt2[i]);
        }

        // mảng 2 chiều
        for (int i =0; i < 2; i++){
            for(int j=0; j < 3; j++){
                System.out.print(arrInt3[i][j] + " ");
            }
            System.out.println("");
        }
    }
}
