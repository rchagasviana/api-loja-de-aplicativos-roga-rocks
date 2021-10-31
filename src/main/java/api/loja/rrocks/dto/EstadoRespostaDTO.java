package api.loja.rrocks.dto;

import api.loja.rrocks.entidades.Categoria;
import api.loja.rrocks.entidades.Cidade;
import api.loja.rrocks.entidades.Estado;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.modelmapper.ModelMapper;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@JsonPropertyOrder({"id", "nome"})
@Getter
@Setter
@NoArgsConstructor
public class EstadoRespostaDTO implements Serializable {

   
	private static final long serialVersionUID = -6521701419273940662L;


	@JsonProperty
    private Long id;


    @JsonProperty
    private String nome;

   // @JsonProperty
    //private List<Cidade> cidades = new ArrayList<>();

    public static EstadoRespostaDTO converterParaEstadoDTO(Estado estado) {
        return new ModelMapper().map(estado, EstadoRespostaDTO.class);

    }


    public static List<EstadoRespostaDTO> converterParaListaEstadoDTO(List<Estado> listaDeEstado) {
        List<EstadoRespostaDTO> listaEstadoDTO = listaDeEstado
                .stream()
                .map(estado -> new ModelMapper().map(estado, EstadoRespostaDTO.class))
                .collect(Collectors.toList());
        return listaEstadoDTO;
    }


}
