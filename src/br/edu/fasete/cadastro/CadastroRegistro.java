package br.edu.fasete.cadastro;

import br.edu.fasete.dao.RegistroDao;
import br.edu.fasete.principais.Aluguel;
import br.edu.fasete.principais.Roupa;

public class CadastroRegistro implements InterfaceCadastroRegistro {
	private RegistroDao registroDao;

	public CadastroRegistro(RegistroDao registroDao){
		this.registroDao = registroDao;
		
	}
	public void InserirRegistro(Aluguel a){
		registroDao.InserirRegistro(a);
	}
	public void dispinibilidade( Roupa r){
		registroDao.dispinibilidade(r);
	}

}
