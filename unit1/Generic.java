package unit1;

import java.util.ArrayList;

public class Generic {
    public static void main(String[] args) {
        ArrayList<A> al = new ArrayList<A>();
        al.add(new A());
        al.add(new B());
    }


}

class A{

}
class B extends A{

}

