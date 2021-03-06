package api.loja.rrocks.controladores;


import api.loja.rrocks.dto.AplicativoRespostaDTO;
import api.loja.rrocks.dto.AplicativoSalvarDTO;
import api.loja.rrocks.entidades.Aplicativo;
import api.loja.rrocks.entidades.Categoria;
import api.loja.rrocks.servicos.AplicativoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;


@RestController
@RequestMapping(value = "/aplicativos")
public class AplicativoController {

    @Autowired
    private AplicativoService servico;

    /*
    *Utilizado pra limpar todos os cache de uma só vez e não apenas baseado em uma única chave
    * Gerenciador de Cache.
    *
    * */

    //LISTAR TODOS OS APLICATIVOS
    @Cacheable(value = "buscarTodosAplicativos")
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<AplicativoRespostaDTO>> buscarTodos() {
        List<Aplicativo> listaDeAplicativo = servico.buscarTodos();
        //Converter para o padrão de resposta
        List<AplicativoRespostaDTO> listaAplicativoDTO = AplicativoRespostaDTO.converterParaListaAplicativoDTO(listaDeAplicativo);
        return ResponseEntity.ok().body(listaAplicativoDTO);
    }


    //RECEBE O ID DA CATEGORIA E RETORNA O PRODUTO MAIS BARATO
    @Cacheable(value = "buscarMaisBaratoPorTipoAplicativos")
    @RequestMapping(value = "/{categoria}", method = RequestMethod.GET)
    public ResponseEntity<?> buscarMaisBaratoPorTipo(@PathVariable Categoria categoria) {
        Aplicativo listaDeAplicativos = servico.buscarPorCategoriaPreco(categoria);
        return ResponseEntity.ok().body(listaDeAplicativos);
    }


    //BUSCAR APLICATIVO POR NOME E TIPO (categoria)
    @Cacheable(value = "buscarPorNomeTipoAplicativos")
    @RequestMapping(value = "/{nome}/{categoria}", method = RequestMethod.GET)
    public ResponseEntity<Aplicativo> buscarPorNomeTipo(@PathVariable String nome, @PathVariable Categoria categoria) {
        Aplicativo listaDeAplicativos = servico.buscarPorNomeTipo(nome, categoria);
        return ResponseEntity.ok().body(listaDeAplicativos);
    }


    //SALVAR UM NOVO APLICATIVO
    @CacheEvict(value = "buscarTodosAplicativos", allEntries = true)
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Aplicativo> salvar(@Valid @RequestBody AplicativoSalvarDTO aplicativoSalvarDTO) {
        /*
         * Conforme a RFC 2616, o código 201 é retornado sempre que um novo valor é inserido, logo
         * a fim de seguir tal padrão todos os métodos utilizados para salvar deverão retornar o código
         * 201. O que é bem válido para padronização da aplicação e melhor comunicação com a equipe de front-end
         * Link: https://www.w3.org/Protocols/rfc2616/rfc2616-sec10.html#sec10
         *
         * Outra boa prática é retornar a URI que busca o novo recurso inserido
         * ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}") -> monta a URI/id
         * buildAndExpand() -> captura o id do nodo dado inserido
         * */

        Aplicativo aplicativo = servico.fromDTOSalvar(aplicativoSalvarDTO);

        servico.salvar(aplicativo);
        URI uriBuscaNovoDadoInserido = ServletUriComponentsBuilder
                .fromCurrentRequestUri()
                .path("/{id}")
                .buildAndExpand(aplicativo.getId()).toUri();
        return ResponseEntity.created(uriBuscaNovoDadoInserido).build();

    }

}
