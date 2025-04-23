package spring.security.com.springsecurity.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import spring.security.com.springsecurity.models.entity.Usuario;
import spring.security.com.springsecurity.security.models.entity.UsuarioAutenticacao;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    @Query("SELECT u FROM UsuarioAutenticacao u LEFT JOIN FETCH u.roles WHERE u.username = :username")
    Optional<UsuarioAutenticacao> findByUsernameWithRoles(String username);
}
