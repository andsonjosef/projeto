package br.edu.fasete.cadastro;

import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JTable;

import br.edu.fasete.principais.Cliente;

public interface InterfaceCadastroCliente {
	 public void AtualizarCliente(Cliente c, String cpf);
	 public void BuscarClienteCPF(Cliente c, String pesq);
	 public void BuscarClientenome(Cliente c, String pesq);
	 public void ExcluirCliente(Cliente c);
	 public void InserirCliente(Cliente c);
	 public Vector<Cliente> listarClientes();

}
