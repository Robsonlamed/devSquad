package controller;

import java.io.IOException;
import java.util.ArrayList;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import bean.PontoPositivo;
import bean.PontoSerMelhorado;
import bean.Quadro;
import dao.PontoPositivoDAO;
import dao.PontoSerMelhoradoDAO;
import dao.QuadroDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/main", "/report", "/limparQuadros", "/logout"})
public class GenericController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	PontoSerMelhorado pontoSerMelhorado = new PontoSerMelhorado();
	PontoSerMelhoradoDAO pontoSerMelhoradoDAO = new PontoSerMelhoradoDAO();
	
	PontoPositivoDAO pontoPositivoDAO = new PontoPositivoDAO();
	PontoPositivo pontoPositivo = new PontoPositivo();
	
	Quadro quadro = new Quadro();
	QuadroDAO quadroDAO = new QuadroDAO();
	
	public GenericController() {
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String acao = request.getServletPath();
		if(acao.equals("/main")) {
			listarPontos(request, response);
		} else if (acao.equals("/report")) {
			gerarRelatorio(request, response);
		} else if (acao.equals("/limparQuadros")) {
			limparQuadros(request, response);
		} else if (acao.equals("/logout")) {
			logout(request, response);
		}else {
			response.sendRedirect("login.jsp");
		}
	}
	
	protected void listarPontos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<PontoPositivo> listaPositivos = pontoPositivoDAO.listarPontoPositivo();
		ArrayList<PontoSerMelhorado> listaSerMelhorados = pontoSerMelhoradoDAO.listarPontoSerMelhorado();

		quadro.setQuadroId("1");
		quadroDAO.listarQuadro(quadro);
		request.setAttribute("pontosPositivo", listaPositivos);
		request.setAttribute("pontosSerMelhorado", listaSerMelhorados);
		request.getServletContext().setAttribute("quadros", quadro.getQuadro());
		RequestDispatcher rd = request.getRequestDispatcher("feedback.jsp");
		rd.forward(request, response);
	}
	
	protected void limparQuadros(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		pontoPositivoDAO.limpaQuadroPontoPositivo();
		pontoSerMelhoradoDAO.limpaQuadroPontoSerMelhorado();
		quadroDAO.deletarQuadro();
		response.sendRedirect("main");
	}
	
	protected void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		pontoPositivoDAO.limpaQuadroPontoPositivo();
		pontoSerMelhoradoDAO.limpaQuadroPontoSerMelhorado();
		quadroDAO.deletarQuadro();
		response.sendRedirect("login.jsp");
	}
	
	protected void gerarRelatorio(HttpServletRequest request, HttpServletResponse response)	throws ServletException, IOException {
		Document documento = new Document();
		String titulo = (request.getParameter("nomeRelatorio"));
		try {
			response.setContentType("apllication/pdf");
			response.addHeader("Content-Disposition", "inline; filename=" + "pontos-a-serem-melhorados.pdf");
			PdfWriter.getInstance(documento, response.getOutputStream());
			
			documento.open();
			documento.add(new Paragraph(titulo + " : "));
			documento.add(new Paragraph(" "));
			PdfPTable lista1 = new PdfPTable(1);
			PdfPTable lista2 = new PdfPTable(1);
			PdfPTable lista3 = new PdfPTable(1);
			PdfPCell col1 = new PdfPCell(new Paragraph("Pontos positivos:"));
			PdfPCell col2 = new PdfPCell(new Paragraph(" "));
			PdfPCell col3 = new PdfPCell(new Paragraph("Pontos a serem melhorados:"));
			lista1.addCell(col1);
			lista2.addCell(col2);
			lista2.addCell(col3);
			lista2.addCell("");			
			ArrayList<PontoPositivo> listaPositivos = pontoPositivoDAO.listarPontoPositivo();
			ArrayList<PontoSerMelhorado> listaSerMelhorados = pontoSerMelhoradoDAO.listarPontoSerMelhorado();
			for (int i = 0; i < listaPositivos.size(); i++) {
					lista1.addCell(listaPositivos.get(i).getPontoPositivo());
			}
			for (int i = 0; i < listaSerMelhorados.size(); i++) {
				lista3.addCell(listaSerMelhorados.get(i).getpontoSerMelhorado());
			}
			documento.add(lista1);
			documento.add(lista2);
			documento.add(lista3);
			documento.close();
		} catch (Exception e) {
			System.out.println(e);
			documento.close();
		}
	}
}
