package br.com.caiocv18.artigojava.recursos;

import br.com.caiocv18.artigojava.entidades.Despesa;
import br.com.caiocv18.artigojava.servicos.DespesaServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/despesas")
public class DespesaRecurso {
    @Autowired
    DespesaServico servico;

    @GetMapping
    public ResponseEntity<List<Despesa>> procurarTodos() {
        List<Despesa> lista = servico.pesquisarTodos();
        return ResponseEntity.ok().body(lista);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Despesa> procurarTodos(@PathVariable Long id) {
        Despesa despesa = servico.procurarPorId(id);
        return ResponseEntity.ok().body(despesa);
    }
}
