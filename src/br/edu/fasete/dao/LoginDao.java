package br.edu.fasete.dao;

import br.edu.fasete.principais.Funcionario;


public interface LoginDao {
	public void apagarLogin(Funcionario f);
	public Funcionario buscarLogin(Funcionario f);
	public Funcionario buscarLoginRoot(Funcionario f);
	public void inserirLogin(Funcionario f);
	
}
