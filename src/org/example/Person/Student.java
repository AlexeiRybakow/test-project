package org.example.Person;

import java.util.HashMap;

public class Student {

    public String Surname;
    public String Name;
    public String MiddleName;
    public String group;
    public HashMap<String, Integer> AcademicPerformance = new HashMap<>();

    public Student(String Surname, String Name, String MiddleName, String group){
        this.Surname = Surname;
        this.Name = Name;
        this.MiddleName = MiddleName;
        this.group = group;

    }

    @Override
    public String toString() {
        return "Student{" +
                "Surname='" + Surname + '\'' +
                ", Name='" + Name + '\'' +
                ", MiddleName='" + MiddleName + '\'' +
                ", group='" + group + '\'' +
                ", AcademicPerformance=" + AcademicPerformance +
                '}';
    }


}
