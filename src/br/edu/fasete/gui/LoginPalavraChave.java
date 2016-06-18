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

@SuppressWarnings("serial")
public class LoginPalavraChave extends JFrame {

	private JPanel contentPane;
	private JTextField loginField;
	Funcionario f = new Funcionario();
	private JPasswordField PalavraChaveField;
	private JLabel lblPergunta;
	private JTextField respostaField;
	private JLabel labelResposta;
	private JPasswordField perguntaField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginPalavraChave frame = new LoginPalavraChave();
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
	public LoginPalavraChave() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 751, 305);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[42px][533px][136px]", "[20px][20px][20px][20px][20px][20px][20px][20px][46.00px]"));
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setFont(new Font("Dialog", Font.PLAIN, 15));
		contentPane.add(lblLogin, "cell 0 0,alignx left,aligny top");
		
		loginField = new JTextField();
		contentPane.add(loginField, "cell 0 1 3 1,growx,aligny top");
		loginField.setColumns(10);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setFont(new Font("Dialog", Font.PLAIN, 15));
		contentPane.add(lblSenha, "cell 0 2,alignx left,aligny top");
		
		JLabel lblbtnConfirmar = new JLabel("");
		lblbtnConfirmar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				Funcionario fu = new Funcionario();

				
					f.setLogin(loginField.getText());
					f.setSenha(PalavraChaveField.getText());
					
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
		
		PalavraChaveField = new JPasswordField();
		contentPane.add(PalavraChaveField, "cell 0 3 3 1,growx,aligny top");
		
		lblPergunta = new JLabel("Pergunta");
		lblPergunta.setFont(new Font("Dialog", Font.PLAIN, 15));
		contentPane.add(lblPergunta, "cell 0 4,growx,aligny top");
		
		respostaField = new JTextField();
		respostaField.setColumns(10);
		contentPane.add(respostaField, "cell 0 7 3 1,growx,aligny top");
		
		labelResposta = new JLabel("Resposta");
		labelResposta.setFont(new Font("Dialog", Font.PLAIN, 15));
		contentPane.add(labelResposta, "cell 0 6,growx,aligny top");
		
		perguntaField = new JPasswordField();
		contentPane.add(perguntaField, "cell 0 5 3 1,growx,aligny top");
		lblbtnConfirmar.setIcon(new ImageIcon(LoginPalavraChave.class.getResource("/imagens/confirmarv1.png")));
		contentPane.add(lblbtnConfirmar, "cell 2 8,alignx left,aligny bottom");
	}

}
