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

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JFormattedTextField;
import net.miginfocom.swing.MigLayout;
import javax.swing.SwingConstants;

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
		setBackground(Color.BLACK);
		getContentPane().setBackground(Color.DARK_GRAY);
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
		cadast.setBackground(Color.DARK_GRAY);
		
		tabbedPane.addTab("Cadastrar Clientes", null, cadast, null);
		tabbedPane.setEnabledAt(0, true);
		cadast.setLayout(new MigLayout("", "[84px][23px][46px][69px][160px][85px][321.00px][71.00px][124px][54.00px][172.00][428px]", "[53px][33.00px][53px][30px][39px][30px][54px][30px][56px][31px][91.00px]"));
		
		JLabel labelnome = new JLabel("Nome");
		labelnome.setForeground(Color.WHITE);
		labelnome.setFont(new Font("Dialog", Font.PLAIN, 15));
		cadast.add(labelnome, "cell 0 0,alignx left,aligny bottom");
		JLabel lblNomeobri = new JLabel("Preenchmento obrigat\u00F3rio");
		lblNomeobri.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblNomeobri.setForeground(Color.RED);
		cadast.add(lblNomeobri, "cell 2 0 3 1,alignx left,aligny bottom");
		lblNomeobri.setVisible(false);
		JLabel lblbtnEditar = new JLabel("");
		JLabel lblbtnExcluir = new JLabel("");
		JLabel lblcpfobri = new JLabel("Preenchimento obrigat\u00F3rio");
		lblcpfobri.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblcpfobri.setForeground(Color.RED);
		cadast.add(lblcpfobri, "cell 6 2,growx,aligny bottom");
		lblcpfobri.setVisible(false);
		
		JLabel lblrgobri = new JLabel("Preenchimento obrigat\u00F3rio");
		lblrgobri.setForeground(Color.RED);
		lblrgobri.setFont(new Font("Dialog", Font.PLAIN, 15));
		cadast.add(lblrgobri, "cell 11 2,alignx left,aligny bottom");
		lblrgobri.setVisible(false);
		
		JLabel lblcidadeobri = new JLabel("Preenchimento obrigat\u00F3rio");
		lblcidadeobri.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblcidadeobri.setForeground(Color.RED);
		cadast.add(lblcidadeobri, "cell 6 4,growx,aligny bottom");
		lblcidadeobri.setVisible(false);
		
		JLabel lblestadoobri = new JLabel("Preenchimento obrigat\u00F3rio");
		lblestadoobri.setForeground(Color.RED);
		lblestadoobri.setFont(new Font("Dialog", Font.PLAIN, 15));
		cadast.add(lblestadoobri, "cell 11 4,alignx left,aligny bottom");
		lblestadoobri.setVisible(false);
		
		JLabel lblenderecoobri = new JLabel("Preenchimento obrigat\u00F3rio");
		lblenderecoobri.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblenderecoobri.setForeground(Color.RED);
		cadast.add(lblenderecoobri, "cell 6 6,growx,aligny bottom");
		lblenderecoobri.setVisible(false);
		
		JLabel lblNumero = new JLabel("N\u00FAmero");
		lblNumero.setForeground(Color.WHITE);
		lblNumero.setFont(new Font("Dialog", Font.PLAIN, 15));
		cadast.add(lblNumero, "cell 8 6,alignx left,aligny bottom");
		
		JLabel lblnumobri = new JLabel("Preenchimento obrigat\u00F3rio");
		lblnumobri.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblnumobri.setForeground(Color.RED);
		cadast.add(lblnumobri, "cell 11 6,aligny bottom");
		lblnumobri.setVisible(false);
		JLabel lblBairroobri2 = new JLabel("Preenchimento obrigat\u00F3rio");
		lblBairroobri2.setForeground(Color.RED);
		lblBairroobri2.setFont(new Font("Dialog", Font.PLAIN, 15));
		cadast.add(lblBairroobri2, "cell 6 8,alignx left,aligny bottom");
		lblBairroobri2.setVisible(false);
		
		numeroField = new JTextField();
		numeroField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cadast.add(numeroField, "cell 8 7 4 1,grow");
		numeroField.setColumns(10);
		
		try {
			MaskFormatter mascara = new MaskFormatter("(##)####-####");
			mascara.setPlaceholderCharacter('_');
			
			
			
			
			JLabel lblTelefone = new JLabel("Telefone");
			lblTelefone.setForeground(Color.WHITE);
			lblTelefone.setFont(new Font("Dialog", Font.PLAIN, 15));
			cadast.add(lblTelefone, "flowx,cell 8 8,alignx left,aligny bottom");
		
			telefoneField = new JFormattedTextField(mascara);
			telefoneField.setFont(new Font("Tahoma", Font.PLAIN, 15));
			telefoneField.setBounds(432, 463, 380, 30);
			cadast.add(telefoneField, "cell 8 9 4 1,grow");
		
		} catch (ParseException e1) {
		
			e1.printStackTrace();
			}
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
					lblCpf.setForeground(Color.WHITE);
					lblCpf.setFont(new Font("Dialog", Font.PLAIN, 15));
					cadast.add(lblCpf, "cell 0 2,alignx left,aligny bottom");
					
					rgField = new JTextField();
					rgField.setFont(new Font("Tahoma", Font.PLAIN, 15));
					cadast.add(rgField, "cell 8 3 4 1,grow");
					rgField.setColumns(10);
					
					JLabel lblRg = new JLabel("RG");
					lblRg.setForeground(Color.WHITE);
					lblRg.setFont(new Font("Dialog", Font.PLAIN, 15));
					cadast.add(lblRg, "cell 8 2,growx,aligny bottom");
					
					JLabel lblEndereo = new JLabel("Endere\u00E7o");
					lblEndereo.setForeground(Color.WHITE);
					lblEndereo.setFont(new Font("Dialog", Font.PLAIN, 15));
					cadast.add(lblEndereo, "cell 0 6,growx,aligny bottom");
					
					enderecoField = new JTextField();
					enderecoField.setFont(new Font("Tahoma", Font.PLAIN, 15));
					cadast.add(enderecoField, "cell 0 7 7 1,grow");
					enderecoField.setColumns(10);
					
					JLabel lblBairro = new JLabel("Bairro");
					lblBairro.setForeground(Color.WHITE);
					lblBairro.setFont(new Font("Dialog", Font.PLAIN, 15));
					cadast.add(lblBairro, "cell 0 8,growx,aligny bottom");
					
					bairroField = new JTextField();
					bairroField.setFont(new Font("Tahoma", Font.PLAIN, 15));
					cadast.add(bairroField, "cell 0 9 7 1,grow");
					bairroField.setColumns(10);
					
					JLabel lblCidade = new JLabel("Cidade");
					lblCidade.setForeground(Color.WHITE);
					lblCidade.setFont(new Font("Dialog", Font.PLAIN, 15));
					cadast.add(lblCidade, "cell 0 4,alignx left,aligny bottom");
					
					JLabel lblEstado = new JLabel("Estado");
					lblEstado.setForeground(Color.WHITE);
					lblEstado.setFont(new Font("Dialog", Font.PLAIN, 15));
					cadast.add(lblEstado, "cell 8 4,growx,aligny bottom");
					

					JLabel lbltelefoneobri = new JLabel("Preenchimento obrigat\u00F3rio");
					lbltelefoneobri.setFont(new Font("Dialog", Font.PLAIN, 15));
					lbltelefoneobri.setForeground(Color.RED);
					cadast.add(lbltelefoneobri, "cell 11 8,alignx left,aligny bottom");
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
					
					JLabel lblbtnsalvar = new JLabel("");
					lblbtnsalvar.setHorizontalAlignment(SwingConstants.CENTER);
					lblbtnsalvar.addMouseListener(new MouseAdapter() {
						@SuppressWarnings("resource")
						@Override
						

						public void mouseClicked(MouseEvent arg0) {
							lblbtnsalvar.setIcon(new ImageIcon(JCadastroCliente.class.getResource("/imagens/salvar3.png")));
							int opcao = JOptionPane.showConfirmDialog(null, "Deseja salvar?", "Aviso", JOptionPane.YES_NO_OPTION);
							int ctnum = 0;
							int ctnum2 = 0;
							String texto = cpfField.getText();
							String numerotel = telefoneField.getText();
							
							char ch, ch2;
							int n = 14;
							int m =13;
							int i,j;
							for (i=0; i<n; i++) {
								ch = texto.charAt(i);
							if ((ch >= '0') && (ch <= '9')) {
					              ctnum = ctnum + 1;
					              
					           }
							}
							for (j=0; j<m; j++) {
								ch2 = numerotel.charAt(j);
							if ((ch2 >= '0') && (ch2 <= '9')) {
					              ctnum2 = ctnum2 + 1;
					              
					           }
							}
							
							
							if (opcao == 0){	
							Cliente c = new Cliente();
							if(nomeField.getText().isEmpty()){
								lblNomeobri.setVisible(true);
							}else{
								lblNomeobri.setVisible(false);

							}if(ctnum<11){
							lblcpfobri.setVisible(true);
							}else{
							lblcpfobri.setVisible(false);

							}if(rgField.getText().isEmpty()){
							lblrgobri.setVisible(true);
							}else{
							lblrgobri.setVisible(false);

							}if(ctnum2<10){
							lbltelefoneobri.setVisible(true);
							}else{
							lbltelefoneobri.setVisible(false);

							}if(bairroField.getText().isEmpty()){
							lblBairroobri2.setVisible(true);
							}else{
							lblBairroobri2.setVisible(false);

							}if(estadoField.getText().isEmpty()){
							lblestadoobri.setVisible(true);
							}else{
							lblestadoobri.setVisible(false);

							}if(enderecoField.getText().isEmpty()){
							lblenderecoobri.setVisible(true);

							}else{
							lblenderecoobri.setVisible(false);

							}if(numeroField.getText().isEmpty()){
								lblnumobri.setVisible(true);

								}else{
									lblnumobri.setVisible(false);

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
							int opcao2 = JOptionPane.showConfirmDialog(null, "Deseja limpar os campos?", "Aviso", JOptionPane.YES_NO_OPTION);
							if (opcao2 == 0){	
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
						}
						
						@Override
						public void mouseEntered(MouseEvent e) {
							lblbtnsalvar.setIcon(new ImageIcon(JCadastroCliente.class.getResource("/imagens/salvar2.png")));
							
						}
						@Override
						public void mouseExited(MouseEvent e) {
							lblbtnsalvar.setIcon(new ImageIcon(JCadastroCliente.class.getResource("/imagens/salvar1.png")));
							
						}
						@Override
						public void mouseReleased(MouseEvent e) {
							lblbtnsalvar.setIcon(new ImageIcon(JCadastroCliente.class.getResource("/imagens/salvar1.png")));
						}
					});
					
					JLabel lblbtncancelar = new JLabel("");
					lblbtncancelar.setIcon(new ImageIcon(JCadastroCliente.class.getResource("/imagens/cancelar1.png")));
					lblbtncancelar.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent arg0) {
							lblbtncancelar.setIcon(new ImageIcon(JCadastroCliente.class.getResource("/imagens/cancelar3.png")));
						}
						@Override
						public void mouseEntered(MouseEvent e) {
							lblbtncancelar.setIcon(new ImageIcon(JCadastroCliente.class.getResource("/imagens/cancelar2.png")));
						}
						@Override
						public void mouseExited(MouseEvent e) {
							lblbtncancelar.setIcon(new ImageIcon(JCadastroCliente.class.getResource("/imagens/cancelar1.png")));
						}
						@Override
						public void mouseReleased(MouseEvent e) {
							lblbtncancelar.setIcon(new ImageIcon(JCadastroCliente.class.getResource("/imagens/cancelar1.png")));
						}
					});
					
					cadast.add(lblbtncancelar, "flowx,cell 11 10,alignx right,aligny bottom");
					lblbtnsalvar.setIcon(new ImageIcon(JCadastroCliente.class.getResource("/imagens/salvar1.png")));
					cadast.add(lblbtnsalvar, "cell 11 10,alignx left,aligny bottom");
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
				int opcao = JOptionPane.showConfirmDialog(null, "Deseja visualizar " + svalueName + "?", "Aviso", JOptionPane.YES_NO_OPTION);
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
		
		
			
		tabelaCategoria.addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent e) {
				
				lblbtnExcluir.setEnabled(true);
				lblbtnEditar.setEnabled(true);
				
			}
			});
		
		
		JPanel exibirpanel = new JPanel();
		exibirpanel.setBackground(Color.DARK_GRAY);
		tabbedPane.addTab("Exibir Clientes", null, exibirpanel, null);
		exibirpanel.setLayout(new MigLayout("", "[156px][95px][143px][14px][851px,grow]", "[504px][47px]"));
		exibirpanel.add(scrollPane, "cell 0 0 5 1,grow");
		
		
		lblbtnEditar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblbtnEditar.setIcon(new ImageIcon(JCadastroCliente.class.getResource("/imagens/editar3.png")));
				c.setNome(svalueName);
				int opcao = JOptionPane.showConfirmDialog(null, "Deseja editar " + svalueName + "?", "Aviso", JOptionPane.YES_NO_OPTION);
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
			@Override
			public void mouseEntered(MouseEvent e) {
				lblbtnEditar.setIcon(new ImageIcon(JCadastroCliente.class.getResource("/imagens/editar2.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblbtnEditar.setIcon(new ImageIcon(JCadastroCliente.class.getResource("/imagens/editar1.png")));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				lblbtnEditar.setIcon(new ImageIcon(JCadastroCliente.class.getResource("/imagens/editar1.png")));
			}
		});
	
		
		
		lblbtnExcluir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblbtnExcluir.setIcon(new ImageIcon(JCadastroCliente.class.getResource("/imagens/excluir3.png")));
				c.setCPF(svalueCpf);
				int opcao = JOptionPane.showConfirmDialog(null, "Deseja excluir " + svalueName + "?", "Aviso", JOptionPane.YES_NO_OPTION);
				if (opcao == 0){
					Fachada.getInstancia().ExcluirCliente(c);
					carregarTabela();
				} else {
				}
				
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblbtnExcluir.setIcon(new ImageIcon(JCadastroCliente.class.getResource("/imagens/excluir2.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblbtnExcluir.setIcon(new ImageIcon(JCadastroCliente.class.getResource("/imagens/excluir1.png")));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				lblbtnExcluir.setIcon(new ImageIcon(JCadastroCliente.class.getResource("/imagens/excluir1.png")));
			}
		});
		lblbtnExcluir.setIcon(new ImageIcon(JCadastroCliente.class.getResource("/imagens/excluir1.png")));
		exibirpanel.add(lblbtnExcluir, "flowx,cell 4 1,alignx right,growy");
		lblbtnEditar.setIcon(new ImageIcon(JCadastroCliente.class.getResource("/imagens/editar1.png")));
		exibirpanel.add(lblbtnEditar, "cell 4 1,alignx right,growy");
		
		JPanel editPanel = new JPanel();
		editPanel.setBackground(Color.DARK_GRAY);
		tabbedPane.addTab("Editar Clientes", null, editPanel, null);
		editPanel.setLayout(new MigLayout("", "[89px,grow][55px][157.00px][54.00px][347.00px][47.00px][60px][43.00px][26.00px][43.00px][][89px,grow]", "[42.00px][33.00px][38.00px][33.00px][41.00px][33.00px][43.00px][33.00px][41.00px][33.00px][40.00px][33.00px][40.00px][33.00][]"));
		
		JLabel nomelabel2 = new JLabel("Nome");
		nomelabel2.setForeground(Color.WHITE);
		nomelabel2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		editPanel.add(nomelabel2, "cell 0 0,alignx left,aligny bottom");
		
		nomeField2 = new JTextField();
		nomeField2.setEditable(false);
		nomeField2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		nomeField2.setColumns(10);
		editPanel.add(nomeField2, "cell 0 1 12 1,grow");
		
		cpfField2 = new JTextField();
		cpfField2.setEditable(false);
		cpfField2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cpfField2.setColumns(10);
		editPanel.add(cpfField2, "cell 0 3 5 1,grow");
		
		JLabel cpflabel2 = new JLabel("CPF");
		cpflabel2.setForeground(Color.WHITE);
		cpflabel2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		editPanel.add(cpflabel2, "cell 0 2,alignx left,aligny bottom");
		
		JLabel rglabel2 = new JLabel("RG");
		rglabel2.setForeground(Color.WHITE);
		rglabel2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		editPanel.add(rglabel2, "cell 6 2,growx,aligny bottom");
		
		rgField2 = new JTextField();
		rgField2.setEditable(false);
		rgField2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		rgField2.setColumns(10);
		editPanel.add(rgField2, "cell 6 3 6 1,grow");
		
		JLabel estadolabel2 = new JLabel("Estado");
		estadolabel2.setForeground(Color.WHITE);
		estadolabel2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		editPanel.add(estadolabel2, "cell 6 4,alignx left,aligny bottom");
		
		JLabel cidadelabel2 = new JLabel("Cidade");
		cidadelabel2.setForeground(Color.WHITE);
		cidadelabel2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		editPanel.add(cidadelabel2, "cell 0 4,alignx left,aligny bottom");
		
		cidadeField2 = new JTextField();
		cidadeField2.setEditable(false);
		cidadeField2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cidadeField2.setColumns(10);
		editPanel.add(cidadeField2, "cell 0 5 5 1,grow");
		
		JLabel numerolabel2 = new JLabel("N\u00FAmero");
		numerolabel2.setForeground(Color.WHITE);
		numerolabel2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		editPanel.add(numerolabel2, "cell 6 6,alignx left,aligny bottom");
		
		enderecoField2 = new JTextField();
		enderecoField2.setEditable(false);
		enderecoField2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		enderecoField2.setColumns(10);
		editPanel.add(enderecoField2, "cell 0 7 5 1,grow");
		
		JLabel enderecolabel2 = new JLabel("Endere\u00E7o");
		enderecolabel2.setForeground(Color.WHITE);
		enderecolabel2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		editPanel.add(enderecolabel2, "cell 0 6,growx,aligny bottom");
		
		numeroField2 = new JTextField();
		numeroField2.setEditable(false);
		numeroField2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		numeroField2.setColumns(10);
		editPanel.add(numeroField2, "cell 6 7 6 1,grow");
		
		JLabel bairrolabel2 = new JLabel("Bairro");
		bairrolabel2.setForeground(Color.WHITE);
		bairrolabel2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		editPanel.add(bairrolabel2, "cell 0 8,alignx left,aligny bottom");
		
		JLabel telefonelabel2 = new JLabel("Telefone");
		telefonelabel2.setForeground(Color.WHITE);
		telefonelabel2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		editPanel.add(telefonelabel2, "cell 6 8,growx,aligny bottom");
		
		bairroField2 = new JTextField();
		bairroField2.setEditable(false);
		bairroField2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		bairroField2.setColumns(10);
		editPanel.add(bairroField2, "cell 0 9 5 1,grow");
		
		telefoneField2 = new JTextField();
		telefoneField2.setEditable(false);
		telefoneField2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		telefoneField2.setColumns(10);
		editPanel.add(telefoneField2, "cell 6 9 6 1,grow");
		
		estadoField2 = new JTextField();
		estadoField2.setEditable(false);
		estadoField2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		estadoField2.setColumns(10);
		editPanel.add(estadoField2, "cell 6 5 6 1,grow");
		
		pesquisarField = new JTextField();
		pesquisarField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		editPanel.add(pesquisarField, "cell 0 11 3 1,grow");
		pesquisarField.setColumns(10);
		
		JLabel lblPesquisarPorNome = new JLabel("Pesquisar por nome");
		lblPesquisarPorNome.setForeground(Color.WHITE);
		lblPesquisarPorNome.setFont(new Font("Tahoma", Font.PLAIN, 15));
		editPanel.add(lblPesquisarPorNome, "cell 0 10 3 1,alignx left,aligny bottom");
		
		JLabel lblNewLabel = new JLabel("Pesquisar por CPF");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		editPanel.add(lblNewLabel, "cell 0 12 3 1,alignx left,aligny bottom");
		
		try {
			MaskFormatter mascara = new MaskFormatter("###.###.###-##");
			mascara.setPlaceholderCharacter('_');
			cpfpesqField = new JFormattedTextField(mascara);
			cpfpesqField.setFont(new Font("Tahoma", Font.PLAIN, 15));
			
			editPanel.add(cpfpesqField, "cell 0 13 3 1,grow");
			
		
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		 
		try {
			MaskFormatter mascara = new MaskFormatter("###.###.###-##");
			mascara.setPlaceholderCharacter('_');
			
		
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		
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
		
		JLabel lblbtnPesquisarCPF = new JLabel("");
		lblbtnPesquisarCPF.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
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
			@Override
			public void mouseEntered(MouseEvent e) {
				lblbtnPesquisarCPF.setIcon(new ImageIcon(JCadastroCliente.class.getResource("/imagens/pesquisar2.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblbtnPesquisarCPF.setIcon(new ImageIcon(JCadastroCliente.class.getResource("/imagens/pesquisar1.png")));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				lblbtnPesquisarCPF.setIcon(new ImageIcon(JCadastroCliente.class.getResource("/imagens/pesquisar1.png")));
			}
		});
		lblbtnPesquisarCPF.setIcon(new ImageIcon(JCadastroCliente.class.getResource("/imagens/pesquisar1.png")));
		editPanel.add(lblbtnPesquisarCPF, "cell 4 13");
		
		JLabel lblbtnSalvar = new JLabel("");
		lblbtnSalvar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblbtnSalvar.setIcon(new ImageIcon(JCadastroCliente.class.getResource("/imagens/salvar3.png")));
				int opcao = JOptionPane.showConfirmDialog(null, "Deseja salvar?", "Aviso", JOptionPane.YES_NO_OPTION);
				if (opcao == 0){
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
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				lblbtnSalvar.setIcon(new ImageIcon(JCadastroCliente.class.getResource("/imagens/salvar2.png")));
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblbtnSalvar.setIcon(new ImageIcon(JCadastroCliente.class.getResource("/imagens/salvar1.png")));
				
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				lblbtnSalvar.setIcon(new ImageIcon(JCadastroCliente.class.getResource("/imagens/salvar1.png")));
			}
		});
		
		JLabel lblbtnEditar2 = new JLabel("");
		lblbtnEditar2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int opcao = JOptionPane.showConfirmDialog(null, "Deseja editar " + svalueName + "?", "Aviso", JOptionPane.YES_NO_OPTION);
				if (opcao == 0){
				lblbtnEditar2.setIcon(new ImageIcon(JCadastroCliente.class.getResource("/imagens/editar3.png")));
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
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblbtnEditar2.setIcon(new ImageIcon(JCadastroCliente.class.getResource("/imagens/editar2.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblbtnEditar2.setIcon(new ImageIcon(JCadastroCliente.class.getResource("/imagens/editar1.png")));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				lblbtnEditar2.setIcon(new ImageIcon(JCadastroCliente.class.getResource("/imagens/editar1.png")));
			}
		});
		
		JLabel lblbtnExcluir2 = new JLabel("");
		lblbtnExcluir2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblbtnExcluir2.setIcon(new ImageIcon(JCadastroCliente.class.getResource("/imagens/excluir3.png")));
				c.setCPF(svalueCpf);
				int opcao = JOptionPane.showConfirmDialog(null, "Deseja excluir " + svalueName + "?", "Aviso", JOptionPane.YES_NO_OPTION);
				if (opcao == 0){
					Fachada.getInstancia().ExcluirCliente(c);
					carregarTabela();} else {   
				}
				
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblbtnExcluir2.setIcon(new ImageIcon(JCadastroCliente.class.getResource("/imagens/excluir2.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblbtnExcluir2.setIcon(new ImageIcon(JCadastroCliente.class.getResource("/imagens/excluir1.png")));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				lblbtnExcluir2.setIcon(new ImageIcon(JCadastroCliente.class.getResource("/imagens/excluir1.png")));
			}
		});
		lblbtnExcluir2.setIcon(new ImageIcon(JCadastroCliente.class.getResource("/imagens/excluir1.png")));
		editPanel.add(lblbtnExcluir2, "cell 7 13");
		lblbtnEditar2.setIcon(new ImageIcon(JCadastroCliente.class.getResource("/imagens/editar1.png")));
		editPanel.add(lblbtnEditar2, "cell 9 13");
		lblbtnSalvar.setIcon(new ImageIcon(JCadastroCliente.class.getResource("/imagens/salvar1.png")));
		editPanel.add(lblbtnSalvar, "cell 11 13");
		editPanel.add(btnLimpparTela, "cell 2 14,growx,aligny bottom");
		
		JLabel lblbtnPesquisarNome = new JLabel("");
		lblbtnPesquisarNome.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblbtnPesquisarNome.setIcon(new ImageIcon(JCadastroCliente.class.getResource("/imagens/pesquisar3.png")));
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
			@Override
			public void mouseEntered(MouseEvent e) {
				lblbtnPesquisarNome.setIcon(new ImageIcon(JCadastroCliente.class.getResource("/imagens/pesquisar2.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblbtnPesquisarNome.setIcon(new ImageIcon(JCadastroCliente.class.getResource("/imagens/pesquisar1.png")));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				lblbtnPesquisarNome.setIcon(new ImageIcon(JCadastroCliente.class.getResource("/imagens/pesquisar1.png")));
			}
		});
		lblbtnPesquisarNome.setIcon(new ImageIcon(JCadastroCliente.class.getResource("/imagens/pesquisar1.png")));
		editPanel.add(lblbtnPesquisarNome, "cell 4 11");
	

	}
	public void carregarTabela() {
		ClienteTableModel tableModel = (ClienteTableModel) tabelaCategoria.getModel();
		tableModel.setRowCount(0);
		for(Cliente cat : Fachada.getInstancia().listarClientes()) {
			tableModel.adicionarCategoria(cat);
		}
	}
}
