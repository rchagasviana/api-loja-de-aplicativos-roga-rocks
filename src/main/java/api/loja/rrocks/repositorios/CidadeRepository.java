package api.loja.rrocks.repositorios;


import api.loja.rrocks.entidades.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Long> {
}
