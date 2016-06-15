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
public class EditAdm extends JFrame {

	private JPanel contentPane;
	private JTextField senhaatualField;
	Funcionario f = new Funcionario();
	private JPasswordField senhaField;
	private JTextField perguntaField;
	private JTextField respostaField;
	private JTextField senhaAtualField_2;
	private JTextField loginAtualField;
	private JTextField loginField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditAdm frame = new EditAdm();
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
	public EditAdm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 998, 561);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[450.00,grow][36.00][450.00,grow]", "[50][30][50][30][30][50][30][50][30][50][30][30]"));
		
		JLabel lblLogin = new JLabel("\u00B4Senha atual");
		lblLogin.setFont(new Font("Dialog", Font.PLAIN, 15));
		contentPane.add(lblLogin, "cell 0 0,aligny bottom");
		
		JLabel lblLoginAtual = new JLabel("Login atual");
		contentPane.add(lblLoginAtual, "cell 2 0");
		
		senhaatualField = new JTextField();
		contentPane.add(senhaatualField, "cell 0 1,grow");
		senhaatualField.setColumns(10);
		
		loginAtualField = new JTextField();
		contentPane.add(loginAtualField, "cell 2 1,grow");
		loginAtualField.setColumns(10);
		
		JLabel lblSenha = new JLabel("Nova senha");
		lblSenha.setFont(new Font("Dialog", Font.PLAIN, 15));
		contentPane.add(lblSenha, "cell 0 2,aligny bottom");
		
		JLabel lblbtnConfirmar = new JLabel("");
		lblbtnConfirmar.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
			String pergunta, resposta;
			f.setSenha(senhaAtualField_2.getText());
			pergunta = perguntaField.getText();
			resposta = respostaField.getText();
			Fachada.getInstancia().editarPergunta(f, pergunta, resposta);
			
			}
		});
		
		JLabel lblNovoLogin = new JLabel("novo login");
		contentPane.add(lblNovoLogin, "cell 2 2");
		
		senhaField = new JPasswordField();
		contentPane.add(senhaField, "cell 0 3,grow");
		
		loginField = new JTextField();
		contentPane.add(loginField, "cell 2 3,grow");
		loginField.setColumns(10);
		
		JButton btnEditar = new JButton("Editar");
		contentPane.add(btnEditar, "flowx,cell 0 4,alignx right");
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String login, senha;
				f.setLogin(loginAtualField.getText());
				f.setSenha(senhaatualField.getText());
				login = loginField.getText();
				senha = senhaField.getText();
				Fachada.getInstancia().editarLogin(f, login, senha);
			}
		});
		contentPane.add(btnSalvar, "cell 0 4,alignx right");
		
		JLabel lblPerguntaParaRecuperao = new JLabel("Pergunta para recupera\u00E7\u00E3o de senha");
		lblPerguntaParaRecuperao.setFont(new Font("Dialog", Font.PLAIN, 15));
		contentPane.add(lblPerguntaParaRecuperao, "cell 0 5,aligny bottom");
		
		perguntaField = new JTextField();
		contentPane.add(perguntaField, "cell 0 6 3 1,grow");
		perguntaField.setColumns(10);
		
		JLabel lblResposta = new JLabel("Resposta");
		lblResposta.setFont(new Font("Dialog", Font.PLAIN, 15));
		contentPane.add(lblResposta, "cell 0 7,aligny bottom");
		
		respostaField = new JTextField();
		contentPane.add(respostaField, "cell 0 8 3 1,grow");
		respostaField.setColumns(10);
		
		JLabel lblSenhaAtual = new JLabel("Senha atual");
		contentPane.add(lblSenhaAtual, "cell 0 9");
		
		senhaAtualField_2 = new JTextField();
		contentPane.add(senhaAtualField_2, "cell 0 10,grow");
		senhaAtualField_2.setColumns(10);
		
		JButton btnVoltar = new JButton("Voltar");
		contentPane.add(btnVoltar, "flowx,cell 0 11,alignx right");
		
		JLabel lblbtnEditar = new JLabel("");
		lblbtnEditar.setIcon(new ImageIcon(EditAdm.class.getResource("/imagens/editar1.png")));
		contentPane.add(lblbtnEditar, "cell 0 11,alignx right");
		lblbtnConfirmar.setIcon(new ImageIcon(EditAdm.class.getResource("/imagens/confirmarv1.png")));
		contentPane.add(lblbtnConfirmar, "cell 0 11,alignx right");
	}

}
