package br.edu.fasete.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.edu.fasete.fachada.Fachada;
import br.edu.fasete.principais.Funcionario;

import net.miginfocom.swing.MigLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class LoginAdm extends JFrame {

	private JPanel contentPane;
	private JTextField loginField;
	Funcionario f = new Funcionario();
	private JPasswordField senhaField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginAdm frame = new LoginAdm();
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
	public LoginAdm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 751, 243);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[457.00,grow]", "[50][30][20.00][30][28.00][30]"));
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setFont(new Font("Dialog", Font.PLAIN, 15));
		contentPane.add(lblLogin, "cell 0 0,aligny bottom");
		
		loginField = new JTextField();
		contentPane.add(loginField, "cell 0 1,grow");
		loginField.setColumns(10);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setFont(new Font("Dialog", Font.PLAIN, 15));
		contentPane.add(lblSenha, "cell 0 2,aligny bottom");
		
		JLabel lblbtnConfirmar = new JLabel("");
		lblbtnConfirmar.addMouseListener(new MouseAdapter() {
			@SuppressWarnings("deprecation")
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				Funcionario fu = new Funcionario();

				
					f.setLogin(loginField.getText());
					f.setSenha(senhaField.getText());
					
					fu =Fachada.getInstancia().buscarLogin(f);
					
					if(fu.getLogin() == null){
						JOptionPane.showMessageDialog(null, "Erro. O Login e/ou a senha estão errados.");
					}else{
						
						Principal janela = new Principal();
						janela.setVisible(true);
						dispose();
					}
			}
		});
		
		senhaField = new JPasswordField();
		contentPane.add(senhaField, "cell 0 3,grow");
		
		JButton btnEsqueciASenha = new JButton("Esqueci a senha");
		btnEsqueciASenha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				LoginPalavraChave lpc = new LoginPalavraChave();
				lpc.setVisible(true);
				dispose();
			}
		});
		contentPane.add(btnEsqueciASenha, "flowx,cell 0 5");
		
		JLabel lblbtnEditar = new JLabel("");
		lblbtnEditar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				EditAdm ea = new EditAdm();
				ea.setVisible(true);
				dispose();
			}
		});
		lblbtnEditar.setIcon(new ImageIcon(LoginAdm.class.getResource("/imagens/editar1.png")));
		contentPane.add(lblbtnEditar, "cell 0 5,alignx right");
		lblbtnConfirmar.setIcon(new ImageIcon(LoginAdm.class.getResource("/imagens/confirmarv1.png")));
		contentPane.add(lblbtnConfirmar, "cell 0 5,alignx right");
	}

}
