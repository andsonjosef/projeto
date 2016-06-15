package br.edu.fasete.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JOptionPane;
import br.edu.fasete.principais.Cliente;
import br.edu.fasete.principais.Roupa;



public class LixeiraDaoJdbc implements LixeiraDao {
		

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
	

}
