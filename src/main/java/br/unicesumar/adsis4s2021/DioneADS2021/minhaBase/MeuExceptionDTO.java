package br.unicesumar.adsis4s2021.DioneADS2021.minhaBase;

public class MeuExceptionDTO {
	
	private String exceptionType;
	private String message;
	
	
	public MeuExceptionDTO() {
	}
	
	public String getExceptionType() {
		return exceptionType;
	}
	public String getMessage() {
		return message;
	}

	public MeuExceptionDTO(String exceptionType, String message) {
		super();
		this.exceptionType = exceptionType;
		this.message = message;
	}

}
