package br.com.caiocv18.artigojava.configuracao;

import br.com.caiocv18.artigojava.entidades.Despesa;
import br.com.caiocv18.artigojava.entidades.Receita;
import br.com.caiocv18.artigojava.entidades.Usuario;
import br.com.caiocv18.artigojava.repositorios.DespesaRepositorio;
import br.com.caiocv18.artigojava.repositorios.ReceitaRepositorio;
import br.com.caiocv18.artigojava.repositorios.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;

@Configuration
@Profile("teste")
public class TesteConfiguracao implements CommandLineRunner {
    @Autowired
    private UsuarioRepositorio usuarioRepositorio;
    @Autowired
    private ReceitaRepositorio receitaRepositorio;
    @Autowired
    private DespesaRepositorio despesaRepositorio;

    @Override
    public void run(String... args) throws Exception {
        Usuario usuario1 = new Usuario("Caio", "caio@gmail.com", "123456");
        Usuario usuario2 = new Usuario("Vinicius", "vinicius@gmail.com" ,"123456");

        Receita receita1 = new Receita("Salário", 2900.00, Instant.now(), usuario1);
        Receita receita2 = new Receita("Salário", 4000.00, Instant.now(), usuario2);
        Receita receita3 = new Receita("Bônus", 500.00, Instant.now(), usuario1);

        Despesa despesa1 = new Despesa("Gasolina", 50.00, Instant.now(), usuario1);
        Despesa despesa2 = new Despesa("Conta de luz", 150.00, Instant.now(), usuario2);
        Despesa despesa3 = new Despesa("Almoço", 25.00, Instant.now(), usuario1);

        usuarioRepositorio.saveAll(Arrays.asList(usuario1,usuario2));
        receitaRepositorio.saveAll(Arrays.asList(receita1,receita2,receita3));
        despesaRepositorio.saveAll(Arrays.asList(despesa1,despesa2,despesa3));

    }
}
