package dataconection;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
	//caminho do banco de dados
	private static final String URL = "jdbc:mysql://localhost:3306/dbconsulta";
    //nome do usuario mysql
	private static final String USER = "root";
	//senha do banco
    private static final String PASSWORD = "1234";
    
    //conecção com o banco de dados
    public static Connection getConnection() throws Exception{
	        
    		//faz com que a classe seja carregada pela JVM
	    	Class.forName("com.mysql.jdbc.Driver");
	    	//cria conexão com banco de dados
	    	Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
	    	
	    	return connection;
        }
    
}
