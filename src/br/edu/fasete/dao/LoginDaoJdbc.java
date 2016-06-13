package br.edu.fasete.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import br.edu.fasete.principais.Funcionario;


public class LoginDaoJdbc implements LoginDao {

	@Override
	public void inserirLogin(Funcionario f) {
		  try {
			   PreparedStatement stmt =  (PreparedStatement) Conexao.getConnection()
			   .prepareStatement("insert into loja.login (login, senha) values (?, ?)");
			   stmt.setString(1,f.getLogin());
			   stmt.setString(2,f.getSenha());
			   stmt.executeUpdate();
			   	  
			   JOptionPane.showMessageDialog(null,"Login Cadastrado!");
			  
			 
		 }catch(Exception es){
			  JOptionPane.showMessageDialog(null,"Os dados são invalidos ou estão vazios!!!");
		  }
	}

	@Override
	public void apagarLogin(Funcionario f) {
		 try {
			  PreparedStatement stmt =  (PreparedStatement) Conexao.getConnection()
			  .prepareStatement( "DELETE FROM loja.funcionario WHERE login like ? and senha like = ?");
		      stmt.setString(1, f.getLogin());
		      stmt.setString(2, f.getSenha());
		      stmt.executeUpdate(); 
		    
		      JOptionPane.showMessageDialog(null,"Login Excluído!");
	     }catch(Exception e){
		    JOptionPane.showMessageDialog(null,"Login não encontrado!");
		  } 
	}

	@Override
	public Funcionario buscarLogin(Funcionario f) {
		Funcionario fu = new Funcionario();
		  try {
			   PreparedStatement stmt =  (PreparedStatement) Conexao.getConnection()
			   .prepareStatement("select * from loja.login where login like ? and senha like ?");
			   stmt.setString(1,f.getLogin());
			   stmt.setString(2,f.getSenha());
			   
			   ResultSet rs = stmt.executeQuery();
			   
			   while(rs.next()){
				   fu.setLogin(rs.getString("login"));
				   fu.setSenha(rs.getString("senha"));
			   }
			   	  
			  //JOptionPane.showMessageDialog(null,"Login Encontrado!");
			  
			 
		  }catch(Exception es){
				  JOptionPane.showMessageDialog(null,"Os dados são invalidos ou estão vazios!!!");
		  }
		return fu;
	}
	
	@Override
	public Funcionario buscarLoginRoot(Funcionario f) {
		Funcionario lo = new Funcionario();
		  try {
			   PreparedStatement stmt =  (PreparedStatement) Conexao.getConnection()
			   .prepareStatement("select * from loja.login_root where login like ? and senha like ?");
			   stmt.setString(1,f.getLogin());
			   stmt.setString(2,f.getSenha());
			   
			   ResultSet rs = stmt.executeQuery();
			   
			   while(rs.next()){
				   lo.setLogin(rs.getString("login"));
				   lo.setSenha(rs.getString("senha"));
			   }
			   	  
			  //JOptionPane.showMessageDialog(null,"Login Encontrado!");
			  
			 
		  }catch(Exception es){
				  JOptionPane.showMessageDialog(null,"Os dados são invalidos ou estão vazios!!!");
		  }
		return lo;
	}
}
