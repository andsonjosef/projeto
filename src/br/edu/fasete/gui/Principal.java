package br.edu.fasete.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.beans.PropertyVetoException;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JDesktopPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import java.awt.Color;

public class Principal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel contentPane_1;
	private JDesktopPane desktop;
	
	
	
	JCadastroCliente janelaCliente = new JCadastroCliente();
	JMenu menuCliente = new JMenu("");
	JCadastroRoupa janelaRoupa = new JCadastroRoupa();
	JMenu menuRoupa = new JMenu("");
	JAluguel janelaAluguel = new JAluguel();
	JMenu menuAluguel = new JMenu("");
	JRegistro janelaRegistro = new JRegistro();
	JMenu menuRegistro = new JMenu("");
	JFuncionario janelaFuncionario = new JFuncionario();
	JMenu menuFuncionario = new JMenu("");
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
		setForeground(Color.DARK_GRAY);
		setBackground(Color.DARK_GRAY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 700);
		setExtendedState(MAXIMIZED_BOTH);
		
		
		
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
				
				
				desktop.add(janelaCliente);
				janelaCliente.setVisible(true);
				if(janelaCliente.isShowing()==true){
					menuCliente.setIcon(new ImageIcon(Principal.class.getResource("/imagens/iconemenu3.png")));
					menuRegistro.setIcon(new ImageIcon(Principal.class.getResource("/imagens/Registrolmenu.png")));
					menuAluguel.setIcon(new ImageIcon(Principal.class.getResource("/imagens/aluguelmenu1.png")));
					menuRoupa.setIcon(new ImageIcon(Principal.class.getResource("/imagens/roupamenu1.png")));
					janelaRoupa.dispose();
					janelaAluguel.dispose();
					janelaRegistro.dispose();
					
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
		
		
		menuRoupa.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				desktop.add(janelaRoupa);
				janelaRoupa.setVisible(true);
				if(janelaRoupa.isFocusable()==true){
					menuRegistro.setIcon(new ImageIcon(Principal.class.getResource("/imagens/Registrolmenu.png")));
					menuCliente.setIcon(new ImageIcon(Principal.class.getResource("/imagens/iconemenu.png")));
					menuAluguel.setIcon(new ImageIcon(Principal.class.getResource("/imagens/aluguelmenu1.png")));
					menuRoupa.setIcon(new ImageIcon(Principal.class.getResource("/imagens/roupamenu3.png")));
					janelaCliente.dispose();
					janelaAluguel.dispose();
					janelaRegistro.dispose();
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
		
		////
		
		
		menuAluguel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(janelaAluguel.isFocusable()==true){
					menuCliente.setIcon(new ImageIcon(Principal.class.getResource("/imagens/iconemenu.png")));
					menuRegistro.setIcon(new ImageIcon(Principal.class.getResource("/imagens/Registrolmenu.png")));
					menuRoupa.setIcon(new ImageIcon(Principal.class.getResource("/imagens/roupamenu1.png")));
					menuAluguel.setIcon(new ImageIcon(Principal.class.getResource("/imagens/aluguelmenu3.png")));
					janelaCliente.dispose();
					janelaRoupa.dispose();
					janelaRegistro.dispose();
					
				}
				desktop.add(janelaAluguel);
				janelaAluguel.setVisible(true);
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
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		contentPane.setLayout(new BorderLayout(0, 0));
		desktop = new JDesktopPane();
		contentPane.add(desktop);
	menuRegistro.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			
			desktop.add(janelaRegistro);
			janelaRegistro.setVisible(true);
			if(janelaRegistro.isFocusable()==true){
				menuRegistro.setIcon(new ImageIcon(Principal.class.getResource("/imagens/Registrolmenu3.png")));
				menuFuncionario.setIcon(new ImageIcon(Principal.class.getResource("/imagens/iconemenu.png")));
				menuAluguel.setIcon(new ImageIcon(Principal.class.getResource("/imagens/aluguelmenu1.png")));
				menuRoupa.setIcon(new ImageIcon(Principal.class.getResource("/imagens/roupamenu1.png")));
				janelaAluguel.dispose();
				janelaRoupa.dispose();
				janelaFuncionario.dispose();
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
		
	
		
	
	menuRegistro.setIcon(new ImageIcon(Principal.class.getResource("/imagens/Registrolmenu.png")));
	menuRegistro.setForeground(Color.WHITE);
	barraMenu.add(menuRegistro);
	
	///
	
	menuFuncionario.setForeground(Color.WHITE);
	
	menuFuncionario.setIcon(new ImageIcon(Principal.class.getResource("/imagens/iconemenu.png")));
	
	
	
	menuFuncionario.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseEntered(MouseEvent e) {
			if(janelaFuncionario.isShowing()==false){
				menuFuncionario.setIcon(new ImageIcon(Principal.class.getResource("/imagens/iconemenu2.png")));
				}if(janelaFuncionario.isShowing()==true){
					menuFuncionario.setIcon(new ImageIcon(Principal.class.getResource("/imagens/iconemenu3.png")));	
				}
		}
		@Override
		public void mouseExited(MouseEvent e) {
			if(janelaFuncionario.isShowing()==false){
			menuFuncionario.setIcon(new ImageIcon(Principal.class.getResource("/imagens/iconemenu.png")));
			}if(janelaFuncionario.isShowing()==true){
				menuFuncionario.setIcon(new ImageIcon(Principal.class.getResource("/imagens/iconemenu3.png")));	
			}
		}
		@Override
		public void mouseClicked(MouseEvent e) {
			
			
			desktop.add(janelaFuncionario);
			janelaFuncionario.setVisible(true);
			if(janelaFuncionario.isShowing()==true){
				menuFuncionario.setIcon(new ImageIcon(Principal.class.getResource("/imagens/iconemenu3.png")));
				menuRegistro.setIcon(new ImageIcon(Principal.class.getResource("/imagens/Registrolmenu.png")));
				menuAluguel.setIcon(new ImageIcon(Principal.class.getResource("/imagens/aluguelmenu1.png")));
				menuRoupa.setIcon(new ImageIcon(Principal.class.getResource("/imagens/roupamenu1.png")));
				janelaRoupa.dispose();
				janelaAluguel.dispose();
				janelaRegistro.dispose();
				
			}
			try {
				janelaFuncionario.setMaximum(true);
			} catch (PropertyVetoException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	
	});
	barraMenu.add(menuFuncionario);
	
	
	contentPane_1 = new JPanel();
	contentPane_1.setBackground(Color.DARK_GRAY);
	contentPane_1.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane_1);
	contentPane_1.setLayout(new BorderLayout(0, 0));
	desktop = new JDesktopPane();
	contentPane_1.add(desktop);
	desktop.setBackground(Color.DARK_GRAY);

}	
	}

