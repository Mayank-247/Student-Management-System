package model;

public class Student {

    private int id;
    private String name;
    private String branch;
    private int age;
    private float cgpa;

    public Student() {}

    public Student(int id, String name, String branch, int age, float cgpa) {
        this.id = id;
        this.name = name;
        this.branch = branch;
        this.age = age;
        this.cgpa = cgpa;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public float getCgpa() {
        return cgpa;
    }

    public void setCgpa(float cgpa) {
        this.cgpa = cgpa;
    }
}