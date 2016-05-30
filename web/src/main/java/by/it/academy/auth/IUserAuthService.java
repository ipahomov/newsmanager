package by.it.academy.auth;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * Created by IPahomov on 28.05.2016.
 */
public interface IUserAuthService {
    UserDetails loadUserByEmail(String email) throws UsernameNotFoundException;
}
