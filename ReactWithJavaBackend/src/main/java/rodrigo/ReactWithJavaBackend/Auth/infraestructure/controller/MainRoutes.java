package rodrigo.ReactWithJavaBackend.Auth.infraestructure.controller;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rodrigo.ReactWithJavaBackend.Auth.application.AuthResponse;
import rodrigo.ReactWithJavaBackend.Auth.application.check.CheckLoggedInService;
import rodrigo.ReactWithJavaBackend.Auth.application.LoginService;
import rodrigo.ReactWithJavaBackend.Auth.domain.User;

@RestController
@RequestMapping("/api/auth/")
public class MainRoutes {

    @Autowired
    public LoginService loginService;

    @Autowired
    public CheckLoggedInService checkLoggedInService;

    @GetMapping("/ping")
    public String ping(){
        return "pong";
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody UserParams params, HttpServletResponse httpServletResponse){
        try {

            System.out.println("PARAMS ON LOGIN " + params);


            AuthResponse response = loginService.run(params.username,params.password);

            String token = response.getToken();
            Cookie authTokenValueCookie = new Cookie("auth_token", token);
            authTokenValueCookie.setSecure(true);
            authTokenValueCookie.setAttribute("SameSite","none");
            authTokenValueCookie.setPath("/");

            httpServletResponse.addCookie(authTokenValueCookie);


            return ResponseEntity.ok().body(response);

        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/verify")
    public ResponseEntity<User> getCheckIsLoggedIn(){
        User user = checkLoggedInService.run();

        return ResponseEntity.ok().body(user);
    }

}

class UserParams{
    public String username;
    public String password;
    public UserParams(String username, String password){
        this.username = username;
        this.password = password;
    }
}
