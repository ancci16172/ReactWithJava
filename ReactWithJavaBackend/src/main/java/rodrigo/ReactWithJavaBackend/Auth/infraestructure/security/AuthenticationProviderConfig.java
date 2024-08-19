package rodrigo.ReactWithJavaBackend.Auth.infraestructure.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import rodrigo.ReactWithJavaBackend.Auth.domain.interfaces.UserRepository;

@Configuration
public class AuthenticationProviderConfig {

    @Autowired
    public UserRepository userRepository;

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception
    {
        return config.getAuthenticationManager();
    }

    @Bean
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setPasswordEncoder(new NotActionPasswordEncoder());

        //Para desserializar

        daoAuthenticationProvider.setUserDetailsService(
                username -> {
                    rodrigo.ReactWithJavaBackend.Auth.domain.User user = userRepository.getByUsername(username);
                    if(user == null) throw new UsernameNotFoundException("User not fount on Authentication provider");
                    return new UserDetails(user);
                });


        return daoAuthenticationProvider;

    }

    @Bean
    public UserDetailsService userDetailService() {

        return username -> new UserDetails(userRepository.getByUsername(username));


    }


}
