package br.edu.fasete.cadastro;

import java.util.Vector;

import br.edu.fasete.dao.RegistroDao;
import br.edu.fasete.principais.Aluguel;
import br.edu.fasete.principais.Cliente;
import br.edu.fasete.principais.Roupa;

public class CadastroRegistro implements InterfaceCadastroRegistro {
	private RegistroDao registroDao;
	
	public CadastroRegistro(RegistroDao registroDao){
		this.registroDao = registroDao;
		
	}
	
	public void BuscarRoupaEd(Roupa r){
		registroDao.BuscarRoupaEd(r);
	}
	public void dispinibilidade( Roupa r){
		registroDao.dispinibilidade(r);
	}
	public void ExcluirReg(Cliente c){
		registroDao.ExcluirReg(c);
	}
	public void ExcluirRoupaSeleEdi(Roupa r){
		registroDao.ExcluirRoupaSeleEdi(r);
	}
	public void InserirRegistro(Aluguel a){
		registroDao.InserirRegistro(a);
	}
	public void InserirRoupaEdi(Roupa r,Cliente c){
		registroDao.InserirRoupaEdi(r, c);
	}
	public void disponivel( Roupa r){
		registroDao.disponivel(r);
	}
	public Vector<Cliente> listarClientesReg(){
		return registroDao.listarClientesReg();
	}
	public Vector<Roupa> ListarRoupaEdi(Roupa r,Cliente c){
		return registroDao.ListarRoupaEdi(r,c);
	}
	public Vector<Roupa> listarRoupasSeleEdi(){
		return registroDao.listarRoupasSeleEdi();
	}
	public Vector<Roupa> listarRoupaListaFim(Cliente c){
		return registroDao.listarRoupaListaFim(c);
	}
	public void ListarRegistro(Cliente c, Aluguel a){
		registroDao.ListarRegistro(c, a);
	}
	public void SomaPrecoEdi(Aluguel a,Cliente c){
		registroDao.SomaPrecoEdi(a,c);
	}
}
