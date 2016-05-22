package br.edu.fasete.principais;

import java.sql.Date;

public class Aluguel {
	int codAluguel;
	int codCliente;
	Date dataLoca;
	Date dataEntre;
	public Aluguel(){
		
	}
	public Aluguel(int codAluguel, int codCliente, Date dataLoca, Date dataEntre) {
		super();
		this.codAluguel = codAluguel;
		this.codCliente = codCliente;
		this.dataLoca = dataLoca;
		this.dataEntre = dataEntre;
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
	
}
