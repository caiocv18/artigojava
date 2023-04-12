package br.com.caiocv18.artigojava.recursos;

import br.com.caiocv18.artigojava.entidades.Categoria;
import br.com.caiocv18.artigojava.servicos.CategoriaServico;
import br.com.caiocv18.artigojava.servicos.UsuarioServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaRecurso {
    @Autowired
    CategoriaServico servico;
    @GetMapping
    public ResponseEntity<List<Categoria>> procurarTodos(){
        List<Categoria> lista = servico.pesquisarTodos();
        return ResponseEntity.ok().body(lista);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Categoria> procurarTodos(@PathVariable Long id){
        Categoria categoria = servico.procurarPorId(id);
        return ResponseEntity.ok().body(categoria);
    }
}
