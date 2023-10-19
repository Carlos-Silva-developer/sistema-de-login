package carlos.portifolio.loginAPI.repository;

import carlos.portifolio.loginAPI.model.UserLogin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<UserLogin, Long> {

    //para o jpa devemos usar as nomeclaturas da aplicação, nome da entidade e seus atributos no java
    @Query("select ul from UserLogin ul where ul.userName = (:userName)")
    public UserLogin findByUserName(@Param("userName") String userName);

    boolean existsByUserName(String username);
}
