package br.edu.fasete.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JOptionPane;
import br.edu.fasete.principais.Roupa;

public class RoupaDaoJdbc implements RoupaDao {
	
	@Override
	public void AtualizarRoupa(Roupa r) {
		 
		 
		  try {
			  PreparedStatement stmt =  (PreparedStatement) Conexao.getConnection()
			   .prepareStatement("update loja.roupa set tipo = ?, modelo = ?, tamanho = ?,genero = ?, cor = ?,disponibilidade = ?,preco = ? where codRoupa = ?");
		 
			   stmt.setString(1,r.getTipo());
			   stmt.setString(2,r.getModelo());
			   stmt.setString(3,r.getTamanho());
			   stmt.setString(4,r.getGenero());
			   stmt.setString(5,r.getCor());
			   stmt.setBoolean(6,r.isDisponibilidade());
			   stmt.setFloat(7,r.getPreco());
			   stmt.setInt(8, r.getCodRoupa());
			   stmt.executeUpdate();
		   
			 JOptionPane.showMessageDialog(null,"Roupa editada!");
		  
		   
		  }catch(Exception e){
		    JOptionPane.showMessageDialog(null,"Dados invalidos!");
		  }

	}
	
	////
	
	@Override
	public void BuscarRoupa(Roupa r) {
	    
		  try {
		    
				PreparedStatement stmt =  (PreparedStatement) Conexao.getConnection()
				.prepareStatement("SELECT * FROM loja.roupa WHERE codroupa = ?");
			    stmt.setInt(1,r.getCodRoupa());
			    ResultSet resultado = stmt.executeQuery();
		  
					  while(resultado.next()) {
							r.setTipo(resultado.getString("tipo"));
							r.setModelo(resultado.getString("modelo"));
							r.setTamanho(resultado.getString("tamanho"));
							r.setGenero(resultado.getString("genero"));
							r.setCor(resultado.getString("cor"));
							r.setDisponibilidade(resultado.getBoolean("disponibilidade"));
							r.setPreco(resultado.getFloat("preco"));
							r.setCodRoupa(resultado.getInt("codRoupa"));
						}
		  }catch(Exception e){
			  JOptionPane.showMessageDialog(null,e);
		  } 
	}
	
	/////
	
	@Override
	public void ExcluirRoupa(Roupa r) {
		  try {
			    
				PreparedStatement stmt =  (PreparedStatement) Conexao.getConnection()
				.prepareStatement("SELECT * FROM loja.roupa WHERE codroupa = ?");
			    stmt.setInt(1,r.getCodRoupa());
			    ResultSet resultado = stmt.executeQuery();
		  
					  while(resultado.next()) {
							r.setTipo(resultado.getString("tipo"));
							r.setModelo(resultado.getString("modelo"));
							r.setTamanho(resultado.getString("tamanho"));
							r.setGenero(resultado.getString("genero"));
							r.setCor(resultado.getString("cor"));
							r.setDisponibilidade(resultado.getBoolean("disponibilidade"));
							r.setPreco(resultado.getFloat("preco"));
							r.setCodRoupa(resultado.getInt("codRoupa"));
						}
		  }catch(Exception e){
			  JOptionPane.showMessageDialog(null,e);
		  } 
		  if(r.isDisponibilidade()==false){
		  try {
			  PreparedStatement stmt;
		  
			   stmt =  (PreparedStatement) Conexao.getConnection()
			   .prepareStatement("insert into loja.roupalixeira  (tipo,modelo,tamanho,genero,cor,disponibilidade,preco,codRoupa) values (?,?,?,?,?,?,?,?)") ;
			   stmt.setString(1,r.getTipo());
			   stmt.setString(2,r.getModelo());
			   stmt.setString(3,r.getTamanho());
			   stmt.setString(4,r.getGenero());
			   stmt.setString(5,r.getCor());
			   stmt.setBoolean(6,r.isDisponibilidade());
			   stmt.setFloat(7,r.getPreco());
			   stmt.setInt(8, r.getCodRoupa());
			   stmt.executeUpdate();
			   
			
	}catch(Exception es){
		  JOptionPane.showMessageDialog(null,"Os dados são invalidos ou estão vazios!");
		  JOptionPane.showMessageDialog(null,es);
		  
	  }
		  
		try {
			  PreparedStatement stmt =  (PreparedStatement) Conexao.getConnection()
			  .prepareStatement( "DELETE FROM loja.roupa WHERE codRoupa = ?");
			  stmt.setInt(1,r.getCodRoupa());
		      stmt.executeUpdate(); 
		    
		     JOptionPane.showMessageDialog(null,"Roupa excluida!");
		  }catch(Exception e){
		    JOptionPane.showMessageDialog(null,"Roupa não encontrada!");
		  } 
		  }else{
			  JOptionPane.showMessageDialog(null,"Roupa registrada em aluguel!");
		  }
	}
	
	//////
	
	@Override
	public void InserirRoupa(Roupa r) {
		
		
		  try {
			  PreparedStatement stmt;
		  
			   stmt =  (PreparedStatement) Conexao.getConnection()
			   .prepareStatement("insert into loja.Roupa  (tipo,modelo,tamanho,genero,cor,disponibilidade,preco) values (?,?,?,?,?,?,?)") ;
			   stmt.setString(1,r.getTipo());
			   stmt.setString(2,r.getModelo());
			   stmt.setString(3,r.getTamanho());
			   stmt.setString(4,r.getGenero());
			   stmt.setString(5,r.getCor());
			   stmt.setBoolean(6,r.isDisponibilidade());
			   stmt.setFloat(7,r.getPreco());
			   stmt.executeUpdate();
			   
			   	 	  
			   JOptionPane.showMessageDialog(null,"Roupa cadastrada!");
			
	}catch(Exception es){
		  JOptionPane.showMessageDialog(null,"Os dados são invalidos ou estão vazios!!!");
		  JOptionPane.showMessageDialog(null,es);
		  
	  }

	}

	
	

	@Override
	public Vector<Roupa> listarRoupas() {
		Vector<Roupa> lista = new Vector<Roupa>();
		try {
			PreparedStatement stmt = Conexao.getConnection().prepareStatement("select * from loja.Roupa where disponibilidade = 0 order by tipo,modelo");
			ResultSet resultado = stmt.executeQuery();
			while(resultado.next()) {
				Roupa r = new Roupa();
				
				r.setCodRoupa(resultado.getInt("codRoupa"));
				r.setTipo(resultado.getString("tipo"));
				r.setModelo(resultado.getString("modelo"));
				r.setTamanho(resultado.getString("tamanho"));
				r.setGenero(resultado.getString("genero"));
				r.setCor(resultado.getString("cor"));
				r.setDisponibilidade(resultado.getBoolean("disponibilidade"));
				r.setPreco(resultado.getFloat("preco"));
				lista.add(r);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;
	}
	public Vector<Roupa> listartodasRoupas() {
		Vector<Roupa> lista = new Vector<Roupa>();
		try {
			PreparedStatement stmt = Conexao.getConnection().prepareStatement("select * from loja.Roupa order by tipo,modelo,genero");
			ResultSet resultado = stmt.executeQuery();
			while(resultado.next()) {
				Roupa r = new Roupa();
				
				r.setCodRoupa(resultado.getInt("codRoupa"));
				r.setTipo(resultado.getString("tipo"));
				r.setModelo(resultado.getString("modelo"));
				r.setTamanho(resultado.getString("tamanho"));
				r.setGenero(resultado.getString("genero"));
				r.setCor(resultado.getString("cor"));
				r.setDisponibilidade(resultado.getBoolean("disponibilidade"));
				r.setPreco(resultado.getFloat("preco"));
				lista.add(r);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;
	}
	
	public Vector<Roupa> listartodasRoupascod(int pesq) {
		Vector<Roupa> lista = new Vector<Roupa>();
		try {
			PreparedStatement stmt = Conexao.getConnection().prepareStatement("select * from loja.Roupa where codRoupa = ?");
			 stmt.setInt(1,pesq);
			ResultSet resultado = stmt.executeQuery();
			while(resultado.next()) {
				Roupa r = new Roupa();
				
				r.setCodRoupa(resultado.getInt("codRoupa"));
				r.setTipo(resultado.getString("tipo"));
				r.setModelo(resultado.getString("modelo"));
				r.setTamanho(resultado.getString("tamanho"));
				r.setGenero(resultado.getString("genero"));
				r.setCor(resultado.getString("cor"));
				r.setDisponibilidade(resultado.getBoolean("disponibilidade"));
				r.setPreco(resultado.getFloat("preco"));
				lista.add(r);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;
	}
	////
}

