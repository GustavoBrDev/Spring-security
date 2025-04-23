package spring.security.com.springsecurity.security.services;

import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import spring.security.com.springsecurity.repositories.UsuarioRepository;

@Service
@AllArgsConstructor
public class AuthenticationService implements UserDetailsService {

    private UsuarioRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       return repository.findByAutenticacao_Username(username).get().getAutenticacao();
    }
}
