package br.edu.fasete.principais;

public class Aluguel {
	int codAluguel;
	int codCliente;
	String dataLoca;
	String dataEntre;
	float preco;
	float precoTotal;
	String funcionario;
	String pagamento;
	boolean erro;
	
	
	public Aluguel(){
		
	}
	public Aluguel(int codAluguel, int codCliente, String dataLoca, String dataEntre, float preco, float precoTotal,String funcionario,String pagamento, boolean erro) {
		super();
		this.codAluguel = codAluguel;
		this.codCliente = codCliente;
		this.dataLoca = dataLoca;
		this.dataEntre = dataEntre;
		this.preco = preco;
		this.precoTotal = precoTotal;
		this.funcionario = funcionario;
		this.pagamento = pagamento;
		this.erro = erro;
	}
	public String getPagamento() {
		return pagamento;
	}
	public void setPagamento(String pagamento) {
		this.pagamento = pagamento;
	}
	public String getFuncionario() {
		return funcionario;
	}
	public void setFuncionario(String funcionario) {
		this.funcionario = funcionario;
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
	public String getDataLoca() {
		return dataLoca;
	}
	public void setDataLoca(String dataLoca) {
		this.dataLoca = dataLoca;
	}
	public String getDataEntre() {
		return dataEntre;
	}
	public void setDataEntre(String dataEntre) {
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
	public boolean isErro() {
		return erro;
	}
	public void setErro(boolean erro) {
		this.erro = erro;
	}
	
	
}
