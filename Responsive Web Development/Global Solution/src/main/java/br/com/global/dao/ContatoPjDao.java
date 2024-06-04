package br.com.global.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.global.beans.ContatoPJ;
import br.com.global.beans.Empresa;
import br.com.global.connections.ConnectionFactory;

public class ContatoPjDao {

	public Connection minhaConexao;

	public ContatoPjDao() throws ClassNotFoundException, SQLException {
		super();
		this.minhaConexao = new ConnectionFactory().conexao();
	}

	public String inserir(ContatoPJ contatoPj) throws SQLException {
		PreparedStatement stmt = minhaConexao.prepareStatement("insert into t_contatopj values(?,?,?)");

		stmt.setString(1, contatoPj.getEmail());
		stmt.setString(2, contatoPj.getTel());
		stmt.setString(3, contatoPj.getEmpresa().getCnpj());
		stmt.execute();
		stmt.close();
		return "Contato da Empresa cadastrado com sucesso";

	}

	public List<ContatoPJ> visualizar() throws SQLException {
		List<ContatoPJ> listaContatoPJ = new ArrayList<ContatoPJ>();
		PreparedStatement stmt = minhaConexao.prepareStatement("select * from t_contatopj");
		ResultSet rs = stmt.executeQuery();

		while (rs.next()) {
			ContatoPJ contatoPj = new ContatoPJ();
			contatoPj.setEmail(rs.getString(1));
			contatoPj.setTel(rs.getString(2));

			Empresa empresa = new Empresa();
			empresa.setCnpj(rs.getString(3));

			contatoPj.setEmpresa(empresa);

			listaContatoPJ.add(contatoPj);
		}

		return listaContatoPJ;
	}

}
