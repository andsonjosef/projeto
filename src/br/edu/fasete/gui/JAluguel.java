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

import com.mysql.jdbc.StringUtils;

import br.edu.fasete.dao.ClienteDaoJdbc;
import br.edu.fasete.dao.Conexao;
import br.edu.fasete.dao.RoupaDaoJdbc;
import br.edu.fasete.fachada.Fachada;
import br.edu.fasete.principais.Lista;
import br.edu.fasete.principais.Cliente;
import br.edu.fasete.principais.Roupa;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.time.format.TextStyle;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Color;
import java.awt.Font;
import java.awt.Panel;

import javax.swing.JFormattedTextField;
import javax.swing.DropMode;
import java.awt.Component;

public class JAluguel extends JInternalFrame {
	ClienteDaoJdbc cli = new ClienteDaoJdbc();
	RoupaDaoJdbc rou = new RoupaDaoJdbc();
	int srow;
	String svalueCpf;
	int svaluecoder;
	String svalueName;
	String vazio;
	Lista a = new Lista();
	Cliente c = new Cliente();
	Roupa r = new Roupa();
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
	private JTable tabelaRoupasele;
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
	private JTextField tamanhoField;
	private JTextField corField;
	private JTextField tipoField;
	private JTextField modeloField;
	private JTextField generoField;
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
	
	public JAluguel() {
		setIconifiable(true);
		setMaximizable(true);
		setClosable(true);
		setBounds(100, 100, 860, 640);
		
		Fachada.getInstancia().limparTabela();
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				
				
				//Carregar tabela sempre que alternar para aba de relat√≥rios
				if(tabbedPane.getSelectedIndex() == 1) {
					carregarTabelaRoupa();
					Fachada.getInstancia().limparTabela();
					carregarTabelaRoupasele();
					
					
				}
				if(tabbedPane.isShowing()) {
					Fachada.getInstancia().limparTabela();
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
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		 
		
		
		try {
			MaskFormatter mascara = new MaskFormatter("(##)####-#####");
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
				 
				try {
					MaskFormatter mascara = new MaskFormatter("###.###.###-##");
					mascara.setPlaceholderCharacter('_');
					
				
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				try {
					MaskFormatter mascara = new MaskFormatter("(##)####-####");
					mascara.setPlaceholderCharacter('_');
					
				
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					}
		
		JPanel cadast = new JPanel();
		
		tabbedPane.addTab("Cadastrar Clientes", null, cadast, null);
		tabbedPane.setEnabledAt(0, true);
		cadast.setLayout(null);
		
		JLabel labelnome = new JLabel("Nome");
		labelnome.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labelnome.setBounds(27, 275, 46, 14);
		cadast.add(labelnome);
		
				JButton btnSalvar = new JButton("Salvar");
				btnSalvar.setBounds(685, 537, 124, 34);
				cadast.add(btnSalvar);
				nomeField = new JTextField();
				nomeField.setFont(new Font("Tahoma", Font.PLAIN, 14));
				
				nomeField.setBounds(27, 295, 782, 25);
				cadast.add(nomeField);
				nomeField.setColumns(10);
				cpfField = new JFormattedTextField();
				cpfField.setFont(new Font("Tahoma", Font.PLAIN, 14));
				cpfField.setBounds(27, 345, 380, 25);
				cadast.add(cpfField);
				
					telefoneField = new JFormattedTextField();
					telefoneField.setFont(new Font("Tahoma", Font.PLAIN, 14));
					telefoneField.setBounds(432, 495, 380, 25);
					cadast.add(telefoneField);
					
					
					JLabel lblCpf = new JLabel("CPF");
					lblCpf.setFont(new Font("Tahoma", Font.PLAIN, 16));
					lblCpf.setBounds(27, 325, 46, 14);
					cadast.add(lblCpf);
					
					rgField = new JTextField();
					rgField.setFont(new Font("Tahoma", Font.PLAIN, 14));
					rgField.setBounds(432, 345, 377, 25);
					cadast.add(rgField);
					rgField.setColumns(10);
					
					JLabel lblRg = new JLabel("RG");
					lblRg.setFont(new Font("Tahoma", Font.PLAIN, 16));
					lblRg.setBounds(432, 325, 46, 14);
					cadast.add(lblRg);
					
					JLabel lblTelefone = new JLabel("Telefone");
					lblTelefone.setFont(new Font("Tahoma", Font.PLAIN, 16));
					lblTelefone.setBounds(432, 475, 68, 14);
					cadast.add(lblTelefone);
					
					JLabel lblEndereo = new JLabel("Endere\u00E7o");
					lblEndereo.setFont(new Font("Tahoma", Font.PLAIN, 16));
					lblEndereo.setBounds(27, 425, 81, 14);
					cadast.add(lblEndereo);
					
					enderecoField = new JTextField();
					enderecoField.setFont(new Font("Tahoma", Font.PLAIN, 14));
					enderecoField.setBounds(27, 445, 655, 25);
					cadast.add(enderecoField);
					enderecoField.setColumns(10);
					
					JLabel lblBairro = new JLabel("Bairro");
					lblBairro.setFont(new Font("Tahoma", Font.PLAIN, 16));
					lblBairro.setBounds(27, 475, 67, 14);
					cadast.add(lblBairro);
					
					bairroField = new JTextField();
					bairroField.setFont(new Font("Tahoma", Font.PLAIN, 14));
					bairroField.setBounds(27, 495, 380, 25);
					cadast.add(bairroField);
					bairroField.setColumns(10);
					
					JLabel lblCidade = new JLabel("Cidade");
					lblCidade.setFont(new Font("Tahoma", Font.PLAIN, 16));
					lblCidade.setBounds(27, 375, 60, 20);
					cadast.add(lblCidade);
					
					JLabel lblEstado = new JLabel("Estado");
					lblEstado.setFont(new Font("Tahoma", Font.PLAIN, 16));
					lblEstado.setBounds(432, 375, 68, 14);
					cadast.add(lblEstado);
					
					cidadeField = new JTextField();
					cidadeField.setFont(new Font("Tahoma", Font.PLAIN, 14));
					cidadeField.setBounds(27, 395, 380, 25);
					cadast.add(cidadeField);
					cidadeField.setColumns(10);
					
					estadoField = new JTextField();
					estadoField.setFont(new Font("Tahoma", Font.PLAIN, 14));
					estadoField.setBounds(432, 395, 377, 25);
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
						public void actionPerformed(ActionEvent e) {
							String pesq = c.getCPF();
							Fachada.getInstancia().BuscarClienteCPF(c, pesq);
							a.setCodCliente(c.getCodPessoa());
							tabbedPane.setSelectedIndex(1);
						}
					});
					
					
					JButton btnCancelar = new JButton("Cancelar");
					btnCancelar.setBounds(551, 537, 124, 34);
					cadast.add(btnCancelar);
					
					JLabel lblNumero = new JLabel("numero");
					lblNumero.setFont(new Font("Tahoma", Font.PLAIN, 16));
					lblNumero.setBounds(700, 425, 68, 14);
					cadast.add(lblNumero);
					
					numeroField = new JTextField();
					numeroField.setFont(new Font("Tahoma", Font.PLAIN, 14));
					numeroField.setBounds(685, 445, 124, 25);
					cadast.add(numeroField);
					numeroField.setColumns(10);
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
					scrollPane.setBounds(27, 11, 782, 253);
					cadast.add(scrollPane);
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
		
		JPanel exibirpanel = new JPanel();
		tabbedPane.addTab("Exibir Clientes", null, exibirpanel, null);
		exibirpanel.setLayout(null);
		
		JButton button_2 = new JButton("Salvar");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int linha = 0;
				
				int linhat = tabelaRoupasele.getRowCount();
				while(linha < linhat){
				r.setCodRoupa((int) tabelaRoupasele.getValueAt(linha, 0));
				linha++;
				Fachada.getInstancia().InserirLista(r, c);
				
				}
				
				
				
			}
		});
		button_2.setBounds(683, 537, 124, 34);
		exibirpanel.add(button_2);
		
		JFormattedTextField precoField = new JFormattedTextField((Object) null);
		precoField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		precoField.setBounds(430, 495, 380, 25);
		exibirpanel.add(precoField);
		
		JLabel lbltipo = new JLabel("Tipo");
		lbltipo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbltipo.setBounds(21, 378, 46, 14);
		exibirpanel.add(lbltipo);
		
		JLabel lblModelo = new JLabel("Modelo");
		lblModelo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblModelo.setBounds(430, 378, 68, 14);
		exibirpanel.add(lblModelo);
		
		JLabel lblCor = new JLabel("Cor");
		lblCor.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCor.setBounds(25, 475, 81, 14);
		exibirpanel.add(lblCor);
		
		tamanhoField = new JTextField();
		tamanhoField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tamanhoField.setColumns(10);
		tamanhoField.setBounds(25, 445, 380, 25);
		exibirpanel.add(tamanhoField);
		
		corField = new JTextField();
		corField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		corField.setColumns(10);
		corField.setBounds(25, 495, 380, 25);
		exibirpanel.add(corField);
		
		JLabel lblTamanho = new JLabel("Tamanho");
		lblTamanho.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTamanho.setBounds(25, 422, 117, 20);
		exibirpanel.add(lblTamanho);
		
		JLabel lblGenero = new JLabel("Genero");
		lblGenero.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblGenero.setBounds(430, 425, 68, 14);
		exibirpanel.add(lblGenero);
		
		tipoField = new JTextField();
		tipoField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tipoField.setColumns(10);
		tipoField.setBounds(25, 395, 380, 25);
		exibirpanel.add(tipoField);
		
		modeloField = new JTextField();
		modeloField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		modeloField.setColumns(10);
		modeloField.setBounds(430, 395, 377, 25);
		exibirpanel.add(modeloField);
		
		JButton button_3 = new JButton("Cancelar");
		button_3.setBounds(549, 537, 124, 34);
		exibirpanel.add(button_3);
		
		JLabel lblPreo = new JLabel("Pre\u00E7o");
		lblPreo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPreo.setBounds(430, 475, 68, 14);
		exibirpanel.add(lblPreo);
		
		generoField = new JTextField();
		generoField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		generoField.setColumns(10);
		generoField.setBounds(430, 445, 377, 25);
		exibirpanel.add(generoField);
		
		///
		tabelaRoupasele = new JTable(new RoupaTableModel());
		tabelaRoupasele.addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent arg0) {
				srow = tabelaRoupasele.getSelectedRow();
				
				svaluecoder = (int) tabelaRoupasele.getValueAt(srow, 0);
				
			}
			
		});
		
		tabelaRoupasele.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		JScrollPane scrollPaneRoupasele = new JScrollPane(tabelaRoupasele);
		scrollPaneRoupasele.setBounds(430, 11, 380, 311);
		exibirpanel.add(scrollPaneRoupasele);
		scrollPaneRoupasele.addMouseListener(new MouseAdapter() {
		});
		
		////
		
		tabelaRoupa = new JTable(new RoupaTableModel());
		tabelaRoupa.addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent arg0) {
				srow = tabelaRoupa.getSelectedRow();
				
				svaluecoder = (int) tabelaRoupa.getValueAt(srow, 0);
				
			}
			
		});
		
		tabelaRoupa.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		JScrollPane scrollPaneRoupa = new JScrollPane(tabelaRoupa);
		scrollPaneRoupa.setBounds(25, 11, 380, 311);
		exibirpanel.add(scrollPaneRoupa);
		
		JButton btnSelecionar = new JButton("Selecionar");
		btnSelecionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
			   int linha = tabelaRoupa.getSelectedRow();
			    r.setCodRoupa((int) tabelaRoupa.getValueAt(linha, 0));  
			   Fachada.getInstancia().InserirRoupaSele(r);
			   carregarTabelaRoupasele();
			  
			    
			}
		});
		btnSelecionar.setBounds(295, 337, 110, 23);
		exibirpanel.add(btnSelecionar);
		
		JButton btnRemover = new JButton("Remover");
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				  int linha = tabelaRoupasele.getSelectedRow();
				    r.setCodRoupa((int) tabelaRoupasele.getValueAt(linha, 0));  
				    Fachada.getInstancia().ExcluirRoupaSele(r);
				    carregarTabelaRoupasele();
			}
		});
		btnRemover.setBounds(440, 333, 89, 23);
		exibirpanel.add(btnRemover);
		scrollPaneRoupa.addMouseListener(new MouseAdapter() {
		});
		
		
		tabelaRoupa.addMouseListener(new MouseAdapter() {
public void mouseClicked(MouseEvent e) {
		if(e.getClickCount() == 2) {
		srow = tabelaRoupa.getSelectedRow();
		
		svaluecoder = (int) tabelaRoupa.getValueAt(srow, 0);
		r.setCodRoupa(svaluecoder);
		
		int pesq = svaluecoder;
		
		
		Fachada.getInstancia().BuscarRoupa(r);
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
					 JOptionPane.showMessageDialog(null,"Cliente n„o encontrado");
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
					 JOptionPane.showMessageDialog(null,"Cliente n„o encontrado");
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
	
	public void carregarTabelaRoupa() {
		RoupaTableModel tableModel = (RoupaTableModel) tabelaRoupa.getModel();
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
}
