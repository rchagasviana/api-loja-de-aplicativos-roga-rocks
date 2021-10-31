package api.loja.rrocks.controladores;


import api.loja.rrocks.dto.EstadoDTO;
import api.loja.rrocks.dto.EstadoRespostaDTO;
import api.loja.rrocks.entidades.Estado;
import api.loja.rrocks.entidades.Estado;
import api.loja.rrocks.servicos.EstadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/estados")
public class EstadoController {

    @Autowired
    private EstadoService servico;

    //RECUPERAR TODOS OS ESTADOS
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<EstadoRespostaDTO>> buscarTodos() {
        //Recebe a lista do tipo Estado
        List<Estado> listaDeEstados = servico.buscarTodos();
        //Converter para o tipo EstadoRepostaDTO
        List<EstadoRespostaDTO> listaEstadoDTO = EstadoRespostaDTO.converterParaListaEstadoDTO(listaDeEstados);
        return ResponseEntity.ok().body(listaEstadoDTO);
    }

    //RECUPERAR CATEGORIA POR ID
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> buscarPorId(@PathVariable Long id) {
        Estado estado = new Estado();
        estado = servico.buscarPorId(id);
        return ResponseEntity.ok().body(estado);
    }

    //SALVAR UMA NOVA CATEGORIA
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Estado> salvar(@Valid @RequestBody EstadoDTO estadoDTO) {
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

        Estado estado = servico.converterParaEstado(estadoDTO);
        servico.salvar(estado);
        URI uriBuscaNovoDadoInserido = ServletUriComponentsBuilder
                .fromCurrentRequestUri()
                .path("/{id}")
                .buildAndExpand(estado.getId()).toUri();
        return ResponseEntity.created(uriBuscaNovoDadoInserido).build();

    }

    //ATUALIZAR UMA CATEGORIA
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> atualizar(@Valid @RequestBody EstadoDTO estadoDTO, @PathVariable Long id) {
        Estado estado = servico.converterParaEstado(estadoDTO);
        estado.setId(id);
        servico.atualizar(estado);
        //https://www.w3.org/Protocols/rfc2616/rfc2616-sec10.html#sec10
        return ResponseEntity.noContent().build();

    }


}
