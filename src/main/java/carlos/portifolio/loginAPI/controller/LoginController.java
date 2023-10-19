package carlos.portifolio.loginAPI.controller;

import carlos.portifolio.loginAPI.dto.Session;
import carlos.portifolio.loginAPI.model.UserLogin;
import carlos.portifolio.loginAPI.repository.UserRepository;
import carlos.portifolio.loginAPI.security.JWTCreator;
import carlos.portifolio.loginAPI.security.JWTObject;
import carlos.portifolio.loginAPI.security.SecurityConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class LoginController {
    @Autowired
    private PasswordEncoder encoder;
    @Autowired
    private SecurityConfig securityConfig;
    @Autowired
    private UserRepository repository;

    @PostMapping("/login")
    public Session logar(@RequestBody UserLogin login){
        UserLogin user = repository.findByUserName(login.getUserName());
        if(user!=null) {
            boolean passwordOk =  encoder.matches(login.getUserPassword(), user.getUserPassword());
            if (!passwordOk) {
                throw new RuntimeException("Senha inválida para o login: " + login.getUserName());
            }
            //Estamos enviando um objeto Sessão para retornar mais informações do usuário
            Session session = new Session();
            session.setLogin(user.getUserName());

            JWTObject jwtObject = new JWTObject();
            jwtObject.setIssuedAt(new Date(System.currentTimeMillis()));
            jwtObject.setExpiration((new Date(System.currentTimeMillis() + SecurityConfig.EXPIRATION)));
//            jwtObject.setRoles(user.getPermissoes().toString());
            session.setToken(JWTCreator.create(SecurityConfig.PREFIX, SecurityConfig.KEY, jwtObject));
            return session;
        }else {
            throw new RuntimeException("Erro ao tentar fazer login");
        }
    }
}
