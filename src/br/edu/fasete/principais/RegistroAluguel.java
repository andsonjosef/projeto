package br.edu.fasete.principais;

public class RegistroAluguel {
	private int codRegistro;
	private int CodCliente;
	private int codRoupa;
	private int codItens;
	private int dataLocacao;
	private int dataEntrega;
	private float total;
	
	public RegistroAluguel(){}
	public RegistroAluguel(int codRegistro, int codCliente, int codRoupa, 
			   int codItens, int dataLocacao, 
			   int dataEntrega, float total) {
super();
this.codRegistro = codRegistro;
this.CodCliente = codCliente;
this.codRoupa = codRoupa;
this.codItens = codItens;
this.dataLocacao = dataLocacao;
this.dataEntrega = dataEntrega;


}

public float getTotal() {
return total;
}
public void setTotal(float total) {
this.total += total;
}


public int getCodRoupa() {
return codRoupa;
}
public void setCodRoupa(int codRoupa) {
this.codRoupa = codRoupa;
}
public int getCodRegistro() {
return codRegistro;
}
public void setCodRegistro(int codRegistro) {
this.codRegistro = codRegistro;
}
public int getCodCliente() {
return CodCliente;
}
public void setCodCliente(int codCliente) {
CodCliente = codCliente;
}
public int getCodItens() {
return codItens;
}
public void setCodItens(int codItens) {
this.codItens = codItens;
}
public int getDataLocacao() {
return dataLocacao;
}
public void setDataLocacao(int dataLocacao) {
this.dataLocacao = dataLocacao;
}
public int getDataEntrega() {
return dataEntrega;
}
public void setDataEntrega(int dataEntrega) {
this.dataEntrega = dataEntrega;
}

}
