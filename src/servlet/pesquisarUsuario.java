package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import banco_dados.conexaoBancoDados;
import banco_dados.usuarios;

public class pesquisarUsuario extends HttpServlet {

	@Override
	protected void doPost (HttpServletRequest request, HttpServletResponse response )
		throws ServletException, IOException {
		
		ResultSet rsRegistro;
		PrintWriter out;
		
		String strUsuario;
		int intCodigoUsuario;

		strUsuario = request.getParameter("txtUsuario");
		
		response.setContentType("text/html;charset=UTF-8");
		out = response.getWriter();
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta http-equiv='Content-Type' content='text/html; charset=utf-8' />");
		out.println("<title>SGC - Vers�o 1.0</title>");
		out.println("<link href='css/clinica_medica.css' rel='stylesheet' type='text/css' />");
		out.println("</head>");
		out.println("<body class='FundoPagina'>");
		out.println("<p class='TituloAplicacao'>SGC - Sistema de Gest�o de Cl�nicas 1.0</p>");
		out.println("<p class='TituloPagina'>Cadastro de Usu�rios</p>");
		
		try {
			conexaoBancoDados conexao = new conexaoBancoDados();
			usuarios usuario = new usuarios();
						
			if (conexao.abrirConexado()) {
				
				usuario.configurarConexao(conexao.obterConexao());
				
				intCodigoUsuario =  usuario.LocalizarRegistro(strUsuario.toUpperCase());
				
				if (intCodigoUsuario != 0) {
					
					rsRegistro = usuario.lerRegistro(intCodigoUsuario);
					out.println("Identifica��o do Usu�rio: " + rsRegistro.getString("Identificacao_Usuario") +"<br>");
					out.println("<br><br>");
					out.println("<a href='editar_usuario.jsp?codigo_usuario=" + intCodigoUsuario + "'>[Editar]</a>" +
								"<a href='excluir_usuario.jsp?codigo_usuario=" + intCodigoUsuario + "'>[Excluir]</a>");
					out.println("<span class='LinkVoltar'><a href='javascript:history.back()'>[Voltar]</a></span>");
				} else {
					out.println("<h2>Usu�rio n�o encontrado!</h2>");
					out.println("<br><br><br>");
					out.println("<span class='LinkVoltar'><a href='javascript:history.back()'>[Voltar]</a></span>");
				}
				conexao.fecharConexao();
			} else
				out.println("<h2>N�o foi poss�vel estabelecer conex�o com o banco de dados!</h2>");			
		} catch (Exception erro) {
			erro.printStackTrace();
			out.println("<h2>Erro do sistema: processo de cadastro de usu�rio!</h2>");
		}
		
		out.println("<p class='RodapePagina'>FUMEC - Programa��o web</p>");
		out.println("</body>");
		out.println("</html>");
	}
}
