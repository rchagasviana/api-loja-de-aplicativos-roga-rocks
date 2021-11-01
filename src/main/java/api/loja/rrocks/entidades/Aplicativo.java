package api.loja.rrocks.entidades;


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

    @Getter
    @Setter
    @Column(nullable = false)
    private String statusAplicativo; //transformar em um enum

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
    private Fabricante fabricante;

    @Getter
    @OneToMany(mappedBy = "aplicativo")
    private List<Release> releases = new ArrayList<>();

    @Getter
    @OneToMany(mappedBy = "aplicativo")
    private List<Avaliacao> avaliacoes = new ArrayList<>();


}
