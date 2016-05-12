package by.it.academy.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Entity for Category table
 */
@Entity
public class Category implements Serializable {
    private static final long serialVersionUID = 3L;

    private Long categoryId;
    private String categoryName;       // name of category
    private String parentName;    // name of parent category
    private UserDetail userDetail;

    public Category() {
    }

    @Id
    @GeneratedValue
    public Long getCategoryId() {
        return categoryId;
    }
    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    @Column
    public String getCategoryName() {
        return categoryName;
    }
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    @Column
    public String getParentName() {
        return parentName;
    }
    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    @ManyToOne
    @JoinColumn(name = "F_USERID")
    public UserDetail getUserDetail() {
        return userDetail;
    }
    public void setUserDetail(UserDetail userDetail) {
        this.userDetail = userDetail;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Category category = (Category) o;

        if (categoryId != null ? !categoryId.equals(category.categoryId) : category.categoryId != null) return false;
        if (categoryName != null ? !categoryName.equals(category.categoryName) : category.categoryName != null)
            return false;
        return !(parentName != null ? !parentName.equals(category.parentName) : category.parentName != null);

    }

    @Override
    public int hashCode() {
        int result = categoryId != null ? categoryId.hashCode() : 0;
        result = 31 * result + (categoryName != null ? categoryName.hashCode() : 0);
        result = 31 * result + (parentName != null ? parentName.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Category{" +
                "categoryId=" + categoryId +
                ", categoryName='" + categoryName + '\'' +
                ", parentName='" + parentName + '\'' +
                '}';
    }
}
