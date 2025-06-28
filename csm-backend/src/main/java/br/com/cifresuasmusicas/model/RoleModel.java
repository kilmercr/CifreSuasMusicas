package br.com.cifresuasmusicas.model;

import br.com.cifresuasmusicas.enums.RolesEnum;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import java.io.Serial;

@Data
@Entity
@Table(name = "TB_ROLE")
public class RoleModel implements GrantedAuthority {

    @Serial
    private static final long serialVersionUID = -6186040511096479401L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roleId;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, unique = true)
    private RolesEnum name;

    @Override
    public String getAuthority() {
        return this.name.getRoleName();
    }
}