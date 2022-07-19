package br.com.msaorim.forum.config.validations;

public class DtoFormError {

	private String campo;
	private String erro;
	
	public DtoFormError() {
		
	}

	public DtoFormError(String campo, String erro) {
		super();
		this.campo = campo;
		this.erro = erro;
	}

	public String getCampo() {
		return campo;
	}

	public String getErro() {
		return erro;
	}
	
}
