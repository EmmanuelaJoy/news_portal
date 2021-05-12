package dao;

import models.Users;

import java.util.List;

public interface UsersDao {
    //List
    List<Users> getAll();

    //Create
    void add(Users user);

    //Read
    Users findById(int id);

    //Delete
    void deleteById(int id);
}
