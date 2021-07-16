package EX20Empregado;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
	/*
	 * 
	 * Tv,900.00
		Mouse,50.00
		Tablet,350.50
		HD Case,80.90
		Computer,850.00
		Monitor,290.00

	Fazer um programa para ler os dados (nome, email e salário) de funcionários a partir de um arquivo em formato .csv.
	Em seguida mostrar, em ordem alfabética, o email dos funcionários cujo salário seja superior a um dado valor fornecido pelo usuário.
	Mostrar também a soma dos salários dos funcionários cujo nome começa com a letra 'M'.
	Veja exemplo na próxima página.
	
	
	*/

	public static void main(String[] args) {
		
		Scanner leia = new Scanner(System.in);
		
	String path = "/Users/danielmacedodeoliveira/ex20.txt";
	
	List<Funcionario> funcionarios = new ArrayList<>();
	
	
	try(BufferedReader arquivo = new BufferedReader(new FileReader(path))) {
		
		String linha = arquivo.readLine();
		
		while (linha != null) {
			
			String[] campos = linha.split(",");
			
			String nome = campos[0];
			String email= campos[1];
			Double preco = Double.parseDouble(campos[2]);
			
			funcionarios.add(new Funcionario(nome,email,preco));
			
			linha = arquivo.readLine();
			
		}
		
		System.out.println("Entre com salario desejado:");
		double salarioD= leia.nextDouble();
		
		Comparator<String> comp = (x,y) -> x.toUpperCase().compareTo(y.toUpperCase());
		
		List<String> emailAl = funcionarios.stream().filter(x -> x.getPreco() > salarioD).map(x -> x.getEmail()).sorted(comp).collect(Collectors.toList());
		
		emailAl.forEach(System.out::println);
		
		Double sunM =  funcionarios.stream().filter( x ->  x.getNome().toUpperCase().charAt(0) == 'M').map(x -> x.getPreco()).reduce(0.0, (x, y) -> x + y);
		
		System.out.println(sunM);
		
		
		/*
		 * 
		 * 
		 * Entre com salario desejado:
			2000,00
			anna@gmail.com
			bob@gmail.com
			maria@gmail.com
			4900.0
		 */
		
	
		
	} catch (Exception e) {
		// TODO: handle exception
	}
		

	}

}
