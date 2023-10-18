package carlos.portifolio.loginAPI.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum UserRole {

    USER(Names.USER),
    ADMIN(Names.ADMIN),
    VISITOR(Names.VISITOR);

    public static class Names {
        public static final String VISITOR = "ROLE_VISITOR";
        public static final String USER = "ROLE_USER";
        public static final String ADMIN = "ROLE_ADMIN";
    }

    private final String role;
}
