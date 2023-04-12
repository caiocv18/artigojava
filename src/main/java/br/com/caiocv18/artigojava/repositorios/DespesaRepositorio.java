package br.com.caiocv18.artigojava.repositorios;

import br.com.caiocv18.artigojava.entidades.Despesa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DespesaRepositorio extends JpaRepository<Despesa,Long> {
}
