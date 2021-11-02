package api.loja.rrocks.repositorios;

import api.loja.rrocks.entidades.Aplicativo;
import api.loja.rrocks.entidades.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public interface AplicativoRepository extends JpaRepository<Aplicativo, Long> {


   /* @Modifying
    @Query("SELECT a.id , a.nome, a.preco, a.categoria FROM Aplicativo a WHERE a.nome =: nome AND a.categoria = :categoria")
    @Transactional
    List<Aplicativo> buscarPorNomeCategoria(
            @Param(value = "nome") String nome,
            @Param(value = "categoria") Long categoria
    );*/

    Optional<Aplicativo> findByNomeAndCategoria(String nome, Categoria categoria);
    Optional<Aplicativo> findByNome(String nome);


}
