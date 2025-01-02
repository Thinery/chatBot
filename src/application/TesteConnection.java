package application;

import java.sql.Connection;
import dataconection.DatabaseConnection;

public class TesteConnection {
	public static void main(String[] args) {
        Connection conn = DatabaseConnection.getConnection();
        if (conn != null) {
            System.out.println("Conexão realizada com sucesso!");
            try {
                conn.close(); // Fecha a conexão após o teste
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Falha ao conectar ao banco de dados!");
        }
    }
}
