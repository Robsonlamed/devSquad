package controller;

import java.io.IOException;

import bean.Quadro;
import dao.QuadroDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/quadro"})
public class QuadroController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	Quadro quadro = new Quadro();
	QuadroDAO quadroDAO = new QuadroDAO();
	
	public QuadroController() {
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String acao = request.getServletPath();
		if(acao.equals("/quadro")) {
			inserirQuadro(request, response);
		} else {
			response.sendRedirect("login.jsp");
		}
	}
	
	protected void inserirQuadro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		quadro.setQuadro(request.getParameter("criaQuadro"));
		quadroDAO.inseriQuadro(quadro);
		response.sendRedirect("main");
	}
	
}
