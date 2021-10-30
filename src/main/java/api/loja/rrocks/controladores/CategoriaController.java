package api.loja.rrocks.controladores;


import api.loja.rrocks.dto.CategoriaDTO;
import api.loja.rrocks.dto.CategoriaRepostaDTO;
import api.loja.rrocks.entidades.Categoria;
import api.loja.rrocks.servicos.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService servico;

    //RECUPERRA TODAS AS CATEGORIAS
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<CategoriaRepostaDTO>> buscarTodos() {
        //Recebe a lista do tipo Categoria
        List<Categoria> listaDeCategorias = servico.buscarTodos();
        //Converter para o tipo CategoriaRepostaDTO
        List<CategoriaRepostaDTO> listaCategoriaDTO = CategoriaRepostaDTO.converterParaListaVendaDTO(listaDeCategorias);
        return ResponseEntity.ok().body(listaCategoriaDTO);
    }

    //RECUPERAR CATEGORIA POR ID
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> buscarPorId(@PathVariable Long id) {
        Categoria categoria = new Categoria();
        categoria = servico.buscarPorId(id);
        return ResponseEntity.ok().body(categoria);
    }

    //SALVAR UMA NOVA CATEGORIA
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Categoria> salvar(@Valid @RequestBody CategoriaDTO categoriaDTO) {
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

        Categoria categoria = servico.converterParaCategoria(categoriaDTO);

        servico.salvar(categoria);
        URI uriBuscaNovoDadoInserido = ServletUriComponentsBuilder
                .fromCurrentRequestUri()
                .path("/{id}")
                .buildAndExpand(categoria.getId()).toUri();
        return ResponseEntity.created(uriBuscaNovoDadoInserido).build();

    }

}
