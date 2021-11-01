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
    @OneToOne
    @MapsId
    @JoinColumn(name = "id")
    private Usuario usuario;


}
