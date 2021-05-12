package dao;

import models.Users;
import org.junit.*;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import static org.junit.Assert.*;

public class Sql2oUsersDaoTest {
    private static Sql2oUsersDao userDao;
    private static Connection connection;

    @BeforeClass
    public static void setUp() throws Exception {
//        String connectionString = "jdbc:postgresql://ec2-54-163-254-204.compute-1.amazonaws.com:5432/de2jr153rr5f6k?sslmode=require";
//        Sql2o sql2o = new Sql2o(connectionString, "swgavudvlixczf", "2948abef64b5819012a8e053e492dede708185e8e553b16645179cb21356ed72");
        String connectionString = "jdbc:postgresql://localhost:5432/news_portal";
        Sql2o sql2o = new Sql2o(connectionString, "emmanuela", "adminPass");
        userDao = new Sql2oUsersDao(sql2o);
        connection = sql2o.open();
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("clearing database");
        userDao.clearAllUsers();
    }

    @AfterClass
    public static void shutDown() throws Exception{
        connection.close();
        System.out.println("connection closed");
    }

    @Test
    public void userIdIsSetCorrectly() throws Exception{
        Users user = newUser();
        int userId = user.getId();
        userDao.add(user);
        assertNotEquals(userId, user.getId());
    }

    @Test
    public void getsAllUsers() throws Exception{
        Users user = newUser();
        Users user1 = newUser();
        Users user2 = newUser();
        userDao.add(user);
        userDao.add(user1);
        userDao.add(user2);
        assertEquals(3, userDao.getAll().size());
    }

    @Test
    public void noUsersReturnsEmptyList() throws Exception {
        assertEquals(0, userDao.getAll().size());
    }

    @Test
    public void deleteByIdDeletesCorrectUser() throws Exception {
        Users user = newUser();
        userDao.add(user);
        userDao.deleteById(user.getId());
        assertEquals(0, userDao.getAll().size());
    }

    private Users newUser(){
        return new Users("Emma", "IT", "Technician");
    }
}