package api.loja.rrocks.repositorios;


import api.loja.rrocks.entidades.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Long> {


    @Transactional
    @Modifying
    @Query("UPDATE Cidade c SET c.nome = :nome WHERE id= :id")
    Integer atualizarNome(String nome, Long id);
}
