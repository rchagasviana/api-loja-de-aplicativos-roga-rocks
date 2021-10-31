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
@Entity
@Table(name = "tb_estado")
public class Estado implements Serializable {
    private static final long serialVersionUID = -8738025770839195089L;

    //ATRIBUTOS BÁSICOS
    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    @Setter
    @Column(length = 50, nullable = false)
    private String nome;

    //RELACIONAMENTOS
    @JsonIgnore
    @Getter
    @OneToMany(mappedBy = "estado")
    private List<Cidade> cidades = new ArrayList<>();


    public Estado(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }
}
