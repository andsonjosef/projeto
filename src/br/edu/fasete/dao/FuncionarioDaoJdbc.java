package br.edu.fasete.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JOptionPane;
import br.edu.fasete.principais.Funcionario;



public class FuncionarioDaoJdbc implements FuncionarioDao {
	
	
	@SuppressWarnings("resource")
	public void AtualizarFuncionario(Funcionario f, String cpf) {
		 try {

		 String cpf1 = "";
			   PreparedStatement stmt =  (PreparedStatement) Conexao.getConnection()
			    .prepareStatement("select CPF from loja.Funcionario ");
				ResultSet rs = stmt.executeQuery();
				while(rs.next()) {
					 cpf1 = rs.getString("CPF");				
				}
				if(cpf1 != f.getCPF()){
		  try {
			   stmt =  (PreparedStatement) Conexao.getConnection()
					    .prepareStatement("update loja.Funcionario set nome = ?, cpf = ?, rg = ?,telefone = ?, estado = ?,cidade = ?,bairro = ?,numero = ?,endereco = ?, login = ?,  senha = ?  where cpf = ? ");
		 
		   stmt.setString(1,f.getNome());
		   stmt.setString(2,f.getCPF());
		   stmt.setString(3,f.getRG());
		   stmt.setString(4,f.getTelefone());
		   stmt.setString(5,f.getEstado());
		   stmt.setString(6,f.getCidade());
		   stmt.setString(7,f.getBairro());
		   stmt.setString(8,f.getNumero());
		   stmt.setString(9,f.getEndereco());
		   stmt.setString(10,f.getLogin());
		   stmt.setString(11,f.getSenha());
			 stmt.setString(12,cpf);
		   
		   stmt.executeUpdate();
			 JOptionPane.showMessageDialog(null,"Funcionário editado!");
		  
		   
		  }catch(Exception e){
		    JOptionPane.showMessageDialog(null,e);
		  }
	}else{
		try {
			   stmt =  (PreparedStatement) Conexao.getConnection()
					    .prepareStatement("update loja.funcionario set nome = ?, rg = ?,telefone = ?, estado = ?,cidade = ?,bairro = ?,numero = ?,endereco = ?, login = ?,  senha = ? where cpf = ?");
		 
		   stmt.setString(1,f.getNome());
		   stmt.setString(2,f.getRG());
		   stmt.setString(3,f.getTelefone());
		   stmt.setString(4,f.getEstado());
		   stmt.setString(5,f.getCidade());
		   stmt.setString(6,f.getBairro());
		   stmt.setString(7,f.getNumero());
		   stmt.setString(8,f.getEndereco());
		   stmt.setString(9,f.getLogin());
		   stmt.setString(10,f.getSenha());
			 stmt.setString(11,cpf);
		   
		   stmt.executeUpdate();
			 JOptionPane.showMessageDialog(null,"Funcionário editado!");
		  
		   
		  }catch(Exception e){
		    JOptionPane.showMessageDialog(null,e);
		  }
			}
		 }catch(Exception e){
			    JOptionPane.showMessageDialog(null,e);
			  }
	}
	
	///
	
	public void BuscarFuncionarioCPF(Funcionario f, String pesq) {
		 
		 try{
			 PreparedStatement stmt =  (PreparedStatement) Conexao.getConnection()
						 .prepareStatement("SELECT * FROM loja.funcionario WHERE cpf = ?");
			 stmt.setString(1, pesq);
			 ResultSet rs = stmt.executeQuery();

			while(rs.next()){
			f.setNome(rs.getString("nome"));
			f.setCPF(rs.getString("CPF"));
			f.setRG(rs.getString("RG"));
			f.setTelefone(rs.getString("telefone"));
			f.setEstado(rs.getString("estado"));
			f.setCidade(rs.getString("cidade"));
			f.setBairro(rs.getString("bairro"));
			f.setNumero(rs.getString("numero"));
			f.setEndereco(rs.getString("endereco"));
			f.setLogin(rs.getString("login"));
			f.setSenha(rs.getString("senha"));
			}
		 }catch(Exception es){
			 JOptionPane.showMessageDialog(null,"Funcionário não encontrado");
		 }
		}
	
	////
	
	public void BuscarFuncionarionome(Funcionario f, String pesq) {
		
		  try {
		    
		PreparedStatement stmt =  (PreparedStatement) Conexao.getConnection()
				 .prepareStatement("SELECT * FROM loja.funcionario WHERE nome like ?");
	   stmt.setString(1,pesq);
ResultSet rs = stmt.executeQuery();

 while(rs.next())
 {
 f.setCodFuncionario(rs.getInt("codFuncionario"));
 f.setNome(rs.getString("nome"));
 f.setCPF(rs.getString("CPF"));
 f.setRG(rs.getString("RG"));
 f.setTelefone(rs.getString("telefone"));
 f.setEstado(rs.getString("estado"));
 f.setCidade(rs.getString("cidade"));
 f.setBairro(rs.getString("bairro"));
 f.setNumero(rs.getString("numero"));
 f.setEndereco(rs.getString("endereco"));
 f.setLogin(rs.getString("login"));
 f.setSenha(rs.getString("senha"));
 }


}catch(Exception e){
	 
	
	 JOptionPane.showMessageDialog(null,"Funcionário não encontrado");

} 
		  
		  ////

		  
	}
	public void ExcluirFuncionario(Funcionario f) {
		 try {
			  PreparedStatement stmt =  (PreparedStatement) Conexao.getConnection()
					    .prepareStatement( "DELETE FROM loja.funcionario WHERE CPF = ?");
		 stmt.setString(1,f.getCPF());
		 stmt.executeUpdate(); 
		    
		 JOptionPane.showMessageDialog(null,"Funcionário excluido!");
		 
		  }catch(Exception e){
		    JOptionPane.showMessageDialog(null,"Funcionário não encontrado!");
		  } 
	}

	////
	
	
	public void InserirFuncionario(Funcionario f) {	
		  try {
			  PreparedStatement stmt;
			    stmt =  (PreparedStatement) Conexao.getConnection()
			    .prepareStatement("insert into loja.funcionario  (nome,cpf,rg,telefone,estado,cidade,bairro,numero,endereco,registrado,login,senha) values (?,?,?,?,?,?,?,?,?,?,?,?)") ;
			   stmt.setString(1,f.getNome());
			   stmt.setString(2,f.getCPF());
			   stmt.setString(3,f.getRG());
			   stmt.setString(4,f.getTelefone());
			   stmt.setString(5,f.getEstado());
			   stmt.setString(6,f.getCidade());
			   stmt.setString(7,f.getBairro());
			   stmt.setString(8,f.getNumero());
			   stmt.setString(9,f.getEndereco());
			   stmt.setBoolean(10, f.isRegistrado());
			   stmt.setString(11,f.getLogin());
			   stmt.setString(12,f.getSenha());
			   stmt.executeUpdate();
			   	 	  
			   JOptionPane.showMessageDialog(null,"Funcionário cadastrado!");  
			 
	}catch(Exception es){
		  //  JOptionPane.showMessageDialog(null,"Os dados são invalidos ou estão vazios!!!");
		  JOptionPane.showMessageDialog(null,es);
	  }
	}

	////
	

	@Override
	public Vector<Funcionario> listarFuncionario() {
		Vector<Funcionario> lista = new Vector<Funcionario>();
		try {
			PreparedStatement stmt = Conexao.getConnection().prepareStatement("select * from loja.funcionario");
			ResultSet resultado = stmt.executeQuery();
			while(resultado.next()) {
				Funcionario f = new Funcionario();
				
				f.setNome(resultado.getString("nome"));
				f.setCPF(resultado.getString("CPF"));
				f.setRG(resultado.getString("RG"));
				f.setTelefone(resultado.getString("telefone"));
				f.setEstado(resultado.getString("estado"));
				f.setCidade(resultado.getString("cidade"));
				f.setBairro(resultado.getString("bairro"));
				f.setEndereco(resultado.getString("endereco"));
				f.setNumero(resultado.getString("numero"));
				f.setCodFuncionario(resultado.getInt("codFuncionario"));
				f.setLogin(resultado.getString("login"));
				lista.add(f);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;
	}
	
	

}
