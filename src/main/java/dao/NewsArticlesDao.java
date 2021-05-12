package dao;

import models.NewsArticles;

import java.util.List;

public interface NewsArticlesDao {
    //List
    List<NewsArticles> getAll();

    //Create
    void add(NewsArticles newsArticle);

    //Read
    NewsArticles findById(int id);

    //Delete
    void deleteById(int id);
    void clearAllArticles();
}
