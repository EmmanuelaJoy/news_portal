package models;

import java.util.Objects;

public class Users {
    private int id;
    private String name;
    private String department;
    private String role;

    public Users(String name, String department, String role){
        this.name = name;
        this.department = department;
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Users users = (Users) o;
        return id == users.id && name.equals(users.name) && department.equals(users.department) && role.equals(users.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, department, role);
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

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }


}
