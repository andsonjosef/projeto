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
import br.edu.fasete.principais.Roupa;
import br.edu.fasete.principais.Teste;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Color;
import java.awt.Font;
import net.miginfocom.swing.MigLayout;
import javax.swing.ImageIcon;

public class JCadastroRoupa extends JInternalFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ClienteDaoJdbc cli = new ClienteDaoJdbc();
	Teste t = new Teste();
	int srow;
	String sValueNome;
	int sValueCode;
	String vazio;
	String svaluetipo;
	Roupa r = new Roupa();
	private JTextField tipoField;
	private JTextField precoField;
	private JTextField corField;
	private JTextField generoField;
	private JTextField tamanhoField;
	private JTabbedPane tabbedPane;
	private JTable tabelaRoupa;
	private JTextField ModeloField;
	private JTextField tipoField2;
	private JTextField modeloField2;
	private JTextField generoField2;
	private JTextField tamanhoField2;
	private JTextField corField2;
	private JTextField precoField2;
	private JTextField pesqField;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JCadastroRoupa frame = new JCadastroRoupa();
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
	
	public JCadastroRoupa() {
		setTitle("Roupa");
		setFrameIcon(new ImageIcon(JCadastroRoupa.class.getResource("/imagens/iconcloset.png")));
		getContentPane().setBackground(Color.DARK_GRAY);
		setBackground(Color.DARK_GRAY);
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 1280, 720);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setForeground(Color.WHITE);
		tabbedPane.setBackground(Color.DARK_GRAY);
		tabbedPane.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				//Carregar tabela sempre que alternar para aba de relatórios
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
				tabelaRoupa = new JTable(new RoupaTableModel());
				tabelaRoupa.addMouseListener(new MouseAdapter() {
					public void mouseReleased(MouseEvent arg0) {
						srow = tabelaRoupa.getSelectedRow();
						sValueCode= (int) tabelaRoupa.getValueAt(srow, 0);
						sValueNome = (String) tabelaRoupa.getValueAt(srow, 2);
						svaluetipo = (String) tabelaRoupa.getValueAt(srow, 1); 
					}
					
				});
				
				
				tabelaRoupa.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				JScrollPane scrollPane = new JScrollPane(tabelaRoupa);
				scrollPane.addMouseListener(new MouseAdapter() {
					
				});
				
		tabelaRoupa.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount() == 2) {
					srow = tabelaRoupa.getSelectedRow();
					sValueCode= (int) tabelaRoupa.getValueAt(srow, 0);
					svaluetipo = (String) tabelaRoupa.getValueAt(srow, 1); 
					sValueNome = (String) tabelaRoupa.getValueAt(srow, 2);
					int opcao = JOptionPane.showConfirmDialog(null, "deseja visualizar " + svaluetipo + " " + sValueNome + "?", "Aviso", JOptionPane.YES_NO_OPTION);
					if (opcao == 0){	
						r.setCodRoupa(sValueCode);
						Fachada.getInstancia().BuscarRoupa(r);
						tipoField2.setText(r.getTipo());
						modeloField2.setText(r.getModelo());
						corField2.setText(r.getCor());
						precoField2.setText(""+r.getPreco());
						generoField2.setText(r.getGenero());
						tamanhoField2.setText(r.getTamanho());
						tabbedPane.setSelectedIndex(2);
						
					}
				}
			}
		});
		
		JLabel lblbtnExcluir = new JLabel("");
		JLabel lblbtnEditar = new JLabel("");	
		tabelaRoupa.addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent e) {
				
			lblbtnEditar.setEnabled(true);
				lblbtnExcluir.setEnabled(true);
				
			}
			});
		
		JPanel cadast = new JPanel();
		cadast.setBackground(Color.DARK_GRAY);
		
		tabbedPane.addTab("Cadastrar Roupas", null, cadast, null);
		tabbedPane.setEnabledAt(0, true);
		cadast.setLayout(new MigLayout("", "[136px][83px][87px][89px][203.00px][22.00][71px][237px][320.00px,grow]", "[123.00px][33px][116.00px][30px][116.00px][31px][112.00px]"));
		
		JLabel lblTipo = new JLabel("Tipo");
		lblTipo.setForeground(Color.WHITE);
		lblTipo.setFont(new Font("Dialog", Font.PLAIN, 15));
		cadast.add(lblTipo, "cell 0 0,growx,aligny bottom");
		
		JLabel lbltipoobri = new JLabel("Preenchimento obrigat\u00F3rio");
		lbltipoobri.setFont(new Font("Dialog", Font.PLAIN, 15));
		lbltipoobri.setForeground(Color.RED);
		cadast.add(lbltipoobri, "cell 4 0,growx,aligny bottom");
		lbltipoobri.setVisible(false);
		
		
		
			
			
			
		
		
		JLabel lblModelo = new JLabel("Modelo");
		lblModelo.setForeground(Color.WHITE);
		lblModelo.setFont(new Font("Dialog", Font.PLAIN, 15));
		cadast.add(lblModelo, "cell 6 0,growx,aligny bottom");
		
		JLabel lblmodeloobri = new JLabel("Preenchimento obrigat\u00F3rio");
		lblmodeloobri.setForeground(Color.RED);
		lblmodeloobri.setFont(new Font("Dialog", Font.PLAIN, 15));
		cadast.add(lblmodeloobri, "cell 8 0,alignx right,aligny bottom");
		lblmodeloobri.setVisible(false);
		
		ModeloField = new JTextField();
		cadast.add(ModeloField, "cell 6 1 3 1,grow");
		ModeloField.setColumns(10);
		
		JLabel lblGenero = new JLabel("Genero");
		lblGenero.setForeground(Color.WHITE);
		lblGenero.setFont(new Font("Dialog", Font.PLAIN, 15));
		cadast.add(lblGenero, "cell 0 2,growx,aligny bottom");
		
		JLabel lblgeneroobri = new JLabel("Preenchimento obrigat\u00F3rio");
		lblgeneroobri.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblgeneroobri.setForeground(Color.RED);
		cadast.add(lblgeneroobri, "cell 4 2,growx,aligny bottom");
		lblgeneroobri.setVisible(false);
		
		JLabel lblTamanho = new JLabel("Tamanho");
		lblTamanho.setForeground(Color.WHITE);
		lblTamanho.setFont(new Font("Dialog", Font.PLAIN, 15));
		cadast.add(lblTamanho, "cell 6 2,growx,aligny bottom");
		
		JLabel lbltamanhoobri = new JLabel("Preenchimento obrigat\u00F3rio");
		lbltamanhoobri.setForeground(Color.RED);
		lbltamanhoobri.setFont(new Font("Dialog", Font.PLAIN, 15));
		cadast.add(lbltamanhoobri, "cell 8 2,alignx right,aligny bottom");
		lbltamanhoobri.setVisible(false);
		
		generoField = new JTextField();
		generoField.setFont(new Font("Dialog", Font.PLAIN, 15));
		cadast.add(generoField, "cell 0 3 5 1,grow");
		generoField.setColumns(10);
		
		tamanhoField = new JTextField();
		tamanhoField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cadast.add(tamanhoField, "cell 6 3 3 1,grow");
		tamanhoField.setColumns(10);
		
		JLabel lblCor = new JLabel("Cor");
		lblCor.setForeground(Color.WHITE);
		lblCor.setFont(new Font("Dialog", Font.PLAIN, 15));
		cadast.add(lblCor, "cell 0 4,growx,aligny bottom");
		
		
		JLabel lblcorobri = new JLabel("Preenchimento obrigat\u00F3rio");
		lblcorobri.setForeground(Color.RED);
		lblcorobri.setFont(new Font("Dialog", Font.PLAIN, 15));
		cadast.add(lblcorobri, "cell 4 4,growx,aligny bottom");
		lblcorobri.setVisible(false);
		
		JLabel lblPreco = new JLabel("Preco");
		lblPreco.setForeground(Color.WHITE);
		lblPreco.setFont(new Font("Dialog", Font.PLAIN, 15));
		cadast.add(lblPreco, "cell 6 4,growx,aligny bottom");
		
		JLabel lblprecoobri = new JLabel("Preenchimento obrigat\u00F3rio");
		lblprecoobri.setForeground(Color.RED);
		lblprecoobri.setFont(new Font("Dialog", Font.PLAIN, 15));
		cadast.add(lblprecoobri, "cell 8 4,alignx right,aligny bottom");
		lblprecoobri.setVisible(false);
		corField = new JTextField();
		corField.setFont(new Font("Dialog", Font.PLAIN, 15));
		cadast.add(corField, "cell 0 5 5 1,grow");
		corField.setColumns(10);
		
		precoField = new JTextField();
		precoField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cadast.add(precoField, "cell 6 5 3 1,grow");
		precoField.setColumns(10);
		tipoField = new JTextField();
		tipoField.setFont(new Font("Dialog", Font.PLAIN, 15));
		cadast.add(tipoField, "cell 0 1 5 1,grow");
		tipoField.setColumns(10);
		
		cadast.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {

				
			}
			@Override
			public void keyReleased(KeyEvent arg0) {

			}
		});
			
			JLabel lblbtncancelar = new JLabel("");
			lblbtncancelar.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					lblbtncancelar.setIcon(new ImageIcon(JCadastroCliente.class.getResource("/imagens/cancelar3.png")));
					int opcao = JOptionPane.showConfirmDialog(null, "Deseja limpar os campos?", "Aviso", JOptionPane.YES_NO_OPTION);
					if (opcao == 0){	
					
						tipoField.setText("");
						ModeloField.setText("");
						precoField.setText("");
						generoField.setText("");
						tamanhoField.setText("");
						corField.setText("");
						
					}
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
			lblbtncancelar.setIcon(new ImageIcon(JCadastroRoupa.class.getResource("/imagens/cancelar1.png")));
			cadast.add(lblbtncancelar, "flowx,cell 8 6,alignx right,aligny bottom");
			
			JLabel lblbtnsalvar = new JLabel("");
			lblbtnsalvar.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					lblbtnsalvar.setIcon(new ImageIcon(JCadastroRoupa.class.getResource("/imagens/salvar3.png")));
					int opcao2 = JOptionPane.showConfirmDialog(null, "Deseja salvar?", "Aviso", JOptionPane.YES_NO_OPTION);
					if (opcao2 == 0){	
						if(tipoField.getText().isEmpty()){
							lbltipoobri.setVisible(true);
						}else{
							lbltipoobri.setVisible(false);
						}if(ModeloField.getText().isEmpty()){
							lblmodeloobri.setVisible(true);
						}else{
							lblmodeloobri.setVisible(false);
						}if(precoField.getText().isEmpty()){
							lblprecoobri.setVisible(true);
						}else{
							lblprecoobri.setVisible(false);
						}if(generoField.getText().isEmpty()){
							lblgeneroobri.setVisible(true);
						}else{
							lblgeneroobri.setVisible(false);
						}if(tamanhoField.getText().isEmpty()){
							lbltamanhoobri.setVisible(true);
						}else{
							lbltamanhoobri.setVisible(false);
						}if(corField.getText().isEmpty()){
							lblcorobri.setVisible(true);
						}else{
							lblcorobri.setVisible(false);
						}
					r.setTipo(tipoField.getText()); 
					r.setModelo(ModeloField.getText());
					r.setPreco(Float.parseFloat((precoField.getText())));
					r.setGenero(generoField.getText());
					r.setTamanho(tamanhoField.getText());
					r.setCor(corField.getText());
					r.setDisponibilidade(false);
					if(corField.getText().isEmpty()||tipoField.getText().isEmpty()||ModeloField.getText().isEmpty()||precoField.getText().isEmpty()||generoField.getText().isEmpty()||tamanhoField.getText().isEmpty()){
						
					}else{
						Fachada.getInstancia().InserirRoupa(r);
					}
					
					}
					int opcao = JOptionPane.showConfirmDialog(null, "Deseja limpar os campos?", "Aviso", JOptionPane.YES_NO_OPTION);
					if (opcao == 0){	
					
						tipoField.setText("");
						ModeloField.setText("");
						precoField.setText("");
						generoField.setText("");
						tamanhoField.setText("");
						corField.setText("");
						
					}
				}
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
			lblbtnsalvar.setIcon(new ImageIcon(JCadastroRoupa.class.getResource("/imagens/salvar1.png")));
			cadast.add(lblbtnsalvar, "cell 8 6,alignx right,aligny bottom");
		
		
		JPanel exibirpanel = new JPanel();
		exibirpanel.setBackground(Color.DARK_GRAY);
		tabbedPane.addTab("Exibir Roupas", null, exibirpanel, null);
		tabbedPane.setEnabledAt(1, true);
		exibirpanel.setLayout(new MigLayout("", "[146px][62px][124px][58px][849px,grow]", "[][504px][82.00px]"));
		
		JLabel lblClientesCadastrados = new JLabel("Roupas cadastrados");
		lblClientesCadastrados.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblClientesCadastrados.setForeground(Color.WHITE);
		exibirpanel.add(lblClientesCadastrados, "cell 0 0");
		exibirpanel.add(scrollPane, "cell 0 1 5 1,grow");
		
		
		lblbtnExcluir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblbtnExcluir.setIcon(new ImageIcon(JRegistro.class.getResource("/imagens/excluir3.png")));
				r.setCodRoupa(sValueCode);
				int opcao = JOptionPane.showConfirmDialog(null, "Realmente deseja excluir " + sValueNome + "?", "Aviso", JOptionPane.YES_NO_OPTION);
				if (opcao == 0){
					Fachada.getInstancia().ExcluirRoupa(r);
					carregarTabela();} else { 
						
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
		lblbtnExcluir.setIcon(new ImageIcon(JCadastroRoupa.class.getResource("/imagens/excluir1.png")));
		exibirpanel.add(lblbtnExcluir, "flowx,cell 4 2,alignx right,aligny bottom");
		
	
		lblbtnEditar.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				lblbtnEditar.setIcon(new ImageIcon(JCadastroCliente.class.getResource("/imagens/confirmar3.png")));
				srow = tabelaRoupa.getSelectedRow();
				sValueCode= (int) tabelaRoupa.getValueAt(srow, 0);
				svaluetipo = (String) tabelaRoupa.getValueAt(srow, 1);
				sValueNome = (String) tabelaRoupa.getValueAt(srow, 2);
				int opcao = JOptionPane.showConfirmDialog(null, "deseja visualizar " + svaluetipo + " " + sValueNome + "?", "Aviso", JOptionPane.YES_NO_OPTION);
				if (opcao == 0){	
					r.setCodRoupa(sValueCode);
					Fachada.getInstancia().BuscarRoupa(r);
					tipoField2.setText(r.getTipo());
					modeloField2.setText(r.getModelo());
					corField2.setText(r.getCor());
					precoField2.setText(""+r.getPreco());
					generoField2.setText(r.getGenero());
					tamanhoField2.setText(r.getTamanho());
					tabbedPane.setSelectedIndex(2);
					
				}
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblbtnEditar.setIcon(new ImageIcon(JCadastroCliente.class.getResource("/imagens/confirmar2.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblbtnEditar.setIcon(new ImageIcon(JCadastroCliente.class.getResource("/imagens/confirmarv1.png")));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				lblbtnEditar.setIcon(new ImageIcon(JCadastroCliente.class.getResource("/imagens/confirmarv1.png")));
			}
		});
		lblbtnEditar.setIcon(new ImageIcon(JCadastroRoupa.class.getResource("/imagens/confirmarv1.png")));
		exibirpanel.add(lblbtnEditar, "cell 4 2,aligny bottom");
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		tabbedPane.addTab("Editar Roupa", null, panel, null);
		panel.setLayout(new MigLayout("", "[637px][23.00][156px,grow]", "[108.00px][33px][105.00px][33px][105.00px][33px][105.00px][33px][grow]"));
		
		JLabel lblTipo_1 = new JLabel("Tipo");
		lblTipo_1.setForeground(Color.WHITE);
		lblTipo_1.setFont(new Font("Dialog", Font.PLAIN, 15));
		panel.add(lblTipo_1, "cell 0 0,growx,aligny bottom");
		
		JLabel lblModelo_1 = new JLabel("Modelo");
		lblModelo_1.setForeground(Color.WHITE);
		lblModelo_1.setFont(new Font("Dialog", Font.PLAIN, 15));
		panel.add(lblModelo_1, "cell 2 0,growx,aligny bottom");
		
		tipoField2 = new JTextField();
		tipoField2.setEditable(false);
		tipoField2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tipoField2.setColumns(10);
		panel.add(tipoField2, "cell 0 1,grow");
		
		modeloField2 = new JTextField();
		modeloField2.setEditable(false);
		modeloField2.setColumns(10);
		panel.add(modeloField2, "cell 2 1,grow");
		
		JLabel lblGenero_1 = new JLabel("Genero");
		lblGenero_1.setForeground(Color.WHITE);
		lblGenero_1.setFont(new Font("Dialog", Font.PLAIN, 15));
		panel.add(lblGenero_1, "cell 0 2,growx,aligny bottom");
		
		JLabel lblTamanho_1 = new JLabel("Tamanho");
		lblTamanho_1.setForeground(Color.WHITE);
		lblTamanho_1.setFont(new Font("Dialog", Font.PLAIN, 15));
		panel.add(lblTamanho_1, "cell 2 2,growx,aligny bottom");
		
		generoField2 = new JTextField();
		generoField2.setEditable(false);
		generoField2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		generoField2.setColumns(10);
		panel.add(generoField2, "cell 0 3,grow");
		
		tamanhoField2 = new JTextField();
		tamanhoField2.setEditable(false);
		tamanhoField2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tamanhoField2.setColumns(10);
		panel.add(tamanhoField2, "cell 2 3,grow");
		
		JLabel lblCor_1 = new JLabel("Cor");
		lblCor_1.setForeground(Color.WHITE);
		lblCor_1.setFont(new Font("Dialog", Font.PLAIN, 15));
		panel.add(lblCor_1, "cell 0 4,growx,aligny bottom");
		
		JLabel lblPreco_1 = new JLabel("Preco");
		lblPreco_1.setForeground(Color.WHITE);
		lblPreco_1.setFont(new Font("Dialog", Font.PLAIN, 15));
		panel.add(lblPreco_1, "cell 2 4,growx,aligny bottom");
		
		corField2 = new JTextField();
		corField2.setEditable(false);
		corField2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		corField2.setColumns(10);
		panel.add(corField2, "cell 0 5,grow");
		
		precoField2 = new JTextField();
		precoField2.setEditable(false);
		precoField2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		precoField2.setColumns(10);
		panel.add(precoField2, "cell 2 5,grow");
		
		JLabel lblPesquisar = new JLabel("Pesquisar");
		lblPesquisar.setForeground(Color.WHITE);
		lblPesquisar.setFont(new Font("Dialog", Font.PLAIN, 15));
		panel.add(lblPesquisar, "cell 0 6,growx,aligny bottom");
		
		pesqField = new JTextField();
		panel.add(pesqField, "flowx,cell 0 7,grow");
		pesqField.setColumns(10);
		
		JLabel lblbtnExcluir2 = new JLabel("");
		lblbtnExcluir2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblbtnExcluir2.setIcon(new ImageIcon(JRegistro.class.getResource("/imagens/excluir3.png")));
				int opcao = JOptionPane.showConfirmDialog(null, "Realmente deseja excluir " + modeloField2.getText() + "?", "Aviso", JOptionPane.YES_NO_OPTION);
				if (opcao == 0){
					Fachada.getInstancia().ExcluirRoupa(r);
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
		
		JLabel lblbtnCancelar = new JLabel("");
		lblbtnCancelar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int opcao = JOptionPane.showConfirmDialog(null, "Deseja cancelar a edi��o?", "Aviso", JOptionPane.YES_NO_OPTION);
				if (opcao == 0){	
				lblbtnCancelar.setIcon(new ImageIcon(JCadastroCliente.class.getResource("/imagens/cancelar3.png")));
				tipoField2.setEditable(false);
				modeloField2.setEditable(false);
				precoField2.setEditable(false);
				corField2.setEditable(false);
				precoField2.setEditable(false);
				tamanhoField2.setEditable(false);
				generoField2.setEditable(false);
				tipoField2.setText("");
				modeloField2.setText("");
				precoField2.setText("");
				corField2.setText("");
				precoField2.setText("");
				tamanhoField2.setText("");
				generoField2.setText("");
				}
				
			}
									
			@Override
			public void mouseEntered(MouseEvent e) {
				lblbtnCancelar.setIcon(new ImageIcon(JCadastroCliente.class.getResource("/imagens/cancelar2.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblbtnCancelar.setIcon(new ImageIcon(JCadastroCliente.class.getResource("/imagens/cancelar1.png")));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				lblbtnCancelar.setIcon(new ImageIcon(JCadastroCliente.class.getResource("/imagens/cancelar1.png")));
			}
		});
		lblbtnCancelar.setIcon(new ImageIcon(JCadastroRoupa.class.getResource("/imagens/cancelar1.png")));
		panel.add(lblbtnCancelar, "flowx,cell 2 7,alignx right");
		lblbtnExcluir2.setIcon(new ImageIcon(JCadastroRoupa.class.getResource("/imagens/excluir1.png")));
		panel.add(lblbtnExcluir2, "cell 2 7,alignx right");
		
		JLabel lblbtnEditar2 = new JLabel("");
		lblbtnEditar2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblbtnEditar2.setIcon(new ImageIcon(JCadastroCliente.class.getResource("/imagens/editar3.png")));
				int opcao = JOptionPane.showConfirmDialog(null, "deseja editar " + sValueNome + "?", "Aviso", JOptionPane.YES_NO_OPTION);
				if (opcao == 0){	
				
				
				tipoField2.setEditable(true);
				modeloField2.setEditable(true);
				precoField2.setEditable(true);
				corField2.setEditable(true);
				precoField2.setEditable(true);
				tamanhoField2.setEditable(true);
				generoField2.setEditable(true);
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
		lblbtnEditar2.setIcon(new ImageIcon(JCadastroRoupa.class.getResource("/imagens/editar1.png")));
		panel.add(lblbtnEditar2, "cell 2 7");
		
		JLabel lblbtnSalvar2 = new JLabel("");
		lblbtnSalvar2.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				lblbtnSalvar2.setIcon(new ImageIcon(JCadastroCliente.class.getResource("/imagens/salvar3.png")));
				if(tipoField2.getText().isEmpty()||modeloField2.getText().isEmpty()||precoField2.getText().isEmpty()||generoField2.getText().isEmpty()||tamanhoField2.getText().isEmpty()||corField2.getText().isEmpty()){
					JOptionPane.showMessageDialog(null, "Erro. H� campos em branco.");
				}else{
					int opcao = JOptionPane.showConfirmDialog(null, "Deseja salvar?", "Aviso", JOptionPane.YES_NO_OPTION);
					if (opcao == 0){	
					
					r.setTipo(tipoField2.getText()); 
					r.setModelo(modeloField2.getText());
					r.setPreco(Float.parseFloat((precoField2.getText())));
					r.setGenero(generoField2.getText());
					r.setTamanho(tamanhoField2.getText());
					r.setCor(corField2.getText());
					r.setDisponibilidade(false);
					Fachada.getInstancia().AtualizarRoupa(r);
					tipoField2.setEditable(false);
					modeloField2.setEditable(false);
					precoField2.setEditable(false);
					corField2.setEditable(false);
					precoField2.setEditable(false);
					tamanhoField2.setEditable(false);
					generoField2.setEditable(false);
					
					}
				}
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblbtnSalvar2.setIcon(new ImageIcon(JCadastroCliente.class.getResource("/imagens/salvar2.png")));
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblbtnSalvar2.setIcon(new ImageIcon(JCadastroCliente.class.getResource("/imagens/salvar1.png")));
				
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				lblbtnSalvar2.setIcon(new ImageIcon(JCadastroCliente.class.getResource("/imagens/salvar1.png")));
			}
		});
		lblbtnSalvar2.setIcon(new ImageIcon(JCadastroRoupa.class.getResource("/imagens/salvar1.png")));
		panel.add(lblbtnSalvar2, "cell 2 7");
		
		JLabel lblbtnPesquisar = new JLabel("");
		lblbtnPesquisar.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				lblbtnPesquisar.setIcon(new ImageIcon(JCadastroCliente.class.getResource("/imagens/pesquisar3.png")));
				r.setCodRoupa(Integer.parseInt((pesqField.getText())));
				Fachada.getInstancia().BuscarRoupa(r);
				tipoField2.setText(r.getTipo());
				modeloField2.setText(r.getModelo());
				corField2.setText(r.getCor());
				precoField2.setText(""+r.getPreco());
				generoField2.setText(r.getGenero());
				tamanhoField2.setText(r.getTamanho());
				tabbedPane.setSelectedIndex(2);
				
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
		lblbtnPesquisar.setIcon(new ImageIcon(JCadastroRoupa.class.getResource("/imagens/pesquisar1.png")));
		panel.add(lblbtnPesquisar, "cell 0 7,alignx right");
		
		try {
			MaskFormatter mascara = new MaskFormatter("###.###.###-##");
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
	

	}
	public void carregarTabela() {
		RoupaTableModel tableModel = (RoupaTableModel) tabelaRoupa.getModel();
		tableModel.setRowCount(0);
		for(Roupa cat : Fachada.getInstancia().listartodasRoupas()) {
			tableModel.adicionarCategoria(cat);
		}
	}
	
	public void limparFields(){
		tipoField.setText("");
		ModeloField.setText("");
		precoField.setText("");
		generoField.setText("");
		tamanhoField.setText("");
		corField.setText("");
		tipoField2.setText("");
		modeloField2.setText("");
		precoField2.setText("");
		corField2.setText("");
		precoField2.setText("");
		tamanhoField2.setText("");
		generoField2.setText("");
		pesqField.setText("");
		tabbedPane.setSelectedIndex(0);
		
	}
}
