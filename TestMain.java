package com.oracle;

import java.util.Scanner;

public class TestMain {
    public static void main(String[] args) {
        System.out.println("welcome to jdeveloper");
        Scanner scan=new Scanner(System.in);
        System.out.println("Enetr a number:");
        int num=scan.nextInt();
        System.out.println("Enter a word:");
        String word=scan.next();
        System.out.println("Number: "+num+" Word: "+word );
        
        
   }
}
