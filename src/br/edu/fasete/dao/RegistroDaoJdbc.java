package br.edu.fasete.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JOptionPane;
import br.edu.fasete.principais.Aluguel;
import br.edu.fasete.principais.Cliente;
import br.edu.fasete.principais.Roupa;


public class RegistroDaoJdbc implements RegistroDao{

	
	public void BuscarRoupaEd(Roupa r) {
	    
		  try {
		    
				PreparedStatement stmt =  (PreparedStatement) Conexao.getConnection()
				.prepareStatement("SELECT * FROM loja.roupa");
			    
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
							
							try {
								  
							  
								   stmt =  (PreparedStatement) Conexao.getConnection()
								   .prepareStatement("insert into loja.Roupasele  (tipo,modelo,tamanho,genero,cor,disponibilidade,preco,codRoupa) values (?,?,?,?,?,?,?,?)") ;
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
							  JOptionPane.showMessageDialog(null,"Os dados são invalidos ou estão vazios!!!");
							  JOptionPane.showMessageDialog(null,es);
						  }
						}
		  }catch(Exception e){
			  JOptionPane.showMessageDialog(null,e);
		  } 
	}
	public void dispinibilidade( Roupa r){
		
						 try {
							 PreparedStatement  stmt =  (PreparedStatement) Conexao.getConnection()
									    .prepareStatement("update loja.roupa set disponibilidade = ? where codRoupa = ?");
							 
							 r.setDisponibilidade(true);
						   stmt.setBoolean(1,r.isDisponibilidade());
						   stmt.setInt(2, r.getCodRoupa());
						   r.setDisponibilidade(false);
						   
						   stmt.executeUpdate();
							 
		
	  }catch(Exception e){
		  JOptionPane.showMessageDialog(null,e);
	  }
	}					 
	 public void disponivel( Roupa r){
								
							 try {
								 PreparedStatement  stmt =  (PreparedStatement) Conexao.getConnection()
										    .prepareStatement("update loja.roupa set disponibilidade = ? where codRoupa = ?");
								 
								 r.setDisponibilidade(false);
							   stmt.setBoolean(1,r.isDisponibilidade());
							   stmt.setInt(2, r.getCodRoupa());
							  
							   
							   stmt.executeUpdate();
								 
			
			}catch(Exception e){
	 } 
							 try {
								  PreparedStatement stmt =  (PreparedStatement) Conexao.getConnection()
								  .prepareStatement( "DELETE FROM loja.listafinal where codRoupa = ?");
								  stmt.setInt(1,r.getCodRoupa());
							      stmt.executeUpdate(); 
							    
							     
							  }catch(Exception e){
							    JOptionPane.showMessageDialog(null,"Roupa não encontrada!");
							  } 
							 
		
	}

	public void ExcluirReg(Cliente c) {
		try {
			  PreparedStatement stmt =  (PreparedStatement) Conexao.getConnection()
			  .prepareStatement( "DELETE FROM loja.aluguel where codCliente = ?");
			  stmt.setInt(1,c.getCodCliente());
		      stmt.executeUpdate(); 
		    
		     
		  }catch(Exception e){
		    JOptionPane.showMessageDialog(null,"Roupa não encontrada!");
		  } 
		 try {
			 PreparedStatement  stmt =  (PreparedStatement) Conexao.getConnection()
					    .prepareStatement("update loja.Cliente set registrado = ? where codCliente= ?");
			 
			 c.setRegistrado(false);
		   stmt.setBoolean(1,c.isRegistrado());
		   stmt.setInt(2, c.getCodCliente());
		   
		   
		   stmt.executeUpdate();
			 

}catch(Exception e){
JOptionPane.showMessageDialog(null,e);
} 
		try {
			  PreparedStatement stmt =  (PreparedStatement) Conexao.getConnection()
			  .prepareStatement( "DELETE FROM loja.listafinal where codCliente =?");
			  stmt.setInt(1,c.getCodCliente());
		      stmt.executeUpdate(); 
		    
		     JOptionPane.showMessageDialog(null, "Registro encerrado!");
		  }catch(Exception e){
		    JOptionPane.showMessageDialog(null,"Roupa não encontrada!");
		  } 
		
		
	}
	
	public void ExcluirRoupaSeleEdi(Roupa r) {
		try {
			  PreparedStatement stmt =  (PreparedStatement) Conexao.getConnection()
			  .prepareStatement( "DELETE FROM loja.lista WHERE codRoupa = ?");
			  stmt.setInt(1,r.getCodRoupa());
		      stmt.executeUpdate(); 
		    
		     
		  }catch(Exception e){
		    JOptionPane.showMessageDialog(null,"Roupa não encontrada!");
		  } 
		try {
			
			  PreparedStatement stmt =  (PreparedStatement) Conexao.getConnection()
			  .prepareStatement("update loja.roupasele set disponibilidade = 0 where codRoupa = ?");
			  
			  stmt.setInt(1,r.getCodRoupa());
		      stmt.executeUpdate(); 
		    
		     
		  }catch(Exception e){
		    JOptionPane.showMessageDialog(null,"Roupa não encontrada!");
		  } 
		
	}
	
	public void InserirRoupaEdi(Roupa r,Cliente c) {
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
			   .prepareStatement("insert into loja.lista  (tipo,modelo,tamanho,genero,cor,disponibilidade,preco,codRoupa,codCliente) values (?,?,?,?,?,?,?,?,?)") ;
			   stmt.setString(1,r.getTipo());
			   stmt.setString(2,r.getModelo());
			   stmt.setString(3,r.getTamanho());
			   stmt.setString(4,r.getGenero());
			   stmt.setString(5,r.getCor());
			   stmt.setBoolean(6,r.isDisponibilidade());
			   stmt.setFloat(7,r.getPreco());
			   stmt.setInt(8, r.getCodRoupa());
			   stmt.setInt(9,c.getCodCliente());
			   stmt.executeUpdate();
			   
			   	 	  
			
			  
			 
	}catch(Exception es){
		  JOptionPane.showMessageDialog(null,"Os dados são invalidos ou estão vazios!!!");
		  JOptionPane.showMessageDialog(null,es);
	  }
	}
	///
	public void InserirRegistro(Aluguel a) {		   
		try {											  
			PreparedStatement  stmt =  (PreparedStatement) Conexao.getConnection()
			  .prepareStatement("insert into loja.aluguel  (codCliente,dataLoca,dataDevo,preco,precoFinal) values (?,?,?,?,?)") ;
				 stmt.setInt(1, a.getCodCliente());
				 stmt.setString(2, a.getDataLoca());
				 stmt.setString(3,a.getDataEntre());
				 stmt.setFloat(4,a.getPreco());
				 stmt.setFloat(5, a.getPrecoTotal());
				 stmt.executeUpdate();
				 JOptionPane.showMessageDialog(null,"Registro cadastrado!");
				 a.setErro(false);
			}catch(Exception es){
				a.setErro(true);
								  JOptionPane.showMessageDialog(null,es);
			}
		try {
			 PreparedStatement  stmt =  (PreparedStatement) Conexao.getConnection()
					    .prepareStatement("update loja.cliente set registrado = ? where codCliente = ?");
			 Cliente c = new Cliente();
			 c.setRegistrado(true);
		   stmt.setBoolean(1,c.isRegistrado());
		   stmt.setInt(2, a.getCodCliente());
		   c.setRegistrado(false);
		   
		   stmt.executeUpdate();
			 
		  
		   
		  }catch(Exception e){
		    JOptionPane.showMessageDialog(null,"Dados invalidos!");
		  }
		 
		
		
		}	
	public Vector<Cliente> listarClientesReg() {
		Vector<Cliente> lista = new Vector<Cliente>();
		try {
			PreparedStatement stmt = Conexao.getConnection().prepareStatement("select * from loja.Cliente where registrado = 1 ");
			ResultSet resultado = stmt.executeQuery();
			while(resultado.next()) {
				Cliente c = new Cliente();
				
				c.setNome(resultado.getString("nome"));
				c.setCPF(resultado.getString("CPF"));
				c.setRG(resultado.getString("RG"));
				c.setTelefone(resultado.getString("telefone"));
				c.setEstado(resultado.getString("estado"));
				c.setCidade(resultado.getString("cidade"));
				c.setBairro(resultado.getString("bairro"));
				c.setEndereco(resultado.getString("endereco"));
				c.setNumero(resultado.getString("numero"));
				c.setCodCliente(resultado.getInt("codCliente"));
				
				lista.add(c);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;
	}
	public  Vector<Roupa> ListarRoupaEdi(Roupa r, Cliente c){
		
		Vector<Roupa> lista = new Vector<Roupa>();
		 
		
		try {
		
			PreparedStatement stmt = Conexao.getConnection().prepareStatement("select * from loja.listafinal where codCliente = ?");
			stmt.setInt(1, c.getCodCliente());
			ResultSet resultado = stmt.executeQuery();
			while(resultado.next()) {
				
				r.setCodRoupa(resultado.getInt("codRoupa"));
				r.setTipo(resultado.getString("tipo"));
				r.setModelo(resultado.getString("modelo"));
				r.setTamanho(resultado.getString("tamanho"));
				r.setGenero(resultado.getString("genero"));
				r.setCor(resultado.getString("cor"));
				r.setDisponibilidade(resultado.getBoolean("disponibilidade"));
				r.setPreco(resultado.getFloat("preco"));
				lista.add(r);
				
				 try {
					  					  
					   stmt =  (PreparedStatement) Conexao.getConnection()
					   .prepareStatement("insert into loja.lista  (codCliente,codRoupa,tipo,modelo,tamanho,genero,cor,disponibilidade,preco) values (?,?,?,?,?,?,?,?,?)") ;
					   stmt.setInt(1, c.getCodCliente());
					   stmt.setInt(2, r.getCodRoupa());
					   stmt.setString(3,r.getTipo());
					   stmt.setString(4,r.getModelo());
					   stmt.setString(5,r.getTamanho());
					   stmt.setString(6,r.getGenero());
					   stmt.setString(7,r.getCor());
					   stmt.setBoolean(8,r.isDisponibilidade());
					   stmt.setFloat(9,r.getPreco());
					   stmt.executeUpdate();
					   
			}catch(Exception es){
				  JOptionPane.showMessageDialog(null,"Os dados são invalidos ou estão vazios!!!");
				  JOptionPane.showMessageDialog(null,es);
			  }

			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;
		
	}
	public Vector<Roupa> listarRoupasSeleEdi() {
		Vector<Roupa> lista = new Vector<Roupa>();
		try {
			PreparedStatement stmt = Conexao.getConnection().prepareStatement("select * from loja.Roupasele where disponibilidade = 0");
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
	public Vector<Roupa> listarRoupaListaFim(Cliente c) {
		Vector<Roupa> lista = new Vector<Roupa>();
		
		
		try {
			
			
			PreparedStatement stmt = Conexao.getConnection().prepareStatement("select * from loja.listafinal WHERE codCliente = ?");
			
			    stmt.setInt(1,c.getCodCliente());
			 
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
	public void ListarRegistro(Cliente c, Aluguel a){
		try{
			PreparedStatement stmt = Conexao.getConnection().prepareStatement("select * from loja.aluguel WHERE codCliente = ?");
			 stmt.setInt(1,c.getCodCliente());
				ResultSet resultado = stmt.executeQuery();
				while(resultado.next()) {
					
					
					a.setDataEntre(resultado.getString("dataDevo"));
					a.setDataLoca(resultado.getString("dataLoca"));
					a.setPrecoTotal(resultado.getFloat("precoFinal"));
					a.setPreco(resultado.getFloat("preco"));
				}
			
		}catch(SQLException e){
			e.printStackTrace();
			
		}
		
	}
	
	public void SomaPrecoEdi(Aluguel a,Cliente c){
		float sum = 0;
		try {
			   PreparedStatement stmt =  (PreparedStatement) Conexao.getConnection()
					    .prepareStatement("select SUM(preco) from loja.lista where codCliente = ?"); 
			   stmt.setInt(1,c.getCodCliente());
						ResultSet rs = stmt.executeQuery();
						while(rs.next()) {
							float t = rs.getInt(1);
						      sum = sum + t;
						      a.setPreco(sum);
							
						}
				
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}


