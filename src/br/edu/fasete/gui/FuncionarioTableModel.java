package br.edu.fasete.gui;

import javax.swing.table.DefaultTableModel;

import br.edu.fasete.principais.Funcionario;




public class FuncionarioTableModel extends DefaultTableModel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String[] columnName = {"nome","login", "CPF","telefone", "bairro","endereco","numero","codigo"};
	@SuppressWarnings("rawtypes")
	private Class[] columnClass = {Funcionario.class,Funcionario.class,Funcionario.class,Funcionario.class,Funcionario.class,Funcionario.class,Funcionario.class,Funcionario.class};
	
	
	public void adicionarCategoria(Funcionario f) {
		Object[] row = new Object[getColumnCount()];
		row[0] = f.getNome();
		row[1] = f.getLogin();
		row[2] = f.getCPF();
		row[3] = f.getTelefone();
		row[4] = f.getBairro();
		row[5] = f.getEndereco();
		row[6] = f.getNumero();
		row[7] = f.getCodFuncionario();
		
		
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
