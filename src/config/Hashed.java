package config;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Hashed {
    
    private static BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
    
    public static String hashPassword(String password){
        return encoder.encode(password);
    }
    
    
}
