package carlos.portifolio.loginAPI.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


import javax.persistence.*;

import static javax.persistence.EnumType.STRING;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Getter @Setter
@EqualsAndHashCode(of = "permId")
public class Permissions {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long permId;

    @Enumerated(STRING)
    private UserRole funcao;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserLogin userId;
}
