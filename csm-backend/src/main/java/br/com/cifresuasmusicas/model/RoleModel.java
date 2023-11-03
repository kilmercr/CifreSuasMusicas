package br.com.cifresuasmusicas.model;

import java.io.Serial;

import br.com.cifresuasmusicas.enums.RolesEnum;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

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