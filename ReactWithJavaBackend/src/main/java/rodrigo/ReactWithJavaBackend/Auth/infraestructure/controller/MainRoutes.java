package rodrigo.ReactWithJavaBackend.Auth.infraestructure.controller;

import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rodrigo.ReactWithJavaBackend.Auth.application.AuthResponse;
import rodrigo.ReactWithJavaBackend.Auth.application.CheckLoggedInService;
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
    public ResponseEntity<AuthResponse> login(@RequestBody UserParams params){
        try {

            System.out.println("PARAMS ON LOGIN " + params);


            AuthResponse response = loginService.run(params.username,params.password);

            HttpHeaders headers = new HttpHeaders();
            headers.setBasicAuth(response.getToken());

            return ResponseEntity.ok().headers(headers).body(response);

        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/checkIsLoggedIn")
    public ResponseEntity<String> getCheckIsLoggedIn(){
        User user = checkLoggedInService.run();

        return ResponseEntity.ok().body(user.toString());
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
