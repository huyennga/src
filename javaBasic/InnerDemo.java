//package unit1;
//
//public class InnerDemo {
//
//    public static void main(String[] args) {
//        Outer out = new Outer();
//        out.show();
//    }
//
//    static class  Outer{
//        public void show(){
//            Inner in = new Inner();
//            in.display();
//        }
//        }
//
//        class Inner {
//            public  void display(){
//                System.out.println("I am Nga");
//            }
//        }
//    }
//
//    // neu muon call class inner trong 1 class outer
//    class C{
//        public void show(){
//            Outer.Inner in = new Outer().new Inner();
//        }
//    }
//
//
