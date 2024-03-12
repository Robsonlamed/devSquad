package controller;

import java.io.IOException;

import bean.PontoSerMelhorado;
import dao.PontoSerMelhoradoDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/pontoSerMelhorado", "/selecionaPontoSerMelhorado", "/updatePontoSerMelhorado", "/deletePontoSerMelhorado"})

public class PontoSerMelhoradoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	PontoSerMelhorado pontoSerMelhorado = new PontoSerMelhorado();
	PontoSerMelhoradoDAO pontoSerMelhoradoDAO = new PontoSerMelhoradoDAO();
	
	public PontoSerMelhoradoController() {
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String acao = request.getServletPath();
		if(acao.equals("/pontoSerMelhorado")) {
			inserirPontoSerMelhorado(request, response);
		} else if (acao.equals("/selecionaPontoSerMelhorado")) {
			pontoSerMelhoradoId(request, response);
		} else if (acao.equals("/updatePontoSerMelhorado")) {
			editaPontoSerMelhorado(request, response);
		} else if (acao.equals("/deletePontoSerMelhorado")) {
			removerPontoSerMelhorado(request, response);
		} else {
			response.sendRedirect("login.jsp");
		}
	}
	
	protected void inserirPontoSerMelhorado(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		pontoSerMelhorado.setpontoSerMelhorado(request.getParameter("textAreaPontoSerMelhorado"));
		pontoSerMelhorado.setCor(request.getParameter("corBackGroundTextArea"));
		pontoSerMelhoradoDAO.inserirPontoSerMelhorado(pontoSerMelhorado);
		response.sendRedirect("main");
	}
	
	protected void pontoSerMelhoradoId(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		pontoSerMelhorado.setId(id);
		pontoSerMelhoradoDAO.selecionarPontoSerMelhorado(pontoSerMelhorado);
		request.setAttribute("pontosSerMelhorado", pontoSerMelhorado);
		RequestDispatcher rd = request.getRequestDispatcher("editarPontos.jsp");
		rd.forward(request, response);
	}
	
	protected void editaPontoSerMelhorado(HttpServletRequest request, HttpServletResponse response)	throws ServletException, IOException {
		pontoSerMelhorado.setId(request.getParameter("idEditaPontoSerMelhorado"));
		pontoSerMelhorado.setpontoSerMelhorado(request.getParameter("textAreaPontoSerMelhorado"));
		pontoSerMelhorado.setCor(request.getParameter("corBackGroundTextArea"));
		pontoSerMelhoradoDAO.editaPontoSerMelhorado(pontoSerMelhorado);
		response.sendRedirect("main");
	}
	
	protected void removerPontoSerMelhorado (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		pontoSerMelhorado.setId(id);
		pontoSerMelhoradoDAO.deletarPontoSerMelhorado(pontoSerMelhorado);
		response.sendRedirect("main");
	}
}
