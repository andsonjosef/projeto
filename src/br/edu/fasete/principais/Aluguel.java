package br.edu.fasete.principais;

public class Aluguel {

	
	protected Cliente cliente;
	protected Itens itensAlugar;
	protected Funcionario funcionario;
	
	public Aluguel(){}
	
	public Aluguel(Funcionario funcionario,Cliente cliente,Itens itensAlugar,String dataLocacao,String dataEntrega){
		this.cliente = cliente;
		this.itensAlugar = itensAlugar;
		this.funcionario = funcionario;
	}
	
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente){
		this.cliente = cliente;
	}
	
}
