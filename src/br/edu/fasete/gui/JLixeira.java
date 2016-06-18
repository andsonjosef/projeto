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
import javax.swing.ListSelectionModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.text.MaskFormatter;
import br.edu.fasete.dao.ClienteDaoJdbc;
import br.edu.fasete.fachada.Fachada;
import br.edu.fasete.principais.Aluguel;
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
import net.miginfocom.swing.MigLayout;
import java.awt.Font;

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
	Aluguel a = new Aluguel();
	Roupa r = new Roupa();
	private JTabbedPane tabbedPane;
	private JTable tabelaCategoria;
	private JTable tabelaCategoria2;
	private JTable tabelaRoupa;
	private JTable tabelaRoupa2;
	JCadastroCliente jc = new JCadastroCliente();
	JCadastroRoupa jr = new JCadastroRoupa();
	
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
		exibirpanel.setLayout(new MigLayout("", "[156px][95px][143px][14px][851px,grow]", "[][504px][47px]"));
		
		JLabel lblClientesExcluidos = new JLabel("Clientes excluidos");
		lblClientesExcluidos.setForeground(Color.WHITE);
		lblClientesExcluidos.setFont(new Font("Dialog", Font.PLAIN, 15));
		exibirpanel.add(lblClientesExcluidos, "cell 0 0");
		exibirpanel.add(scrollPane, "cell 0 1 5 1,grow");
		
		
		lblbtnEditar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblbtnEditar.setIcon(new ImageIcon(JLixeira.class.getResource("/imagens/restaurar3.png")));
				c.setCPF(svalueCpf);
				
				int opcao = JOptionPane.showConfirmDialog(null, "Deseja restaurar " + svalueName + "?", "Aviso", JOptionPane.YES_NO_OPTION);
				if (opcao == 0){
					Fachada.getInstancia().RestaurarCliente(c);
				
					jc.carregarTabela();
					carregarTabela();
					carregarTabelaRoupa();
					carregarTabela2();
					carregarTabela3();
				
			} else {
				   
			}
			
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblbtnEditar.setIcon(new ImageIcon(JLixeira.class.getResource("/imagens/restaurar2.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblbtnEditar.setIcon(new ImageIcon(JLixeira.class.getResource("/imagens/restaurar1.png")));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				lblbtnEditar.setIcon(new ImageIcon(JLixeira.class.getResource("/imagens/restaurar1.png")));
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
			exibirpanel.add(lblbtnExcluir, "flowx,cell 4 2,alignx right,growy");
			lblbtnEditar.setIcon(new ImageIcon(JLixeira.class.getResource("/imagens/restaurar1.png")));
			exibirpanel.add(lblbtnEditar, "cell 4 2,alignx right,growy");
		
		tabelaRoupa2 = new JTable(new RoupaTableModel());
		tabelaRoupa2.addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent arg0) {
				srow = tabelaRoupa2.getSelectedRow();
				sValueCode= (int) tabelaRoupa2.getValueAt(srow, 0);
				
			}
			
		});
		
		
		tabelaCategoria2 = new JTable(new AluguelTableModel());
		tabelaCategoria2.addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent arg0) {
				srow = tabelaCategoria2.getSelectedRow();
				sValueCode = (int) tabelaCategoria2.getValueAt(srow, 0);
				c.setCodCliente(sValueCode);
				carregarTabela2();
				
			}
			
		});
		
		
		tabelaCategoria2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		JScrollPane scrollPane3 = new JScrollPane(tabelaCategoria2);
		scrollPane3.setBounds(10, 11, 619, 575);
		scrollPane3.addMouseListener(new MouseAdapter() {
			
		});
		
		tabelaRoupa2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		JScrollPane scrollPane2 = new JScrollPane(tabelaRoupa2);
		scrollPane2.setBounds(683, 11, 566, 575);
		scrollPane2.addMouseListener(new MouseAdapter() {
			
		});
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
		
		JPanel cadast = new JPanel();
		cadast.setBackground(Color.DARK_GRAY);
		
		tabbedPane.addTab("Roupas", null, cadast, null);
		tabbedPane.setBackgroundAt(1, Color.DARK_GRAY);
		tabbedPane.setEnabledAt(1, true);
		cadast.setLayout(new MigLayout("", "[1075px,grow]", "[][504px][70px]"));
		
		JLabel lblRoupasExcluidas = new JLabel("Roupas excluidas");
		lblRoupasExcluidas.setForeground(Color.WHITE);
		lblRoupasExcluidas.setFont(new Font("Dialog", Font.PLAIN, 15));
		cadast.add(lblRoupasExcluidas, "cell 0 0");
		cadast.add(scrollPane_1, "cell 0 1,grow");
		
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
		cadast.add(lblbtnExccluir2, "flowx,cell 0 2,alignx right,growy");
		
		JLabel lblbtnRestaurar = new JLabel("");
		lblbtnRestaurar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblbtnRestaurar.setIcon(new ImageIcon(JLixeira.class.getResource("/imagens/restaurar3.png")));
				jr.carregarTabela();
				r.setCodRoupa(sValueCode);
				int opcao = JOptionPane.showConfirmDialog(null, "Deseja Restaurar " + svalueNome + "?", "Aviso", JOptionPane.YES_NO_OPTION);
				if (opcao == 0){
					Fachada.getInstancia().RestaurarRoupa(r);
					carregarTabela();
					carregarTabelaRoupa();
					carregarTabela2();
					carregarTabela3();
					} else { 
						
					}
			
			}
			public void mouseEntered(MouseEvent e) {
				lblbtnRestaurar.setIcon(new ImageIcon(JLixeira.class.getResource("/imagens/restaurar2.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblbtnRestaurar.setIcon(new ImageIcon(JLixeira.class.getResource("/imagens/restaurar1.png")));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				lblbtnRestaurar.setIcon(new ImageIcon(JLixeira.class.getResource("/imagens/restaurar1.png")));
			}
		});
		lblbtnRestaurar.setIcon(new ImageIcon(JLixeira.class.getResource("/imagens/restaurar1.png")));
		cadast.add(lblbtnRestaurar, "cell 0 2");
		
		cadast.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {

				
			}
			@Override
			public void keyReleased(KeyEvent arg0) {

			}
		});
		
		//JPanel editPanel = new JPanel();
	//	editPanel.setBackground(Color.DARK_GRAY);
		//tabbedPane.addTab("Registros", null, editPanel, null);
	//	editPanel.setLayout(null);
		//editPanel.add(scrollPane2);
		//editPanel.add(scrollPane3);
		
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
	

	}
	public void carregarTabela() {
		ClienteTableModel tableModel = (ClienteTableModel) tabelaCategoria.getModel();
		tableModel.setRowCount(0);
		for(Cliente cat : Fachada.getInstancia().listarClienteslixe()) {
			tableModel.adicionarCategoria(cat);
		}
	}
	public void carregarTabela3() {
		AluguelTableModel tableModel = (AluguelTableModel) tabelaCategoria2.getModel();
		tableModel.setRowCount(0);
		for(Aluguel cat : Fachada.getInstancia().ListarRegistrolixeira(a)){
			tableModel.adicionarAluguel(cat);
		}
	}
	public void carregarTabelaRoupa() {
		RoupaTableModel tableModel = (RoupaTableModel) tabelaRoupa.getModel();
		tableModel.setRowCount(0);
		for(Roupa cat : Fachada.getInstancia().listarRoupalixe()) {
			tableModel.adicionarCategoria(cat);
		}
	}
	public void carregarTabela2() {
		RoupaTableModel tableModel = (RoupaTableModel) tabelaRoupa2.getModel();
		tableModel.setRowCount(0);
		for(Roupa cat : Fachada.getInstancia().listarRoupaListaFimlixeira(c)) {
			tableModel.adicionarCategoria(cat);
		}
	}
}
