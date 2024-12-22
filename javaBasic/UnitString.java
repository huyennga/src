package javaBasic;
// import org.apache.commons.lang3.StringUtils;
import  java.lang.String;

public class UnitString {
    public static void main(String[] args) {
        String blog = "StudyAndShare";
        System.out.println(blog);
        System.out.println(blog.length());
        System.out.println(blog.charAt(4));
//        System.out.println(blog.toLowerCase(Locale.ROOT));
        System.out.println(blog.indexOf(7));

        String name  = " Hoang Nga ";
        System.out.println(name);
        System.out.println(name.trim());
//  lấy một chuổi con trong 1 chuổi cha
        String a ="Last validated 3:00PM";
        // StringUtils.substringAfter(a, "Last validated ");


    }
}
