package api.loja.rrocks.servicos;

import api.loja.rrocks.dto.CategoriaDTO;
import api.loja.rrocks.dto.EstadoDTO;
import api.loja.rrocks.entidades.Categoria;
import api.loja.rrocks.entidades.Estado;
import api.loja.rrocks.repositorios.EstadoRepository;
import api.loja.rrocks.servicos.excecoes.ObjetoNaoEncontradoException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Service
public class EstadoService {

    @Autowired
    private EstadoRepository repositorio;

    //BUSCAR TODOS AS ESTADOS
    public List<Estado> buscarTodos() {
        return repositorio.findAll();
    }

    //BUSCAR POR ID
    public Estado buscarPorId(Long id) {
        Optional<Estado> estado = repositorio.findById(id);
        return estado.orElseThrow(
                () -> new ObjetoNaoEncontradoException("registro de Id igual a " + id + " não encontrado!!")
        );
    }

    //SALVAR UM ESTADO
    public Estado salvar(Estado estado) {
        estado.setId(null);
        return repositorio.save(estado);
    }

    //ATUALIZAR UM ESTADO
    public Integer atualizar(Estado estado) {
        buscarPorId(estado.getId());
        return repositorio.atualizarNome(estado.getNome(),estado.getId());
    }

    public Estado converterParaEstado(EstadoDTO estadoDTO) {
        return new ModelMapper().map(estadoDTO, Estado.class);
    }

}
