package br.javaweb.form;

import java.io.Serializable;

import br.javaweb.util.anotacao.Form;

/**

 */
@Form(nome="login")
public class LoginForm implements Serializable{

	private static final long serialVersionUID = 2104679029711424669L;

	private String email;
	
	private String senha;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
