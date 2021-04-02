package banco_dados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conexaoBancoDados {

	Connection conBanco;
	
	public boolean abrirConexado() {
		String url = "jdbc:mysql://localhost/web2?user=aluno&password=123";		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conBanco = DriverManager.getConnection(url);
			return true;
		} catch (Exception erro) {
			erro.printStackTrace();
			return false;
		}
	}
	
	public boolean fecharConexao() {
		try {
			conBanco.close();
			return true;
		} catch (SQLException erro) {
			erro.printStackTrace();
			return false;
		}
	}
	
	public Connection obterConexao() {
		return conBanco;
	}
}