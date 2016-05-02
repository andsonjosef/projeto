package br.edu.fasete.principais;

public class Aluguel {

	protected String dataLocacao;
	protected String dataEntrega;
	protected Cliente cliente;
	protected Itens itensAlugar;
	protected Funcionario funcionario;
	
	public Aluguel(){}
	
	public Aluguel(Funcionario funcionario,Cliente cliente,Itens itensAlugar,String dataLocacao,String dataEntrega){
		this.cliente = cliente;
		this.itensAlugar = itensAlugar;
		this.dataLocacao = dataLocacao;
		this.dataEntrega = dataEntrega;
		this.funcionario = funcionario;
	}
	
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente){
		this.cliente = cliente;
	}
	public String getDataLocacao() {
		return dataLocacao;
	}
	public void setDataLocacao(String dataLocacao) {
		this.dataLocacao = dataLocacao;
	}
	public String getDataEntrega() {
		return dataEntrega;
	}
	public void setDataEntrega(String dataEntrega) {
		this.dataEntrega = dataEntrega;
	}
}
