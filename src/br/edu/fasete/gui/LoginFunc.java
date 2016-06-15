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
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
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
		setBounds(100, 100, 605, 373);
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
						janela.setVisible(true);
						dispose();
					}
			}
		});
		
		senhaField = new JPasswordField();
		contentPane.add(senhaField, "cell 0 3,grow");
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 try {
					    String caminho="";
						JFileChooser abrir = new JFileChooser();  
					    int retorno = abrir.showOpenDialog(null);  
				            if (retorno==JFileChooser.APPROVE_OPTION)  {
			                    caminho = abrir.getSelectedFile().getAbsolutePath();  					                    
							          }
					           
					             String dbName = "loja";
					             String dbUser = "root";
					             String dbPass = "root";
					            String restorePath = "\""+caminho+"\"";
					            String[] executeCmd = new String[]{"C:\\xampp\\mysql\\bin\\mysql", dbName, "-u" + dbUser, "-p" + dbPass, "-e", " source " + restorePath};
					            Process runtimeProcess = Runtime.getRuntime().exec(executeCmd);
					            int processComplete = runtimeProcess.waitFor();
					            if (processComplete == 0) {
					                JOptionPane.showMessageDialog(null, "Restaurado com sucesso! " );
					            } else {
					                JOptionPane.showMessageDialog(null, "Erro ao restaurar!");
					            }


					        } catch (IOException | InterruptedException | HeadlessException ex) {
					            JOptionPane.showMessageDialog(null, "Erro ao restaurarl" + ex.getMessage());
					        }
						
			}
		});
		
		JButton btnBackup = new JButton("backup");
		btnBackup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					 CodeSource codeSource = Backup.class.getProtectionDomain().getCodeSource();
				        File jarFile = new File(codeSource.getLocation().toURI().getPath());
				        String jarDir = jarFile.getParentFile().getPath();
				        	String nome="";
				        JFileChooser file = new JFileChooser(); 
				          file.setFileSelectionMode(JFileChooser.FILES_ONLY);
				          int i= file.showSaveDialog(null);
				        if (i==1){
				           
				        } else {
				            File arquivo = file.getSelectedFile();
				          nome = arquivo.getPath();
				        }
				        
				        String dbName = "loja";
				        String dbUser = "root";
				        String dbPass = "root";
				        String folderPath = jarDir + "\\backup2";
				        File f1 = new File(folderPath);
				        f1.mkdir();
				        String savePath = nome+".sql";
				         String executeCmd = "C:\\xampp\\mysql\\bin\\mysqldump -u" + dbUser + " -p" + dbPass + " --compact --skip-comments --skip-triggers --database " + dbName + " -r " + savePath;
				        Process runtimeProcess = Runtime.getRuntime().exec(executeCmd);
				        int processComplete = runtimeProcess.waitFor();

				        if (processComplete == 0) {
				            
				            JOptionPane.showMessageDialog(null, "Backup concluido com sucesso!");
				        } else {
				        	JOptionPane.showMessageDialog(null, "Erro ao tentar fazer o backup!");
				        }

				    } catch (URISyntaxException | IOException | InterruptedException | HeadlessException ex) {
			            JOptionPane.showMessageDialog(null, "Error at Restoredbfromsql" + ex.getMessage());
			        }
			}
		});
		contentPane.add(btnBackup, "flowx,cell 0 5");
		contentPane.add(btnNewButton, "cell 0 5,alignx right");
		lblbtnConfirmar.setIcon(new ImageIcon(LoginFunc.class.getResource("/imagens/confirmarv1.png")));
		contentPane.add(lblbtnConfirmar, "cell 0 5,alignx right");
	}

}
