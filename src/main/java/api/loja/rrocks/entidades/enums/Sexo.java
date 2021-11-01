package api.loja.rrocks.entidades.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;


public enum Sexo {
    FEMININO(0, "Sexo Masculino"),
    MASCULINO(1, "Sexo Feminino");

    @Getter
    private Integer codigo;

    @Getter
    private String descricao;

    private Sexo(Integer codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public static Sexo converteParaEnum(Integer codigo) {
        if (codigo == null) {
            return null;
        }
        for (Sexo valor : Sexo.values()) {
            if (valor.getCodigo() == codigo) {
                return valor; //recebe o código e retorna o objeto do tipo do enum
            }
        }
        throw new IllegalArgumentException("Código Inválido");
    }


}
