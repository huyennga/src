package While_For;

import javax.sound.midi.Soundbank;
import java.util.Scanner;

public class WhileDemo {
    public static void main(String args[]) {
        //
        // int i =0;
        // while (i <10){
        //     System.out.println(" i: " + i);
        //     i++;
        // }

        // chuyển số thập phân sang nhị phân
        int n;
        Scanner sc = new Scanner(System.in);
        System.out.println("nhap vap so nguyen > 0");
        n = sc.nextInt();

        String nhiPhan = "";
        while (n>0){
            nhiPhan = (n%2) + nhiPhan;
            n = n/2;
        }
        System.out.println("số hệ nhị phân là" + nhiPhan);

        /*
        * chia liên tục cho 2 và lấy phần dư
        * đảo ngược chuổi  => ra kết quả
        * 10:2 = 5 dư 0
        * 5:2 = 2 dư 1
        * 2:2 = 1 dư 0
        * 1:2 = 0 dư 1
        * ==> 1010
         */

    }
}
