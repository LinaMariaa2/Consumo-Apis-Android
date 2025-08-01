package com.lina.consumoapis.model;

public class PostEmployee {
    private String name;
    private double salary;
    private int age;
// Utilizamos otro modelo para post porque vamos a enviar propiedades especificas
    public PostEmployee() {

    }

    public PostEmployee(String name, double salary, int age){
        this.name = name;
        this.salary = salary;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }
    public void setSalary(double salary) {
        this.salary = salary;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
}
