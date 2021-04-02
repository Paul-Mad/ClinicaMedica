package model;

public class c_usuarios {

	private int codigoUsuario;
	private String idUsuario, 
				   senhaAcesso,
				   cadastroFuncionario,
				   cadastroUsuario,
				   cadastroPaciente,
				   cadastroEspecialidade,
				   cadastroMedico,
				   cadastroConvenio,
				   agendamentoConsulta,
				   cancelamentoConsulta,
				   moduloAdiministrativo,
				   moduloAgendamento,
				   moduloAtendimento;

	public c_usuarios() {
		super();
		this.codigoUsuario = 0;
		this.idUsuario = "";
		this.senhaAcesso = "";
		this.cadastroFuncionario = "";
		this.cadastroUsuario = "";
		this.cadastroPaciente = "";
		this.cadastroEspecialidade = "";
		this.cadastroMedico = "";
		this.cadastroConvenio = "";
		this.agendamentoConsulta = "";
		this.cancelamentoConsulta = "";
		this.moduloAdiministrativo = "";
		this.moduloAgendamento = "";
		this.moduloAtendimento = "";
	}
	
	public c_usuarios(String idUsuario, String senhaAcesso, 
			String cadastroFuncionario,	String cadastroUsuario, 
			String cadastroPaciente, String cadastroEspecialidade, 
			String cadastroMedico, String cadastroConvenio, 
			String agendamentoConsulta, String cancelamentoConsulta,
			String moduloAdiministrativo, String moduloAgendamento, 
			String moduloAtendimento, int codigoUsuario) {
		super();
		this.idUsuario = idUsuario;
		this.senhaAcesso = senhaAcesso;
		this.cadastroFuncionario = cadastroFuncionario;
		this.cadastroUsuario = cadastroUsuario;
		this.cadastroPaciente = cadastroPaciente;
		this.cadastroEspecialidade = cadastroEspecialidade;
		this.cadastroMedico = cadastroMedico;
		this.cadastroConvenio = cadastroConvenio;
		this.agendamentoConsulta = agendamentoConsulta;
		this.cancelamentoConsulta = cancelamentoConsulta;
		this.moduloAdiministrativo = moduloAdiministrativo;
		this.moduloAgendamento = moduloAgendamento;
		this.moduloAtendimento = moduloAtendimento;
		this.codigoUsuario = codigoUsuario;
	}

	public int getCodigoUsuario() {
		return codigoUsuario;
	}

	public void setCodigoUsuario(int codigoUsuario) {
		this.codigoUsuario = codigoUsuario;
	}

	public String getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getSenhaAcesso() {
		return senhaAcesso;
	}

	public void setSenhaAcesso(String senhaAcesso) {
		this.senhaAcesso = senhaAcesso;
	}

	public String getCadastroFuncionario() {
		return cadastroFuncionario;
	}

	public void setCadastroFuncionario(String cadastroFuncionario) {
		this.cadastroFuncionario = cadastroFuncionario;
	}

	public String getCadastroUsuario() {
		return cadastroUsuario;
	}

	public void setCadastroUsuario(String cadastroUsuario) {
		this.cadastroUsuario = cadastroUsuario;
	}

	public String getCadastroPaciente() {
		return cadastroPaciente;
	}

	public void setCadastroPaciente(String cadastroPaciente) {
		this.cadastroPaciente = cadastroPaciente;
	}

	public String getCadastroEspecialidade() {
		return cadastroEspecialidade;
	}

	public void setCadastroEspecialidade(String cadastroEspecialidade) {
		this.cadastroEspecialidade = cadastroEspecialidade;
	}

	public String getCadastroMedico() {
		return cadastroMedico;
	}

	public void setCadastroMedico(String cadastroMedico) {
		this.cadastroMedico = cadastroMedico;
	}

	public String getCadastroConvenio() {
		return cadastroConvenio;
	}

	public void setCadastroConvenio(String cadastroConvenio) {
		this.cadastroConvenio = cadastroConvenio;
	}

	public String getAgendamentoConsulta() {
		return agendamentoConsulta;
	}

	public void setAgendamentoConsulta(String agendamentoConsulta) {
		this.agendamentoConsulta = agendamentoConsulta;
	}

	public String getCancelamentoConsulta() {
		return cancelamentoConsulta;
	}

	public void setCancelamentoConsulta(String cancelamentoConsulta) {
		this.cancelamentoConsulta = cancelamentoConsulta;
	}

	public String getModuloAdiministrativo() {
		return moduloAdiministrativo;
	}

	public void setModuloAdiministrativo(String moduloAdiministrativo) {
		this.moduloAdiministrativo = moduloAdiministrativo;
	}

	public String getModuloAgendamento() {
		return moduloAgendamento;
	}

	public void setModuloAgendamento(String moduloAgendamento) {
		this.moduloAgendamento = moduloAgendamento;
	}

	public String getModuloAtendimento() {
		return moduloAtendimento;
	}

	public void setModuloAtendimento(String moduloAtendimento) {
		this.moduloAtendimento = moduloAtendimento;
	}

}
