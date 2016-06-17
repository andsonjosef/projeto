package br.edu.fasete.cadastro;

import java.util.Vector;

import br.edu.fasete.principais.Aluguel;
import br.edu.fasete.principais.Cliente;
import br.edu.fasete.principais.Funcionario;
import br.edu.fasete.principais.Roupa;

public interface InterfaceCadastroRegistro {
	public void BuscarRoupaEd(Roupa r);
	public void dispinibilidade( Roupa r);
	public void disponivel( Roupa r);
	public void ExcluirReg(Cliente c,Aluguel a );
	public void ExcluirRoupaSeleEdi(Roupa r);
	public void InserirRegistro(Aluguel a, Funcionario f);
	public void InserirRoupaEdi(Roupa r,Cliente c);
	public Vector<Cliente> listarClientesReg();
	public Vector<Roupa> ListarRoupaEdi(Roupa r,Cliente c);
	public Vector<Roupa> listarRoupasSeleEdi();
	public Vector<Roupa> listarRoupaListaFim(Cliente c);
	public void ListarRegistro(Cliente c, Aluguel a);
	public void SomaPrecoEdi(Aluguel a,Cliente c);
	public Vector<Aluguel> ListarRegistrolixeira( Aluguel a);
	public Vector<Roupa> listarRoupaListaFimlixeira(Cliente c);
	


}
