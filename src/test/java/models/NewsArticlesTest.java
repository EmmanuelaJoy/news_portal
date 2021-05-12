package models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class NewsArticlesTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void instantiatesNewsArticlesObjectsCorrectly_true() throws Exception {
        NewsArticles newsArticles = newNewsArticle();
        assertTrue(newsArticles instanceof NewsArticles);
    }

    @Test
    public void newsArticlesNameReturnsCorrectly_String() throws Exception {
        NewsArticles newsArticles = newNewsArticle();
        assertEquals("Time Management", newsArticles.getName());
    }

    @Test
    public void newsArticlesAuthorReturnsCorrectly_String() throws Exception {
        NewsArticles newsArticles = newNewsArticle();
        assertEquals("Emmanuela Joy", newsArticles.getAuthor());
    }

    @Test
    public void newsArticlesDescriptionReturnsCorrectly_String() throws Exception {
        NewsArticles newsArticles = newNewsArticle();
        assertEquals("Stop procrastinating", newsArticles.getDescription());
    }

    @Test
    public void setArticleIdSetsCorrectId_int() throws Exception {
        NewsArticles newsArticles = newNewsArticle();
        newsArticles.setArticleId(2);
        assertNotEquals(1, newsArticles.getArticleId());
    }

    @Test
    public void setNameSetsCorrectName_String() throws Exception {
        NewsArticles newsArticles = newNewsArticle();
        newsArticles.setName("Financial Management");
        assertNotEquals("Time Management", newsArticles.getName());
    }

    @Test
    public void setAuthorSetsCorrectAuthor_String() throws Exception {
        NewsArticles newsArticles = newNewsArticle();
        newsArticles.setAuthor("Stacy Njoroge");
        assertNotEquals("Emmanuela Joy", newsArticles.getAuthor());
    }

    @Test
    public void setDescriptionSetsCorrectDescription_String() throws Exception {
        NewsArticles newsArticles = newNewsArticle();
        newsArticles.setDescription("When life gives you lemons..");
        assertNotEquals("Stop procrastinating", newsArticles.getDescription());
    }

    private NewsArticles newNewsArticle() {
        return new NewsArticles("Time Management", "Emmanuela Joy", "Stop procrastinating");
    }
}