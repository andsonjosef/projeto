package br.edu.fasete.cadastro;

import br.edu.fasete.principais.Funcionario;

public interface InterfaceCadastroLogin {
	public void apagarLogin(Funcionario f);
	public Funcionario buscarLogin(Funcionario f);
	public Funcionario buscarLoginRoot(Funcionario f);
	public void inserirLogin(Funcionario f);
	public void editarLogin(Funcionario f, String login, String senha);
	public void editarPergunta(Funcionario f, String pergunta, String resposta);

}
