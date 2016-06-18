package br.edu.fasete.fachada;


import java.util.Vector;
import br.edu.fasete.cadastro.CadastroAluguel;
import br.edu.fasete.cadastro.CadastroLixeira;
import br.edu.fasete.cadastro.CadastroFuncionario;
import br.edu.fasete.cadastro.CadastroLogin;
import br.edu.fasete.cadastro.CadastroCliente;
import br.edu.fasete.cadastro.CadastroRoupa;
import br.edu.fasete.cadastro.CadastroRegistro;
import br.edu.fasete.cadastro.InterfaceCadastroAluguel;
import br.edu.fasete.cadastro.InterfaceCadastroCliente;
import br.edu.fasete.cadastro.InterfaceCadastroFuncionario;
import br.edu.fasete.cadastro.InterfaceCadastroLixeira;
import br.edu.fasete.cadastro.InterfaceCadastroLogin;
import br.edu.fasete.cadastro.InterfaceCadastroRegistro;
import br.edu.fasete.cadastro.InterfaceCadastroRoupa;
import br.edu.fasete.dao.AluguelDaoJdbc;
import br.edu.fasete.dao.ClienteDaoJdbc;
import br.edu.fasete.dao.FuncionarioDaoJdbc;
import br.edu.fasete.dao.LixeiraDaoJdbc;
import br.edu.fasete.dao.LoginDaoJdbc;
import br.edu.fasete.dao.RegistroDaoJdbc;
import br.edu.fasete.dao.RoupaDaoJdbc;
import br.edu.fasete.principais.Aluguel;
import br.edu.fasete.principais.Cliente;
import br.edu.fasete.principais.Funcionario;
import br.edu.fasete.principais.Roupa;



public class Fachada {
private InterfaceCadastroCliente cadastroCliente;
private InterfaceCadastroRoupa cadastroRoupa;
private InterfaceCadastroAluguel cadastroAluguel;
private InterfaceCadastroRegistro cadastroRegistro;
private InterfaceCadastroFuncionario cadastroFuncionario;
private InterfaceCadastroLogin cadastroLogin;
private InterfaceCadastroLixeira cadastroLixeira;

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
	cadastroFuncionario = new CadastroFuncionario(new FuncionarioDaoJdbc());
	cadastroLogin = new CadastroLogin(new LoginDaoJdbc());
	cadastroLixeira = new CadastroLixeira(new LixeiraDaoJdbc());
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
public Vector<Cliente> listartodosClientes(){
	return cadastroCliente.listartodosClientes();
}
public Vector<Cliente> listartodosClientespesq(String pesq){
	return cadastroCliente.listartodosClientespesq(pesq);
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
public Vector<Roupa> listartodasRoupas(){
	return cadastroRoupa.listartodasRoupas();
}
public Vector<Roupa> listartodasRoupascod(int pesq){
	return cadastroRoupa.listartodasRoupascod(pesq);
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
public void ExcluirReg(Cliente c,Aluguel a ){
	cadastroRegistro.ExcluirReg(c,a);
}
public void ExcluirRoupaSeleEdi(Roupa r){
	cadastroRegistro.ExcluirRoupaSeleEdi(r);
}
public void InserirRegistro(Aluguel a,Funcionario f){
	 cadastroRegistro.InserirRegistro(a,f);
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
public void SomaPrecoEdi(Aluguel a,Cliente c){
	cadastroRegistro.SomaPrecoEdi(a,c);
}

//------------Funcionario----------------------
public void AtualizarFuncionario(Funcionario f, String svalueCpf){
	cadastroFuncionario.AtualizarFuncionario(f,svalueCpf);
}
public void BuscarFuncionarioCPF(Funcionario f, String pesq){
	cadastroFuncionario.BuscarFuncionarioCPF(f,pesq);
}
public void BuscarFuncionarionome(Funcionario f, String pesq){
	cadastroFuncionario.BuscarFuncionarionome(f,pesq);
}
public void ExcluirFuncionario(Funcionario f){
	cadastroFuncionario.ExcluirFuncionario(f);
}
public void InserirFuncionario(Funcionario f){
	cadastroFuncionario.InserirFuncionario(f);
}
public Vector<Funcionario> listarFuncionario(){
	return cadastroFuncionario.listarFuncionario();
}

//------------Login---------------

public void apagarLogin(Funcionario f){
	cadastroLogin.apagarLogin(f);
}
public Funcionario buscarLogin(Funcionario f){
	return cadastroLogin.buscarLogin(f);
}
public Funcionario buscarLoginRoot(Funcionario f){
	return cadastroLogin.buscarLoginRoot(f);
}
public void inserirLogin(Funcionario f){
	cadastroLogin.inserirLogin(f);
}
public void editarLogin(Funcionario f, String login, String senha){
	cadastroLogin.editarLogin(f, login, senha);
}
public void editarPergunta(Funcionario f, String pergunta, String resposta){
	cadastroLogin.editarPergunta(f, pergunta, resposta);
}
public Funcionario buscarPergunta(Funcionario f){
	return cadastroLogin.buscarPergunta(f);
}
public void buscarnRoot(Funcionario f){
	cadastroLogin.buscarnRoot(f);
}

//-------------Lixeira-----------------


public void ExcluirClienteLixe(Cliente c){
	cadastroLixeira.ExcluirClienteLixe(c);
}
public void ExcluirRoupaLixe(Roupa r){
	cadastroLixeira.ExcluirRoupaLixe(r);
}

public Vector<Cliente> listarClienteslixe() {
	return cadastroLixeira.listarClienteslixe();
}
public Vector<Roupa> listarRoupalixe() {
	return cadastroLixeira.listarRoupalixe();
}
public void RestaurarCliente(Cliente c){
	cadastroLixeira.RestaurarCliente(c);
}
public void RestaurarRoupa(Roupa r){
	cadastroLixeira.RestaurarRoupa(r);
}
public Vector<Aluguel> ListarRegistrolixeira( Aluguel a){
	return cadastroRegistro.ListarRegistrolixeira(a);
}
public Vector<Roupa> listarRoupaListaFimlixeira(Cliente c){
	return cadastroRegistro.listarRoupaListaFimlixeira(c);
}
}