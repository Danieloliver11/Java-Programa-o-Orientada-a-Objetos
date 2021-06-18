package entidades;

public class Fatura {

	private Double pagamentoBasico;
	private Double taxa;

	public Fatura(Double pagamentoBasico, Double taxa) {
		super();
		this.pagamentoBasico = pagamentoBasico;
		this.taxa = taxa;
	}

	public Double getPagamentoBasico() {
		return pagamentoBasico;
	}

	public void setPagamentoBasico(Double pagamentoBasico) {
		this.pagamentoBasico = pagamentoBasico;
	}

	public Double getTaxa() {
		return taxa;
	}

	public void setTaxa(Double taxa) {
		this.taxa = taxa;
	}

	public Double totalPagamento() {

		return this.getPagamentoBasico() + this.getTaxa();
	}

}
