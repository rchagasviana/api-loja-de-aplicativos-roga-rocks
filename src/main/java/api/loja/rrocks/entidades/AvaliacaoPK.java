package api.loja.rrocks.entidades;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@NoArgsConstructor
@EqualsAndHashCode
@Embeddable
public class AvaliacaoPK implements Serializable {

    @Getter
    @Setter
    @Column(name = "aplicativo_id")
    private Long IdAplicativo;

    @Getter
    @Setter
    @Column(name = "consumidor_id")
    private Long IdConsumidor;
}
