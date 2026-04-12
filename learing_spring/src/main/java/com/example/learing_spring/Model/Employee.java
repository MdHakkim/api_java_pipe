package com.example.learing_spring.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

import java.util.Date;

@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotBlank(message = "Name is required not empty")
    private String name;
    private String roll;
    @Min(value=1000,message="salary must be grean then 1000")
    private Double salary;

    private Integer age;
    private Date todaydate;
    public Employee() {
    }
    public Employee( String name, String roll, Double salary, Date todaydate) {
//        this.id = id;
        this.name = name;
        this.roll = roll;
        this.salary = salary;
        this.todaydate = todaydate;
    }

    public Integer getId() {
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

    public String getRoll() {
        return roll;
    }

    public void setRoll(String roll) {
        this.roll = roll;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Date gettodaydate() {
        return todaydate;
    }

    public void settodaydate(Date todaydate) {
        this.todaydate = todaydate;
    }
}
