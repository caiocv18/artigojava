package br.com.caiocv18.artigojava.recursos;

import br.com.caiocv18.artigojava.entidades.Usuario;
import br.com.caiocv18.artigojava.servicos.UsuarioServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioRecurso {
    @Autowired
    UsuarioServico servico;
    @GetMapping
    public ResponseEntity<List<Usuario>> procurarTodos(){
        List<Usuario> lista = servico.pesquisarTodos();
        return ResponseEntity.ok().body(lista);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Usuario> procurarTodos(@PathVariable Long id){
        Usuario usuario = servico.procurarPorId(id);
        return ResponseEntity.ok().body(usuario);
    }
}
