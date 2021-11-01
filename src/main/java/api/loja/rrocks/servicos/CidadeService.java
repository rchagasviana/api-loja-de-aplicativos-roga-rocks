package api.loja.rrocks.servicos;

import api.loja.rrocks.dto.CidadeAtualizarDTO;
import api.loja.rrocks.dto.CidadeSalvarDTO;
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
    public Cidade fromDTOSalvar(CidadeSalvarDTO cidadeSalvarDTO) {
        Estado estado = new Estado();
        estado = repositorioEstado.getById(cidadeSalvarDTO.getEstado());
        Cidade cidade = new Cidade(null, cidadeSalvarDTO.getNome(), estado);
        return cidade;
    }

    //ATUALIZAR UMA CIDADE
    /*
     * Há três possibilidades para atualização de um registro de Cidade:
     * 1)Somente o nome. Neste caso, o IdEstado deverá ser nulo.
     * 2)Somente o idEstado. Neste caso, o nome da cidade deverá ser nulo.
     * 3)Ou atualizar o nome da cidade e o estado a qual ela está associado
     * */
    public Integer atualizar(Cidade cidade) {
        Estado estado = new Estado();

        //Verificar se somente o Nome da cidade está sendo passada
        if (cidade.getEstado().getId() == null && !cidade.getNome().isEmpty()) {

            return repositorio.atualizarNome(cidade.getNome(), cidade.getId());

            //Verifica se somente o código do estado deve ser atualizado
        } else if (cidade.getEstado().getId() != null && cidade.getNome().isEmpty()) {

            estado.setId(cidade.getEstado().getId());
            return repositorio.atualizarEstado(estado, cidade.getId());
        }
        //Caso o Nome e Códgo do Estado não sejam nulos, a intenção é atualizar os dois
        estado.setId(cidade.getEstado().getId());
        return repositorio.atualizarNomeECodigoEstado(cidade.getNome(), estado, cidade.getId());
    }

    public Cidade fromDTOAtualizar(CidadeAtualizarDTO cidadeAtualizarDTO) {
        Estado estado = new Estado();
        estado.setId(cidadeAtualizarDTO.getEstado());
        Cidade cidade = new Cidade(cidadeAtualizarDTO.getId(), cidadeAtualizarDTO.getNome(), estado);
        return cidade;
    }

    public Cidade converterParaCidade(CidadeAtualizarDTO cidadeAtualizarDTO) {
        return new ModelMapper().map(cidadeAtualizarDTO, Cidade.class);
    }

}
