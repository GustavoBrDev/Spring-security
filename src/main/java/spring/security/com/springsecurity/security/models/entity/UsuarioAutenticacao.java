package spring.security.com.springsecurity.security.models.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import spring.security.com.springsecurity.models.entity.Usuario;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Entity
public class UsuarioAutenticacao implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String password;
    private String username;
    @ManyToMany
    private List<Roles> roles;
    private boolean accountNonExpired;
    private boolean accountNonLocked;
    private boolean credentialsNonExpired;
    private boolean enabled;

    @OneToOne(mappedBy = "autenticacao")
    private Usuario usuario;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.getRoles()
                .stream()
                .map(role -> new SimpleGrantedAuthority("ROLE_" + role.getName()))
                .collect(Collectors.toList());
    }
}
