package by.it.academy.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by IPahomov on 03.05.2016.
 */
@Entity
public class NewsComment implements Serializable {
    private static final long serialVersionUID = 3L;

    @Id
    @GeneratedValue
    private Long newsCommentId;

    @Column(length = 600)
    private String commentText;

    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    @ManyToOne
    @JoinColumn(name = "F_NEWSID")
    private News news;

    public Long getNewsCommentId() {
        return newsCommentId;
    }

    public void setNewsCommentId(Long newsCommentId) {
        this.newsCommentId = newsCommentId;
    }

    public String getCommentText() {
        return commentText;
    }

    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        NewsComment that = (NewsComment) o;

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
