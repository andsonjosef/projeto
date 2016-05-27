package br.edu.fasete.gui;

import javax.swing.table.DefaultTableModel;

import br.edu.fasete.principais.Cliente;


public class ClienteTableModel extends DefaultTableModel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String[] columnName = {"nome", "CPF","telefone", "bairro","endereco","numero"};
	@SuppressWarnings("rawtypes")
	private Class[] columnClass = {Cliente.class,Cliente.class,Cliente.class,Cliente.class,Cliente.class,Cliente.class};
	
	
	public void adicionarCategoria(Cliente c) {
		Object[] row = new Object[getColumnCount()];
		row[0] = c.getNome();
		row[1] = c.getCPF();
		row[2] = c.getTelefone();
		row[3] = c.getBairro();
		row[4] = c.getEndereco();
		row[5] = c.getNumero();
		
		
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
