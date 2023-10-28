package br.com.caiocv18.artigojava.servicos;

import br.com.caiocv18.artigojava.entidades.Usuario;
import br.com.caiocv18.artigojava.repositorios.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServico {
    @Autowired
    private UsuarioRepositorio repositorio;

    public List<Usuario> pesquisarTodos(){
        return repositorio.findAll();
    }

    public Usuario procurarPorId(Long id){
        Optional<Usuario> usuario = repositorio.findById(id);
        return usuario.get();
    }

    public Usuario inserir (Usuario novoUsuario){
        return repositorio.save(novoUsuario);
    }
}
