package br.com.caiocv18.artigojava.configuracao;

import br.com.caiocv18.artigojava.entidades.Usuario;
import br.com.caiocv18.artigojava.repositorios.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.ArrayList;
import java.util.Arrays;

@Configuration
@Profile("teste")
public class TesteConfiguracao implements CommandLineRunner {
    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    @Override
    public void run(String... args) throws Exception {
        Usuario usuario1 = new Usuario("Caio", "caio@gmail.com", "123456");
        Usuario usuario2 = new Usuario("Vinicius", "vinicius@gmail.com" ,"123456");

        usuarioRepositorio.saveAll(Arrays.asList(usuario1,usuario2));

    }
}
