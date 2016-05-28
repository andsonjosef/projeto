package br.edu.fasete.principais;

public class Funcionario extends Cliente{
	public int codFuncionario;
	String login;
	String senha;
	boolean acessar;

	

	public Funcionario() {
		super();
	}

	public Funcionario(String nome, String CPF, 
					   String RG,  String telefone,int codCliente,String estado, String cidade, String bairro, String endereco, String numero, int codFuncionario, String login, String senha,boolean acessar,boolean registro) {
		super(nome, CPF, RG, telefone,codCliente,estado,cidade,bairro,endereco,numero,registro );
		this.codFuncionario = codFuncionario;
		this.login = login;
		this.senha = senha;
		this.acessar = acessar;
	}

	public boolean isAcessar() {
		return acessar;
	}

	public void setAcessar(boolean acessar) {
		this.acessar = acessar;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public int getCodFuncionario() {
		return codFuncionario;
	}
	public void setCodFuncionario(int codFuncionario) {
		this.codFuncionario = codFuncionario;
	}
}
