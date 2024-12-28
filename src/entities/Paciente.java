package entities;

import java.util.Date;

public class Paciente {

	private Integer id;
	private String nome;
	private String cpf;
	private Date dataNascimento;
	
	public Paciente() {		
	}

	public Paciente(Integer id, String nome, String cpf, Date data) {
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.dataNascimento = data;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Date getData() {
		return dataNascimento;
	}

	public void setData(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	//metodos
	
	public void marcarConsulta() {
		
	}
	
	public void listarConsultas() {
		
	}
	
	public void cancelarConsulta() {
		
	}
}
