package br.com.newsletter.handler;

public class AssinanteNotFoundException  extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public AssinanteNotFoundException(String message) {
		super(message);
	}

}