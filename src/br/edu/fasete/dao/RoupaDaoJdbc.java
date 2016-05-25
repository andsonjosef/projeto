package br.edu.fasete.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JOptionPane;

import br.edu.fasete.principais.Aluguel;
import br.edu.fasete.principais.Cliente;
import br.edu.fasete.principais.Roupa;

public class RoupaDaoJdbc implements RoupaDao {

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
			   stmt.setBoolean(6,r.getDisponibilidade());
			   stmt.setFloat(7,r.getPreco());
			   stmt.executeUpdate();
			   
			   	 	  
			   JOptionPane.showMessageDialog(null,"Roupa cadastrada!");
			  
			 
	}catch(Exception es){
		  JOptionPane.showMessageDialog(null,"Os dados são invalidos ou estão vazios!!!");
		  JOptionPane.showMessageDialog(null,es);
	  }

	}

	@Override
	public void ExcluirRoupa(Roupa r) {
		try {
			  PreparedStatement stmt =  (PreparedStatement) Conexao.getConnection()
			  .prepareStatement( "DELETE FROM loja.roupa WHERE codRoupa = ?");
			  stmt.setInt(1,r.getCodRoupa());
		      stmt.executeUpdate(); 
		    
		     JOptionPane.showMessageDialog(null,"Roupa excluida!");
		  }catch(Exception e){
		    JOptionPane.showMessageDialog(null,"Roupa não encontrada!");
		  } 
	}

	@Override
	public Vector<Roupa> listarRoupas() {
		Vector<Roupa> lista = new Vector<Roupa>();
		try {
			PreparedStatement stmt = Conexao.getConnection().prepareStatement("select * from loja.Roupa ");
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
	
	public Vector<Roupa> listarRoupasSele() {
		Vector<Roupa> lista = new Vector<Roupa>();
		try {
			PreparedStatement stmt = Conexao.getConnection().prepareStatement("select * from loja.Roupasele ");
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

	public Vector<Roupa> listarRoupaLista() {
		Vector<Roupa> lista = new Vector<Roupa>();
		
		
		try {
			PreparedStatement stmt = Conexao.getConnection().prepareStatement("select * from loja.lista ");
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
	
	public void SomaPreco(Aluguel a){
		float sum = 0;
		try {
			   PreparedStatement stmt =  (PreparedStatement) Conexao.getConnection()
					    .prepareStatement("select SUM(preco) from loja.lista"); 
						ResultSet rs = stmt.executeQuery();
						while(rs.next()) {
							float c = rs.getInt(1);
						      sum = sum + c;
						      a.setPreco(sum);
							
						}
				
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	

	@Override
	public void AtualizarRoupa(Roupa r) {

		try {			 
		 int codRoupa = 0;
			   PreparedStatement stmt =  (PreparedStatement) Conexao.getConnection()
			    .prepareStatement("select codroupa from loja.roupa"); 
				ResultSet rs = stmt.executeQuery();
				while(rs.next()) {
					 codRoupa = rs.getInt("codroupa");
				}
				if(codRoupa == r.getCodRoupa()){
		  try {
			   stmt =  (PreparedStatement) Conexao.getConnection()
			   .prepareStatement("update loja.roupa set tipo = ?, modelo = ?, tamanho = ?,genero = ?, cor = ?,disponibilidade = ?,preco = ? where codRoupa = ?");
		 
			   stmt.setString(1,r.getTipo());
			   stmt.setString(2,r.getModelo());
			   stmt.setString(3,r.getTamanho());
			   stmt.setString(4,r.getGenero());
			   stmt.setString(5,r.getCor());
			   stmt.setBoolean(6,r.getDisponibilidade());
			   stmt.setFloat(7,r.getPreco());
			   stmt.setInt(8, codRoupa);
			   stmt.executeUpdate();
		   
			 JOptionPane.showMessageDialog(null,"Roupa editada!");
		  
		   
		  }catch(Exception e){
		    JOptionPane.showMessageDialog(null,"Dados invalidos!");
		  }
	}else{
				
				JOptionPane.showMessageDialog(null,"Código já cadastrado ou invalido!");
			}
		 }catch(Exception e){
			    JOptionPane.showMessageDialog(null,"Dados invalidos!");
			  }
	}

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
						}
		  }catch(Exception e){
			  JOptionPane.showMessageDialog(null,e);
		  } 
	}
	
	public void limparTabela() {
	    
		  try {
				PreparedStatement stmt =  (PreparedStatement) Conexao.getConnection()
				.prepareStatement("DELETE FROM loja.roupasele");
				 stmt.executeUpdate();			
		  }catch(Exception e){
			  JOptionPane.showMessageDialog(null,e);
		  }   
	}
	
	public void limparLista() {
	    
		  try {
				PreparedStatement stmt =  (PreparedStatement) Conexao.getConnection()
				.prepareStatement("DELETE FROM loja.lista");
				 stmt.executeUpdate();			
		  }catch(Exception e){
			  JOptionPane.showMessageDialog(null,e);
		  }   
	}
	
	public void ExcluirRoupaSele(Roupa r) {
		try {
			  PreparedStatement stmt =  (PreparedStatement) Conexao.getConnection()
			  .prepareStatement( "DELETE FROM loja.roupasele WHERE codRoupa = ?");
			  stmt.setInt(1,r.getCodRoupa());
		      stmt.executeUpdate(); 
		    
		     
		  }catch(Exception e){
		    JOptionPane.showMessageDialog(null,"Roupa não encontrada!");
		  } 
	}
	public void InserirRoupaSele(Roupa r) {
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
		
		  try {
			  PreparedStatement stmt;
		  
			   stmt =  (PreparedStatement) Conexao.getConnection()
			   .prepareStatement("insert into loja.Roupasele  (tipo,modelo,tamanho,genero,cor,disponibilidade,preco,codRoupa) values (?,?,?,?,?,?,?,?)") ;
			   stmt.setString(1,r.getTipo());
			   stmt.setString(2,r.getModelo());
			   stmt.setString(3,r.getTamanho());
			   stmt.setString(4,r.getGenero());
			   stmt.setString(5,r.getCor());
			   stmt.setBoolean(6,r.getDisponibilidade());
			   stmt.setFloat(7,r.getPreco());
			   stmt.setInt(8, r.getCodRoupa());
			   stmt.executeUpdate();
			   
			   	 	  
			
			  
			 
	}catch(Exception es){
		  JOptionPane.showMessageDialog(null,"Os dados são invalidos ou estão vazios!!!");
		  JOptionPane.showMessageDialog(null,es);
	  }

	}
	
	
	public void InserirLista(Roupa r, Cliente c) {

		
		  try {
			  PreparedStatement stmt;
		  
			   stmt =  (PreparedStatement) Conexao.getConnection()
			   .prepareStatement("insert into loja.lista  (codCliente,codRoupa,tipo,modelo,tamanho,genero,cor,disponibilidade,preco) values (?,?,?,?,?,?,?,?,?)") ;
			   stmt.setInt(1, c.getCodPessoa());
			   stmt.setInt(2, r.getCodRoupa());
			   stmt.setString(3,r.getTipo());
			   stmt.setString(4,r.getModelo());
			   stmt.setString(5,r.getTamanho());
			   stmt.setString(6,r.getGenero());
			   stmt.setString(7,r.getCor());
			   stmt.setBoolean(8,r.getDisponibilidade());
			   stmt.setFloat(9,r.getPreco());
			   stmt.executeUpdate();
			   
	}catch(Exception es){
		  JOptionPane.showMessageDialog(null,"Os dados são invalidos ou estão vazios!!!");
		  JOptionPane.showMessageDialog(null,es);
	  }

	}
}

