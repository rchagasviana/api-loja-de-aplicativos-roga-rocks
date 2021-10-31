package api.loja.rrocks.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;


@NoArgsConstructor
@Getter
@Setter
public class EstadoDTO implements Serializable {


	private static final long serialVersionUID = 5124151964115710344L;

	private Long id;

    @NotEmpty(message = "Preenchimento obrigatório")
    @Length(min = 4, max = 50, message = "O nome do Estado precisa ter entre 4 e 50 caracteres")
    private String nome;

}
