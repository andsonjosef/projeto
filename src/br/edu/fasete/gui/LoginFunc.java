package br.edu.fasete.gui;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import br.edu.fasete.fachada.Fachada;
import br.edu.fasete.principais.Funcionario;
import net.miginfocom.swing.MigLayout;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.HeadlessException;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import javax.swing.JPasswordField;
import javax.swing.JFileChooser;
import java.awt.Color;
import java.awt.Toolkit;

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
					UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel");
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
		setIconImage(Toolkit.getDefaultToolkit().getImage(LoginFunc.class.getResource("/imagens/iconcloset.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 751, 271);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[][457.00,grow]", "[50][30][50][30][50][30]"));
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setForeground(Color.WHITE);
		lblLogin.setFont(new Font("Dialog", Font.PLAIN, 15));
		contentPane.add(lblLogin, "cell 0 0,aligny bottom");
		
		loginField = new JTextField();
		loginField.setForeground(Color.WHITE);
		loginField.setFont(new Font("Dialog", Font.PLAIN, 15));
		contentPane.add(loginField, "cell 0 1 2 1,grow");
		loginField.setColumns(10);
		
		JLabel lblbtnConfirmar = new JLabel("");
		lblbtnConfirmar.addMouseListener(new MouseAdapter() {
			@SuppressWarnings("deprecation")
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				Funcionario fu = new Funcionario();

				
					f.setLogin(loginField.getText());
					f.setSenha(senhaField.getText());
					
					fu =Fachada.getInstancia().buscarLogin(f);
					
					if(fu.getLogin() == null|| fu.getSenha() == null){
						JOptionPane.showMessageDialog(null, "Erro. O Login e/ou a senha estão errados.");
						
					}else{
						
						Principal janela = new Principal();
						janela.textField.setText(f.getLogin());
						janela.setVisible(true);
						janela.menuFuncionario.setEnabled(false);
						dispose();
					}
			}
			public void mouseEntered(MouseEvent arg0) {
				lblbtnConfirmar.setIcon(new ImageIcon(LoginFunc.class.getResource("/imagens/etrar2.png")));
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblbtnConfirmar.setIcon(new ImageIcon(LoginFunc.class.getResource("/imagens/etrar1.png")));
			}
			public void mouseReleased(MouseEvent e) {
				lblbtnConfirmar.setIcon(new ImageIcon(LoginFunc.class.getResource("/imagens/etrar1.png")));
			}
		});
		
		JLabel label = new JLabel("");
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
				    String caminho="";
						 JFileChooser abrir = new JFileChooser();  
						 int retorno = abrir.showOpenDialog(null);  
						            if (retorno==JFileChooser.APPROVE_OPTION)  {
						                    caminho = abrir.getSelectedFile().getAbsolutePath();  
						                    
						            }
				            /*NOTE: String s is the mysql file name including the .sql in its name*/
				            /*NOTE: Getting path to the Jar file being executed*/
				            /*NOTE: YourImplementingClass-> replace with the class executing the code*/
				          
				           
				            
				            /*NOTE: Creating Database Constraints*/
				             String dbName = "mysql";
				             String dbUser = "root";
				             String dbPass = "root";

				            /*NOTE: Creating Path Constraints for restoring*/
				            String restorePath = "\""+caminho+"\"";
				            
				           
				           

				            /*NOTE: Used to create a cmd command*/
				            /*NOTE: Do not create a single large string, this will cause buffer locking, use string array*/
				            String[] executeCmd = new String[]{"C:\\xampp\\mysql\\bin\\mysql", dbName, "-u" + dbUser, "-p" + dbPass, "-e", " source " + restorePath};

				            /*NOTE: processComplete=0 if correctly executed, will contain other values if not*/
				            Process runtimeProcess = Runtime.getRuntime().exec(executeCmd);
				            int processComplete = runtimeProcess.waitFor();

				            /*NOTE: processComplete=0 if correctly executed, will contain other values if not*/
				            if (processComplete == 0) {
				                JOptionPane.showMessageDialog(null, "Restaurado com sucesso." );
				            } else {
				                JOptionPane.showMessageDialog(null, "Erro ao restaurar");
				            }


				        } catch (IOException | InterruptedException | HeadlessException ex) {
				            JOptionPane.showMessageDialog(null, "Error at Restoredbfromsql" + ex.getMessage());
				        }
				
			}
			public void mouseEntered(MouseEvent arg0) {
				label.setIcon(new ImageIcon(LoginFunc.class.getResource("/imagens/restaurar2.png")));
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				label.setIcon(new ImageIcon(LoginFunc.class.getResource("/imagens/restaurar1.png")));
			}
			public void mouseReleased(MouseEvent e) {
				label.setIcon(new ImageIcon(LoginFunc.class.getResource("/imagens/restaurar1.png")));
			}
		});
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setForeground(Color.WHITE);
		lblSenha.setFont(new Font("Dialog", Font.PLAIN, 15));
		contentPane.add(lblSenha, "cell 0 2,aligny bottom");
		
		senhaField = new JPasswordField();
		senhaField.setForeground(Color.WHITE);
		senhaField.setFont(new Font("Dialog", Font.PLAIN, 15));
		contentPane.add(senhaField, "cell 0 3 2 1,grow");
		label.setIcon(new ImageIcon(LoginFunc.class.getResource("/imagens/restaurar1.png")));
		contentPane.add(label, "flowx,cell 0 5,alignx left");
		lblbtnConfirmar.setIcon(new ImageIcon(LoginFunc.class.getResource("/imagens/etrar1.png")));
		contentPane.add(lblbtnConfirmar, "cell 1 5,alignx right");
		
		JLabel label_1 = new JLabel("");
		label_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				LoginAdm la = new LoginAdm();
				la.setVisible(true);
				dispose();
			}
			public void mouseEntered(MouseEvent arg0) {
				label_1.setIcon(new ImageIcon(LoginFunc.class.getResource("/imagens/admin2.png")));
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				label_1.setIcon(new ImageIcon(LoginFunc.class.getResource("/imagens/admin1.png")));
			}
			public void mouseReleased(MouseEvent e) {
				label_1.setIcon(new ImageIcon(LoginFunc.class.getResource("/imagens/admin1.png")));
			}
		});
		label_1.setIcon(new ImageIcon(LoginFunc.class.getResource("/imagens/admin1.png")));
		contentPane.add(label_1, "cell 0 5");
	}

}
