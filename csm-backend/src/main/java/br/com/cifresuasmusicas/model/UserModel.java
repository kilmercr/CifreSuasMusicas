package br.com.cifresuasmusicas.model;

import br.com.cifresuasmusicas.enums.SexEnum;
import br.com.cifresuasmusicas.utils.CsmUtils;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serial;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "TB_USER")
public class UserModel implements UserDetails {

    @Serial
    private static final long serialVersionUID = 4783944992322083216L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    @Column(nullable = false, unique = true)
    private String username;
    @JsonIgnore
    @Column(nullable = false)
    private String password;

    @Column(nullable = false, unique = true)
    private String cpf;
    @Column(nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    private SexEnum sex;

    private String email;
    private String naturality;
    private String nacionality;

    @Column(nullable = false)
    private LocalDate dtBirthday;
    @Column(nullable = false)
    private LocalDateTime dtCreate;
    private LocalDateTime dtUpdate;

    @Transient
    private String login;
    @Transient
    private String cpfFormatado;

    @ManyToMany
    @JoinTable(name = "TB_USERS_ROLES", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private List<RoleModel> roles;

    public String getLogin() {
        return this.getUsername();
    }

    public void setLogin(String login) {
        this.setUsername(login);
    }

    public String getCpfFormatado() {
        return CsmUtils.formatCPF(this.getCpf());
    }

    public void setCpfFormatado() {
        this.cpfFormatado = CsmUtils.formatCPF(this.getCpf());
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.roles;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}