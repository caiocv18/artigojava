package br.com.caiocv18.artigojava.recursos;

import br.com.caiocv18.artigojava.entidades.Receita;
import br.com.caiocv18.artigojava.servicos.ReceitaServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/receitas")
public class ReceitaRecurso {
    @Autowired
    ReceitaServico servico;

    @GetMapping
    public ResponseEntity<List<Receita>> procurarTodos() {
        List<Receita> lista = servico.pesquisarTodos();
        return ResponseEntity.ok().body(lista);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Receita> procurarTodos(@PathVariable Long id) {
        Receita receita = servico.procurarPorId(id);
        return ResponseEntity.ok().body(receita);
    }
}
