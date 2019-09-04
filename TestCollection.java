package com.oracle;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class TestCollection {
    public static void main(String[] args) {
        Set<String> set=new TreeSet<String>();
        set.add("Alex");
        set.add("Bravo");
        set.add("Charles");
        set.add("David");
        set.add("Alex");
        System.out.println("size:" +set.size());
        for (String n : set) {
            System.out.println(n);
       }
   }
}
