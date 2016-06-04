package br.edu.fasete.gui;

import java.awt.EventQueue;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import br.edu.fasete.dao.RoupaDaoJdbc;
import br.edu.fasete.principais.Roupa;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JCadastroRoupa33 extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textFieldTipo;
	private JTextField textFieldGenero;
	private JTextField textFieldModelo;
	private JTextField textFieldTamanho;
	private JTextField textFieldCor;
	private JTextField textFieldDisponibilidade;
	private JTextField textFieldPreco;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JCadastroRoupa33 frame = new JCadastroRoupa33();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JCadastroRoupa33() {
		setBounds(100, 100, 860, 640);
		getContentPane().setLayout(null);
		
		JLabel lblTipo = new JLabel("Tipo");
		lblTipo.setBounds(10, 11, 46, 14);
		getContentPane().add(lblTipo);
		
		textFieldTipo = new JTextField();
		textFieldTipo.setBounds(10, 36, 86, 20);
		getContentPane().add(textFieldTipo);
		textFieldTipo.setColumns(10);
		
		JLabel lblGnero = new JLabel("G\u00EAnero");
		lblGnero.setBounds(10, 67, 46, 14);
		getContentPane().add(lblGnero);
		
		textFieldGenero = new JTextField();
		textFieldGenero.setBounds(10, 92, 86, 20);
		getContentPane().add(textFieldGenero);
		textFieldGenero.setColumns(10);
		
		JLabel lblModelo = new JLabel("Modelo");
		lblModelo.setBounds(10, 135, 46, 14);
		getContentPane().add(lblModelo);
		
		textFieldModelo = new JTextField();
		textFieldModelo.setBounds(10, 160, 86, 20);
		getContentPane().add(textFieldModelo);
		textFieldModelo.setColumns(10);
		
		JLabel lblTamanho = new JLabel("Tamanho");
		lblTamanho.setBounds(10, 198, 46, 14);
		getContentPane().add(lblTamanho);
		
		textFieldTamanho = new JTextField();
		textFieldTamanho.setBounds(10, 223, 86, 20);
		getContentPane().add(textFieldTamanho);
		textFieldTamanho.setColumns(10);
		
		JLabel lblCor = new JLabel("Cor");
		lblCor.setBounds(10, 264, 46, 14);
		getContentPane().add(lblCor);
		
		textFieldCor = new JTextField();
		textFieldCor.setBounds(10, 289, 86, 20);
		getContentPane().add(textFieldCor);
		textFieldCor.setColumns(10);
		
		JLabel lblDisponibilidade = new JLabel("Disponibilidade");
		lblDisponibilidade.setBounds(10, 337, 86, 14);
		getContentPane().add(lblDisponibilidade);
		
		textFieldDisponibilidade = new JTextField();
		textFieldDisponibilidade.setBounds(10, 362, 86, 20);
		getContentPane().add(textFieldDisponibilidade);
		textFieldDisponibilidade.setColumns(10);
		
		JLabel lblPreo = new JLabel("Pre\u00E7o");
		lblPreo.setBounds(10, 410, 46, 14);
		getContentPane().add(lblPreo);
		
		textFieldPreco = new JTextField();
		textFieldPreco.setBounds(10, 435, 86, 20);
		getContentPane().add(textFieldPreco);
		textFieldPreco.setColumns(10);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				RoupaDaoJdbc ro = new RoupaDaoJdbc();
				Roupa r = new Roupa();
				r.setCor(textFieldCor.getText());
				r.setDisponibilidade(Boolean.parseBoolean(textFieldDisponibilidade.getText()));
				r.setGenero(textFieldGenero.getText());
				r.setModelo(textFieldModelo.getText());
				r.setPreco(Float.parseFloat(textFieldPreco.getText()));
				r.setTamanho(textFieldTamanho.getText());
				r.setTipo(textFieldTipo.getText());
				ro.InserirRoupa(r);
			}
		});
		btnSalvar.setBounds(10, 530, 89, 23);
		getContentPane().add(btnSalvar);

	}
}
