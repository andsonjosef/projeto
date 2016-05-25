package br.edu.fasete.dao;

import java.util.Vector;

import br.edu.fasete.principais.Aluguel;
import br.edu.fasete.principais.Cliente;
import br.edu.fasete.principais.Roupa;



public interface RoupaDao {
	 public void InserirRoupa(Roupa r);
	 public void ExcluirRoupa(Roupa r);
	 public Vector<Roupa> listarRoupas();
	 public Vector<Roupa> listarRoupasSele();
	 public void AtualizarRoupa(Roupa r);
	 public void BuscarRoupa(Roupa r);
	 public void limparTabela();
	 public void limparLista();
	 public void InserirRoupaSele(Roupa r);
	 public void ExcluirRoupaSele(Roupa r);
	 public void InserirLista(Roupa r, Cliente c); 
	 public Vector<Roupa> listarRoupaLista();
	 public void SomaPreco(Aluguel a);
	 
	
}
