package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.Usuario;

public class UsuarioDAO extends GenericDAO {
	
	public void inserirUsuario(Usuario usuario) throws SQLException {
		String create = "insert into usuario (email, senha) value (?,?);";
		try {
			Connection connection = conectar();
			PreparedStatement statement = connection.prepareStatement(create);
			statement.setString(1, usuario.getEmail());
			statement.setString(2, usuario.getSenha());
			statement.executeUpdate();
			connection.close();
		} catch (Exception e) {
			throw e;
		}
	}
	
	public Usuario selecionaEmail(String email) {
		Usuario emailValido = null;
		String readEmail = "select * from usuario where email = ?";
		try {
			Connection connection = conectar();
			PreparedStatement statement = connection.prepareStatement(readEmail);
			statement.setString(1, email);
			
			try (ResultSet result = statement.executeQuery()) {
				if(result.next()) {
					emailValido = new Usuario();
					emailValido.setEmail(result.getString("email"));
					emailValido.setSenha(result.getString("senha"));
				}
			} catch (Exception e) {
				System.out.println(e);
			}
			connection.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return emailValido;
	}
}
