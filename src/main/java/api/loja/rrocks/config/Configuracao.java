package api.loja.rrocks.config;

import api.loja.rrocks.entidades.Categoria;
import api.loja.rrocks.entidades.Cidade;
import api.loja.rrocks.entidades.Estado;
import api.loja.rrocks.repositorios.CategoriaRepository;
import api.loja.rrocks.repositorios.CidadeRepository;
import api.loja.rrocks.repositorios.EstadoRepository;
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
    private CategoriaRepository categoriaRepository;

    @Autowired
    private EstadoRepository estadoRepository;

    @Autowired
    private CidadeRepository cidadeRepository;

    @Override
    public void run(String... args) throws Exception {

        //POPULANDO ESTADO
        Estado estado01 = new Estado(null, "Maranhão (MA)");
        Estado estado02 = new Estado(null, "Piauí (PI)");
        Estado estado03 = new Estado(null, "Ceará (CE)");
        Estado estado04 = new Estado(null, "Rio Grande do Norte (RN)");
        Estado estado05 = new Estado(null, "Pernambuco (PE)");
        Estado estado06 = new Estado(null, "Paraíba (PB)");
        Estado estado07 = new Estado(null, "Sergipe (SE)");
        Estado estado08 = new Estado(null, "Alagoas (AL)");
        Estado estado09 = new Estado(null, "Bahia (BA)");
        Estado estado10 = new Estado(null, "Rio Grande do Sul (RS)");
        Estado estado11 = new Estado(null, "Santa Catarina (SC)");
        estadoRepository.saveAll(Arrays.asList(estado01, estado02, estado03, estado04, estado05, estado06, estado07, estado08, estado09, estado10, estado11));

        //POPULANDO CIDADE
        Cidade cidade01 = new Cidade(null, "São Luís", estado01);
        Cidade cidade02 = new Cidade(null, "Teresina", estado02);
        Cidade cidade03 = new Cidade(null, "Fortaleza", estado03);
        Cidade cidade04 = new Cidade(null, "Natal", estado04);
        Cidade cidade05 = new Cidade(null, "Recife", estado05);
        Cidade cidade06 = new Cidade(null, "João Pessoa", estado06);
        Cidade cidade07 = new Cidade(null, "Aracaju", estado07);
        Cidade cidade08 = new Cidade(null, "Maceió", estado08);
        Cidade cidade09 = new Cidade(null, "Salvador", estado09);
        Cidade cidade10 = new Cidade(null, "Porto Alegre", estado10);
        Cidade cidade11 = new Cidade(null, "Florianópolis", estado11);
        Cidade cidade12 = new Cidade(null, "Imperatriz", estado01);
        Cidade cidade13 = new Cidade(null, "Caxias", estado01);
        Cidade cidade14 = new Cidade(null, "Barreirinhas", estado01);
        cidadeRepository.saveAll(Arrays.asList(cidade01, cidade02, cidade03, cidade04, cidade05, cidade06, cidade07, cidade08, cidade09, cidade10, cidade11, cidade12, cidade13, cidade14));


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
        categoriaRepository.saveAll(Arrays.asList(categoria01, categoria02, categoria03, categoria04, categoria05, categoria06, categoria07, categoria08, categoria09, categoria10));

    }
}
