package api.loja.rrocks.servicos;


import api.loja.rrocks.entidades.Aplicativo;
import api.loja.rrocks.entidades.Categoria;
import api.loja.rrocks.entidades.Fabricante;
import api.loja.rrocks.entidades.Release;
import api.loja.rrocks.entidades.enums.ClassificacaoAplicativo;
import api.loja.rrocks.entidades.enums.StatusAplicativo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Instant;
import java.util.Optional;

@SpringBootTest
@WebAppConfiguration
public class AplicativoServiceTest {

    @Autowired
    private AplicativoService servico;


    @Test
    public void buscarPorCategoriaPrecoTest() {
        Categoria categoria = new Categoria();
        categoria.setId(1L);
        Aplicativo aplicativo = servico.buscarPorCategoriaPreco(categoria);
        /*
         * Compara o retorno com o esperado que é o 6 cujo aplicativo possui o menor valor da categoria
         * */
        assertEquals("6", aplicativo.getId());
    }

    @Test
    public void buscarPorNomeTipoTest() {
        String nome = "Lembrete de Contas PRO";
        Categoria categoria = new Categoria();
        categoria.setId(7L);
        servico.buscarPorNomeTipo(nome, categoria);
        assertEquals(5, categoria.getId());
    }

    @Test
    public void salvar() {
        Categoria categoria = new Categoria();
        Fabricante fabricante = new Fabricante();

        categoria.setId(1L);
        fabricante.setId(1L);

        Aplicativo aplicativo = new Aplicativo(
                null, "Teste",
                30.99, "Testando aplicação ",
                ClassificacaoAplicativo.NAO_RECOMENDADA_MENORES_18_ANOS, StatusAplicativo.EM_DESENVOLVIMENTO,
                categoria, fabricante
        );

        Release release = new Release(
                null, "1.0.1",
                Instant.parse("2020-07-01T00:00:00Z"), Instant.parse("2021-11-01T00:00:00Z"),
                "Versão de teste", aplicativo);
        aplicativo.getReleases().add(release);

        Aplicativo aplicativo01 = servico.salvar(aplicativo);

        assertEquals(true,aplicativo01);
    }

}
