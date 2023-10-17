package carlos.portifolio.loginAPI.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Getter
@Setter
@EqualsAndHashCode(of = "id") @ToString(of = "id")
public class UserLogin {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String userName;

    @Column(nullable = false, unique = true)
    private String userLogin;

    @Column(nullable = false)
    private String userPassword;


    @OneToMany(mappedBy = "userId", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Permissions> permissoes = new ArrayList<>();

    public void adicionarPermissao(Permissions permissao) {
        this.permissoes.add(permissao);
        permissao.setUserId(this);
    }
}