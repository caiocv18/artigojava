package br.com.caiocv18.artigojava.recursos;

import br.com.caiocv18.artigojava.entidades.Usuario;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioRecurso {
    @GetMapping
    public ResponseEntity<Usuario> procurarTodos(){

        Usuario novoUsuario = new Usuario(1, "Caio", "caiocv18_dev@gmail.com", "12345");
        return ResponseEntity.ok().body(novoUsuario);
    }
}
