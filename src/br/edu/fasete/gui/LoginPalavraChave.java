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
import java.awt.Color;
import java.awt.Toolkit;

@SuppressWarnings("serial")
public class LoginPalavraChave extends JFrame {

	private JPanel contentPane;
	private JTextField loginField;
	Funcionario f = new Funcionario();
	private JTextField PalavraChaveField;
	private JLabel lblPergunta;
	private JTextField respostaField;
	private JLabel labelResposta;
	public JTextField perguntaField;
	private JLabel label;

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
		setTitle("Recuperar senha");
		setIconImage(Toolkit.getDefaultToolkit().getImage(LoginPalavraChave.class.getResource("/imagens/iconcloset.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 751, 305);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[42px][533px][136px]", "[20px][20px][][20px][20px][20px][20px][20px][46.00px]"));
		
		lblPergunta = new JLabel("Pergunta");
		lblPergunta.setForeground(Color.WHITE);
		lblPergunta.setFont(new Font("Dialog", Font.PLAIN, 15));
		contentPane.add(lblPergunta, "cell 0 0,growx,aligny top");
		
		perguntaField = new JTextField();
		perguntaField.setEditable(false);
		perguntaField.setForeground(Color.WHITE);
		perguntaField.setFont(new Font("Dialog", Font.PLAIN, 15));
		contentPane.add(perguntaField, "cell 0 1 3 1,growx,aligny top");
		
		JLabel lblbtnConfirmar = new JLabel("");
		lblbtnConfirmar.addMouseListener(new MouseAdapter() {
		
			@Override
			public void mouseClicked(MouseEvent arg0) {
				lblbtnConfirmar.setIcon(new ImageIcon(LoginPalavraChave.class.getResource("/imagens/salvar3.png")));
				Funcionario fu = new Funcionario();

				
					f.setPergunta(perguntaField.getText());
					f.setRespsota(respostaField.getText());
					
					fu =Fachada.getInstancia().buscarPergunta(f);
					
					
					if(fu.getPergunta() == null||fu.getRespsota() == null){
						JOptionPane.showMessageDialog(null, "Erro. O Login e/ou a senha estão errados.");
					}else{
						Fachada.getInstancia().buscarnRoot(f);
						
						loginField.setText(f.getLogin());
						PalavraChaveField.setText(f.getSenha());
						
					}
			}
			public void mouseEntered(MouseEvent arg0) {
				lblbtnConfirmar.setIcon(new ImageIcon(LoginPalavraChave.class.getResource("/imagens/salvar2.png")));
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblbtnConfirmar.setIcon(new ImageIcon(LoginPalavraChave.class.getResource("/imagens/salvar1.png")));
			}
			public void mouseReleased(MouseEvent e) {
				lblbtnConfirmar.setIcon(new ImageIcon(LoginPalavraChave.class.getResource("/imagens/salvar1.png")));
			}
		});
		
		labelResposta = new JLabel("Resposta");
		labelResposta.setForeground(Color.WHITE);
		labelResposta.setFont(new Font("Dialog", Font.PLAIN, 15));
		contentPane.add(labelResposta, "cell 0 2,growx,aligny top");
		
		respostaField = new JTextField();
		respostaField.setForeground(Color.WHITE);
		respostaField.setFont(new Font("Dialog", Font.PLAIN, 15));
		respostaField.setColumns(10);
		contentPane.add(respostaField, "cell 0 3 3 1,growx,aligny top");
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setForeground(Color.WHITE);
		lblLogin.setFont(new Font("Dialog", Font.PLAIN, 15));
		contentPane.add(lblLogin, "cell 0 4,alignx left,aligny top");
		
		loginField = new JTextField();
		loginField.setForeground(Color.WHITE);
		loginField.setEditable(false);
		loginField.setFont(new Font("Dialog", Font.PLAIN, 15));
		contentPane.add(loginField, "cell 0 5 3 1,growx,aligny top");
		loginField.setColumns(10);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setForeground(Color.WHITE);
		lblSenha.setFont(new Font("Dialog", Font.PLAIN, 15));
		contentPane.add(lblSenha, "cell 0 6,alignx left,aligny top");
		
		PalavraChaveField = new JTextField();
		PalavraChaveField.setForeground(Color.WHITE);
		PalavraChaveField.setEditable(false);
		PalavraChaveField.setFont(new Font("Dialog", Font.PLAIN, 15));
		contentPane.add(PalavraChaveField, "cell 0 7 3 1,growx,aligny top");
		
		label = new JLabel("");
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				LoginAdm la = new LoginAdm();
				la.setVisible(true);
				dispose();
			}
			public void mouseEntered(MouseEvent arg0) {
				label.setIcon(new ImageIcon(LoginPalavraChave.class.getResource("/imagens/cancelar2.png")));
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				label.setIcon(new ImageIcon(LoginPalavraChave.class.getResource("/imagens/cancelar1.png")));
			}
			public void mouseReleased(MouseEvent e) {
				label.setIcon(new ImageIcon(LoginPalavraChave.class.getResource("/imagens/cancelar1.png")));
			}
		});
		label.setIcon(new ImageIcon(LoginPalavraChave.class.getResource("/imagens/cancelar1.png")));
		contentPane.add(label, "cell 1 8,alignx right,aligny bottom");
		lblbtnConfirmar.setIcon(new ImageIcon(LoginPalavraChave.class.getResource("/imagens/salvar1.png")));
		contentPane.add(lblbtnConfirmar, "cell 2 8,alignx left,aligny bottom");
	}

}
