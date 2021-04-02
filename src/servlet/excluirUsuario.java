package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import banco_dados.conexaoBancoDados;
import banco_dados.usuarios;

public class excluirUsuario extends HttpServlet {

	@Override
	protected void doPost (HttpServletRequest request, HttpServletResponse response )
		throws ServletException, IOException {

		PrintWriter out;
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
				
				if (usuario.excluirRegistro(Integer.parseInt(request.getParameter("codigo_usuario")))) {
					out.println("<h2>Registro de usu�rio exclu�do com sucesso!</h2>");
					out.println("<br><br><br><br>");
					out.println("<a href='menu_usuarios.html'>Fechar</a>");
				} else 
					out.println("<h2>N�o foi poss�vel excluir o registro do usu�rio!</h2>");			
				
				conexao.fecharConexao();
				
			} else
				out.println("<h2>N�o foi poss�vel estabelecer conex�o com o banco de dados!</h2>");			
		} catch (Exception erro) {
			erro.printStackTrace();
			out.println("<h2>Erro do sistema: processo de exclus�o de usu�rio!</h2>");
		}
		
		out.println("<p class='RodapePagina'>FUMEC - Programa��o web</p>");
		out.println("</body>");
		out.println("</html>");
	}
}
