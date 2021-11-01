package api.loja.rrocks.entidades;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.io.Serializable;


@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "tb_contato")
public class Contato implements Serializable {
    private static final long serialVersionUID = -4780764383051859825L;

    //ATRIBUTOS BÁSICOS
    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Getter
    @Setter
    @Column(length = 100, nullable = false, unique = true)
    private String email;

    @Getter
    @Setter
    @Column(length = 15, nullable = false, unique = true)
    private String telefone;

    //RELACIONAMENTOS
    @Transient //Esta coluna  representa a chave estrangeira que também será chave primária, logo não deverá se persistida e sim mapeada para o atributo Id.
    @Getter
    @Setter
    @OneToOne
    @MapsId
    @JoinColumn(name = "id")
    private Usuario usuario;

    public Contato(Long id, String email, String telefone, Usuario usuario) {
        this.id = id;
        this.email = email;
        this.telefone = telefone;
        this.usuario = usuario;
    }
}
