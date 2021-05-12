package dao;

import models.NewsArticles;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

public class Sql2oNewsArticlesDao implements NewsArticlesDao{

    private final Sql2o sql2o;

    public Sql2oNewsArticlesDao(Sql2o sql2o){
        this.sql2o = sql2o;
    }

    @Override
    public List<NewsArticles> getAll() {
        try(Connection connection = sql2o.open()) {
            return connection.createQuery("SELECT * FROM news_articles").executeAndFetch(NewsArticles.class);
        }
    }

    @Override
    public void add(NewsArticles newsArticle) {
        String sql = "INSERT INTO news_articles (name, author, description) VALUES (:name, :author, :description)";
        try(Connection connection = sql2o.open()){
            int id = (int) connection.createQuery(sql,true).bind(newsArticle).executeUpdate().getKey();
            newsArticle.setId(id);
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public NewsArticles findById(int id) {
        try(Connection connection = sql2o.open()) {
            return connection.createQuery("SELECT * FROM news_articles WHERE id = :id").addParameter("id", id).executeAndFetchFirst(NewsArticles.class);
        }
    }

    @Override
    public void deleteById(int id) {
        String sql = "DELETE from news_articles WHERE id=:id";
        try (Connection connection = sql2o.open()) {
            connection.createQuery(sql).addParameter("id", id).executeUpdate();
        } catch (Sql2oException ex){
            System.out.println(ex);
        }
    }

    @Override
    public void clearAllArticles() {
        String sql = "DELETE from news_articles";
        try(Connection connection = sql2o.open()){
            connection.createQuery(sql).executeUpdate();
        } catch (Sql2oException ex){
            System.out.println(ex);
        }
    }
}
