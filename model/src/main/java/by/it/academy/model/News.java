package by.it.academy.model;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

/**
 * Entity for news table
 */
@Entity
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class News implements Serializable {
    private static final long serialVersionUID = 4L;

    private Long newsId;
    private String categoryName;    //name of category

    @NotNull(message = "Title must be not null or empty")
    @Length(min = 5, message = "Too small title name. Minimum 5 symbols.")
    private String title;

    private String author;

    @NotNull(message = "Annotation must be not null or empty")
    @Length(min = 5, message = "Too small annotation. Minimum 5 symbols.")
    private String annotation;    //short text about news

    @NotNull(message = "Main text must be not null or empty")
    @Length(min = 5, message = "Too small main text. Minimum 5 symbols.")
    private String maintext;
    private Date releaseDate;   // add current time of add/edit operations
    private Set<Comment> comments;

    public News() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getNewsId() {
        return newsId;
    }
    public void setNewsId(Long newsId) {
        this.newsId = newsId;
    }

    @Column
    public String getCategoryName() {
        return categoryName;
    }
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    @Column
    @Type(type = "text")
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    @Column
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }

    @Column
    @Type(type = "text")
    public String getAnnotation() {
        return annotation;
    }
    public void setAnnotation(String annotation) {
        this.annotation = annotation;
    }

    @Column
    @Type(type = "text")
    public String getMaintext() {
        return maintext;
    }
    public void setMaintext(String maintext) {
        this.maintext = maintext;
    }

    @Column
    @Temporal(TemporalType.TIMESTAMP)
    public Date getReleaseDate() {
        return releaseDate;
    }
    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    @OneToMany(mappedBy = "news")
    public Set<Comment> getComments() {
        return comments;
    }
    public void setComments(Set<Comment> comments) {
        this.comments = comments;
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
