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
import br.edu.fasete.fachada.Fachada;
import br.edu.fasete.principais.Cliente;
import br.edu.fasete.principais.Roupa;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JFormattedTextField;
import net.miginfocom.swing.MigLayout;

public class JLixeira extends JInternalFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ClienteDaoJdbc cli = new ClienteDaoJdbc();
	
	int srow;
	String svalueCpf;
	String svalueName;
	String svalueNome;
	String vazio;
	int sValueCode;
	Cliente c = new Cliente();
	Roupa r = new Roupa();
	private JTabbedPane tabbedPane;
	private JTable tabelaCategoria;
	private JTable tabelaRoupa;
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
	private JFormattedTextField cpfpesqField;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JLixeira frame = new JLixeira();
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
	
	public JLixeira() {
		setBackground(Color.DARK_GRAY);
		getContentPane().setBackground(Color.DARK_GRAY);
		setIconifiable(true);
		setClosable(true);
		
	
		setBounds(100, 100, 1280, 720);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setForeground(Color.WHITE);
		tabbedPane.setBackground(Color.DARK_GRAY);
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
				tabelaRoupa = new JTable(new RoupaTableModel());
				tabelaRoupa.addMouseListener(new MouseAdapter() {
					public void mouseReleased(MouseEvent arg0) {
						srow = tabelaRoupa.getSelectedRow();
						sValueCode = (int) tabelaRoupa.getValueAt(srow, 0);
						svalueNome = (String) tabelaRoupa.getValueAt(srow, 2);
					}
					
				});
				
				
				tabelaRoupa.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				JScrollPane scrollPane_1 = new JScrollPane(tabelaRoupa);
				scrollPane_1.addMouseListener(new MouseAdapter() {
					public void mouseReleased(MouseEvent arg0) {
						
						
						
					}
					
				});
				
		JLabel lblbtnEditar = new JLabel("");
		JLabel lblbtnExcluir = new JLabel("");
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
		tabbedPane.addTab("Clientes", null, exibirpanel, null);
		exibirpanel.setLayout(new MigLayout("", "[156px][95px][143px][14px][851px,grow]", "[504px][47px]"));
		exibirpanel.add(scrollPane, "cell 0 0 5 1,grow");
		
		
		lblbtnEditar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblbtnEditar.setIcon(new ImageIcon(JLixeira.class.getResource("/imagens/editar3.png")));
				c.setCPF(svalueCpf);
				
				int opcao = JOptionPane.showConfirmDialog(null, "Deseja restaurar " + svalueName + "?", "Aviso", JOptionPane.YES_NO_OPTION);
				if (opcao == 0){
					Fachada.getInstancia().RestaurarCliente(c);
					JCadastroCliente janelaCliente = new JCadastroCliente();
					janelaCliente.carregarTabela();
				
			} else {
				   
			}
			
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblbtnEditar.setIcon(new ImageIcon(JLixeira.class.getResource("/imagens/editar2.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblbtnEditar.setIcon(new ImageIcon(JLixeira.class.getResource("/imagens/editar1.png")));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				lblbtnEditar.setIcon(new ImageIcon(JLixeira.class.getResource("/imagens/editar1.png")));
			}
		});
		
			
			
			lblbtnExcluir.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					lblbtnExcluir.setIcon(new ImageIcon(JLixeira.class.getResource("/imagens/excluir3.png")));
					c.setCPF(svalueCpf);
					int opcao = JOptionPane.showConfirmDialog(null, "Deseja excluir " + svalueName + "?", "Aviso", JOptionPane.YES_NO_OPTION);
					if (opcao == 0){
						Fachada.getInstancia().ExcluirClienteLixe(c);
						carregarTabela();
					} else {
					}
					
				}
				@Override
				public void mouseEntered(MouseEvent e) {
					lblbtnExcluir.setIcon(new ImageIcon(JLixeira.class.getResource("/imagens/excluir2.png")));
				}
				@Override
				public void mouseExited(MouseEvent e) {
					lblbtnExcluir.setIcon(new ImageIcon(JLixeira.class.getResource("/imagens/excluir1.png")));
				}
				@Override
				public void mouseReleased(MouseEvent e) {
					lblbtnExcluir.setIcon(new ImageIcon(JLixeira.class.getResource("/imagens/excluir1.png")));
				}
			});
			lblbtnExcluir.setIcon(new ImageIcon(JLixeira.class.getResource("/imagens/excluir1.png")));
			exibirpanel.add(lblbtnExcluir, "flowx,cell 4 1,alignx right,growy");
			lblbtnEditar.setIcon(new ImageIcon(JLixeira.class.getResource("/imagens/editar1.png")));
			exibirpanel.add(lblbtnEditar, "cell 4 1,alignx right,growy");
		
		JPanel cadast = new JPanel();
		cadast.setBackground(Color.DARK_GRAY);
		
		tabbedPane.addTab("Roupas", null, cadast, null);
		cadast.setLayout(new MigLayout("", "[1075px,grow]", "[504px][70px]"));
		cadast.add(scrollPane_1, "cell 0 0,grow");
		
		JLabel lblbtnExccluir2 = new JLabel("");
		lblbtnExccluir2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblbtnExccluir2.setIcon(new ImageIcon(JRegistro.class.getResource("/imagens/excluir3.png")));
				r.setCodRoupa(sValueCode);
				int opcao = JOptionPane.showConfirmDialog(null, "Realmente deseja excluir " + svalueNome + "?", "Aviso", JOptionPane.YES_NO_OPTION);
				if (opcao == 0){
					Fachada.getInstancia().ExcluirRoupaLixe(r);
					carregarTabelaRoupa();
					} else { 
						
					}
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblbtnExccluir2.setIcon(new ImageIcon(JCadastroCliente.class.getResource("/imagens/excluir2.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblbtnExccluir2.setIcon(new ImageIcon(JCadastroCliente.class.getResource("/imagens/excluir1.png")));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				lblbtnExccluir2.setIcon(new ImageIcon(JCadastroCliente.class.getResource("/imagens/excluir1.png")));
			}
		});
		lblbtnExccluir2.setIcon(new ImageIcon(JLixeira.class.getResource("/imagens/excluir1.png")));
		cadast.add(lblbtnExccluir2, "flowx,cell 0 1,alignx right,growy");
		
		JButton btnRestaurar = new JButton("Restaurar");
		btnRestaurar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				r.setCodRoupa(sValueCode);
				int opcao = JOptionPane.showConfirmDialog(null, "Deseja Restaurar " + svalueNome + "?", "Aviso", JOptionPane.YES_NO_OPTION);
				if (opcao == 0){
					Fachada.getInstancia().RestaurarRoupa(r);
					carregarTabela();} else { 
						
					}
			}
		});
		cadast.add(btnRestaurar, "cell 0 1,alignx left,aligny center");
		tabbedPane.setBackgroundAt(1, Color.DARK_GRAY);
		tabbedPane.setEnabledAt(1, true);
		
		try {
			MaskFormatter mascara = new MaskFormatter("(##)####-####");
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
					
					cadast.addKeyListener(new KeyAdapter() {
						@Override
						public void keyTyped(KeyEvent arg0) {

							
						}
						@Override
						public void keyReleased(KeyEvent arg0) {

						}
					});
		
		JPanel editPanel = new JPanel();
		editPanel.setBackground(Color.DARK_GRAY);
		tabbedPane.addTab("Registros", null, editPanel, null);
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
				lblbtnPesquisarCPF.setIcon(new ImageIcon(JLixeira.class.getResource("/imagens/pesquisar2.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblbtnPesquisarCPF.setIcon(new ImageIcon(JLixeira.class.getResource("/imagens/pesquisar1.png")));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				lblbtnPesquisarCPF.setIcon(new ImageIcon(JLixeira.class.getResource("/imagens/pesquisar1.png")));
			}
		});
		lblbtnPesquisarCPF.setIcon(new ImageIcon(JLixeira.class.getResource("/imagens/pesquisar1.png")));
		editPanel.add(lblbtnPesquisarCPF, "cell 4 13");
		
		JLabel lblbtnSalvar = new JLabel("");
		lblbtnSalvar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblbtnSalvar.setIcon(new ImageIcon(JLixeira.class.getResource("/imagens/salvar3.png")));
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
				lblbtnSalvar.setIcon(new ImageIcon(JLixeira.class.getResource("/imagens/salvar2.png")));
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblbtnSalvar.setIcon(new ImageIcon(JLixeira.class.getResource("/imagens/salvar1.png")));
				
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				lblbtnSalvar.setIcon(new ImageIcon(JLixeira.class.getResource("/imagens/salvar1.png")));
			}
		});
		
		JLabel lblbtnEditar2 = new JLabel("");
		lblbtnEditar2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int opcao = JOptionPane.showConfirmDialog(null, "Deseja editar " + svalueName + "?", "Aviso", JOptionPane.YES_NO_OPTION);
				if (opcao == 0){
				lblbtnEditar2.setIcon(new ImageIcon(JLixeira.class.getResource("/imagens/editar3.png")));
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
				lblbtnEditar2.setIcon(new ImageIcon(JLixeira.class.getResource("/imagens/editar2.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblbtnEditar2.setIcon(new ImageIcon(JLixeira.class.getResource("/imagens/editar1.png")));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				lblbtnEditar2.setIcon(new ImageIcon(JLixeira.class.getResource("/imagens/editar1.png")));
			}
		});
		
		JLabel lblbtnExcluir2 = new JLabel("");
		lblbtnExcluir2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblbtnExcluir2.setIcon(new ImageIcon(JLixeira.class.getResource("/imagens/excluir3.png")));
				c.setCPF(svalueCpf);
				int opcao = JOptionPane.showConfirmDialog(null, "Deseja excluir " + svalueName + "?", "Aviso", JOptionPane.YES_NO_OPTION);
				if (opcao == 0){
					Fachada.getInstancia().ExcluirCliente(c);
					carregarTabela();} else {   
				}
				
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblbtnExcluir2.setIcon(new ImageIcon(JLixeira.class.getResource("/imagens/excluir2.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblbtnExcluir2.setIcon(new ImageIcon(JLixeira.class.getResource("/imagens/excluir1.png")));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				lblbtnExcluir2.setIcon(new ImageIcon(JLixeira.class.getResource("/imagens/excluir1.png")));
			}
		});
		lblbtnExcluir2.setIcon(new ImageIcon(JLixeira.class.getResource("/imagens/excluir1.png")));
		editPanel.add(lblbtnExcluir2, "cell 7 13");
		lblbtnEditar2.setIcon(new ImageIcon(JLixeira.class.getResource("/imagens/editar1.png")));
		editPanel.add(lblbtnEditar2, "cell 9 13");
		lblbtnSalvar.setIcon(new ImageIcon(JLixeira.class.getResource("/imagens/salvar1.png")));
		editPanel.add(lblbtnSalvar, "cell 11 13");
		editPanel.add(btnLimpparTela, "cell 2 14,growx,aligny bottom");
		
		JLabel lblbtnPesquisarNome = new JLabel("");
		lblbtnPesquisarNome.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblbtnPesquisarNome.setIcon(new ImageIcon(JLixeira.class.getResource("/imagens/pesquisar3.png")));
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
				lblbtnPesquisarNome.setIcon(new ImageIcon(JLixeira.class.getResource("/imagens/pesquisar2.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblbtnPesquisarNome.setIcon(new ImageIcon(JLixeira.class.getResource("/imagens/pesquisar1.png")));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				lblbtnPesquisarNome.setIcon(new ImageIcon(JLixeira.class.getResource("/imagens/pesquisar1.png")));
			}
		});
		lblbtnPesquisarNome.setIcon(new ImageIcon(JLixeira.class.getResource("/imagens/pesquisar1.png")));
		editPanel.add(lblbtnPesquisarNome, "cell 4 11");
	

	}
	public void carregarTabela() {
		ClienteTableModel tableModel = (ClienteTableModel) tabelaCategoria.getModel();
		tableModel.setRowCount(0);
		for(Cliente cat : Fachada.getInstancia().listarClienteslixe()) {
			tableModel.adicionarCategoria(cat);
		}
	}
	public void carregarTabelaRoupa() {
		RoupaTableModel tableModel = (RoupaTableModel) tabelaRoupa.getModel();
		tableModel.setRowCount(0);
		for(Roupa cat : Fachada.getInstancia().listarRoupalixe()) {
			tableModel.adicionarCategoria(cat);
		}
	}
}
