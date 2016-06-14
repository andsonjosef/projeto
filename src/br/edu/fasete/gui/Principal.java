package br.edu.fasete.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.beans.PropertyVetoException;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.security.CodeSource;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JDesktopPane;
import javax.swing.JFileChooser;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.HeadlessException;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Principal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel contentPane_1;
	private JDesktopPane desktop;
	
	
	
	JCadastroCliente janelaCliente = new JCadastroCliente();
	JMenu menuCliente = new JMenu("");
	JCadastroRoupa janelaRoupa = new JCadastroRoupa();
	JMenu menuRoupa = new JMenu("");
	JAluguel janelaAluguel = new JAluguel();
	JMenu menuAluguel = new JMenu("");
	JRegistro janelaRegistro = new JRegistro();
	JMenu menuRegistro = new JMenu("");
	JFuncionario janelaFuncionario = new JFuncionario();
	JMenu menuFuncionario = new JMenu("");
	private final JLabel label = new JLabel(".................................................................................................................................................................................................................................................................................................................................................................................................");
	private final JMenu mnNewMenu = new JMenu("");
	private final JMenuItem mntmCriarBackup = new JMenuItem("Criar Backup");
	private final JMenuItem mntmRestaurarDeBackup = new JMenuItem("Restaurar de Backup");
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
            //here you can put the selected theme class name in JTattoo
            UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel");
 
		} catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					Principal frame = new Principal();
					frame.pack();
					frame.setBackground(Color.DARK_GRAY);
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
	public Principal(){
		setForeground(Color.DARK_GRAY);
		setBackground(Color.DARK_GRAY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 700);
		setExtendedState(MAXIMIZED_BOTH);
		
		
		
		//this.setUndecorated(true);        
		
		//this.getRootPane().setWindowDecorationStyle(JRootPane.FRAME);
		
		JMenuBar barraMenu = new JMenuBar();
		barraMenu.setForeground(Color.DARK_GRAY);
		barraMenu.setBackground(Color.DARK_GRAY);
		setJMenuBar(barraMenu);
		
		
		menuCliente.setForeground(Color.WHITE);
		
			menuCliente.setIcon(new ImageIcon(Principal.class.getResource("/imagens/iconemenu.png")));
		
		
		
		menuCliente.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				if(janelaCliente.isShowing()==false){
					menuCliente.setIcon(new ImageIcon(Principal.class.getResource("/imagens/iconemenu2.png")));
					}if(janelaCliente.isShowing()==true){
						menuCliente.setIcon(new ImageIcon(Principal.class.getResource("/imagens/iconemenu3.png")));	
					}
			}
			@Override
			public void mouseExited(MouseEvent e) {
				if(janelaCliente.isShowing()==false){
				menuCliente.setIcon(new ImageIcon(Principal.class.getResource("/imagens/iconemenu.png")));
				}if(janelaCliente.isShowing()==true){
					menuCliente.setIcon(new ImageIcon(Principal.class.getResource("/imagens/iconemenu3.png")));	
				}
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				
				
				desktop.add(janelaCliente);
				janelaCliente.setVisible(true);
				if(janelaCliente.isShowing()==true){
					menuCliente.setIcon(new ImageIcon(Principal.class.getResource("/imagens/iconemenu3.png")));
					menuRegistro.setIcon(new ImageIcon(Principal.class.getResource("/imagens/Registrolmenu.png")));
					menuAluguel.setIcon(new ImageIcon(Principal.class.getResource("/imagens/aluguelmenu1.png")));
					menuRoupa.setIcon(new ImageIcon(Principal.class.getResource("/imagens/roupamenu1.png")));
					menuFuncionario.setIcon(new ImageIcon(Principal.class.getResource("/imagens/funcimenu.png")));
					janelaRoupa.dispose();
					janelaAluguel.dispose();
					janelaRegistro.dispose();
					janelaFuncionario.dispose();
					
				}
				try {
					janelaCliente.setMaximum(true);
				} catch (PropertyVetoException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		
		});
		barraMenu.add(menuCliente);
		
		////
		
		
		menuRoupa.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				desktop.add(janelaRoupa);
				janelaRoupa.setVisible(true);
				if(janelaRoupa.isFocusable()==true){
					menuRegistro.setIcon(new ImageIcon(Principal.class.getResource("/imagens/Registrolmenu.png")));
					menuCliente.setIcon(new ImageIcon(Principal.class.getResource("/imagens/iconemenu.png")));
					menuAluguel.setIcon(new ImageIcon(Principal.class.getResource("/imagens/aluguelmenu1.png")));
					menuRoupa.setIcon(new ImageIcon(Principal.class.getResource("/imagens/roupamenu3.png")));
					menuFuncionario.setIcon(new ImageIcon(Principal.class.getResource("/imagens/funcimenu.png")));
					janelaCliente.dispose();
					janelaAluguel.dispose();
					janelaRegistro.dispose();
				}
				try {
					janelaRoupa.setMaximum(true);
				} catch (PropertyVetoException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				if(janelaRoupa.isShowing()==false){
					menuRoupa.setIcon(new ImageIcon(Principal.class.getResource("/imagens/roupamenu2.png")));
					}if(janelaRoupa.isShowing()==true){
						menuRoupa.setIcon(new ImageIcon(Principal.class.getResource("/imagens/roupamenu3.png")));
					}
			}
			@Override
			public void mouseExited(MouseEvent e) {
				if(janelaRoupa.isShowing()==false){
					menuRoupa.setIcon(new ImageIcon(Principal.class.getResource("/imagens/roupamenu1.png")));
				}if(janelaRoupa.isShowing()==true){
					menuRoupa.setIcon(new ImageIcon(Principal.class.getResource("/imagens/roupamenu3.png")));
				}
			}
		});
		
		
		menuRoupa.setIcon(new ImageIcon(Principal.class.getResource("/imagens/roupamenu1.png")));
		menuRoupa.setForeground(Color.WHITE);
		barraMenu.add(menuRoupa);
		
		////
		
		
		menuAluguel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(janelaAluguel.isFocusable()==true){
					janelaAluguel.carregarTabela();
					menuCliente.setIcon(new ImageIcon(Principal.class.getResource("/imagens/iconemenu.png")));
					menuRegistro.setIcon(new ImageIcon(Principal.class.getResource("/imagens/Registrolmenu.png")));
					menuRoupa.setIcon(new ImageIcon(Principal.class.getResource("/imagens/roupamenu1.png")));
					menuAluguel.setIcon(new ImageIcon(Principal.class.getResource("/imagens/aluguelmenu3.png")));
					menuFuncionario.setIcon(new ImageIcon(Principal.class.getResource("/imagens/funcimenu.png")));
					janelaCliente.dispose();
					janelaRoupa.dispose();
					janelaRegistro.dispose();
					
				}
				desktop.add(janelaAluguel);
				janelaAluguel.setVisible(true);
				try {
					janelaAluguel.setMaximum(true);
				} catch (PropertyVetoException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				if(janelaAluguel.isShowing()==false){
					menuAluguel.setIcon(new ImageIcon(Principal.class.getResource("/imagens/aluguelmenu2.png")));
					}if(janelaAluguel.isShowing()==true){
						menuAluguel.setIcon(new ImageIcon(Principal.class.getResource("/imagens/aluguelmenu3.png")));
					}
			}
			@Override
			public void mouseExited(MouseEvent e) {
				if(janelaAluguel.isShowing()==false){
					menuAluguel.setIcon(new ImageIcon(Principal.class.getResource("/imagens/aluguelmenu1.png")));
				}if(janelaAluguel.isShowing()==true){
					menuAluguel.setIcon(new ImageIcon(Principal.class.getResource("/imagens/aluguelmenu3.png")));
				}
			}
		});
		
		
		
		menuAluguel.setIcon(new ImageIcon(Principal.class.getResource("/imagens/aluguelmenu1.png")));
		menuAluguel.setForeground(Color.WHITE);
		barraMenu.add(menuAluguel);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		contentPane.setLayout(new BorderLayout(0, 0));
		desktop = new JDesktopPane();
		contentPane.add(desktop);
	menuRegistro.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			
			desktop.add(janelaRegistro);
			janelaRegistro.setVisible(true);
			if(janelaRegistro.isFocusable()==true){
				janelaRegistro.carregarTabela();
				menuRegistro.setIcon(new ImageIcon(Principal.class.getResource("/imagens/Registrolmenu3.png")));
				menuFuncionario.setIcon(new ImageIcon(Principal.class.getResource("/imagens/iconemenu.png")));
				menuAluguel.setIcon(new ImageIcon(Principal.class.getResource("/imagens/aluguelmenu1.png")));
				menuRoupa.setIcon(new ImageIcon(Principal.class.getResource("/imagens/roupamenu1.png")));
				menuFuncionario.setIcon(new ImageIcon(Principal.class.getResource("/imagens/funcimenu.png")));
				janelaAluguel.dispose();
				janelaRoupa.dispose();
				janelaFuncionario.dispose();
			}
			
			try {
				janelaRegistro.setMaximum(true);
			} catch (PropertyVetoException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}			
		}
		@Override
		public void mouseEntered(MouseEvent e) {
			if(janelaRegistro.isShowing()==false){
				menuRegistro.setIcon(new ImageIcon(Principal.class.getResource("/imagens/Registrolmenu2.png")));
				}if(janelaRegistro.isShowing()==true){
					menuRegistro.setIcon(new ImageIcon(Principal.class.getResource("/imagens/Registrolmenu3.png")));
				}
		}
		@Override
		public void mouseExited(MouseEvent e) {
			if(janelaRegistro.isShowing()==false){
				menuRegistro.setIcon(new ImageIcon(Principal.class.getResource("/imagens/Registrolmenu.png")));
			}if(janelaRegistro.isShowing()==true){
				menuRegistro.setIcon(new ImageIcon(Principal.class.getResource("/imagens/Registrolmenu3.png")));
			}
		}
	});
		
	
		
	
	menuRegistro.setIcon(new ImageIcon(Principal.class.getResource("/imagens/Registrolmenu.png")));
	menuRegistro.setForeground(Color.WHITE);
	barraMenu.add(menuRegistro);
	
	///
	
	menuFuncionario.setForeground(Color.WHITE);
	
	menuFuncionario.setIcon(new ImageIcon(Principal.class.getResource("/imagens/funcimenu.png")));
	
	
	
	menuFuncionario.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseEntered(MouseEvent e) {
			if(janelaFuncionario.isShowing()==false){
				menuFuncionario.setIcon(new ImageIcon(Principal.class.getResource("/imagens/funcimenu2.png")));
				}if(janelaFuncionario.isShowing()==true){
					menuFuncionario.setIcon(new ImageIcon(Principal.class.getResource("/imagens/funcimenu3.png")));
				}
		}
		@Override
		public void mouseExited(MouseEvent e) {
			if(janelaFuncionario.isShowing()==false){
				menuFuncionario.setIcon(new ImageIcon(Principal.class.getResource("/imagens/funcimenu.png")));
			}if(janelaFuncionario.isShowing()==true){
				menuFuncionario.setIcon(new ImageIcon(Principal.class.getResource("/imagens/funcimenu3.png")));
			}
		}
		@Override
		public void mouseClicked(MouseEvent e) {
			
			
			desktop.add(janelaFuncionario);
			janelaFuncionario.setVisible(true);
			if(janelaFuncionario.isShowing()==true){
				menuCliente.setIcon(new ImageIcon(Principal.class.getResource("/imagens/iconemenu.png")));
				menuFuncionario.setIcon(new ImageIcon(Principal.class.getResource("/imagens/funcimenu3.png")));
				menuRegistro.setIcon(new ImageIcon(Principal.class.getResource("/imagens/Registrolmenu.png")));
				menuAluguel.setIcon(new ImageIcon(Principal.class.getResource("/imagens/aluguelmenu1.png")));
				menuRoupa.setIcon(new ImageIcon(Principal.class.getResource("/imagens/roupamenu1.png")));
				janelaRoupa.dispose();
				janelaAluguel.dispose();
				janelaRegistro.dispose();
				janelaCliente.dispose();
				
			}
			try {
				janelaFuncionario.setMaximum(true);
			} catch (PropertyVetoException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	
	});
	barraMenu.add(menuFuncionario);
	label.setFont(new Font("Dialog", Font.BOLD, 5));
	label.setForeground(Color.DARK_GRAY);
	
	barraMenu.add(label);
	mnNewMenu.setIcon(new ImageIcon(Principal.class.getResource("/imagens/backupbotao1.png")));
	
	barraMenu.add(mnNewMenu);
	mntmCriarBackup.addActionListener(new ActionListener() {
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
			        /*NOTE: Creating Database Constraints*/
			        String dbName = "loja";
			        String dbUser = "root";
			        String dbPass = "root";

			        /*NOTE: Creating Path Constraints for folder saving*/
			        /*NOTE: Here the backup folder is created for saving inside it*/
			        String folderPath = jarDir + "\\backup2";

			        /*NOTE: Creating Folder if it does not exist*/
			        File f1 = new File(folderPath);
			        f1.mkdir();

			        /*NOTE: Creating Path Constraints for backup saving*/
			        /*NOTE: Here the backup is saved in a folder called backup with the name backup.sql*/
			        // String savePath = "\"" + jarDir + "\\backup2\\" + "backup11122.sql\"";
			        String savePath = nome+".sql";

			        /*NOTE: Used to create a cmd command*/
			         String executeCmd = "C:\\xampp\\mysql\\bin\\mysqldump -u" + dbUser + " -p" + dbPass + " --compact --skip-comments --skip-triggers --database " + dbName + " -r " + savePath;
			
			
			        /*NOTE: Executing the command here*/
			        Process runtimeProcess = Runtime.getRuntime().exec(executeCmd);
			        int processComplete = runtimeProcess.waitFor();

			        /*NOTE: processComplete=0 if correctly executed, will contain other values if not*/
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
	
	mnNewMenu.add(mntmCriarBackup);
	mntmRestaurarDeBackup.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
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
				            CodeSource codeSource = Restaurar.class.getProtectionDomain().getCodeSource();
				           
				            
				            /*NOTE: Creating Database Constraints*/
				             String dbName = "mysql";
				             String dbUser = "root";
				             String dbPass = "root";

				            /*NOTE: Creating Path Constraints for restoring*/
				            String restorePath = "\""+caminho+"\"";
				            JOptionPane.showMessageDialog(null, restorePath);
				           
				           

				            /*NOTE: Used to create a cmd command*/
				            /*NOTE: Do not create a single large string, this will cause buffer locking, use string array*/
				            String[] executeCmd = new String[]{"C:\\xampp\\mysql\\bin\\mysql", dbName, "-u" + dbUser, "-p" + dbPass, "-e", " source " + restorePath};

				            /*NOTE: processComplete=0 if correctly executed, will contain other values if not*/
				            Process runtimeProcess = Runtime.getRuntime().exec(executeCmd);
				            int processComplete = runtimeProcess.waitFor();

				            /*NOTE: processComplete=0 if correctly executed, will contain other values if not*/
				            if (processComplete == 0) {
				                JOptionPane.showMessageDialog(null, "Successfully restored from SQL : " );
				            } else {
				                JOptionPane.showMessageDialog(null, "Error at restoring");
				            }


				        } catch (IOException | InterruptedException | HeadlessException ex) {
				            JOptionPane.showMessageDialog(null, "Error at Restoredbfromsql" + ex.getMessage());
				        }
		}
	});
	
	mnNewMenu.add(mntmRestaurarDeBackup);
	
	
	contentPane_1 = new JPanel();
	contentPane_1.setBackground(Color.DARK_GRAY);
	contentPane_1.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane_1);
	contentPane_1.setLayout(new BorderLayout(0, 0));
	desktop = new JDesktopPane();
	contentPane_1.add(desktop);
	desktop.setBackground(Color.DARK_GRAY);

}	
	}

