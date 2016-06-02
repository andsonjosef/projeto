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


public class JCadastroCliente extends JInternalFrame {
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
	private JFormattedTextField cpfpesqField;
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
	
	@SuppressWarnings("unused")
	public JCadastroCliente() {
		setIconifiable(true);
		setMaximizable(true);
		setClosable(true);
		setBounds(100, 100, 860, 640);
		
		
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
			
			e1.printStackTrace();
		}
		 
		
		
		try {
			MaskFormatter mascara = new MaskFormatter("(##)####-#####");
			mascara.setPlaceholderCharacter('_');
			
		
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		
		JButton btnExculir = new JButton("Exculir");
		btnExculir.setEnabled(false);

		JButton btnEditar = new JButton("Editar");
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
		scrollPane.addMouseListener(new MouseAdapter() {
		});
				
		tabelaCategoria.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount() == 2) {
				srow = tabelaCategoria.getSelectedRow();
				svalueCpf = (String) tabelaCategoria.getValueAt(srow, 1);
				svalueName = (String) tabelaCategoria.getValueAt(srow, 0);
				c.setNome(svalueName);
				
				String pesq = "";
				pesq = svalueName;
				
				Fachada.getInstancia().BuscarClientenome(c,pesq);
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
			
			}
			}
		});
		scrollPane.setBounds(0, 11, 839, 504);
		
		
			
		tabelaCategoria.addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent e) {
				
				btnEditar.setEnabled(true);
				btnExculir.setEnabled(true);
				
			}
			});
		
		JPanel cadast = new JPanel();
		
		tabbedPane.addTab("Cadastrar Clientes", null, cadast, null);
		tabbedPane.setEnabledAt(0, true);
		cadast.setLayout(null);
		
		JLabel labelnome = new JLabel("Nome");
		labelnome.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labelnome.setBounds(18, 35, 46, 14);
		cadast.add(labelnome);
		
		JLabel lblNomeobri = new JLabel("Preenchmento obrigat\u00F3rio");
		lblNomeobri.setFont(new Font("Arial Black", Font.BOLD, 14));
		lblNomeobri.setForeground(Color.RED);
		lblNomeobri.setBounds(74, 35, 341, 14);
		cadast.add(lblNomeobri);
		lblNomeobri.setVisible(false);
		
		JLabel lblcpfobri = new JLabel("Preenchmento obrigat\u00F3rio");
		lblcpfobri.setFont(new Font("Arial Black", Font.BOLD, 14));
		lblcpfobri.setForeground(Color.RED);
		lblcpfobri.setBounds(104, 145, 245, 14);
		cadast.add(lblcpfobri);
		lblcpfobri.setVisible(false);
		
		JLabel lblcidadeobri = new JLabel("Preenchmento obrigat\u00F3rio");
		lblcidadeobri.setFont(new Font("Arial Black", Font.BOLD, 14));
		lblcidadeobri.setForeground(Color.RED);
		lblcidadeobri.setBounds(104, 248, 259, 14);
		cadast.add(lblcidadeobri);
		lblcidadeobri.setVisible(false);
		
		JLabel lblrgobri = new JLabel("Preenchmento obrigat\u00F3rio");
		lblrgobri.setForeground(Color.RED);
		lblrgobri.setFont(new Font("Arial Black", Font.BOLD, 14));
		lblrgobri.setBounds(510, 145, 230, 14);
		cadast.add(lblrgobri);
		lblrgobri.setVisible(false);
		
		JLabel lblestadoobri = new JLabel("Preenchmento obrigat\u00F3rio");
		lblestadoobri.setForeground(Color.RED);
		lblestadoobri.setFont(new Font("Arial Black", Font.BOLD, 14));
		lblestadoobri.setBounds(510, 251, 242, 14);
		cadast.add(lblestadoobri);
		lblestadoobri.setVisible(false);
		
		JLabel lblenderecoobri = new JLabel("Preenchmento obrigat\u00F3rio");
		lblenderecoobri.setFont(new Font("Arial Black", Font.BOLD, 14));
		lblenderecoobri.setForeground(Color.RED);
		lblenderecoobri.setBounds(104, 347, 244, 14);
		cadast.add(lblenderecoobri);
		lblenderecoobri.setVisible(false);
		
		
		JLabel lblBairroobri = new JLabel("Preenchmento obrigat\u00F3rio");
		lblBairroobri.setForeground(Color.RED);
		lblBairroobri.setFont(new Font("Arial Black", Font.BOLD, 14));
		lblBairroobri.setBounds(104, 438, 230, 14);
		cadast.add(lblBairroobri);
		lblBairroobri.setVisible(false);
		
		JLabel lbltelefoneobri = new JLabel("Preenchmento obrigat\u00F3rio");
		lbltelefoneobri.setFont(new Font("Arial Black", Font.BOLD, 14));
		lbltelefoneobri.setForeground(Color.RED);
		lbltelefoneobri.setBounds(510, 438, 299, 14);
		cadast.add(lbltelefoneobri);
		lbltelefoneobri.setVisible(false);
		
				JButton btnSalvar = new JButton("Salvar");
				btnSalvar.setBounds(685, 537, 124, 34);
				cadast.add(btnSalvar);
				nomeField = new JTextField();
				nomeField.setFont(new Font("Tahoma", Font.PLAIN, 14));
				
				nomeField.setBounds(18, 74, 791, 30);
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
				
				
				JLabel lblCpf = new JLabel("CPF");
				lblCpf.setFont(new Font("Tahoma", Font.PLAIN, 16));
				lblCpf.setBounds(27, 145, 46, 14);
				cadast.add(lblCpf);
				
				rgField = new JTextField();
				rgField.setFont(new Font("Tahoma", Font.PLAIN, 14));
				rgField.setBounds(432, 177, 380, 30);
				cadast.add(rgField);
				rgField.setColumns(10);
				
				JLabel lblRg = new JLabel("RG");
				lblRg.setFont(new Font("Tahoma", Font.PLAIN, 16));
				lblRg.setBounds(432, 145, 46, 14);
				cadast.add(lblRg);
				
				JLabel lblTelefone = new JLabel("Telefone");
				lblTelefone.setFont(new Font("Tahoma", Font.PLAIN, 16));
				lblTelefone.setBounds(432, 438, 68, 14);
				cadast.add(lblTelefone);
				
				JLabel lblEndereo = new JLabel("Endere\u00E7o");
				lblEndereo.setFont(new Font("Tahoma", Font.PLAIN, 16));
				lblEndereo.setBounds(20, 346, 81, 14);
				cadast.add(lblEndereo);
				
				enderecoField = new JTextField();
				enderecoField.setFont(new Font("Tahoma", Font.PLAIN, 14));
				enderecoField.setBounds(20, 371, 655, 30);
				cadast.add(enderecoField);
				enderecoField.setColumns(10);
				
				JLabel lblBairro = new JLabel("Bairro");
				lblBairro.setFont(new Font("Tahoma", Font.PLAIN, 16));
				lblBairro.setBounds(27, 439, 67, 14);
				cadast.add(lblBairro);
				
				bairroField = new JTextField();
				bairroField.setFont(new Font("Tahoma", Font.PLAIN, 14));
				bairroField.setBounds(20, 463, 380, 30);
				cadast.add(bairroField);
				bairroField.setColumns(10);
				
				JLabel lblCidade = new JLabel("Cidade");
				lblCidade.setFont(new Font("Tahoma", Font.PLAIN, 16));
				lblCidade.setBounds(20, 245, 60, 20);
				cadast.add(lblCidade);
				
				JLabel lblEstado = new JLabel("Estado");
				lblEstado.setFont(new Font("Tahoma", Font.PLAIN, 16));
				lblEstado.setBounds(432, 251, 68, 14);
				cadast.add(lblEstado);
				
				cidadeField = new JTextField();
				cidadeField.setFont(new Font("Tahoma", Font.PLAIN, 14));
				cidadeField.setBounds(20, 276, 380, 30);
				cadast.add(cidadeField);
				cidadeField.setColumns(10);
				
				estadoField = new JTextField();
				estadoField.setFont(new Font("Tahoma", Font.PLAIN, 14));
				estadoField.setBounds(432, 276, 380, 30);
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
					@SuppressWarnings("resource")
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
				btnCancelar.setBounds(551, 537, 124, 34);
				cadast.add(btnCancelar);
				
				JLabel lblNumero = new JLabel("numero");
				lblNumero.setFont(new Font("Tahoma", Font.PLAIN, 16));
				lblNumero.setBounds(685, 349, 68, 14);
				cadast.add(lblNumero);
				
				numeroField = new JTextField();
				numeroField.setFont(new Font("Tahoma", Font.PLAIN, 14));
				numeroField.setBounds(685, 371, 124, 30);
				cadast.add(numeroField);
				numeroField.setColumns(10);
				
				JButton btnLimparTela = new JButton("Limpar tela");
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
				btnLimparTela.setBounds(417, 537, 124, 34);
				cadast.add(btnLimparTela);
		
		JPanel exibirpanel = new JPanel();
		tabbedPane.addTab("Exibir Clientes", null, exibirpanel, null);
		exibirpanel.setLayout(null);
		exibirpanel.add(scrollPane);
		
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c.setNome(svalueName);
				int opcao = JOptionPane.showConfirmDialog(null, "deseja editar " + svalueName + "?", "Aviso", JOptionPane.YES_NO_OPTION);
String pesq = "";
				if (opcao == 0){
				Fachada.getInstancia().BuscarClientenome(c,pesq);
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
		btnEditar.setBounds(691, 515, 124, 34);
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
		btnExculir.setBounds(557, 515, 124, 34);
		exibirpanel.add(btnExculir);
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				carregarTabela();
			}
		});
		btnAtualizar.setBounds(423, 515, 124, 34);
		exibirpanel.add(btnAtualizar);
		
		JPanel editPanel = new JPanel();
		tabbedPane.addTab("Editar Clientes", null, editPanel, null);
		editPanel.setLayout(null);
		
		JLabel nomelabel2 = new JLabel("Nome");
		nomelabel2.setBounds(10, 11, 46, 14);
		editPanel.add(nomelabel2);
		
		nomeField2 = new JTextField();
		nomeField2.setEditable(false);
		nomeField2.setColumns(10);
		nomeField2.setBounds(10, 30, 482, 20);
		editPanel.add(nomeField2);
		
		cpfField2 = new JTextField();
		cpfField2.setEditable(false);
		cpfField2.setColumns(10);
		cpfField2.setBounds(10, 82, 230, 20);
		editPanel.add(cpfField2);
		
		JLabel cpflabel2 = new JLabel("CPF");
		cpflabel2.setBounds(10, 61, 46, 14);
		editPanel.add(cpflabel2);
		
		JLabel rglabel2 = new JLabel("RG");
		rglabel2.setBounds(262, 61, 46, 14);
		editPanel.add(rglabel2);
		
		rgField2 = new JTextField();
		rgField2.setEditable(false);
		rgField2.setColumns(10);
		rgField2.setBounds(262, 82, 230, 20);
		editPanel.add(rgField2);
		
		JLabel estadolabel2 = new JLabel("Estado");
		estadolabel2.setBounds(262, 113, 46, 14);
		editPanel.add(estadolabel2);
		
		JLabel cidadelabel2 = new JLabel("Cidade");
		cidadelabel2.setBounds(10, 113, 46, 14);
		editPanel.add(cidadelabel2);
		
		cidadeField2 = new JTextField();
		cidadeField2.setEditable(false);
		cidadeField2.setColumns(10);
		cidadeField2.setBounds(10, 138, 230, 20);
		editPanel.add(cidadeField2);
		
		enderecoField2 = new JTextField();
		enderecoField2.setEditable(false);
		enderecoField2.setColumns(10);
		enderecoField2.setBounds(10, 194, 383, 20);
		editPanel.add(enderecoField2);
		
		JLabel enderecolabel2 = new JLabel("Endere\u00E7o");
		enderecolabel2.setBounds(10, 169, 81, 14);
		editPanel.add(enderecolabel2);
		
		JLabel bairrolabel2 = new JLabel("Bairro");
		bairrolabel2.setBounds(10, 225, 46, 14);
		editPanel.add(bairrolabel2);
		
		bairroField2 = new JTextField();
		bairroField2.setEditable(false);
		bairroField2.setColumns(10);
		bairroField2.setBounds(10, 250, 230, 20);
		editPanel.add(bairroField2);
		
		JLabel numerolabel2 = new JLabel("numero");
		numerolabel2.setBounds(418, 169, 46, 14);
		editPanel.add(numerolabel2);
		
		numeroField2 = new JTextField();
		numeroField2.setEditable(false);
		numeroField2.setColumns(10);
		numeroField2.setBounds(418, 194, 74, 20);
		editPanel.add(numeroField2);
		
		telefoneField2 = new JTextField();
		telefoneField2.setEditable(false);
		telefoneField2.setColumns(10);
		telefoneField2.setBounds(262, 250, 230, 20);
		editPanel.add(telefoneField2);
		
		JLabel telefonelabel2 = new JLabel("Telefone");
		telefonelabel2.setBounds(262, 225, 46, 14);
		editPanel.add(telefonelabel2);
		
		estadoField2 = new JTextField();
		estadoField2.setEditable(false);
		estadoField2.setColumns(10);
		estadoField2.setBounds(262, 138, 230, 20);
		editPanel.add(estadoField2);
		
		JButton button = new JButton("Cancelar");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				numeroField2.setEditable(false);
				nomeField2.setEditable(false);
				cpfField2.setEditable(false);
				rgField2.setEditable(false);
				cidadeField2.setEditable(false);
				estadoField2.setEditable(false);
				enderecoField2.setEditable(false);
				bairroField2.setEditable(false);
				telefoneField2.setEditable(false);
				
			}
		});
		button.setBounds(391, 337, 89, 23);
		editPanel.add(button);
		
		JButton button_1 = new JButton("Salvar");
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
		button_1.setBounds(391, 368, 89, 23);
		editPanel.add(button_1);
		
		pesquisarField = new JTextField();
		pesquisarField.setBounds(10, 306, 251, 20);
		editPanel.add(pesquisarField);
		pesquisarField.setColumns(10);
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String pesq;
				pesq = pesquisarField.getText();
				Fachada.getInstancia().BuscarClientenome(c,pesq);
				
				cpfField2.setText(""+c.getCPF());
				nomeField2.setText(c.getNome());
				rgField2.setText(c.getRG());
				cidadeField2.setText(c.getCidade());
				estadoField2.setText(c.getEstado());
				enderecoField2.setText(c.getEndereco());
				numeroField2.setText(""+c.getNumero());
				bairroField2.setText(c.getBairro());
				telefoneField2.setText(""+c.getTelefone());
				
				 c.setNome("");
				 c.setCPF("");
				 c.setRG("");
				 c.setTelefone("");
				 c.setEstado("");
				 c.setCidade("");
				 c.setBairro("");
				 c.setNumero("");
				 c.setEndereco("");
				 if(nomeField2.getText().isEmpty()){
					 JOptionPane.showMessageDialog(null,"Cliente não encontrado");
				 }
				
			}
		});
		btnPesquisar.setBounds(271, 305, 100, 23);
		editPanel.add(btnPesquisar);
		
		JLabel lblPesquisarPorNome = new JLabel("Pesquisar por nome");
		lblPesquisarPorNome.setBounds(10, 281, 210, 14);
		editPanel.add(lblPesquisarPorNome);
		
		JButton btnLimpparTela = new JButton("Limpar tela");
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
		btnLimpparTela.setBounds(262, 402, 111, 23);
		editPanel.add(btnLimpparTela);
		
		
		JLabel lblPesquisarPorCpf = new JLabel("Pesquisar por CPF");
		lblPesquisarPorCpf.setBounds(10, 337, 129, 14);
		editPanel.add(lblPesquisarPorCpf);
		
		try {
			MaskFormatter mascara = new MaskFormatter("###.###.###-##");
			mascara.setPlaceholderCharacter('_');
			cpfpesqField = new JFormattedTextField(mascara);
			cpfpesqField.setFont(new Font("Tahoma", Font.PLAIN, 14));
			cpfpesqField.setBounds(10, 367, 251, 20);
			editPanel.add(cpfpesqField);
			
		
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
		
		
		JButton btnPesquisar_1 = new JButton("Pesquisar");
		btnPesquisar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String pesq;
				pesq = cpfpesqField.getText();
				Fachada.getInstancia().BuscarClienteCPF(c,pesq);
				
				cpfField2.setText(""+c.getCPF());
				nomeField2.setText(c.getNome());
				rgField2.setText(c.getRG());
				cidadeField2.setText(c.getCidade());
				estadoField2.setText(c.getEstado());
				enderecoField2.setText(c.getEndereco());
				numeroField2.setText(""+c.getNumero());
				bairroField2.setText(c.getBairro());
				telefoneField2.setText(""+c.getTelefone());
				 c.setNome("");
				 c.setCPF("");
				 c.setRG("");
				 c.setTelefone("");
				 c.setEstado("");
				 c.setCidade("");
				 c.setBairro("");
				 c.setNumero("");
				 c.setEndereco("");
				 if(nomeField2.getText().isEmpty()){
					 JOptionPane.showMessageDialog(null,"Cliente não encontrado");
				 }
			}
		});
		btnPesquisar_1.setBounds(271, 368, 100, 23);
		editPanel.add(btnPesquisar_1);
		
		JButton btnEditar_1 = new JButton("Editar");
		btnEditar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				numeroField2.setEditable(true);
				nomeField2.setEditable(true);
				cpfField2.setEditable(true);
				rgField2.setEditable(true);
				cidadeField2.setEditable(true);
				estadoField2.setEditable(true);
				enderecoField2.setEditable(true);
				bairroField2.setEditable(true);
				telefoneField2.setEditable(true);
				
				
			}
		});
		btnEditar_1.setBounds(391, 303, 89, 23);
		editPanel.add(btnEditar_1);
		
		JButton btnExcluir2 = new JButton("Excluir");
		btnExcluir2.addActionListener(new ActionListener() {
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
		btnExcluir2.setBounds(391, 402, 89, 23);
		editPanel.add(btnExcluir2);
	

	}
	public void carregarTabela() {
		ClienteTableModel tableModel = (ClienteTableModel) tabelaCategoria.getModel();
		tableModel.setRowCount(0);
		for(Cliente cat : Fachada.getInstancia().listarClientes()) {
			tableModel.adicionarCategoria(cat);
		}
	}
}
