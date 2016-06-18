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
	public void editarLogin(Funcionario f, String login, String senha) {
		 try {
			
			  PreparedStatement stmt =  (PreparedStatement) Conexao.getConnection()
					 
			  .prepareStatement( "update loja.login_root set login = ?, senha = ? WHERE login = ? and senha = ?");
			  stmt.setString(1, login);
			  stmt.setString(2, senha);
		      stmt.setString(3, f.getLogin());
		      stmt.setString(4, f.getSenha());
		      stmt.executeUpdate(); 
		    
		      JOptionPane.showMessageDialog(null,"Login editado!");
	     }catch(Exception e){
		    JOptionPane.showMessageDialog(null, e);
		  } 
	}
	
	public void editarPergunta(Funcionario f, String pergunta, String resposta) {
		 try {
			
			  PreparedStatement stmt =  (PreparedStatement) Conexao.getConnection()
					 
			  .prepareStatement( "update loja.login_root set pergunta = ?, resposta = ? WHERE senha = ?");
			  stmt.setString(1, pergunta);
			  stmt.setString(2, resposta);
		      stmt.setString(3, f.getSenha());
		      stmt.executeUpdate(); 
		    
		      JOptionPane.showMessageDialog(null,"pergunta editada!");
	     }catch(Exception e){
		    JOptionPane.showMessageDialog(null, e);
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
	
	public Funcionario buscarPergunta(Funcionario f) {
		Funcionario lo = new Funcionario();
		  try {
			   PreparedStatement stmt =  (PreparedStatement) Conexao.getConnection()
			   .prepareStatement("select * from loja.login_root where pergunta like ? and resposta like ?");
			   stmt.setString(1,f.getPergunta());
			   stmt.setString(2,f.getRespsota());
			   
			   ResultSet rs = stmt.executeQuery();
			   
			   while(rs.next()){
				   lo.setPergunta(rs.getString("pergunta"));
				   lo.setRespsota(rs.getString("resposta"));
			   }
			   	  
			  //JOptionPane.showMessageDialog(null,"Login Encontrado!");
			  
			 
		  }catch(Exception es){
				  JOptionPane.showMessageDialog(null,"Os dados são invalidos ou estão vazios!!!");
		  }
		return lo;
	}
	public void buscarnRoot(Funcionario f) {
		  try {
			   PreparedStatement stmt =  (PreparedStatement) Conexao.getConnection()
			   .prepareStatement("select * from loja.login_root");
			  
			   
			   ResultSet rs = stmt.executeQuery();
			   
			   while(rs.next()){
				   f.setLogin(rs.getString("login"));
				   f.setSenha(rs.getString("senha"));
			   }
			   	  
			 //JOptionPane.showMessageDialog(null,"Login Encontrado!");
			  
			 
		  }catch(Exception es){
				  JOptionPane.showMessageDialog(null,"erro!");
		  }
		
	}
	
	public void buscarPerunta2(Funcionario f) {
		  try {
			   PreparedStatement stmt =  (PreparedStatement) Conexao.getConnection()
			   .prepareStatement("select * from loja.login_root");
			  
			  
			   ResultSet rs = stmt.executeQuery();
			   
			   while(rs.next()){
				   f.setPergunta(rs.getString("pergunta"));
			   }
			   	  
			 //JOptionPane.showMessageDialog(null,"Login Encontrado!");
			  
			 
		  }catch(Exception es){
				  JOptionPane.showMessageDialog(null,"erro!");
		  }
		
	}
	
}
