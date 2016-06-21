package br.edu.fasete.principais;

public class Pagamento {
	String dataVenc1;
	float valorParc1;
	String status1;
	float valorPago1;
	String dataPago1;
	String dataVenc2;
	float valorParc2;
	String status2;
	float valorPago2;
	String dataPago2;
	
	
	public Pagamento(){
		
	}
	public Pagamento(String dataVenc1, float valorParc1, String status1,float valorPago1,String dataPago1,String dataVenc2,	float valorParc2,String status2,float valorPago2,String dataPago2) {
		super();
		this.dataVenc1 = dataVenc1;
		this.valorParc1 = valorParc1;
		this.status1 = status1;
		this.valorPago1 = valorPago1;
		this.dataPago1 = dataPago1;
		this.dataVenc2 = dataVenc2;
		this.valorParc2 = valorParc2;
		this.status2 = status2;
		this.valorPago2 = valorPago2;
		this.dataPago2 = dataPago2;
	}
	public String getDataVenc1() {
		return dataVenc1;
	}
	public void setDataVenc1(String dataVenc1) {
		this.dataVenc1 = dataVenc1;
	}
	public float getValorParc1() {
		return valorParc1;
	}
	public void setValorParc1(float valorParc1) {
		this.valorParc1 = valorParc1;
	}
	public String getStatus1() {
		return status1;
	}
	public void setStatus1(String status1) {
		this.status1 = status1;
	}
	public float getValorPago1() {
		return valorPago1;
	}
	public void setValorPago1(float valorPago1) {
		this.valorPago1 = valorPago1;
	}
	public String getDataPago1() {
		return dataPago1;
	}
	public void setDataPago1(String dataPago1) {
		this.dataPago1 = dataPago1;
	}
	public String getDataVenc2() {
		return dataVenc2;
	}
	public void setDataVenc2(String dataVenc2) {
		this.dataVenc2 = dataVenc2;
	}
	public float getValorParc2() {
		return valorParc2;
	}
	public void setValorParc2(float valorParc2) {
		this.valorParc2 = valorParc2;
	}
	public String getStatus2() {
		return status2;
	}
	public void setStatus2(String status2) {
		this.status2 = status2;
	}
	public float getValorPago2() {
		return valorPago2;
	}
	public void setValorPago2(float valorPago2) {
		this.valorPago2 = valorPago2;
	}
	public String getDataPago2() {
		return dataPago2;
	}
	public void setDataPago2(String dataPago2) {
		this.dataPago2 = dataPago2;
	}
	
	
	
}
