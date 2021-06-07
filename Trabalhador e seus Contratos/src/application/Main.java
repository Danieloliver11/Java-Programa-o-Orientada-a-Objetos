package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import entities.Departamento;
import entities.HoraContratos;
import entities.NivelTrabalhador;
import entities.Trabalhador;



public class Main {
	public static void main(String[] args) throws ParseException {
		
		SimpleDateFormat d_m_a = new SimpleDateFormat("dd/MM/yyyy");
		
		Scanner leia = new Scanner(System.in);
		
		
		System.out.println("Digite o nome do seu departamento.");
		String departamento = leia.next();
		
		System.out.println("Digite os dados do funcionario!");
		
		System.out.println("Digite o Nome: ");
		String nome = leia.next();
		
		System.out.println("Qual o nivel do funcionario? (JUNIOR/PLENO/SENIOR)");
		String level = leia.next().toUpperCase();
		
		System.out.println("Qual o salario base do funcionario?");
		double salario = leia.nextDouble();
		
		Trabalhador funcionario = new Trabalhador(nome, NivelTrabalhador.valueOf(level), salario, new Departamento(departamento));
		
		
		
		System.out.println("Quantos contratos o funcionario teve ?");
		int contrato = leia.nextInt();
		
		for(int x = 0; x < contrato; x++) {
			
			System.out.println("Entre com o contrato "+ (x + 1));
			
			System.out.println("Data do contrato: (dd/MM/yyyy)");
			Date dataContrato = d_m_a.parse(leia.next());
			
			System.out.println("Qual o valor por Hora?");
			double valorH = leia.nextDouble();
			
			System.out.println("Horas trabalhadas");
			int horasTrabalhada = leia.nextInt();
			
			HoraContratos contratos = new HoraContratos(dataContrato,valorH,horasTrabalhada);
			
			
			funcionario.addContrato(contratos);
			
		}
		
		System.out.println("Entre com o mês e o ano para calcular sua renda nessa data: (MM/yyyy)");
		String data = leia.next();
		
		int mes = Integer.parseInt(data.substring(0, 2));
		int ano = Integer.parseInt(data.substring(3));
		
		
		System.out.println("Nome: "+funcionario.getNome());
		System.out.println("Departamento: "+ funcionario.getDepartamento().getNomeDepart());
		System.out.println("Renda: "+mes+"/"+ano+": "+ funcionario.renda(mes, ano));
		
		
		
		
		
		
	}

}
