package carlos.portifolio.loginAPI.service;

import carlos.portifolio.loginAPI.model.UserLogin;
import carlos.portifolio.loginAPI.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private PasswordEncoder encoder;

    public void createUser(UserLogin user) {

        String pass = user.getUserPassword();
        user.setUserPassword(encoder.encode(pass));
        repository.save(user);

    }

}
