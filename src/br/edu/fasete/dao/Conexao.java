package br.edu.fasete.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class Conexao {

	 
	 private static Connection con;
	 private static String url = "jdbc:mysql://localhost:3306/loja";
	 private static String user = "root";
	 private static String pass = "";

	  
	static{
	 	 	  try{
	   Class.forName("com.mysql.jdbc.Driver");
	   
	     }
	  catch(Exception e){
	   System.out.println("Erro: " + e.getMessage());
	   	  
	  }
	 }
	 public static Connection getConnection(){
		 if(con==null){
			 try {
				 con = DriverManager.getConnection(url,user,pass);
						 }catch(SQLException e){
							 e.printStackTrace();
							 
						 }
			 }
		return con;
		 
	 }
	  public void fecharBDConn(){
			 try{
			  con.close();
			  System.out.println("Conexao finalizada com sucesso");
			 }catch(Exception e){
			  System.out.println("Erro ao fechar conexao com banco" + e.getMessage());
			 }
			  }
			}






