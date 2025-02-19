package org.anik.entity;

public class Employee {
    private int id;
    private String name;
    private String address;
    private Double salary;

    public Employee(){
    }

    public Employee(int id, String name, String address, Double salary) {
      this.id = id;
      this.name = name;
      this.address = address;
      this.salary = salary;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }
}
