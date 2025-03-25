package spring.security.com.springsecurity.security.services;

import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import spring.security.com.springsecurity.models.Usuario;
import spring.security.com.springsecurity.repositories.UsuarioRepository;
import spring.security.com.springsecurity.security.UserAdapter;

@Service
@AllArgsConstructor
public class AuthenticationService implements UserDetailsService {

    private UsuarioRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = repository.findByUsuario( username ).orElseThrow(() -> new UsernameNotFoundException( "Usuário não encontrado" ));
        return new UserAdapter( usuario );
    }
}
