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

public class JCadastroRoupa2 extends JInternalFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ClienteDaoJdbc cli = new ClienteDaoJdbc();
	int srow;
	String sValueNome;
	int sValueCode;
	String vazio;
	Roupa r = new Roupa();
	private JTextField tipoField;
	private JTextField precoField;
	private JTextField corField;
	private JTextField generoField;
	private JTextField tamanhoField;
	private JTabbedPane tabbedPane;
	private JTable tabelaRoupa;
	private JFormattedTextField telefoneField;
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
					JCadastroRoupa2 frame = new JCadastroRoupa2();
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
	
	public JCadastroRoupa2() {
		setIconifiable(true);
		setMaximizable(true);
		setClosable(true);
		setBounds(100, 100, 1280, 720);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
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
					
		
		JButton btnExculir = new JButton("Exculir");
		btnExculir.setEnabled(false);
		
				JButton btnEditar = new JButton("Editar");
				btnEditar.setEnabled(false);
				tabelaRoupa = new JTable(new RoupaTableModel());
				tabelaRoupa.addMouseListener(new MouseAdapter() {
					public void mouseReleased(MouseEvent arg0) {
						srow = tabelaRoupa.getSelectedRow();
						sValueCode= (int) tabelaRoupa.getValueAt(srow, 0);
						sValueNome = (String) tabelaRoupa.getValueAt(srow, 2);
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
					sValueNome = (String) tabelaRoupa.getValueAt(srow, 2);
					int opcao = JOptionPane.showConfirmDialog(null, "deseja editar " + sValueNome + "?", "Aviso", JOptionPane.YES_NO_OPTION);
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
		scrollPane.setBounds(0, 11, 1249, 504);
		
		
			
		tabelaRoupa.addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent e) {
				
				btnEditar.setEnabled(true);
				btnExculir.setEnabled(true);
				
			}
			});
		
		JPanel cadast = new JPanel();
		
		tabbedPane.addTab("Cadastrar Roupa", null, cadast, null);
		tabbedPane.setEnabledAt(0, true);
		cadast.setLayout(new MigLayout("", "[84px,grow][23px][46px][69px][160px][162.00px][81.00][71.00px][124px][54.00px][172.00][84,grow]", "[53px][33.00px][53px][30px][39px][30px][54px][30px][56px][31px][91.00px]"));
		
		JLabel lblTipo = new JLabel("Tipo");
		lblTipo.setFont(new Font("Dialog", Font.PLAIN, 15));
		cadast.add(lblTipo, "cell 2 0 2 1,alignx left,aligny bottom");
		
		JLabel lblNomeobri = new JLabel("Preenchmento obrigat\u00F3rio");
		lblNomeobri.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblNomeobri.setForeground(Color.RED);
		cadast.add(lblNomeobri, "cell 5 0,alignx left,aligny bottom");
		lblNomeobri.setVisible(false);
		
		
		
			
			
			
		
		
		JLabel lblModelo = new JLabel("Modelo");
		lblModelo.setFont(new Font("Dialog", Font.PLAIN, 15));
		cadast.add(lblModelo, "cell 7 0,alignx left,aligny bottom");
		
		ModeloField = new JTextField();
		cadast.add(ModeloField, "cell 7 1 4 1,grow");
		ModeloField.setColumns(10);
		
		JLabel lblGenero = new JLabel("Genero");
		lblGenero.setFont(new Font("Dialog", Font.PLAIN, 15));
		cadast.add(lblGenero, "cell 2 4 2 1,alignx left,aligny bottom");
		
		JLabel lblcidadeobri = new JLabel("Preenchmento obrigat\u00F3rio");
		lblcidadeobri.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblcidadeobri.setForeground(Color.RED);
		cadast.add(lblcidadeobri, "cell 5 4,growx,aligny bottom");
		lblcidadeobri.setVisible(false);
		
		JLabel lblTamanho = new JLabel("Tamanho");
		lblTamanho.setFont(new Font("Dialog", Font.PLAIN, 15));
		cadast.add(lblTamanho, "cell 7 4,growx,aligny bottom");
		
		JLabel lblestadoobri = new JLabel("Preenchmento obrigat\u00F3rio");
		lblestadoobri.setForeground(Color.RED);
		lblestadoobri.setFont(new Font("Dialog", Font.PLAIN, 15));
		cadast.add(lblestadoobri, "cell 10 4,alignx left,aligny bottom");
		lblestadoobri.setVisible(false);
		
		generoField = new JTextField();
		generoField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cadast.add(generoField, "cell 2 5 4 1,grow");
		generoField.setColumns(10);
		
		tamanhoField = new JTextField();
		tamanhoField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cadast.add(tamanhoField, "cell 7 5 4 1,grow");
		tamanhoField.setColumns(10);
		
		JLabel lblCor = new JLabel("Cor");
		lblCor.setFont(new Font("Dialog", Font.PLAIN, 15));
		cadast.add(lblCor, "cell 2 8 2 1,growx,aligny bottom");
		
		
		JLabel lblBairroobri = new JLabel("Preenchmento obrigat\u00F3rio");
		lblBairroobri.setForeground(Color.RED);
		lblBairroobri.setFont(new Font("Dialog", Font.PLAIN, 15));
		cadast.add(lblBairroobri, "cell 5 8,alignx left,aligny bottom");
		lblBairroobri.setVisible(false);
		
		JLabel lblPreco = new JLabel("Preco");
		lblPreco.setFont(new Font("Dialog", Font.PLAIN, 15));
		cadast.add(lblPreco, "cell 7 8,growx,aligny bottom");
		
		corField = new JTextField();
		corField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cadast.add(corField, "cell 2 9 4 1,grow");
		corField.setColumns(10);
		
		precoField = new JTextField();
		precoField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cadast.add(precoField, "cell 7 9 4 1,grow");
		precoField.setColumns(10);
		tipoField = new JTextField();
		tipoField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cadast.add(tipoField, "cell 2 1 4 1,grow");
		tipoField.setColumns(10);
		
		cadast.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {

				
			}
			@Override
			public void keyReleased(KeyEvent arg0) {

			}
		});
		
		JButton btnLimparTela = new JButton("Limpar tela");
		btnLimparTela.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnLimparTela.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tipoField.setText("");
				
				precoField.setText("");
				generoField.setText("");
				tamanhoField.setText("");
				corField.setText("");
				
				telefoneField.setText("");
				
			}
		});
		cadast.add(btnLimparTela, "cell 8 10,aligny bottom");
		
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cadast.add(btnCancelar, "cell 10 10,aligny bottom");
		
			
			
				
				
				
		
			JButton btnSalvar = new JButton("Salvar");
			btnSalvar.setFont(new Font("Tahoma", Font.PLAIN, 15));
			cadast.add(btnSalvar, "cell 11 10,aligny bottom");
			
			
			
			//------------------------SALVAR--------------------------------------
			
btnSalvar.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
					Roupa r = new Roupa();


					
					r.setTipo(tipoField.getText()); 
					r.setModelo(ModeloField.getText());
					r.setPreco(Float.parseFloat((precoField.getText())));
					r.setGenero(generoField.getText());
					r.setTamanho(tamanhoField.getText());
					r.setCor(corField.getText());
					r.setDisponibilidade(false);
					Fachada.getInstancia().InserirRoupa(r);
				}
			});
		
		
		JPanel exibirpanel = new JPanel();
		tabbedPane.addTab("Exibir Roupa", null, exibirpanel, null);
		exibirpanel.setLayout(null);
		exibirpanel.add(scrollPane);
		
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					srow = tabelaRoupa.getSelectedRow();
					sValueCode= (int) tabelaRoupa.getValueAt(srow, 0);
					sValueNome = (String) tabelaRoupa.getValueAt(srow, 2);
					int opcao = JOptionPane.showConfirmDialog(null, "deseja editar " + sValueNome + "?", "Aviso", JOptionPane.YES_NO_OPTION);
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
		});
		btnEditar.setBounds(400, 556, 124, 34);
		exibirpanel.add(btnEditar);
		
		
		btnExculir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {	
				r.setCodRoupa(sValueCode);
				int opcao = JOptionPane.showConfirmDialog(null, "Realmente deseja excluir " + sValueNome + "?", "Aviso", JOptionPane.YES_NO_OPTION);
				if (opcao == 0){
					Fachada.getInstancia().ExcluirRoupa(r);
					carregarTabela();} else { 
						
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
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Editar Roupa", null, panel, null);
		panel.setLayout(new MigLayout("", "[84,grow][450px,grow][81][110][110][110][120.00px][84]", "[53][33px][130][33px][130][33px][130][33]"));
		
		JLabel lblTipo_1 = new JLabel("Tipo");
		lblTipo_1.setFont(new Font("Dialog", Font.PLAIN, 15));
		panel.add(lblTipo_1, "cell 1 0,aligny bottom");
		
		JLabel lblModelo_1 = new JLabel("Modelo");
		lblModelo_1.setFont(new Font("Dialog", Font.PLAIN, 15));
		panel.add(lblModelo_1, "cell 3 0,aligny bottom");
		
		tipoField2 = new JTextField();
		tipoField2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tipoField2.setColumns(10);
		panel.add(tipoField2, "cell 1 1,grow");
		
		modeloField2 = new JTextField();
		modeloField2.setColumns(10);
		panel.add(modeloField2, "cell 3 1 4 1,grow");
		
		JLabel lblGenero_1 = new JLabel("Genero");
		lblGenero_1.setFont(new Font("Dialog", Font.PLAIN, 15));
		panel.add(lblGenero_1, "cell 1 2,aligny bottom");
		
		JLabel lblTamanho_1 = new JLabel("Tamanho");
		lblTamanho_1.setFont(new Font("Dialog", Font.PLAIN, 15));
		panel.add(lblTamanho_1, "cell 3 2,aligny bottom");
		
		generoField2 = new JTextField();
		generoField2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		generoField2.setColumns(10);
		panel.add(generoField2, "cell 1 3,grow");
		
		tamanhoField2 = new JTextField();
		tamanhoField2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tamanhoField2.setColumns(10);
		panel.add(tamanhoField2, "cell 3 3 4 1,grow");
		
		JLabel lblCor_1 = new JLabel("Cor");
		lblCor_1.setFont(new Font("Dialog", Font.PLAIN, 15));
		panel.add(lblCor_1, "cell 1 4,aligny bottom");
		
		JLabel lblPreco_1 = new JLabel("Preco");
		lblPreco_1.setFont(new Font("Dialog", Font.PLAIN, 15));
		panel.add(lblPreco_1, "cell 3 4,aligny bottom");
		
		corField2 = new JTextField();
		corField2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		corField2.setColumns(10);
		panel.add(corField2, "cell 1 5,grow");
		
		precoField2 = new JTextField();
		precoField2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		precoField2.setColumns(10);
		panel.add(precoField2, "cell 3 5 4 1,grow");
		
		JLabel lblPesquisar = new JLabel("Pesquisar");
		lblPesquisar.setFont(new Font("Dialog", Font.PLAIN, 15));
		panel.add(lblPesquisar, "cell 1 6,aligny bottom");
		
		pesqField = new JTextField();
		panel.add(pesqField, "cell 1 7,grow");
		pesqField.setColumns(10);
		
		JButton btnNewButton = new JButton("Pesquisar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(btnNewButton, "flowx,cell 3 7,alignx right,growy");
		
		JButton btnEditar_1 = new JButton("Editar");
		btnEditar_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(btnEditar_1, "cell 4 7,alignx right,growy");
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int opcao = JOptionPane.showConfirmDialog(null, "Realmente deseja excluir " + sValueNome + "?", "Aviso", JOptionPane.YES_NO_OPTION);
				if (opcao == 0){
					Fachada.getInstancia().ExcluirRoupa(r);
					carregarTabela();} else { 
						
					}
			}
		});
		btnExcluir.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(btnExcluir, "cell 5 7,alignx right,growy");
		
		JButton btnSalvar_1 = new JButton("Salvar");
		btnSalvar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				r.setTipo(tipoField2.getText()); 
				r.setModelo(modeloField2.getText());
				r.setPreco(Float.parseFloat((precoField2.getText())));
				r.setGenero(generoField2.getText());
				r.setTamanho(tamanhoField2.getText());
				r.setCor(corField2.getText());
				r.setDisponibilidade(false);
				Fachada.getInstancia().AtualizarRoupa(r);
				
				
			}
		});
		btnSalvar_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(btnSalvar_1, "cell 6 7,alignx right,growy");
		
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
		for(Roupa cat : Fachada.getInstancia().listarRoupas()) {
			tableModel.adicionarCategoria(cat);
		}
	}
}
