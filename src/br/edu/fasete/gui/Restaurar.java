package br.edu.fasete.gui;

import java.awt.HeadlessException;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.security.CodeSource;

import javax.swing.JOptionPane;

public class Restaurar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 try {
	        	
	            /*NOTE: String s is the mysql file name including the .sql in its name*/
	            /*NOTE: Getting path to the Jar file being executed*/
	            /*NOTE: YourImplementingClass-> replace with the class executing the code*/
	            CodeSource codeSource = Restaurar.class.getProtectionDomain().getCodeSource();
	            File jarFile = new File(codeSource.getLocation().toURI().getPath());
	            String jarDir = jarFile.getParentFile().getPath();

	            /*NOTE: Creating Database Constraints*/
	             String dbName = "loja3";
	             String dbUser = "root";
	             String dbPass = "root";

	            /*NOTE: Creating Path Constraints for restoring*/
	            String restorePath = "\"" + jarDir + "\\backup\\" + "backup.sql\"";

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


	        } catch (URISyntaxException | IOException | InterruptedException | HeadlessException ex) {
	            JOptionPane.showMessageDialog(null, "Error at Restoredbfromsql" + ex.getMessage());
	        }
		
	    }
	public static void Restoredbfromsql(String s) {
       
	}
	}


