package com.oracle;

//import java.io.File;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TestReadWrite {
    public static void main(String[] args) {
        try(            FileReader fr = new FileReader("C:\\demo\\abc.txt");
            FileWriter fw= new FileWriter("C:\\demo\\vbn.txt");
                        ) {
           
            
           // BufferedReader br= new BufferedReader(fr);
            //BufferedWriter bw= new BufferedWriter(fw);
            
           // FileReader fr1 = new FileReader("C:\\demo\\xyz.txt");
            //FileWriter fw1= new FileWriter("C:\\demo\\pqr.txt");
            int code=0;
           // char c=null;
           // String line=null;
            int loopCounter=0;
            while((code= fr.read()) !=-1){
                 char c=(char)code;
                if(Character.isLowerCase(c)){
                    c=Character.toUpperCase(c);
                   // code=c;
                       
                        
                    }
                else if(Character.isUpperCase(c)){
                    c=Character.toLowerCase(c);
                   // code=c;
                        //fw.write(c);
                       // loopCounter++;
                    }
                    fw.write(c);
                    loopCounter++;
               
               
                //fw.newLine();
              //  fw1.write(code);
              
                }
            //fw.flush();
           // fr.close();
           // fw.close();
          //  fw1.flush();
          //  fr1.close();
           // fw1.close();
            System.out.println("file written and counter is:"+loopCounter);
        } catch (FileNotFoundException e) {
            System.err.println(e);
        } catch (IOException e) {
            System.err.println(e);
        }

    }
}
