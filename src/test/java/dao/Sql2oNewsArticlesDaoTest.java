package dao;

import models.NewsArticles;
import org.junit.*;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import static org.junit.Assert.*;

public class Sql2oNewsArticlesDaoTest {

    private static Sql2oNewsArticlesDao newsArticlesDao;
    private static Connection connection;

    @BeforeClass
    public static void setUp() throws Exception {
        String connectionString = "jdbc:postgresql://localhost:5432/news_portal_test";
        Sql2o sql2o = new Sql2o(connectionString, "emmanuela", "adminPass");
        newsArticlesDao = new Sql2oNewsArticlesDao(sql2o);
        connection = sql2o.open();
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("clearing database");
        newsArticlesDao.clearAllArticles();
    }

    @AfterClass
    public static void shutDown() throws Exception{
        connection.close();
        System.out.println("connection closed");
    }

    @Test
    public void newsArticleIdIsSetCorrectly() throws Exception{
        NewsArticles newsArticle = newNewsArticles();
        int newsArticleId = newsArticle.getId();
        newsArticlesDao.add(newsArticle);
        assertNotEquals(newsArticleId, newsArticle.getId());
    }

    @Test
    public void getsAllNewsArticles() throws Exception{
        NewsArticles newsArticle = newNewsArticles();
        NewsArticles newsArticle1 = newNewsArticles();
        newsArticlesDao.add(newsArticle);
        newsArticlesDao.add(newsArticle1);
        assertEquals(2, newsArticlesDao.getAll().size());
    }

    @Test
    public void noNewsArticlesReturnsEmptyList() throws Exception {
        assertEquals(0, newsArticlesDao.getAll().size());
    }

    @Test
    public void deleteByIdDeletesCorrectNewsArticle() throws Exception {
        NewsArticles newsArticle = newNewsArticles();
        newsArticlesDao.add(newsArticle);
        newsArticlesDao.deleteById(newsArticle.getId());
        assertEquals(0, newsArticlesDao.getAll().size());
    }

    @Test
    public void clearAllClearsAll() throws Exception {
        NewsArticles newsArticle = newNewsArticles();
        NewsArticles newsArticle1 = newNewsArticles();
        newsArticlesDao.add(newsArticle);
        newsArticlesDao.add(newsArticle1);
        int daoSize = newsArticlesDao.getAll().size();
        newsArticlesDao.clearAllArticles();
        assertTrue(daoSize > 0 && daoSize > newsArticlesDao.getAll().size());
    }

    private NewsArticles newNewsArticles(){
        return new NewsArticles("Financial Planning", "Todd", "Creating a budget is very important");
    }
}