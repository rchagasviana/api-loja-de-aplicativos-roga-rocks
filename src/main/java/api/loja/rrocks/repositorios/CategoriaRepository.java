package api.loja.rrocks.repositorios;

import api.loja.rrocks.entidades.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository  extends JpaRepository<Categoria, Long> {
}
