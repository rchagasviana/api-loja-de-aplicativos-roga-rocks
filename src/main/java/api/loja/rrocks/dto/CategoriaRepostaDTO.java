package api.loja.rrocks.dto;


import api.loja.rrocks.entidades.Categoria;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.modelmapper.ModelMapper;
import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

/*
 * Para efeito de estudo ressalta-se que o Padrão DTO (Data Transfer Object)
 * é utilizado, como o nome sugere, para transferência de dados. Tal padrão permite que o programador
 * escolha quais dados devem ser trafegados e a ordem que podem ser apresentados.
 *
 * Utilizada apenas para consulta
 *  */

@JsonPropertyOrder({"nome", "id"})
@Getter
@Setter
@NoArgsConstructor
public class CategoriaRepostaDTO implements Serializable {
    private static final long serialVersionUID = 7101007895821351138L;

    @JsonProperty
    private Long id;

    @JsonProperty
    private String nome;

    public static CategoriaRepostaDTO converterParaCategoriaDTO(Categoria categoria) {
        return new ModelMapper().map(categoria, CategoriaRepostaDTO.class);

    }

    public static List<CategoriaRepostaDTO> converterParaListaCategoriaDTO(List<Categoria> listaDeCategoria) {
        List<CategoriaRepostaDTO> listaCategoriaDTO = listaDeCategoria
                .stream()
                .map(categoria -> new ModelMapper().map(categoria, CategoriaRepostaDTO.class))
                .collect(Collectors.toList());
        return listaCategoriaDTO;
    }


}
