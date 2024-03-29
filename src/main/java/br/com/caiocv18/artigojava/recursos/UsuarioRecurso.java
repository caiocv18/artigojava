package br.com.caiocv18.artigojava.recursos;

import br.com.caiocv18.artigojava.entidades.Usuario;
import br.com.caiocv18.artigojava.servicos.UsuarioServico;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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

    @PostMapping //Informa que se trata de uma requisição que utiliza o método PUT
    public ResponseEntity<Usuario> inserir(@RequestBody Usuario novoUsuario){ //@RequestBody informa que se trata de uma requisição que precisa de um corpo do tipo Usuario
        novoUsuario = servico.inserir(novoUsuario); //Insere no banco de dados invocando o método que foi criado dentro do UsuarioServico
        URI uri = ServletUriComponentsBuilder. //Serve para construir uma nova URI
                fromCurrentRequest(). //Informa para construir a nova URI com base na requisição atual
                path("/{id}"). //Adiciona o valor do ID após o "/"
                buildAndExpand(novoUsuario.getId()). //Permite a criação da URI dinâmica de acordo com o valor que for retornado no parâmetro
                toUri(); //Converte o resultado das operações anteriores para o formato de URI
        return ResponseEntity.created(uri).body(novoUsuario);
    }

    @DeleteMapping(value = "/{id}") //Informa que se trata de uma requisição que utiliza o método DELETE e que será passado o parâmetro ID
    public ResponseEntity<Void> remover(@PathVariable Long id){ //Void informa que será uma requisição sem nenhum retorno na resposta e @PathVariable é utilizado para recuperar o ID que foi passado pelo Path da requisição
        servico.remover(id); //Remove no banco de dados invocando o método criado dentro de UsuarioServico
        return ResponseEntity.noContent().build(); //Responde a requisição de deleção de usuário de forma a não ter conteúdo
    }

    @PutMapping(value = "/{id}") //Informa que se trata de uma requisição que utiliza o método PUT e que será passado o parâmetro ID
    public ResponseEntity<Usuario> atualizar(@PathVariable Long id, @RequestBody Usuario usuarioAtualizado){
        usuarioAtualizado = servico.atualizar(id, usuarioAtualizado); //Atualiza no banco de dados invocando o método criado dentro de UsuarioServico
        return ResponseEntity.ok().body(usuarioAtualizado); //Responde a requisição informando os dados atualizados do usuário no corpo da resposta
    }
}
