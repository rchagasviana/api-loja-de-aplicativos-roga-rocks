package api.loja.rrocks.servicos;

import api.loja.rrocks.entidades.Aplicativo;
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
}
