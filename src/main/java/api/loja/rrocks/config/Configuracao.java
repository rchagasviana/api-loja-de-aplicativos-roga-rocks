package api.loja.rrocks.config;

import api.loja.rrocks.entidades.Categoria;
import api.loja.rrocks.repositorios.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;


@Configuration
@Profile("test")
public class Configuracao implements CommandLineRunner {

    @Autowired
    private CategoriaRepository repositorioCategoria;

    @Override
    public void run(String... args) throws Exception {

        //Populando a tabela Categoria
        Categoria categoria01 = new Categoria(null, "Apps para smartwatch", Instant.now());
        Categoria categoria02 = new Categoria(null, "Compras", Instant.now());
        Categoria categoria03 = new Categoria(null, "Comunicação", Instant.now());
        Categoria categoria04 = new Categoria(null, "Educação", Instant.now());
        Categoria categoria05 = new Categoria(null, "Finanças", Instant.now());
        Categoria categoria06 = new Categoria(null, "Mapas e navegação", Instant.now());
        Categoria categoria07 = new Categoria(null, "Produtividade", Instant.now());
        Categoria categoria08 = new Categoria(null, "Mapas e navegação", Instant.now());
        Categoria categoria09 = new Categoria(null, "Música e áudio", Instant.now());
        Categoria categoria10 = new Categoria(null, "Saúde e fitness", Instant.now());
        //Persistindo categorias
        repositorioCategoria.saveAll(Arrays.asList(categoria01,categoria02,categoria03,categoria04,categoria05,categoria06,categoria07,categoria08,categoria09,categoria10));

    }
}
