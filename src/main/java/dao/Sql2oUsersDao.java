package dao;

import models.Departments;
import models.Users;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

public class Sql2oUsersDao implements UsersDao{

    private final Sql2o sql2o;

    public Sql2oUsersDao(Sql2o sql2o){
        this.sql2o = sql2o;
    }

    @Override
    public List<Users> getAll() {
        try(Connection connection = sql2o.open()) {
            return connection.createQuery("SELECT * FROM users").executeAndFetch(Users.class);
        }
    }

    @Override
    public void add(Users user) {
        String sql = "INSERT INTO users (name, department, role) VALUES (:name, :department, :role)";
        try(Connection connection = sql2o.open()){
            int id = (int) connection.createQuery(sql,true).bind(user).executeUpdate().getKey();
            user.setId(id);
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public void addUserToDepartment(Users user, Departments department) {
        String sql = "INSERT INTO departments_users (userId, departmentId) VALUES (:userId, :departmentId)";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("userId", user.getId())
                    .addParameter("departmentId", department.getId())
                    .executeUpdate();
        } catch (Sql2oException ex){
            System.out.println(ex);
        }
    }

    @Override
    public Users findById(int id) {
        try(Connection connection = sql2o.open()) {
            return connection.createQuery("SELECT * FROM users WHERE id = :id").addParameter("id", id).executeAndFetchFirst(Users.class);
        }
    }

    @Override
    public void deleteById(int id) {
        String sql = "DELETE from users WHERE id=:id";
        try (Connection connection = sql2o.open()) {
            connection.createQuery(sql).addParameter("id", id).executeUpdate();
        } catch (Sql2oException ex){
            System.out.println(ex);
        }
    }

    @Override
    public void clearAllUsers() {
        String sql = "DELETE from users";
        try(Connection connection = sql2o.open()){
            connection.createQuery(sql).executeUpdate();
        } catch (Sql2oException ex){
            System.out.println(ex);
        }
    }
}
