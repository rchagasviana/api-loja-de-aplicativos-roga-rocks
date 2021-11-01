package api.loja.rrocks.config;

import api.loja.rrocks.entidades.*;
import api.loja.rrocks.repositorios.CategoriaRepository;
import api.loja.rrocks.repositorios.CidadeRepository;
import api.loja.rrocks.repositorios.EstadoRepository;
import api.loja.rrocks.repositorios.UsuarioRepository;
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

    @Autowired
    private UsuarioRepository usuarioRepository;

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


        //PPOPULANDO CATEGORIA
        Categoria categoria01 = new Categoria(null, "Apps para smartwatch", Instant.now());
        Categoria categoria02 = new Categoria(null, "Compras", Instant.now());
        Categoria categoria03 = new Categoria(null, "Comunicação", Instant.now());
        Categoria categoria04 = new Categoria(null, "Educação", Instant.now());
        Categoria categoria05 = new Categoria(null, "Finanças", Instant.now());
        Categoria categoria06 = new Categoria(null, "Mapas e navegação", Instant.now());
        Categoria categoria07 = new Categoria(null, "Produtividade", Instant.now());
        Categoria categoria08 = new Categoria(null, "Música e áudio", Instant.now());
        Categoria categoria09 = new Categoria(null, "Saúde e fitness", Instant.now());
        categoriaRepository.saveAll(Arrays.asList(categoria01, categoria02, categoria03, categoria04, categoria05, categoria06, categoria07, categoria08, categoria09));

        //POPULANDO USUARIO-FABRICANTE
        Usuario fabricante01 = new Fabricante(null, "Seleep Cycle AB", Instant.parse("2004-02-01T11:00:07Z"), "14.780.865/0001-22");
        Usuario fabricante02 = new Fabricante(null, "Perigee AB", Instant.parse("2004-02-01T00:00:00Z"), "15.800.455/0001-69");
        Usuario fabricante03 = new Fabricante(null, "Shoppe", Instant.parse("2005-05-01T00:00:00Z"), "48.972.014/0001-01");
        Usuario fabricante04 = new Fabricante(null, "Mosaico Negócios de Internet S.A", Instant.parse("2001-09-01T00:00:00Z"), "41.748.245/0001-89");
        Usuario fabricante05 = new Fabricante(null, "Skype", Instant.parse("2002-10-01T00:00:00Z"), "51.594.730/0001-07");
        Usuario fabricante06 = new Fabricante(null, "Gran Cursos Onlline", Instant.parse("2008-07-01T00:00:00Z"), "84.481.138/0001-40");
        Usuario fabricante07 = new Fabricante(null, "C6 Bank", Instant.parse("2008-07-01T00:00:00Z"), "03.841.392/0001-00");
        Usuario fabricante08 = new Fabricante(null, "Waze", Instant.parse("2008-07-01T00:00:00Z"), "15.598.897/0001-74");
        Usuario fabricante09 = new Fabricante(null, "Handy Apps", Instant.parse("2008-07-01T00:00:00Z"), "29.953.218/0001-42");
        Usuario fabricante10 = new Fabricante(null, "Spotify AB", Instant.parse("2008-07-01T00:00:00Z"), "51.621.179/0001-35");
        Usuario fabricante11 = new Fabricante(null, "Adidas Runtastic", Instant.parse("2008-07-01T00:00:00Z"), "53.552.175/0001-78");

        usuarioRepository.saveAll(Arrays.asList(fabricante01, fabricante02, fabricante03, fabricante04, fabricante05, fabricante06, fabricante07, fabricante08, fabricante09, fabricante10, fabricante11));

    }
}
