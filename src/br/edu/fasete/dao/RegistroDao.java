package br.edu.fasete.dao;

import java.util.Vector;

import br.edu.fasete.principais.Aluguel;
import br.edu.fasete.principais.Cliente;
import br.edu.fasete.principais.Roupa;


public interface RegistroDao {
	
	
	public void BuscarRoupaEd(Roupa r);
	public void dispinibilidade( Roupa r);
	public void ExcluirReg(Cliente c);
	public void ExcluirRoupaSeleEdi(Roupa r);
	public void InserirRoupaEdi(Roupa r,Cliente c);
	public void InserirRegistro(Aluguel a);
	public void disponivel( Roupa r);
	public Vector<Cliente> listarClientesReg();
	public Vector<Roupa> ListarRoupaEdi(Roupa r,Cliente c);
	public Vector<Roupa> listarRoupasSeleEdi();
	public Vector<Roupa> listarRoupaListaFim(Cliente c);
	public void ListarRegistro(Cliente c, Aluguel a);

}
