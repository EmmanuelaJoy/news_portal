package dao;

import models.Departments;
import models.Users;

import java.util.List;

public interface UsersDao {
    //List
    List<Users> getAll();

    //Create
    void add(Users user);
    void addUserToDepartment(Users user, Departments department);

    //Read
    Users findById(int id);

    //Delete
    void deleteById(int id);
    void clearAllUsers();
}
