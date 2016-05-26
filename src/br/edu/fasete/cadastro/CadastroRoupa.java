package br.edu.fasete.cadastro;

import java.util.Vector;

import br.edu.fasete.dao.RoupaDao;
import br.edu.fasete.principais.Aluguel;
import br.edu.fasete.principais.Cliente;
import br.edu.fasete.principais.Roupa;

public class CadastroRoupa implements InterfaceCadastroRoupa {
	private RoupaDao roupaDao;
	
	public CadastroRoupa(RoupaDao roupaDao) {
		this.roupaDao = roupaDao;
	}
	
	@Override
	public void AtualizarRoupa(Roupa r) {
		roupaDao.AtualizarRoupa(r);
	}
	
	@Override
	public void BuscarRoupa(Roupa r) {
		roupaDao.BuscarRoupa(r);
	}
	
	@Override
	public void ExcluirRoupa(Roupa r) {
		roupaDao.ExcluirRoupa(r);

	}
	@Override
	public void InserirRoupa(Roupa r){
		roupaDao.InserirRoupa(r);
	}
	

	@Override
	public Vector<Roupa> listarRoupas() {
		return roupaDao.listarRoupas();
	}
	
}
