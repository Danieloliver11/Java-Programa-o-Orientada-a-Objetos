package Service;

import java.util.Calendar;
import java.util.Date;

import Entity.Contrato;
import Entity.Prestacao;

public class PagamentoService {

	private TaxaService taxa;

	public PagamentoService(TaxaService taxa) { // inversao de dependencias 
		super();
		this.taxa = taxa;
	}

	public void processContrato(Contrato contrato, int parcelas) {

		double parcelasValor = contrato.getValorTotal() / parcelas;

		for (int n = 1; n <= parcelas; n++) {

			Date data = calData(contrato.getData(), n);

			Double jurosSimples = parcelasValor + taxa.juros(parcelasValor, n);
			Double jurosTotal = jurosSimples + taxa.taxaDePagamento(parcelasValor);

			contrato.addInstallment(new Prestacao(data, jurosTotal)); //
			
		}

	}

	private Date calData(Date data, int n) {

		Calendar cal = Calendar.getInstance();
		cal.setTime(data);
		cal.add(Calendar.MONTH, n);

		return cal.getTime();
	}

}
