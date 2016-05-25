package br.edu.fasete.principais;

import java.sql.Date;

public class Aluguel {
	int codAluguel;
	int codCliente;
	Date dataLoca;
	Date dataEntre;
	float preco;
	float precoTotal;
	
	public Aluguel(){
		
	}
	public Aluguel(int codAluguel, int codCliente, Date dataLoca, Date dataEntre, float preco, float precoTotal) {
		super();
		this.codAluguel = codAluguel;
		this.codCliente = codCliente;
		this.dataLoca = dataLoca;
		this.dataEntre = dataEntre;
		this.preco = preco;
		this.precoTotal = precoTotal;
	}
	public int getCodAluguel() {
		return codAluguel;
	}
	public void setCodAluguel(int codAluguel) {
		this.codAluguel = codAluguel;
	}
	public int getCodCliente() {
		return codCliente;
	}
	public void setCodCliente(int codCliente) {
		this.codCliente = codCliente;
	}
	public Date getDataLoca() {
		return dataLoca;
	}
	public void setDataLoca(Date dataLoca) {
		this.dataLoca = dataLoca;
	}
	public Date getDataEntre() {
		return dataEntre;
	}
	public void setDataEntre(Date dataEntre) {
		this.dataEntre = dataEntre;
	}

	public float getPrecoTotal() {
		return precoTotal;
	}
	public void setPrecoTotal(float precoTotal) {
		this.precoTotal = precoTotal;
	}
	
	public float getPreco(){
		return preco;
	}
	public void setPreco(float preco){
		this.preco = preco;
	}
	
	
}
