package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Date;

import dataconection.DatabaseConnection;
import entities.Medico;
import entities.Paciente;

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
			pstm.setInt(1, Paciente.getId());
			pstm.setInt(2, Medico.getId());
			pstm.setInt(3, Consulta.getId());
			pstm.setDate(4, new Date(Consulta.getDataHorario().getDate()));
			pstm.setDate(5, new Date(Consulta.getDataHorario().getTime()));
			
			//executa a query
			pstm.execute();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(pstm != null) {
				pstm.close();
			}
		}
	}
}
