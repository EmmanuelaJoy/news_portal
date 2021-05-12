package models;

import java.util.Objects;

public class Departments {
    private int id;
    private String name;
    private String description;
    private String employees;

    public Departments(String name, String description, String employees){
        this.name = name;
        this.description = description;
        this.employees = employees;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Departments that = (Departments) o;
        return id == that.id && name.equals(that.name) && description.equals(that.description) && employees.equals(that.employees);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, employees);
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEmployees() {
        return employees;
    }

    public void setEmployees(String employees) {
        this.employees = employees;
    }
}
