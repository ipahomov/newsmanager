package by.it.academy.auth;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

/**
 * Class AuthUser extended springframework authentication User
 * Created by IPahomov on 01.06.2016.
 */
public class AuthUser extends User {
    private final String email;
    private final String lastname;

    public AuthUser(String username, String password, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities, String email, String lastname){
        super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
        this.email = email;
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public String getLastname() {
        return lastname;
    }
}
