package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.PontoPositivo;

// TODO: Auto-generated Javadoc
/**
 * The Class DAO.
 */
public class PontoPositivoDAO extends GenericDAO {

	public void inserirPontoPositivo(PontoPositivo pontoPositivo) {
		String create = "insert into pontoPositivo (pontoPositivo, cor) values (?,?)";
		try {
			Connection connection = conectar();
			PreparedStatement statement = connection.prepareStatement(create);
			statement.setString(1, pontoPositivo.getPontoPositivo());
			statement.setString(2, pontoPositivo.getCor());
			statement.executeUpdate();
			connection.close();

		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public ArrayList<PontoPositivo> listarPontoPositivo() {
		ArrayList<PontoPositivo> pontosPositivo = new ArrayList<>();
		String read = "select * from pontoPositivo";
		try {
			Connection connection = conectar();
			PreparedStatement statement = connection.prepareStatement(read);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				String id = result.getString(1);
				String pontoPositivo = result.getString(2);
				String cor = result.getString(3);
				pontosPositivo.add(new PontoPositivo(id, pontoPositivo, cor));
			}
			connection.close();
			return pontosPositivo;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	public void selecionarPontoPositivo(PontoPositivo pontoPositivo) {
		String readId = "select * from pontoPositivo where id = ?";
		try {
			Connection connection = conectar();
			PreparedStatement statement = connection.prepareStatement(readId);
			statement.setString(1, pontoPositivo.getId());
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				pontoPositivo.setId(result.getString(1));
				pontoPositivo.setPontoPositivo(result.getString(2));;
				pontoPositivo.setCor(result.getString(3));
			}
			connection.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void editaPontoPositivo(PontoPositivo pontoPositivo) {
		String update = "update pontoPositivo set pontoPositivo=?, cor=? where id=?";
		try {
			Connection connection = conectar();
			PreparedStatement statement = connection.prepareStatement(update);
			statement.setString(1, pontoPositivo.getPontoPositivo());
			statement.setString(2, pontoPositivo.getCor());
			statement.setString(3, pontoPositivo.getId());
			statement.executeUpdate();
			connection.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void deletarPontoPositivo(PontoPositivo pontoPositivo) {
		String delete = "delete from pontoPositivo where id=?";
		try {
			Connection connection = conectar();
			PreparedStatement statement = connection.prepareStatement(delete);
			statement.setString(1, pontoPositivo.getId());
			statement.executeUpdate();
			connection.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public void limpaQuadroPontoPositivo() {
		String limpaQuadros = "TRUNCATE TABLE pontoPositivo;";
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
