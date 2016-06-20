package br.edu.fasete.gui;

import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import br.edu.fasete.dao.LoginDaoJdbc;
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
import java.awt.Toolkit;

@SuppressWarnings("serial")
public class LoginEditar extends JFrame {

	private JPanel contentPane;
	private JTextField loginAtualField;
	Funcionario f = new Funcionario();
	private JPasswordField senhaAtualField;
	private JPasswordField senhaNovaField;
	private JTextField loginNovotextField;
	private JTextField PerguntaTextField;
	private JTextField respostaTextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginEditar frame = new LoginEditar();
					frame.getContentPane().setBackground(Color.darkGray);
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
	public LoginEditar() {
		setTitle("Editar administrador");
		setIconImage(Toolkit.getDefaultToolkit().getImage(LoginEditar.class.getResource("/imagens/iconcloset.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 751, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[75px][4px][136px][4px][494px]", "[39.00px][22px][44.00px][21px][47.00px][22px][51.00px][21px][49.00px][20px][50.00px][20px][68.00px]"));
		
		JLabel lblLoginAtual = new JLabel("Login Atual");
		lblLoginAtual.setForeground(Color.WHITE);
		lblLoginAtual.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(lblLoginAtual, "cell 0 0,alignx center,aligny bottom");
		
		loginAtualField = new JTextField();
		loginAtualField.setEditable(false);
		loginAtualField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(loginAtualField, "cell 0 1 5 1,grow");
		loginAtualField.setColumns(10);
		
		JLabel lblSenhaAtual = new JLabel("Senha Atual");
		lblSenhaAtual.setForeground(Color.WHITE);
		lblSenhaAtual.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(lblSenhaAtual, "cell 0 2 3 1,alignx left,aligny bottom");
		
		senhaAtualField = new JPasswordField();
		senhaAtualField.setEditable(false);
		senhaAtualField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(senhaAtualField, "cell 0 3 5 1,grow");
		
		JLabel senhaNovalbl = new JLabel("Senha Nova");
		senhaNovalbl.setForeground(Color.WHITE);
		senhaNovalbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(senhaNovalbl, "cell 0 6 3 1,alignx left,aligny bottom");
		
		senhaNovaField = new JPasswordField();
		senhaNovaField.setEditable(false);
		senhaNovaField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(senhaNovaField, "cell 0 7 5 1,grow");
		
		loginNovotextField = new JTextField();
		loginNovotextField.setEditable(false);
		loginNovotextField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		loginNovotextField.setColumns(10);
		contentPane.add(loginNovotextField, "cell 0 5 5 1,grow");
		
		JLabel lblPergunta = new JLabel("Pergunta");
		lblPergunta.setForeground(Color.WHITE);
		lblPergunta.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(lblPergunta, "cell 0 8,alignx left,aligny bottom");
		
		PerguntaTextField = new JTextField();
		PerguntaTextField.setEditable(false);
		PerguntaTextField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(PerguntaTextField, "cell 0 9 5 1,grow");
		PerguntaTextField.setColumns(10);
		
		JLabel lblResposta = new JLabel("Resposta");
		lblResposta.setForeground(Color.WHITE);
		lblResposta.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(lblResposta, "cell 0 10,alignx left,aligny bottom");
		
		respostaTextField = new JTextField();
		respostaTextField.setEditable(false);
		respostaTextField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(respostaTextField, "cell 0 11 5 1,grow");
		respostaTextField.setColumns(10);
		
		JLabel loginNovoLbl = new JLabel("Login Novo");
		loginNovoLbl.setForeground(Color.WHITE);
		loginNovoLbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(loginNovoLbl, "cell 0 4,alignx center,aligny bottom");
		
		JLabel lblbtnConfirmar = new JLabel("");
		lblbtnConfirmar.addMouseListener(new MouseAdapter() {
			@SuppressWarnings("deprecation")
			@Override
			public void mouseClicked(MouseEvent arg0) {

				
				
				
				Funcionario f2 = new Funcionario();
				f.setLogin(loginAtualField.getText());
				f.setSenha(senhaAtualField.getText());
				
				f2 = Fachada.getInstancia().buscarLoginRoot(f);
				
				//falta conferir a resposta
				if(f2.getLogin() != null || f2.getSenha() != null){
					String pergunta = PerguntaTextField.getText();
					String resposta = respostaTextField.getText();
					Fachada.getInstancia().editarPergunta(f2, pergunta, resposta);
					String login = loginNovotextField.getText();
					String senha = senhaNovaField.getText();
				Fachada.getInstancia().editarLogin(f2, login, senha);
					
				}else{
					JOptionPane.showMessageDialog(null,"Login ou senha incorreta.");
				}
			}
			public void mouseEntered(MouseEvent arg0) {
				lblbtnConfirmar.setIcon(new ImageIcon(LoginEditar.class.getResource("/imagens/salvar2.png")));
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblbtnConfirmar.setIcon(new ImageIcon(LoginEditar.class.getResource("/imagens/salvar1.png")));
			}
			public void mouseReleased(MouseEvent e) {
				lblbtnConfirmar.setIcon(new ImageIcon(LoginEditar.class.getResource("/imagens/salvar1.png")));
			}
		});
		
		JLabel lblbtnEditar = new JLabel("");
		lblbtnEditar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				loginAtualField.setEditable(true);
				senhaAtualField.setEditable(true);
				loginNovotextField.setEditable(true);
				senhaNovaField.setEditable(true);
				PerguntaTextField.setEditable(true);
				respostaTextField.setEditable(true);
			}
			public void mouseEntered(MouseEvent arg0) {
				lblbtnEditar.setIcon(new ImageIcon(LoginEditar.class.getResource("/imagens/editar2.png")));
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblbtnEditar.setIcon(new ImageIcon(LoginEditar.class.getResource("/imagens/editar1.png")));
			}
			public void mouseReleased(MouseEvent e) {
				lblbtnEditar.setIcon(new ImageIcon(LoginEditar.class.getResource("/imagens/editar1.png")));
			}
		});
		
		JLabel lblCancelar = new JLabel("");
		lblCancelar.setIcon(new ImageIcon(LoginEditar.class.getResource("/imagens/cancelar1.png")));
		lblCancelar.setForeground(Color.WHITE);
		lblCancelar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				LoginAdm janela = new LoginAdm();
				janela.getContentPane().setBackground(Color.darkGray);
				janela.setVisible(true);
				dispose();
			}
			public void mouseEntered(MouseEvent arg0) {
				lblCancelar.setIcon(new ImageIcon(LoginEditar.class.getResource("/imagens/cancelar2.png")));
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblCancelar.setIcon(new ImageIcon(LoginEditar.class.getResource("/imagens/cancelar1.png")));
			}
			public void mouseReleased(MouseEvent e) {
				lblCancelar.setIcon(new ImageIcon(LoginEditar.class.getResource("/imagens/cancelar1.png")));
			}
		});
		contentPane.add(lblCancelar, "flowx,cell 4 12,alignx right,aligny bottom");
		lblbtnEditar.setIcon(new ImageIcon(LoginEditar.class.getResource("/imagens/editar1.png")));
		contentPane.add(lblbtnEditar, "cell 4 12,alignx right,aligny bottom");
		lblbtnConfirmar.setIcon(new ImageIcon(LoginEditar.class.getResource("/imagens/salvar1.png")));
		contentPane.add(lblbtnConfirmar, "cell 4 12,alignx right,aligny bottom");
	}
}
