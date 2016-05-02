package br.edu.fasete.gui;

import javax.swing.table.DefaultTableModel;

import br.edu.fasete.principais.Cliente;


public class ClienteTableModel extends DefaultTableModel{
	private String[] columnName = {"nome", "CPF","RG","estado","cidade","bairro","endereco","numero","telefone"};
	private Class[] columnClass = {Cliente.class,Cliente.class,Cliente.class,Cliente.class,Cliente.class,Cliente.class,Cliente.class,Cliente.class,Cliente.class};
	
	
	public void adicionarCategoria(Cliente c) {
		Object[] row = new Object[getColumnCount()];
		row[0] = c.getNome();
		row[1] = c.getCPF();
		row[2] = c.getRG();
		row[3] = c.getEstado();
		row[4] = c.getCidade();
		row[5] = c.getBairro();
		row[6] = c.getEndereco();
		row[7] = c.getNumero();
		row[8] = c.getTelefone();
		
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
