package br.edu.infnet.lojas.exceptions;

public class VeiculoNaoEncontradoException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public VeiculoNaoEncontradoException(String mensagem) {
        super(mensagem);
    }
}
