package br.edu.fasete.cadastro;

import java.util.Vector;
import br.edu.fasete.dao.ClienteDao;
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


}
