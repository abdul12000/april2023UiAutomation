package org.example;

//import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;


public class MapClass {
//    @Test
    public void mapTest() {
        Map<String, Integer> StudentsAge= new HashMap<>();
        StudentsAge.put("Tomi", 25);
        StudentsAge.put("Yemi", 29);
        StudentsAge.put("Bismark", 30);
        StudentsAge.put("Bismark", 40);
        StudentsAge.put("Ebun", 27);
        StudentsAge.put("Lateef", 26);

        System.out.println(StudentsAge.get("Bismark"));
        for(Map.Entry i : StudentsAge.entrySet()){
            System.out.println(i.getKey() + " " + i.getValue());
        }
        System.out.println("hello");

    }
}
