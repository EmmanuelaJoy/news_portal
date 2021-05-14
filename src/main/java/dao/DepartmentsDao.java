package dao;

import models.Departments;
import models.Users;

import java.util.List;

public interface DepartmentsDao {
    //List
    List<Departments> getAll();
    List<Users> getAllDepartmentUsers(int departmentId);

    //Create
    void add(Departments departments);

    //Read
    Departments findById(int id);

    //Delete
    void deleteById(int id);
    void clearAllDepartments();
}
