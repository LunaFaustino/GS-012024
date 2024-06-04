package br.com.global.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.global.beans.Empresa;
import br.com.global.connections.ConnectionFactory;
import br.com.global.models.Endereco;

public class EnderecoDao {
	
	public Connection minhaConexao;

	public EnderecoDao() throws ClassNotFoundException, SQLException {
		super();
		this.minhaConexao = new ConnectionFactory().conexao();
	}
	
	public String inserir(Endereco endereco) throws SQLException {
		PreparedStatement stmt = minhaConexao.prepareStatement("insert into t_endereco values(?,?,?,?,?,?,?,?)");
		
		stmt.setInt(1, endereco.getNum());
		stmt.setString(2, endereco.getCep());
		stmt.setString(3, endereco.getLogradouro());
		stmt.setString(4, endereco.getComplemento());
		stmt.setString(5, endereco.getBairro());
		stmt.setString(6, endereco.getLocalidade());
		stmt.setString(7, endereco.getUf());
		stmt.setString(8, endereco.getEmpresa().getCnpj());
		stmt.execute();
		stmt.close();
		return "Endereço cadastrado com sucesso";
		
	}
	
	public List<Endereco> visualizar() throws SQLException {
		List<Endereco> listaEndereco = new ArrayList<Endereco>();
		PreparedStatement stmt = minhaConexao.prepareStatement("select * from t_endereco");
		ResultSet rs = stmt.executeQuery();

		while (rs.next()) {
			Endereco endereco = new Endereco();
			endereco.setNum(rs.getInt(1));
			endereco.setCep(rs.getString(2));
			endereco.setLogradouro(rs.getString(3));
			endereco.setComplemento(rs.getString(4));
			endereco.setBairro(rs.getString(5));
			endereco.setLocalidade(rs.getString(6));
			endereco.setUf(rs.getString(7));
			
			Empresa empresa = new Empresa();
			empresa.setCnpj(rs.getString(8));
			
			endereco.setEmpresa(empresa);
				
			listaEndereco.add(endereco);
		}

		return listaEndereco;
	}
	
	

}
