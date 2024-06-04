package br.com.global.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.global.beans.Empresa;
import br.com.global.beans.Representante;
import br.com.global.connections.ConnectionFactory;

public class EmpresaDao {
	
	public Connection minhaConexao;

	public EmpresaDao() throws ClassNotFoundException, SQLException {
		super();
		this.minhaConexao = new ConnectionFactory().conexao();
	}
	
	public String inserir(Empresa empresa) throws SQLException {
		PreparedStatement stmt = minhaConexao.prepareStatement("insert into t_empresa values(?,?,?,?)");

		stmt.setString(1, empresa.getCnpj());
		stmt.setString(2, empresa.getNomeFant());
		stmt.setString(3, empresa.getRazaoSoc());
		stmt.setString(4, empresa.getRepresentante().getCpf());
		stmt.execute();
		stmt.close();
		return "Empresa cadastrada com sucesso";

	}

	public List<Empresa> visualizar() throws SQLException {
		List<Empresa> listaEmpresa = new ArrayList<Empresa>();
		PreparedStatement stmt = minhaConexao.prepareStatement("select * from t_empresa");
		ResultSet rs = stmt.executeQuery();

		while (rs.next()) {
			Empresa empresa = new Empresa();
			empresa.setCnpj(rs.getString(1));
			empresa.setNomeFant(rs.getString(2));
			empresa.setRazaoSoc(rs.getString(3));
			
			Representante representante = new Representante();
			representante.setCpf(rs.getString(4));
			
			empresa.setRepresentante(representante);

			listaEmpresa.add(empresa);
		}

		return listaEmpresa;
	}

}
