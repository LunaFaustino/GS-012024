package br.com.global.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.global.beans.Representante;
import br.com.global.connections.ConnectionFactory;

public class RepresentanteDao {

	public Connection minhaConexao;

	public RepresentanteDao() throws ClassNotFoundException, SQLException {
		super();
		this.minhaConexao = new ConnectionFactory().conexao();
	}

	public String inserir(Representante representante) throws SQLException {
		PreparedStatement stmt = minhaConexao.prepareStatement("insert into t_representante values(?,?)");

		stmt.setString(1, representante.getCpf());
		stmt.setString(2, representante.getNome());
		stmt.execute();
		stmt.close();
		return "Representante cadastrado com sucesso";

	}

	public List<Representante> visualizar() throws SQLException {
		List<Representante> listaRepresentante = new ArrayList<Representante>();
		PreparedStatement stmt = minhaConexao.prepareStatement("select * from t_representante");
		ResultSet rs = stmt.executeQuery();

		while (rs.next()) {
			Representante representante = new Representante();
			representante.setCpf(rs.getString(1));
			representante.setNome(rs.getString(2));

			listaRepresentante.add(representante);
		}

		return listaRepresentante;
	}

}
