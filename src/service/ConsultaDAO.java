package service;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import dataconection.DatabaseConnection;

public class ConsultaDAO {
	/*
	 * CRUD - CREATE - OK - 
	 * INSERT READ - OK -
	 * SELECT UPDATE - 
	 * UPDATE DELETE - DELETE - OK
	 */

	// metodo que cria uma consulta no banco de dados 'CREATE'
	public void save(Consulta consulta) {
		String sql = "INSERT INTO consulta (paciente_idpaciente, medico_idmedico, idconsulta, data, hora) VALUES (?,?,?,?,?)";

		Connection conn = null;

		PreparedStatement pstm = null;

		try {
			// criar uma conexao com o banco de dados
			conn = DatabaseConnection.getConnection();
			// preparedstatement que executa uma query
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			// adiciona os valores que são esperados pela query
			pstm.setInt(1, 1);
			pstm.setInt(2, 1);
			pstm.setInt(3, consulta.getId());
			// Converter LocalDate para java.sql.Date
			pstm.setDate(4, Date.valueOf(consulta.getData()));
			// Converter LocalTime (parte de LocalDateTime) para java.sql.Time
			pstm.setTime(5, Time.valueOf(consulta.getHora()));

			// executa a query
			pstm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// fechar as conexões
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	public static List<Consulta> getConsulta() {
		String sql = "SELECT * FROM consulta";
		List<Consulta> consultas = new ArrayList<Consulta>();

		Connection conn = null;
		PreparedStatement pstm = null;
		// classe que recupera os dados do banco! ***select***
		ResultSet rset = null;

		try {
			conn = DatabaseConnection.getConnection();

			pstm = (PreparedStatement) conn.prepareStatement(sql);

			rset = pstm.executeQuery();

			while (rset.next()) {

				Consulta consulta = new Consulta();

				// recupera o id
				consulta.setId(rset.getInt("idconsulta"));
				// recupera o id paciente
				consulta.setIdPaciente(rset.getInt("paciente_idpaciente"));
				// recupera o id medico
				consulta.setIdMedico(rset.getInt("medico_idmedico"));
				// recupera a data
				consulta.setData(rset.getDate("data").toLocalDate());
				// recupera a hora
				consulta.setHora(rset.getTime("hora").toLocalTime());

				consultas.add(consulta);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rset != null) {
					rset.close();
				}
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		return consultas;
	}
	
	public static void deleteByIdconsulta(int id) {
		String sql = "DELETE FROM consulta WHERE idconsulta = ?";
				
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			conn = DatabaseConnection.getConnection();
			pstm = conn.prepareStatement(sql);
			
			pstm.setInt(1, id);
			pstm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try{
				if(pstm!=null) {
					pstm.close();
				}
				if(conn!=null){
					conn.close();
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
		
	}
}}
