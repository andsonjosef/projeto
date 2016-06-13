package br.edu.fasete.cadastro;

import br.edu.fasete.principais.Funcionario;

public interface InterfaceCadastroLogin {
	public void apagarLogin(Funcionario f);
	public Funcionario buscarLogin(Funcionario f);
	public Funcionario buscarLoginRoot(Funcionario f);
	public void inserirLogin(Funcionario f);

}
