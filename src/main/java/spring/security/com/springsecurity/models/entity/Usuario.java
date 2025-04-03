package spring.security.com.springsecurity.models.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import spring.security.com.springsecurity.security.models.entity.UsuarioAutenticacao;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
public class Usuario {

    @Id
    @GeneratedValue ( strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;

    private String endereco;

    @OneToOne( cascade = CascadeType.PERSIST)
    private UsuarioAutenticacao autenticacao;
}
