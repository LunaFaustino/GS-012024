package br.com.global.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.global.beans.Empresa;
import br.com.global.beans.Produto;
import br.com.global.connections.ConnectionFactory;

public class ProdutoDao {
	
	public Connection minhaConexao;

	public ProdutoDao() throws ClassNotFoundException, SQLException {
		super();
		this.minhaConexao = new ConnectionFactory().conexao();
	}

	public String inserir(Produto produto) throws SQLException {
		PreparedStatement stmt = minhaConexao.prepareStatement("insert into t_produto values(?,?,?,?)");

		stmt.setString(1, produto.getTipo());
		stmt.setDouble(2, produto.getQuantidade());
		stmt.setString(3, produto.getReciclagem());
		stmt.setString(4, produto.getEmpresa().getCnpj());
		stmt.execute();
		stmt.close();
		return "Produto cadastrado com sucesso";

	}

	public List<Produto> visualizar() throws SQLException {
		List<Produto> listaProduto = new ArrayList<Produto>();
		PreparedStatement stmt = minhaConexao.prepareStatement("select * from t_produto");
		ResultSet rs = stmt.executeQuery();

		while (rs.next()) {
			Produto produto = new Produto();
			produto.setTipo(rs.getString(1));
			produto.setQuantidade(rs.getDouble(2));
			produto.setReciclagem(rs.getString(3));

			Empresa empresa = new Empresa();
			empresa.setCnpj(rs.getString(4));

			produto.setEmpresa(empresa);

			listaProduto.add(produto);
		}

		return listaProduto;
	}

}
