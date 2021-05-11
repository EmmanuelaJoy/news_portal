package models;

import java.util.Date;
import java.util.Objects;

public class NewsArticles {
    private int id;
    private int articleId;
    private String name;
    private String author;
    private  String description;
    private Date published;

    public NewsArticles(int articleId, String name, String author, String description){
        this.articleId = articleId;
        this.name = name;
        this.author = author;
        this.description = description;
        this.published= new Date();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NewsArticles that = (NewsArticles) o;
        return id == that.id && articleId == that.articleId && name.equals(that.name) && author.equals(that.author) && description.equals(that.description) && published.equals(that.published);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, articleId, name, author, description, published);
    }

    public int getId() {
        return id;
    }

    public int getArticleId() {
        return articleId;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public String getDescription() {
        return description;
    }

    public Date getPublished() {
        return published;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setArticleId(int articleId) {
        this.articleId = articleId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPublished(Date published) {
        this.published = published;
    }
}
