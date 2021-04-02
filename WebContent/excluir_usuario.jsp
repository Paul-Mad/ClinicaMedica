<%@page contentType="text/html;" pageEncoding="utf-8"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="model.c_usuarios"%>
<jsp:useBean id="conexao" scope="page" class="banco_dados.conexaoBancoDados"/>
<jsp:useBean id="usuario" scope="page" class="banco_dados.usuarios"/>

<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>SGC - Versão 1.0</title>
		<link href="css/clinica_medica.css" rel="stylesheet" type="text/css">
	</head>

	<body class="FundoPagina">
		<%
			ResultSet rsRegistro;
			boolean blnConectado;
			
			c_usuarios Usuario = new c_usuarios();
			int intCodigoUsuario = Integer.parseInt(request.getParameter("codigo_usuario"));
			blnConectado = false;
			
			if (conexao.abrirConexado()){
				usuario.configurarConexao(conexao.obterConexao());
				
				rsRegistro = usuario.lerRegistro(intCodigoUsuario);
				
				Usuario.setIdUsuario(rsRegistro.getString("Identificacao_Usuario")); 
				Usuario.setSenhaAcesso(rsRegistro.getString("Senha_Acesso")); 
				Usuario.setCadastroFuncionario(rsRegistro.getString("Cadastro_Funcionario")); 
				Usuario.setCadastroUsuario(rsRegistro.getString("Cadastro_Usuario")); 
				Usuario.setCadastroPaciente(rsRegistro.getString("Cadastro_Paciente")); 
				Usuario.setCadastroEspecialidade(rsRegistro.getString("Cadastro_Especialidade")); 
				Usuario.setCadastroMedico(rsRegistro.getString("Cadastro_Medico")); 
				Usuario.setCadastroConvenio(rsRegistro.getString("Cadastro_Convenio")); 
				Usuario.setAgendamentoConsulta(rsRegistro.getString("Agendamento_Consulta")); 
				Usuario.setCancelamentoConsulta(rsRegistro.getString("Cancelamento_Consulta")); 
				Usuario.setModuloAdiministrativo(rsRegistro.getString("Modulo_Administrativo")); 
				Usuario.setModuloAgendamento(rsRegistro.getString("Modulo_Agendamento")); 
				Usuario.setModuloAtendimento(rsRegistro.getString("Modulo_Atendimento")); 
				Usuario.setCodigoUsuario(intCodigoUsuario); 
				
				conexao.fecharConexao();
				
				blnConectado = true;				
			} else {
				out.println("<p>Falha na conexão com o banco de dados!</p>");
			} 
		%>
			
		<% if (blnConectado) { %>  
			<p class="TituloAplicacao">SGC - Sistema de Gestão de Clínicas 1.0</p>
			<p class="TituloPagina">Cadastro de Usuários - Inserção</p>
	
			<form name="formExcluiUsuario" method="post" action="excluirUsuario" target="_parent">
			<p>Nome do usuário: <%=Usuario.getIdUsuario()%></p>
			<br>
			<p>Módulo Administrativo: <%=Usuario.getModuloAdiministrativo()%></p>
			<p>&nbsp;&nbsp;&nbsp;&nbsp; Cadastro de Funcionários: <%=Usuario.getCadastroFuncionario()%></p>
			<p>&nbsp;&nbsp;&nbsp;&nbsp; Cadastro de Usuários: <%=Usuario.getCadastroUsuario()%></p>
			<p>&nbsp;&nbsp;&nbsp;&nbsp; Cadastro de Especialidade: <%=Usuario.getCadastroEspecialidade()%></p>
			<p>&nbsp;&nbsp;&nbsp;&nbsp; Cadastro de Médicos: <%=Usuario.getCadastroMedico()%></p>
			<p>&nbsp;&nbsp;&nbsp;&nbsp; Cadastro de Convênios: <%=Usuario.getCadastroConvenio()%></p>
			<p>Módulo de agendamento: <%=Usuario.getModuloAgendamento()%></p>
			<p>&nbsp;&nbsp;&nbsp;&nbsp; Cadastro de Pacientes: <%=Usuario.getCadastroPaciente()%></p>
			<p>&nbsp;&nbsp;&nbsp;&nbsp; Agendamento de Consulta: <%=Usuario.getAgendamentoConsulta()%></p>
			<p>&nbsp;&nbsp;&nbsp;&nbsp; Cancelamento de Consulta: <%=Usuario.getCancelamentoConsulta()%></p>
			<p>Módulo de atendimento médico: <%=Usuario.getModuloAtendimento()%></p>

			<input type="hidden" name="codigo_usuario" value="<%=intCodigoUsuario%>">
			<br>			
			<p><p><input type="submit" name="btnExcluir" value="Excluir"/>			
			<span class="LinkVoltar"><a href="javascript:history.back()">[Voltar]</a></span>
			</p>
			</form>

			<p class="RodapePagina">FUMEC - Programação web</p>
		<% } %> 
			
	</body>
</html>