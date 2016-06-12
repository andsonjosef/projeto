package br.edu.fasete.cadastro;

import java.util.Vector;
import br.edu.fasete.principais.Funcionario;

public interface InterfaceCadastroFuncionario {
	public void AtualizarFuncionario(Funcionario f, String cpf);
	 public void BuscarFuncionarioCPF(Funcionario f, String pesq);
	 public void BuscarFuncionarionome(Funcionario f, String pesq);
	 public void ExcluirFuncionario(Funcionario f);
	 public void InserirFuncionario(Funcionario f);
	 public Vector<Funcionario> listarFuncionario();

}
