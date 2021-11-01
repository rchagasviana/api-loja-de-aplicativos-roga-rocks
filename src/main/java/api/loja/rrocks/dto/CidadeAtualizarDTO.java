package api.loja.rrocks.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;


/*
* Este DTO é destinado para atualização de novos dados de uma Cidade.
* */
@NoArgsConstructor
@Getter
@Setter
public class CidadeAtualizarDTO implements Serializable {
	private static final long serialVersionUID = -5242365729814566264L;


	private Long id;

    private String nome;

	private Long estado;

}
