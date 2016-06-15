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

@SuppressWarnings("serial")
public class EditAdm extends JFrame {

	private JPanel contentPane;
	private JTextField loginField;
	Funcionario f = new Funcionario();
	private JPasswordField senhaField;
	private JTextField textField;
	private JTextField textField_1;

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
		setBounds(100, 100, 879, 496);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[457.00,grow]", "[50][30][50][30][][30][50][30][50][30][30]"));
		
		JLabel lblLogin = new JLabel("\u00B4Senha atual");
		lblLogin.setFont(new Font("Dialog", Font.PLAIN, 15));
		contentPane.add(lblLogin, "cell 0 0,aligny bottom");
		
		loginField = new JTextField();
		contentPane.add(loginField, "cell 0 1,grow");
		loginField.setColumns(10);
		
		JLabel lblSenha = new JLabel("Nova senha");
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
		
		JButton btnEditar = new JButton("Editar");
		contentPane.add(btnEditar, "flowx,cell 0 5,alignx right");
		
		JButton btnSalvar = new JButton("Salvar");
		contentPane.add(btnSalvar, "cell 0 5,alignx right");
		
		JLabel lblPerguntaParaRecuperao = new JLabel("Pergunta para recupera\u00E7\u00E3o de senha");
		lblPerguntaParaRecuperao.setFont(new Font("Dialog", Font.PLAIN, 15));
		contentPane.add(lblPerguntaParaRecuperao, "cell 0 6,aligny bottom");
		
		textField = new JTextField();
		contentPane.add(textField, "cell 0 7,grow");
		textField.setColumns(10);
		
		JLabel lblResposta = new JLabel("Resposta");
		lblResposta.setFont(new Font("Dialog", Font.PLAIN, 15));
		contentPane.add(lblResposta, "cell 0 8,aligny bottom");
		
		textField_1 = new JTextField();
		contentPane.add(textField_1, "cell 0 9,grow");
		textField_1.setColumns(10);
		
		JLabel lblbtnEditar = new JLabel("");
		lblbtnEditar.setIcon(new ImageIcon(EditAdm.class.getResource("/imagens/editar1.png")));
		contentPane.add(lblbtnEditar, "flowx,cell 0 10,alignx right");
		lblbtnConfirmar.setIcon(new ImageIcon(EditAdm.class.getResource("/imagens/confirmarv1.png")));
		contentPane.add(lblbtnConfirmar, "cell 0 10,alignx right");
	}

}
