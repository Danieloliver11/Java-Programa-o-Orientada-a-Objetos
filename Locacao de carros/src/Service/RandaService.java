package Service;

import entidades.CarAlugar;
import entidades.Fatura;

public class RandaService {

	private Double precoPorHora;
	private Double precoPorDia;

	private TaxService taxService;

	public RandaService(Double precoPorHora, Double precoPorDia, TaxService taxService) {
		super();
		this.precoPorHora = precoPorHora;
		this.precoPorDia = precoPorDia;
		this.taxService = taxService;
	}

	public Double getPrecoPorHora() {
		return precoPorHora;
	}

	public void setPrecoPorHora(Double precoPorHora) {
		this.precoPorHora = precoPorHora;
	}

	public Double getPrecoPorDia() {
		return precoPorDia;
	}

	public void setPrecoPorDia(Double precoPorDia) {
		this.precoPorDia = precoPorDia;
	}

	public TaxService getTaxService() {
		return taxService;
	}

	public void setTaxService(TaxService taxService) {
		this.taxService = taxService;
	}

	// pega as as horas ou os dias da diferenca de da retirada e devolucao do
	// veiculo.
	public void proceFatura(CarAlugar carAlugar) {

		// valor basico
		double pagamentoBasico;
		Long retirada = carAlugar.getRetirada().getTime();
		Long devolucao = carAlugar.getDevolucao().getTime();

		Double horas = (double) (devolucao - retirada) / 1000 / 60 / 60; // da o total de horas.

		if (horas <= 12.0) {
			// calucla o valor por hora
			pagamentoBasico = Math.ceil(horas) * precoPorHora; // Math.ceil arredonda para cima (horas)

		} else {

			// calcula o valor por dia
			pagamentoBasico = Math.ceil(horas / 24) * precoPorDia; // (horas / 24) para saber o valor da quantidade de
																	// dias
		}

		// leva para a interface
		double tax = taxService.tax(pagamentoBasico);

		carAlugar.setFatura(new Fatura(pagamentoBasico, tax));

	}

}
