package br.edu.fasete.fachada;

import java.util.Vector;
import br.edu.fasete.cadastro.CadastroCliente;
import br.edu.fasete.cadastro.CadastroRoupa;
import br.edu.fasete.cadastro.InterfaceCadastroCliente;
import br.edu.fasete.cadastro.InterfaceCadastroRoupa;
import br.edu.fasete.dao.ClienteDaoJdbc;
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
public void BuscarCliente(Cliente c){
	cadastroCliente.BuscarCliente(c);
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
public void AtualizarRoupa(Roupa r){
	cadastroRoupa.AtualizarRoupa(r);
}
public void BuscarRoupa(Roupa r){
	cadastroRoupa.BuscarRoupa(r);
}
}
