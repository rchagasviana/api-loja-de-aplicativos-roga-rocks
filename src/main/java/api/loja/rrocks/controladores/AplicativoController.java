package api.loja.rrocks.controladores;

import api.loja.rrocks.dto.AplicativoRespostaDTO;
import api.loja.rrocks.entidades.Aplicativo;
import api.loja.rrocks.servicos.AplicativoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/aplicativos")
public class AplicativoController {

    @Autowired
    private AplicativoService servico;


    //LISTAR TODOS OS APLICATIVOS
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<AplicativoRespostaDTO>> buscarTodos() {
        List<Aplicativo> listaDeAplicativo = servico.buscarTodos();
        //Converter para o padrão de resposta
        List<AplicativoRespostaDTO> listaAplicativoDTO = AplicativoRespostaDTO.converterParaListaAplicativoDTO(listaDeAplicativo);
        return ResponseEntity.ok().body(listaAplicativoDTO);
    }

    //LISTAR TODOS OS APLICATIVOS
   /* @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Aplicativo>> buscarTodos() {
        List<Aplicativo> listaDeAplicativo = servico.buscarTodos();
        return ResponseEntity.ok().body(listaDeAplicativo);
    }*/

}
