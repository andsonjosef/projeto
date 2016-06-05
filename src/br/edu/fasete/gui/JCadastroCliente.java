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
import net.miginfocom.swing.MigLayout;

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
	
	public JCadastroCliente() {
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 1280, 720);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				//Carregar tabela sempre que alternar para aba de relat√≥rios
				if(tabbedPane.getSelectedIndex() == 1) {
					carregarTabela();
				}
			}
		});
		getContentPane().setLayout(new BorderLayout(0, 0));
		getContentPane().add(tabbedPane, BorderLayout.CENTER);
		
		@SuppressWarnings("unused")
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
				
				
				try {
					MaskFormatter mascara = new MaskFormatter("###.###.###-##");
					mascara.setPlaceholderCharacter('_');
					
				
				} catch (ParseException e1) {
				
					e1.printStackTrace();
				}
				 
				
				
				try {
					MaskFormatter mascara = new MaskFormatter("(##)####-####");
					mascara.setPlaceholderCharacter('_');
					
				
				} catch (ParseException e1) {
					
					e1.printStackTrace();
					}
		
		JPanel cadast = new JPanel();
		
		tabbedPane.addTab("Cadastrar Clientes", null, cadast, null);
		tabbedPane.setEnabledAt(0, true);
		cadast.setLayout(new MigLayout("", "[84px][23px][46px][69px][160px][85px][321.00px][71.00px][124px][54.00px][172.00][428px]", "[53px][33.00px][53px][30px][39px][30px][54px][30px][56px][31px][91.00px]"));
		
		JLabel labelnome = new JLabel("Nome");
		labelnome.setFont(new Font("Dialog", Font.PLAIN, 15));
		cadast.add(labelnome, "cell 0 0,alignx left,aligny bottom");
		
		JLabel lblNomeobri = new JLabel("Preenchmento obrigat\u00F3rio");
		lblNomeobri.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblNomeobri.setForeground(Color.RED);
		cadast.add(lblNomeobri, "cell 2 0 3 1,alignx left,growy");
		lblNomeobri.setVisible(false);
		
		JLabel lblcpfobri = new JLabel("Preenchmento obrigat\u00F3rio");
		lblcpfobri.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblcpfobri.setForeground(Color.RED);
		cadast.add(lblcpfobri, "cell 2 2 3 1,grow");
		lblcpfobri.setVisible(false);
		
		JLabel lblcidadeobri = new JLabel("Preenchmento obrigat\u00F3rio");
		lblcidadeobri.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblcidadeobri.setForeground(Color.RED);
		cadast.add(lblcidadeobri, "cell 2 4 3 1,growx,aligny bottom");
		lblcidadeobri.setVisible(false);
		
		JLabel lblrgobri = new JLabel("Preenchmento obrigat\u00F3rio");
		lblrgobri.setForeground(Color.RED);
		lblrgobri.setFont(new Font("Dialog", Font.PLAIN, 15));
		cadast.add(lblrgobri, "cell 11 2,alignx left,growy");
		lblrgobri.setVisible(false);
		
		JLabel lblestadoobri = new JLabel("Preenchmento obrigat\u00F3rio");
		lblestadoobri.setForeground(Color.RED);
		lblestadoobri.setFont(new Font("Dialog", Font.PLAIN, 15));
		cadast.add(lblestadoobri, "cell 11 4,alignx left,aligny bottom");
		lblestadoobri.setVisible(false);
		
		JLabel lblenderecoobri = new JLabel("Preenchmento obrigat\u00F3rio");
		lblenderecoobri.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblenderecoobri.setForeground(Color.RED);
		cadast.add(lblenderecoobri, "cell 2 6 3 1,grow");
		lblenderecoobri.setVisible(false);
		
		JLabel lblNumero = new JLabel("numero");
		lblNumero.setFont(new Font("Dialog", Font.PLAIN, 15));
		cadast.add(lblNumero, "cell 10 6,alignx left,aligny bottom");
		
		numeroField = new JTextField();
		numeroField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cadast.add(numeroField, "cell 10 7,alignx left,growy");
		numeroField.setColumns(10);
		
		
		JLabel lblBairroobri = new JLabel("Preenchmento obrigat\u00F3rio");
		lblBairroobri.setForeground(Color.RED);
		lblBairroobri.setFont(new Font("Dialog", Font.PLAIN, 15));
		cadast.add(lblBairroobri, "cell 2 8 3 1,alignx left,growy");
		lblBairroobri.setVisible(false);
		
		try {
			MaskFormatter mascara = new MaskFormatter("(##)####-####");
			mascara.setPlaceholderCharacter('_');
		
			telefoneField = new JFormattedTextField(mascara);
			telefoneField.setFont(new Font("Tahoma", Font.PLAIN, 15));
			telefoneField.setBounds(432, 463, 380, 30);
			cadast.add(telefoneField, "cell 10 9,grow");
		
		} catch (ParseException e1) {
		
			e1.printStackTrace();
			}
				
					
					
					
		
				JButton btnSalvar = new JButton("Salvar");
				btnSalvar.setFont(new Font("Tahoma", Font.PLAIN, 15));
				cadast.add(btnSalvar, "cell 5 10 2 1,aligny bottom");
				nomeField = new JTextField();
				nomeField.setFont(new Font("Tahoma", Font.PLAIN, 15));
				cadast.add(nomeField, "cell 0 1 12 1,grow");
				nomeField.setColumns(10);
				try {
					MaskFormatter mascara = new MaskFormatter("###.###.###-##");
					mascara.setPlaceholderCharacter('_');
					cpfField = new JFormattedTextField(mascara);
					cpfField.setFont(new Font("Tahoma", Font.PLAIN, 15));
					
					cadast.add(cpfField, "cell 0 3 7 1,grow");
					
					
				
				} catch (ParseException e1) {
					
					e1.printStackTrace();
				}
				 
				try {
					MaskFormatter mascara = new MaskFormatter("###.###.###-##");
					mascara.setPlaceholderCharacter('_');
					
				
				} catch (ParseException e1) {
					
					e1.printStackTrace();
				}
					
					
					
				
				
				
					
					
					JLabel lblCpf = new JLabel("CPF");
					lblCpf.setFont(new Font("Dialog", Font.PLAIN, 15));
					cadast.add(lblCpf, "cell 0 2,alignx left,aligny bottom");
					
					rgField = new JTextField();
					rgField.setFont(new Font("Tahoma", Font.PLAIN, 15));
					cadast.add(rgField, "cell 8 3 4 1,grow");
					rgField.setColumns(10);
					
					JLabel lblRg = new JLabel("RG");
					lblRg.setFont(new Font("Dialog", Font.PLAIN, 15));
					cadast.add(lblRg, "cell 8 2,growx,aligny bottom");
					
					JLabel lblEndereo = new JLabel("Endere\u00E7o");
					lblEndereo.setFont(new Font("Dialog", Font.PLAIN, 15));
					cadast.add(lblEndereo, "cell 0 6,growx,aligny bottom");
					
					enderecoField = new JTextField();
					enderecoField.setFont(new Font("Tahoma", Font.PLAIN, 15));
					cadast.add(enderecoField, "cell 0 7 9 1,grow");
					enderecoField.setColumns(10);
					
					JLabel lblBairro = new JLabel("Bairro");
					lblBairro.setFont(new Font("Dialog", Font.PLAIN, 15));
					cadast.add(lblBairro, "cell 0 8,growx,aligny bottom");
					
					bairroField = new JTextField();
					bairroField.setFont(new Font("Tahoma", Font.PLAIN, 15));
					cadast.add(bairroField, "cell 0 9 7 1,grow");
					bairroField.setColumns(10);
					
					JLabel lblCidade = new JLabel("Cidade");
					lblCidade.setFont(new Font("Dialog", Font.PLAIN, 15));
					cadast.add(lblCidade, "cell 0 4,alignx left,aligny bottom");
					
					JLabel lblEstado = new JLabel("Estado");
					lblEstado.setFont(new Font("Dialog", Font.PLAIN, 15));
					cadast.add(lblEstado, "cell 8 4,growx,aligny bottom");
					

					JLabel lbltelefoneobri = new JLabel("Preenchmento obrigat\u00F3rio");
					lbltelefoneobri.setFont(new Font("Dialog", Font.PLAIN, 15));
					lbltelefoneobri.setForeground(Color.RED);
					cadast.add(lbltelefoneobri, "cell 11 8,alignx left,growy");
					lbltelefoneobri.setVisible(false);
					
					cidadeField = new JTextField();
					cidadeField.setFont(new Font("Tahoma", Font.PLAIN, 15));
					cadast.add(cidadeField, "cell 0 5 7 1,grow");
					cidadeField.setColumns(10);
					
					estadoField = new JTextField();
					estadoField.setFont(new Font("Tahoma", Font.PLAIN, 15));
					cadast.add(estadoField, "cell 8 5 4 1,grow");
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
							c.setRegistrado(false);
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
												  }
											  }   catch (SQLException e1) {
													e1.printStackTrace();
												  }
												  if(cpf != c.getCPF() && c.getCPF().length() == 14 ){
													 Fachada.getInstancia().InserirCliente(c);
												  }else{
														JOptionPane.showMessageDialog(null, "CPF j· cadastrado ou inv·lido");																	
												  }
										}
															
									}else{
										JOptionPane.showMessageDialog(null, "CPF j· cadastrado ou inv·lido. ");
									}
																
								}	
							} catch (SQLException e1) {
								e1.printStackTrace();
								}
						}
					});
					
					
					JButton btnCancelar = new JButton("Cancelar");
					btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 15));
					cadast.add(btnCancelar, "cell 4 10,aligny bottom");
					
					JButton btnLimparTela = new JButton("Limpar tela");
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
					cadast.add(btnLimparTela, "cell 0 10 4 1,aligny bottom");
					
					JLabel lblTelefone = new JLabel("Telefone");
					lblTelefone.setFont(new Font("Dialog", Font.PLAIN, 15));
					cadast.add(lblTelefone, "flowx,cell 10 8 2 1,alignx left,aligny bottom");
					
		
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
				int opcao = JOptionPane.showConfirmDialog(null, "deseja editar " + svalueName + "?", "Aviso", JOptionPane.YES_NO_OPTION);
				String pesq = svalueName;
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
			}
		});
		scrollPane.setBounds(0, 11, 1249, 504);
		
		
			
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
				String pesq = svalueName;
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
		btnEditar.setBounds(400, 556, 124, 34);
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
		btnExculir.setBounds(218, 556, 124, 34);
		exibirpanel.add(btnExculir);
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				carregarTabela();
			}
		});
		btnAtualizar.setBounds(32, 556, 124, 34);
		exibirpanel.add(btnAtualizar);
		
		JPanel editPanel = new JPanel();
		tabbedPane.addTab("Editar Clientes", null, editPanel, null);
		editPanel.setLayout(new MigLayout("", "[89px,grow][55px][157.00px][54.00px][347.00px][47.00px][60px][43.00px][107px][43.00px][][89px,grow]", "[42.00px][33.00px][38.00px][33.00px][41.00px][33.00px][43.00px][33.00px][41.00px][33.00px][40.00px][33.00px][40.00px][33.00][]"));
		
		JLabel nomelabel2 = new JLabel("Nome");
		nomelabel2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		editPanel.add(nomelabel2, "cell 0 0,alignx left,aligny bottom");
		
		nomeField2 = new JTextField();
		nomeField2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		nomeField2.setColumns(10);
		editPanel.add(nomeField2, "cell 0 1 12 1,grow");
		
		cpfField2 = new JTextField();
		cpfField2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cpfField2.setColumns(10);
		editPanel.add(cpfField2, "cell 0 3 5 1,grow");
		
		JLabel cpflabel2 = new JLabel("CPF");
		cpflabel2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		editPanel.add(cpflabel2, "cell 0 2,alignx left,aligny bottom");
		
		JLabel rglabel2 = new JLabel("RG");
		rglabel2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		editPanel.add(rglabel2, "cell 6 2,growx,aligny bottom");
		
		rgField2 = new JTextField();
		rgField2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		rgField2.setColumns(10);
		editPanel.add(rgField2, "cell 6 3 6 1,grow");
		
		JLabel estadolabel2 = new JLabel("Estado");
		estadolabel2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		editPanel.add(estadolabel2, "cell 6 4,alignx left,aligny bottom");
		
		JLabel cidadelabel2 = new JLabel("Cidade");
		cidadelabel2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		editPanel.add(cidadelabel2, "cell 0 4,alignx left,aligny bottom");
		
		cidadeField2 = new JTextField();
		cidadeField2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cidadeField2.setColumns(10);
		editPanel.add(cidadeField2, "cell 0 5 5 1,grow");
		
		enderecoField2 = new JTextField();
		enderecoField2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		enderecoField2.setColumns(10);
		editPanel.add(enderecoField2, "cell 0 7 9 1,grow");
		
		JLabel enderecolabel2 = new JLabel("Endere\u00E7o");
		enderecolabel2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		editPanel.add(enderecolabel2, "cell 0 6,growx,aligny bottom");
		
		numeroField2 = new JTextField();
		numeroField2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		numeroField2.setColumns(10);
		editPanel.add(numeroField2, "cell 10 7 2 1,alignx left,growy");
		
		JLabel bairrolabel2 = new JLabel("Bairro");
		bairrolabel2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		editPanel.add(bairrolabel2, "cell 0 8,alignx left,aligny bottom");
		
		bairroField2 = new JTextField();
		bairroField2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		bairroField2.setColumns(10);
		editPanel.add(bairroField2, "cell 0 9 7 1,grow");
		
		JLabel numerolabel2 = new JLabel("numero");
		numerolabel2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		editPanel.add(numerolabel2, "cell 11 6,alignx left,aligny bottom");
		
		telefoneField2 = new JTextField();
		telefoneField2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		telefoneField2.setColumns(10);
		editPanel.add(telefoneField2, "cell 8 9 4 1,alignx left,growy");
		
		JLabel telefonelabel2 = new JLabel("Telefone");
		telefonelabel2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		editPanel.add(telefonelabel2, "cell 8 8,growx,aligny bottom");
		
		estadoField2 = new JTextField();
		estadoField2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		estadoField2.setColumns(10);
		editPanel.add(estadoField2, "cell 6 5 6 1,grow");
		
		pesquisarField = new JTextField();
		pesquisarField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		editPanel.add(pesquisarField, "cell 0 11 3 1,grow");
		pesquisarField.setColumns(10);
		
		JButton btnPesquisarNome = new JButton("Pesquisar");
		btnPesquisarNome.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnPesquisarNome.addActionListener(new ActionListener() {
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
					 JOptionPane.showMessageDialog(null,"Cliente n„o encontrado");
				 }
				
			}
		});
		editPanel.add(btnPesquisarNome, "cell 4 11,alignx left,growy");
		
		JLabel lblPesquisarPorNome = new JLabel("Pesquisar por nome");
		lblPesquisarPorNome.setFont(new Font("Tahoma", Font.PLAIN, 15));
		editPanel.add(lblPesquisarPorNome, "cell 0 10 3 1,alignx left,aligny bottom");
		
		JLabel lblNewLabel = new JLabel("Pesquisar por CPF");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		editPanel.add(lblNewLabel, "cell 0 12 3 1,alignx left,aligny bottom");
		
		try {
			MaskFormatter mascara = new MaskFormatter("###.###.###-##");
			mascara.setPlaceholderCharacter('_');
			cpfpesqField = new JFormattedTextField(mascara);
			cpfpesqField.setFont(new Font("Tahoma", Font.PLAIN, 15));
			
			editPanel.add(cpfpesqField, "cell 0 13 3 1,grow");
			
		
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
	
		
		
		JButton btnPesquisarCPF = new JButton("Pesquisar");
		btnPesquisarCPF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
					 JOptionPane.showMessageDialog(null,"Cliente n„o encontrado");
				 }
			}
		});
		btnPesquisarCPF.setFont(new Font("Tahoma", Font.PLAIN, 15));
		editPanel.add(btnPesquisarCPF, "cell 4 13,alignx left,growy");
		
		JButton btnLimpparTela = new JButton("Limpar tela");
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
		
		JButton button_1 = new JButton("Salvar");
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
				@SuppressWarnings("unused")
				String cpf = c.getCPF();
				Fachada.getInstancia().AtualizarCliente(c,svalueCpf);
			}
		});
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				c.setCPF(svalueCpf);
				int opcao = JOptionPane.showConfirmDialog(null, "Realmente deseja excluir " + svalueName + "?", "Aviso", JOptionPane.YES_NO_OPTION);
				if (opcao == 0){
					Fachada.getInstancia().ExcluirCliente(c);
					carregarTabela();} else {   
				}
			}
		});
		btnExcluir.setFont(new Font("Tahoma", Font.PLAIN, 15));
		editPanel.add(btnExcluir, "cell 6 13 2 1,alignx right,growy");
		
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
		btnEditar_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		editPanel.add(btnEditar_1, "cell 8 13,alignx right,growy");
		editPanel.add(button_1, "cell 10 13 2 1,alignx left,growy");
		editPanel.add(btnLimpparTela, "cell 2 14,growx,aligny bottom");
	

	}
	public void carregarTabela() {
		ClienteTableModel tableModel = (ClienteTableModel) tabelaCategoria.getModel();
		tableModel.setRowCount(0);
		for(Cliente cat : Fachada.getInstancia().listarClientes()) {
			tableModel.adicionarCategoria(cat);
		}
	}
}
