package api.loja.rrocks.repositorios;

import api.loja.rrocks.entidades.Estado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Long> {


    @Transactional
    @Modifying
    @Query("UPDATE Estado c SET c.nome = :nome WHERE id= :id")
    Integer atualizarNome(String nome, Long id);
}
