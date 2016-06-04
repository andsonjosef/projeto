package br.edu.fasete.fachada;


import java.util.Vector;
import br.edu.fasete.cadastro.CadastroAluguel;
import br.edu.fasete.cadastro.CadastroCliente;
import br.edu.fasete.cadastro.CadastroRoupa;
import br.edu.fasete.cadastro.CadastroRegistro;
import br.edu.fasete.cadastro.InterfaceCadastroAluguel;
import br.edu.fasete.cadastro.InterfaceCadastroCliente;
import br.edu.fasete.cadastro.InterfaceCadastroRegistro;
import br.edu.fasete.cadastro.InterfaceCadastroRoupa;
import br.edu.fasete.dao.AluguelDaoJdbc;
import br.edu.fasete.dao.ClienteDaoJdbc;
import br.edu.fasete.dao.RegistroDaoJdbc;
import br.edu.fasete.dao.RoupaDaoJdbc;
import br.edu.fasete.principais.Aluguel;
import br.edu.fasete.principais.Cliente;
import br.edu.fasete.principais.Roupa;



public class Fachada {
private InterfaceCadastroCliente cadastroCliente;
private InterfaceCadastroRoupa cadastroRoupa;
private InterfaceCadastroAluguel cadastroAluguel;
private InterfaceCadastroRegistro cadastroRegistro;

private static Fachada instancia;

public static Fachada getInstancia() {
	if(instancia == null)
		instancia = new Fachada();
	return instancia;
}

private Fachada() {
	cadastroCliente = new CadastroCliente(new ClienteDaoJdbc());
	cadastroRoupa = new CadastroRoupa(new RoupaDaoJdbc());
	cadastroAluguel = new CadastroAluguel(new AluguelDaoJdbc());
	cadastroRegistro = new CadastroRegistro(new RegistroDaoJdbc());
}

//------------Cliente----------------------
public void AtualizarCliente(Cliente c, String svalueCpf){
	cadastroCliente.AtualizarCliente(c,svalueCpf);
}
public void BuscarClienteCPF(Cliente c, String pesq){
	cadastroCliente.BuscarClienteCPF(c,pesq);
}
public void BuscarClientenome(Cliente c, String pesq){
	cadastroCliente.BuscarClientenome(c,pesq);
}
public void ExcluirCliente(Cliente c){
	cadastroCliente.ExcluirCliente(c);
}
public void InserirCliente(Cliente c){
	cadastroCliente.InserirCliente(c);
}
public Vector<Cliente> listarClientes(){
	return cadastroCliente.listarClientes();
}

//---------------Roupa-----------------------
public void AtualizarRoupa(Roupa r){
	cadastroRoupa.AtualizarRoupa(r);
}
public void BuscarRoupa(Roupa r){
	cadastroRoupa.BuscarRoupa(r);
}
public void ExcluirRoupa(Roupa r){
	cadastroRoupa.ExcluirRoupa(r);
}
public void InserirRoupa(Roupa r){
	cadastroRoupa.InserirRoupa(r);
}
public Vector<Roupa> listarRoupas(){
	return cadastroRoupa.listarRoupas();
}

//---------------Aluguel-----------------------
public void ExcluirRoupaSele(Roupa r){
	cadastroAluguel.ExcluirRoupaSele(r);
}
public void InserirLista(Roupa r, Cliente c){
	cadastroAluguel.InserirLista(r, c);
}
public void InserirListaFinal(Roupa r, Cliente c){
	cadastroAluguel.InserirListaFinal(r, c);
}
public void InserirRoupaSele(Roupa r){
	cadastroAluguel.InserirRoupaSele(r);
}
public void limparLista(){
	cadastroAluguel.limparLista();
}
public void limparTabela(){
	cadastroAluguel.limparTabela();
}
public Vector<Roupa> listarRoupaLista(){
	return cadastroAluguel.listarRoupaLista();
}
public Vector<Roupa> listarRoupasSele(){
	return cadastroAluguel.listarRoupasSele();
}
public void SomaPreco(Aluguel a){
	cadastroAluguel.SomaPreco(a);
}
//---------------Registro-----------------------
public void BuscarRoupaEd(Roupa r){
	cadastroRegistro.BuscarRoupaEd(r);
}

public void dispinibilidade( Roupa r){
	cadastroRegistro.dispinibilidade(r);
}
public void disponivel( Roupa r){
	cadastroRegistro.disponivel(r);
}
public void ExcluirReg(Cliente c){
	cadastroRegistro.ExcluirReg(c);
}
public void ExcluirRoupaSeleEdi(Roupa r){
	cadastroRegistro.ExcluirRoupaSeleEdi(r);
}
public void InserirRegistro(Aluguel a){
	 cadastroRegistro.InserirRegistro(a);
}
public void InserirRoupaEdi(Roupa r,Cliente c){
	cadastroRegistro.InserirRoupaEdi(r, c);
}
public Vector<Cliente> listarClientesReg(){
	return cadastroRegistro.listarClientesReg();
}
public Vector<Roupa> ListarRoupaEdi(Roupa r,Cliente c){
	return cadastroRegistro.ListarRoupaEdi(r,c);
}
public Vector<Roupa> listarRoupasSeleEdi(){
	return cadastroRegistro.listarRoupasSeleEdi();
}
public Vector<Roupa> listarRoupaListaFim(Cliente c){
	return cadastroRegistro.listarRoupaListaFim(c);
}
public void ListarRegistro(Cliente c, Aluguel a){
	cadastroRegistro.ListarRegistro(c, a);
}

}