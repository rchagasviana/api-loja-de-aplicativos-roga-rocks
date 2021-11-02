package api.loja.rrocks.servicos;

import api.loja.rrocks.dto.AplicativoSalvarDTO;
import api.loja.rrocks.dto.CidadeSalvarDTO;
import api.loja.rrocks.entidades.*;
import api.loja.rrocks.entidades.enums.ClassificacaoAplicativo;
import api.loja.rrocks.entidades.enums.StatusAplicativo;
import api.loja.rrocks.repositorios.AplicativoRepository;
import api.loja.rrocks.repositorios.CategoriaRepository;
import api.loja.rrocks.repositorios.ReleaseRepository;
import api.loja.rrocks.repositorios.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import java.time.Instant;
import java.util.List;

@Service
public class AplicativoService {

    @Autowired
    private AplicativoRepository repositorio;
    @Autowired
    private CategoriaRepository categoriaRepository;
    @Autowired
    private UsuarioRepository fabricanteRepository;
    @Autowired
    private ReleaseRepository releaseRepository;

    //BUSCAR TODOS O APLICATIVOS
    public List<Aplicativo> buscarTodos() {
        return repositorio.findAll();
    }

    /*
     * Monta o objeto para ser persistido na entidade Aplicativo
     * */
    public Aplicativo fromDTOSalvar(AplicativoSalvarDTO aplicativoSalvarDTO) {
        Categoria categoria = new Categoria();
        Fabricante fabricante = new Fabricante();


        //Monta os objetos de cada Entidade relacionada à entidade Aplicativo
        /*
         * A categoria e o fabricante já estão previamente, logo não há necessidade
         * de buscar pelo id informado.
         * */
        categoria.setId(aplicativoSalvarDTO.getIdCategoria());
        fabricante.setId(aplicativoSalvarDTO.getIdFabricante());

        //Aplicativo a ser salvo
        Aplicativo aplicativo = new Aplicativo(
                null,
                aplicativoSalvarDTO.getNome(),
                aplicativoSalvarDTO.getPreco(),
                aplicativoSalvarDTO.getDescricao(),
                ClassificacaoAplicativo.coverterParaEnum(aplicativoSalvarDTO.getClassificacao()),
                StatusAplicativo.EM_DESENVOLVIMENTO,
                categoria,
                fabricante);
        /*O objeto release será salvo após o objeto aplicativo ser persistido para que o código do aplicativo
         * possa ser utilizado para salvar uma release
         * */
        Release release = new Release(
                null,
                aplicativoSalvarDTO.getNomeRelease(),
                Instant.now(),
                null,
                aplicativoSalvarDTO.getDescricaoRelease(),
                aplicativo
        );
        /*
         * Após o aplicativo ser salvo e ter um Id gerado, esta permitirá fazer a associação com a release inserida junto
         * com o app.
         * */
        aplicativo.getReleases().add(release);
        return aplicativo;
    }

    @Transactional
    public Aplicativo salvar(Aplicativo aplicativo) {
        aplicativo = repositorio.save(aplicativo);
        releaseRepository.saveAll(aplicativo.getReleases());
        return aplicativo;
    }


}
