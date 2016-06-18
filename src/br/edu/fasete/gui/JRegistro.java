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

public class JRegistro extends JInternalFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ClienteDaoJdbc cli = new ClienteDaoJdbc();
	RoupaDaoJdbc rou = new RoupaDaoJdbc();
	int srow;
	String svalueCpf;
	int svaluecoder;
	int svaluecodigoRoupa;
	int svaluecodCli;
	String svalueName;
	String vazio;
	Lista l = new Lista();
	Cliente c = new Cliente();
	Roupa r = new Roupa();
	Aluguel a = new Aluguel();
	Funcionario f = new Funcionario();
	private JTextField nomeField;
	private JTextField rgField;
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
	private JTextField precoField2;
	private JFormattedTextField datalocaField2;
	private JFormattedTextField datadevoField2;
	private JTextField precofimField2;
	private JFormattedTextField dataLoca;
	private JFormattedTextField DataDevo;
	private JTextField precoFieldal;
	private JTextField precoFieldFim;
	java.util.Date x;
	private JTextField funcField;
	private JTextField pagamentoField;
	private JTextField funcioField2;
	public JTextField logField;
	
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
	
	@SuppressWarnings({"rawtypes", "unchecked" })
	public JRegistro() {
		 
		getContentPane().setBackground(Color.DARK_GRAY);
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 1280, 720);
		
		Fachada.getInstancia().limparTabela();
		Fachada.getInstancia().limparLista();
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setForeground(Color.WHITE);
		tabbedPane.setBackground(Color.DARK_GRAY);
		tabbedPane.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if(tabbedPane.getSelectedIndex() == 0) {
					
					Fachada.getInstancia().limparTabela();
					Fachada.getInstancia().limparLista();
				}
				
				
				//Carregar tabela sempre que alternar para aba de relat√≥rios
				if(tabbedPane.getSelectedIndex() == 1) {
					carregarTabelaRoupa();
					 carregarTabela();
					carregarTabelaRoupasele();	
				}
				
				if(tabbedPane.getSelectedIndex() == 2) {
					carregarTabelaRoupa();
					carregarTabelaRoupasele();
					
					
				}
				if(tabbedPane.getSelectedIndex() == 3) {
					
					
					
				}
				
				if(tabbedPane.isShowing()) {	
					
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
		
		JPanel cadast = new JPanel();
		cadast.setBackground(Color.DARK_GRAY);
		
		tabbedPane.addTab("Registros abertos", null, cadast, null);
		tabbedPane.setEnabledAt(0, true);
		cadast.setLayout(new MigLayout("", "[101.00px,grow][31px][407px][31px][13px][28px][181px][34px][373px,grow]", "[][253px][51.00px][30px][47.00px][30px][51.00px][30px][54.00px][30px][58.00px][25px][61.00px]"));
		JComboBox pagamentoBox = new JComboBox();
		
		JLabel lblClientesComAluguel = new JLabel("Clientes com aluguel em andamento");
		lblClientesComAluguel.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblClientesComAluguel.setForeground(Color.WHITE);
		cadast.add(lblClientesComAluguel, "cell 0 0 3 1");
		JLabel labelnome = new JLabel("Nome");
		labelnome.setForeground(Color.WHITE);
		labelnome.setFont(new Font("Dialog", Font.PLAIN, 15));
		cadast.add(labelnome, "cell 0 2,alignx left,aligny bottom");
				
				JLabel lblNumero = new JLabel("numero");
				lblNumero.setForeground(Color.WHITE);
				lblNumero.setFont(new Font("Dialog", Font.PLAIN, 15));
				cadast.add(lblNumero, "cell 6 8,alignx left,aligny bottom");
				
				numeroField = new JTextField();
				numeroField.setEditable(false);
				numeroField.setFont(new Font("Dialog", Font.PLAIN, 15));
				cadast.add(numeroField, "cell 6 9 3 1,grow");
				numeroField.setColumns(10);
				nomeField = new JTextField();
				nomeField.setEditable(false);
				nomeField.setFont(new Font("Dialog", Font.PLAIN, 15));
				cadast.add(nomeField, "cell 0 3 9 1,grow");
				nomeField.setColumns(10);
				cpfField = new JFormattedTextField();
				cpfField.setEditable(false);
				cpfField.setFont(new Font("Dialog", Font.PLAIN, 15));
				cadast.add(cpfField, "cell 0 5 5 1,grow");
				
					telefoneField = new JFormattedTextField();
					telefoneField.setEditable(false);
					telefoneField.setFont(new Font("Dialog", Font.PLAIN, 15));
					cadast.add(telefoneField, "cell 6 11 3 1,grow");
					
					
					JLabel lblCpf = new JLabel("CPF");
					lblCpf.setForeground(Color.WHITE);
					lblCpf.setFont(new Font("Dialog", Font.PLAIN, 15));
					cadast.add(lblCpf, "cell 0 4,alignx left,aligny bottom");
					
					rgField = new JTextField();
					rgField.setEditable(false);
					rgField.setFont(new Font("Dialog", Font.PLAIN, 15));
					cadast.add(rgField, "cell 6 5 3 1,grow");
					rgField.setColumns(10);
					
					JLabel lblRg = new JLabel("RG");
					lblRg.setForeground(Color.WHITE);
					lblRg.setFont(new Font("Dialog", Font.PLAIN, 15));
					cadast.add(lblRg, "cell 6 4,growx,aligny bottom");
					
					JLabel lblTelefone = new JLabel("Telefone");
					lblTelefone.setForeground(Color.WHITE);
					lblTelefone.setFont(new Font("Dialog", Font.PLAIN, 15));
					cadast.add(lblTelefone, "cell 6 10,alignx left,aligny bottom");
					
					JLabel lblEndereo = new JLabel("Endere\u00E7o");
					lblEndereo.setForeground(Color.WHITE);
					lblEndereo.setFont(new Font("Dialog", Font.PLAIN, 15));
					cadast.add(lblEndereo, "cell 0 8,alignx left,aligny bottom");
					
					enderecoField = new JTextField();
					enderecoField.setEditable(false);
					enderecoField.setFont(new Font("Dialog", Font.PLAIN, 15));
					cadast.add(enderecoField, "cell 0 9 5 1,grow");
					enderecoField.setColumns(10);
					
					JLabel lblBairro = new JLabel("Bairro");
					lblBairro.setForeground(Color.WHITE);
					lblBairro.setFont(new Font("Dialog", Font.PLAIN, 15));
					cadast.add(lblBairro, "cell 0 10,alignx left,aligny bottom");
					
					bairroField = new JTextField();
					bairroField.setEditable(false);
					bairroField.setFont(new Font("Dialog", Font.PLAIN, 15));
					cadast.add(bairroField, "cell 0 11 5 1,grow");
					bairroField.setColumns(10);
					
					JLabel lblCidade = new JLabel("Cidade");
					lblCidade.setForeground(Color.WHITE);
					lblCidade.setFont(new Font("Dialog", Font.PLAIN, 15));
					cadast.add(lblCidade, "cell 0 6,alignx left,aligny bottom");
					
					JLabel lblEstado = new JLabel("Estado");
					lblEstado.setForeground(Color.WHITE);
					lblEstado.setFont(new Font("Dialog", Font.PLAIN, 15));
					cadast.add(lblEstado, "cell 6 6,alignx left,aligny bottom");
					
					cidadeField = new JTextField();
					cidadeField.setEditable(false);
					cidadeField.setFont(new Font("Dialog", Font.PLAIN, 15));
					cadast.add(cidadeField, "cell 0 7 5 1,grow");
					cidadeField.setColumns(10);
					
					estadoField = new JTextField();
					estadoField.setEditable(false);
					estadoField.setFont(new Font("Dialog", Font.PLAIN, 15));
					cadast.add(estadoField, "cell 6 7 3 1,grow");
					estadoField.setColumns(10);
					
					
					cadast.addKeyListener(new KeyAdapter() {
						@Override
						public void keyTyped(KeyEvent arg0) {

							
						}
						@Override
						public void keyReleased(KeyEvent arg0) {

						}
					});
					tabelaCategoria = new JTable(new ClienteTableModel());
					tabelaCategoria.setCellSelectionEnabled(true);
					tabelaCategoria.setFont(new Font("Tahoma", Font.PLAIN, 15));
					tabelaCategoria.addMouseListener(new MouseAdapter() {
						public void mouseReleased(MouseEvent arg0) {
							srow = tabelaCategoria.getSelectedRow();
							svalueCpf = (String) tabelaCategoria.getValueAt(srow, 1);
							svalueName = (String) tabelaCategoria.getValueAt(srow, 0);
							svaluecodCli=(int) tabelaCategoria.getValueAt(srow, 6);
						}
						
						@Override
						public void mouseClicked(MouseEvent e) {
							if(e.getClickCount() == 2) {
								int opcao = JOptionPane.showConfirmDialog(null, "Deseja visualizar o registro de " + svalueName + "?", "Aviso", JOptionPane.YES_NO_OPTION);
								
								if (opcao == 0){
							nomeField2.setText(c.getNome());
							c.setCodCliente(svaluecodCli);
							carregarTabelaRoupaLista();
							Fachada.getInstancia().ListarRegistro(c, a);
							dataLoca.setText(a.getDataLoca());
							DataDevo.setText(a.getDataEntre());
							precoFieldal.setText(""+a.getPreco());
							precoFieldFim.setText(""+a.getPrecoTotal());
							tabbedPane.setSelectedIndex(1);
								}
							}
							
						}
					});
					
					
					tabelaCategoria.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
					JScrollPane scrollPane = new JScrollPane(tabelaCategoria);
					cadast.add(scrollPane, "cell 0 1 9 1,grow");
					
					logField = new JTextField();
					cadast.add(logField, "cell 0 12,alignx center");
					logField.setColumns(10);
					logField.setVisible(false);
					
					JLabel lblbtnConfirmar = new JLabel("");
					lblbtnConfirmar.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							lblbtnConfirmar.setIcon(new ImageIcon(JRegistro.class.getResource("/imagens/confirmar3.png")));
							nomeField2.setText(c.getNome());
							c.setCodCliente(svaluecodCli);
							carregarTabelaRoupaLista();
							Fachada.getInstancia().ListarRegistro(c, a);
							dataLoca.setText(a.getDataLoca());
							DataDevo.setText(a.getDataEntre());
							precoFieldal.setText(""+a.getPreco());
							precoFieldFim.setText(""+a.getPrecoTotal());
							funcField.setText(a.getFuncionario());
							pagamentoField.setText(a.getPagamento());
							tabbedPane.setSelectedIndex(1);
						}
						@Override
						public void mouseEntered(MouseEvent arg0) {
							lblbtnConfirmar.setIcon(new ImageIcon(JAluguel.class.getResource("/imagens/avan\u00E7ar2.png")));
						}
						@Override
						public void mouseExited(MouseEvent e) {
							lblbtnConfirmar.setIcon(new ImageIcon(JAluguel.class.getResource("/imagens/avan\u00E7ar1.png")));
						}
						@Override
						public void mouseReleased(MouseEvent e) {
							lblbtnConfirmar.setIcon(new ImageIcon(JAluguel.class.getResource("/imagens/avan\u00E7ar1.png")));
						}
					});
					lblbtnConfirmar.setIcon(new ImageIcon(JRegistro.class.getResource("/imagens/avan\u00E7ar1.png")));
					cadast.add(lblbtnConfirmar, "cell 8 12,alignx right");
					
					JPanel editPanel = new JPanel();
					editPanel.setBackground(Color.DARK_GRAY);
					tabbedPane.addTab("Visualizar registro", null, editPanel, null);
					
					///
					tabelaRoupaAluguel = new JTable(new RoupaTableModel());
					tabelaRoupaAluguel.setCellSelectionEnabled(true);
					tabelaRoupaAluguel.addMouseListener(new MouseAdapter() {
						public void mouseReleased(MouseEvent arg0) {
							srow = tabelaRoupaAluguel.getSelectedRow();
							

							
						}
						
					});
					editPanel.setLayout(new MigLayout("", "[115px][30px][132px][30px][115px][30px][115px][30px][115][30][115,grow][652px,grow]", "[14px][36.00px][][547.00px][54.00px][20px][80.00px,grow]"));
					
					JLabel lblNewLabel = new JLabel("Roupas alugadas");
					lblNewLabel.setForeground(Color.WHITE);
					lblNewLabel.setFont(new Font("Dialog", Font.PLAIN, 15));
					editPanel.add(lblNewLabel, "cell 0 2 7 1");
					
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
					editPanel.add(nomeField2, "cell 0 1 12 1,growx,aligny top");
					
					JLabel lblDataDeLocao = new JLabel("Data de loca\u00E7\u00E3o");
					lblDataDeLocao.setFont(new Font("Dialog", Font.PLAIN, 15));
					lblDataDeLocao.setForeground(Color.WHITE);
					editPanel.add(lblDataDeLocao, "cell 0 4,alignx left,aligny bottom");
					
					JLabel lblFuncionrio = new JLabel("Funcion\u00E1rio");
					lblFuncionrio.setForeground(Color.WHITE);
					lblFuncionrio.setFont(new Font("Dialog", Font.PLAIN, 15));
					editPanel.add(lblFuncionrio, "cell 8 4,alignx left,aligny bottom");
					
					JLabel lblPagamento = new JLabel("Pagamento");
					lblPagamento.setForeground(Color.WHITE);
					lblPagamento.setFont(new Font("Dialog", Font.PLAIN, 15));
					editPanel.add(lblPagamento, "cell 10 4,alignx left,aligny bottom");
					
					try {
						MaskFormatter mascara = new MaskFormatter("##/##/####");
						mascara.setPlaceholderCharacter('_');
						dataLoca = new JFormattedTextField(mascara);
						dataLoca.setFont(new Font("Dialog", Font.PLAIN, 15));
						dataLoca.setEditable(false);
						editPanel.add(dataLoca, "cell 0 5,grow");
						dataLoca.setColumns(10);
						
					
					} catch (ParseException e1) {
						
						e1.printStackTrace();
					}
					
	
					JLabel lblDataDeDevoluo = new JLabel("Data de Devolu\u00E7\u00E3o");
					lblDataDeDevoluo.setFont(new Font("Dialog", Font.PLAIN, 15));
					lblDataDeDevoluo.setForeground(Color.WHITE);
					editPanel.add(lblDataDeDevoluo, "cell 2 4,growx,aligny bottom");
					
					try {
						MaskFormatter mascara = new MaskFormatter("##/##/####");
						mascara.setPlaceholderCharacter('_');
						DataDevo = new JFormattedTextField(mascara);
						DataDevo.setFont(new Font("Dialog", Font.PLAIN, 15));
						DataDevo.setEditable(false);
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
					precoFieldFim.setEditable(false);
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
					
					JLabel lblbtnEditar = new JLabel("");
					lblbtnEditar.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							lblbtnEditar.setIcon(new ImageIcon(JRegistro.class.getResource("/imagens/editar3.png")));
							Fachada.getInstancia().limparTabela();
							Fachada.getInstancia().BuscarRoupaEd(r);
							c.setCodCliente(svaluecodCli);
							Fachada.getInstancia().ListarRoupaEdi(r,c);
							carregarTabelaRoupasele();
							tabbedPane.setSelectedIndex(2);
							Fachada.getInstancia().SomaPrecoEdi(a,c);
							funcioField2.setText(logField.getText());
							precoField2.setText(""+a.getPreco());
							datadevoField2.setText(DataDevo.getText());
							datalocaField2.setText(dataLoca.getText());
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
					
					JLabel lblbtnExcluir = new JLabel("");
					lblbtnExcluir.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							lblbtnExcluir.setIcon(new ImageIcon(JRegistro.class.getResource("/imagens/excluir3.png")));
							int opcao = JOptionPane.showConfirmDialog(null, "Realmente excluir o registro?", "Aviso", JOptionPane.YES_NO_OPTION);
							if (opcao == 0){
							Fachada.getInstancia().ExcluirReg(c,a);
							tabbedPane.setSelectedIndex(0);
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
					
					JLabel lblbtnVoltar = new JLabel("");
					lblbtnVoltar.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent arg0) {
							lblbtnVoltar.setIcon(new ImageIcon(JAluguel.class.getResource("/imagens/VOLTAR3.png")));
							tabbedPane.setSelectedIndex(0);
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
					
					funcField = new JTextField();
					funcField.setFont(new Font("Dialog", Font.PLAIN, 15));
					funcField.setEditable(false);
					editPanel.add(funcField, "cell 8 5,grow");
					funcField.setColumns(10);
					
					pagamentoField = new JTextField();
					pagamentoField.setFont(new Font("Dialog", Font.PLAIN, 15));
					pagamentoField.setEditable(false);
					editPanel.add(pagamentoField, "cell 10 5,grow");
					pagamentoField.setColumns(10);
					lblbtnVoltar.setIcon(new ImageIcon(JRegistro.class.getResource("/imagens/VOLTAR1.png")));
					editPanel.add(lblbtnVoltar, "flowx,cell 11 5,alignx right,aligny bottom");
					lblbtnExcluir.setIcon(new ImageIcon(JRegistro.class.getResource("/imagens/excluir1.png")));
					editPanel.add(lblbtnExcluir, "cell 11 5,alignx right,aligny bottom");
					lblbtnEditar.setIcon(new ImageIcon(JRegistro.class.getResource("/imagens/editar1.png")));
					editPanel.add(lblbtnEditar, "cell 11 5,alignx right,aligny bottom");
					
					JPanel exibirpanel = new JPanel();
					exibirpanel.setBackground(Color.DARK_GRAY);
					tabbedPane.addTab("Editar registro", null, exibirpanel, null);
					exibirpanel.setLayout(new MigLayout("", "[115][][115][][115][][115][][115,grow][40.00][115][495.00px,trailing]", "[][459.00px][23px][55][20][55.00px,grow]"));
					
					JLabel lblbtnRemover = new JLabel("");
					lblbtnRemover.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							lblbtnRemover.setIcon(new ImageIcon(JRegistro.class.getResource("/imagens/remover3.png")));
							int linha = tabelaRoupasele.getSelectedRow();
						    r.setCodRoupa((int) tabelaRoupasele.getValueAt(linha, 0));  
						    Fachada.getInstancia().ExcluirRoupaSeleEdi(r);
						    carregarTabelaRoupasele();
						    carregarTabelaRoupa();
						    Fachada.getInstancia().SomaPrecoEdi(a,c);
						    carregarTabelaRoupasele();
						    carregarTabelaRoupa();
						    
						    precoField2.setText(""+a.getPreco());
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
							    r.setCodRoupa((int) tabelaRoupa_1.getValueAt(linha, 0));  
							   Fachada.getInstancia().InserirRoupaEdi(r, c);
							   carregarTabelaRoupasele();
							   carregarTabelaRoupa();
							   Fachada.getInstancia().SomaPrecoEdi(a,c);
							   precoField2.setText(""+a.getPreco());
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
					
					JLabel lblRoupasDisponveis = new JLabel("Roupas dispon\u00EDveis");
					lblRoupasDisponveis.setForeground(Color.WHITE);
					lblRoupasDisponveis.setFont(new Font("Dialog", Font.PLAIN, 15));
					exibirpanel.add(lblRoupasDisponveis, "cell 0 0 3 1");
					
					JLabel lblNewLabel_1 = new JLabel("Roupas selecionadas");
					lblNewLabel_1.setFont(new Font("Dialog", Font.PLAIN, 15));
					lblNewLabel_1.setForeground(Color.WHITE);
					exibirpanel.add(lblNewLabel_1, "cell 10 0 2 1");
					lblbtnAdicionar.setIcon(new ImageIcon(JRegistro.class.getResource("/imagens/Adicionar1.png")));
					exibirpanel.add(lblbtnAdicionar, "cell 8 2,alignx right");
					lblbtnRemover.setIcon(new ImageIcon(JRegistro.class.getResource("/imagens/remover1.png")));
					exibirpanel.add(lblbtnRemover, "cell 11 2,alignx right");
					
					
					///
					
					tabelaRoupasele = new JTable(new RoupaTableModel());
					tabelaRoupasele.setFont(new Font("Dialog", Font.PLAIN, 15));
					tabelaRoupasele.addMouseListener(new MouseAdapter() {
						@SuppressWarnings("unused")
						public void tabelaRoupasele(MouseEvent arg0) {
							srow = tabelaRoupaAluguel.getSelectedRow();
							
							svaluecoder = (int) tabelaRoupasele.getValueAt(srow, 0);
							
						}
						
						@Override
						public void mouseClicked(MouseEvent e) {
							if(e.getClickCount() == 2) {
							int linha = tabelaRoupasele.getSelectedRow();
						    r.setCodRoupa((int) tabelaRoupasele.getValueAt(linha, 0));  
						    Fachada.getInstancia().ExcluirRoupaSeleEdi(r);
						    carregarTabelaRoupasele();
						    carregarTabelaRoupa();
						    Fachada.getInstancia().SomaPrecoEdi(a,c);
						    precoField2.setText(""+a.getPreco());
							}
						}
					});
					
					tabelaRoupasele.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
					JScrollPane scrollPaneRoupaAluguel = new JScrollPane(tabelaRoupasele);
					exibirpanel.add(scrollPaneRoupaAluguel, "cell 10 1 2 1,grow");
					scrollPaneRoupaAluguel.addMouseListener(new MouseAdapter() {
					});
					
					////
					
					tabelaRoupa_1 = new JTable(new RoupaTableModel());
					tabelaRoupa_1.setFont(new Font("Dialog", Font.PLAIN, 15));
					tabelaRoupa_1.addMouseListener(new MouseAdapter() {
						public void mouseReleased(MouseEvent arg0) {
							srow = tabelaRoupa.getSelectedRow();
							

							
						}
						
						@Override
						public void mouseClicked(MouseEvent e) {
							if(e.getClickCount() == 2) {
								 int linha = tabelaRoupa_1.getSelectedRow();
								    r.setCodRoupa((int) tabelaRoupa_1.getValueAt(linha, 0));  
								   Fachada.getInstancia().InserirRoupaEdi(r, c);
								   carregarTabelaRoupasele();
								   carregarTabelaRoupa();
								   Fachada.getInstancia().SomaPrecoEdi(a,c);
								   precoField2.setText(""+a.getPreco());
								
							}
						}
					});
					
					tabelaRoupa_1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
					JScrollPane scrollPaneRoupa = new JScrollPane(tabelaRoupa_1);
					exibirpanel.add(scrollPaneRoupa, "cell 0 1 9 1,grow");
					
					JLabel lblDataDeLocao_1 = new JLabel("Data de Loca\u00E7\u00E3o");
					lblDataDeLocao_1.setFont(new Font("Dialog", Font.PLAIN, 15));
					lblDataDeLocao_1.setForeground(Color.WHITE);
					exibirpanel.add(lblDataDeLocao_1, "cell 0 3,aligny bottom");
					
					JLabel lblModelo = new JLabel("Data de devolu\u00E7\u00E3o");
					lblModelo.setForeground(Color.WHITE);
					lblModelo.setFont(new Font("Dialog", Font.PLAIN, 15));
					exibirpanel.add(lblModelo, "cell 2 3,growx,aligny bottom");
					
					JLabel lblTamanho = new JLabel("Pre\u00E7o");
					lblTamanho.setForeground(Color.WHITE);
					lblTamanho.setFont(new Font("Dialog", Font.PLAIN, 15));
					exibirpanel.add(lblTamanho, "cell 4 3,growx,aligny bottom");
					
					JLabel lblGenero = new JLabel("Pre\u00E7o final");
					lblGenero.setForeground(Color.WHITE);
					lblGenero.setFont(new Font("Dialog", Font.PLAIN, 15));
					exibirpanel.add(lblGenero, "cell 6 3,growx,aligny bottom");
					
					JLabel lblFuncionrio_1 = new JLabel("Funcion\u00E1rio");
					lblFuncionrio_1.setForeground(Color.WHITE);
					lblFuncionrio_1.setFont(new Font("Dialog", Font.PLAIN, 15));
					exibirpanel.add(lblFuncionrio_1, "cell 10 3,aligny bottom");
					
					try {
						MaskFormatter mascara = new MaskFormatter("##/##/####");
						mascara.setPlaceholderCharacter('_');
						datalocaField2 = new JFormattedTextField(mascara);
						datalocaField2.setFont(new Font("Dialog", Font.PLAIN, 15));
						datalocaField2.setColumns(10);
						exibirpanel.add(datalocaField2, "cell 0 4,grow");
						
						
						
						
					
					} catch (ParseException e1) {
						
						e1.printStackTrace();
					}
				
					try {
						MaskFormatter mascara = new MaskFormatter("##/##/####");
						mascara.setPlaceholderCharacter('_');
						datadevoField2 = new JFormattedTextField(mascara);
						datadevoField2.setFont(new Font("Dialog", Font.PLAIN, 15));
						datadevoField2.setColumns(10);
						exibirpanel.add(datadevoField2, "cell 2 4,grow");
						
						
						
						
					
					} catch (ParseException e1) {
						
						e1.printStackTrace();
					}
				
					
					precoField2 = new JTextField();
					precoField2.setEditable(false);
					precoField2.setFont(new Font("Dialog", Font.PLAIN, 15));
					precoField2.setColumns(10);
					exibirpanel.add(precoField2, "cell 4 4,grow");
					
					precofimField2 = new JTextField();
					precofimField2.setFont(new Font("Dialog", Font.PLAIN, 15));
					precofimField2.setColumns(10);
					exibirpanel.add(precofimField2, "cell 6 4,grow");
					
					JLabel lblbtnsalvar = new JLabel("");
					lblbtnsalvar.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							if(precofimField2.getText().isEmpty()||datadevoField2.getText().isEmpty()||datalocaField2.getText().isEmpty()){
								JOptionPane.showMessageDialog(null, "Erro. H· campos em branco.");
								
							}else{
								int opcao = JOptionPane.showConfirmDialog(null, "Realmente deseja salvar?", "Aviso", JOptionPane.YES_NO_OPTION);
								if (opcao == 0){
							lblbtnsalvar.setIcon(new ImageIcon(JRegistro.class.getResource("/imagens/salvar3.png")));
							Fachada.getInstancia().ExcluirReg(c,a);
							
							int i= 0;	
							int tamanho = tabelaRoupasele.getModel().getRowCount();
							while(i<tamanho){
								r.setCodRoupa((int) tabelaRoupasele.getValueAt(i, 0));
								r.setTipo((String) tabelaRoupasele.getValueAt(i, 1));
								r.setModelo((String) tabelaRoupasele.getValueAt(i, 2));
								r.setTamanho((String) tabelaRoupasele.getValueAt(i, 3));
								r.setGenero((String) tabelaRoupasele.getValueAt(i, 4));
								r.setCor((String) tabelaRoupasele.getValueAt(i, 5));
								r.setPreco((float) tabelaRoupasele.getValueAt(i, 6));
								
								
								Fachada.getInstancia().InserirListaFinal(r, c);
								Fachada.getInstancia().dispinibilidade(r);
								i++;
							}
							 f.setLogin(funcioField2.getText());
							 a.setPagamento(pagamentoBox.getSelectedItem().toString());
							a.setCodCliente(c.getCodCliente());
							a.setDataLoca(datalocaField2.getText());
							a.setDataEntre(datadevoField2.getText());
							a.setPreco(Float.parseFloat((precoField2.getText())));
							a.setPrecoTotal(Float.parseFloat((precofimField2.getText())));
							Fachada.getInstancia().InserirRegistro(a,f);
							
							carregarTabelaRoupaLista();
							Fachada.getInstancia().SomaPreco(a);
							tabbedPane.setSelectedIndex(0);
							}
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
					lblbtncancelar.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent arg0) {
							lblbtncancelar.setIcon(new ImageIcon(JCadastroCliente.class.getResource("/imagens/cancelar3.png")));
							Fachada.getInstancia().limparLista();
							tabbedPane.setSelectedIndex(1);
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
					
				
					pagamentoBox.setFont(new Font("Dialog", Font.PLAIN, 15));
					pagamentoBox.setModel(new DefaultComboBoxModel(new String[] {"  \u00C0 vista", "  2 vezes"}));
					exibirpanel.add(pagamentoBox, "cell 8 4,grow");
					
					funcioField2 = new JTextField();
					funcioField2.setFont(new Font("Dialog", Font.PLAIN, 15));
					funcioField2.setEditable(false);
					exibirpanel.add(funcioField2, "cell 10 4,grow");
					funcioField2.setColumns(10);
					lblbtncancelar.setIcon(new ImageIcon(JRegistro.class.getResource("/imagens/cancelar1.png")));
					exibirpanel.add(lblbtncancelar, "flowx,cell 11 4");
					
					JLabel lblbtnENcerrar = new JLabel("");
					lblbtnENcerrar.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							int opcao = JOptionPane.showConfirmDialog(null, "Realmente excluir o registro?", "Aviso", JOptionPane.YES_NO_OPTION);
							if (opcao == 0){
							lblbtnENcerrar.setIcon(new ImageIcon(JRegistro.class.getResource("/imagens/excluir3.png")));
							Fachada.getInstancia().ExcluirReg(c,a);
							tabbedPane.setSelectedIndex(0);
							}
						}
						@Override
						public void mouseEntered(MouseEvent e) {
							lblbtnENcerrar.setIcon(new ImageIcon(JCadastroCliente.class.getResource("/imagens/excluir2.png")));
						}
						@Override
						public void mouseExited(MouseEvent e) {
							lblbtnENcerrar.setIcon(new ImageIcon(JCadastroCliente.class.getResource("/imagens/excluir1.png")));
						}
						@Override
						public void mouseReleased(MouseEvent e) {
							lblbtnENcerrar.setIcon(new ImageIcon(JCadastroCliente.class.getResource("/imagens/excluir1.png")));
						}
						
					});
					lblbtnENcerrar.setIcon(new ImageIcon(JRegistro.class.getResource("/imagens/excluir1.png")));
					exibirpanel.add(lblbtnENcerrar, "cell 11 4");
					lblbtnsalvar.setIcon(new ImageIcon(JRegistro.class.getResource("/imagens/salvar1.png")));
					exibirpanel.add(lblbtnsalvar, "cell 11 4");
					scrollPaneRoupa.addMouseListener(new MouseAdapter() {
					});
					
					
					tabelaRoupa_1.addMouseListener(new MouseAdapter() {
public void mouseClicked(MouseEvent e) {
					if(e.getClickCount() == 2) {
					srow = tabelaRoupa.getSelectedRow();
					
					svaluecoder = (int) tabelaRoupa.getValueAt(srow, 0);
					r.setCodRoupa(svaluecoder);
					
					@SuppressWarnings("unused")
					int pesq = svaluecoder;
					
					
					Fachada.getInstancia().BuscarRoupa(r);
					nomeField2.setText(c.getNome());
					
					tabbedPane.setSelectedIndex(2);

}
}
});
					scrollPane.addMouseListener(new MouseAdapter() {
					});
					
		tabelaCategoria.addMouseListener(new MouseAdapter() {
			
			
			public void mouseClicked(MouseEvent e) {
				srow = tabelaCategoria.getSelectedRow();
				//svalueCpf = (String) tabelaCategoria.getValueAt(srow, 1);
				//svalueName = (String) tabelaCategoria.getValueAt(srow, 0);
				c.setNome(svalueName);
				
				String pesq = "";
				pesq = svalueName;
				
				Fachada.getInstancia().BuscarClientenome(c,pesq);
				nomeField.setText(c.getNome());
				cpfField.setText(""+c.getCPF());
				rgField.setText(c.getRG());
				cidadeField.setText(c.getCidade());
				estadoField.setText(c.getEstado());
				enderecoField.setText(c.getEndereco());
				numeroField.setText(""+c.getNumero());
				bairroField.setText(c.getBairro());
				telefoneField.setText(""+c.getTelefone());
				
				
					if(e.getClickCount() == 2) {
					
			
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
		for(Cliente cat : Fachada.getInstancia().listarClientesReg()) {
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
		for(Roupa rou : Fachada.getInstancia().listarRoupaLista()){
			tableModel.adicionarCategoria(rou);
		}
	}
	
	public void carregarTabelaRoupaLista() {
		RoupaTableModel tableModel = (RoupaTableModel) tabelaRoupaAluguel.getModel();
		tableModel.setRowCount(0);
		for(Roupa rou : Fachada.getInstancia().listarRoupaListaFim(c)) {
			tableModel.adicionarCategoria(rou);
		}
	}
	public void limparFields(){
		nomeField.setText("");
		cpfField.setText("");
		rgField.setText("");
		cidadeField.setText("");
		estadoField.setText("");
		enderecoField.setText("");
		numeroField.setText("");
		bairroField.setText("");
		telefoneField.setText("");
		nomeField2.setText("");
		precoField2.setText("");
		precoFieldFim.setText("");
		dataLoca.setText("");
		DataDevo.setText("");
		precoFieldal.setText("");
		pagamentoField.setText("");
		datalocaField2.setText("");
		datadevoField2.setText("");
		funcioField2.setText("");
		funcField.setText("");
		tabbedPane.setSelectedIndex(0);
		
	}
}
