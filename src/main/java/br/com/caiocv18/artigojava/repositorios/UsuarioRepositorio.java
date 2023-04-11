package br.com.caiocv18.artigojava.repositorios;

import br.com.caiocv18.artigojava.entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepositorio extends JpaRepository<Usuario,Long> {
}
