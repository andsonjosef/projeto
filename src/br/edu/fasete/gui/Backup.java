package br.edu.fasete.gui;

import java.awt.HeadlessException;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.security.CodeSource;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class Backup {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
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

}
