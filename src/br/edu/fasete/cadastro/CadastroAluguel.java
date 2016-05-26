package br.edu.fasete.cadastro;

import java.util.Vector;

import br.edu.fasete.dao.AluguelDao;
import br.edu.fasete.principais.Aluguel;
import br.edu.fasete.principais.Cliente;
import br.edu.fasete.principais.Roupa;

public class CadastroAluguel implements InterfaceCadastroAluguel{
	private AluguelDao aluguelDao;

	public CadastroAluguel(AluguelDao aluguelDao){
		this.aluguelDao = aluguelDao;
		
	}
	@Override
	public void ExcluirRoupaSele(Roupa r) {
		aluguelDao.ExcluirRoupaSele(r);
		
	}

	@Override
	public void InserirLista(Roupa r, Cliente c) {
		aluguelDao.InserirLista(r, c);
		
	}

	@Override
	public void InserirRoupaSele(Roupa r) {
		aluguelDao.InserirRoupaSele(r);
		
	}

	@Override
	public void limparLista() {
		aluguelDao.limparLista();
		
	}

	@Override
	public void limparTabela() {
		aluguelDao.limparTabela();
		
	}

	@Override
	public Vector<Roupa> listarRoupaLista() {
		return aluguelDao.listarRoupaLista();
	}

	@Override
	public Vector<Roupa> listarRoupasSele() {
		return aluguelDao.listarRoupasSele();
	}

	@Override
	public void SomaPreco(Aluguel a) {
		aluguelDao.SomaPreco(a);
		
	}
	

}
