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
import br.edu.fasete.dao.RoupaDaoJdbc;
import br.edu.fasete.fachada.Fachada;
import br.edu.fasete.principais.Lista;
import br.edu.fasete.principais.Aluguel;
import br.edu.fasete.principais.Cliente;
import br.edu.fasete.principais.Roupa;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Font;
import javax.swing.JFormattedTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import net.miginfocom.swing.MigLayout;

public class JAluguel2 extends JInternalFrame {
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
	private JTextField tamanhoField;
	private JTextField corField;
	private JTextField tipoField;
	private JTextField modeloField;
	private JTextField generoField;
	private JTextField dataLoca;
	private JTextField DataDevo;
	private JTextField precoFieldal;
	private JTextField precoFieldFim;
	java.util.Date x;
	
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
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public JAluguel2() {
		setIconifiable(true);
		setMaximizable(true);
		setClosable(true);
		setBounds(100, 100, 1280, 720);

		Fachada.getInstancia().limparTabela();
		Fachada.getInstancia().limparLista();
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				
				
				//Carregar tabela sempre que alternar para aba de relatórios
				if(tabbedPane.getSelectedIndex() == 1) {
					carregarTabelaRoupa();
					Fachada.getInstancia().limparTabela();
					Fachada.getInstancia().limparLista();
					carregarTabelaRoupasele();	
				}
				
				if(tabbedPane.getSelectedIndex() == 2) {
					carregarTabelaRoupa();
					Fachada.getInstancia().limparTabela();
					carregarTabelaRoupaLista();
				}
				if(tabbedPane.isShowing()) {	
					Fachada.getInstancia().limparTabela();	
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
		
		tabbedPane.addTab("Cadastrar Aluguel", null, cadast, null);
		tabbedPane.setEnabledAt(0, true);
		cadast.setLayout(new MigLayout("", "[101.00px][31px][407px][31px][13px][28px][181px][34px][373px]", "[253px][51.00px][25px][47.00px][25px][51.00px][25px][54.00px][25px][58.00px][25px][61.00px]"));
		
		JLabel labelnome = new JLabel("Nome");
		labelnome.setFont(new Font("Dialog", Font.PLAIN, 15));
		cadast.add(labelnome, "cell 0 1,alignx left,aligny bottom");
		
				JButton btnSalvar = new JButton("Salvar");
				btnSalvar.setFont(new Font("Dialog", Font.PLAIN, 15));
				cadast.add(btnSalvar, "cell 0 11,growx,aligny bottom");
				nomeField = new JTextField();
				nomeField.setFont(new Font("Dialog", Font.PLAIN, 15));
				cadast.add(nomeField, "cell 0 2 9 1,grow");
				nomeField.setColumns(10);
				cpfField = new JFormattedTextField();
				cpfField.setFont(new Font("Dialog", Font.PLAIN, 15));
				cadast.add(cpfField, "cell 0 4 5 1,grow");
				
					telefoneField = new JFormattedTextField();
					telefoneField.setFont(new Font("Dialog", Font.PLAIN, 15));
					cadast.add(telefoneField, "cell 4 10 3 1,grow");
					
					
					JLabel lblCpf = new JLabel("CPF");
					lblCpf.setFont(new Font("Dialog", Font.PLAIN, 15));
					cadast.add(lblCpf, "cell 0 3,alignx left,aligny bottom");
					
					rgField = new JTextField();
					rgField.setFont(new Font("Dialog", Font.PLAIN, 15));
					cadast.add(rgField, "cell 6 4 3 1,grow");
					rgField.setColumns(10);
					
					JLabel lblRg = new JLabel("RG");
					lblRg.setFont(new Font("Dialog", Font.PLAIN, 15));
					cadast.add(lblRg, "cell 6 3 3 1,growx,aligny bottom");
					
					JLabel lblTelefone = new JLabel("Telefone");
					lblTelefone.setFont(new Font("Dialog", Font.PLAIN, 15));
					cadast.add(lblTelefone, "cell 4 9 3 1,alignx left,aligny bottom");
					
					JLabel lblEndereo = new JLabel("Endere\u00E7o");
					lblEndereo.setFont(new Font("Dialog", Font.PLAIN, 15));
					cadast.add(lblEndereo, "cell 0 7,alignx left,aligny bottom");
					
					enderecoField = new JTextField();
					enderecoField.setFont(new Font("Dialog", Font.PLAIN, 15));
					cadast.add(enderecoField, "cell 0 8 7 1,grow");
					enderecoField.setColumns(10);
					
					JLabel lblBairro = new JLabel("Bairro");
					lblBairro.setFont(new Font("Dialog", Font.PLAIN, 15));
					cadast.add(lblBairro, "cell 0 9,alignx left,aligny bottom");
					
					bairroField = new JTextField();
					bairroField.setFont(new Font("Dialog", Font.PLAIN, 15));
					cadast.add(bairroField, "cell 0 10 3 1,grow");
					bairroField.setColumns(10);
					
					JLabel lblCidade = new JLabel("Cidade");
					lblCidade.setFont(new Font("Dialog", Font.PLAIN, 15));
					cadast.add(lblCidade, "cell 0 5,alignx left,aligny bottom");
					
					JLabel lblEstado = new JLabel("Estado");
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
					
	
					
					//------------------------SALVAR--------------------------------------
					
					btnSalvar.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							String pesq = c.getCPF();
							Fachada.getInstancia().BuscarClienteCPF(c, pesq);
							
							tabbedPane.setSelectedIndex(1);
						}
					});
					
					
					JButton btnCancelar = new JButton("Cancelar");
					btnCancelar.setFont(new Font("Dialog", Font.PLAIN, 15));
					cadast.add(btnCancelar, "cell 2 11,alignx left,aligny bottom");
					
					JLabel lblNumero = new JLabel("numero");
					lblNumero.setFont(new Font("Dialog", Font.PLAIN, 15));
					cadast.add(lblNumero, "cell 8 7,alignx left,aligny bottom");
					
					numeroField = new JTextField();
					numeroField.setFont(new Font("Dialog", Font.PLAIN, 15));
					cadast.add(numeroField, "cell 8 8,alignx left,growy");
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
					cadast.add(scrollPane, "cell 0 0 9 1,grow");
					
					JPanel exibirpanel = new JPanel();
					tabbedPane.addTab("Selecionar Roupas", null, exibirpanel, null);
					
					JButton button_2 = new JButton("Salvar");
					button_2.setFont(new Font("Dialog", Font.PLAIN, 15));
					button_2.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							int linha = 0;
							
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
							
							carregarTabelaRoupaLista();
							Fachada.getInstancia().SomaPreco(a);
							precoFieldal.setText(""+a.getPreco());
							tabbedPane.setSelectedIndex(2);
						}
					});
					exibirpanel.setLayout(new MigLayout("", "[128px][42px][124px][168px][133.00px][623px]", "[311px][23px][47.00px][25px][42.00px][25px][42.00px][25px][55.00px]"));
					exibirpanel.add(button_2, "cell 0 8,growx,aligny bottom");
					
					JFormattedTextField precoField = new JFormattedTextField((Object) null);
					precoField.setFont(new Font("Dialog", Font.PLAIN, 15));
					exibirpanel.add(precoField, "cell 5 7,grow");
					
					JLabel lbltipo = new JLabel("Tipo");
					lbltipo.setFont(new Font("Dialog", Font.PLAIN, 15));
					exibirpanel.add(lbltipo, "cell 0 2 5 1,grow");
					
					JLabel lblModelo = new JLabel("Modelo");
					lblModelo.setFont(new Font("Dialog", Font.PLAIN, 15));
					exibirpanel.add(lblModelo, "cell 5 2,grow");
					
					JLabel lblCor = new JLabel("Cor");
					lblCor.setFont(new Font("Dialog", Font.PLAIN, 15));
					exibirpanel.add(lblCor, "cell 0 6 5 1,grow");
					
					tamanhoField = new JTextField();
					tamanhoField.setFont(new Font("Dialog", Font.PLAIN, 15));
					tamanhoField.setColumns(10);
					exibirpanel.add(tamanhoField, "cell 0 5 5 1,grow");
					
					corField = new JTextField();
					corField.setFont(new Font("Dialog", Font.PLAIN, 15));
					corField.setColumns(10);
					exibirpanel.add(corField, "cell 0 7 5 1,grow");
					
					JLabel lblTamanho = new JLabel("Tamanho");
					lblTamanho.setFont(new Font("Dialog", Font.PLAIN, 15));
					exibirpanel.add(lblTamanho, "cell 0 4 5 1,growx,aligny top");
					
					JLabel lblGenero = new JLabel("Genero");
					lblGenero.setFont(new Font("Dialog", Font.PLAIN, 15));
					exibirpanel.add(lblGenero, "cell 5 4,growx,aligny top");
					
					tipoField = new JTextField();
					tipoField.setFont(new Font("Dialog", Font.PLAIN, 15));
					tipoField.setColumns(10);
					exibirpanel.add(tipoField, "cell 0 3 5 1,grow");
					
					modeloField = new JTextField();
					modeloField.setFont(new Font("Dialog", Font.PLAIN, 15));
					modeloField.setColumns(10);
					exibirpanel.add(modeloField, "cell 5 3,grow");
					
					JButton button_3 = new JButton("Cancelar");
					button_3.setFont(new Font("Dialog", Font.PLAIN, 15));
					exibirpanel.add(button_3, "cell 2 8,growx,aligny bottom");
					
					JLabel lblPreo = new JLabel("Pre\u00E7o");
					lblPreo.setFont(new Font("Dialog", Font.PLAIN, 15));
					exibirpanel.add(lblPreo, "cell 5 6,grow");
					
					generoField = new JTextField();
					generoField.setFont(new Font("Dialog", Font.PLAIN, 15));
					generoField.setColumns(10);
					exibirpanel.add(generoField, "cell 5 5,grow");
					
					
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
					exibirpanel.add(scrollPaneRoupaAluguel, "cell 5 0,grow");
					scrollPaneRoupaAluguel.addMouseListener(new MouseAdapter() {
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
					exibirpanel.add(scrollPaneRoupa, "cell 0 0 5 1,grow");
					
					JButton btnSelecionar = new JButton("Selecionar");
					btnSelecionar.setFont(new Font("Dialog", Font.PLAIN, 15));
					btnSelecionar.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
						
						   int linha = tabelaRoupa_1.getSelectedRow();
						    r.setCodRoupa((int) tabelaRoupa_1.getValueAt(linha, 0));  
						   Fachada.getInstancia().InserirRoupaSele(r);
						   carregarTabelaRoupasele();
						  
						    
						}
					});
					exibirpanel.add(btnSelecionar, "cell 4 1,grow");
					
					JButton btnRemover = new JButton("Remover");
					btnRemover.setFont(new Font("Dialog", Font.PLAIN, 15));
					btnRemover.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							
							  int linha = tabelaRoupasele.getSelectedRow();
							    r.setCodRoupa((int) tabelaRoupasele.getValueAt(linha, 0));  
							    Fachada.getInstancia().ExcluirRoupaSele(r);
							    carregarTabelaRoupasele();
						}
					});
					exibirpanel.add(btnRemover, "cell 5 1,alignx left,growy");
					scrollPaneRoupa.addMouseListener(new MouseAdapter() {
					});
					
					
					tabelaRoupa_1.addMouseListener(new MouseAdapter() {
public void mouseClicked(MouseEvent e) {
	srow = tabelaRoupa_1.getSelectedRow();
	
	r.setCodRoupa( (int) tabelaRoupa_1.getValueAt(srow, 0));
	Fachada.getInstancia().BuscarRoupa(r);
	tipoField.setText(r.getTipo());
	modeloField.setText(r.getModelo());
	tamanhoField.setText(r.getTamanho());
	corField.setText(r.getCor());
	generoField.setText(r.getGenero());
	precoField.setText(""+r.getPreco());
					if(e.getClickCount() == 2) {
					

}
}
});
					
					JPanel editPanel = new JPanel();
					tabbedPane.addTab("Concluir Aluguel", null, editPanel, null);
					
					///
					tabelaRoupaAluguel = new JTable(new RoupaTableModel());
					tabelaRoupaAluguel.addMouseListener(new MouseAdapter() {
						public void mouseReleased(MouseEvent arg0) {
							srow = tabelaRoupaAluguel.getSelectedRow();
							
							svaluecoder = (int) tabelaRoupaAluguel.getValueAt(srow, 0);
							
						}
						
					});
					editPanel.setLayout(new MigLayout("", "[111px][30px][132px][30px][86px][67px][86px][45px][652px]", "[14px][36.00px][396.00px][54.00px][20px][80.00px]"));
					
					
					
					
					tabelaRoupaAluguel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
					JScrollPane scrollPaneRoupasele = new JScrollPane(tabelaRoupaAluguel);
					editPanel.add(scrollPaneRoupasele, "cell 0 2 9 1,grow");
					scrollPaneRoupasele.addMouseListener(new MouseAdapter() {
					});
					
					
					
					
					JLabel nomelabel2 = new JLabel("Nome");
					editPanel.add(nomelabel2, "cell 0 0,alignx left,aligny top");
					
					nomeField2 = new JTextField();
					nomeField2.setEditable(false);
					nomeField2.setColumns(10);
					editPanel.add(nomeField2, "cell 0 1 9 1,growx,aligny top");
					
					JButton button = new JButton("Cancelar");
					button.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							
							
						}
					});
					editPanel.add(button, "cell 0 5,alignx right,aligny bottom");
					
					JButton button_1 = new JButton("Salvar");
					button_1.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) 
						{
							
							int i= 0;	
							int tamanho = tabelaRoupaAluguel.getModel().getRowCount();
							while(i<tamanho){
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
							
							a.setCodCliente(c.getCodCliente());
							a.setDataLoca(dataLoca.getText());
							a.setDataEntre(DataDevo.getText());
							a.setPreco(Float.parseFloat((precoFieldal.getText())));
							a.setPrecoTotal(Float.parseFloat((precoFieldFim.getText())));
							Fachada.getInstancia().InserirRegistro(a);
							
							
							
						}
					});
					editPanel.add(button_1, "cell 2 5,alignx left,aligny bottom");
					
					JLabel lblDataDeLocao = new JLabel("Data de loca\u00E7\u00E3o");
					editPanel.add(lblDataDeLocao, "cell 0 3,growx,aligny bottom");
					
					dataLoca = new JTextField();
					editPanel.add(dataLoca, "cell 0 4,alignx left,aligny top");
					dataLoca.setColumns(10);
					
					JLabel lblDataDeDevoluo = new JLabel("Data de Devolu\u00E7\u00E3o");
					editPanel.add(lblDataDeDevoluo, "cell 2 3,growx,aligny bottom");
					
					DataDevo = new JTextField();
					editPanel.add(DataDevo, "cell 2 4,alignx left,aligny top");
					DataDevo.setColumns(10);
					
					precoFieldal = new JTextField();
					precoFieldal.setEditable(false);
					editPanel.add(precoFieldal, "cell 4 4,alignx left,aligny top");
					precoFieldal.setColumns(10);
					
					precoFieldFim = new JTextField();
					editPanel.add(precoFieldFim, "cell 6 4,alignx left,aligny top");
					precoFieldFim.setColumns(10);
					
					JLabel lblPreo_1 = new JLabel("Pre\u00E7o");
					editPanel.add(lblPreo_1, "cell 4 3,alignx center,aligny bottom");
					
					JLabel lblPreoFinal = new JLabel("Pre\u00E7o final");
					editPanel.add(lblPreoFinal, "cell 6 3,alignx center,aligny bottom");
					
					JComboBox comboBox = new JComboBox();
					comboBox.setModel(new DefaultComboBoxModel(new String[] {"Parcelado", "Pago"}));
					editPanel.add(comboBox, "cell 8 4,alignx left,aligny top");
					scrollPane.addMouseListener(new MouseAdapter() {
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
	
carregarTabela();
	}
	public void carregarTabela() {
		ClienteTableModel tableModel = (ClienteTableModel) tabelaCategoria.getModel();
		tableModel.setRowCount(0);
		for(Cliente cat : Fachada.getInstancia().listarClientes()) {
			tableModel.adicionarCategoria(cat);
		}
	}
	
	public void carregarTabelaRoupa() {
		RoupaTableModel tableModel = (RoupaTableModel) tabelaRoupa_1.getModel();
		tableModel.setRowCount(0);
		for(Roupa rou : Fachada.getInstancia().listarRoupas()) {
			tableModel.adicionarCategoria(rou);
		}
	}
	
	public void carregarTabelaRoupasele() {
		RoupaTableModel tableModel = (RoupaTableModel) tabelaRoupasele.getModel();
		tableModel.setRowCount(0);
		for(Roupa rou : Fachada.getInstancia().listarRoupasSele()) {
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
}
