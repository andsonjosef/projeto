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

public class Principal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JDesktopPane desktop;
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
		setJMenuBar(barraMenu);
		
		JMenu menuCliente = new JMenu("Cliente");
		menuCliente.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JCadastroCliente janela = new JCadastroCliente();
				desktop.add(janela);
				janela.setVisible(true);
				try {
					janela.setMaximum(true);
				} catch (PropertyVetoException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		barraMenu.add(menuCliente);
		
		JMenu menuRoupa = new JMenu("Roupa");
		barraMenu.add(menuRoupa);
		
		JMenuItem menuCadastroRoupa = new JMenuItem("Roupa");
		menuCadastroRoupa.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, InputEvent.ALT_MASK));
		menuCadastroRoupa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JCadastroRoupa janela = new JCadastroRoupa();
				desktop.add(janela);
				janela.setVisible(true);
				try {
					janela.setMaximum(true);
				} catch (PropertyVetoException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		menuRoupa.add(menuCadastroRoupa);
		
		
		JMenu menuAluguel = new JMenu("Aluguel");
		barraMenu.add(menuAluguel);
		
		JMenuItem menuCadastroAluguel = new JMenuItem("Aluguel");
		menuCadastroAluguel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JAluguel janela = new JAluguel();
				desktop.add(janela);
				janela.setVisible(true);
				try {
					janela.setMaximum(true);
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
		
	
		
	JMenu menuRegistro = new JMenu("Registro");
	barraMenu.add(menuRegistro);
	
	JMenuItem menuCadastroRegistro = new JMenuItem("Registro");
	menuCadastroRegistro.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			JRegistro janela = new JRegistro();
			desktop.add(janela);
			janela.setVisible(true);
			try {
				janela.setMaximum(true);
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

