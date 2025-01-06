package service;

import java.util.Date;

import entities.Medico;
import entities.Paciente;

public class Consulta {
	private Integer id;
	private Date dataHorario;
	private String status;
	private Paciente paciente;
	private Medico medico;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Date getDataHorario() {
		return dataHorario;
	}
	public void setDataHorario(Date dataHorario) {
		this.dataHorario = dataHorario;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Paciente getPaciente() {
		return paciente;
	}
	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
	public Medico getMedico() {
		return medico;
	}
	public void setMedico(Medico medico) {
		this.medico = medico;
	}
	
	
	
}
