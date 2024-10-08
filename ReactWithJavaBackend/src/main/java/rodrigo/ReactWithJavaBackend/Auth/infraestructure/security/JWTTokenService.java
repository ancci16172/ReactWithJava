package rodrigo.ReactWithJavaBackend.Auth.infraestructure.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import rodrigo.ReactWithJavaBackend.Auth.domain.User;
import rodrigo.ReactWithJavaBackend.Auth.domain.interfaces.TokenGenerator;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.function.Function;

@Component
public class JWTTokenService implements TokenGenerator {

    private static final String SECRET_KEY="586E3272357538782F413F4428472B4B6250655368566B597033733676397924";

    @Override
    public String generateToken(User user) {
        return Jwts.builder()
                .setClaims(new HashMap<String, Object>())
                .setSubject(user.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis()+1000*60*24*6))
                .signWith(getKey(), SignatureAlgorithm.HS256)
                .compact();
    }
    private Key getKey(){
        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    private Claims getAllClaims(String token){
        return Jwts
                .parserBuilder()
                .setSigningKey(getKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    private <T> T getClaims(String token, Function<Claims, T> claimsResolver){
        final Claims claims = getAllClaims(token);
        return claimsResolver.apply(claims);
    }

    public String getUsernameFromToken(String token){
        return getClaims(token, Claims::getSubject);
    }

    public boolean isTokenValid(String token, UserDetails userDetails) {
        final String username=getUsernameFromToken(token);
        return (username.equals(userDetails.getUsername())&& !isTokenExpired(token));
    }
    private boolean isTokenExpired(String token){

        return getExpiration(token).before(new Date());
    }
    private Date getExpiration(String token){

        return getClaims(token, Claims::getExpiration);
    }



}
