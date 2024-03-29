package br.edu.fasete.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.beans.PropertyVetoException;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.security.CodeSource;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import br.edu.fasete.principais.Funcionario;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JDesktopPane;
import javax.swing.JFileChooser;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.InputMap;

import java.awt.Color;
import java.awt.HeadlessException;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

import java.awt.Toolkit;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JComponent;

public class Principal extends JFrame {


	private static final long serialVersionUID = 1L;

	private JPanel contentPane_1;
	
	private JDesktopPane desktop_1;
	
	
	Funcionario f = new Funcionario();
	JCadastroCliente2 janelaCliente = new JCadastroCliente2();
	JMenu menuCliente = new JMenu("");
	JCadastroRoupa2 janelaRoupa = new JCadastroRoupa2();
	JMenu menuRoupa = new JMenu("");
	JAluguel2 janelaAluguel = new JAluguel2();
	JMenu menuAluguel = new JMenu("");
	JRegistro2 janelaRegistro = new JRegistro2();
	JMenu menuRegistro = new JMenu("");
	JFuncionario janelaFuncionario = new JFuncionario();
	JMenu menuFuncionario = new JMenu("");
	JLixeira janelaLixeira = new JLixeira();
	JMenu menuLixeira = new JMenu("");
	JRelatorio janelaRelatorio = new JRelatorio();
	JMenu menuRelatorio = new JMenu("");
	private final JMenu menuBackup = new JMenu("");
	private final JMenuItem mntmCriarBackup = new JMenuItem("Criar Backup");
	private final JMenuItem mntmRestaurarDeBackup = new JMenuItem("Restaurar de Backup");
	private final JMenu menuLixeiro = new JMenu("");
	JTextField textField;
	String texto1;
	private JLabel label_1 = new JLabel("");
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
            //here you can put the selected theme class name in JTattoo
            UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel");
 
		} catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					Principal frame = new Principal();
					frame.pack();
					frame.setBackground(Color.DARK_GRAY);
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
	public Principal(){
		setTitle("Closet");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Principal.class.getResource("/imagens/iconcloset.png")));
		addMouseListener(new MouseAdapter() {
			
		});
		setForeground(Color.DARK_GRAY);
		setBackground(Color.DARK_GRAY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 700);
		setExtendedState(MAXIMIZED_BOTH);
		
		InputMap inputMap = this.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
		inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_F2, 0),"forward");
		this.getRootPane().setInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW, inputMap);
		this.getRootPane().getActionMap().put("forward", new AbstractAction(){
		    private static final long serialVersionUID = 1L;
		    @Override
		    public void actionPerformed(ActionEvent arg0) {
		        System.out.println("F2 foi pressionado");
		       
		    }
		});
		
		//this.setUndecorated(true);        
		
		//this.getRootPane().setWindowDecorationStyle(JRootPane.FRAME);
		
		JMenuBar barraMenu = new JMenuBar();
		barraMenu.setForeground(Color.DARK_GRAY);
		barraMenu.setBackground(Color.DARK_GRAY);
		setJMenuBar(barraMenu);
		
		

		
		
		menuCliente.setForeground(Color.WHITE);
		
			menuCliente.setIcon(new ImageIcon(Principal.class.getResource("/imagens/iconemenu.png")));
		
		
		
		menuCliente.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				if(janelaCliente.isShowing()==false){
					menuCliente.setIcon(new ImageIcon(Principal.class.getResource("/imagens/iconemenu2.png")));
					}if(janelaCliente.isShowing()==true){
						menuCliente.setIcon(new ImageIcon(Principal.class.getResource("/imagens/iconemenu3.png")));	
					}
			}
			@Override
			public void mouseExited(MouseEvent e) {
				if(janelaCliente.isShowing()==false){
				menuCliente.setIcon(new ImageIcon(Principal.class.getResource("/imagens/iconemenu.png")));
				}if(janelaCliente.isShowing()==true){
					menuCliente.setIcon(new ImageIcon(Principal.class.getResource("/imagens/iconemenu3.png")));	
				}
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				
				
				
				if(janelaCliente.isFocusable()==true){
					desktop_1.add(janelaCliente);
					janelaCliente.setVisible(true);
				
					janelaCliente.carregarTabela();
					menuCliente.setIcon(new ImageIcon(Principal.class.getResource("/imagens/iconemenu3.png")));
					menuRegistro.setIcon(new ImageIcon(Principal.class.getResource("/imagens/Registrolmenu.png")));
					menuAluguel.setIcon(new ImageIcon(Principal.class.getResource("/imagens/aluguelmenu1.png")));
					menuRoupa.setIcon(new ImageIcon(Principal.class.getResource("/imagens/roupamenu1.png")));
					menuFuncionario.setIcon(new ImageIcon(Principal.class.getResource("/imagens/funcimenu.png")));
					menuLixeiro.setIcon(new ImageIcon(Principal.class.getResource("/imagens/lixeiramenu.png")));
					janelaLixeira.dispose();
					janelaRoupa.dispose();
					janelaAluguel.dispose();
					janelaRegistro.dispose();
					janelaFuncionario.dispose();
					janelaCliente.limparFields();
					
				}
				try {
					janelaCliente.setMaximum(true);
				} catch (PropertyVetoException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		
		});
		barraMenu.add(menuCliente);
		
		////
		ActionListener menucluienttc = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(janelaCliente.isFocusable()==true){
					desktop_1.add(janelaCliente);
					janelaCliente.setVisible(true);
				
					janelaCliente.carregarTabela();
					menuCliente.setIcon(new ImageIcon(Principal.class.getResource("/imagens/iconemenu3.png")));
					menuRegistro.setIcon(new ImageIcon(Principal.class.getResource("/imagens/Registrolmenu.png")));
					menuAluguel.setIcon(new ImageIcon(Principal.class.getResource("/imagens/aluguelmenu1.png")));
					menuRoupa.setIcon(new ImageIcon(Principal.class.getResource("/imagens/roupamenu1.png")));
					menuFuncionario.setIcon(new ImageIcon(Principal.class.getResource("/imagens/funcimenu.png")));
					menuLixeiro.setIcon(new ImageIcon(Principal.class.getResource("/imagens/lixeiramenu.png")));
					janelaLixeira.dispose();
					janelaRoupa.dispose();
					janelaAluguel.dispose();
					janelaRegistro.dispose();
					janelaFuncionario.dispose();
					janelaCliente.limparFields();
					
				}
				try {
					janelaCliente.setMaximum(true);
				} catch (PropertyVetoException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		};
		menuCliente.addActionListener(menucluienttc);
		menuCliente.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("F1"), "teste");	
		menuCliente.getActionMap().put("teste", new AbstractAction("teste") {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				menucluienttc.actionPerformed(arg0);
				
			}
		});
		menuRoupa.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				if(janelaRoupa.isFocusable()==true){
					desktop_1.add(janelaRoupa);
					janelaRoupa.setVisible(true);
					janelaRoupa.carregarTabela();
					menuRegistro.setIcon(new ImageIcon(Principal.class.getResource("/imagens/Registrolmenu.png")));
					menuCliente.setIcon(new ImageIcon(Principal.class.getResource("/imagens/iconemenu.png")));
					menuAluguel.setIcon(new ImageIcon(Principal.class.getResource("/imagens/aluguelmenu1.png")));
					menuRoupa.setIcon(new ImageIcon(Principal.class.getResource("/imagens/roupamenu3.png")));
					menuFuncionario.setIcon(new ImageIcon(Principal.class.getResource("/imagens/funcimenu.png")));
					menuLixeiro.setIcon(new ImageIcon(Principal.class.getResource("/imagens/lixeiramenu.png")));
					janelaLixeira.dispose();
					janelaCliente.dispose();
					janelaAluguel.dispose();
					janelaRegistro.dispose();
					janelaRoupa.limparFields();
				}
				try {
					janelaRoupa.setMaximum(true);
				} catch (PropertyVetoException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				if(janelaRoupa.isShowing()==false){
					menuRoupa.setIcon(new ImageIcon(Principal.class.getResource("/imagens/roupamenu2.png")));
					}if(janelaRoupa.isShowing()==true){
						menuRoupa.setIcon(new ImageIcon(Principal.class.getResource("/imagens/roupamenu3.png")));
					}
			}
			@Override
			public void mouseExited(MouseEvent e) {
				if(janelaRoupa.isShowing()==false){
					menuRoupa.setIcon(new ImageIcon(Principal.class.getResource("/imagens/roupamenu1.png")));
				}if(janelaRoupa.isShowing()==true){
					menuRoupa.setIcon(new ImageIcon(Principal.class.getResource("/imagens/roupamenu3.png")));
				}
			}
		});
		
		
		menuRoupa.setIcon(new ImageIcon(Principal.class.getResource("/imagens/roupamenu1.png")));
		menuRoupa.setForeground(Color.WHITE);
		barraMenu.add(menuRoupa);
		
	ActionListener menuroupatc = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(janelaRoupa.isFocusable()==true){
					desktop_1.add(janelaRoupa);
					janelaRoupa.setVisible(true);
					janelaRoupa.carregarTabela();
					menuRegistro.setIcon(new ImageIcon(Principal.class.getResource("/imagens/Registrolmenu.png")));
					menuCliente.setIcon(new ImageIcon(Principal.class.getResource("/imagens/iconemenu.png")));
					menuAluguel.setIcon(new ImageIcon(Principal.class.getResource("/imagens/aluguelmenu1.png")));
					menuRoupa.setIcon(new ImageIcon(Principal.class.getResource("/imagens/roupamenu3.png")));
					menuFuncionario.setIcon(new ImageIcon(Principal.class.getResource("/imagens/funcimenu.png")));
					menuLixeiro.setIcon(new ImageIcon(Principal.class.getResource("/imagens/lixeiramenu.png")));
					janelaLixeira.dispose();
					janelaCliente.dispose();
					janelaAluguel.dispose();
					janelaRegistro.dispose();
					janelaRoupa.limparFields();
				}
				try {
					janelaRoupa.setMaximum(true);
				} catch (PropertyVetoException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		};
		menuRoupa.addActionListener(menuroupatc);
		menuRoupa.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("F2"), "teste2");	
		menuRoupa.getActionMap().put("teste2", new AbstractAction("teste2") {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				menuroupatc.actionPerformed(arg0);
				
			}
		});
		
		
		
		////
		
		
		menuAluguel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textField.getText();
				
				janelaAluguel.funcField.setText(textField.getText());
				if(janelaAluguel.isFocusable()==true){
					desktop_1.add(janelaAluguel);
					janelaAluguel.setVisible(true);
					janelaAluguel.carregarTabela();
					janelaAluguel.carregarTabelaRoupa();
					janelaAluguel.carregarTabelaRoupaLista();
					janelaAluguel.carregarTabelaRoupasele();
					menuCliente.setIcon(new ImageIcon(Principal.class.getResource("/imagens/iconemenu.png")));
					menuRegistro.setIcon(new ImageIcon(Principal.class.getResource("/imagens/Registrolmenu.png")));
					menuRoupa.setIcon(new ImageIcon(Principal.class.getResource("/imagens/roupamenu1.png")));
					menuAluguel.setIcon(new ImageIcon(Principal.class.getResource("/imagens/aluguelmenu3.png")));
					menuFuncionario.setIcon(new ImageIcon(Principal.class.getResource("/imagens/funcimenu.png")));
					menuLixeiro.setIcon(new ImageIcon(Principal.class.getResource("/imagens/lixeiramenu.png")));
					janelaLixeira.dispose();
					janelaCliente.dispose();
					janelaRoupa.dispose();
					janelaRegistro.dispose();
					janelaAluguel.limparFields();
					
				}
				
				try {
					janelaAluguel.setMaximum(true);
				} catch (PropertyVetoException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				if(janelaAluguel.isShowing()==false){
					menuAluguel.setIcon(new ImageIcon(Principal.class.getResource("/imagens/aluguelmenu2.png")));
					}if(janelaAluguel.isShowing()==true){
						menuAluguel.setIcon(new ImageIcon(Principal.class.getResource("/imagens/aluguelmenu3.png")));
					}
			}
			@Override
			public void mouseExited(MouseEvent e) {
				if(janelaAluguel.isShowing()==false){
					menuAluguel.setIcon(new ImageIcon(Principal.class.getResource("/imagens/aluguelmenu1.png")));
				}if(janelaAluguel.isShowing()==true){
					menuAluguel.setIcon(new ImageIcon(Principal.class.getResource("/imagens/aluguelmenu3.png")));
				}
			}
		});
		
		
		
		menuAluguel.setIcon(new ImageIcon(Principal.class.getResource("/imagens/aluguelmenu1.png")));
		menuAluguel.setForeground(Color.WHITE);
		barraMenu.add(menuAluguel);
		
		
		
	ActionListener menualugueltc = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				janelaAluguel.funcField.setText(textField.getText());
				if(janelaAluguel.isFocusable()==true){
					desktop_1.add(janelaAluguel);
					janelaAluguel.setVisible(true);
					janelaAluguel.carregarTabela();
					janelaAluguel.carregarTabelaRoupa();
					janelaAluguel.carregarTabelaRoupaLista();
					janelaAluguel.carregarTabelaRoupasele();
					menuCliente.setIcon(new ImageIcon(Principal.class.getResource("/imagens/iconemenu.png")));
					menuRegistro.setIcon(new ImageIcon(Principal.class.getResource("/imagens/Registrolmenu.png")));
					menuRoupa.setIcon(new ImageIcon(Principal.class.getResource("/imagens/roupamenu1.png")));
					menuAluguel.setIcon(new ImageIcon(Principal.class.getResource("/imagens/aluguelmenu3.png")));
					menuFuncionario.setIcon(new ImageIcon(Principal.class.getResource("/imagens/funcimenu.png")));
					menuLixeiro.setIcon(new ImageIcon(Principal.class.getResource("/imagens/lixeiramenu.png")));
					janelaLixeira.dispose();
					janelaCliente.dispose();
					janelaRoupa.dispose();
					janelaRegistro.dispose();
					janelaAluguel.limparFields();
					
				}
				
				try {
					janelaAluguel.setMaximum(true);
				} catch (PropertyVetoException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		};
		menuAluguel.addActionListener(menualugueltc);
		menuAluguel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("F3"), "teste3");	
		menuAluguel.getActionMap().put("teste3", new AbstractAction("teste3") {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				menualugueltc.actionPerformed(arg0);
				
			}
		});
		
		
		
		
	menuRegistro.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			janelaRegistro.logField.setText(texto1);
			desktop_1.add(janelaRegistro);
			janelaRegistro.setVisible(true);
			if(janelaRegistro.isFocusable()==true){
				janelaRegistro.carregarTabela();
				janelaRegistro.carregarTabelaRoupa();
				janelaRegistro.carregarTabelaRoupaLista();
				janelaRegistro.carregarTabelaRoupasele();
				menuRegistro.setIcon(new ImageIcon(Principal.class.getResource("/imagens/Registrolmenu3.png")));
				menuFuncionario.setIcon(new ImageIcon(Principal.class.getResource("/imagens/iconemenu.png")));
				menuAluguel.setIcon(new ImageIcon(Principal.class.getResource("/imagens/aluguelmenu1.png")));
				menuRoupa.setIcon(new ImageIcon(Principal.class.getResource("/imagens/roupamenu1.png")));
				menuFuncionario.setIcon(new ImageIcon(Principal.class.getResource("/imagens/funcimenu.png")));
				menuLixeiro.setIcon(new ImageIcon(Principal.class.getResource("/imagens/lixeiramenu.png")));
				janelaLixeira.dispose();
				janelaAluguel.dispose();
				janelaRoupa.dispose();
				janelaFuncionario.dispose();
				janelaRegistro.limparFields();
			}
			
			try {
				janelaRegistro.setMaximum(true);
			} catch (PropertyVetoException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}			
		}
		@Override
		public void mouseEntered(MouseEvent e) {
			if(janelaRegistro.isShowing()==false){
				menuRegistro.setIcon(new ImageIcon(Principal.class.getResource("/imagens/Registrolmenu2.png")));
				}if(janelaRegistro.isShowing()==true){
					menuRegistro.setIcon(new ImageIcon(Principal.class.getResource("/imagens/Registrolmenu3.png")));
				}
		}
		@Override
		public void mouseExited(MouseEvent e) {
			if(janelaRegistro.isShowing()==false){
				menuRegistro.setIcon(new ImageIcon(Principal.class.getResource("/imagens/Registrolmenu.png")));
			}if(janelaRegistro.isShowing()==true){
				menuRegistro.setIcon(new ImageIcon(Principal.class.getResource("/imagens/Registrolmenu3.png")));
			}
		}
	});
		
	ActionListener menuregistrottc = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			janelaRegistro.logField.setText(texto1);
			desktop_1.add(janelaRegistro);
			janelaRegistro.setVisible(true);
			if(janelaRegistro.isFocusable()==true){
				janelaRegistro.carregarTabela();
				janelaRegistro.carregarTabelaRoupa();
				janelaRegistro.carregarTabelaRoupaLista();
				janelaRegistro.carregarTabelaRoupasele();
				menuRegistro.setIcon(new ImageIcon(Principal.class.getResource("/imagens/Registrolmenu3.png")));
				menuFuncionario.setIcon(new ImageIcon(Principal.class.getResource("/imagens/iconemenu.png")));
				menuAluguel.setIcon(new ImageIcon(Principal.class.getResource("/imagens/aluguelmenu1.png")));
				menuRoupa.setIcon(new ImageIcon(Principal.class.getResource("/imagens/roupamenu1.png")));
				menuFuncionario.setIcon(new ImageIcon(Principal.class.getResource("/imagens/funcimenu.png")));
				menuLixeiro.setIcon(new ImageIcon(Principal.class.getResource("/imagens/lixeiramenu.png")));
				janelaLixeira.dispose();
				janelaAluguel.dispose();
				janelaRoupa.dispose();
				janelaFuncionario.dispose();
				janelaRegistro.limparFields();
			}
			
			try {
				janelaRegistro.setMaximum(true);
			} catch (PropertyVetoException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}	
			
		}
	};
	menuRegistro.addActionListener(menuregistrottc);
	menuRegistro.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("F4"), "teste4");	
	menuRegistro.getActionMap().put("teste4", new AbstractAction("teste4") {
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			menuregistrottc.actionPerformed(arg0);
			
		}
	});
		
	
	menuRegistro.setIcon(new ImageIcon(Principal.class.getResource("/imagens/Registrolmenu.png")));
	menuRegistro.setForeground(Color.WHITE);
	barraMenu.add(menuRegistro);
	
	///
	
	menuFuncionario.setForeground(Color.WHITE);
	
	menuFuncionario.setIcon(new ImageIcon(Principal.class.getResource("/imagens/funcimenu.png")));
	
	
	
	menuFuncionario.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseEntered(MouseEvent e) {
			if(janelaFuncionario.isShowing()==false){
				menuFuncionario.setIcon(new ImageIcon(Principal.class.getResource("/imagens/funcimenu2.png")));
				}if(janelaFuncionario.isShowing()==true){
					menuFuncionario.setIcon(new ImageIcon(Principal.class.getResource("/imagens/funcimenu3.png")));
				}
		}
		@Override
		public void mouseExited(MouseEvent e) {
			if(janelaFuncionario.isShowing()==false){
				menuFuncionario.setIcon(new ImageIcon(Principal.class.getResource("/imagens/funcimenu.png")));
			}if(janelaFuncionario.isShowing()==true){
				menuFuncionario.setIcon(new ImageIcon(Principal.class.getResource("/imagens/funcimenu3.png")));
			}
		}
		@Override
		public void mouseClicked(MouseEvent e) {
			
			if(menuFuncionario.isEnabled()==false){
			}else{	
			if(janelaFuncionario.isFocusable()==true){
				desktop_1.add(janelaFuncionario);
				janelaFuncionario.setVisible(true);
				menuCliente.setIcon(new ImageIcon(Principal.class.getResource("/imagens/iconemenu.png")));
				menuFuncionario.setIcon(new ImageIcon(Principal.class.getResource("/imagens/funcimenu3.png")));
				menuRegistro.setIcon(new ImageIcon(Principal.class.getResource("/imagens/Registrolmenu.png")));
				menuAluguel.setIcon(new ImageIcon(Principal.class.getResource("/imagens/aluguelmenu1.png")));
				menuRoupa.setIcon(new ImageIcon(Principal.class.getResource("/imagens/roupamenu1.png")));
				menuLixeiro.setIcon(new ImageIcon(Principal.class.getResource("/imagens/lixeiramenu.png")));
				janelaLixeira.dispose();
				janelaRoupa.dispose();
				janelaAluguel.dispose();
				janelaRegistro.dispose();
				janelaCliente.dispose();
				janelaFuncionario.limparFields();
				
			}
			try {
				janelaFuncionario.setMaximum(true);
			} catch (PropertyVetoException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		}
	
	});
	
	barraMenu.add(menuFuncionario);
	menuBackup.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent arg0) {
			menuBackup.setIcon(new ImageIcon(Principal.class.getResource("/imagens/backupbotao3.png")));
		}
		public void mouseEntered(MouseEvent e) {
			
			menuBackup.setIcon(new ImageIcon(Principal.class.getResource("/imagens/backupbotao2.png")));
				
		}
		@Override
		public void mouseExited(MouseEvent e) {
			menuBackup.setIcon(new ImageIcon(Principal.class.getResource("/imagens/backupbotao1.png")));
		}
	});
	menuRelatorio.setIcon(new ImageIcon(Principal.class.getResource("/imagens/relatoriolmenu1.png")));
	
	
	menuRelatorio.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			
			if(menuRelatorio.isEnabled()==false){
			}else{	
			if(janelaRelatorio.isFocusable()==true){
				janelaRelatorio.carregarTabelanome();
				desktop_1.add(janelaRelatorio);
				janelaRelatorio.setVisible(true);
			//	menuCliente.setIcon(new ImageIcon(Principal.class.getResource("/imagens/iconemenu.png")));
				//menuFuncionario.setIcon(new ImageIcon(Principal.class.getResource("/imagens/funcimenu1.png")));
				menuRegistro.setIcon(new ImageIcon(Principal.class.getResource("/imagens/Registrolmenu.png")));
				menuAluguel.setIcon(new ImageIcon(Principal.class.getResource("/imagens/aluguelmenu1.png")));
				menuRoupa.setIcon(new ImageIcon(Principal.class.getResource("/imagens/roupamenu1.png")));
				menuLixeiro.setIcon(new ImageIcon(Principal.class.getResource("/imagens/lixeiramenu.png")));
				menuRelatorio.setIcon(new ImageIcon(Principal.class.getResource("/imagens/relatoriolmenu3.png")));
				janelaLixeira.dispose();
				janelaRoupa.dispose();
				janelaAluguel.dispose();
				janelaRegistro.dispose();
				janelaCliente.dispose();
				janelaFuncionario.limparFields();
				
			}
			try {
				janelaRelatorio.setMaximum(true);
			} catch (PropertyVetoException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
			
		}
		@Override
		public void mouseEntered(MouseEvent e) {
			if(janelaRelatorio.isShowing()==false){
				menuRelatorio.setIcon(new ImageIcon(Principal.class.getResource("/imagens/relatoriolmenu2.png")));
				}if(janelaRegistro.isShowing()==true){
					menuRelatorio.setIcon(new ImageIcon(Principal.class.getResource("/imagens/relatoriolmenu3.png")));
				}
		}
		@Override
		public void mouseExited(MouseEvent e) {
			if(janelaRelatorio.isShowing()==false){
				menuRelatorio.setIcon(new ImageIcon(Principal.class.getResource("/imagens/relatoriolmenu1.png")));
			}if(janelaRelatorio.isShowing()==true){
				menuRelatorio.setIcon(new ImageIcon(Principal.class.getResource("/imagens/relatoriolmenu1.png")));
			}
		}
	
	});
	barraMenu.add(menuFuncionario);
	menuBackup.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent arg0) {
			menuBackup.setIcon(new ImageIcon(Principal.class.getResource("/imagens/backupbotao3.png")));
		}
		public void mouseEntered(MouseEvent e) {
			
			menuBackup.setIcon(new ImageIcon(Principal.class.getResource("/imagens/backupbotao2.png")));
				
		}
		@Override
		public void mouseExited(MouseEvent e) {
			menuBackup.setIcon(new ImageIcon(Principal.class.getResource("/imagens/backupbotao1.png")));
		}
	});
	barraMenu.add(menuRelatorio);
	menuBackup.setIcon(new ImageIcon(Principal.class.getResource("/imagens/backupbotao1.png")));
	
	barraMenu.add(menuBackup);
	mntmCriarBackup.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			try{
				 CodeSource codeSource = Backup.class.getProtectionDomain().getCodeSource();
			        File jarFile = new File(codeSource.getLocation().toURI().getPath());
			        String jarDir = jarFile.getParentFile().getPath();
			        	String nome="";
			        JFileChooser file = new JFileChooser(); 
			          file.setFileSelectionMode(JFileChooser.FILES_ONLY);
			          int i= file.showSaveDialog(null);
			        if (i==1){
			           
			        } else {
			            File arquivo = file.getSelectedFile();
			          nome = arquivo.getPath();
			        }
			        /*NOTE: Creating Database Constraints*/
			        String dbName = "loja";
			        String dbUser = "root";
			        String dbPass = "root";

			        /*NOTE: Creating Path Constraints for folder saving*/
			        /*NOTE: Here the backup folder is created for saving inside it*/
			        String folderPath = jarDir + "\\backup2";

			        /*NOTE: Creating Folder if it does not exist*/
			        File f1 = new File(folderPath);
			        f1.mkdir();

			        /*NOTE: Creating Path Constraints for backup saving*/
			        /*NOTE: Here the backup is saved in a folder called backup with the name backup.sql*/
			        // String savePath = "\"" + jarDir + "\\backup2\\" + "backup11122.sql\"";
			        String savePath = nome+".sql";

			        /*NOTE: Used to create a cmd command*/
			         String executeCmd = "C:\\xampp\\mysql\\bin\\mysqldump -u" + dbUser + " -p" + dbPass + " --compact --skip-comments --skip-triggers --database " + dbName + " -r " + savePath;
			
			
			        /*NOTE: Executing the command here*/
			        Process runtimeProcess = Runtime.getRuntime().exec(executeCmd);
			        int processComplete = runtimeProcess.waitFor();

			        /*NOTE: processComplete=0 if correctly executed, will contain other values if not*/
			        if (processComplete == 0) {
			            
			            JOptionPane.showMessageDialog(null, "Backup concluido com sucesso!");
			        } else {
			        	JOptionPane.showMessageDialog(null, "Erro ao tentar fazer o backup!");
			        }

			    } catch (URISyntaxException | IOException | InterruptedException | HeadlessException ex) {
		            JOptionPane.showMessageDialog(null, "Error at Restoredbfromsql" + ex.getMessage());
		        }
		}
	});
	ActionListener menuRelatoriottc = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			if(menuRelatorio.isEnabled()==false){
			}else{	
			if(janelaRelatorio.isFocusable()==true){
				janelaRelatorio.carregarTabelanome();
				desktop_1.add(janelaRelatorio);
				janelaRelatorio.setVisible(true);
			//	menuCliente.setIcon(new ImageIcon(Principal.class.getResource("/imagens/iconemenu.png")));
				//menuFuncionario.setIcon(new ImageIcon(Principal.class.getResource("/imagens/funcimenu1.png")));
				menuRegistro.setIcon(new ImageIcon(Principal.class.getResource("/imagens/Registrolmenu.png")));
				menuAluguel.setIcon(new ImageIcon(Principal.class.getResource("/imagens/aluguelmenu1.png")));
				menuRoupa.setIcon(new ImageIcon(Principal.class.getResource("/imagens/roupamenu1.png")));
				menuLixeiro.setIcon(new ImageIcon(Principal.class.getResource("/imagens/lixeiramenu.png")));
				menuRelatorio.setIcon(new ImageIcon(Principal.class.getResource("/imagens/relatoriolmenu3.png")));
				janelaLixeira.dispose();
				janelaRoupa.dispose();
				janelaAluguel.dispose();
				janelaRegistro.dispose();
				janelaCliente.dispose();
				janelaFuncionario.limparFields();
				
			}
			try {
				janelaRelatorio.setMaximum(true);
			} catch (PropertyVetoException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			}
		}
	};
	menuRelatorio.addActionListener(menuRelatoriottc);
	menuRelatorio.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("F6"), "teste6");	
	menuRelatorio.getActionMap().put("teste", new AbstractAction("teste6") {
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			menuRelatoriottc.actionPerformed(arg0);
			
		}
	});
	
	menuBackup.add(mntmCriarBackup);
	mntmRestaurarDeBackup.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			 try {
				    String caminho="";
						 JFileChooser abrir = new JFileChooser();  
						 int retorno = abrir.showOpenDialog(null);  
						            if (retorno==JFileChooser.APPROVE_OPTION)  {
						                    caminho = abrir.getSelectedFile().getAbsolutePath();  
						                    
						            }
				            /*NOTE: String s is the mysql file name including the .sql in its name*/
				            /*NOTE: Getting path to the Jar file being executed*/
				            /*NOTE: YourImplementingClass-> replace with the class executing the code*/
				          
				           
				            
				            /*NOTE: Creating Database Constraints*/
				             String dbName = "mysql";
				             String dbUser = "root";
				             String dbPass = "root";

				            /*NOTE: Creating Path Constraints for restoring*/
				            String restorePath = "\""+caminho+"\"";
				         
				           
				           

				            /*NOTE: Used to create a cmd command*/
				            /*NOTE: Do not create a single large string, this will cause buffer locking, use string array*/
				            String[] executeCmd = new String[]{"C:\\xampp\\mysql\\bin\\mysql", dbName, "-u" + dbUser, "-p" + dbPass, "-e", " source " + restorePath};

				            /*NOTE: processComplete=0 if correctly executed, will contain other values if not*/
				            Process runtimeProcess = Runtime.getRuntime().exec(executeCmd);
				            int processComplete = runtimeProcess.waitFor();

				            /*NOTE: processComplete=0 if correctly executed, will contain other values if not*/
				            if (processComplete == 0) {
				                JOptionPane.showMessageDialog(null, "Restaurado com sucesso." );
				            } else {
				                JOptionPane.showMessageDialog(null, "Erro ao restaurar");
				            }


				        } catch (IOException | InterruptedException | HeadlessException ex) {
				            JOptionPane.showMessageDialog(null, "Error at Restoredbfromsql" + ex.getMessage());
				        }
		}
	});
	
	menuBackup.add(mntmRestaurarDeBackup);
	menuLixeiro.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			
			
			if(janelaLixeira.isFocusable()==true){
				desktop_1.add(janelaLixeira);
				janelaLixeira.setVisible(true);
				janelaLixeira.carregarTabela();
				janelaLixeira.carregarTabelaRoupa();
				janelaLixeira.carregarTabela3();
				menuCliente.setIcon(new ImageIcon(Principal.class.getResource("/imagens/iconemenu.png")));
				menuFuncionario.setIcon(new ImageIcon(Principal.class.getResource("/imagens/funcimenu.png")));
				menuRegistro.setIcon(new ImageIcon(Principal.class.getResource("/imagens/Registrolmenu.png")));
				menuAluguel.setIcon(new ImageIcon(Principal.class.getResource("/imagens/aluguelmenu1.png")));
				menuRoupa.setIcon(new ImageIcon(Principal.class.getResource("/imagens/roupamenu1.png")));
				menuLixeiro.setIcon(new ImageIcon(Principal.class.getResource("/imagens/lixeiramenu3.png")));
				janelaRoupa.dispose();
				janelaAluguel.dispose();
				janelaRegistro.dispose();
				janelaCliente.dispose();
				janelaFuncionario.dispose();
				janelaLixeira.carregarTabela();
				janelaLixeira.carregarTabela2();
				janelaLixeira.carregarTabela3();
				janelaLixeira.carregarTabelaRoupa();
				
			}
			try {
				janelaLixeira.setMaximum(true);
			} catch (PropertyVetoException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		public void mouseEntered(MouseEvent e) {
			if(janelaLixeira.isShowing()==false){
				menuLixeiro.setIcon(new ImageIcon(Principal.class.getResource("/imagens/lixeiramenu2.png")));
				}if(janelaRegistro.isShowing()==true){
					menuLixeiro.setIcon(new ImageIcon(Principal.class.getResource("/imagens/lixeiramenu3.png")));
				}
		}
		@Override
		public void mouseExited(MouseEvent e) {
			if(janelaLixeira.isShowing()==false){
				menuLixeiro.setIcon(new ImageIcon(Principal.class.getResource("/imagens/lixeiramenu.png")));
			}if(janelaLixeira.isShowing()==true){
				menuLixeiro.setIcon(new ImageIcon(Principal.class.getResource("/imagens/lixeiramenu3.png")));
			}
		}
	});
	menuLixeiro.setIcon(new ImageIcon(Principal.class.getResource("/imagens/lixeiramenu.png")));
	
	barraMenu.add(menuLixeiro);
	
	textField = new JTextField();
	textField.setHorizontalAlignment(SwingConstants.CENTER);
	textField.setFont(new Font("Dialog", Font.PLAIN, 15));
	textField.setForeground(Color.WHITE);
	textField.setBackground(Color.DARK_GRAY);
	textField.setEditable(false);
	barraMenu.add(textField);
	textField.setColumns(10);
	
	JMenu mnNewMenu = new JMenu("");
	mnNewMenu.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			mnNewMenu.setIcon(new ImageIcon(Principal.class.getResource("/imagens/sairpmenu3.png")));
				LoginFunc2 lg = new LoginFunc2();
				lg.setVisible(true);
				dispose();
				

		}
		public void mouseEntered(MouseEvent e) {	
			mnNewMenu.setIcon(new ImageIcon(Principal.class.getResource("/imagens/sairpmenu2.png")));
		
		}
		@Override
		public void mouseExited(MouseEvent e) {
		
			mnNewMenu.setIcon(new ImageIcon(Principal.class.getResource("/imagens/sairpmenu.png")));
		}
	});
	mnNewMenu.setIcon(new ImageIcon(Principal.class.getResource("/imagens/sairpmenu.png")));
	barraMenu.add(mnNewMenu);
	
	
	contentPane_1 = new JPanel();
	contentPane_1.setBackground(Color.DARK_GRAY);
	contentPane_1.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane_1);
	contentPane_1.setLayout(new BorderLayout(0, 0));
	desktop_1 = new JDesktopPane();
	contentPane_1.add(desktop_1);
	desktop_1.setBackground(Color.DARK_GRAY);
	label_1.setIcon(new ImageIcon(Principal.class.getResource("/imagens/Untitled-1.png")));
	label_1.setBounds(967, 11, 580, 636);
	
	desktop_1.add(label_1);

}	
	public void func(Funcionario f){
		textField.setText(f.getLogin());
		
	}
	}

