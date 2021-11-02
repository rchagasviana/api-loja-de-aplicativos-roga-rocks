package api.loja.rrocks.entidades;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@EqualsAndHashCode
@Embeddable
public class AvaliacaoPK implements Serializable {
	private static final long serialVersionUID = 7688595492118877882L;

	@Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "aplicativo_id")
    private Aplicativo aplicativo;

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "consumidor_id")
    private Usuario consumidor;


}
