package br.edu.fasete.cadastro;

import java.util.Vector;
import br.edu.fasete.dao.ClienteDao;
import br.edu.fasete.principais.Cliente;


public class CadastroCliente implements InterfaceCadastroCliente {
	private ClienteDao clienteDao;
	public CadastroCliente(ClienteDao clienteDao) {
		this.clienteDao = clienteDao;
	}
	@Override
	public void AtualizarCliente(Cliente c, String cpf) {
		clienteDao.AtualizarCliente(c,cpf);
	}
	public void BuscarClienteCPF(Cliente c, String pesq) {
		clienteDao.BuscarClienteCPF(c,pesq);
	}
	@Override
	public void BuscarClientenome(Cliente c, String pesq) {
		clienteDao.BuscarClientenome(c,pesq);
	}
	@Override
	public void ExcluirCliente(Cliente c) {
		clienteDao.ExcluirCliente(c);
	}	
	@Override
	public void InserirCliente(Cliente c) {
		clienteDao.InserirCliente(c);
	}
	@Override
	public Vector<Cliente> listarClientes(){
		return clienteDao.listarClientes();
	}
	
	public Vector<Cliente> listartodosClientes(){
		return clienteDao.listartodosClientes();
	}

}
