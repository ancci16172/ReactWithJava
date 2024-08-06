package rodrigo.ReactWithJavaBackend.Auth.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;
import rodrigo.ReactWithJavaBackend.Auth.domain.User;
import rodrigo.ReactWithJavaBackend.Auth.domain.interfaces.TokenGenerator;
import rodrigo.ReactWithJavaBackend.Auth.domain.interfaces.UserRepository;

@Service
public class LoginService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TokenGenerator tokenGenerator;

    @Autowired
    private AuthenticationManager authenticationManager;

    public AuthResponse run(String username, String password) throws Exception {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));

        User user = this.userRepository.getByUsernameAndPassword(username, password);

        if(user == null)
            throw new Exception("Error no se encontro el usuario con las credenciales: user " + username + " password " + password);


        String token = this.tokenGenerator.generateToken(user);

        return new AuthResponse(token);
    }

}
