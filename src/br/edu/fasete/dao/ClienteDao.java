package br.edu.fasete.dao;

import java.util.Vector;

import br.edu.fasete.principais.Cliente;


public interface ClienteDao {
	 public void InserirCliente(Cliente c);
	 public void ExcluirCliente(Cliente c);
	 public Vector<Cliente> listarClientes();
	 public void AtualizarCliente(Cliente c, String cpf);
	 public void BuscarClientenome(Cliente c, String pesq);
	 public void BuscarClienteCPF(Cliente c, String pesq);
	
}
