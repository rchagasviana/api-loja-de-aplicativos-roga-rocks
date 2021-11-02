package api.loja.rrocks.entidades;

import api.loja.rrocks.entidades.enums.Sexo;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;


@NoArgsConstructor
@Entity
@Table(name = "tb_consumidor")
public class Consumidor extends Usuario {
    private static final long serialVersionUID = -3967675967983837044L;

    @Getter
    @Setter
    @Column(nullable = false)
    private Instant dataNascimento;


    @Column(nullable = false)
    private Integer sexo; //transformar em um enum depois

    //RELACIONAMENTOS
    @Getter
    @Setter
    @Column(length = 50)
    private String profissao;


    @Getter
    @Setter
    @OneToMany(mappedBy = "id.consumidor")//obs: A referência é pra Classe Id da Classe Avaliação que contém o mapeamento das chaves compostas
    //Cada consumidor só poderá fazer um comentário e após isso somente reavaliar.
    // Dessa forma a valiação fica mais fidedigna, uma vez que cada app sofrerá atualizações com o tempo
    private Set<Avaliacao> avaliacoes = new HashSet<>();

    public Consumidor(Long id, String nome, Instant dataNascimento, Sexo sexo, String profissao) {
        super(id, nome);
        this.dataNascimento = dataNascimento;
        this.sexo = sexo.getCodigo();
        this.profissao = profissao;
    }

    public Sexo getSexo() {
        return Sexo.converteParaEnum(sexo);
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo.getCodigo();
    }
}
