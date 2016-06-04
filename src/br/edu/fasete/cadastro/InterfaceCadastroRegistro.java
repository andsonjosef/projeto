package br.edu.fasete.cadastro;

import java.util.Vector;

import br.edu.fasete.principais.Aluguel;
import br.edu.fasete.principais.Cliente;
import br.edu.fasete.principais.Roupa;

public interface InterfaceCadastroRegistro {
	public void InserirRegistro(Aluguel a);
	public void dispinibilidade( Roupa r);
	public void disponivel( Roupa r);
	public void ExcluirReg(Cliente c);
	public Vector<Cliente> listarClientesReg();
	public Vector<Roupa> ListarRoupaEdi(Roupa r);
	public Vector<Roupa> listarRoupaListaFim(Cliente c);
	public void ListarRegistro(Cliente c, Aluguel a);
	


}
