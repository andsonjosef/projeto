package br.edu.fasete.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JLabel;
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
	String svalueCpf;
	String svalueName;
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
						svalueCpf = (String) tabelaRoupa.getValueAt(srow, 1);
						svalueName = (String) tabelaRoupa.getValueAt(srow, 0);
						
					}
					
				});
				
				
				tabelaRoupa.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				JScrollPane scrollPane = new JScrollPane(tabelaRoupa);
				scrollPane.addMouseListener(new MouseAdapter() {
				});
				
		tabelaRoupa.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount() == 2) {
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
		
		tabbedPane.addTab("Cadastrar Clientes", null, cadast, null);
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
@SuppressWarnings("resource")
public void actionPerformed(ActionEvent e) {
					Roupa r = new Roupa();
					if(tipoField.getText().isEmpty()){
						lblNomeobri.setVisible(true);
					}else{
						lblNomeobri.setVisible(false);
					}

					if(telefoneField.getText().isEmpty()){
					}
					
					r.setTipo(tipoField.getText()); 
					r.setModelo(ModeloField.getText());
					r.setPreco(Float.parseFloat((precoField.getText())));
					r.setGenero(generoField.getText());
					r.setTamanho(tamanhoField.getText());
					r.setCor(corField.getText());
					
				}
			});
		
		
		JPanel exibirpanel = new JPanel();
		tabbedPane.addTab("Exibir Clientes", null, exibirpanel, null);
		exibirpanel.setLayout(null);
		exibirpanel.add(scrollPane);
		
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				}
		});
		btnEditar.setBounds(400, 556, 124, 34);
		exibirpanel.add(btnEditar);
		
		
		btnExculir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {	
				
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
