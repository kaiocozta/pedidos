package br.com.apsoo.pedidos.service.exception;

public class CategoriaPossuiVinculoException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public CategoriaPossuiVinculoException(String message) {
        super(message);
    }

    public CategoriaPossuiVinculoException(String message, Throwable cause) {
        super(message, cause);
    }
}
