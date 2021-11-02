package api.loja.rrocks.dto;


import api.loja.rrocks.entidades.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.modelmapper.ModelMapper;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


@JsonPropertyOrder({"id", "nome", "preco", "releases", "categoria", "fabricante", "avaliacoes"})
@Getter
@Setter
@NoArgsConstructor
public class AplicativoRespostaDTO implements Serializable {

    @JsonProperty
    private Long id;

    @JsonProperty
    private String nome;

    @JsonProperty
    private Double preco;

    @JsonProperty
    private List<Release> releases = new ArrayList<>();

    @JsonProperty
    private Categoria categoria;

    @JsonProperty
    private Usuario fabricante;

    @JsonProperty
    private Set<Avaliacao> avaliacoes = new HashSet<>();


    public static AplicativoRespostaDTO converterParaCategoriaDTO(Aplicativo aplicativo) {
        return new ModelMapper().map(aplicativo, AplicativoRespostaDTO.class);
    }

    public static List<AplicativoRespostaDTO> converterParaListaAplicativoDTO(List<Aplicativo> listaDeAplicativo) {
        List<AplicativoRespostaDTO> listaAplicativoDTO = listaDeAplicativo
                .stream()
                .map(aplicativo -> new ModelMapper().map(aplicativo, AplicativoRespostaDTO.class))
                .collect(Collectors.toList());
        return listaAplicativoDTO;
    }


}
