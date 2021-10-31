package api.loja.rrocks.controladores;


import api.loja.rrocks.dto.CidadeDTO;
import api.loja.rrocks.dto.CidadeRespostaDTO;
import api.loja.rrocks.entidades.Cidade;
import api.loja.rrocks.servicos.CidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/cidades")
public class CidadeController {

    @Autowired
    private CidadeService servico;

    //RECUPERAR TODOS OS CIDADES
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<CidadeRespostaDTO>> buscarTodos() {
        //Recebe a lista do tipo Cidade
        List<Cidade> listaDeCidades = servico.buscarTodos();
        //Converter para o tipo CidadeRepostaDTO
        List<CidadeRespostaDTO> listaCidadeDTO = CidadeRespostaDTO.converterParaListaCidadeDTO(listaDeCidades);
        return ResponseEntity.ok().body(listaCidadeDTO);
    }

    //RECUPERAR CIDADE POR ID
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> buscarPorId(@PathVariable Long id) {
        Cidade cidade = new Cidade();
        cidade = servico.buscarPorId(id);
        return ResponseEntity.ok().body(cidade);
    }

    //SALVAR UMA NOVA CIDADE
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Cidade> salvar(@Valid @RequestBody CidadeDTO cidadeDTO) {
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

        Cidade cidade = servico.fromDTO(cidadeDTO);

        servico.salvar(cidade);
        URI uriBuscaNovoDadoInserido = ServletUriComponentsBuilder
                .fromCurrentRequestUri()
                .path("/{id}")
                .buildAndExpand(cidade.getId()).toUri();
        return ResponseEntity.created(uriBuscaNovoDadoInserido).build();

    }

    //ATUALIZAR UMA CIDADE
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> atualizar(@Valid @RequestBody CidadeDTO cidadeDTO, @PathVariable Long id) {
        Cidade cidade = servico.converterParaCidade(cidadeDTO);
        cidade.setId(id);
        servico.atualizar(cidade);
        //https://www.w3.org/Protocols/rfc2616/rfc2616-sec10.html#sec10
        return ResponseEntity.noContent().build();

    }


}
