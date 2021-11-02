package api.loja.rrocks.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@NoArgsConstructor
@Getter
@Setter
public class AplicativoSalvarDTO implements Serializable {
    private static final long serialVersionUID = 3968631205962155825L;

    //DADOS DO APLICATIVO
    private Long id;

    @NotEmpty(message = "Preenchimento obrigatório")
    @Length(min = 2, max = 30, message = "O nome do aplicativo precisa ter entre 2 e 30 caracteres.")
    private String nome;

    @NotNull(message = "Informe um preço para seu aplicativo, por favor!")
    private Double preco;

    @NotEmpty(message = "Uma descrição da sua aplicação é necessária.")
    @Length(min = 6, max = 600, message = "O descção do aplicativo precisa ter entre 6 e 600 caracteres.")
    private String descricao;

    /*private Integer statusAplicativo;
     * Sempre que um aplicativo for inserido no sistema
     * seu status será atribuído automaticamente como  EM_DESENVOLVIMENTO (código=1)
     * que significa que é uma aplicação que foi lançada e a equipe continua trabalhando
     * em novas releases.
     * */

    @NotNull(message = "Uma classificação indicativa é obrigatória para sua aplicação.")
    private Integer classificacao;

    //DADOS DAS ENTIDADES RELACIONADAS AO APLICATIVO
    @NotNull(message = "O aplicativo precisa pertencer a uma categoria")
    private Integer categoria;

    @NotNull(message = "O fabricante do aplicativo é obrigatório para medidas legais caso necessário.")
    private Integer fabricante;

    //OBRIGATORIAMENTE UMA RELEASE DEVE SER INFORMADA PARA UM APP INSERIDO
    /*
     * Os parâmetros de data de lanamento e data término não serão informados.
     * Uma vez que serão adicionados em back conforme a data de inserção
     * no sistema e desativação do app.
     * */
    @NotNull(message = "Uma classificação indicativa é obrigatória para sua aplicação.")
    private Integer idRelease;

    @NotEmpty(message = "Informa um nome para sua release")
    @Length(min = 1, max = 30, message = "O nome da Release precisa ter entre 4 e 30 caracteres.")
    private String nomeRelease;

    @NotEmpty(message = "Preenchimento obrigatório")
    @Length(min = 5, max = 500, message = "O nome do Cidade precisa ter entre 4 e 50 caracteres.")
    private String descricaoRelease;

}
