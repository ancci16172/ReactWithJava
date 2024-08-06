package rodrigo.ReactWithJavaBackend.Auth.domain.interfaces;

import rodrigo.ReactWithJavaBackend.Auth.domain.User;

public interface UserRepository {

    public User getByUsernameAndPassword(String username, String password);
    public User getByUsername(String username);
}
