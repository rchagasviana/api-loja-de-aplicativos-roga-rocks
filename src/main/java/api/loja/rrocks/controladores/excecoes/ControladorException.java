package api.loja.rrocks.controladores.excecoes;


/*
 * Utilizada para interceptar as exceções geradas pelas
 * classes de serviço e evitar excesso de código como
 * try-catch dentro das classes controladoras
 * */

import api.loja.rrocks.servicos.excecoes.ObjetoNaoEncontradoException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ControladorException {


    @ExceptionHandler(ObjetoNaoEncontradoException.class) //Trata exceções com objetos desse tipo
    public ResponseEntity<ModeloErroPadrao> objetoNaoEncontrado
            (ObjetoNaoEncontradoException objetoLancadoPeloService, HttpServletRequest requisicao) {

        String dadosDaRequisicao = "URI:" + requisicao.getRequestURI();

        ModeloErroPadrao erro = new ModeloErroPadrao(
                HttpStatus.NOT_FOUND.value(), //o código de erro http. Neste caso, retornará o 404
                objetoLancadoPeloService.getMessage(), // a mensagem personalizada criada
                System.currentTimeMillis(), //momento que a exceção ocorreu,
                dadosDaRequisicao
        );

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);


    }
}
