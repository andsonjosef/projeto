package br.edu.fasete.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import br.edu.fasete.principais.Roupa;

public class RegistroDaoJdbc implements RegistroDao{
	
	public void InserirListaFinal(Roupa r) {
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
							  try {
															  
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
							  JOptionPane.showMessageDialog(null,"Os dados são invalidos ou estão vazios!");
							  
						  }
							  JOptionPane.showMessageDialog(null,"Registro cadastrado!");
						}
		  }catch(Exception e){
			  JOptionPane.showMessageDialog(null,e);
		  } 
		
		
	}

	public void InserirRegistro(Roupa r) {		   
	try {											  
		PreparedStatement  stmt =  (PreparedStatement) Conexao.getConnection()
		  .prepareStatement("insert into loja.aluguel  (codCliente,dataLoca,dataDevo,preco,precoFinal) values (?,?,?,?,?)") ;
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
							  JOptionPane.showMessageDialog(null,"Os dados são invalidos ou estão vazios!");
		}
	}
}

