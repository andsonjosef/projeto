package br.edu.fasete.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JDesktopPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;
import javax.swing.ImageIcon;
import java.awt.Color;

public class Principal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JDesktopPane desktop;
	
	JCadastroCliente janelaCliente = new JCadastroCliente();
	JCadastroRoupa janelaRoupa = new JCadastroRoupa();
	JMenu menuCliente = new JMenu("Cliente");
	JMenuItem menuCadastroRoupa = new JMenuItem("Roupa");
	JMenu menuRoupa = new JMenu("Roupa");
	JAluguel janelaAluguel = new JAluguel();
	JMenu menuAluguel = new JMenu("Aluguel");
	JRegistro janelaRegistro = new JRegistro();
	JMenuItem menuCadastroRegistro = new JMenuItem("Registro");
	JMenu menuRegistro = new JMenu("Registro");
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 700);
		setExtendedState(MAXIMIZED_BOTH);
		
		
		JMenuBar barraMenu = new JMenuBar();
		barraMenu.setBackground(Color.DARK_GRAY);
		setJMenuBar(barraMenu);
		
		
		menuCliente.setForeground(Color.WHITE);
		menuCliente.setIcon(new ImageIcon(Principal.class.getResource("/imagens/iconcliente.png")));
		menuCliente.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				desktop.add(janelaCliente);
				janelaCliente.setVisible(true);
				if(janelaCliente.isShowing()==true){
					menuCliente.setIcon(new ImageIcon(Principal.class.getResource("/imagens/iconclienteSele.png")));
					menuRegistro.setIcon(new ImageIcon(Principal.class.getResource("/imagens/registroicone.png")));
					
					menuAluguel.setIcon(new ImageIcon(Principal.class.getResource("/imagens/alugueliicone.png")));
					menuRoupa.setIcon(new ImageIcon(Principal.class.getResource("/imagens/roupauicone.png")));
					menuCliente.setForeground(Color.YELLOW);
					menuRoupa.setForeground(Color.WHITE);
					menuAluguel.setForeground(Color.WHITE);
					menuRegistro.setForeground(Color.WHITE);
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
		
		
		menuRoupa.setIcon(new ImageIcon(Principal.class.getResource("/imagens/roupauicone.png")));
		menuRoupa.setForeground(Color.WHITE);
		barraMenu.add(menuRoupa);
		
		
		menuCadastroRoupa.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, InputEvent.ALT_MASK));
		menuCadastroRoupa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				desktop.add(janelaRoupa);
				janelaRoupa.setVisible(true);
				if(janelaRoupa.isFocusable()==true){
					menuRegistro.setIcon(new ImageIcon(Principal.class.getResource("/imagens/registroicone.png")));
					menuCliente.setIcon(new ImageIcon(Principal.class.getResource("/imagens/iconcliente.png")));
					menuAluguel.setIcon(new ImageIcon(Principal.class.getResource("/imagens/alugueliicone.png")));
					menuRoupa.setIcon(new ImageIcon(Principal.class.getResource("/imagens/roupauSeleicone.png")));
					menuRoupa.setForeground(Color.YELLOW);
					menuCliente.setForeground(Color.WHITE);
					menuAluguel.setForeground(Color.WHITE);
					menuRegistro.setForeground(Color.WHITE);
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
		});
		menuRoupa.add(menuCadastroRoupa);
		
		
		
		menuAluguel.setIcon(new ImageIcon(Principal.class.getResource("/imagens/alugueliicone.png")));
		menuAluguel.setForeground(Color.WHITE);
		barraMenu.add(menuAluguel);
		
		JMenuItem menuCadastroAluguel = new JMenuItem("Aluguel");
		menuCadastroAluguel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(janelaAluguel.isFocusable()==true){
					menuRegistro.setIcon(new ImageIcon(Principal.class.getResource("/imagens/registroicone.png")));
					menuCliente.setIcon(new ImageIcon(Principal.class.getResource("/imagens/iconcliente.png")));
					menuAluguel.setIcon(new ImageIcon(Principal.class.getResource("/imagens/aluguelSeleiicone.png")));
					menuRoupa.setIcon(new ImageIcon(Principal.class.getResource("/imagens/roupauicone.png")));
					menuRoupa.setForeground(Color.WHITE);
					menuCliente.setForeground(Color.WHITE);
					menuAluguel.setForeground(Color.YELLOW);
					menuRegistro.setForeground(Color.WHITE);
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
		});
		menuAluguel.add(menuCadastroAluguel);
		
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		contentPane.setLayout(new BorderLayout(0, 0));
		desktop = new JDesktopPane();
		contentPane.add(desktop);
		
	
		
	
	menuRegistro.setIcon(new ImageIcon(Principal.class.getResource("/imagens/registroicone.png")));
	menuRegistro.setForeground(Color.WHITE);
	barraMenu.add(menuRegistro);
	
	
	
	menuCadastroRegistro.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
			desktop.add(janelaRegistro);
			janelaRegistro.setVisible(true);
			if(janelaRegistro.isFocusable()==true){
				menuRegistro.setIcon(new ImageIcon(Principal.class.getResource("/imagens/registroSeleicone.png")));
				menuCliente.setIcon(new ImageIcon(Principal.class.getResource("/imagens/iconcliente.png")));
				menuAluguel.setIcon(new ImageIcon(Principal.class.getResource("/imagens/alugueliicone.png")));
				menuRoupa.setIcon(new ImageIcon(Principal.class.getResource("/imagens/roupauicone.png")));
				menuRoupa.setForeground(Color.WHITE);
				menuCliente.setForeground(Color.WHITE);
				menuAluguel.setForeground(Color.WHITE);
				menuRegistro.setForeground(Color.YELLOW);
				janelaCliente.dispose();
				janelaAluguel.dispose();
				janelaRoupa.dispose();
			}
			
			try {
				janelaRegistro.setMaximum(true);
			} catch (PropertyVetoException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
	});
	menuRegistro.add(menuCadastroRegistro);
	
	
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(new BorderLayout(0, 0));
	desktop = new JDesktopPane();
	contentPane.add(desktop);

}	
	}

