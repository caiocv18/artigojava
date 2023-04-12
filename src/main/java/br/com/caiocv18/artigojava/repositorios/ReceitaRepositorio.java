package br.com.caiocv18.artigojava.repositorios;

import br.com.caiocv18.artigojava.entidades.Receita;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReceitaRepositorio extends JpaRepository<Receita,Long> {
}
