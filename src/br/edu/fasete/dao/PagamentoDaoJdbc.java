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
					    .prepareStatement("update loja.pagamento set valorParc1 = ?, dataVenc1 = ?, status1 = ?,valorPago1 = ?, dataPago1 = ?,valorParc2 = ?,dataVenc2 = ?,status2 = ?,valorPago2 = ?,dataPago2 = ?, preco = ?, precoFinal =? precoTotal=? where codCliente = ?");
		 
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
			  
			   stmt.setFloat(11, p.getPreco());
			   stmt.setFloat(12,p.getPrecoFinal());
			   stmt.setFloat(13, p.getPrecoTotal());
			   stmt.setInt(14,p.getCodCliente());
		   
		   stmt.executeUpdate();
			 JOptionPane.showMessageDialog(null,"Pagamento salvo!");
		  
		   
		  }catch(Exception e){
		    JOptionPane.showMessageDialog(null,e);
		  }
	
	}
	public void BuscarPagamento(Pagamento p, String pesq) {
		
		  try {
		    
		PreparedStatement stmt =  (PreparedStatement) Conexao.getConnection()
				 .prepareStatement("SELECT * FROM loja.pagamento WHERE codCliente like ?");
	   stmt.setInt(1,p.getCodCliente());
ResultSet rs = stmt.executeQuery();

 while(rs.next())
 {
 p.setValorParc1(rs.getFloat("valorParc1"));
 p.setDataVenc1(rs.getString("dataVenc1"));
 p.setStatus1(rs.getString("status1"));
 p.setValorPago1(rs.getFloat("valorPago1"));
 p.setDataPago1(rs.getString("dataPago1"));
 p.setValorParc2(rs.getFloat("valorParc2"));
 p.setDataVenc2(rs.getString("dataVenc2"));
 p.setStatus2(rs.getString("status2"));
 p.setValorPago2(rs.getFloat("valorPago2"));
 p.setDataPago2(rs.getString("dataPago2"));
 p.setCliente(rs.getString("cliente"));
 p.setFuncionario(rs.getString("funcionario"));
 }


}catch(Exception e){
	 
	
	 JOptionPane.showMessageDialog(null,"pagamento não encontrado");

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
			    .prepareStatement("insert into loja.Pagamento  (valorParc1,dataVenc1,status1,valorPago1,dataPago1,valorParc2,dataVenc2,status2,valorPago2,dataPago2,cliente,funcionario,codCliente,preco,precoFinal,precoTotal) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)") ;
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
			   stmt.setFloat(14, p.getPreco());
			   stmt.setFloat(15,p.getPrecoFinal());
			   stmt.setFloat(16, p.getPrecoTotal());
			   stmt.executeUpdate();
			   	 	  
			
			 
	}catch(Exception es){
		  //  JOptionPane.showMessageDialog(null,"Os dados são invalidos ou estão vazios!!!");
		  JOptionPane.showMessageDialog(null,es);
	  }
	}
	public Vector<Pagamento> listarPagamentos() {
		Vector<Pagamento> lista = new Vector<Pagamento>();
		try {
			PreparedStatement stmt = Conexao.getConnection().prepareStatement("select * from loja.pagamento" );
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				Pagamento p = new Pagamento();
				
				p.setValorParc1(rs.getFloat("valorParc1"));
				 p.setDataVenc1(rs.getString("dataVenc1"));
				 p.setStatus1(rs.getString("status1"));
				 p.setValorPago1(rs.getFloat("valorPago1"));
				 p.setDataPago1(rs.getString("dataPago1"));
				 p.setValorParc2(rs.getFloat("valorParc2"));
				 p.setDataVenc2(rs.getString("dataVenc2"));
				 p.setStatus2(rs.getString("status2"));
				 p.setValorPago2(rs.getFloat("valorPago2"));
				 p.setDataPago2(rs.getString("dataPago2"));
				 p.setCliente(rs.getString("cliente"));
				 p.setFuncionario(rs.getString("funcionario"));
				 p.setPrecoTotal(rs.getFloat("precototal"));
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
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				Pagamento p = new Pagamento();
				
				p.setValorParc1(rs.getFloat("valorParc1"));
				 p.setDataVenc1(rs.getString("dataVenc1"));
				 p.setStatus1(rs.getString("status1"));
				 p.setValorPago1(rs.getFloat("valorPago1"));
				 p.setDataPago1(rs.getString("dataPago1"));
				 p.setValorParc2(rs.getFloat("valorParc2"));
				 p.setDataVenc2(rs.getString("dataVenc2"));
				 p.setStatus2(rs.getString("status2"));
				 p.setValorPago2(rs.getFloat("valorPago2"));
				 p.setDataPago2(rs.getString("dataPago2"));
				 p.setCliente(rs.getString("cliente"));
				 p.setFuncionario(rs.getString("funcionario"));
				 p.setPrecoTotal(rs.getFloat("precototal"));
				lista.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;
	}
	public void pagamentoTotal(Pagamento p){
		
		try {
			   PreparedStatement stmt =  (PreparedStatement) Conexao.getConnection()
					    .prepareStatement("select SUM(? + ?) as total from loja.pagamento where codCliente = ?");
			   stmt.setFloat(1,p.getValorPago1());
			   stmt.setFloat(2,p.getValorPago2());
			    stmt.setInt(3,p.getCodCliente());
						ResultSet rs = stmt.executeQuery();
						while(rs.next()) {
							
						       p.setPrecoTotal( rs.getFloat("total"));
						    JOptionPane.showMessageDialog(null, p.getPrecoTotal());
							
						}
				
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e);
			
		}
	}

}
