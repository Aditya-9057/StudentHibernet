package com.Adityabhosale;


import jakarta.persistence.*;

@Entity
//@Table(name = "stud")
public class Student {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int roll;

    //@Column(name = "st_name",length = 20 ,nullable = false ,unique = true)
    private String name;

    //@Column(name = "st_mks")
    private float marks;

    public Student() {
    }

    public Student(int roll, String name, float marks) {
        this.roll = roll;
        this.name = name;
        this.marks = marks;
    }

    public int getRoll() {
        return roll;
    }

    public void setRoll(int roll) {
        this.roll = roll;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getMarks() {
        return marks;
    }

    public void setMarks(float marks) {
        this.marks = marks;
    }

    @Override
    public String toString() {
        return "Student{" +
                "roll=" + roll +
                ", name='" + name + '\'' +
                ", marks=" + marks +
                '}';
    }
}
