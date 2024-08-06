package rodrigo.ReactWithJavaBackend.Auth.infraestructure.security;

import org.springframework.security.crypto.password.PasswordEncoder;



public class NotActionPasswordEncoder implements PasswordEncoder {


    @Override
    public String encode(CharSequence rawPassword) {
        return rawPassword.toString();
    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        return rawPassword.toString().equals(encodedPassword);
    }
}
