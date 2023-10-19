package carlos.portifolio.loginAPI.security;


import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Getter @Setter
public class JWTObject {

    private String subject;
    private Date issuedAt;
    private Date expiration;
    private List<String> roles;

    public void setRoles(String...roles) {
        this.roles = Arrays.asList(roles);
    }


}
