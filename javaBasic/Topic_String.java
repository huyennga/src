package javaBasic;

public class Topic_String {

    public static void main(java.lang.String[] args) {
        java.lang.String schoolName = "Hieu Giang";
        java.lang.String schoolName2 = "Hieu GIANG";
        java.lang.String address = "Quang Tri";
        System.out.println("Do dai = " + schoolName.length());
        System.out.println("Lay ra 1 ky tu = " + schoolName.charAt(1));
        System.out.println("Noi chuoi = " + schoolName.concat(address));
        System.out.println("Kiem tra hai chuoi bang nhau tuyet doi = " + schoolName.equals(address));
        System.out.println("Kiem tra hai chuoi bang nhau tuong doi = " + schoolName.equalsIgnoreCase(schoolName2));
        System.out.println("Co bat dau bang 1 ky tu/chuoi hay khong = " + schoolName.startsWith("H"));
        System.out.println("Co bat dau bang 1 ky tu/chuoi hay khong = " + schoolName.contains("eu"));
        System.out.println("Co Key thucbang 1 ky tu/chuoi hay khong = " + schoolName.contains("Giang"));
        System.out.println("Vi tri cua 1 ky tu/chuoi ky tu trong chuoi = " + schoolName.indexOf("g"));
        System.out.println("Tách cua 1 ky tu/chuoi ky tu trong chuoi = " + schoolName.substring(5));
        System.out.println("Tách cua 1 ky tu/chuoi ky tu trong chuoi = " + schoolName.substring(5,7));
        // tách chuổi thành 1 mãng dượ vào ký tự/ chuổi kí tự
        java.lang.String result = "View 48 of 132 results";
        java.lang.String results[] = result.split(" "); // ra duoc 4 item [View, 48, of, 132, results]

        System.out.println(results[1]);
        // Replace
        // String price = "$100.00";
        // price.replace("$", " ");
        // float priceF = Float.parseFloat(price);
        // System.out.println(priceF);

        // cắt bỏ khoảng trắng đầu và cuối chuổi
        java.lang.String place = " \n   \t   Hello world    ";
        System.out.println("cắt khoảng trắng " + place.trim());

        // covert String qua int,
        java.lang.String a = "100";
        int b = Integer.parseInt(a);
        System.out.println(a);

        // isEmpty va Blank
        a = " ";
        System.out.println("Empty " + a.isEmpty());

        // String builder
        //Phương thức append() của lớp StringBuilder nối thêm tham số vào cuối chuỗi.
        StringBuilder sb = new StringBuilder("Hello ");
        sb.append("Java");//đến đây chuỗi ban đầu đã bị thay đổi
        System.out.println(sb);//in Hello Java

    }
}
