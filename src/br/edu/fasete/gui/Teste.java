package br.edu.fasete.gui;

import java.io.IOException;

public class Teste {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		   Process exec;  
	        try {  
	        	 Runtime.getRuntime().exec("cmd /c \"c:/xampp/mysql/bin/mysqldump.exe\" --user=root --password= loja > c:/teste/oi.sql"); 
	            
	        } catch (IOException e) {  
	            e.printStackTrace();  
	        }      

	}

}
