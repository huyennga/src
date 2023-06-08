package For_ForEach_Stream;

import java.util.ArrayList;
import java.util.List;

public class Unit01_For_ForEach_Stream {
    public static void main(String[] args) {

            String[] arr = { "1", "2", "3" };
            int count = 0;

            String[] arr1 = { "Geeks", "For", "Geeks" };

            for (String str : arr) {
                System.out.print(arr1[count++]);
            }
            /// forEach
            String[] arr3 = { "1", "2", "3" };
            int count2 = 0;

            String[] arr4 = { "Geeks", "For", "Geeks" };

            // for (String str : arr3) {
            //     System.out.print(arr1[count++]);
            // }

            //
        List<String> arr5  = new ArrayList<String>();
        arr5.add("Geeks");
        arr5.add("For");
        arr5.add("Geeks");

        arr5.parallelStream().forEach(s -> {
            System.out.print(s);
        });

    }
}
