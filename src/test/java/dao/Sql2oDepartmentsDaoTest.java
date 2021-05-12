package dao;

import models.Departments;
import models.Users;
import org.junit.*;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import static org.junit.Assert.*;

public class Sql2oDepartmentsDaoTest {
    private static Sql2oDepartmentsDao departmentsDao;
    private static Connection connection;

    @BeforeClass
    public static void setUp() throws Exception {
        String connectionString = "jdbc:postgresql://localhost:5432/news_portal";
        Sql2o sql2o = new Sql2o(connectionString, "emmanuela", "adminPass");
        departmentsDao = new Sql2oDepartmentsDao(sql2o);
        connection = sql2o.open();
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("clearing database");
        departmentsDao.clearAllDepartments();
    }

    @AfterClass
    public static void shutDown() throws Exception{
        connection.close();
        System.out.println("connection closed");
    }

    @Test
    public void departmentIdIsSetCorrectly() throws Exception{
        Departments department = newDepartment();
        int departmentId = department.getId();
        departmentsDao.add(department);
        assertNotEquals(departmentId, department.getId());
    }

    @Test
    public void getsAllDepartments() throws Exception{
        Departments department = newDepartment();
        Departments department1 = newDepartment();
        departmentsDao.add(department);
        departmentsDao.add(department1);
        assertEquals(2, departmentsDao.getAll().size());
    }

    @Test
    public void noDepartmentsReturnsEmptyList() throws Exception {
        assertEquals(0, departmentsDao.getAll().size());
    }

    @Test
    public void deleteByIdDeletesCorrectDepartment() throws Exception {
        Departments department = newDepartment();
        departmentsDao.add(department);
        departmentsDao.deleteById(department.getId());
        assertEquals(0, departmentsDao.getAll().size());
    }

    @Test
    public void clearAllClearsAll() throws Exception {
        Departments department = newDepartment();
        Departments department1 = newDepartment();
        departmentsDao.add(department);
        departmentsDao.add(department1);
        int daoSize = departmentsDao.getAll().size();
        departmentsDao.clearAllDepartments();
        assertTrue(daoSize > 0 && daoSize > departmentsDao.getAll().size());
    }

    private Departments newDepartment(){
        return new Departments("Finance", "Handles company finances", "Emma, Joy");
    }
}