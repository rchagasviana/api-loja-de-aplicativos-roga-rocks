package api.loja.rrocks.controladores;


import api.loja.rrocks.dto.CategoriaDTO;
import api.loja.rrocks.entidades.Categoria;
import api.loja.rrocks.servicos.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService servico;

    //Pode ser utilizado também o -> @GetMapping
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<CategoriaDTO>> buscarTodos() {
        //Recebe a lista do tipo Categoria
        List<Categoria> listaDeCategorias = servico.buscarTodos();
        //Converter para o tipo CategoriaDTO
        List<CategoriaDTO> listaCategoriaDTO = CategoriaDTO.converterParaListaVendaDTO(listaDeCategorias);
        return ResponseEntity.ok().body(listaCategoriaDTO);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> buscarPorId(@PathVariable Long id) {
        Categoria categoria = new Categoria();
        categoria = servico.buscarPorId(id);
        return ResponseEntity.ok().body(categoria);
    }


}
