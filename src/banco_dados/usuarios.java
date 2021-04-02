package banco_dados;

import java.sql.*;

import model.c_usuarios;

public class usuarios {

	private Connection conBanco;
	private PreparedStatement psComando;
	private ResultSet rsRegistros;
	
	public void configurarConexao(Connection conBanco) {
		this.conBanco = conBanco;
	}
	
	public boolean inserirRegistro(c_usuarios usuario) {
		
		String strComandoSQL;
		
		try{
			strComandoSQL = "INSERT INTO usuarios (Identificacao_Usuario, Senha_Acesso, " +
							"Cadastro_Funcionario, Cadastro_Usuario, Cadastro_Paciente, " +
							"Cadastro_Especialidade, Cadastro_Medico, Cadastro_Convenio, " +
							"Agendamento_Consulta, Cancelamento_Consulta, Modulo_Administrativo, " +
							"Modulo_Agendamento, Modulo_Atendimento) " +
							"VALUES " +
							"('" + usuario.getIdUsuario() + "', '" + usuario.getSenhaAcesso() + "', '" +
							usuario.getCadastroFuncionario() + "', '" + usuario.getCadastroUsuario() + "', '" +
							usuario.getCadastroPaciente() + "', '" + usuario.getCadastroEspecialidade() + "', '" +
							usuario.getCadastroMedico() + "', '" + usuario.getCadastroConvenio() + "', '" +
							usuario.getAgendamentoConsulta() + "', '" + usuario.getCancelamentoConsulta() + "', '" +
							usuario.getModuloAdiministrativo() + "', '" + usuario.getModuloAgendamento() + "', '" +
							usuario.getModuloAtendimento() + "')";
			
			psComando = conBanco.prepareStatement(strComandoSQL);
			psComando.executeUpdate();
			
			return true;
					
		} catch (Exception erro) {
			erro.printStackTrace();
			return false;
		}
	}
	
	public int LocalizarRegistro(String strUsuario) {
		
		int intCodigoUsuario = 0;
		String strComandoSQL;
		
		try{
			strComandoSQL = "SELECT Codigo_Usuario FROM usuarios " +
						    "WHERE Identificacao_Usuario = '" + strUsuario + "'";
			
			psComando = conBanco.prepareStatement(strComandoSQL);
			rsRegistros = psComando.executeQuery();
			rsRegistros.next();
			
			intCodigoUsuario = rsRegistros.getInt("Codigo_Usuario");
			
		} catch (Exception erro) {
			erro.printStackTrace();
		}
		
		return intCodigoUsuario;
	}
	
	public ResultSet lerRegistro(int intCodigoUsuario) {
		
		String strComandoSQL;
		
		try {
			
			strComandoSQL = "SELECT * FROM usuarios WHERE Codigo_Usuario = " + intCodigoUsuario;
			psComando = conBanco.prepareStatement(strComandoSQL);
			rsRegistros = psComando.executeQuery();
			rsRegistros.next();
			
			return rsRegistros;
		} catch (Exception erro) {
			erro.printStackTrace();
			return null;
		}
	}
	
	public boolean alterarRegistro(c_usuarios usuario) {
		
		String strComandoSQL;
		
		try {
			
			strComandoSQL = "UPDATE usuarios SET Identificacao_Usuario = '" + usuario.getIdUsuario() + 
						   "', Senha_Acesso = '" + usuario.getSenhaAcesso() +
						   "', Cadastro_Funcionario = '" + usuario.getCadastroFuncionario() +
						   "', Cadastro_Usuario = '" + usuario.getCadastroUsuario() +
						   "', Cadastro_Paciente = '" + usuario.getCadastroPaciente() +
						   "', Cadastro_Especialidade = '" + usuario.getCadastroEspecialidade() +
						   "', Cadastro_Medico = '" + usuario.getCadastroMedico() +
						   "', Cadastro_Convenio = '" + usuario.getCadastroConvenio() +
						   "', Agendamento_Consulta = '" + usuario.getAgendamentoConsulta() +
						   "', Cancelamento_Consulta = '" + usuario.getCancelamentoConsulta() +
						   "', Modulo_Administrativo = '" + usuario.getModuloAdiministrativo() +
						   "', Modulo_Agendamento = '" + usuario.getModuloAgendamento() +
						   "', Modulo_Atendimento = '" + usuario.getModuloAtendimento() +
						   "' WHERE Codigo_Usuario = " + usuario.getCodigoUsuario();
			
			psComando = conBanco.prepareStatement(strComandoSQL);
			psComando.executeUpdate();
			
			return true;
			
		} catch (Exception erro) {
			erro.printStackTrace();
			return false;
		}
	}
	
	public boolean excluirRegistro(int intCodigoUsuario) {
		
		String strComandoSQL;
		
		try {
			strComandoSQL = "DELETE FROM usuarios WHERE Codigo_Usuario = " + intCodigoUsuario;
			psComando = conBanco.prepareStatement(strComandoSQL);
			psComando.executeUpdate();
			
			return true;
			
		} catch (Exception erro) {
			erro.printStackTrace();
			return false;
		}
		
	}
	
}
