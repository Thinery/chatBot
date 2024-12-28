package application;

import java.util.Locale;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Bem vindo ao chatbot do SUS!");
		System.out.print("Informe o seu cpf: ");
		String cpf = sc.nextLine();
		
		
		System.out.println(validaCPF(cpf));
		
		
		sc.close();
	}

	public static boolean validaCPF(String cpf) {
		Integer primeiroDigito;
		Integer segundoDigito;
		int soma = 0, numero = 0, peso;
		
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
