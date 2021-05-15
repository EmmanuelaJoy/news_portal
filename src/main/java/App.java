import com.google.gson.Gson;
import dao.Sql2oDepartmentsDao;
import dao.Sql2oNewsArticlesDao;
import dao.Sql2oUsersDao;
import models.Departments;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.sql.DriverManager;

import static spark.Spark.*;


public class App {
    public static void main(String[] args) {
        Sql2oDepartmentsDao departmentsDao;
        Sql2oUsersDao usersDao;
        Sql2oNewsArticlesDao newsArticlesDao;
        Connection conn;
        Gson gson = new Gson();

        staticFileLocation("/public");
////        DriverManager.registerDriver(new com.mysql.jdbc.Driver ());
//        String connectionString = "jdbc: h2:~/news_portal.db;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
//        Sql2o sql2o = new Sql2o(connectionString, "", "");

        String connectionString = "jdbc:postgresql://localhost:5432/news_portal";
        Sql2o sql2o = new Sql2o(connectionString, "emmanuela", "adminPass");

        departmentsDao = new Sql2oDepartmentsDao(sql2o);
        usersDao = new Sql2oUsersDao(sql2o);
        newsArticlesDao = new Sql2oNewsArticlesDao(sql2o);

        post("/departments/new", "application/json", (req,res) -> {
            Departments department = gson.fromJson(req.body(), Departments.class);
            departmentsDao.add(department);
            res.status(201);
            res.type("application/json");
            return gson.toJson(department);
        });

        get("/departments", "application/json", (req, res) -> { //accept a request in format JSON from an app
            res.type("application/json");
            return gson.toJson(departmentsDao.getAll());//send it back to be displayed
        });

        get("/departments/:id", "application/json", (req, res) -> { //accept a request in format JSON from an app
            res.type("application/json");
            int departmentId = Integer.parseInt(req.params("id"));
            res.type("application/json");
            return gson.toJson(departmentsDao.findById(departmentId));
        });
    }
}
