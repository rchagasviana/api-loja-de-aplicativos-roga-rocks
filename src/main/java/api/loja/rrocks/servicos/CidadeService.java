package api.loja.rrocks.servicos;

import api.loja.rrocks.dto.CidadeDTO;
import api.loja.rrocks.entidades.Cidade;
import api.loja.rrocks.entidades.Estado;
import api.loja.rrocks.repositorios.CidadeRepository;
import api.loja.rrocks.repositorios.EstadoRepository;
import api.loja.rrocks.servicos.excecoes.ObjetoNaoEncontradoException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class CidadeService {

    @Autowired
    private CidadeRepository repositorio;

    @Autowired
    private EstadoRepository repositorioEstado;


    //BUSCAR TODOS AS CIDADE
    public List<Cidade> buscarTodos() {
        return repositorio.findAll();
    }

    //BUSCAR POR ID
    public Cidade buscarPorId(Long id) {
        Optional<Cidade> cidade = repositorio.findById(id);
        return cidade.orElseThrow(
                () -> new ObjetoNaoEncontradoException("registro de Id igual a " + id + " não encontrado!!")
        );
    }

    //SALVAR UM CIDADE
    @Transactional
    public Cidade salvar(Cidade cidade) {
       // cidade.setId(null);
        return repositorio.save(cidade);
    }

    /*
    * Observação: Toda cidade precisa estar associada a um resgitro de Estado, logo este método recebe o
    * objeto padrão montado com os dados para inserir uma cidade junto com o código do estado referente.
    * Logo em seguida monta os objetos de cidade com os dados do "nome" e o Estado após buscar a referência
    * correspondente ao Id do estado informado. Após isso, o Controlador de Cidade recebe o objeto montado
    * e o envia para o método salvar dentro da desta classe e fluxo segue.
    *
    * */
    public Cidade fromDTO(CidadeDTO cidadeDTO) {
        Estado estado = new Estado();
        estado = repositorioEstado.getById(cidadeDTO.getEstado());
        Cidade cidade = new Cidade(null, cidadeDTO.getNome(), estado);
        return cidade;
    }

    //ATUALIZAR UM CIDADE
    public Integer atualizar(Cidade cidade) {
        buscarPorId(cidade.getId());
        return repositorio.atualizarNome(cidade.getNome(), cidade.getId());
    }

    public Cidade converterParaCidade(CidadeDTO cidadeDTO) {
        return new ModelMapper().map(cidadeDTO, Cidade.class);
    }

}
