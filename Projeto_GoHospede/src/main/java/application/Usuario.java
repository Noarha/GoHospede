package application;

public class Usuario {
	private String nome;
	private String cpf;
	private String email;
	private String nascimento;
	private String telefone;
	private String senha;
	public Usuario(String nome, String cpf, String email, String nascimento, String telefone, String senha) {
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.nascimento = nascimento;
		this.telefone = telefone;
		this.senha = senha;	
	}
	public String getNome() {
		return nome;
	}
	public String getCpf() {
		return cpf;	
	}
	public String getEmail() {
		return email;
	}
	public String getNascimento() {
		return nascimento;
	}
	public String getTelefone() {
		return telefone;
	}

	public String getSenha() {
		return senha;	
	}
	public String converterParaLinha() {
		return nome +";"+cpf+";"+email+";"+nascimento+";"+telefone+";"+senha;
	}
}
	


