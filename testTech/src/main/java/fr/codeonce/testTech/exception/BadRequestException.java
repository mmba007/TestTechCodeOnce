package fr.codeonce.testTech.exception;

public class BadRequestException extends RuntimeException {

	public BadRequestException(String exception) {
		super(exception);
	}
}
