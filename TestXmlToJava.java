package com.oracle;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

public class TestXmlToJava {
    public static void main(String[] args) {
        
        try{
            JAXBContext jaxb=JAXBContext.newInstance(Student.class);
            Unmarshaller unmarshaller=jaxb.createUnmarshaller();
            Student s=(Student)unmarshaller
                .unmarshal(new File("C:\\Users\\Nexwave\\Desktop\\xml\\students.xml"));
            System.out.println("Roll: "+s.getRollNo()+" Name: "+s.getName()+" Grade: "+s.getGrade());
        }
        catch(Exception e){
            System.out.println(e);
            }
   }
}
