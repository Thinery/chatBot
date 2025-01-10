package application;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import service.Consulta;
import service.ConsultaDAO;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
				
		System.out.println("Bem vindo ao chatbot do SUS!");
		System.out.print("Informe o seu cpf: ");	
		
		//faz a validação do cpf
		boolean result = false;
		while (result != true) {
			String cpf = sc.nextLine();
			if(validaCpf(cpf) == true) {
				break;
			} else {
				System.out.println("Esse não é um cpf valido, tente novamente...");
				System.out.print("cpf: ");
			}
		}
		
		System.out.println("O que deseja? \n1.Marcar consulta \n2.Ver Consultas marcadas \n3.Desmarcar consultas");
		int opcao = 0;
		while(opcao  > 3 || opcao < 1) {
			opcao = sc.nextInt();
			if(opcao  > 3 || opcao < 1) {
				System.out.println("Valor invalido, digite novamente...");
			}
		}
		//codigo que marca a consulta
		if(opcao==1) {
			int idconsulta = geraID();
			//vai ser implementado futuramente medico de cada posto de saude!
			System.out.println("Digite a area do posto de saúde que deseja marcar consulta: \n1.Zona Norte \n2.Zona Sul \n3.Zona Leste \n4.Zona Oeste");
			int zona = 5;
			while (zona > 4 || zona < 1) {
				zona = sc.nextInt();
				if(zona > 4 || zona < 1) {
					System.out.println("Zona invalida, digite novamente...");
				}
			}
			System.out.println("Medicos disponiveis: ");
			
			
			System.out.println("Escolha um dos dias disponiveis para marcar a consulta: ano-mes-dia ");
			sc.nextLine();
			String dataInput = sc.nextLine();
			System.out.println("Escolha um dos horarios disponiveis para marcar a consulta: hora-minuto:");
			String horaInput = sc.nextLine();
			
			
			try {
	            // Converte a data e o horário para os formatos esperados
	            LocalDate data = LocalDate.parse(dataInput, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
	            LocalTime hora = LocalTime.parse(horaInput, DateTimeFormatter.ofPattern("HH:mm"));

	            // Cria uma nova consulta e define os valores
	            ConsultaDAO consultadao = new ConsultaDAO();
	            Consulta consulta = new Consulta();
	            consulta.setIdMedico(1); // Exemplo de ID fixo porque só tem um paciente cadastrado por enquanto
	            consulta.setIdPaciente(1); // Exemplo de ID fixo porque só tem um medico cadastrado por enquanto
	            consulta.setId(idconsulta); // id gerado pela funçao
	            consulta.setData(data);
	            consulta.setHora(hora);

	            consultadao.save(consulta);

	            System.out.println("Consulta registrada com sucesso!");
	            System.out.println("Código da consulta: "+idconsulta);
	        } catch (Exception e) {
	            System.out.println("Erro ao processar a data ou horário. Verifique o formato inserido.");
	        }
		}
		
		//codigo que mostra a consulta pro usuario
		if(opcao==2) {
			for(Consulta c : ConsultaDAO.getConsulta()) {
				System.out.println("--------------------");
				System.out.println("Consulta: "+c.getId());
				System.out.println("Paciente: "+c.getIdPaciente());
				System.out.println("Medico: "+c.getIdMedico());
				System.out.println("Data: "+c.getData()+" Horario: "+c.getHora());
				System.out.println("--------------------");
				
			}
		}
		
		sc.close();
	}

	public static int geraID() {
		//gera um numero entre 1 e 10
		int ale = (int) (Math.random()*10);
		//gera um numero entre 1 a 1000 e multiplica pelo "ale"
		int aleID = (int) (Math.random()*1000)*ale;
		return aleID;
	}
	
	public static boolean validaCpf(String cpf) {
		Integer primeiroDigito;
		Integer segundoDigito;
		int soma = 0, numero = 0, peso;
		
		//verifica se o tamanho do cpf condiz com um cpf verdadeiro
		if(cpf.length()>14 || cpf.length()<11) {
			return false;
		}
		
		//remove todos caracteres nao numericos
		cpf = cpf.replaceAll("\\D", "");	
		
		//calcula o primeiro digito
		peso = 10;
		for(int i = 0; i<9; i++) {
			// -'0' importante pra converter o numerico correspondente
			numero = cpf.charAt(i)-'0';
			soma += numero * peso;
			peso--;
		}
		soma = soma%11;
		if(soma<2) {
			primeiroDigito = 0;
		}else {
			primeiroDigito = 11-soma;
		}
		
		//calcula o segundo digito
		soma = 0;
		peso = 11;
		for(int i = 0; i<10; i++) {
			numero = cpf.charAt(i)-'0';
			soma += numero * peso;
			peso--;
		}
		soma = soma%11;
		if(soma<2) {
			segundoDigito = 0;
		}else {
			segundoDigito = 11-soma;
		}
		
		if(cpf.charAt(9) - '0' == primeiroDigito && cpf.charAt(10) - '0' == segundoDigito) {
			return true;
		}
		else {
			return false;
		}
	}
	
}
