package api.loja.rrocks.entidades;


import api.loja.rrocks.entidades.enums.ClassificacaoAplicativo;
import api.loja.rrocks.entidades.enums.StatusAplicativo;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "tb_aplicativo")
public class Aplicativo implements Serializable {
    private static final long serialVersionUID = 6864653223844672751L;

    //ATRIBUTOS BÁSICOS
    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    @Setter
    @Column(nullable = false)
    private String nome;

    @Getter
    @Setter
    @Column(nullable = false)
    private Double preco;

    @Getter
    @Setter
    @Column(nullable = false)
    private String descricao;


    @Column(nullable = false)
    private Integer statusAplicativo;

    @Column(nullable = false)
    private Integer classificacao;

    //RELACIONAMENTOS
    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "fabricante_id")
    private Usuario fabricante;

    @Getter
    @OneToMany(mappedBy = "aplicativo")
    private List<Release> releases = new ArrayList<>();

    @Getter
    @Setter
    @OneToMany(mappedBy = "id.aplicativo")
    /*
     * A implementação com o conjuntos doi modificada porque assim, sempre que um novo comentário
     * for inserido pelomesmo usuário para o mesmo aplicativo, ele irá sobrescreverá o anterior
     * (lembrar de ignorar os hashCode, toString e coleções quando for usar conjunto)
     * */
    //private Set<Avaliacao> avaliacoes = new HashSet<>();
    private List<Avaliacao> avaliacoes = new ArrayList<>();


    public Aplicativo(Long id,
                      String nome,
                      Double preco,
                      String descricao,
                      ClassificacaoAplicativo classificacao,
                      StatusAplicativo statusAplicativo,
                      Categoria categoria,
                      Usuario fabricante) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.descricao = descricao;
        this.classificacao = classificacao.getCodigo();
        this.statusAplicativo = statusAplicativo.getCodigo();
        this.categoria = categoria;
        this.fabricante = fabricante;
    }

    public StatusAplicativo getStatusAplicativo() {
        return StatusAplicativo.converteParaEnum(statusAplicativo);
    }

    public void setStatusAplicativo(StatusAplicativo statusAplicativo) {
        this.statusAplicativo = statusAplicativo.getCodigo();
    }

    public ClassificacaoAplicativo getClassificacao() {
        return ClassificacaoAplicativo.coverterParaEnum(classificacao);
    }

    public void setClassificacao(ClassificacaoAplicativo classificacao) {
        this.classificacao = classificacao.getCodigo();
    }


}
