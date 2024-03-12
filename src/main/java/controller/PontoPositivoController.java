package controller;

import java.io.IOException;

import bean.PontoPositivo;
import dao.PontoPositivoDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// TODO: Auto-generated Javadoc
/**
 * The Class Controller.
 */
@WebServlet(urlPatterns = { "/controller", "/pontoPositivo", "/selecionaPontoPositivo", "/updatePontoPositivo", "/delete",})
public class PontoPositivoController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	PontoPositivoDAO pontoPositivoDAO = new PontoPositivoDAO();
	PontoPositivo pontoPositivo = new PontoPositivo();
	
	public PontoPositivoController() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String acao = request.getServletPath();
		if (acao.equals("/pontoPositivo")) {
			inserirPontoPositivo(request, response);
		} else if (acao.equals("/selecionaPontoPositivo")) {
			pontoPositivoId(request, response);
		} else if (acao.equals("/updatePontoPositivo")) {
			editaPontoPositivo(request, response);
		} else if (acao.equals("/delete")) {
			removerPontoPositivo(request, response);
		} else {
			response.sendRedirect("login.jsp");
		}
	}
	
	protected void inserirPontoPositivo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		pontoPositivo.setPontoPositivo(request.getParameter("textAreaPontoPositivo"));
		pontoPositivo.setCor(request.getParameter("corBackGroundTextArea"));
		pontoPositivoDAO.inserirPontoPositivo(pontoPositivo);
		response.sendRedirect("main");
	}
	
	protected void pontoPositivoId(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		pontoPositivo.setId(id);
		pontoPositivoDAO.selecionarPontoPositivo(pontoPositivo);
		request.setAttribute("pontosPositivo", pontoPositivo);
		RequestDispatcher rd = request.getRequestDispatcher("editarPontos.jsp");
		rd.forward(request, response);
	}

	protected void editaPontoPositivo(HttpServletRequest request, HttpServletResponse response)	throws ServletException, IOException {
		pontoPositivo.setId(request.getParameter("idEditaPositivo"));
		pontoPositivo.setPontoPositivo(request.getParameter("textAreaPontoPositivo"));
		pontoPositivo.setCor(request.getParameter("corBackGroundTextArea"));
		pontoPositivoDAO.editaPontoPositivo(pontoPositivo);
		response.sendRedirect("main");
	}

	protected void removerPontoPositivo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		pontoPositivo.setId(id);
		pontoPositivoDAO.deletarPontoPositivo(pontoPositivo);
		response.sendRedirect("main");
	}
}
