package api.loja.rrocks.repositorios;

import api.loja.rrocks.entidades.Aplicativo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AplicativoRepository extends JpaRepository<Aplicativo, Long> {
}
