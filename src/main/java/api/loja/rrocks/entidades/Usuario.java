package api.loja.rrocks.entidades;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@EqualsAndHashCode
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Entity
public abstract class Usuario implements Serializable {
    private static final long serialVersionUID = 2995162596171271014L;

    //ATRIBUTOS BÁSICOS
    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Getter
    @Setter
    @Column(length = 50, nullable = false)
    private String nome;

    //RELACIONAMENTOS
    @JsonIgnore
    @Getter
    @OneToMany(mappedBy = "usuario")
    private List<Endereco> enderecos = new ArrayList<>();

    /*
     * -Cada ocorrência de Usuário pode ter somente uma ocorrência de ContatoRepository.
     * -A Entidade ContatoRepository representa uma entidade fraca, portanto, a sua chave estrangeira também é chave primária.
     * Isso porque, nesta regra de negócio, não faz sentido existir um registro de ContatoRepository sem um Usuário associado
     *
     *  */
    @JsonIgnore
    @Getter
    @Setter
    @OneToOne(cascade = CascadeType.ALL) //neste caso não se usa mappedBy = "usuario"
    @PrimaryKeyJoinColumn
    private Contato contato;

    public Usuario(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }
}
