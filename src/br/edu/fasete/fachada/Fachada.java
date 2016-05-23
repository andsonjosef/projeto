package br.edu.fasete.fachada;

import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JTable;

import br.edu.fasete.cadastro.CadastroCliente;
import br.edu.fasete.cadastro.CadastroRoupa;
import br.edu.fasete.cadastro.InterfaceCadastroCliente;
import br.edu.fasete.cadastro.InterfaceCadastroRoupa;
import br.edu.fasete.dao.ClienteDaoJdbc;
import br.edu.fasete.dao.RoupaDao;
import br.edu.fasete.dao.RoupaDaoJdbc;
import br.edu.fasete.principais.Cliente;
import br.edu.fasete.principais.Roupa;



public class Fachada {
private InterfaceCadastroCliente cadastroCliente;
private InterfaceCadastroRoupa cadastroRoupa;

private static Fachada instancia;

public static Fachada getInstancia() {
	if(instancia == null)
		instancia = new Fachada();
	return instancia;
}

private Fachada() {
	cadastroCliente = new CadastroCliente(new ClienteDaoJdbc());
	cadastroRoupa = new CadastroRoupa(new RoupaDaoJdbc());
	
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

//---------------Roupa-----------------------

public void InserirRoupa(Roupa r){
	cadastroRoupa.InserirRoupa(r);
}

public void ExcluirRoupa(Roupa r){
	cadastroRoupa.ExcluirRoupa(r);
}
public Vector<Roupa> listarRoupas(){
	return cadastroRoupa.listarRoupas();
}

public Vector<Roupa> listarRoupasSele(){
	return cadastroRoupa.listarRoupasSele();
}
public void AtualizarRoupa(Roupa r){
	cadastroRoupa.AtualizarRoupa(r);
}
public void BuscarRoupa(Roupa r){
	cadastroRoupa.BuscarRoupa(r);
}
public void limparTabela(){
	cadastroRoupa.limparTabela();
}
public void InserirRoupaSele(Roupa r){
	cadastroRoupa.InserirRoupaSele(r);
}
public void ExcluirRoupaSele(Roupa r){
	cadastroRoupa.ExcluirRoupaSele(r);
}
public void InserirLista(Roupa r, Cliente c){
	cadastroRoupa.InserirLista(r, c);
}
}
