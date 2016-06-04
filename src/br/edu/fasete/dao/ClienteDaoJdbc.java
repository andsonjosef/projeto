package br.edu.fasete.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JOptionPane;
import br.edu.fasete.principais.Cliente;



public class ClienteDaoJdbc implements ClienteDao {
	
	
	@SuppressWarnings("resource")
	public void AtualizarCliente(Cliente c, String cpf) {
		 try {

		 String cpf1 = "";
			   PreparedStatement stmt =  (PreparedStatement) Conexao.getConnection()
			    .prepareStatement("select cpf from loja.Cliente ");
				ResultSet rs = stmt.executeQuery();
				while(rs.next()) {
					 cpf1 = rs.getString("CPF");				
				}
				if(cpf1 != c.getCPF()){
		  try {
			   stmt =  (PreparedStatement) Conexao.getConnection()
					    .prepareStatement("update loja.cliente set nome = ?, cpf = ?, rg = ?,telefone = ?, estado = ?,cidade = ?,bairro = ?,numero = ?,endereco = ? where cpf = ?");
		 
		   stmt.setString(1,c.getNome());
		   stmt.setString(2,c.getCPF());
		   stmt.setString(3,c.getRG());
		   stmt.setString(4,c.getTelefone());
		   stmt.setString(5,c.getEstado());
		   stmt.setString(6,c.getCidade());
		   stmt.setString(7,c.getBairro());
		   stmt.setString(8,c.getNumero());
		   stmt.setString(9,c.getEndereco());
			 stmt.setString(10,cpf);
		   
		   stmt.executeUpdate();
			 JOptionPane.showMessageDialog(null,"Cliente editado!");
		  
		   
		  }catch(Exception e){
		    JOptionPane.showMessageDialog(null,"Dados invalidos!");
		  }
	}else{
		try {
			   stmt =  (PreparedStatement) Conexao.getConnection()
					    .prepareStatement("update loja.cliente set nome = ?, rg = ?,telefone = ?, estado = ?,cidade = ?,bairro = ?,numero = ?,endereco = ? where cpf = ?");
		 
		   stmt.setString(1,c.getNome());
		   stmt.setString(2,c.getRG());
		   stmt.setString(3,c.getTelefone());
		   stmt.setString(4,c.getEstado());
		   stmt.setString(5,c.getCidade());
		   stmt.setString(6,c.getBairro());
		   stmt.setString(7,c.getNumero());
		   stmt.setString(8,c.getEndereco());
			 stmt.setString(9,cpf);
		   
		   stmt.executeUpdate();
			 JOptionPane.showMessageDialog(null,"Cliente editado!");
		  
		   
		  }catch(Exception e){
		    JOptionPane.showMessageDialog(null,"Dados invalidos!");
		  }
			}
		 }catch(Exception e){
			    JOptionPane.showMessageDialog(null,"Dados invalidos!");
			  }
	}
	
	///
	
	public void BuscarClienteCPF(Cliente c, String pesq) {
		 
		 try{
			 PreparedStatement stmt =  (PreparedStatement) Conexao.getConnection()
						 .prepareStatement("SELECT * FROM loja.cliente WHERE cpf = ?");
			 stmt.setString(1, pesq);
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
			}
		 }catch(Exception es){
			 JOptionPane.showMessageDialog(null,"Cliente não encontrado");
		 }
		}
	
	////
	
	public void BuscarClientenome(Cliente c, String pesq) {
		
		  try {
		    
		PreparedStatement stmt =  (PreparedStatement) Conexao.getConnection()
				 .prepareStatement("SELECT * FROM loja.cliente WHERE nome like ?");
	   stmt.setString(1,pesq);
ResultSet rs = stmt.executeQuery();

 while(rs.next())
 {
 c.setCodCliente(rs.getInt("codCliente"));
 c.setNome(rs.getString("nome"));
 c.setCPF(rs.getString("CPF"));
 c.setRG(rs.getString("RG"));
 c.setTelefone(rs.getString("telefone"));
 c.setEstado(rs.getString("estado"));
 c.setCidade(rs.getString("cidade"));
 c.setBairro(rs.getString("bairro"));
 c.setNumero(rs.getString("numero"));
 c.setEndereco(rs.getString("endereco"));
 }


}catch(Exception e){
	 
	
	 JOptionPane.showMessageDialog(null,"Cliente não encontrado");

} 
		  
		  ////

		  
	}
	public void ExcluirCliente(Cliente c) {
		 try {
			  PreparedStatement stmt =  (PreparedStatement) Conexao.getConnection()
					    .prepareStatement( "DELETE FROM loja.cliente WHERE cpf = ?");
		 stmt.setString(1,c.getCPF());
		 stmt.executeUpdate(); 
		    
		 JOptionPane.showMessageDialog(null,"Cliente excluido!");
		 
		  }catch(Exception e){
		    JOptionPane.showMessageDialog(null,"Cliente não encontrado!");
		  } 
	}

	////
	
	
	public void InserirCliente(Cliente c) {	
		  try {
			  PreparedStatement stmt;
			    stmt =  (PreparedStatement) Conexao.getConnection()
			    .prepareStatement("insert into loja.Cliente  (nome,cpf,rg,telefone,estado,cidade,bairro,numero,endereco,registrado) values (?,?,?,?,?,?,?,?,?,?)") ;
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
			   stmt.executeUpdate();
			   	 	  
			   JOptionPane.showMessageDialog(null,"Cliente cadastrado!");  
			 
	}catch(Exception es){
		  //  JOptionPane.showMessageDialog(null,"Os dados são invalidos ou estão vazios!!!");
		  JOptionPane.showMessageDialog(null,es);
	  }
	}

	////
	

	@Override
	public Vector<Cliente> listarClientes() {
		Vector<Cliente> lista = new Vector<Cliente>();
		try {
			PreparedStatement stmt = Conexao.getConnection().prepareStatement("select * from loja.Cliente where registrado = 0 ");
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
				lista.add(c);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;
	}
	
	

}
