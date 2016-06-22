package br.edu.fasete.cadastro;

import java.util.Vector;
import br.edu.fasete.principais.Pagamento;

public interface InterfaceCadastroPagamento {
	public void AtualizarPagamento(Pagamento p, String cliente);
	public void BuscarPagamento(Pagamento p, String pesq);
	public void ExcluirPagamento(Pagamento p);
	public void InserirPagamento(Pagamento p);
	public Vector<Pagamento> listarPagamentos();
	public Vector<Pagamento> listarPagamentopesq(String pesq);
	public void pagamentoTotal(Pagamento p);
}
