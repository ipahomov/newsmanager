package by.it.academy.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

/**
 * Entity for news
 */
@Entity
public class News implements Serializable {
    private static final long serialVersionUID = 4L;

    @Id
    @GeneratedValue
    private Long newsId;

    @Column
    private String categoryName;    //name of category

    @Column
    private String title;

    @Column
    private String author;

    @Column
    private String annotation;    //short text about news

    @Column
    private String maintext;

    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date releaseDate;   // add current time of add/edit operations

    @OneToMany(mappedBy = "news")
    private Set<NewsComment> newsComments;

    public News() {
    }

    public Long getNewsId() {
        return newsId;
    }

    public void setNewsId(Long newsId) {
        this.newsId = newsId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAnnotation() {
        return annotation;
    }

    public void setAnnotation(String annotation) {
        this.annotation = annotation;
    }

    public String getMaintext() {
        return maintext;
    }

    public void setMaintext(String maintext) {
        this.maintext = maintext;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Set<NewsComment> getNewsComments() {
        return newsComments;
    }

    public void setNewsComments(Set<NewsComment> newsComments) {
        this.newsComments = newsComments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        News news = (News) o;

        if (newsId != null ? !newsId.equals(news.newsId) : news.newsId != null) return false;
        if (categoryName != null ? !categoryName.equals(news.categoryName) : news.categoryName != null) return false;
        if (title != null ? !title.equals(news.title) : news.title != null) return false;
        if (author != null ? !author.equals(news.author) : news.author != null) return false;
        if (annotation != null ? !annotation.equals(news.annotation) : news.annotation != null) return false;
        if (maintext != null ? !maintext.equals(news.maintext) : news.maintext != null) return false;
        return !(releaseDate != null ? !releaseDate.equals(news.releaseDate) : news.releaseDate != null);

    }

    @Override
    public int hashCode() {
        int result = newsId != null ? newsId.hashCode() : 0;
        result = 31 * result + (categoryName != null ? categoryName.hashCode() : 0);
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (author != null ? author.hashCode() : 0);
        result = 31 * result + (annotation != null ? annotation.hashCode() : 0);
        result = 31 * result + (maintext != null ? maintext.hashCode() : 0);
        result = 31 * result + (releaseDate != null ? releaseDate.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "News{" +
                "newsId=" + newsId +
                ", categoryName='" + categoryName + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", annotation='" + annotation + '\'' +
                ", maintext='" + maintext + '\'' +
                ", releaseDate='" + releaseDate + '\'' +
                '}';
    }
}
