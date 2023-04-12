package br.com.caiocv18.artigojava.servicos;

import br.com.caiocv18.artigojava.entidades.Receita;
import br.com.caiocv18.artigojava.repositorios.ReceitaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReceitaServico {
    @Autowired
    private ReceitaRepositorio repositorio;

    public List<Receita> pesquisarTodos() {
        return repositorio.findAll();
    }

    public Receita procurarPorId(Long id) {
        Optional<Receita> receita = repositorio.findById(id);
        return receita.get();
    }
}
