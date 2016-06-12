package br.edu.fasete.cadastro;

import java.util.Vector;

import br.edu.fasete.dao.FuncionarioDao;
import br.edu.fasete.principais.Funcionario;



public class CadastroFuncionario implements InterfaceCadastroFuncionario {
	private FuncionarioDao funcionarioDao;
	public CadastroFuncionario(FuncionarioDao funcionarioDao) {
		this.funcionarioDao = funcionarioDao;
	}
	@Override
	public void AtualizarFuncionario(Funcionario f, String cpf) {
		funcionarioDao.AtualizarFuncionario(f,cpf);
	}
	@Override
	public void BuscarFuncionarioCPF(Funcionario f, String pesq) {
		funcionarioDao.BuscarFuncionarioCPF(f,pesq);
	}
	@Override
	public void BuscarFuncionarionome(Funcionario f, String pesq) {
		funcionarioDao.BuscarFuncionarionome(f,pesq);
	}
	@Override
	public void ExcluirFuncionario(Funcionario f) {
		funcionarioDao.ExcluirFuncionario(f);
	}	
	@Override
	public void InserirFuncionario(Funcionario f) {
		funcionarioDao.InserirFuncionario(f);
	}
	@Override
	public Vector<Funcionario> listarFuncionario(){
		return funcionarioDao.listarFuncionario();
	}

}
