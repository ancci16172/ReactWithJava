package rodrigo.ReactWithJavaBackend.Auth.domain.interfaces;

import rodrigo.ReactWithJavaBackend.Auth.domain.User;

public interface TokenGenerator {

    public String generateToken(User user);

}
