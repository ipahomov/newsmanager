package by.it.academy.model;

import java.io.Serializable;

/**
 * Entity for Category table
 */
public class Category implements Serializable {

    private String catId;       // name of category
    private String parentId;    // name of parent category

    public Category() {
    }

    public String getCatId() {
        return catId;
    }

    public void setCatId(String catId) {
        this.catId = catId;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((catId == null) ? 0 : catId.hashCode());
        result = prime * result + ((parentId == null) ? 0 : parentId.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Category other = (Category) obj;
        if (catId == null) {
            if (other.catId != null)
                return false;
        } else if (!catId.equals(other.catId))
            return false;
        if (parentId == null) {
            if (other.parentId != null)
                return false;
        } else if (!parentId.equals(other.parentId))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Category [catId=" + catId + ", parentId=" + parentId + "]";
    }

}
