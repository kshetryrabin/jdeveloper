package com.oracle;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Student {
    
    private String rollNo;//tag name in xml file and variable name in java must be same
    private String name;
    private String grade;

    public void setRollNo(String rollNo) {
        this.rollNo = rollNo;
    }

    public String getRollNo() {
        return rollNo;
    }

    public void setName(String name) {
        this.name = name;
    }
    @XmlElement(name="studentName")
    public String getName() {
        return name;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getGrade() {
        return grade;
    }

}

/*
 * <student>
 *  <rollno>
 *  <name>
 *  <grade>
 *  </student>
 */
