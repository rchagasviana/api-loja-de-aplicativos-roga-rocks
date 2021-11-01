package api.loja.rrocks.config;

import api.loja.rrocks.entidades.*;
import api.loja.rrocks.entidades.enums.ClassificacaoAplicativo;
import api.loja.rrocks.entidades.enums.Sexo;
import api.loja.rrocks.entidades.enums.StatusAplicativo;
import api.loja.rrocks.repositorios.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.transaction.Transactional;
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
    @Autowired
    private EnderecoRepository enderecoRepository;
    @Autowired
    private ContatoRepository contatoRepository;
    @Autowired
    private AplicativoRepository aplicativoRepository;

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

        //POPULANDO ENDEREÇO PARA USUÁRIOS-FABRICANTES
        Endereco endereco01 = new Endereco(null, "1ª Travessa Quinta dos Machados", "30-B", "Próximo à Universidade X", "Túnel do Sacavém", "65043-243", cidade01, fabricante01);
        Endereco endereco02 = new Endereco(null, "Rua Marechal Castelo Branco", "SN", "Próximo à Escola A", "Olho D'Água", "65065-090", cidade01, fabricante02);
        Endereco endereco03 = new Endereco(null, "Rua Vereador Paulo Fortes", "SN", "Próximo ao Batalhão PM-MA", "Recanto das Palmeiras", "64045-780", cidade02, fabricante03);
        Endereco endereco04 = new Endereco(null, "Rua I", "SN", "Próximo ao Hospital da Cidade", "Parque Dois Irmãos", "60761-305", cidade03, fabricante04);
        Endereco endereco05 = new Endereco(null, "Rua I", "SN", "Próximo ao Centro Industrial", "Parque Dois Irmãos", "60761-305", cidade03, fabricante05);
        Endereco endereco06 = new Endereco(null, "Rua I", "SN", "Próximo ao Centro Industrial", "Parque Dois Irmãos", "60761-305", cidade03, fabricante06);
        Endereco endereco07 = new Endereco(null, "Rua I", "SN", "Próximo ao Centro Industrial", "Parque Dois Irmãos", "60761-305", cidade03, fabricante07);
        Endereco endereco08 = new Endereco(null, "Rua I", "SN", "Próximo ao Centro Industrial", "Parque Dois Irmãos", "60761-305", cidade03, fabricante08);
        Endereco endereco09 = new Endereco(null, "Rua I", "SN", "Próximo ao Centro Industrial", "Parque Dois Irmãos", "60761-305", cidade03, fabricante09);
        Endereco endereco10 = new Endereco(null, "Rua I", "SN", "Próximo ao Centro Industrial", "Parque Dois Irmãos", "60761-305", cidade03, fabricante10);
        Endereco endereco11 = new Endereco(null, "Rua I", "SN", "Próximo ao Centro Industrial", "Parque Dois Irmãos", "60761-305", cidade03, fabricante11);
        Endereco endereco12 = new Endereco(null, "Rua I", "SN", "Próximo ao Centro Industrial", "Parque Dois Irmãos", "60761-305", cidade03, fabricante01);
        enderecoRepository.saveAll(Arrays.asList(endereco01, endereco02, endereco03, endereco04, endereco05, endereco06, endereco07, endereco08, endereco09, endereco10, endereco11, endereco12));

        //POPULANDO CONTATO PARA USUÁRIOS-FABRICANTES
        Contato contato01 = new Contato(null, "SeleepCycleAB@hotmail.com", "(98) 38247-0672", fabricante01);
        Contato contato02 = new Contato(null, "PerigeeAB@hotmail.com", "(36) 20798-3058", fabricante02);
        Contato contato03 = new Contato(null, "Shoppe@hotmail.com", "(82) 34688-6182", fabricante03);
        Contato contato04 = new Contato(null, "MosaicoNegóciosdeInternetS.A@hotmail.com", "(74) 53726-5164", fabricante04);
        Contato contato05 = new Contato(null, "Skype@hotmail.com", "(49) 72715-8818", fabricante05);
        Contato contato06 = new Contato(null, "GranCursosOnlline@hotmail.com", "(73) 43947-4354", fabricante06);
        Contato contato07 = new Contato(null, "C6Bank@hotmail.com", "(71) 37943-4490", fabricante07);
        Contato contato08 = new Contato(null, "Waze@hotmail.com", "(69) 89174-6615", fabricante08);
        Contato contato09 = new Contato(null, "HandyApps@hotmail.com", "(89) 60144-5979", fabricante09);
        Contato contato10 = new Contato(null, "SpotifyAB@hotmail.com", "(21) 83039-1299", fabricante10);
        Contato contato11 = new Contato(null, "AdidasRuntastic@hotmail.com", "(49) 25733-9335", fabricante11);
        contatoRepository.saveAll(Arrays.asList(contato01, contato02, contato03, contato04, contato05, contato06, contato07, contato08, contato09, contato10, contato11));


        //POPULANDO USUÁRIO CONSUMIDOR
        Usuario consumidor01 = new Consumidor(null, "Gael Cláudio Murilo das Neves", Instant.parse("1980-07-01T00:00:00Z"), Sexo.MASCULINO, "Programador");
        Usuario consumidor02 = new Consumidor(null, "Ryan Bruno Raul Silveira", Instant.parse("1985-07-01T00:00:00Z"), Sexo.MASCULINO, "Engenheiro Civil");
        Usuario consumidor03 = new Consumidor(null, "Stella Cláudia Lopes", Instant.parse("1950-07-01T00:00:00Z"), Sexo.FEMININO, "Educador Físico");
        Usuario consumidor04 = new Consumidor(null, "Rafael Luan Erick Martins", Instant.parse("1988-07-01T00:00:00Z"), Sexo.MASCULINO, "Médico");
        Usuario consumidor05 = new Consumidor(null, "Juliana Evelyn Figueiredo", Instant.parse("1990-07-01T00:00:00Z"), Sexo.FEMININO, "Advogado");
        Usuario consumidor06 = new Consumidor(null, "Vanessa Sophia Alves", Instant.parse("1996-07-01T00:00:00Z"), Sexo.FEMININO, "Policial");
        Usuario consumidor07 = new Consumidor(null, "Miguel Yago Vicente da Cruz", Instant.parse("2000-07-01T00:00:00Z"), Sexo.MASCULINO, "Vendedor");
        Usuario consumidor08 = new Consumidor(null, "Martin Marcelo Giovanni Martins", Instant.parse("2008-07-01T00:00:00Z"), Sexo.MASCULINO, "Auxiliar de Serviços Gerais");
        Usuario consumidor09 = new Consumidor(null, "Manuela Cecília Baptista", Instant.parse("2005-07-01T00:00:00Z"), Sexo.FEMININO, "Professor");
        Usuario consumidor10 = new Consumidor(null, "Márcia Alessandra da Costa", Instant.parse("1960-07-01T00:00:00Z"), Sexo.FEMININO, "Analista Financeiro");
        Usuario consumidor11 = new Consumidor(null, "César Ruan Gomes", Instant.parse("1960-07-01T00:00:00Z"), Sexo.MASCULINO, "Engenheiro de Software");
        usuarioRepository.saveAll(Arrays.asList(consumidor01, consumidor02, consumidor03, consumidor04, consumidor05, consumidor06, consumidor07, consumidor08, consumidor09, consumidor10, consumidor11));

        //POPULANDO ENDEREÇO PARA USUÁRIOS-CONSUMIDORES
        Endereco endereco13 = new Endereco(null, "Via de Acesso Oito", "30-B", "Próximo à Universidade X", "Jardim Carvalho", "91430-265", cidade01, consumidor01);
        Endereco endereco14 = new Endereco(null, "Beco Nove", "SN", "Próximo à Escola A", "Protásio Alves", "91450-600", cidade01, consumidor02);
        Endereco endereco15 = new Endereco(null, "Acesso Cinco B", "SN", "Próximo ao Batalhão PM-MA", "Sarandi", "91120-024", cidade02, consumidor03);
        Endereco endereco16 = new Endereco(null, "Rua Nova Petrópolis", "SN", "Próximo ao Hospital da Cidade", "Cascata", "91710-500", cidade03, consumidor04);
        Endereco endereco17 = new Endereco(null, "Rua Miraguaí", "SN", "Próximo ao Centro Industrial", "Lomba do Pinheiro", "91550-826", cidade03, consumidor05);
        Endereco endereco18 = new Endereco(null, "Rua João Cláudio Ribeiro da Roza", "SN", "Próximo ao Centro Industrial", "Lami", "91787-667", cidade03, consumidor06);
        Endereco endereco19 = new Endereco(null, "Travessa Dois", "SN", "Próximo ao Centro Industrial", "Novo Angelim", "65060-474", cidade03, consumidor07);
        Endereco endereco20 = new Endereco(null, "Travessa Nove", "SN", "Próximo ao Centro Industrial", "Chácara Itapiracó", "65054-890", cidade03, consumidor08);
        Endereco endereco21 = new Endereco(null, "Fonte das Pedras", "SN", "Próximo ao Centro Industrial", "Centro", "65015-400", cidade03, consumidor09);
        Endereco endereco22 = new Endereco(null, "Rua Quarenta e Nove", "SN", "Próximo ao Centro Industrial", "Vinhais", "65071-260", cidade03, consumidor10);
        Endereco endereco23 = new Endereco(null, "Rua Frei Sampaio", "SN", "Próximo ao Centro Industrial", "Lira", "65025-430", cidade03, consumidor11);
        Endereco endereco24 = new Endereco(null, "Rua dos Timbós", "SN", "Próximo ao Centro Industrial", "Jardim Renascença", "65075-410", cidade03, consumidor02);
        enderecoRepository.saveAll(Arrays.asList(endereco13, endereco14, endereco15, endereco16, endereco17, endereco18, endereco19, endereco20, endereco21, endereco22, endereco23, endereco24));

        //POPULANDO CONTATOS PARA USUÁRIOS-CONSUMIDORES
        Contato contato12 = new Contato(null, "GaelClaudio@hotmail.com", "(52) 65857-4467", consumidor01);
        Contato contato13 = new Contato(null, "RyanBruno@hotmail.com", "(18) 46280-1404", consumidor02);
        Contato contato14 = new Contato(null, "StellaClaudia@hotmail.com", "(69) 79034-6774", consumidor03);
        Contato contato15 = new Contato(null, "RafaelLuan@hotmail.com", "(16) 46828-9125", consumidor04);
        Contato contato16 = new Contato(null, "JulianaEvelyn@hotmail.com", "(24) 65281-0826", consumidor05);
        Contato contato17 = new Contato(null, "VanessaSophia@hotmail.com", "(60) 45656-1182", consumidor06);
        Contato contato18 = new Contato(null, "MiguelYago@hotmail.com", "(72) 30890-8909", consumidor07);
        Contato contato19 = new Contato(null, "MartinMarcelo@hotmail.com", "(38) 65081-7306", consumidor08);
        Contato contato20 = new Contato(null, "ManuelaCecilia@hotmail.com", "(17) 84004-1902", consumidor09);
        Contato contato21 = new Contato(null, "MarciaAlessandra@hotmail.com", "(86) 17983-2760", consumidor10);
        Contato contato22 = new Contato(null, "CesarRuan@hotmail.com", "(69) 32897-5096", consumidor11);
        contatoRepository.saveAll(Arrays.asList(contato12, contato13, contato14, contato15, contato16, contato17, contato18, contato19, contato20, contato21, contato22));


        //POPULANDO APLICATIVO
        Aplicativo aplicativo01 = new Aplicativo(
                null,
                "Sleep Cyce: Gravador de sono",
                12.25,
                "Regule seu sono diariamente como nosso APP.",
                ClassificacaoAplicativo.CLASSIFICACAO_LIVRE,
                StatusAplicativo.EM_DESENVOLVIMENTO,
                categoria01,
                fabricante01
        );
        Aplicativo aplicativo02 = new Aplicativo(
                null,
                "Sleep Cyce: Gravador de corrida",
                5.37,
                "Pode ser utiliziado para gravar os treinos durante uma atividade física",
                ClassificacaoAplicativo.CLASSIFICACAO_LIVRE,
                StatusAplicativo.DESCONTINUADO,
                categoria01,
                fabricante01
        );

        Aplicativo aplicativo03 = new Aplicativo(
                null,
                "Shopee",
                2.57,
                "Compre com promoções",
                ClassificacaoAplicativo.CLASSIFICACAO_LIVRE,
                StatusAplicativo.EM_DESENVOLVIMENTO,
                categoria02,
                fabricante03
        );

        aplicativoRepository.saveAll(Arrays.asList(aplicativo01, aplicativo02, aplicativo03));


    }
}
