package api.loja.rrocks.dto;



import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.time.Instant;

@NoArgsConstructor
@Getter
@Setter
public class CategoriaDTO implements Serializable {
    private static final long serialVersionUID = -6630311160662577482L;

    private Long id;

    @NotEmpty(message = "Preenchimento obrigatório")
    @Length(min = 3, max = 100, message = "O nome da Categoria precisa ter entre 3 e 100 caracteres")
    private String nome;

    private Instant dataDeCriacao;

}
