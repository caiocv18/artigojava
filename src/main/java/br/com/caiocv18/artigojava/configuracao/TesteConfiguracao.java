package br.com.caiocv18.artigojava.configuracao;

import br.com.caiocv18.artigojava.entidades.Categoria;
import br.com.caiocv18.artigojava.entidades.Despesa;
import br.com.caiocv18.artigojava.entidades.Receita;
import br.com.caiocv18.artigojava.entidades.Usuario;
import br.com.caiocv18.artigojava.enums.DespesaStatus;
import br.com.caiocv18.artigojava.enums.ReceitaStatus;
import br.com.caiocv18.artigojava.repositorios.CategoriaRepositorio;
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
    @Autowired
    private CategoriaRepositorio categoriaRepositorio;

    @Override
    public void run(String... args) throws Exception {
        Usuario usuario1 = new Usuario("Caio", "caio@gmail.com", "123456");
        Usuario usuario2 = new Usuario("Vinicius", "vinicius@gmail.com", "123456");

        usuarioRepositorio.saveAll(Arrays.asList(usuario1, usuario2));

        Categoria categoria1 = new Categoria("Combustível");
        Categoria categoria2 = new Categoria("Alimentação");
        Categoria categoria3 = new Categoria("Trabalho");
        Categoria categoria4 = new Categoria("Contas mensais");

        categoriaRepositorio.saveAll(Arrays.asList(categoria1, categoria2, categoria3, categoria4));

        Receita receita1 = new Receita("Salário", 2900.00, Instant.now(), ReceitaStatus.RECEBIDA, usuario1, categoria3);
        Receita receita2 = new Receita("Salário", 4000.00, Instant.now(), ReceitaStatus.RECEBIDA, usuario2, categoria3);
        Receita receita3 = new Receita("Bônus", 500.00, Instant.now(), ReceitaStatus.AGENDADA, usuario1, categoria3);

        Despesa despesa1 = new Despesa("Gasolina", 50.00, Instant.now(), DespesaStatus.PAGA, usuario1, categoria1);
        Despesa despesa2 = new Despesa("Conta de luz", 150.00, Instant.now(), DespesaStatus.ATRASADA, usuario2, categoria4);
        Despesa despesa3 = new Despesa("Almoço", 25.00, Instant.now(), DespesaStatus.PAGA, usuario1, categoria2);


        receitaRepositorio.saveAll(Arrays.asList(receita1, receita2, receita3));
        despesaRepositorio.saveAll(Arrays.asList(despesa1, despesa2, despesa3));


    }
}
