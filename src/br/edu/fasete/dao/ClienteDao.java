package br.edu.fasete.dao;

import java.util.Vector;

import br.edu.fasete.principais.Cliente;


public interface ClienteDao {
	 public void AtualizarCliente(Cliente c, String cpf);
	 public void BuscarClienteCPF(Cliente c, String pesq);
	 public void BuscarClientenome(Cliente c, String pesq);
	 public void ExcluirCliente(Cliente c);
	 public void InserirCliente(Cliente c);
	 public Vector<Cliente> listarClientes();
	 public Vector<Cliente> listartodosClientes();
	 public Vector<Cliente> listartodosClientespesq(String pesq);
}
