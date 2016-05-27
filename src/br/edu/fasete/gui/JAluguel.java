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
import br.edu.fasete.principais.Aluguel;
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
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class JAluguel extends JInternalFrame {
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
		
		JPanel editPanel = new JPanel();
		tabbedPane.addTab("Editar Clientes", null, editPanel, null);
		editPanel.setLayout(null);
		
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
		tabelaRoupaAluguel = new JTable(new RoupaTableModel());
		tabelaRoupaAluguel.addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent arg0) {
				srow = tabelaRoupaAluguel.getSelectedRow();
				
				svaluecoder = (int) tabelaRoupaAluguel.getValueAt(srow, 0);
				
			}
			
		});
		
		
		
		
		tabelaRoupaAluguel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		JScrollPane scrollPaneRoupasele = new JScrollPane(tabelaRoupaAluguel);
		scrollPaneRoupasele.setBounds(10, 60, 482, 311);
		editPanel.add(scrollPaneRoupasele);
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
		
		
		///
		
		tabelaRoupasele = new JTable(new RoupaTableModel());
		tabelaRoupasele.addMouseListener(new MouseAdapter() {
			public void tabelaRoupasele(MouseEvent arg0) {
				srow = tabelaRoupaAluguel.getSelectedRow();
				
				svaluecoder = (int) tabelaRoupasele.getValueAt(srow, 0);
				
			}
			
		});
		
		tabelaRoupasele.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		JScrollPane scrollPaneRoupaAluguel = new JScrollPane(tabelaRoupasele);
		scrollPaneRoupaAluguel.setBounds(430, 11, 380, 311);
		exibirpanel.add(scrollPaneRoupaAluguel);
		scrollPaneRoupaAluguel.addMouseListener(new MouseAdapter() {
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
		
		tabbedPane.setSelectedIndex(2);

}
}
});
		
		
		
		
		JLabel nomelabel2 = new JLabel("Nome");
		nomelabel2.setBounds(10, 11, 46, 14);
		editPanel.add(nomelabel2);
		
		nomeField2 = new JTextField();
		nomeField2.setEditable(false);
		nomeField2.setColumns(10);
		nomeField2.setBounds(10, 30, 482, 20);
		editPanel.add(nomeField2);
		
		JButton button = new JButton("Cancelar");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
			}
		});
		button.setBounds(554, 261, 89, 23);
		editPanel.add(button);
		
		JButton button_1 = new JButton("Salvar");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Fachada.getInstancia().InserirListaFinal(r, c);
				
			}
		});
		button_1.setBounds(704, 261, 89, 23);
		editPanel.add(button_1);
		
		JLabel lblDataDeLocao = new JLabel("Data de loca\u00E7\u00E3o");
		lblDataDeLocao.setBounds(554, 33, 97, 14);
		editPanel.add(lblDataDeLocao);
		
		dataLoca = new JTextField();
		dataLoca.setBounds(554, 58, 86, 20);
		editPanel.add(dataLoca);
		dataLoca.setColumns(10);
		
		JLabel lblDataDeDevoluo = new JLabel("Data de Devolu\u00E7\u00E3o");
		lblDataDeDevoluo.setBounds(697, 33, 132, 14);
		editPanel.add(lblDataDeDevoluo);
		
		DataDevo = new JTextField();
		DataDevo.setBounds(707, 58, 86, 20);
		editPanel.add(DataDevo);
		DataDevo.setColumns(10);
		
		precoFieldal = new JTextField();
		precoFieldal.setBounds(554, 123, 86, 20);
		editPanel.add(precoFieldal);
		precoFieldal.setColumns(10);
		
		precoFieldFim = new JTextField();
		precoFieldFim.setBounds(707, 123, 86, 20);
		editPanel.add(precoFieldFim);
		precoFieldFim.setColumns(10);
		
		JLabel lblPreo_1 = new JLabel("Pre\u00E7o");
		lblPreo_1.setBounds(554, 98, 46, 14);
		editPanel.add(lblPreo_1);
		
		JLabel lblPreoFinal = new JLabel("Pre\u00E7o final");
		lblPreoFinal.setBounds(717, 98, 62, 14);
		editPanel.add(lblPreoFinal);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Parcelado", "Pago"}));
		comboBox.setBounds(554, 177, 153, 20);
		editPanel.add(comboBox);
		
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
	
	public void carregarTabelaRoupaLista() {
		RoupaTableModel tableModel = (RoupaTableModel) tabelaRoupaAluguel.getModel();
		tableModel.setRowCount(0);
		for(Roupa rou : Fachada.getInstancia().listarRoupaLista()) {
			tableModel.adicionarCategoria(rou);
		}
	}
}
