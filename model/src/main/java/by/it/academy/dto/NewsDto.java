package by.it.academy.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
/**
 * Created by IPahomov on 01.06.2016.
 */
public class NewsDto {

    private Long newsId;

    @NotNull(message = "Title must be not null or empty")
    @Min(value = 5, message = "Too small title name")
    private String title;

    @NotNull(message = "Annotation must be not null or empty")
    @Min(value = 5, message = "Too small annotation")
    private String annotation;    //short text about news

    @NotNull(message = "Main text must be not null or empty")
    @Min(value = 5, message = "Too small main text")
    private String maintext;

    public NewsDto(){}

    public Long getNewsId() {
        return newsId;
    }

    public void setNewsId(Long newsId) {
        this.newsId = newsId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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
}
