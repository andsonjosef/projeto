package br.edu.fasete.dao;

import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JTable;

import br.edu.fasete.principais.Cliente;


public interface ClienteDao {
	 public void InserirCliente(Cliente c);
	 public void ExcluirCliente(Cliente c);
	 public Vector<Cliente> listarClientes();
	 public void AtualizarCliente(Cliente c, String cpf);
	 public void BuscarClientenome(Cliente c, String pesq);
	 public void BuscarClienteCPF(Cliente c, String pesq);
	
}
