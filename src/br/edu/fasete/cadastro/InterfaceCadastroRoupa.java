package br.edu.fasete.cadastro;

import java.util.Vector;
import br.edu.fasete.principais.Roupa;

public interface InterfaceCadastroRoupa {
	public void AtualizarRoupa(Roupa r);
	public void BuscarRoupa(Roupa r);
	public void ExcluirRoupa(Roupa r);
	public void InserirRoupa(Roupa r); 
	public Vector<Roupa> listarRoupas();

}
