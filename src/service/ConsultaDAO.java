package service;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.Time;

import dataconection.DatabaseConnection;

public class ConsultaDAO {
	
	public void save(Consulta consulta) {
		String sql = "INSERT INTO consulta (paciente_idpaciente, medico_idmedico, idconsulta, data, hora) VALUES (?,?,?,?,?)";
		
		Connection conn = null;
		
		PreparedStatement pstm = null;
		
		try {
			//criar uma conexao com o banco de dados
			conn = DatabaseConnection.getConnection();
			//preparedstatement que executa uma query
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			//adiciona os valores que são esperados pela query
			pstm.setInt(1, 1);
			pstm.setInt(2, 1);
			pstm.setInt(3, Consulta.getId());
			// Converter LocalDate para java.sql.Date
            pstm.setDate(4, Date.valueOf(consulta.getData()));
            // Converter LocalTime (parte de LocalDateTime) para java.sql.Time
            pstm.setTime(5, Time.valueOf(consulta.getHora()));
            
			//executa a query
			pstm.execute();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			//fechar as conexões
			try {
				if(pstm != null) {
					pstm.close();
				}
				if(conn!=null) {
					conn.close();
				}
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
}
