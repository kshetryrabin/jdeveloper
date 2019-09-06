package com.oracle;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestReExp {
    public static void main(String[] args) {
       //Pattern p=Pattern.compile("[ \t]");
       // Pattern p=Pattern.compile("[A-Z0-9]");
      // Pattern p=Pattern.compile("[^l]");
       Pattern p=Pattern.compile("\\p{javaLowerCase}");
        Matcher m=p.matcher("Hello Every1 Welcome 2 Java 8 Course");
        int counter=0;
        while(m.find()){
            System.out.println("Matched Pattern: "+m.group());
            System.out.println("at: "+m.start());
            System.out.println("ends at: "+m.end());
            counter++;
            }
System.out.println("Occurences: "+counter);        
   }
}
