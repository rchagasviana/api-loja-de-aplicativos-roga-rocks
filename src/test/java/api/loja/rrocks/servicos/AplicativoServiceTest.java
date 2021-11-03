package api.loja.rrocks.servicos;


import api.loja.rrocks.entidades.Aplicativo;
import api.loja.rrocks.entidades.Categoria;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.junit.jupiter.api.Assertions.assertEquals;

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

}
