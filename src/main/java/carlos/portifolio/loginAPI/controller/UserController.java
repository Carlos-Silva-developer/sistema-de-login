package carlos.portifolio.loginAPI.controller;

import carlos.portifolio.loginAPI.model.UserLogin;
import carlos.portifolio.loginAPI.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private LoginService service;

    @PostMapping
    public void createUser(@RequestBody UserLogin user) {
        service.createUser(user);
    }

}
