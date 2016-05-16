package br.edu.fasete.fachada;

import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JTable;

import br.edu.fasete.cadastro.CadastroCliente;
import br.edu.fasete.cadastro.InterfaceCadastroCliente;
import br.edu.fasete.dao.ClienteDaoJdbc;
import br.edu.fasete.principais.Cliente;



public class Fachada {
private InterfaceCadastroCliente cadastroCliente;

private static Fachada instancia;

public static Fachada getInstancia() {
	if(instancia == null)
		instancia = new Fachada();
	return instancia;
}

private Fachada() {
	cadastroCliente = new CadastroCliente(new ClienteDaoJdbc());
	
}

//------------Cliente----------------------

public void InserirCliente(Cliente c){
	cadastroCliente.InserirCliente(c);
}

public void ExcluirCliente(Cliente c){
	cadastroCliente.ExcluirCliente(c);
}
public Vector<Cliente> listarClientes(){
	return cadastroCliente.listarClientes();
}
public void AtualizarCliente(Cliente c, String svalueCpf){
	cadastroCliente.AtualizarCliente(c,svalueCpf);
}
public void BuscarClientenome(Cliente c, String pesq){
	cadastroCliente.BuscarClientenome(c,pesq);
}
public void BuscarClienteCPF(Cliente c, String pesq){
	cadastroCliente.BuscarClienteCPF(c,pesq);
}

//--------------------------------------
}
