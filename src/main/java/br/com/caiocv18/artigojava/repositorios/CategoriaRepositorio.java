package br.com.caiocv18.artigojava.repositorios;

import br.com.caiocv18.artigojava.entidades.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepositorio extends JpaRepository<Categoria, Long> {
}
