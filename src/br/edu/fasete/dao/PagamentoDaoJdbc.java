package br.edu.fasete.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JOptionPane;
import br.edu.fasete.principais.Pagamento;



public class PagamentoDaoJdbc implements PagamentoDao {
	
	
	
	public void AtualizarPagamento(Pagamento p, String cliente) {

		  try {
			  PreparedStatement  stmt =  (PreparedStatement) Conexao.getConnection()
					    .prepareStatement("update loja.pagamento set valorParc1 = ?, dataVenc1 = ?, status1 = ?,valorPago1 = ?, dataPago1 = ?,valorParc2 = ?,dataVenc2 = ?,status2 = ?,valorPago2 = ?,dataPago2 = ? where codCliente = ?");
		 
			  stmt.setFloat(1,p.getValorParc1());
			   stmt.setString(2,p.getDataVenc1());
			   stmt.setString(3,p.getStatus1());
			   stmt.setFloat(4,p.getValorPago1());
			   stmt.setString(5,p.getDataPago1());
			   stmt.setFloat(6,p.getValorParc2());
			   stmt.setString(7,p.getDataVenc2());
			   stmt.setString(8,p.getStatus2());
			   stmt.setFloat(9,p.getValorPago2());
			   stmt.setString(10, p.getDataPago2());
			   stmt.setInt(11,p.getCodCliente());
		   
		   stmt.executeUpdate();
			 JOptionPane.showMessageDialog(null,"Pagamento editado!");
		  
		   
		  }catch(Exception e){
		    JOptionPane.showMessageDialog(null,"Dados invalidos!");
		  }
	
	}
	public void BuscarPagamento(Pagamento p, String pesq) {
		
		  try {
		    
		PreparedStatement stmt =  (PreparedStatement) Conexao.getConnection()
				 .prepareStatement("SELECT * FROM loja.pagamento WHERE cliente like ?");
	   stmt.setString(1,pesq);
ResultSet rs = stmt.executeQuery();

 while(rs.next())
 {
 p.setValorParc1(rs.getFloat("valorParc1"));
 p.setDataVenc1(rs.getString("dataVenc1"));
 p.setStatus1(rs.getString("status1"));
 p.setValorPago1(rs.getFloat("valorPago1"));
 p.setDataPago1(rs.getString("dataPago1"));
 p.setValorParc1(rs.getFloat("valorParc2"));
 p.setDataVenc1(rs.getString("dataVenc2"));
 p.setStatus1(rs.getString("status2"));
 p.setValorPago1(rs.getFloat("valorPago2"));
 p.setDataPago1(rs.getString("dataPago2"));
 p.setCliente(rs.getString("cliente"));
 p.setFuncionario(rs.getString("funcionario"));
 }


}catch(Exception e){
	 
	
	 JOptionPane.showMessageDialog(null,"Cliente não encontrado");

} 
		  
		  ////

		  
	}
	public void ExcluirPagamento(Pagamento p) {
		
		 try {
			  PreparedStatement stmt =  (PreparedStatement) Conexao.getConnection()
					    .prepareStatement( "DELETE FROM loja.pagamento WHERE cliente = ? ");
		 stmt.setString(1,p.getCliente());
		 stmt.executeUpdate(); 
		    
		 JOptionPane.showMessageDialog(null,"Pagamento excluido!");
		 
		  }catch(Exception e){
		    JOptionPane.showMessageDialog(null,"Pagamento não encontrado!");
		  } 
		
	}
	public void InserirPagamento(Pagamento p) {	
		  try {
			  PreparedStatement stmt;
			    stmt =  (PreparedStatement) Conexao.getConnection()
			    .prepareStatement("insert into loja.Pagamento  (valorParc1,dataVenc1,status1,valorPago1,dataPago1,valorParc2,dataVenc2,status2,valorPago2,dataPago2,cliente,funcionario,codCliente) values (?,?,?,?,?,?,?,?,?,?,?,?,?)") ;
			   stmt.setFloat(1,p.getValorParc1());
			   stmt.setString(2,p.getDataVenc1());
			   stmt.setString(3,p.getStatus1());
			   stmt.setFloat(4,p.getValorPago1());
			   stmt.setString(5,p.getDataPago1());
			   stmt.setFloat(6,p.getValorParc2());
			   stmt.setString(7,p.getDataVenc2());
			   stmt.setString(8,p.getStatus2());
			   stmt.setFloat(9,p.getValorPago2());
			   stmt.setString(10, p.getDataPago2());
			   stmt.setString(11,p.getCliente());
			   stmt.setString(12,p.getFuncionario());
			   stmt.setInt(13,p.getCodCliente());
			   stmt.executeUpdate();
			   	 	  
			   JOptionPane.showMessageDialog(null, "Pagamento cadastrado!");
			 
	}catch(Exception es){
		  //  JOptionPane.showMessageDialog(null,"Os dados são invalidos ou estão vazios!!!");
		  JOptionPane.showMessageDialog(null,es);
	  }
	}
	public Vector<Pagamento> listarPagamentos() {
		Vector<Pagamento> lista = new Vector<Pagamento>();
		try {
			PreparedStatement stmt = Conexao.getConnection().prepareStatement("select * from loja.pagamento" );
			ResultSet resultado = stmt.executeQuery();
			while(resultado.next()) {
				Pagamento p = new Pagamento();
				
				 stmt.setFloat(1,p.getValorParc1());
				   stmt.setString(2,p.getDataVenc1());
				   stmt.setString(3,p.getStatus1());
				   stmt.setFloat(4,p.getValorPago1());
				   stmt.setString(5,p.getDataPago1());
				   stmt.setFloat(6,p.getValorParc2());
				   stmt.setString(7,p.getDataVenc2());
				   stmt.setString(8,p.getStatus2());
				   stmt.setFloat(9,p.getValorPago2());
				   stmt.setString(10, p.getDataPago2());
				   stmt.setString(11,p.getCliente());
				   stmt.setString(12,p.getFuncionario());
				lista.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;
	}
	public Vector<Pagamento> listarPagamentopesq(String pesq) {
		Vector<Pagamento> lista = new Vector<Pagamento>();
		try {
			PreparedStatement stmt = Conexao.getConnection().prepareStatement("select * from loja.pagamento where cliente like ? order by nome ");
			 stmt.setString(1, pesq + "%");
			ResultSet resultado = stmt.executeQuery();
			while(resultado.next()) {
				Pagamento p = new Pagamento();
				
				 stmt.setFloat(1,p.getValorParc1());
				   stmt.setString(2,p.getDataVenc1());
				   stmt.setString(3,p.getStatus1());
				   stmt.setFloat(4,p.getValorPago1());
				   stmt.setString(5,p.getDataPago1());
				   stmt.setFloat(6,p.getValorParc2());
				   stmt.setString(7,p.getDataVenc2());
				   stmt.setString(8,p.getStatus2());
				   stmt.setFloat(9,p.getValorPago2());
				   stmt.setString(10, p.getDataPago2());
				   stmt.setString(11,p.getCliente());
				   stmt.setString(12,p.getFuncionario());
				lista.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;
	}
	

}
