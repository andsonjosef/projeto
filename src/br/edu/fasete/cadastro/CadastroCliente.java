package br.edu.fasete.cadastro;

import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JTable;

import br.edu.fasete.dao.ClienteDao;
import br.edu.fasete.principais.Cliente;


public class CadastroCliente implements InterfaceCadastroCliente {
	private ClienteDao clienteDao;
	public CadastroCliente(ClienteDao clienteDao) {
		this.clienteDao = clienteDao;
	}


	@Override
	public void InserirCliente(Cliente c) {
		clienteDao.InserirCliente(c);

	}

	@Override
	public void ExcluirCliente(Cliente c) {
		clienteDao.ExcluirCliente(c);

	}

	@Override
	public Vector<Cliente> listarClientes(){
		return clienteDao.listarClientes();
	}

	@Override
	public void AtualizarCliente(Cliente c, String cpf) {
		clienteDao.AtualizarCliente(c,cpf);

	}

	@Override
	public void BuscarCliente(Cliente c, String pesq) {
		clienteDao.BuscarCliente(c,pesq);

	}

}
