package br.edu.fasete.dao;

import java.util.Vector;

import br.edu.fasete.principais.Roupa;



public interface RoupaDao {
	 public void InserirRoupa(Roupa r);
	 public void ExcluirRoupa(Roupa r);
	 public Vector<Roupa> listarRoupas();
	 public void AtualizarRoupa(Roupa r);
	 public void BuscarRoupa(Roupa r);
	
}