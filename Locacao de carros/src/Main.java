import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import Service.BrasilTaxaService;
import Service.RandaService;
import entidades.CarAlugar;
import entidades.Veiculo;
/*
 * Problema exemplo
Uma locadora brasileira de carros cobra um valor por hora para locações de até 12 horas. Porém, 
se a duração da locação ultrapassar 12 horas, a locação será cobrada com base em um valor diário. Além do valor da locação, 
é acrescido no preço o valor do imposto conforme regras do país que, no caso do Brasil, é 20% para valores até 100.00, 
ou 15% para valores acima de 100.00. Fazer um programa que lê os dados da locação (modelo do carro, instante inicial e final da locação), 
bem como o valor por hora e o valor diário de locação. O programa deve então gerar a nota de pagamento (contendo valor da locação, 
valor do imposto e valor total do pagamento) e informar os dados na tela. Veja os exemplos.*/

public class Main {

	public static void main(String[] args) throws ParseException {

		Scanner leia = new Scanner(System.in);
		SimpleDateFormat dma = new SimpleDateFormat("dd/MM/yyyy hh:mm");

		System.out.println("Insira os dados de aluguel\n");

		System.out.println("Qual o modelo do Carro");
		String nomeCar = leia.next();

		leia.nextLine();
		System.out.println("Digite a data da retirada do veiculo. (dd/MM/yyyy HH:mm)");
		Date saidaData = dma.parse(leia.nextLine());

		leia.nextLine();
		System.out.println("Digite a data da devolução do veiculo. (dd/MM/yyyy HH:mm)");
		Date voltaData = dma.parse(leia.nextLine());

		CarAlugar carro = new CarAlugar(saidaData, voltaData, new Veiculo(nomeCar));

		System.out.println("Entre com o preço por hora");
		Double precoH = leia.nextDouble();

		System.out.println("Entre com o preço por dia");
		Double precoD = leia.nextDouble();

		RandaService renda = new RandaService(precoH, precoD, new BrasilTaxaService());

		renda.proceFatura(carro);

		System.out.println("Fatura");

		System.out.println("Pagamento basico: " + carro.getFatura().getPagamentoBasico());
		System.out.println("Taxa: " + carro.getFatura().getTaxa());
		System.out.println("Total do pagamento: " + carro.getFatura().totalPagamento());

		leia.close();

	}

}
