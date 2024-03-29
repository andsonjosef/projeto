package br.edu.fasete.cadastro;

import java.util.Vector;

import br.edu.fasete.principais.Cliente;
import br.edu.fasete.principais.Roupa;

public interface InterfaceCadastroLixeira {
	 public Vector<Cliente> listarClienteslixe();
	 public Vector<Roupa> listarRoupalixe();
	 public void RestaurarCliente(Cliente c);
	 public void RestaurarRoupa(Roupa r);
	 public void ExcluirClienteLixe(Cliente c);
	 public void ExcluirRoupaLixe(Roupa r);
}
