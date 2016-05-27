package br.edu.fasete.gui;

import javax.swing.table.DefaultTableModel;
import br.edu.fasete.principais.Roupa;

public class RoupaTableModel extends DefaultTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String[] columnName = {"codigo","Tipo", "Modelo","Tamanho","Gênero","Cor","Preço"};
	@SuppressWarnings("rawtypes")
	private Class[] columnClass = {Roupa.class,Roupa.class,Roupa.class,Roupa.class,Roupa.class,Roupa.class,Roupa.class};
	
	
	public void adicionarCategoria(Roupa r) {
		Object[] row = new Object[getColumnCount()];
		
		row[0] = r.getCodRoupa();
		row[1] = r.getTipo();
		row[2] = r.getModelo();
		row[3] = r.getTamanho();
		row[4] = r.getGenero();
		row[5] = r.getCor();
		row[6] = r.getPreco();
		
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