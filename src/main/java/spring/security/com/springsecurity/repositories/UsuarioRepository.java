package spring.security.com.springsecurity.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.security.com.springsecurity.models.Usuario;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    public Optional<Usuario> findByUsuario(String usuario);
}
