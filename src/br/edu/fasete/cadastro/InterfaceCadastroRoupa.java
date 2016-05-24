package br.edu.fasete.cadastro;

import java.util.Vector;

import br.edu.fasete.principais.Cliente;
import br.edu.fasete.principais.Roupa;

public interface InterfaceCadastroRoupa {
	 public void InserirRoupa(Roupa r);
	 public void ExcluirRoupa(Roupa r);
	 public Vector<Roupa> listarRoupas();
	 public Vector<Roupa> listarRoupasSele();
	 public void AtualizarRoupa(Roupa r);
	 public void BuscarRoupa(Roupa r);
	 public void limparTabela();
	 public void InserirRoupaSele(Roupa r);
	 public void ExcluirRoupaSele(Roupa r);
	 public void InserirLista(Roupa r, Cliente c);
	 public void limparLista();
	 public Vector<Roupa> listarRoupaLista();
}
