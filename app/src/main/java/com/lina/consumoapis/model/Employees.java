package com.lina.consumoapis.model;

public class Employees {
//Declaramos propiedades del empleado
    private int id;
    private String employee_name;
    private Double employee_salary;
    private int employee_age;
    private String profile_image;

    // Este es el constructor vacío, necesario para convertir json a java
    public Employees(){}

    public Employees(int id, String employee_name, Double employee_salary, int employee_age, String profile_image){

        this.id = id;
        this.employee_name = employee_name;
        this.employee_salary = employee_salary;
        this.employee_age = employee_age;
        this.profile_image = profile_image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmployee_name() {
        return employee_name;
    }

    public void setEmployee_name(String employee_name) {
        this.employee_name = employee_name;
    }

    public Double getEmployee_salary() {
        return employee_salary;
    }

    public void setEmployee_salary(Double employee_salary) {
        this.employee_salary = employee_salary;
    }

    public int getEmployee_age() {
        return employee_age;
    }

    public void setEmployee_age(int employee_age) {
        this.employee_age = employee_age;
    }

    public String getProfile_image() {
        return profile_image;
    }

    public void setProfile_image(String profile_image) {
        this.profile_image = profile_image;
    }

    @Override
    public String toString() {
        return id + " " + employee_name ;
    }
}



