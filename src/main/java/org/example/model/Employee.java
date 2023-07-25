package org.example.model;

public class Employee {
    private String name;
    private String department;
    private int age;

    private long salary;

    private String city;

    public Employee() {
    }

    public Employee(String name, String department, int age, long salary,String city) {
        this.name = name;
        this.department = department;
        this.age = age;
        this.salary = salary;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
