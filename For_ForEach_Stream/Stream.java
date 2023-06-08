package For_ForEach_Stream;

public class Stream {
    public static void filterByEvenElements()
    {
        // create integer array
        Integer[] myArray
                = new Integer[] { 1, 4, 5, 7, 9, 10 };

        // create a stream and filter by
        // even numbers predicate
        Stream.of(myArray)
                .filter(x -> x % 2 == 0)
                .forEach(System.out::println);
    }
    public static void main(String[] args)
    {
        // filters a stream by even elements
        filterByEvenElements();
        System.out.println("======");

        // // filters a stream by starting string
        // filterByStartsWith();
        // System.out.println("======");
        //
        // // filters a stream by starting vowel
        // filterByStartsWithVowelsRegex();
    }

}
