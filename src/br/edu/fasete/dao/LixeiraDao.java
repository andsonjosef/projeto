package br.edu.fasete.dao;

import java.util.Vector;

import br.edu.fasete.principais.Cliente;
import br.edu.fasete.principais.Roupa;


public interface LixeiraDao {
	 public Vector<Cliente> listarClienteslixe();
	 public Vector<Roupa> listarRoupalixe();
	 public void RestaurarCliente(Cliente c);
	 public void RestaurarRoupa(Roupa r);
}
