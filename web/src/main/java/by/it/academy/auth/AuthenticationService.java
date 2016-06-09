package by.it.academy.auth;

import by.it.academy.model.user.User;
import by.it.academy.model.user.UserProfile;
import by.it.academy.services.IUserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Service for user authentication through spring security
 * Implements UserDetailsService and realize method loadUserByUsername
 * Created by IPahomov on 28.05.2016.
 */
@Service("authService")
public class AuthenticationService implements UserDetailsService {
    private static final Logger log = Logger.getLogger(AuthenticationService.class);

    @Autowired
    private IUserService userService;

    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        AuthUser authUser = null;
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

        if ((email != null) & (!email.isEmpty())) {
            User user = userService.getUserByEmail(email);
            log.info("User: " + user);
            if (user != null) {
                log.info("User: " + user);
                authorities = getGrantedAuthorities(user);
                authUser = new AuthUser(
                        user.getFirstName(), user.getPassword(), true, true, true, true, authorities, user.getEmail(), user.getLastName());
            } else {
                log.error("User not found");
                throw new UsernameNotFoundException("User not found");
            }

        } else {
            log.error("Error email");
            throw new UsernameNotFoundException("Error email");
        }

        return authUser;
    }

    private List<GrantedAuthority> getGrantedAuthorities(User user) {
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

        for (UserProfile userProfile : user.getUserProfiles()) {
            System.out.println("UserProfile : " + userProfile);
            authorities.add(new SimpleGrantedAuthority("ROLE_" + userProfile.getType()));
        }
        System.out.print("authorities :" + authorities);
        return authorities;
    }
}
