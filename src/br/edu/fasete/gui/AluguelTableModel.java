package br.edu.fasete.gui;

import javax.swing.table.DefaultTableModel;

import br.edu.fasete.principais.Aluguel;
import br.edu.fasete.principais.Cliente;


public class AluguelTableModel extends DefaultTableModel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String[] columnName = {"codigo", "data de locação","data de entrega", "preço final"};
	@SuppressWarnings("rawtypes")
	private Class[] columnClass = {Cliente.class,Cliente.class,Cliente.class,Cliente.class};
	
	
	public void adicionarAluguel(Aluguel a) {
		Object[] row = new Object[getColumnCount()];
		row[0] = a.getCodCliente();
		row[1] = a.getDataLoca();
		row[2] = a.getDataEntre();
		row[3] = a.getPrecoTotal();
	
		
		
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
