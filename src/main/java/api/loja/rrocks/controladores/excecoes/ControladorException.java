package api.loja.rrocks.controladores.excecoes;


/*
 * Utilizada para interceptar as exceções geradas pelas
 * classes de serviço e evitar excesso de código como
 * try-catch dentro das classes controladoras
 * */

import api.loja.rrocks.servicos.excecoes.ObjetoNaoEncontradoException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class ControladorException {


    @ExceptionHandler(ObjetoNaoEncontradoException.class) //Trata exceções com objetos desse tipo
    public ResponseEntity<ModeloErroPadrao> objetoNaoEncontrado
            (ObjetoNaoEncontradoException error, HttpServletRequest requisicao) {

        String dadosDaRequisicao = "URI:" + requisicao.getRequestURI();

        ModeloErroPadrao erro = new ModeloErroPadrao(
                HttpStatus.NOT_FOUND.value(), //o código de erro http. Neste caso, retornará o 404
                error.getMessage(), // a mensagem personalizada criada
                System.currentTimeMillis(), //momento que a exceção ocorreu,
                dadosDaRequisicao
        );

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);

    }


    /*
     * MethodArgumentNotValidException é gerada sempre que uma validação das classes DTO não
     * passam
     * */
    @ExceptionHandler(MethodArgumentNotValidException.class) //Trata exceções com objetos desse tipo
    public ResponseEntity<ModeloErroPadrao> erroDeValidacao
    (MethodArgumentNotValidException error, HttpServletRequest requisicao) {

        String dadosDaRequisicao = "URI:" + requisicao.getRequestURI();

        /*
        * Capturando o modelo error.getMessage() toda a mensagem é mostrada. No entanto, somente a mensagem
        * default informada pelo CategoriaDTO na ocorrência no erro de validação deverá ser mostrada.
        * Como várias validações podem não ser atendidas, várias mensagem de erros são agrupadas e por isso
        * é preciso efetuar a iteração e salvá-las em uma lista e só depois exibi-las.
        * */
        List<String> mensagemErroValidacao = new ArrayList<>();

        for (FieldError x : error.getBindingResult().getFieldErrors()) {
            mensagemErroValidacao.add(x.getDefaultMessage());
        }

        ModeloErroPadrao erro = new ModeloErroPadrao(
                HttpStatus.NOT_FOUND.value(), //o código de erro http. Neste caso, retornará o 400 - Bad Request
                mensagemErroValidacao.toString(), // a mensagem personalizada criada
                System.currentTimeMillis(), //momento que a exceção ocorreu,
                dadosDaRequisicao
        );

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);

    }


}
