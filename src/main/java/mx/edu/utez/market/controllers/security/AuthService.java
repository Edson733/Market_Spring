package mx.edu.utez.market.controllers.security;

import mx.edu.utez.market.controllers.user.UserService;
import mx.edu.utez.market.models.security.AuthUser;
import mx.edu.utez.market.models.user.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AuthService implements UserDetailsService {
    UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.getByUsername(username).get();
        return AuthUser.build(user);
    }
}
