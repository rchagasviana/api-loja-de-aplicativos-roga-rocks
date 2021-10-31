package api.loja.rrocks.dto;

import api.loja.rrocks.entidades.Cidade;
import api.loja.rrocks.entidades.Estado;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.modelmapper.ModelMapper;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;


@JsonPropertyOrder({"id", "nome", "estado"})
@Getter
@Setter
@NoArgsConstructor
public class CidadeRespostaDTO implements Serializable {

    
	private static final long serialVersionUID = -6380093920681019994L;

	@JsonProperty
    private Long id;

    @JsonProperty
    private String nome;

    @JsonProperty
    private Estado estado;

    public static CidadeRespostaDTO converterParaCidadeDTO(Cidade cidade) {
        return new ModelMapper().map(cidade, CidadeRespostaDTO.class);

    }

    public static List<CidadeRespostaDTO> converterParaListaCidadeDTO(List<Cidade> listaDeCidade) {
        List<CidadeRespostaDTO> listaCidadeDTO = listaDeCidade
                .stream()
                .map(cidade -> new ModelMapper().map(cidade, CidadeRespostaDTO.class))
                .collect(Collectors.toList());
        return listaCidadeDTO;
    }


}
