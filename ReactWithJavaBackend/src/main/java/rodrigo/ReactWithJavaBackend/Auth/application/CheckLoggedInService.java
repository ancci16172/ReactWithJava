package rodrigo.ReactWithJavaBackend.Auth.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rodrigo.ReactWithJavaBackend.Auth.domain.User;
import rodrigo.ReactWithJavaBackend.Auth.domain.interfaces.UserContext;

@Service
public class CheckLoggedInService {

    @Autowired
    public UserContext userContext;

    public User run(){
        User user = userContext.getUser();
        System.out.println("User logged in " + user);

        return user;
    }

}
