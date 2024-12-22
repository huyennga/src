package For_ForEach_Stream;

import java.util.Arrays;
import java.util.List;

public class Stream02 {
    public static void main(String[] args) {
        List<Person> persons = Arrays.asList(
                new Person("Alice", 23),
                new Person("Bob", 17),
                new Person("Charlie", 30),
                new Person("David", 20),
                new Person("Eve", 15)
        );

        // Example using Stream, filter, and noneMatch
        boolean noneMatchResult = persons.stream()
                .filter(p -> p.getAge() >= 18)
                .noneMatch(p -> p.getName().startsWith("A"));

        System.out.println("None of the filtered persons have a name that starts with 'A': " + noneMatchResult);
    }
}

class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age + "}";
    }
}
