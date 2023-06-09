package org.example;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SetClass {
    public static void main(String[] args) {
        Set<String> names = new HashSet<>();
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
