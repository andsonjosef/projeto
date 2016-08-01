package comprovanteRela;

public class Comprovante2 {
	String dataVenc1;
	float valorParc1;
	float valorPago1;
	String dataPago1;
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
	public String toString(){
		return dataVenc1 + "-" + valorParc1 + "-"  + dataPago1 + "-" + valorPago1 + "\n\n";		
	}

}
