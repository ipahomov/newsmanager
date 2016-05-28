package by.it.academy.model;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Entity for news comments table
 * Created by IPahomov on 03.05.2016.
 */
@Entity
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Comment implements Serializable {
    private static final long serialVersionUID = 3L;

    private Long newsCommentId;
    private String commentText;
    private Date date;
    private News news;

    @Id
    @GeneratedValue
    public Long getNewsCommentId() {
        return newsCommentId;
    }
    public void setNewsCommentId(Long newsCommentId) {
        this.newsCommentId = newsCommentId;
    }

    @Column
    @Type(type = "text")
    public String getCommentText() {
        return commentText;
    }
    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }

    @Column
    @Temporal(TemporalType.TIMESTAMP)
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }

    @ManyToOne
    @JoinColumn(name = "F_NEWSID")
    public News getNews() {
        return news;
    }
    public void setNews(News news) {
        this.news = news;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Comment that = (Comment) o;

        if (newsCommentId != null ? !newsCommentId.equals(that.newsCommentId) : that.newsCommentId != null)
            return false;
        if (commentText != null ? !commentText.equals(that.commentText) : that.commentText != null) return false;
        return !(date != null ? !date.equals(that.date) : that.date != null);

    }

    @Override
    public int hashCode() {
        int result = newsCommentId != null ? newsCommentId.hashCode() : 0;
        result = 31 * result + (commentText != null ? commentText.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "NewsComment{" +
                "newsCommentId=" + newsCommentId +
                ", commentText='" + commentText + '\'' +
                ", date=" + date +
                '}';
    }
}
