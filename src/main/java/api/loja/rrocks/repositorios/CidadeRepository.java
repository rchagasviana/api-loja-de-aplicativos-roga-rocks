package api.loja.rrocks.repositorios;


import api.loja.rrocks.entidades.Cidade;
import api.loja.rrocks.entidades.Estado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Long> {


    @Modifying
    @Query("UPDATE Cidade c SET c.nome = :nome WHERE id= :codigoCidade")
    @Transactional
    Integer atualizarNome(
            @Param(value = "nome") String nome,
            @Param(value = "codigoCidade") Long codigoCidade
    );

    @Modifying
    @Query("UPDATE Cidade c SET c.estado = :codigoEstado WHERE id= :codigoCidade")
    @Transactional
    Integer atualizarEstado(
            @Param(value = "codigoEstado") Estado codigoEstado,
            @Param(value = "codigoCidade") Long codigoCidade
    );


    @Modifying
    @Query("UPDATE Cidade c SET c.nome = :nome, c.estado = :codigoEstado WHERE id= :codigoCidade")
    @Transactional
    Integer atualizarNomeECodigoEstado(
            @Param(value = "nome") String nome,
            @Param(value = "codigoEstado") Estado codigoEstado,
            @Param(value = "codigoCidade") Long codigoCidade
    );

}
