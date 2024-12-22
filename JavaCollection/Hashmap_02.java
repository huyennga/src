package JavaCollection;

import org.testng.Assert;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class Hashmap_02 {
    public static void main(String args[])
    {

        // create a list of integers
        List<Integer>   number = Arrays.asList(2, 5, 6, 3);
        List<String> names = Arrays.asList(
                "Reflection", "Collection", "Stream", "Reflectionssss", "Redasdasd", "Reflectionsssww");
        List<String> names05 = Arrays.asList(
                "Reflection", "Collection", "Stream", "dá", "ád", "ád");
        // demonstration of map method
        List<String> a  = names.stream().filter(x -> x.startsWith("R")).collect(Collectors.toList());
        Assert.assertTrue(a.stream().anyMatch(i->i.startsWith("R")));
        System.out.println(a);

        long Count = names05.stream().distinct().count();
        System.out.println("The count of distinct elements is : " + Count);


        List<Integer> b = number.stream().sorted().collect(Collectors.toList());
        System.out.println(b);


        boolean answer = number.stream().allMatch(n-> n % 3 ==0);
        System.out.println(answer);


        boolean answer2 = number.stream().anyMatch(n-> n % 3 ==0);
        System.out.println(answer);

        boolean answer3 = number.stream().noneMatch(n-> n % 3 ==0);
        System.out.println(answer);

        Optional<Integer> answer4 = number.stream().findFirst();

        if (answer4.isPresent()) {
            System.out.println(answer4.get());
        }
        else {
            System.out.println("no value");
        }

    }
}
