package dao;

import models.Departments;

import java.util.List;

public interface DepartmentsDao {
    //List
    List<Departments> getAll();

    //Create
    void add(Departments departments);

    //Read
    Departments findById(int id);

    //Delete
    void deleteById(int id);
    void clearAllDepartments();
}
