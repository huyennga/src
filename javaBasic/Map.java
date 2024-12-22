package javaBasic;

import java.util.HashMap;

public class Map {
    public static void main(String[] args) {
        HashMap map = new HashMap();
        map.put("Ten", "Nga");
        map.put(new Integer(5), "tuoi");
        System.out.println(map);
        System.out.println(map.get("Ten"));
       // remove 1 doi tuong
        map.remove("Ten");
        System.out.println(map.get("Ten"));

        java.util.Map<java.lang.String, java.lang.String> payload = new HashMap<>();
        payload.put("roleId", "1222222");
        payload.put("type", "LICENSE");
        System.out.println(payload);
    }

}
