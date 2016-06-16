package br.edu.fasete.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JOptionPane;
import br.edu.fasete.principais.Cliente;
import br.edu.fasete.principais.Roupa;



public class LixeiraDaoJdbc implements LixeiraDao {
	
	public void ExcluirClienteLixe(Cliente c){
		try {
			  PreparedStatement stmt =  (PreparedStatement) Conexao.getConnection()
					    .prepareStatement( "DELETE FROM loja.clientelixeira WHERE cpf = ?");
		 stmt.setString(1,c.getCPF());
		 stmt.executeUpdate(); 
		    
		 JOptionPane.showMessageDialog(null,"Cliente excluido!");
		 
		  }catch(Exception e){
		    JOptionPane.showMessageDialog(null,"Cliente não encontrado!");
		  } 
		
	}
	
	public void ExcluirRoupaLixe(Roupa r) {
		  
		  
		try {
			  PreparedStatement stmt =  (PreparedStatement) Conexao.getConnection()
			  .prepareStatement( "DELETE FROM loja.roupalixeira WHERE codRoupa = ?");
			  stmt.setInt(1,r.getCodRoupa());
		      stmt.executeUpdate(); 
		    
		     JOptionPane.showMessageDialog(null,"Roupa excluida!");
		  }catch(Exception e){
		    JOptionPane.showMessageDialog(null,"Roupa não encontrada!");
		  } 
	}

	@Override
	public Vector<Cliente> listarClienteslixe() {
		Vector<Cliente> lista = new Vector<Cliente>();
		try {
			PreparedStatement stmt = Conexao.getConnection().prepareStatement("select * from loja.clientelixeira ");
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
	
	@Override
	public Vector<Roupa> listarRoupalixe() {
		Vector<Roupa> lista = new Vector<Roupa>();
		try {
			PreparedStatement stmt = Conexao.getConnection().prepareStatement("select * from loja.Roupalixeira");
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
	
	public void RestaurarCliente(Cliente c) {
		try{
			 PreparedStatement stmt =  (PreparedStatement) Conexao.getConnection()
						 .prepareStatement("SELECT * FROM loja.clientelixeira WHERE cpf = ?");
			 stmt.setString(1, c.getCPF());
			 ResultSet rs = stmt.executeQuery();

			while(rs.next()){
			c.setNome(rs.getString("nome"));
			c.setCPF(rs.getString("CPF"));
			c.setRG(rs.getString("RG"));
			c.setTelefone(rs.getString("telefone"));
			c.setEstado(rs.getString("estado"));
			c.setCidade(rs.getString("cidade"));
			c.setBairro(rs.getString("bairro"));
			c.setNumero(rs.getString("numero"));
			c.setEndereco(rs.getString("endereco"));
			c.setCodCliente(rs.getInt("codCliente"));
			}
		 }catch(Exception es){
			 JOptionPane.showMessageDialog(null,"Cliente não encontrado");
		 }
		 try {
			  PreparedStatement stmt;
			    stmt =  (PreparedStatement) Conexao.getConnection()
			    .prepareStatement("insert into loja.cliente (nome,cpf,rg,telefone,estado,cidade,bairro,numero,endereco,registrado,codCliente) values (?,?,?,?,?,?,?,?,?,?,?)") ;
			   stmt.setString(1,c.getNome());
			   stmt.setString(2,c.getCPF());
			   stmt.setString(3,c.getRG());
			   stmt.setString(4,c.getTelefone());
			   stmt.setString(5,c.getEstado());
			   stmt.setString(6,c.getCidade());
			   stmt.setString(7,c.getBairro());
			   stmt.setString(8,c.getNumero());
			   stmt.setString(9,c.getEndereco());
			   stmt.setBoolean(10, c.isRegistrado());
			   stmt.setInt(11, c.getCodCliente());
			   stmt.executeUpdate();
			   	 	  
			  
			 
	}catch(Exception es){
		  //  JOptionPane.showMessageDialog(null,"Os dados são invalidos ou estão vazios!!!");
		  JOptionPane.showMessageDialog(null,es);
	  }
		 try {
			  PreparedStatement stmt =  (PreparedStatement) Conexao.getConnection()
					    .prepareStatement( "DELETE FROM loja.clientelixeira WHERE cpf = ?");
		 stmt.setString(1,c.getCPF());
		 stmt.executeUpdate(); 
		    
		 JOptionPane.showMessageDialog(null,"Cliente Restaurado!");
		 
		  }catch(Exception e){
		    JOptionPane.showMessageDialog(null,"Cliente não encontrado!");
		  } 
	}

	public void RestaurarRoupa(Roupa r) {
		  try {
			    
				PreparedStatement stmt =  (PreparedStatement) Conexao.getConnection()
				.prepareStatement("SELECT * FROM loja.roupalixeira WHERE codroupa = ?");
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
			   .prepareStatement("insert into loja.roupa  (tipo,modelo,tamanho,genero,cor,disponibilidade,preco,codRoupa) values (?,?,?,?,?,?,?,?)") ;
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
		  
		try {
			  PreparedStatement stmt =  (PreparedStatement) Conexao.getConnection()
			  .prepareStatement( "DELETE FROM loja.roupalixeira WHERE codRoupa = ?");
			  stmt.setInt(1,r.getCodRoupa());
		      stmt.executeUpdate(); 
		    
		     JOptionPane.showMessageDialog(null,"Roupa restaurada!");
		  }catch(Exception e){
		    JOptionPane.showMessageDialog(null,"Roupa não encontrada!");
		  } 
	}
}
