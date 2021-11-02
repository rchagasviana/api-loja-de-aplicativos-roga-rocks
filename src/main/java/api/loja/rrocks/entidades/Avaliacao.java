package api.loja.rrocks.entidades;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
@Table(name = "tb_avaliacao")
public class Avaliacao implements Serializable {
    private static final long serialVersionUID = -6995701512149967584L;

    //ATRIBUTOS BÁSICOS
    @JsonIgnore
    @Getter
    @Setter
    @EmbeddedId
    private AvaliacaoPK id = new AvaliacaoPK();

    //ATRIBUTOS DO RELACIONAMENTO
    @Getter
    @Setter
    @Column(length = 500)
    private String comentario;


    public Avaliacao(Aplicativo aplicativo, Usuario consumidor, String comentario) {
        this.id = id;
        id.setAplicativo(aplicativo);
        id.setConsumidor(consumidor);
        this.comentario = comentario;
    }


    @JsonIgnore
    public Aplicativo getAplicativo() {
        return id.getAplicativo();
    }

    @JsonIgnore
    public Usuario getUsuario() {
        return id.getConsumidor();
    }


}
