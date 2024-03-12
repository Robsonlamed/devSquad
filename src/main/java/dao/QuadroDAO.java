package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import bean.Quadro;

public class QuadroDAO extends GenericDAO {
	
	public void inseriQuadro(Quadro quadro) {
		String create = "insert into quadro (quadro) values (?)";
		try {
			Connection connection = conectar();
			PreparedStatement statement = connection.prepareStatement(create);
			statement.setString(1, quadro.getQuadro());
			statement.executeUpdate();
			connection.close();

		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	
	public void listarQuadro(Quadro quadro) {
		String readId = "select * from quadro where quadroId = ?";
		try {
			Connection connection = conectar();
			PreparedStatement statement = connection.prepareStatement(readId);
			statement.setString(1, quadro.getQuadroId());
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				quadro.setQuadro(result.getString(2));
			}
			connection.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public void deletarQuadro() {
		String delete = "TRUNCATE TABLE quadro";
		try {
			Connection connection = conectar();
			PreparedStatement statement = connection.prepareStatement(delete);
			statement.executeUpdate();
			connection.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
