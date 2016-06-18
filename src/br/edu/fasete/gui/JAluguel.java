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
import br.edu.fasete.dao.RoupaDaoJdbc;
import br.edu.fasete.fachada.Fachada;
import br.edu.fasete.principais.Lista;
import br.edu.fasete.principais.Aluguel;
import br.edu.fasete.principais.Cliente;
import br.edu.fasete.principais.Funcionario;
import br.edu.fasete.principais.Roupa;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Font;
import javax.swing.JFormattedTextField;
import net.miginfocom.swing.MigLayout;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JAluguel extends JInternalFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ClienteDaoJdbc cli = new ClienteDaoJdbc();
	RoupaDaoJdbc rou = new RoupaDaoJdbc();
	int srow;
	String svalueCpf;
	int svaluecoder;
	String svalueName;
	String vazio;
	Lista l = new Lista();
	Cliente c = new Cliente();
	Roupa r = new Roupa();
	Aluguel a = new Aluguel();
	Funcionario f = new Funcionario();
	int pesq2;
	String pesq;
	private  JTextField precoField2;
	private JTextField nomeField;
	private JTextField enderecoField;
	private JTextField bairroField;
	private JTextField cidadeField;
	private JTextField estadoField;
	private JTextField numeroField;
	private JTabbedPane tabbedPane;
	private JTable tabelaCategoria;
	private JTable tabelaRoupa;
	private JTable tabelaRoupa_1;
	private JTable tabelaRoupasele;
	private JTable tabelaRoupaAluguel;
	private JTextField nomeField2;
	private JFormattedTextField telefoneField;
	private JFormattedTextField cpfField;
	private JTextField tamanhoField;
	private JTextField corField;
	private JTextField tipoField;
	private JTextField modeloField;
	private JTextField generoField;
	private JFormattedTextField dataLoca;
	private JFormattedTextField DataDevo;
	private JTextField precoFieldal;
	private JTextField precoFieldFim;
	java.util.Date x;
	JTextField funcField;
	private JTextField funcioField;
	private JTextField textField;
	private JTextField pesqField;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JAluguel frame = new JAluguel();
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
	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public JAluguel() {
		getContentPane().setBackground(Color.DARK_GRAY);
		
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 1280, 720);
		
		Fachada.getInstancia().limparTabela();
		Fachada.getInstancia().limparLista();
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		@SuppressWarnings("unused")
		JTabbedPane PanelCadastro = new JTabbedPane(JTabbedPane.TOP);
		
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
		
		////
		
		tabelaRoupa = new JTable(new RoupaTableModel());
		tabelaRoupa.addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent arg0) {
				srow = tabelaRoupa.getSelectedRow();
				
				svaluecoder = (int) tabelaRoupa.getValueAt(srow, 0);
				
			}
			
		});
					
					tabbedPane = new JTabbedPane(JTabbedPane.TOP);
					tabbedPane.setForeground(Color.WHITE);
					tabbedPane.setBackground(Color.DARK_GRAY);
					
					tabbedPane.addChangeListener(new ChangeListener() {
						public void stateChanged(ChangeEvent e) {
							
							
							//Carregar tabela sempre que alternar para aba de relatórios
							if(tabbedPane.getSelectedIndex() == 1) {
								carregarTabelaRoupa();
								//Fachada.getInstancia().limparTabela();
								//Fachada.getInstancia().limparLista();
								carregarTabelaRoupasele();	
							}
							
							if(tabbedPane.getSelectedIndex() == 2) {
								carregarTabelaRoupa();
								//Fachada.getInstancia().limparTabela();
								carregarTabelaRoupaLista();
							}
							if(tabbedPane.isShowing()) {	
								//Fachada.getInstancia().limparTabela();	
								carregarTabela();	
							}	
						}
					});
					getContentPane().add(tabbedPane, BorderLayout.CENTER);
					getContentPane().add(tabbedPane);
					
					JPanel cadast = new JPanel();
					cadast.setBackground(Color.DARK_GRAY);
					
					tabbedPane.addTab("Cadastrar Aluguel", null, cadast, null);
					tabbedPane.setEnabledAt(0, true);
					cadast.setLayout(new MigLayout("", "[101.00px,grow][31px,grow][407px][31px][13px][28px][181px][34px][373px,grow]", "[30][253px][35.00px][47.00px][25px][51.00px][25px][54.00px][25px][58.00px][25px][61.00px]"));
					
					JLabel lblClientesDiponiveis = new JLabel("Clientes Dipon\u00EDveis");
					lblClientesDiponiveis.setForeground(Color.WHITE);
					lblClientesDiponiveis.setFont(new Font("Dialog", Font.PLAIN, 15));
					cadast.add(lblClientesDiponiveis, "cell 0 0 2 1");
								
								pesqField = new JTextField();
								pesqField.addKeyListener(new KeyAdapter() {
									@Override
									public void keyTyped(KeyEvent e) {
										pesq =pesqField.getText();
										carregarTabelanome();
									}
								});
								cadast.add(pesqField, "cell 0 2 2 1,grow");
								pesqField.setColumns(10);
								
								JLabel lblPesquisar = new JLabel("Pesquisar");
								lblPesquisar.setForeground(Color.WHITE);
								lblPesquisar.setFont(new Font("Dialog", Font.PLAIN, 15));
								cadast.add(lblPesquisar, "cell 2 2");
								
								JLabel labelnome = new JLabel("Nome");
								labelnome.setForeground(Color.WHITE);
								labelnome.setFont(new Font("Dialog", Font.PLAIN, 15));
								cadast.add(labelnome, "cell 0 3,alignx left,aligny bottom");
								JLabel lblCpf = new JLabel("CPF");
								lblCpf.setForeground(Color.WHITE);
								lblCpf.setFont(new Font("Dialog", Font.PLAIN, 15));
								cadast.add(lblCpf, "cell 6 3,alignx left,aligny bottom");
								nomeField = new JTextField();
								nomeField.setFont(new Font("Dialog", Font.PLAIN, 15));
								cadast.add(nomeField, "cell 0 4 5 1,grow");
								nomeField.setColumns(10);
								cpfField = new JFormattedTextField();
								cpfField.setFont(new Font("Dialog", Font.PLAIN, 15));
								cadast.add(cpfField, "cell 6 4 3 1,grow");
								
								JLabel lblNumero = new JLabel("numero");
								lblNumero.setForeground(Color.WHITE);
								lblNumero.setFont(new Font("Dialog", Font.PLAIN, 15));
								cadast.add(lblNumero, "cell 6 7,alignx left,aligny bottom");
							
								telefoneField = new JFormattedTextField();
								telefoneField.setFont(new Font("Dialog", Font.PLAIN, 15));
								cadast.add(telefoneField, "cell 6 10 3 1,grow");
								
								 precoField2 = new JTextField();
								
								JLabel lblTelefone = new JLabel("Telefone");
								lblTelefone.setForeground(Color.WHITE);
								lblTelefone.setFont(new Font("Dialog", Font.PLAIN, 15));
								cadast.add(lblTelefone, "cell 6 9,alignx left,aligny bottom");
								
								JLabel lblEndereo = new JLabel("Endere\u00E7o");
								lblEndereo.setForeground(Color.WHITE);
								lblEndereo.setFont(new Font("Dialog", Font.PLAIN, 15));
								cadast.add(lblEndereo, "cell 0 7,alignx left,aligny bottom");
								
								enderecoField = new JTextField();
								enderecoField.setFont(new Font("Dialog", Font.PLAIN, 15));
								cadast.add(enderecoField, "cell 0 8 5 1,grow");
								enderecoField.setColumns(10);
								
								JLabel lblBairro = new JLabel("Bairro");
								lblBairro.setForeground(Color.WHITE);
								lblBairro.setFont(new Font("Dialog", Font.PLAIN, 15));
								cadast.add(lblBairro, "cell 0 9,alignx left,aligny bottom");
								
								bairroField = new JTextField();
								bairroField.setFont(new Font("Dialog", Font.PLAIN, 15));
								cadast.add(bairroField, "cell 0 10 5 1,grow");
								bairroField.setColumns(10);
								
								JLabel lblCidade = new JLabel("Cidade");
								lblCidade.setForeground(Color.WHITE);
								lblCidade.setFont(new Font("Dialog", Font.PLAIN, 15));
								cadast.add(lblCidade, "cell 0 5,alignx left,aligny bottom");
								
								JLabel lblEstado = new JLabel("Estado");
								lblEstado.setForeground(Color.WHITE);
								lblEstado.setFont(new Font("Dialog", Font.PLAIN, 15));
								cadast.add(lblEstado, "cell 6 5,alignx left,aligny bottom");
								
								cidadeField = new JTextField();
								cidadeField.setFont(new Font("Dialog", Font.PLAIN, 15));
								cadast.add(cidadeField, "cell 0 6 5 1,grow");
								cidadeField.setColumns(10);
								
								estadoField = new JTextField();
								estadoField.setFont(new Font("Dialog", Font.PLAIN, 15));
								cadast.add(estadoField, "cell 6 6 3 1,grow");
								estadoField.setColumns(10);
								
								
								cadast.addKeyListener(new KeyAdapter() {
									@Override
									public void keyTyped(KeyEvent arg0) {

										
									}
									@Override
									public void keyReleased(KeyEvent arg0) {

									}
								});
								
								numeroField = new JTextField();
								numeroField.setFont(new Font("Dialog", Font.PLAIN, 15));
								cadast.add(numeroField, "cell 6 8 3 1,grow");
								numeroField.setColumns(10);
								tabelaCategoria = new JTable(new ClienteTableModel());
								tabelaCategoria.setFont(new Font("Tahoma", Font.PLAIN, 15));
								tabelaCategoria.addMouseListener(new MouseAdapter() {
									public void mouseReleased(MouseEvent arg0) {
										srow = tabelaCategoria.getSelectedRow();
										svalueCpf = (String) tabelaCategoria.getValueAt(srow, 1);
										svalueName = (String) tabelaCategoria.getValueAt(srow, 0);
										
										
									}
									
								});
								
								
								tabelaCategoria.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
								JScrollPane scrollPane = new JScrollPane(tabelaCategoria);
								cadast.add(scrollPane, "cell 0 1 9 1,grow");
								
								JLabel btnlblAvancar = new JLabel("");
								btnlblAvancar.addMouseListener(new MouseAdapter() {
									@Override
									public void mouseClicked(MouseEvent arg0) {

										Fachada.getInstancia().limparTabela();
										Fachada.getInstancia().BuscarRoupaEd(r);
										Fachada.getInstancia().ListarRoupaEdi(r,c);
										carregarTabelaRoupasele();
										
										btnlblAvancar.setIcon(new ImageIcon(JAluguel.class.getResource("/imagens/avan\u00E7ar3.png")));
										String pesq = c.getCPF();
										Fachada.getInstancia().BuscarClienteCPF(c, pesq);
										
										tabbedPane.setSelectedIndex(1);
									}
									@Override
									public void mouseEntered(MouseEvent arg0) {
										btnlblAvancar.setIcon(new ImageIcon(JAluguel.class.getResource("/imagens/avan\u00E7ar2.png")));
									}
									@Override
									public void mouseExited(MouseEvent e) {
										btnlblAvancar.setIcon(new ImageIcon(JAluguel.class.getResource("/imagens/avan\u00E7ar1.png")));
									}
									@Override
									public void mouseReleased(MouseEvent e) {
										btnlblAvancar.setIcon(new ImageIcon(JAluguel.class.getResource("/imagens/avan\u00E7ar1.png")));
									}
								});
								
								funcField = new JTextField();
								funcField.setVisible(false);
								cadast.add(funcField, "cell 1 11,alignx center");
								funcField.setColumns(10);
								btnlblAvancar.setIcon(new ImageIcon(JAluguel.class.getResource("/imagens/avan\u00E7ar1.png")));
								cadast.add(btnlblAvancar, "cell 8 11,alignx right");
								
								JPanel exibirpanel = new JPanel();
								exibirpanel.setBackground(Color.DARK_GRAY);
								tabbedPane.addTab("Selecionar Roupas", null, exibirpanel, null);
								exibirpanel.setLayout(new MigLayout("", "[128px,grow][42px][124px][168px][133.00px,grow][16.00][623px,grow]", "[][311px][23px][47.00px][25px][42.00px][25px][42.00px][25px][55.00px]"));
								
								JLabel lblbtnRemover = new JLabel("");
								lblbtnRemover.addMouseListener(new MouseAdapter() {
									@Override
									public void mouseClicked(MouseEvent e) {
										lblbtnRemover.setIcon(new ImageIcon(JAluguel.class.getResource("/imagens/remover3.png")));
										int linha = tabelaRoupasele.getSelectedRow();
									    r.setCodRoupa((int) tabelaRoupasele.getValueAt(linha, 0));  
									    Fachada.getInstancia().ExcluirRoupaSeleEdi(r);
									    carregarTabelaRoupasele();
									    carregarTabelaRoupa();
									}
									public void mouseEntered(MouseEvent arg0) {
										lblbtnRemover.setIcon(new ImageIcon(JAluguel.class.getResource("/imagens/remover2.png")));
										
									}
									@Override
									public void mouseExited(MouseEvent e) {
										lblbtnRemover.setIcon(new ImageIcon(JAluguel.class.getResource("/imagens/remover1.png")));
									}
									public void mouseReleased(MouseEvent e) {
										lblbtnRemover.setIcon(new ImageIcon(JAluguel.class.getResource("/imagens/remover1.png")));
									}
								});
								
								JLabel lblbtnAdicionar = new JLabel("");
								lblbtnAdicionar.addMouseListener(new MouseAdapter() {
									@Override
									public void mouseClicked(MouseEvent e) {
										lblbtnAdicionar.setIcon(new ImageIcon(JAluguel.class.getResource("/imagens/adicionar3.png")));
										   int linha = tabelaRoupa_1.getSelectedRow();
										  //  r.setCodRoupa((int) tabelaRoupa_1.getValueAt(linha, 0));  
										    r.setCodRoupa((int) tabelaRoupa_1.getValueAt(linha, 0));  
											   Fachada.getInstancia().InserirRoupaEdi(r, c);
											   carregarTabelaRoupasele();
											   carregarTabelaRoupa();
										  
									}
									@Override
									public void mouseEntered(MouseEvent arg0) {
										lblbtnAdicionar.setIcon(new ImageIcon(JAluguel.class.getResource("/imagens/adicionar2.png")));
										
									}
									@Override
									public void mouseExited(MouseEvent e) {
										lblbtnAdicionar.setIcon(new ImageIcon(JAluguel.class.getResource("/imagens/Adicionar1.png")));
									}
									public void mouseReleased(MouseEvent e) {
										lblbtnAdicionar.setIcon(new ImageIcon(JAluguel.class.getResource("/imagens/Adicionar1.png")));
									}
								});
								
								JLabel lblRoupasDisponiveis = new JLabel("Roupas dispon\u00EDveis");
								lblRoupasDisponiveis.setForeground(Color.WHITE);
								lblRoupasDisponiveis.setFont(new Font("Dialog", Font.PLAIN, 15));
								exibirpanel.add(lblRoupasDisponiveis, "cell 0 0 2 1");
								
								JLabel lblRoupasSelecionadas = new JLabel("Roupas selecionadas");
								lblRoupasSelecionadas.setForeground(Color.WHITE);
								lblRoupasSelecionadas.setFont(new Font("Dialog", Font.PLAIN, 15));
								exibirpanel.add(lblRoupasSelecionadas, "cell 6 0");
								
								textField = new JTextField();
								textField.addKeyListener(new KeyAdapter() {
									@Override
									public void keyTyped(KeyEvent arg0) {
									if(textField.getText().isEmpty()){
										carregarTabelaRoupa();
									}
									}
								});
								exibirpanel.add(textField, "cell 0 2 2 1,grow");
								textField.setColumns(10);
								
								JLabel lblbtnPesquisar = new JLabel("");
								lblbtnPesquisar.addMouseListener(new MouseAdapter() {
									@Override
									public void mouseClicked(MouseEvent arg0) {
										lblbtnPesquisar.setIcon(new ImageIcon(JCadastroCliente.class.getResource("/imagens/pesquisar3.png")));
										pesq2 =Integer.parseInt(textField.getText());
										carregarTabelaRoupaListacod();
									}
									
									@Override
									public void mouseEntered(MouseEvent e) {
										lblbtnPesquisar.setIcon(new ImageIcon(JCadastroCliente.class.getResource("/imagens/pesquisar2.png")));
									}
									@Override
									public void mouseExited(MouseEvent e) {
										lblbtnPesquisar.setIcon(new ImageIcon(JCadastroCliente.class.getResource("/imagens/pesquisar1.png")));
									}
									@Override
									public void mouseReleased(MouseEvent e) {
										lblbtnPesquisar.setIcon(new ImageIcon(JCadastroCliente.class.getResource("/imagens/pesquisar1.png")));
									}
								
								
																	
								});
								lblbtnPesquisar.setIcon(new ImageIcon(JAluguel.class.getResource("/imagens/pesquisar1.png")));
								exibirpanel.add(lblbtnPesquisar, "cell 2 2");
								
								JLabel lblbtnlista = new JLabel("");
								lblbtnlista.addMouseListener(new MouseAdapter() {
									@Override
									public void mouseClicked(MouseEvent arg0) {
										lblbtnlista.setIcon(new ImageIcon(JAluguel.class.getResource("/imagens/lista3.png")));
										carregarTabelaRoupa();
									}
									
									@Override
									public void mouseEntered(MouseEvent e) {
										lblbtnlista.setIcon(new ImageIcon(JAluguel.class.getResource("/imagens/lista2.png")));
									}
									@Override
									public void mouseExited(MouseEvent e) {
										lblbtnlista.setIcon(new ImageIcon(JAluguel.class.getResource("/imagens/lista1.png")));
									}
									@Override
									public void mouseReleased(MouseEvent e) {
										lblbtnlista.setIcon(new ImageIcon(JAluguel.class.getResource("/imagens/lista1.png")));
									}
								
								});
								lblbtnlista.setIcon(new ImageIcon(JAluguel.class.getResource("/imagens/lista1.png")));
								exibirpanel.add(lblbtnlista, "cell 3 2,alignx center");
								lblbtnAdicionar.setIcon(new ImageIcon(JAluguel.class.getResource("/imagens/Adicionar1.png")));
								exibirpanel.add(lblbtnAdicionar, "cell 4 2");
								lblbtnRemover.setIcon(new ImageIcon(JAluguel.class.getResource("/imagens/remover1.png")));
								exibirpanel.add(lblbtnRemover, "cell 6 2,alignx right,aligny center");
								
								
								precoField2.setFont(new Font("Dialog", Font.PLAIN, 15));
								exibirpanel.add(precoField2, "cell 6 8,grow");
								
								JLabel lbltipo = new JLabel("Tipo");
								lbltipo.setForeground(Color.WHITE);
								lbltipo.addMouseListener(new MouseAdapter() {
									@Override
									public void mouseClicked(MouseEvent e) {
										 int linha = tabelaRoupa_1.getSelectedRow();
										    r.setCodRoupa((int) tabelaRoupa_1.getValueAt(linha, 0));  
										   Fachada.getInstancia().InserirRoupaSele(r);
										   carregarTabelaRoupasele();
									}
								});
								lbltipo.setFont(new Font("Dialog", Font.PLAIN, 15));
								exibirpanel.add(lbltipo, "flowx,cell 0 3,grow");
								
								JLabel lblModelo = new JLabel("Modelo");
								lblModelo.setForeground(Color.WHITE);
								lblModelo.setFont(new Font("Dialog", Font.PLAIN, 15));
								exibirpanel.add(lblModelo, "cell 6 3,grow");
								
								JLabel lblCor = new JLabel("Cor");
								lblCor.setForeground(Color.WHITE);
								lblCor.setFont(new Font("Dialog", Font.PLAIN, 15));
								exibirpanel.add(lblCor, "cell 0 7 5 1,grow");
								
								tamanhoField = new JTextField();
								tamanhoField.setFont(new Font("Dialog", Font.PLAIN, 15));
								tamanhoField.setColumns(10);
								exibirpanel.add(tamanhoField, "cell 0 6 5 1,grow");
								
								corField = new JTextField();
								corField.setFont(new Font("Dialog", Font.PLAIN, 15));
								corField.setColumns(10);
								exibirpanel.add(corField, "cell 0 8 5 1,grow");
								
								JLabel lblTamanho = new JLabel("Tamanho");
								lblTamanho.setForeground(Color.WHITE);
								lblTamanho.setFont(new Font("Dialog", Font.PLAIN, 15));
								exibirpanel.add(lblTamanho, "flowy,cell 0 5 5 1,growx,aligny top");
								
								JLabel lblGenero = new JLabel("Genero");
								lblGenero.setForeground(Color.WHITE);
								lblGenero.setFont(new Font("Dialog", Font.PLAIN, 15));
								exibirpanel.add(lblGenero, "cell 6 5,growx,aligny top");
								
								tipoField = new JTextField();
								tipoField.setFont(new Font("Dialog", Font.PLAIN, 15));
								tipoField.setColumns(10);
								exibirpanel.add(tipoField, "cell 0 4 5 1,grow");
								
								modeloField = new JTextField();
								modeloField.setFont(new Font("Dialog", Font.PLAIN, 15));
								modeloField.setColumns(10);
								exibirpanel.add(modeloField, "cell 6 4,grow");
								
								JLabel lblPreo = new JLabel("Pre\u00E7o");
								lblPreo.setForeground(Color.WHITE);
								lblPreo.setFont(new Font("Dialog", Font.PLAIN, 15));
								exibirpanel.add(lblPreo, "cell 6 7,grow");
								
								generoField = new JTextField();
								generoField.setFont(new Font("Dialog", Font.PLAIN, 15));
								generoField.setColumns(10);
								exibirpanel.add(generoField, "cell 6 6,grow");
								
								
								///
								
								tabelaRoupasele = new JTable(new RoupaTableModel());
								tabelaRoupasele.setFont(new Font("Dialog", Font.PLAIN, 15));
								tabelaRoupasele.addMouseListener(new MouseAdapter() {
									@SuppressWarnings("unused")
									public void tabelaRoupasele(MouseEvent arg0) {
										srow = tabelaRoupaAluguel.getSelectedRow();
										
										svaluecoder = (int) tabelaRoupasele.getValueAt(srow, 0);
										
									}
									
								});
								
								tabelaRoupasele.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
								JScrollPane scrollPaneRoupaAluguel = new JScrollPane(tabelaRoupasele);
								exibirpanel.add(scrollPaneRoupaAluguel, "cell 6 1,grow");
								scrollPaneRoupaAluguel.addMouseListener(new MouseAdapter() {
									@Override
									public void mouseClicked(MouseEvent e) {
										if(e.getClickCount() == 2) {
											int linha = tabelaRoupasele.getSelectedRow();
										    r.setCodRoupa((int) tabelaRoupasele.getValueAt(linha, 0));  
										    Fachada.getInstancia().ExcluirRoupaSeleEdi(r);
										    carregarTabelaRoupasele();
										    carregarTabelaRoupa();
										}
									}
									
								});
							
								////
								
								tabelaRoupa_1 = new JTable(new RoupaTableModel());
								tabelaRoupa_1.setFont(new Font("Dialog", Font.PLAIN, 15));
								tabelaRoupa_1.addMouseListener(new MouseAdapter() {
									public void mouseReleased(MouseEvent arg0) {
										srow = tabelaRoupa_1.getSelectedRow();
										
										svaluecoder = (int) tabelaRoupa_1.getValueAt(srow, 0);
										Fachada.getInstancia().BuscarRoupa(r);
										tipoField.setText(r.getTipo());
										modeloField.setText(r.getModelo());
										tamanhoField.setText(r.getTamanho());
										corField.setText(r.getCor());
										generoField.setText(r.getGenero());
										
										
									}
									
								});
								
								tabelaRoupa_1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
								JScrollPane scrollPaneRoupa = new JScrollPane(tabelaRoupa_1);
								exibirpanel.add(scrollPaneRoupa, "cell 0 1 5 1,grow");
								
								JLabel btnlblAvancar2 = new JLabel("");
								btnlblAvancar2.addMouseListener(new MouseAdapter() {
									@Override
									public void mouseClicked(MouseEvent e) {
										
									/*	int linha = 0;
										 
										int linhat = tabelaRoupasele.getRowCount();
										
										while(linha < linhat){
										r.setCodRoupa((int) tabelaRoupasele.getValueAt(linha, 0));
										r.setTipo( (String) tabelaRoupasele.getValueAt(linha, 1));
										r.setModelo( (String) tabelaRoupasele.getValueAt(linha, 2));
										r.setTamanho( (String) tabelaRoupasele.getValueAt(linha, 3));
										r.setGenero( (String) tabelaRoupasele.getValueAt(linha, 4));
										r.setCor( (String) tabelaRoupasele.getValueAt(linha, 5));
										r.setPreco( (float) tabelaRoupasele.getValueAt(linha, 6));
								
										linha++;
									
										Fachada.getInstancia().InserirLista(r, c);
										
										}
										*/
										funcioField.setText(funcField.getText());
										nomeField2.setText(c.getNome());
										carregarTabelaRoupaLista();
										Fachada.getInstancia().SomaPreco(a);
										precoFieldal.setText(""+a.getPreco());
										tabbedPane.setSelectedIndex(2);
										
										
									}
									@Override
									public void mouseEntered(MouseEvent arg0) {
										btnlblAvancar2.setIcon(new ImageIcon(JAluguel.class.getResource("/imagens/avan\u00E7ar2.png")));
									}
									@Override
									public void mouseExited(MouseEvent e) {
										btnlblAvancar2.setIcon(new ImageIcon(JAluguel.class.getResource("/imagens/avan\u00E7ar1.png")));
									}
									@Override
									public void mouseReleased(MouseEvent e) {
										btnlblAvancar2.setIcon(new ImageIcon(JAluguel.class.getResource("/imagens/avan\u00E7ar1.png")));
									}
								});
								
								JLabel lblbtnVoltar = new JLabel("");
								lblbtnVoltar.addMouseListener(new MouseAdapter() {
									@Override
									public void mouseClicked(MouseEvent e) {
										lblbtnVoltar.setIcon(new ImageIcon(JAluguel.class.getResource("/imagens/VOLTAR3.png")));
										tabbedPane.setSelectedIndex(0);
										Fachada.getInstancia().limparLista();
									}
									@Override
									public void mouseEntered(MouseEvent e) {
										lblbtnVoltar.setIcon(new ImageIcon(JAluguel.class.getResource("/imagens/VOLTAR2.png")));
									}
									@Override
									public void mouseExited(MouseEvent e) {
										lblbtnVoltar.setIcon(new ImageIcon(JAluguel.class.getResource("/imagens/VOLTAR1.png")));
									}
									@Override
									public void mouseReleased(MouseEvent e) {
										lblbtnVoltar.setIcon(new ImageIcon(JAluguel.class.getResource("/imagens/VOLTAR1.png")));
									}
								});
								lblbtnVoltar.setIcon(new ImageIcon(JAluguel.class.getResource("/imagens/VOLTAR1.png")));
								exibirpanel.add(lblbtnVoltar, "flowx,cell 6 9,alignx right");
								btnlblAvancar2.setIcon(new ImageIcon(JAluguel.class.getResource("/imagens/avan\u00E7ar1.png")));
								exibirpanel.add(btnlblAvancar2, "cell 6 9,alignx right");
								scrollPaneRoupa.addMouseListener(new MouseAdapter() {
								});
								
								
								tabelaRoupa_1.addMouseListener(new MouseAdapter() {
									public void mouseClicked(MouseEvent e) {
										if(e.getClickCount() == 2) {											 
										
											   int linha = tabelaRoupa_1.getSelectedRow();
											    r.setCodRoupa((int) tabelaRoupa_1.getValueAt(linha, 0));  
											    r.setCodRoupa((int) tabelaRoupa_1.getValueAt(linha, 0));  
												   Fachada.getInstancia().InserirRoupaEdi(r, c);
												   carregarTabelaRoupasele();
												   carregarTabelaRoupa();
										
									} else {
										   
									}
								}
									
								});
								tabelaRoupasele.addMouseListener(new MouseAdapter() {
									public void mouseClicked(MouseEvent e) {
										if(e.getClickCount()==2){
											int linha = tabelaRoupasele.getSelectedRow();
										    r.setCodRoupa((int) tabelaRoupasele.getValueAt(linha, 0));  
										    Fachada.getInstancia().ExcluirRoupaSeleEdi(r);
										    carregarTabelaRoupasele();
										    carregarTabelaRoupa();
										}
									}
								});
								
								
								tabelaRoupa_1.addMouseListener(new MouseAdapter() {
public void mouseClicked(MouseEvent e) {
	srow = tabelaRoupa_1.getSelectedRow();
	
	//r.setCodRoupa( (int) tabelaRoupa_1.getValueAt(srow, 0));
	Fachada.getInstancia().BuscarRoupa(r);
	tipoField.setText(r.getTipo());
	modeloField.setText(r.getModelo());
	tamanhoField.setText(r.getTamanho());
	corField.setText(r.getCor());
	generoField.setText(r.getGenero());
	precoField2.setText(""+r.getPreco());
								if(e.getClickCount() == 2) {
								

}
}
});
								
			JPanel editPanel = new JPanel();
			editPanel.setBackground(Color.DARK_GRAY);
								tabbedPane.addTab("Concluir Aluguel", null, editPanel, null);
								
								///
								tabelaRoupaAluguel = new JTable(new RoupaTableModel());
								tabelaRoupaAluguel.addMouseListener(new MouseAdapter() {
									public void mouseReleased(MouseEvent arg0) {
										srow = tabelaRoupaAluguel.getSelectedRow();
										
										svaluecoder = (int) tabelaRoupaAluguel.getValueAt(srow, 0);
										
									}
									
								});
								editPanel.setLayout(new MigLayout("", "[115px][30px][115px][30px][115px][30px][115px][30px][115,grow][30][115,grow][652px,grow]", "[14px][30.00px][][465.00px][54.00px][20px][grow]"));
								
								JLabel lblRoupasSelecionadas_1 = new JLabel("Roupas Selecionadas");
								lblRoupasSelecionadas_1.setForeground(Color.WHITE);
								lblRoupasSelecionadas_1.setFont(new Font("Dialog", Font.PLAIN, 15));
								editPanel.add(lblRoupasSelecionadas_1, "cell 0 2");
								
								
								
								
								tabelaRoupaAluguel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
								JScrollPane scrollPaneRoupasele = new JScrollPane(tabelaRoupaAluguel);
								editPanel.add(scrollPaneRoupasele, "cell 0 3 12 1,grow");
								scrollPaneRoupasele.addMouseListener(new MouseAdapter() {
								});
								
								
								
								
								JLabel nomelabel2 = new JLabel("Nome");
								nomelabel2.setForeground(Color.WHITE);
								editPanel.add(nomelabel2, "cell 0 0,alignx left,aligny top");
								
								nomeField2 = new JTextField();
								nomeField2.setEditable(false);
								nomeField2.setColumns(10);
								editPanel.add(nomeField2, "cell 0 1 12 1,grow");
								
								JLabel lblDataDeLocao = new JLabel("Data de loca\u00E7\u00E3o");
								lblDataDeLocao.setFont(new Font("Dialog", Font.PLAIN, 15));
								lblDataDeLocao.setForeground(Color.WHITE);
								editPanel.add(lblDataDeLocao, "cell 0 4,growx,aligny bottom");
								
								JLabel lblFuncionrio = new JLabel("Funcion\u00E1rio");
								lblFuncionrio.setForeground(Color.WHITE);
								lblFuncionrio.setFont(new Font("Dialog", Font.PLAIN, 15));
								editPanel.add(lblFuncionrio, "cell 8 4,aligny bottom");
								
								try {
									MaskFormatter mascara = new MaskFormatter("##/##/####");
									mascara.setPlaceholderCharacter('_');
									dataLoca = new JFormattedTextField(mascara);
									dataLoca.setFont(new Font("Dialog", Font.PLAIN, 15));
									editPanel.add(dataLoca, "cell 0 5,grow");
									dataLoca.setColumns(10);
									
									
									
									
								
								} catch (ParseException e1) {
									
									e1.printStackTrace();
								}
							
								
								JLabel lblDataDeDevoluo = new JLabel("Data de Devolu\u00E7\u00E3o");
								lblDataDeDevoluo.setFont(new Font("Dialog", Font.PLAIN, 15));
								lblDataDeDevoluo.setForeground(Color.WHITE);
								editPanel.add(lblDataDeDevoluo, "cell 2 4,alignx left,aligny bottom");
								
								try {
									MaskFormatter mascara = new MaskFormatter("##/##/####");
									mascara.setPlaceholderCharacter('_');
									DataDevo = new JFormattedTextField(mascara);
									DataDevo.setFont(new Font("Dialog", Font.PLAIN, 15));
									editPanel.add(DataDevo, "cell 2 5,grow");
									DataDevo.setColumns(10);
									
									
									
									
								
								} catch (ParseException e1) {
									
									e1.printStackTrace();
								}
								
								
								precoFieldal = new JTextField();
								precoFieldal.setFont(new Font("Dialog", Font.PLAIN, 15));
								precoFieldal.setEditable(false);
								editPanel.add(precoFieldal, "cell 4 5,grow");
								precoFieldal.setColumns(10);
								
								precoFieldFim = new JTextField();
								precoFieldFim.setFont(new Font("Dialog", Font.PLAIN, 15));
								editPanel.add(precoFieldFim, "cell 6 5,grow");
								precoFieldFim.setColumns(10);
								
								JLabel lblPreo_1 = new JLabel("Pre\u00E7o");
								lblPreo_1.setFont(new Font("Dialog", Font.PLAIN, 15));
								lblPreo_1.setForeground(Color.WHITE);
								editPanel.add(lblPreo_1, "cell 4 4,alignx left,aligny bottom");
								
								JLabel lblPreoFinal = new JLabel("Pre\u00E7o final");
								lblPreoFinal.setFont(new Font("Dialog", Font.PLAIN, 15));
								lblPreoFinal.setForeground(Color.WHITE);
								editPanel.add(lblPreoFinal, "cell 6 4,alignx left,aligny bottom");
								
								JLabel lblbtnVoltar2 = new JLabel("");
								lblbtnVoltar2.addMouseListener(new MouseAdapter() {
									@Override
									public void mouseClicked(MouseEvent e) {
										lblbtnVoltar2.setIcon(new ImageIcon(JAluguel.class.getResource("/imagens/VOLTAR3.png")));
										tabbedPane.setSelectedIndex(1);
									}
									@Override
									public void mouseEntered(MouseEvent e) {
										lblbtnVoltar2.setIcon(new ImageIcon(JAluguel.class.getResource("/imagens/VOLTAR2.png")));
									}
									@Override
									public void mouseExited(MouseEvent e) {
										lblbtnVoltar2.setIcon(new ImageIcon(JAluguel.class.getResource("/imagens/VOLTAR1.png")));
									}
									@Override
									public void mouseReleased(MouseEvent e) {
										lblbtnVoltar2.setIcon(new ImageIcon(JAluguel.class.getResource("/imagens/VOLTAR1.png")));
									}
								});
								
								funcioField = new JTextField();
								funcioField.setFont(new Font("Dialog", Font.PLAIN, 15));
								funcioField.setEditable(false);
								editPanel.add(funcioField, "cell 8 5,grow");
								funcioField.setColumns(10);
								
								JComboBox pagamentoBox = new JComboBox();
								pagamentoBox.setFont(new Font("Dialog", Font.PLAIN, 15));
								pagamentoBox.setModel(new DefaultComboBoxModel(new String[] {"\u00C0 vista", "2 vezes"}));
								editPanel.add(pagamentoBox, "cell 10 5,grow");
								lblbtnVoltar2.setIcon(new ImageIcon(JAluguel.class.getResource("/imagens/VOLTAR1.png")));
								editPanel.add(lblbtnVoltar2, "flowx,cell 11 5,alignx right");
								
								JLabel lblbtnsalvar = new JLabel("");
								lblbtnsalvar.addMouseListener(new MouseAdapter() {
									@Override
									public void mouseClicked(MouseEvent e) {
										int i= 0;	
										int tamanho = tabelaRoupaAluguel.getModel().getRowCount();
										while(i<tamanho){
											lblbtnsalvar.setIcon(new ImageIcon(JAluguel.class.getResource("/imagens/salvar3.png")));
											r.setCodRoupa((int) tabelaRoupaAluguel.getValueAt(i, 0));
											r.setTipo((String) tabelaRoupaAluguel.getValueAt(i, 1));
											r.setModelo((String) tabelaRoupaAluguel.getValueAt(i, 2));
											r.setTamanho((String) tabelaRoupaAluguel.getValueAt(i, 3));
											r.setGenero((String) tabelaRoupaAluguel.getValueAt(i, 4));
											r.setCor((String) tabelaRoupaAluguel.getValueAt(i, 5));
											r.setPreco((float) tabelaRoupaAluguel.getValueAt(i, 6));
											
											
											Fachada.getInstancia().InserirListaFinal(r, c);
											Fachada.getInstancia().dispinibilidade(r);
											
											i++;
										}
										
										a.setPagamento(pagamentoBox.getSelectedItem().toString());
										a.setCodCliente(c.getCodCliente());
										a.setDataLoca(dataLoca.getText());
										a.setDataEntre(DataDevo.getText());
										a.setPreco(Float.parseFloat((precoFieldal.getText())));
										a.setPrecoTotal(Float.parseFloat((precoFieldFim.getText())));
										
									    f.setLogin(funcField.getText());
										Fachada.getInstancia().InserirRegistro(a,f);
										Fachada.getInstancia().limparLista();
										tabbedPane.setSelectedIndex(0);
										
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
								lblbtnsalvar.setIcon(new ImageIcon(JAluguel.class.getResource("/imagens/salvar1.png")));
								editPanel.add(lblbtnsalvar, "cell 11 5,alignx right");
					tabelaCategoria.addMouseListener(new MouseAdapter() {
						
						
					});
					
		tabelaCategoria.addMouseListener(new MouseAdapter() {
			
			
			public void mouseClicked(MouseEvent e) {
				srow = tabelaCategoria.getSelectedRow();
				svalueCpf = (String) tabelaCategoria.getValueAt(srow, 1);
				svalueName = (String) tabelaCategoria.getValueAt(srow, 0);
				c.setNome(svalueName);
				
				String pesq = "";
				pesq = svalueName;
				
				Fachada.getInstancia().BuscarClientenome(c,pesq);
				nomeField.setText(c.getNome());
				cpfField.setText(""+c.getCPF());
				
				cidadeField.setText(c.getCidade());
				estadoField.setText(c.getEstado());
				enderecoField.setText(c.getEndereco());
				numeroField.setText(""+c.getNumero());
				bairroField.setText(c.getBairro());
				telefoneField.setText(""+c.getTelefone());
				
				
					if(e.getClickCount() == 2) {
						 pesq = c.getCPF();
						 int opcao = JOptionPane.showConfirmDialog(null, "Deseja selecionar " + svalueName + "?", "Aviso", JOptionPane.YES_NO_OPTION);
							
							if (opcao == 0){
						Fachada.getInstancia().BuscarClienteCPF(c, pesq);
						
						Fachada.getInstancia().limparTabela();
						Fachada.getInstancia().BuscarRoupaEd(r);
						Fachada.getInstancia().ListarRoupaEdi(r,c);
						carregarTabelaRoupasele();
						
						btnlblAvancar.setIcon(new ImageIcon(JAluguel.class.getResource("/imagens/avan\u00E7ar3.png")));
						 pesq = c.getCPF();
						Fachada.getInstancia().BuscarClienteCPF(c, pesq);
						
						tabbedPane.setSelectedIndex(1);
							}
			
			}
			}
		});
		
		
			
		tabelaCategoria.addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent e) {
				
			
				
			}
			});
		
		try {
			MaskFormatter mascara = new MaskFormatter("###.###.###-##");
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
	

	//carregarTabela();

	}
	public void carregarTabela() {
		ClienteTableModel tableModel = (ClienteTableModel) tabelaCategoria.getModel();
		tableModel.setRowCount(0);
		for(Cliente cat : Fachada.getInstancia().listarClientes()) {
			tableModel.adicionarCategoria(cat);
		}
	}
	public void carregarTabelanome() {
		ClienteTableModel tableModel = (ClienteTableModel) tabelaCategoria.getModel();
		tableModel.setRowCount(0);
		for(Cliente cat : Fachada.getInstancia().listartodosClientespesq(pesq)) {
			tableModel.adicionarCategoria(cat);
		}
	}
	
	public void carregarTabelaRoupa() {
		RoupaTableModel tableModel = (RoupaTableModel) tabelaRoupa_1.getModel();
		tableModel.setRowCount(0);
		for(Roupa rou : Fachada.getInstancia().listarRoupasSeleEdi()) {
			tableModel.adicionarCategoria(rou);
		}
	}
	
	public void carregarTabelaRoupasele() {
		RoupaTableModel tableModel = (RoupaTableModel) tabelaRoupasele.getModel();
		tableModel.setRowCount(0);
		for(Roupa rou : Fachada.getInstancia().listarRoupaLista()) {
			tableModel.adicionarCategoria(rou);
		}
	}
	
	public void carregarTabelaRoupaLista() {
		RoupaTableModel tableModel = (RoupaTableModel) tabelaRoupaAluguel.getModel();
		tableModel.setRowCount(0);
		for(Roupa rou : Fachada.getInstancia().listarRoupaLista()) {
			tableModel.adicionarCategoria(rou);
		}
	}
		public void carregarTabelaRoupaListacod() {
			RoupaTableModel tableModel = (RoupaTableModel) tabelaRoupa_1.getModel();
			tableModel.setRowCount(0);
			for(Roupa rou : Fachada.getInstancia().listartodasRoupascod(pesq2)) {
				tableModel.adicionarCategoria(rou);
			}
	}
	
	public void limparFields(){
		nomeField.setText("");
		cpfField.setText("");
		cidadeField.setText("");
		estadoField.setText("");
		enderecoField.setText("");
		numeroField.setText("");
		bairroField.setText("");
		telefoneField.setText("");
		nomeField2.setText("");
		tipoField.setText("");
		modeloField.setText("");
		precoField2.setText("");
		precoFieldFim.setText("");
		generoField.setText("");
		dataLoca.setText("");
		DataDevo.setText("");
		tamanhoField.setText("");
		corField.setText("");
		precoFieldal.setText("");
		tabbedPane.setSelectedIndex(0);
		funcioField.setText("");
		
	}
}
