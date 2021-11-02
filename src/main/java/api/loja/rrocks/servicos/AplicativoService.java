package api.loja.rrocks.servicos;

import api.loja.rrocks.dto.AplicativoSalvarDTO;
import api.loja.rrocks.dto.CidadeSalvarDTO;
import api.loja.rrocks.entidades.Aplicativo;
import api.loja.rrocks.entidades.Cidade;
import api.loja.rrocks.entidades.Estado;
import api.loja.rrocks.repositorios.AplicativoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class AplicativoService {

    @Autowired
    private AplicativoRepository repositorio;

    //BUSCAR TODOS O APLICATIVOS
    public List<Aplicativo> buscarTodos() {
        return repositorio.findAll();
    }

    /*
     * Monsta o objeto para ser persistido na entidade Aplicativo
     * */
    public Aplicativo fromDTOSalvar(AplicativoSalvarDTO aplicativoSalvarDTO) {
        //Estado estado = new Estado();
        //   Aplicativo aplicativo = new Aplicativo();
        System.out.println(aplicativoSalvarDTO);
        return null;
    }


}
