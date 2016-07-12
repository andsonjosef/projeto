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
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

@SuppressWarnings("serial")
public class LoginAdm2 extends JFrame {

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
	public LoginAdm2() {
		setTitle("Entrar como administrador");
		setIconImage(Toolkit.getDefaultToolkit().getImage(LoginAdm.class.getResource("/imagens/iconcloset.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 751, 243);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[457.00,grow]", "[50][30][20.00][30][28.00][30]"));
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setForeground(Color.WHITE);
		lblLogin.setFont(new Font("Dialog", Font.PLAIN, 15));
		contentPane.add(lblLogin, "cell 0 0,aligny bottom");
		
		loginField = new JTextField();
		loginField.setForeground(Color.WHITE);
		loginField.setFont(new Font("Dialog", Font.PLAIN, 15));
		contentPane.add(loginField, "cell 0 1,grow");
		loginField.setColumns(10);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setForeground(Color.WHITE);
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
					
					fu =Fachada.getInstancia().buscarLoginRoot(f);
					
					if(fu.getLogin() == null|| fu.getSenha() == null){
						JOptionPane.showMessageDialog(null, "Erro. O Login e/ou a senha estão errados.");
					}else{
						
						Principal janela = new Principal();
						janela.textField.setText(f.getLogin());
						janela.menuFuncionario.setEnabled(true);
						janela.setVisible(true);
						dispose();
					}
					
			}
			public void mouseEntered(MouseEvent arg0) {
				lblbtnConfirmar.setIcon(new ImageIcon(LoginAdm.class.getResource("/imagens/etrar2.png")));
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblbtnConfirmar.setIcon(new ImageIcon(LoginAdm.class.getResource("/imagens/etrar1.png")));
			}
			public void mouseReleased(MouseEvent e) {
				lblbtnConfirmar.setIcon(new ImageIcon(LoginAdm.class.getResource("/imagens/etrar1.png")));
			}
		});
		
		senhaField = new JPasswordField();
		senhaField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER){
					Funcionario fu = new Funcionario();

					
					f.setLogin(loginField.getText());
					String senha = new String(senhaField.getPassword());
					f.setSenha(senha);
					
					fu =Fachada.getInstancia().buscarLoginRoot(f);
					
					if(fu.getLogin() == null|| fu.getSenha() == null){
						JOptionPane.showMessageDialog(null, "Erro. O Login e/ou a senha estão errados.");
					}else{
						
						Principal janela = new Principal();
						janela.textField.setText(f.getLogin());
						janela.menuFuncionario.setEnabled(true);
						janela.setVisible(true);
						dispose();
					}
				}
			}
		});
		senhaField.setForeground(Color.WHITE);
		senhaField.setFont(new Font("Dialog", Font.PLAIN, 15));
		contentPane.add(senhaField, "cell 0 3,grow");
		
		JLabel lblbtnEditar = new JLabel("");
		lblbtnEditar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				LoginEditar ea = new LoginEditar();
				ea.setVisible(true);
				dispose();
			}
			public void mouseEntered(MouseEvent arg0) {
				lblbtnEditar.setIcon(new ImageIcon(LoginAdm.class.getResource("/imagens/editar2.png")));
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblbtnEditar.setIcon(new ImageIcon(LoginAdm.class.getResource("/imagens/editar1.png")));
			}
			public void mouseReleased(MouseEvent e) {
				lblbtnEditar.setIcon(new ImageIcon(LoginAdm.class.getResource("/imagens/editar1.png")));
			}
		});
		
		JLabel label = new JLabel("");
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Fachada.getInstancia().buscarPerunta2(f);
				
				LoginPalavraChave lpc = new LoginPalavraChave();
				lpc.perguntaField.setText(f.getPergunta());
				lpc.setVisible(true);
				dispose();
			}
			public void mouseEntered(MouseEvent arg0) {
				label.setIcon(new ImageIcon(LoginAdm.class.getResource("/imagens/senha2.png")));
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				label.setIcon(new ImageIcon(LoginAdm.class.getResource("/imagens/senha1.png")));
			}
			public void mouseReleased(MouseEvent e) {
				label.setIcon(new ImageIcon(LoginAdm.class.getResource("/imagens/senha1.png")));
			}
		});
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				LoginFunc lf = new LoginFunc();
				lf.setVisible(true);
				lf.getContentPane().setBackground(Color.darkGray);
				dispose();
			}
			public void mouseEntered(MouseEvent arg0) {
				lblNewLabel.setIcon(new ImageIcon(LoginAdm.class.getResource("/imagens/VOLTAR2.png")));
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblNewLabel.setIcon(new ImageIcon(LoginAdm.class.getResource("/imagens/VOLTAR1.png")));
			}
			public void mouseReleased(MouseEvent e) {
				lblNewLabel.setIcon(new ImageIcon(LoginAdm.class.getResource("/imagens/VOLTAR1.png")));
			}
			
		});
		lblNewLabel.setIcon(new ImageIcon(LoginAdm.class.getResource("/imagens/VOLTAR1.png")));
		contentPane.add(lblNewLabel, "flowx,cell 0 5,alignx right");
		label.setIcon(new ImageIcon(LoginAdm.class.getResource("/imagens/senha1.png")));
		contentPane.add(label, "cell 0 5,alignx right");
		lblbtnEditar.setIcon(new ImageIcon(LoginAdm.class.getResource("/imagens/editar1.png")));
		contentPane.add(lblbtnEditar, "cell 0 5,alignx right");
		lblbtnConfirmar.setIcon(new ImageIcon(LoginAdm.class.getResource("/imagens/etrar1.png")));
		contentPane.add(lblbtnConfirmar, "cell 0 5,alignx right");
	}

}
