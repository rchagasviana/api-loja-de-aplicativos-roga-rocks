package api.loja.rrocks.entidades.enums;

import lombok.Getter;

public enum StatusAplicativo {

    EM_DESENVOLVIMENTO(1, "Em desenvolvimento"),
    DESCONTINUADO(2, "Descontinuado");

    @Getter
    private Integer codigo;
    
    @Getter
    private String descricao;

    private StatusAplicativo(Integer codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public static StatusAplicativo converteParaEnum(Integer codigo) {
        if (codigo == null) {
            return null;
        }
        for (StatusAplicativo valor : StatusAplicativo.values()) {
            if (valor.getCodigo() == codigo) {
                return valor; //recebe o código e retorna o objeto do tipo do enum
            }
        }
        throw new IllegalArgumentException("Código Inválido");
    }
}
