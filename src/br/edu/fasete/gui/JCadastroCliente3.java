package br.edu.fasete.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.text.MaskFormatter;
import br.edu.fasete.dao.ClienteDaoJdbc;
import br.edu.fasete.dao.Conexao;
import br.edu.fasete.fachada.Fachada;
import br.edu.fasete.principais.Cliente;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JFormattedTextField;

public class JCadastroCliente3 extends JInternalFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ClienteDaoJdbc cli = new ClienteDaoJdbc();
	int srow;
	String svalueCpf;
	String svalueName;
	String vazio;
	Cliente c = new Cliente();
	private JTextField nomeField;
	private JTextField rgField;
	private JTextField enderecoField;
	private JTextField bairroField;
	private JTextField cidadeField;
	private JTextField estadoField;
	private JTextField numeroField;
	private JTabbedPane tabbedPane;
	private JTable tabelaCategoria;
	private JTextField nomeField2;
	private JTextField cpfField2;
	private JTextField rgField2;
	private JTextField cidadeField2;
	private JTextField enderecoField2;
	private JTextField bairroField2;
	private JTextField numeroField2;
	private JTextField telefoneField2;
	private JTextField estadoField2;
	private JTextField pesquisarField;
	private JFormattedTextField telefoneField;
	private JFormattedTextField cpfField;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JCadastroCliente frame = new JCadastroCliente();
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
	
	public JCadastroCliente3() {
		setIconifiable(true);
		setMaximizable(true);
		setClosable(true);
		setBounds(100, 100, 1280, 720);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				//Carregar tabela sempre que alternar para aba de relatÃ³rios
				if(tabbedPane.getSelectedIndex() == 1) {
					carregarTabela();
				}
			}
		});
		getContentPane().setLayout(new BorderLayout(0, 0));
		getContentPane().add(tabbedPane, BorderLayout.CENTER);
		
		JTabbedPane PanelCadastro = new JTabbedPane(JTabbedPane.TOP);
		getContentPane().add(tabbedPane);
		
		try {
			MaskFormatter mascara = new MaskFormatter("###.###.###-##");
			mascara.setPlaceholderCharacter('_');
			
		
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		 
		
		
		try {
			MaskFormatter mascara = new MaskFormatter("(##)####-#####");
			mascara.setPlaceholderCharacter('_');
			
		
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
				
				
				try {
					MaskFormatter mascara = new MaskFormatter("###.###.###-##");
					mascara.setPlaceholderCharacter('_');
					
				
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				 
				
				
				try {
					MaskFormatter mascara = new MaskFormatter("(##)####-####");
					mascara.setPlaceholderCharacter('_');
					
				
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					}
		
		JPanel cadast = new JPanel();
		
		tabbedPane.addTab("Cadastrar Clientes", null, cadast, null);
		tabbedPane.setEnabledAt(0, true);
		cadast.setLayout(null);
		
		JLabel labelnome = new JLabel("Nome");
		labelnome.setBounds(7, 40, 39, 20);
		labelnome.setFont(new Font("Dialog", Font.PLAIN, 15));
		cadast.add(labelnome);
		
		JLabel lblNomeobri = new JLabel("Preenchmento obrigat\u00F3rio");
		lblNomeobri.setBounds(78, 7, 168, 53);
		lblNomeobri.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblNomeobri.setForeground(Color.RED);
		cadast.add(lblNomeobri);
		lblNomeobri.setVisible(false);
		
		JLabel lblcpfobri = new JLabel("Preenchmento obrigat\u00F3rio");
		lblcpfobri.setBounds(78, 101, 168, 53);
		lblcpfobri.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblcpfobri.setForeground(Color.RED);
		cadast.add(lblcpfobri);
		lblcpfobri.setVisible(false);
		
		JLabel lblcidadeobri = new JLabel("Preenchmento obrigat\u00F3rio");
		lblcidadeobri.setBounds(78, 211, 168, 20);
		lblcidadeobri.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblcidadeobri.setForeground(Color.RED);
		cadast.add(lblcidadeobri);
		lblcidadeobri.setVisible(false);
		
		JLabel lblrgobri = new JLabel("Preenchmento obrigat\u00F3rio");
		lblrgobri.setBounds(864, 101, 168, 53);
		lblrgobri.setForeground(Color.RED);
		lblrgobri.setFont(new Font("Dialog", Font.PLAIN, 15));
		cadast.add(lblrgobri);
		lblrgobri.setVisible(false);
		
		JLabel lblestadoobri = new JLabel("Preenchmento obrigat\u00F3rio");
		lblestadoobri.setBounds(864, 211, 168, 20);
		lblestadoobri.setForeground(Color.RED);
		lblestadoobri.setFont(new Font("Dialog", Font.PLAIN, 15));
		cadast.add(lblestadoobri);
		lblestadoobri.setVisible(false);
		
		JLabel lblenderecoobri = new JLabel("Preenchmento obrigat\u00F3rio");
		lblenderecoobri.setBounds(78, 269, 168, 54);
		lblenderecoobri.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblenderecoobri.setForeground(Color.RED);
		cadast.add(lblenderecoobri);
		lblenderecoobri.setVisible(false);
		
		JLabel lblNumero = new JLabel("numero");
		lblNumero.setBounds(727, 303, 50, 20);
		lblNumero.setFont(new Font("Dialog", Font.PLAIN, 15));
		cadast.add(lblNumero);
		
		numeroField = new JTextField();
		numeroField.setBounds(727, 327, 133, 30);
		numeroField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cadast.add(numeroField);
		numeroField.setColumns(10);
		
		
		JLabel lblBairroobri = new JLabel("Preenchmento obrigat\u00F3rio");
		lblBairroobri.setBounds(78, 361, 168, 56);
		lblBairroobri.setForeground(Color.RED);
		lblBairroobri.setFont(new Font("Dialog", Font.PLAIN, 15));
		cadast.add(lblBairroobri);
		lblBairroobri.setVisible(false);
				
		try {
			MaskFormatter mascara = new MaskFormatter("(##)####-####");
			mascara.setPlaceholderCharacter('_');
		
			telefoneField = new JFormattedTextField(mascara);
			telefoneField.setFont(new Font("Tahoma", Font.PLAIN, 14));
			telefoneField.setBounds(432, 463, 380, 30);
			cadast.add(telefoneField);
			
		
		} catch (ParseException e1) {
		
			e1.printStackTrace();
			}
		
				JButton btnSalvar = new JButton("Salvar");
				btnSalvar.setBounds(250, 520, 71, 27);
				btnSalvar.setFont(new Font("Tahoma", Font.PLAIN, 15));
				cadast.add(btnSalvar);
				nomeField = new JTextField();
				nomeField.setBounds(7, 64, 1245, 33);
				nomeField.setFont(new Font("Tahoma", Font.PLAIN, 15));
				cadast.add(nomeField);
				nomeField.setColumns(10);
				try {
					MaskFormatter mascara = new MaskFormatter("###.###.###-##");
					mascara.setPlaceholderCharacter('_');
					cpfField = new JFormattedTextField(mascara);
					cpfField.setFont(new Font("Tahoma", Font.PLAIN, 14));
					cpfField.setBounds(20, 177, 380, 30);
					cadast.add(cpfField);
					
				
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				 
				try {
					MaskFormatter mascara = new MaskFormatter("###.###.###-##");
					mascara.setPlaceholderCharacter('_');
					
				
				} catch (ParseException e1) {
					
					e1.printStackTrace();
				}
					
					
					JLabel lblCpf = new JLabel("CPF");
					lblCpf.setBounds(7, 134, 30, 20);
					lblCpf.setFont(new Font("Dialog", Font.PLAIN, 15));
					cadast.add(lblCpf);
					
					rgField = new JTextField();
					rgField.setBounds(620, 158, 632, 30);
					rgField.setFont(new Font("Tahoma", Font.PLAIN, 15));
					cadast.add(rgField);
					rgField.setColumns(10);
					
					JLabel lblRg = new JLabel("RG");
					lblRg.setBounds(620, 134, 85, 20);
					lblRg.setFont(new Font("Dialog", Font.PLAIN, 15));
					cadast.add(lblRg);
					
					JLabel lblEndereo = new JLabel("Endere\u00E7o");
					lblEndereo.setBounds(7, 303, 63, 20);
					lblEndereo.setFont(new Font("Dialog", Font.PLAIN, 15));
					cadast.add(lblEndereo);
					
					JLabel lbltelefoneobri = new JLabel("Preenchmento obrigat\u00F3rio");
					lbltelefoneobri.setBounds(864, 361, 168, 56);
					lbltelefoneobri.setFont(new Font("Dialog", Font.PLAIN, 15));
					lbltelefoneobri.setForeground(Color.RED);
					cadast.add(lbltelefoneobri);
					lbltelefoneobri.setVisible(false);
		
					
					enderecoField = new JTextField();
					enderecoField.setBounds(7, 327, 698, 30);
					enderecoField.setFont(new Font("Tahoma", Font.PLAIN, 15));
					cadast.add(enderecoField);
					enderecoField.setColumns(10);
					
					JLabel lblBairro = new JLabel("Bairro");
					lblBairro.setBounds(7, 397, 63, 20);
					lblBairro.setFont(new Font("Dialog", Font.PLAIN, 15));
					cadast.add(lblBairro);
					
					bairroField = new JTextField();
					bairroField.setBounds(7, 421, 574, 31);
					bairroField.setFont(new Font("Tahoma", Font.PLAIN, 15));
					cadast.add(bairroField);
					bairroField.setColumns(10);
					
					JLabel lblCidade = new JLabel("Cidade");
					lblCidade.setBounds(7, 211, 46, 20);
					lblCidade.setFont(new Font("Dialog", Font.PLAIN, 15));
					cadast.add(lblCidade);
					
					JLabel lblEstado = new JLabel("Estado");
					lblEstado.setBounds(620, 211, 85, 20);
					lblEstado.setFont(new Font("Dialog", Font.PLAIN, 15));
					cadast.add(lblEstado);
					
					cidadeField = new JTextField();
					cidadeField.setBounds(7, 235, 574, 30);
					cidadeField.setFont(new Font("Tahoma", Font.PLAIN, 15));
					cadast.add(cidadeField);
					cidadeField.setColumns(10);
					
					estadoField = new JTextField();
					estadoField.setBounds(620, 235, 632, 30);
					estadoField.setFont(new Font("Tahoma", Font.PLAIN, 15));
					cadast.add(estadoField);
					estadoField.setColumns(10);
					
					cadast.addKeyListener(new KeyAdapter() {
						@Override
						public void keyTyped(KeyEvent arg0) {

							
						}
						@Override
						public void keyReleased(KeyEvent arg0) {

						}
					});
					
	
					
					//------------------------SALVAR--------------------------------------
					
					btnSalvar.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
Cliente c = new Cliente();
if(nomeField.getText().isEmpty()){
	lblNomeobri.setVisible(true);
}else{
	lblNomeobri.setVisible(false);

}if(cpfField.getText().isEmpty()){
lblcpfobri.setVisible(true);
}else{
lblcpfobri.setVisible(false);

}if(rgField.getText().isEmpty()){
lblrgobri.setVisible(true);
}else{
lblrgobri.setVisible(false);

}if(telefoneField.getText().isEmpty()){
lbltelefoneobri.setVisible(true);
}else{
lbltelefoneobri.setVisible(false);

}if(bairroField.getText().isEmpty()){
lblBairroobri.setVisible(true);
}else{
lblBairroobri.setVisible(false);

}if(estadoField.getText().isEmpty()){
lblestadoobri.setVisible(true);
}else{
lblestadoobri.setVisible(false);

}if(enderecoField.getText().isEmpty()){
lblenderecoobri.setVisible(true);
}else{
lblenderecoobri.setVisible(false);

}
/*boolean ehNumero = true;

try{
    Integer.parseInt(telefoneField.getText());
}catch(Exception e2){
    ehNumero = false;
}			

if(ehNumero == false){
	JOptionPane.showMessageDialog(null, "Somente números no campo telefone. ");
}		*/
							c.setNome(nomeField.getText()); 
							c.setCPF(cpfField.getText());
							c.setRG(rgField.getText());
							c.setTelefone(telefoneField.getText());
							c.setBairro(bairroField.getText());
							c.setCidade(cidadeField.getText());
							c.setEstado(estadoField.getText());
							c.setNumero(numeroField.getText());
							c.setEndereco(enderecoField.getText());
							
							
							
							 String cpf = "";
								   PreparedStatement stmt;
								try {
									stmt = (PreparedStatement) Conexao.getConnection()
									    .prepareStatement("select cpf from loja.Cliente ");
							
									ResultSet rs = stmt.executeQuery();
									while(rs.next()) {
										 cpf = rs.getString("CPF");
										 
										 
										 if(cpf != c.getCPF() && c.getCPF().length() == 14 ){

												if(nomeField.getText().isEmpty() || cpfField.getText().isEmpty() || rgField.getText().isEmpty() || telefoneField.getText().isEmpty() || bairroField.getText().isEmpty() || estadoField.getText().isEmpty() || enderecoField.getText().isEmpty()){
													
												}else{
													
													 
													  cpf = "";
														   
														try {
															stmt = (PreparedStatement) Conexao.getConnection()
															    .prepareStatement("select cpf from loja.Cliente ");
													
															 rs = stmt.executeQuery();
															while(rs.next()) {
																 cpf = rs.getString("CPF");
																
															}	} catch (SQLException e1) {
																// TODO Auto-generated catch block
																e1.printStackTrace();
															}
															if(cpf != c.getCPF() && c.getCPF().length() == 14 ){
													Fachada.getInstancia().InserirCliente(c);
															}else{
																JOptionPane.showMessageDialog(null, "CPF já cadastrado ou inválido");
																
															}
												}
									
											}else{
												JOptionPane.showMessageDialog(null, "CPF já cadastrado ou inválido. ");
												
											}
										
									}	} catch (SQLException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
									
						
						
							
							
							
							
						}
					});
					
					
					JButton btnCancelar = new JButton("Cancelar");
					btnCancelar.setBounds(124, 520, 87, 27);
					btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 15));
					cadast.add(btnCancelar);
					
					JButton btnLimparTela = new JButton("Limpar tela");
					btnLimparTela.setBounds(7, 520, 103, 27);
					btnLimparTela.setFont(new Font("Tahoma", Font.PLAIN, 15));
					btnLimparTela.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							nomeField.setText("");
							cpfField.setText("");
							rgField.setText("");
							cidadeField.setText("");
							estadoField.setText("");
							enderecoField.setText("");
							numeroField.setText("");
							bairroField.setText("");
							telefoneField.setText("");
							
						}
					});
					cadast.add(btnLimparTela);
					
					JLabel lblTelefone = new JLabel("Telefone");
					lblTelefone.setBounds(727, 397, 56, 20);
					lblTelefone.setFont(new Font("Dialog", Font.PLAIN, 15));
					cadast.add(lblTelefone);
					
					JLabel lbltelefoneobri1 = new JLabel("Preenchmento obrigat\u00F3rio");
					lbltelefoneobri1.setBounds(864, 361, 168, 56);
					lbltelefoneobri1.setFont(new Font("Dialog", Font.PLAIN, 15));
					lbltelefoneobri1.setForeground(Color.RED);
					cadast.add(lbltelefoneobri1);
					lbltelefoneobri1.setVisible(false);
		
		JButton btnExculir = new JButton("Exculir");
		btnExculir.setBounds(218, 556, 124, 34);
		btnExculir.setEnabled(false);
		
				JButton btnEditar = new JButton("Editar");
				btnEditar.setBounds(400, 556, 124, 34);
				btnEditar.setEnabled(false);
				tabelaCategoria = new JTable(new ClienteTableModel());
				tabelaCategoria.addMouseListener(new MouseAdapter() {
					public void mouseReleased(MouseEvent arg0) {
						srow = tabelaCategoria.getSelectedRow();
						svalueCpf = (String) tabelaCategoria.getValueAt(srow, 1);
						svalueName = (String) tabelaCategoria.getValueAt(srow, 0);
						
					}
					
				});
				
				
				tabelaCategoria.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				JScrollPane scrollPane = new JScrollPane(tabelaCategoria);
				scrollPane.setBounds(0, 11, 1249, 504);
				scrollPane.addMouseListener(new MouseAdapter() {
				});
				
		tabelaCategoria.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount() == 2) {
				srow = tabelaCategoria.getSelectedRow();
				svalueCpf = (String) tabelaCategoria.getValueAt(srow, 1);
				svalueName = (String) tabelaCategoria.getValueAt(srow, 0);
				c.setNome(svalueName);
				int opcao = JOptionPane.showConfirmDialog(null, "deseja editar " + svalueName + "?", "Aviso", JOptionPane.YES_NO_OPTION);
				String pesq = null;
				if (opcao == 0){
				Fachada.getInstancia().BuscarClienteCPF(c,pesq);
				nomeField2.setText(c.getNome());
				cpfField2.setText(""+c.getCPF());
				rgField2.setText(c.getRG());
				cidadeField2.setText(c.getCidade());
				estadoField2.setText(c.getEstado());
				enderecoField2.setText(c.getEndereco());
				numeroField2.setText(""+c.getNumero());
				bairroField2.setText(c.getBairro());
				telefoneField2.setText(""+c.getTelefone());
				tabbedPane.setSelectedIndex(2);
			} }else {
			
			}
			}
		});
		
		
			
		tabelaCategoria.addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent e) {
				
				btnEditar.setEnabled(true);
				btnExculir.setEnabled(true);
				
			}
			});
		
	
		
		
		
		
	
		
		
		
		
		JPanel exibirpanel = new JPanel();
		tabbedPane.addTab("Exibir Clientes", null, exibirpanel, null);
		exibirpanel.setLayout(null);
		exibirpanel.add(scrollPane);
		
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c.setNome(svalueName);
				int opcao = JOptionPane.showConfirmDialog(null, "deseja editar " + svalueName + "?", "Aviso", JOptionPane.YES_NO_OPTION);
				String pesq = null;
				if (opcao == 0){
				Fachada.getInstancia().BuscarClienteCPF(c,pesq);
				nomeField2.setText(c.getNome());
				cpfField2.setText(""+c.getCPF());
				rgField2.setText(c.getRG());
				cidadeField2.setText(c.getCidade());
				estadoField2.setText(c.getEstado());
				enderecoField2.setText(c.getEndereco());
				numeroField2.setText(""+c.getNumero());
				bairroField2.setText(c.getBairro());
				telefoneField2.setText(""+c.getTelefone());
			
				tabbedPane.setSelectedIndex(2);
			} else {
				   
			}
			}
		});
		exibirpanel.add(btnEditar);
		
		
		btnExculir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				c.setCPF(svalueCpf);
				
				
				int opcao = JOptionPane.showConfirmDialog(null, "Realmente deseja excluir " + svalueName + "?", "Aviso", JOptionPane.YES_NO_OPTION);

				if (opcao == 0){
					Fachada.getInstancia().ExcluirCliente(c);
					carregarTabela();
				
				} else {
				   
				}
				
				
				
			}
		});
		exibirpanel.add(btnExculir);
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.setBounds(32, 556, 124, 34);
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				carregarTabela();
			}
		});
		exibirpanel.add(btnAtualizar);
		
		JPanel editPanel = new JPanel();
		tabbedPane.addTab("Editar Clientes", null, editPanel, null);
		editPanel.setLayout(null);
		
		JLabel nomelabel2 = new JLabel("Nome");
		nomelabel2.setBounds(7, 30, 39, 19);
		nomelabel2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		editPanel.add(nomelabel2);
		
		nomeField2 = new JTextField();
		nomeField2.setBounds(7, 53, 1245, 33);
		nomeField2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		nomeField2.setColumns(10);
		editPanel.add(nomeField2);
		
		cpfField2 = new JTextField();
		cpfField2.setBounds(7, 132, 578, 33);
		cpfField2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cpfField2.setColumns(10);
		editPanel.add(cpfField2);
		
		JLabel cpflabel2 = new JLabel("CPF");
		cpflabel2.setBounds(7, 109, 25, 19);
		cpflabel2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		editPanel.add(cpflabel2);
		
		JLabel rglabel2 = new JLabel("RG");
		rglabel2.setBounds(610, 109, 44, 19);
		rglabel2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		editPanel.add(rglabel2);
		
		rgField2 = new JTextField();
		rgField2.setBounds(610, 132, 642, 33);
		rgField2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		rgField2.setColumns(10);
		editPanel.add(rgField2);
		
		JLabel estadolabel2 = new JLabel("Estado");
		estadolabel2.setBounds(610, 191, 44, 19);
		estadolabel2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		editPanel.add(estadolabel2);
		
		JLabel cidadelabel2 = new JLabel("Cidade");
		cidadelabel2.setBounds(7, 191, 43, 19);
		cidadelabel2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		editPanel.add(cidadelabel2);
		
		cidadeField2 = new JTextField();
		cidadeField2.setBounds(7, 214, 578, 33);
		cidadeField2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cidadeField2.setColumns(10);
		editPanel.add(cidadeField2);
		
		enderecoField2 = new JTextField();
		enderecoField2.setBounds(7, 298, 744, 33);
		enderecoField2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		enderecoField2.setColumns(10);
		editPanel.add(enderecoField2);
		
		JLabel enderecolabel2 = new JLabel("Endere\u00E7o");
		enderecolabel2.setBounds(7, 275, 71, 19);
		enderecolabel2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		editPanel.add(enderecolabel2);
		
		JLabel bairrolabel2 = new JLabel("Bairro");
		bairrolabel2.setBounds(7, 357, 37, 19);
		bairrolabel2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		editPanel.add(bairrolabel2);
		
		bairroField2 = new JTextField();
		bairroField2.setBounds(7, 380, 647, 33);
		bairroField2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		bairroField2.setColumns(10);
		editPanel.add(bairroField2);
		
		JLabel numerolabel2 = new JLabel("numero");
		numerolabel2.setBounds(778, 275, 50, 19);
		numerolabel2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		editPanel.add(numerolabel2);
		
		numeroField2 = new JTextField();
		numeroField2.setBounds(778, 298, 136, 33);
		numeroField2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		numeroField2.setColumns(10);
		editPanel.add(numeroField2);
		
		telefoneField2 = new JTextField();
		telefoneField2.setBounds(674, 380, 136, 33);
		telefoneField2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		telefoneField2.setColumns(10);
		editPanel.add(telefoneField2);
		
		JLabel telefonelabel2 = new JLabel("Telefone");
		telefonelabel2.setBounds(674, 357, 77, 19);
		telefonelabel2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		editPanel.add(telefonelabel2);
		
		estadoField2 = new JTextField();
		estadoField2.setBounds(610, 214, 642, 33);
		estadoField2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		estadoField2.setColumns(10);
		editPanel.add(estadoField2);
		
		JButton button = new JButton("Cancelar");
		button.setBounds(269, 523, 87, 27);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		button.setFont(new Font("Tahoma", Font.PLAIN, 15));
		editPanel.add(button);
		
		JButton button_1 = new JButton("Salvar");
		button_1.setBounds(7, 523, 71, 27);
		button_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				c.setNome(nomeField2.getText()); 
				c.setCPF(cpfField2.getText());
				c.setRG(rgField2.getText());
				c.setTelefone(telefoneField2.getText());
				c.setBairro(bairroField2.getText());
				c.setCidade(cidadeField2.getText());
				c.setEstado(estadoField2.getText());
				c.setNumero(numeroField2.getText());
				c.setEndereco(enderecoField2.getText());
				String cpf = c.getCPF();
				Fachada.getInstancia().AtualizarCliente(c,svalueCpf);
			}
		});
		editPanel.add(button_1);
		
		pesquisarField = new JTextField();
		pesquisarField.setBounds(7, 461, 230, 33);
		pesquisarField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		editPanel.add(pesquisarField);
		pesquisarField.setColumns(10);
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.setBounds(269, 461, 93, 33);
		btnPesquisar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//c.setCPF(Integer.parseInt((pesquisarField.getText())));
				c.setNome(pesquisarField.getText());
				
				nomeField2.setText(c.getNome());
				cpfField2.setText(""+c.getCPF());
				rgField2.setText(c.getRG());
				cidadeField2.setText(c.getCidade());
				estadoField2.setText(c.getEstado());
				enderecoField2.setText(c.getEndereco());
				numeroField2.setText(""+c.getNumero());
				bairroField2.setText(c.getBairro());
				telefoneField2.setText(""+c.getTelefone());
				
			}
		});
		editPanel.add(btnPesquisar);
		
		JLabel lblPesquisarPorNome = new JLabel("Pesquisar por nome ou CPF");
		lblPesquisarPorNome.setBounds(7, 438, 180, 19);
		lblPesquisarPorNome.setFont(new Font("Tahoma", Font.PLAIN, 15));
		editPanel.add(lblPesquisarPorNome);
		
		JButton btnLimpparTela = new JButton("Limpar tela");
		btnLimpparTela.setBounds(111, 523, 126, 27);
		btnLimpparTela.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnLimpparTela.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nomeField2.setText("");
				cpfField2.setText("");
				rgField2.setText("");
				cidadeField2.setText("");
				estadoField2.setText("");
				enderecoField2.setText("");
				numeroField2.setText("");
				bairroField2.setText("");
				telefoneField2.setText("");
				pesquisarField.setText("");
			}
		});
		editPanel.add(btnLimpparTela);
	

	}
	public void carregarTabela() {
		ClienteTableModel tableModel = (ClienteTableModel) tabelaCategoria.getModel();
		tableModel.setRowCount(0);
		for(Cliente cat : Fachada.getInstancia().listarClientes()) {
			tableModel.adicionarCategoria(cat);
		}
	}
}
