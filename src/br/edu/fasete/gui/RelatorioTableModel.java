package br.edu.fasete.gui;

import javax.swing.table.DefaultTableModel;

import br.edu.fasete.principais.Pagamento;


public class RelatorioTableModel extends DefaultTableModel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String[] columnName = {"nome", "primeira parcela","data primeira parcea","segunda parcela", "data segunda parcela","total"};
	@SuppressWarnings("rawtypes")
	private Class[] columnClass = {Pagamento.class,Pagamento.class,Pagamento.class,Pagamento.class,Pagamento.class,Pagamento.class};
	
	
	public void adicionarCategoria(Pagamento p) {
		Object[] row = new Object[getColumnCount()];
		row[0] = p.getCliente();
		row[1] = p.getValorPago1();
		row[2] = p.getDataPago1();
		row[3] = p.getValorPago2();
		row[4] = p.getDataPago2();
		row[5] = p.getPrecoTotal();
		
		
		
		addRow(row);
	}

	public String getColumnName(int i) {
		return columnName[i];
	}

	public Class<?> getColumnClass(int i) {
		return columnClass[i];
	}

	public int getColumnCount() {
		return columnName.length;
	}

	public boolean isCellEditable(int row, int column) {
		return false;
	}
	
	
	
	
	
	
	
	

}
