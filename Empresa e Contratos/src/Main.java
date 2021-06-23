import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import Entity.Contrato;
import Entity.Prestacao;
import Service.PagamentoService;
import Service.PaypalService;

public class Main {

	public static void main(String[] args) throws ParseException {
		

		Scanner leia = new Scanner(System.in);
		
		SimpleDateFormat dma = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("Numero ");
		int numero = leia.nextInt();
		
		System.out.println("Data (dd/MM/yyyy):");
		Date data = dma.parse(leia.next());
		
		System.out.println("Valor do contrato: ");
		double valor = leia.nextDouble();
		
		
		
		
		Contrato contrato = new Contrato(numero, data, valor);
		
		System.out.println("Digite o total de parcelas ");
		int parcelas = leia.nextInt();
		
		PagamentoService pagamento = new PagamentoService(new PaypalService()); // inversao de controle
		
		pagamento.processContrato(contrato, parcelas);
		
		
		for(Prestacao x: contrato.getPrestacao()) {
			
			System.out.println(x.toString());
		}
		
		leia.close();
	}

}
