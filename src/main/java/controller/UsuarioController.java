package controller;

import java.io.IOException;
import java.sql.SQLException;

import bean.Usuario;
import dao.UsuarioDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/cadastro", "/login" })
public class UsuarioController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	UsuarioDAO usuarioDAO = new UsuarioDAO();
	Usuario usuario = new Usuario();
	
	public UsuarioController() {
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String acao = request.getServletPath();
		if(acao.equals("/cadastro")) {
			inserirUsuario(request, response);
		} else if (acao.equals("/login")) {
			validaEmail(request, response);
		} else {
			response.sendRedirect("login.jsp");
		}
	}
	
	protected void inserirUsuario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			usuario.setEmail(request.getParameter("email"));
			usuario.setSenha(request.getParameter("senha"));
			usuarioDAO.inserirUsuario(usuario);
			response.sendRedirect("login.jsp");
		} catch (SQLException e) {
			String error = "Usuário já cadastrado";
			request.setAttribute("errorMessage", error);
			e.printStackTrace();
			RequestDispatcher rd = request.getRequestDispatcher("cadastro.jsp");
			rd.forward(request, response);
		}
	}
	
	protected void validaEmail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
		Usuario emailValido = usuarioDAO.selecionaEmail(email);
		if(emailValido != null && emailValido.getSenha() != null && emailValido.getSenha().equals(senha)) {
			request.setAttribute("usuario", emailValido.getEmail());
			RequestDispatcher rd = request.getRequestDispatcher("main");
			rd.forward(request, response);
		} 
		String mensagemErroString = "Usuário ou senha incorreta.";
		request.setAttribute("usuarioInvalido", mensagemErroString);
		RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
		rd.forward(request, response);
	}
	
}




















