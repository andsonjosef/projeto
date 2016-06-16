package br.edu.fasete.cadastro;

import java.util.Vector;
import br.edu.fasete.dao.LixeiraDao;
import br.edu.fasete.principais.Cliente;
import br.edu.fasete.principais.Roupa;


public class CadastroLixeira implements InterfaceCadastroLixeira {
	private LixeiraDao lixeiraDao;
	public CadastroLixeira(LixeiraDao lixeiraDao) {
		this.lixeiraDao = lixeiraDao;
	}
	@Override
	public Vector<Cliente> listarClienteslixe() {
		return lixeiraDao.listarClienteslixe();
	}
	@Override
	public Vector<Roupa> listarRoupalixe() {
		return lixeiraDao.listarRoupalixe();
	}
	
	public void RestaurarCliente(Cliente c){
		lixeiraDao.RestaurarCliente(c);
	}
	public void RestaurarRoupa(Roupa r){
		lixeiraDao.RestaurarRoupa(r);
	}
	 public void ExcluirClienteLixe(Cliente c){
		 lixeiraDao.ExcluirClienteLixe(c);
	 }
	 public void ExcluirRoupaLixe(Roupa r){
		 lixeiraDao.ExcluirRoupaLixe(r);
	 }

}
