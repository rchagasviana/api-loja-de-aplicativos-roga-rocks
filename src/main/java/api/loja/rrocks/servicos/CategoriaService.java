package api.loja.rrocks.servicos;

import api.loja.rrocks.dto.CategoriaDTO;
import api.loja.rrocks.entidades.Categoria;
import api.loja.rrocks.repositorios.CategoriaRepository;
import api.loja.rrocks.servicos.excecoes.ObjetoNaoEncontradoException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
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

    public Categoria salvar(Categoria categoria) {
        //Para inserção de uma nova categoria, o Id tem que ser nulo, caso contrário trata-se de uma atualização
        categoria.setId(null); //garante que se trata de um noto registro que está sendo inserido
        categoria.setDataDeCriacao(Instant.now());//Atribui o data do momento que está sendo salvo
        return repositorio.save(categoria);
    }

    //Este método serve para auxiliar na conversão de uma CategoriaDTO para uma Categoria
    public Categoria converterParaCategoria(CategoriaDTO categoriaDTO) {
        return new ModelMapper().map(categoriaDTO, Categoria.class);
    }


}
