package br.edu.fasete.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;
import br.edu.fasete.principais.Aluguel;
import br.edu.fasete.principais.Cliente;
import br.edu.fasete.principais.Roupa;


public class RegistroDaoJdbc implements RegistroDao{

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
}


