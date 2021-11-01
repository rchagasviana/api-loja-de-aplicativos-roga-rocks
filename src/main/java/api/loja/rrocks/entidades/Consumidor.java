package api.loja.rrocks.entidades;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;


@NoArgsConstructor
@Entity
@Table(name = "tb_consumidor")
public class Consumidor extends Usuario {
	private static final long serialVersionUID = -3967675967983837044L;

	@Getter
    @Setter
    @Column(nullable = false)
    private Instant dataNascimento;

    @Getter
    @Setter
    @Column(nullable = false)
    private String sexo; //transformar em um enum depois

    //RELACIONAMENTOS
    @Getter
    @Setter
    @Column(length = 50)
    private String profissao;

    @Getter
    @OneToMany(mappedBy = "consumidor")
    private List<Avaliacao> avaliacoes = new ArrayList<>();

    public Consumidor(Long id, String nome, Instant dataNascimento, String sexo, String profissao) {
        super(id, nome);
        this.dataNascimento = dataNascimento;
        this.sexo = sexo;
        this.profissao = profissao;
    }
}
