package br.com.caiocv18.artigojava.servicos;

import br.com.caiocv18.artigojava.entidades.Despesa;
import br.com.caiocv18.artigojava.repositorios.DespesaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DespesaServico {
    @Autowired
    private DespesaRepositorio repositorio;

    public List<Despesa> pesquisarTodos() {
        return repositorio.findAll();
    }

    public Despesa procurarPorId(Long id) {
        Optional<Despesa> despesa = repositorio.findById(id);
        return despesa.get();
    }
}
