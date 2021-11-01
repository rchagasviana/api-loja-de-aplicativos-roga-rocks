package api.loja.rrocks.entidades;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;


@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "tb_categoria")
public class Categoria implements Serializable {
    private static final long serialVersionUID = -1203976754595126432L;

    //ATRIBUTOS BÁSICOS
    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    @Setter
    @Column(length = 100, nullable = false)
    private String nome;

    @Getter
    @Setter
    @Column(nullable = false)
    private Instant dataDeCriacao;

    //RELACIONAMENTOS

    @Getter
    @OneToMany(mappedBy = "categoria")
    private List<Aplicativo> aplicativos = new ArrayList<>();


    public Categoria(Long id, String nome, Instant dataDeCriacao) {
        this.id = id;
        this.nome = nome;
        this.dataDeCriacao = dataDeCriacao;
    }
}
