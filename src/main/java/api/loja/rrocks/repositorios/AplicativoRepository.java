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

    Optional<Aplicativo> findByNome(String nome);

    Optional<Aplicativo> findByNomeAndCategoria(String nome, Categoria categoria);


    //SELECT a FROM Aplicativo a WHERE a.preco = (SELECT MIN(a.preco) FROM a) -> buscar produto por menor preço
    //"SELECT a FROM Aplicativo a WHERE a.categoria= :categoria" -> buscar por categoria
    //SELECT a FROM Aplicativo a WHERE a.preco = (SELECT MIN(a.preco) FROM a WHERE a.categoria= :categoria)

    @Query("SELECT a FROM Aplicativo a WHERE a.preco = (SELECT MIN(a.preco) FROM a WHERE a.categoria= :categoria)")
    Optional<Aplicativo> buscarAplicativoBaratoPorTipo(@Param(value = "categoria") Categoria categoria);


}
