package rodrigo.ReactWithJavaBackend.Auth.domain.interfaces;

import rodrigo.ReactWithJavaBackend.Auth.domain.User;


//Esta es una clase que siempre va a interactuar con el usuario logueado
//que este ejecutando este servicio
public interface UserContext {

    //Retorna el usuario logueado
    public User getUser();

}
