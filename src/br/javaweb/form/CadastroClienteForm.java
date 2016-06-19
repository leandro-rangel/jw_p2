package br.javaweb.form;

import java.io.Serializable;

import br.javaweb.util.anotacao.Form;

/**
 
 */
@Form(nome="cadastroCliente")
public class CadastroClienteForm implements Serializable{

	private static final long serialVersionUID = 8056140913416744435L;

	private Long id;
	
	private String nome;

	private Long cpf;
	
	private Long telefone;
	
	private String email;
	
	private String senha;
	
	private String senha2;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Long getCpf() {
		return cpf;
	}

	public void setCpf(Long cpf) {
		this.cpf = cpf;
	}

	public Long getTelefone() {
		return telefone;
	}

	public void setTelefone(Long telefone) {
		this.telefone = telefone;
	}

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

	public String getSenha2() {
		return senha2;
	}

	public void setSenha2(String senha2) {
		this.senha2 = senha2;
	}
	
}
