package br.javaweb.util;


public class JavaWebException extends Exception {

	private static final long serialVersionUID = 6915599857255798746L;

	public JavaWebException(String mensagem, Exception e) {
        super(mensagem, e);
    }

    public JavaWebException(String mensagem) {
        super(mensagem);
    }
}
