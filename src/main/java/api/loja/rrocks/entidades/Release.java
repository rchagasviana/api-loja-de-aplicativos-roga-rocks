package api.loja.rrocks.entidades;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;

@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "tb_release")
public class Release implements Serializable {
    private static final long serialVersionUID = 7237653720731301917L;

    //ATRIBUTOS BÁSICOS
    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    @Setter
    @Column(length = 500)
    private String nome;

    @Getter
    @Setter
    @Column(nullable = false)
    private Instant dataLancamento;

    @Getter
    @Setter
    @Column(name = "dataEncerramentoRelease")
    private Instant dataTermino;

    @Getter
    @Setter
    @Column(length = 500)
    private String descricao;

    //RELACIONAMENTOS
    @JsonIgnore
    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "aplicativo_id")
    private Aplicativo aplicativo;


    public Release(Long id, String nome, Instant dataLancamento, Instant dataTermino, String descricao, Aplicativo aplicativo) {
        this.id = id;
        this.nome = nome;
        this.dataLancamento = dataLancamento;
        this.dataTermino = dataTermino;
        this.descricao = descricao;
        this.aplicativo = aplicativo;
    }

}
