package com.oracle;

public class TestStrings {
    public static void main(String[] args) {
        String s1,s2,s3,s4;
        s1="hello";
        s2="hello";
        s3=new String("hello");
        s4="HELLO";
        System.out.println("s1==s2:"+(s1==s2));
        System.out.println("s1==s3:"+(s1==s3));
        System.out.println("s1 equals s3:"+s1.equals(s3));
        System.out.println("s1 equals s4:"+s1.equals(s4));
        System.out.println("s1 equalsignorecase s4"+s1.equalsIgnoreCase(s4));
        StringBuffer sb1= new StringBuffer("hello");
        System.out.println(sb1);
        sb1.append("123");
        System.out.println("sb1="+sb1);
        sb1.deleteCharAt(2);
        System.out.println(sb1);
        
   }
}
