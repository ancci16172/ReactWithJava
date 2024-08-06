package rodrigo.ReactWithJavaBackend.Auth.infraestructure.controller;

import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rodrigo.ReactWithJavaBackend.Auth.application.AuthResponse;
import rodrigo.ReactWithJavaBackend.Auth.application.LoginService;

@RestController
@RequestMapping("/auth/")
public class MainRoutes {

    @Autowired
    public LoginService loginService;

    @GetMapping("/ping")
    public String ping(){
        return "pong";
    }

    @PostMapping("login")
    public ResponseEntity<AuthResponse> login(@RequestBody UserParams params){
        try {

            System.out.println(params);

            AuthResponse response = loginService.run(params.username,params.password);

            return ResponseEntity.ok().body(response);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
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
