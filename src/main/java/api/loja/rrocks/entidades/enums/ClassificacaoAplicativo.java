package api.loja.rrocks.entidades.enums;

import lombok.Getter;

public enum ClassificacaoAplicativo {
    /*
    * Esta implementação foi escolhido para evitar que caso uma nova classificação seja adicionada
    * não afete os registros já existentes na base de dados e cause alguma inconsistência, tendo em vista
    * que valores atribuídos automaticamente seguem a ordem de declaração dos valores.
    * */

    CLASSIFICACAO_LIVRE(0, "LIVRE (L)"),
    NAO_RECOMENDADA_MENORES_10_ANOS(1, "Não recomendado para menores de 10 (dez) anos"),
    NAO_RECOMENDADA_MENORES_12_ANOS(2, "Não recomendado para menores de 12 (dez) anos"),
    NAO_RECOMENDADA_MENORES_14_ANOS(3, "Não recomendado para menores de 14 (dez) anos"),
    NAO_RECOMENDADA_MENORES_16_ANOS(4, "Não recomendado para menores de 16 (dez) anos"),
    NAO_RECOMENDADA_MENORES_18_ANOS(5, "Não recomendado para menores de 18 (dez) anos");

    @Getter
    private Integer codigo;

    @Getter
    private String descricao;

    private ClassificacaoAplicativo(Integer codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public static ClassificacaoAplicativo coverterParaEnum(Integer codigo) {
        if (codigo == null) {
            return null;
        }
        for (ClassificacaoAplicativo valor : ClassificacaoAplicativo.values()) {
            if (valor.getCodigo() == codigo) {
                return valor;
            }
        }
        //Caso seja informado algum código diferente dos definidos acima
        throw new IllegalArgumentException("Código Inválido");
    }
}
