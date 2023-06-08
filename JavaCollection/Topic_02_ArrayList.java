package JavaCollection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Topic_02_ArrayList {


    public static void main(String[] args) {
        String[] student = {"Nam", "Ha", "Hoang"};
         List<String> animal = new ArrayList<String>();
        animal.add("cho");
        animal.add("meo");
        // chen 1 list vao list hien tại
        animal.addAll(List.of(student));
        System.out.println(animal);

        animal.add(1, "add them");
        System.out.println(animal);
        // set la thay the (replace) vi tri nao do = mot value moi, con Add là  add (insert) thêm vào vị trị đó 1 value mới
        animal.set(1, "Thay the");
        System.out.println(animal);
        // remove
        animal.remove("Thay the");
        System.out.println(animal);
        // remove all
        animal.removeAll(animal);
        System.out.println(animal);

        // add lai tu dau
        animal.add("cho");
        animal.add("meo");
        System.out.println(animal);
        // remove =  cach clear, dung cách này nhanh hơn remove
        // animal.clear();
        // System.out.println(animal);

        String[] animalArray =  new  String[animal.size()];
        List<String> abc = Arrays.asList(animalArray);
        for (String a :animalArray) {
            System.out.println(animalArray);
        }


    }
}
