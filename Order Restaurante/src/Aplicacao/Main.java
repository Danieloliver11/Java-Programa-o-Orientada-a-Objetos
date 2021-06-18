package Aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Scanner;

import Entidade.Cliente;
import Entidade.Order;
import Entidade.OrderItem;
import Entidade.Produto;
import Entidade.StatusOrder;

public class Main {

	public static void main(String[] args) throws ParseException {
		
		LocalDate ldNow = LocalDate.now();
		 
		Scanner leia = new Scanner(System.in);
		SimpleDateFormat dma = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("Nome: ");
		String nome = leia.next();
		
		System.out.println("Email: ");
		String email = leia.next();
		
		System.out.println("Data de nascimento (DD/MM/YYYY): ");
		Date nascimento = dma.parse(leia.next());
		
	
		Cliente cliente = new Cliente(nome,email,nascimento);
		
		
		
		
		System.out.println("Quantos itens essa ordem tem?");
		int numero = leia.nextInt();
		
		Order ordem = new Order(ldNow, StatusOrder.PROCESSANDO, cliente);
		
		for(int x = 0; x < numero; x++) {
			
			System.out.println("Nome do produto :");
			String nomeP = leia.next();
			
			System.out.println("Preço do produto");
			double preco = leia.nextDouble();
			
			System.out.println("Quantidade do produto");
			int quant = leia.nextInt();
			
			OrderItem item = new  OrderItem(quant,preco, new Produto(nomeP, preco));
			
			ordem.addItens(item);

			
		}
		
		System.out.println(ordem.toString());
		System.out.println();
		
	}

}
