package br.edu.fasete.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Principal2 extends JFrame {

	private JPanel contentPane;
	private JPanel contentPane_1;
	
	private JDesktopPane desktop;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal2 frame = new Principal2();
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
	public Principal2() {
		setForeground(SystemColor.desktop);
		setBackground(SystemColor.desktop);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 700);
		setExtendedState(MAXIMIZED_BOTH);
		
		
		JMenuBar barraMenu = new JMenuBar();
		barraMenu.setBackground(SystemColor.desktop);
		setJMenuBar(barraMenu);
		
		JMenu menuCliente = new JMenu("Cliente");
		menuCliente.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
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
		menuCliente.setForeground(SystemColor.textHighlightText);
		menuCliente.setBackground(SystemColor.windowBorder);
		
		menuCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
		menuRoupa.setForeground(SystemColor.textHighlightText);
		barraMenu.add(menuRoupa);
		
		JMenuItem menuCadastroRoupa = new JMenuItem("Roupa");
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
		menuAluguel.setForeground(SystemColor.textHighlightText);
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
	menuRegistro.setForeground(SystemColor.textHighlightText);
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
	
	
	contentPane_1 = new JPanel();
	contentPane_1.setBackground(Color.DARK_GRAY);
	contentPane_1.setForeground(SystemColor.desktop);
	contentPane_1.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane_1);
	contentPane_1.setLayout(new BorderLayout(0, 0));
	desktop = new JDesktopPane();
	contentPane_1.add(desktop);

	
			
	}

}
