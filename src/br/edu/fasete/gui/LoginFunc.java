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
import java.awt.HeadlessException;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.security.CodeSource;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class LoginFunc extends JFrame {

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
					LoginFunc frame = new LoginFunc();
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
	public LoginFunc() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 751, 271);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[457.00,grow]", "[50][30][50][30][50][30]"));
		
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
						janela.textField.setText(f.getLogin());
						janela.setVisible(true);
						dispose();
					}
			}
		});
		
		senhaField = new JPasswordField();
		contentPane.add(senhaField, "cell 0 3,grow");
		
		JButton btnAdm = new JButton("Adm");
		btnAdm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginAdm la = new LoginAdm();
				la.setVisible(true);
				dispose();
				
						
			}
		});
		
		JLabel label = new JLabel("");
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
			}
		});
		label.setIcon(new ImageIcon(LoginFunc.class.getResource("/imagens/restaurar1.png")));
		contentPane.add(label, "flowx,cell 0 5,alignx right");
		contentPane.add(btnAdm, "cell 0 5,alignx right");
		lblbtnConfirmar.setIcon(new ImageIcon(LoginFunc.class.getResource("/imagens/confirmarv1.png")));
		contentPane.add(lblbtnConfirmar, "cell 0 5,alignx right");
	}

}
