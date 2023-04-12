package br.com.caiocv18.artigojava.servicos;

import br.com.caiocv18.artigojava.entidades.Categoria;
import br.com.caiocv18.artigojava.repositorios.CategoriaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaServico {
    @Autowired
    private CategoriaRepositorio repositorio;

    public List<Categoria> pesquisarTodos() {
        return repositorio.findAll();
    }

    public Categoria procurarPorId(Long id) {
        Optional<Categoria> categoria = repositorio.findById(id);
        return categoria.get();
    }
}
