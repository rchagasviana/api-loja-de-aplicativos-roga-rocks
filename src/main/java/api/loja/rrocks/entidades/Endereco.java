package api.loja.rrocks.entidades;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "tb_endereco")
public class Endereco implements Serializable {
    private static final long serialVersionUID = -6576029616429605591L;

    //ATRIBUTOS BÁSICOS
    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    @Setter
    @Column(length = 100)
    private String logradouro;

    @Getter
    @Setter
    @Column(length = 7)
    private String numero;

    @Getter
    @Setter
    @Column(length = 50)
    private String complemento;

    @Getter
    @Setter
    @Column(length = 50)
    private String bairro;

    @Getter
    @Setter
    @Column(length = 20)
    private String cep;

    //RELACIONAMENTOS
    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "cidade_id", nullable = false)
    private Cidade cidade;

    @JsonIgnore
    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;


    public Endereco(Long id, String logradouro, String numero, String complemento, String bairro, String cep, Cidade cidade, Usuario usuario) {
        this.id = id;
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cep = cep;
        this.cidade = cidade;
        this.usuario = usuario;
    }


}
