package carlos.portifolio.loginAPI.repository;

import carlos.portifolio.loginAPI.domain.UserLogin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserLogin, Long> {
}
