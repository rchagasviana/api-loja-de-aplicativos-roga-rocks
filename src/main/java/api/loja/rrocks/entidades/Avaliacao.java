package api.loja.rrocks.entidades;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "tb_avaliacao")
public class Avaliacao implements Serializable {

    //ATRIBUTOS BÁSICOS
    @Getter
    @Setter
    @EmbeddedId
    private AvaliacaoPK id;

    @Getter
    @Setter
    @ManyToOne
    @MapsId("IdAplicativo")
    @JoinColumn(name = "aplicativo_id")
    private Aplicativo aplicativo;

    @Getter
    @Setter
    @ManyToOne
    @MapsId("IdConsumidor")
    @JoinColumn(name = "consumidor_id")
    private Consumidor consumidor;

    //ATRIBUTOS DO RELACIONAMENTO
    @Getter
    @Setter
    private String comentario;


}
