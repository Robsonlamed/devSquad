package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.sql.ResultSet;

import bean.PontoSerMelhorado;

public class PontoSerMelhoradoDAO extends GenericDAO {
	
	public void inserirPontoSerMelhorado(PontoSerMelhorado pontoSerMelhorado) {
		String create = "insert into pontoSerMelhorado (pontoSerMelhorado,cor) values (?,?)";
		try {
			Connection connection = conectar();
			PreparedStatement statement = connection.prepareStatement(create);
			statement.setString(1, pontoSerMelhorado.getpontoSerMelhorado());
			statement.setString(2, pontoSerMelhorado.getCor());
			statement.executeUpdate();
			connection.close();

		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public ArrayList<PontoSerMelhorado> listarPontoSerMelhorado() {
		ArrayList<PontoSerMelhorado> pontosSerMelhorados = new ArrayList<>();
		String read = "select * from pontoSerMelhorado";
		try {
			Connection connection = conectar();
			PreparedStatement statement = connection.prepareStatement(read);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				String id = result.getString(1);
				String pontoPositivo = result.getString(2);
				String cor = result.getString(3);
				pontosSerMelhorados.add(new PontoSerMelhorado(id, pontoPositivo, cor));
			}
			connection.close();
			return pontosSerMelhorados;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	
	public void selecionarPontoSerMelhorado(PontoSerMelhorado pontoSerMelhorado) {
		String readId = "select * from pontoSerMelhorado where id = ?";
		try {
			Connection connection = conectar();
			PreparedStatement statement = connection.prepareStatement(readId);
			statement.setString(1, pontoSerMelhorado.getId());
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				pontoSerMelhorado.setId(result.getString(1));
				pontoSerMelhorado.setpontoSerMelhorado(result.getString(2));
				pontoSerMelhorado.setCor(result.getString(3));
			}
			connection.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public void editaPontoSerMelhorado(PontoSerMelhorado pontoSerMelhorado) {
		String update = "update pontoSerMelhorado set pontoSerMelhorado=?, cor=? where id=?";
		try {
			Connection connection = conectar();
			PreparedStatement statement = connection.prepareStatement(update);
			statement.setString(1, pontoSerMelhorado.getpontoSerMelhorado());
			statement.setString(2, pontoSerMelhorado.getCor());
			statement.setString(3, pontoSerMelhorado.getId());
			statement.executeUpdate();
			connection.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public void deletarPontoSerMelhorado(PontoSerMelhorado pontoSerMelhorado) {
		String delete = "delete from pontoSerMelhorado where id=?";
		try {
			Connection connection = conectar();
			PreparedStatement statement = connection.prepareStatement(delete);
			statement.setString(1, pontoSerMelhorado.getId());
			statement.executeUpdate();
			connection.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public void limpaQuadroPontoSerMelhorado() {
		String limpaQuadros = "TRUNCATE TABLE pontoSerMelhorado;";
		try {
			Connection connection = conectar();
			PreparedStatement statement = connection.prepareStatement(limpaQuadros);
			statement.executeUpdate();
			connection.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
