package api.loja.rrocks.dto;



import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;


/*
* Este DTO é destinado para inserção de novos dados de uma Cidade.
* */
@NoArgsConstructor
@Getter
@Setter
public class CidadeSalvarDTO implements Serializable {

	private static final long serialVersionUID = -8038088900583207407L;

	private Long id;

	@NotEmpty(message = "Preenchimento obrigatório")
	@Length(min = 4, max = 100, message = "O nome do Cidade precisa ter entre 4 e 50 caracteres.")
    private String nome;

	@NotNull(message = "Uma cidade precisa estar associada a um Estado. Preenchimento obrigatório.")
    private Long estado;

}
