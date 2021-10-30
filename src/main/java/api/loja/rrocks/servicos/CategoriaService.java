package api.loja.rrocks.servicos;

import api.loja.rrocks.entidades.Categoria;
import api.loja.rrocks.repositorios.CategoriaRepository;
import api.loja.rrocks.servicos.excecoes.ObjetoNaoEncontradoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository repositorio;


    public List<Categoria> buscarTodos() {
        return repositorio.findAll();
    }

    public Categoria buscarPorId(Long id) {
        Optional<Categoria> categoria = repositorio.findById(id);
        return categoria.orElseThrow(
                () -> new ObjetoNaoEncontradoException("registro de Id igual a " + id + " não encontrado!!")
        );
    }


}
