package br.edu.fasete.cadastro;

import java.util.Vector;

import br.edu.fasete.dao.RoupaDao;
import br.edu.fasete.principais.Cliente;
import br.edu.fasete.principais.Roupa;

public class CadastroRoupa implements InterfaceCadastroRoupa {
	private RoupaDao roupaDao;
	public CadastroRoupa(RoupaDao roupaDao) {
		this.roupaDao = roupaDao;
	}
	@Override
	public void InserirRoupa(Roupa r){
		roupaDao.InserirRoupa(r);
	}

	@Override
	public void ExcluirRoupa(Roupa r) {
		roupaDao.ExcluirRoupa(r);

	}

	@Override
	public Vector<Roupa> listarRoupas() {
		return roupaDao.listarRoupas();
	}
	
	public Vector<Roupa> listarRoupasSele() {
		return roupaDao.listarRoupasSele();
	}
	
	@Override
	public void AtualizarRoupa(Roupa r) {
		roupaDao.AtualizarRoupa(r);
	}

	@Override
	public void BuscarRoupa(Roupa r) {
		roupaDao.BuscarRoupa(r);
	}
	public void limparTabela(){
		roupaDao.limparTabela();
	}
	public void InserirRoupaSele(Roupa r){
		roupaDao.InserirRoupaSele(r);
	}
	 public void ExcluirRoupaSele(Roupa r){
		 roupaDao.ExcluirRoupaSele(r);
	 }
	 public void InserirLista(Roupa r, Cliente c){
		 roupaDao.InserirLista(r, c);
	 }
}
