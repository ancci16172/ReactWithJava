package rodrigo.ReactWithJavaBackend.Auth.infraestructure.security;

import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import rodrigo.ReactWithJavaBackend.Auth.domain.User;
import rodrigo.ReactWithJavaBackend.Auth.domain.interfaces.UserContext;


@Component
public class SpringSecurityUserContext implements UserContext {

    public User getUser(){
        SecurityContext context = SecurityContextHolder.getContext();
        UserDetails userDetails = (UserDetails) context.getAuthentication().getPrincipal();


        var username = userDetails.getUsername();
        var password = userDetails.getPassword();
        var userId = userDetails.getUserId();

        return new User(username, password,userId);

    }

}
