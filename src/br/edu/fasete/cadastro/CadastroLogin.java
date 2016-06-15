package br.edu.fasete.cadastro;

import br.edu.fasete.dao.LoginDao;
import br.edu.fasete.principais.Funcionario;



public class CadastroLogin implements InterfaceCadastroLogin {
	private LoginDao loginDao;
	public CadastroLogin(LoginDao loginDao) {
		this.loginDao = loginDao;
	}
	public void apagarLogin(Funcionario f){
		loginDao.apagarLogin(f);
	}
	public Funcionario buscarLogin(Funcionario f){
		return loginDao.buscarLogin(f);
	}
	public Funcionario buscarLoginRoot(Funcionario f){
		return loginDao.buscarLoginRoot(f);
	}
	public void inserirLogin(Funcionario f){
		loginDao.inserirLogin(f);
	}
	public void editarLogin(Funcionario f, String login, String senha){
		loginDao.editarLogin(f, login, senha);
	}
	public void editarPergunta(Funcionario f, String pergunta, String resposta){
		loginDao.editarPergunta(f, pergunta, resposta);
	}
}
