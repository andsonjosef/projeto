package br.edu.fasete.cadastro;

import java.util.Vector;
import br.edu.fasete.dao.PagamentoDao;
import br.edu.fasete.principais.Pagamento;


public class CadastroPagamento implements InterfaceCadastroPagamento {
	private PagamentoDao pagamentodao;
	public CadastroPagamento(PagamentoDao pagamentodao) {
		this.pagamentodao = pagamentodao;
	}

	public void AtualizarPagamento(Pagamento p, String cliente){
		pagamentodao.AtualizarPagamento(p, cliente);
	}
	public void BuscarPagamento(Pagamento p, String pesq){
		pagamentodao.BuscarPagamento(p, pesq);
	}
	public void ExcluirPagamento(Pagamento p){
		pagamentodao.ExcluirPagamento(p);
	}
	public void InserirPagamento(Pagamento p){
		pagamentodao.InserirPagamento(p);
	}
	public Vector<Pagamento> listarPagamentos(){
		return pagamentodao.listarPagamentos();
	}
	public Vector<Pagamento> listarPagamentopesq(String pesq){
		return pagamentodao.listarPagamentopesq(pesq);
	}
	public void pagamentoTotal(Pagamento p){
		pagamentodao.pagamentoTotal(p);
	}
}
