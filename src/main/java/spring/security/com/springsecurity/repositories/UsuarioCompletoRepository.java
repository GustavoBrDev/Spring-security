package spring.security.com.springsecurity.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.security.com.springsecurity.models.entity.UsuarioCompleto;

import java.util.Optional;

public interface UsuarioCompletoRepository extends JpaRepository<UsuarioCompleto, Long> {

    Optional<UsuarioCompleto> findByUsername(String username);
}
