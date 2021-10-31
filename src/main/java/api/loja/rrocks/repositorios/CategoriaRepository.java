package api.loja.rrocks.repositorios;

import api.loja.rrocks.entidades.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

    @Transactional
    @Modifying
    @Query("UPDATE Categoria c SET c.nome = :nome WHERE id= :id")
    Integer atualizarNome(String nome, Long id);


}
