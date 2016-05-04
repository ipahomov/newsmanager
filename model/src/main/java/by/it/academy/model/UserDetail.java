package by.it.academy.model;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * Created by IPahomov on 03.05.2016.
 */
@Entity
public class UserDetail implements Serializable {
    private static final long serialVersionUID = 5L;

    @Id
    @GenericGenerator(
            name = "gen",
            strategy = "foreign",
            parameters = @Parameter(name = "property", value = "user")
    )
    @GeneratedValue(generator = "gen")
    private Long userId;

    @Column
    private String country;

    @Column
    private String city;

    @OneToOne
    @PrimaryKeyJoinColumn
    private User user;

    @OneToMany(mappedBy = "userDetail")
    private Set<Category> categories;

    public UserDetail() {}

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userDetailId) {
        this.userId = userDetailId;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserDetail that = (UserDetail) o;

        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;
        if (country != null ? !country.equals(that.country) : that.country != null) return false;
        return !(city != null ? !city.equals(that.city) : that.city != null);

    }

    @Override
    public int hashCode() {
        int result = userId != null ? userId.hashCode() : 0;
        result = 31 * result + (country != null ? country.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "UserDetail{" +
                "userId=" + userId +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", categories=" + categories +
                '}';
    }
}
