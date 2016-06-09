package by.it.academy.model.user;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Entity for user
 * Authors and admin can add/edit/delete news/categories.
 * Others may only see all news
 */
@Entity
public class User implements Serializable {
    private static final long serialVersionUID = 4L;

    private Long userId;

    @NotNull(message = "Input firstname")
    @Pattern(regexp="^[A-Z]+[a-z]+$", message="First name must be alphanumeric with no spaces and first capital")
    private String firstName;

    @NotNull(message = "Input lastname")
    @Pattern(regexp="^[A-Z]+[a-z]+$", message="Last name must be alphanumeric with no spaces and first capital")
    private String lastName;

    @NotNull
    @Email
    private String email;

    @NotNull
    @Length(min = 8, message = "Password must be minimum 8 symbols")
    private String password;

    private UserDetail userDetail;
    private Set<UserProfile> userProfiles = new HashSet<UserProfile>();

    public User() {
    }

    @Id
    @GeneratedValue
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Column
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Column
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    public UserDetail getUserDetail() {
        return userDetail;
    }

    public void setUserDetail(UserDetail userDetail) {
        this.userDetail = userDetail;
    }

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "T_USER_USER_PROFILE",
            joinColumns = {@JoinColumn(name = "F_USER_ID")},
            inverseJoinColumns = {@JoinColumn(name = "F_USER_PROFILE_ID")})
    public Set<UserProfile> getUserProfiles() {
        return userProfiles;
    }

    public void setUserProfiles(Set<UserProfile> userProfiles) {
        this.userProfiles = userProfiles;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (userId != null ? !userId.equals(user.userId) : user.userId != null) return false;
        if (firstName != null ? !firstName.equals(user.firstName) : user.firstName != null) return false;
        if (lastName != null ? !lastName.equals(user.lastName) : user.lastName != null) return false;
        if (email != null ? !email.equals(user.email) : user.email != null) return false;
        if (password != null ? !password.equals(user.password) : user.password != null) return false;
        if (userDetail != null ? !userDetail.equals(user.userDetail) : user.userDetail != null) return false;
        return !(userProfiles != null ? !userProfiles.equals(user.userProfiles) : user.userProfiles != null);

    }

    @Override
    public int hashCode() {
        int result = userId != null ? userId.hashCode() : 0;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (userDetail != null ? userDetail.hashCode() : 0);
        result = 31 * result + (userProfiles != null ? userProfiles.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", userDetail=" + userDetail +
                ", userProfiles=" + userProfiles +
                '}';
    }
}
