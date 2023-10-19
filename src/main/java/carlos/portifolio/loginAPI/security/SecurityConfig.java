package carlos.portifolio.loginAPI.security;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@ConfigurationProperties(prefix = "security.config")
public class SecurityConfig {

    public static String PREFIX;
    public static String KEY;
    public static Long EXPIRATION;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new PasswordEncoder() {
            @Override
            public String encode(CharSequence rawPassword) {
                return null;
            }

            @Override
            public boolean matches(CharSequence rawPassword, String encodedPassword) {
                return false;
            }
        };
    }
}


