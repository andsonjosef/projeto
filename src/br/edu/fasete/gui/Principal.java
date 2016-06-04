package br.edu.fasete.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import javax.swing.JDesktopPane;

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
		
		
		JMenuBar barraMenu = new JMenuBar();
		setJMenuBar(barraMenu);
		
		JMenu menuCliente = new JMenu("Cliente");
		barraMenu.add(menuCliente);
		
		JMenuItem menuCadastroCliente = new JMenuItem("Cliente");
		menuCadastroCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JCadastroCliente2 janela = new JCadastroCliente2();
				desktop.add(janela);
				janela.setVisible(true);
			}
		});
		menuCliente.add(menuCadastroCliente);
		
		JMenu menuRoupa = new JMenu("Roupa");
		barraMenu.add(menuRoupa);
		
		JMenuItem menuCadastroRoupa = new JMenuItem("Roupa");
		menuCadastroRoupa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JCadastroRoupa janela = new JCadastroRoupa();
				desktop.add(janela);
				janela.setVisible(true);
			}
		});
		menuRoupa.add(menuCadastroRoupa);
		
		
		JMenu menuAluguel = new JMenu("Aluguel");
		barraMenu.add(menuAluguel);
		
		JMenuItem menuCadastroAluguel = new JMenuItem("Aluguel");
		menuCadastroAluguel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JAluguel2 janela = new JAluguel2();
				desktop.add(janela);
				janela.setVisible(true);
			}
		});
		menuAluguel.add(menuCadastroAluguel);
		
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		desktop = new JDesktopPane();
		contentPane.add(desktop);
		
	
		
	JMenu menuRegistro = new JMenu("Registro");
	barraMenu.add(menuRegistro);
	
	JMenuItem menuCadastroRegistro = new JMenuItem("Registro");
	menuCadastroRegistro.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			JRegistro2 janela = new JRegistro2();
			desktop.add(janela);
			janela.setVisible(true);
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

