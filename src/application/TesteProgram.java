package application;

import java.time.LocalDate;
import java.time.LocalTime;

import service.Consulta;
import service.ConsultaDAO;

public class TesteProgram {

	public static void main(String[] args) {
		
		ConsultaDAO consultadao = new ConsultaDAO();
		
		Consulta consulta = new Consulta();
		consulta.setIdMedico(1);
		consulta.setIdPaciente(1);
		consulta.setId(1);
		consulta.setData(LocalDate.of(2025, 1, 7));
		consulta.setHora(LocalTime.of(14, 30));
		
		consultadao.save(consulta);

	}

}
