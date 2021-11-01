package api.loja.rrocks.entidades;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;


@NoArgsConstructor
@Entity
@Table(name = "tb_fabricante")
public class Fabricante extends Usuario {
    private static final long serialVersionUID = 1361464332427755555L;

    //ATRIBUTOS BÁSICOS
    @Getter
    @Setter
    @Column(nullable = false)
    private Instant dataFundacao;

    //RELACIONAMENTOS
    @OneToMany(mappedBy = "fabricante")
    private List<Aplicativo> aplicativos = new ArrayList<>();


    public Fabricante(Long id, String nome, Instant dataFundacao) {
        super(id, nome);
        this.dataFundacao = dataFundacao;
    }
}
