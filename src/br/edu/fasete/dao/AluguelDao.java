package br.edu.fasete.dao;

import java.util.Vector;

import br.edu.fasete.principais.Aluguel;
import br.edu.fasete.principais.Cliente;
import br.edu.fasete.principais.Roupa;

public interface AluguelDao {
	 public void ExcluirRoupaSele(Roupa r);
	 public void InserirLista(Roupa r, Cliente c); 
	 public void InserirRoupaSele(Roupa r);
	 public void limparLista();
	 public void InserirListaFinal(Roupa r, Cliente c);
	 public void limparTabela();
	 public Vector<Roupa> listarRoupaLista();
	 public Vector<Roupa> listarRoupasSele();
	 public void SomaPreco(Aluguel a);
	
}
