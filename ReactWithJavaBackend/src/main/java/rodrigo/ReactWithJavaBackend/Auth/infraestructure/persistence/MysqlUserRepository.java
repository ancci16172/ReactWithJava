package rodrigo.ReactWithJavaBackend.Auth.infraestructure.persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import rodrigo.ReactWithJavaBackend.Auth.domain.User;
import rodrigo.ReactWithJavaBackend.Auth.domain.interfaces.UserRepository;

import java.time.temporal.ValueRange;
import java.util.List;

@Repository
public class MysqlUserRepository implements UserRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public User getByUsernameAndPassword(String username, String password) {
        System.out.println("getByUsernameAndPassword llego con " + username + " con " + password);
        User user =  jdbcTemplate.queryForObject(
                "SELECT * FROM usuarios WHERE username = ? AND password = ?",
                new Object[]{username, password},
                (rs, rowNum) -> new User(
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getInt("USER_ID")
                )
        );

        System.out.println("Objeto obtenido por jdbc " + user);
        return user;
    }

    @Override
    public User getByUsername(String username) {
        User user = jdbcTemplate.queryForObject(
                "SELECT * from usuarios where username=?",
                new Object[]{username},
                (rs,rowNum) -> new User(
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getInt("USER_ID"))
                );

        return user;
    }
}
