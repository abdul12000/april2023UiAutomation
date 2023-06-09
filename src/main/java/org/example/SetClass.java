package org.example;

import java.util.ArrayList;
import java.util.List;

public class ListClass {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("Tomi");
        names.add("Yemi");
        names.add("Bismark");
        names.add("Ebun");
        names.add("Ebun");
        names.add("");
        names.add("Ebun");
        for(String i : names){
            System.out.println(i);
        }
    }
}
