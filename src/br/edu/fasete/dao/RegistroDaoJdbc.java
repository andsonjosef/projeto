package br.edu.fasete.dao;

import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import br.edu.fasete.principais.Aluguel;


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
			 OptionPane.showMessageDialog(null,"Registro cadastrado!");
			 a.setErro(false);
		}catch(Exception es){
			a.setErro(true);
							  JOptionPane.showMessageDialog(null,es);
		}
	}
}

