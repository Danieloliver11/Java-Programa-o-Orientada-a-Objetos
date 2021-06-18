package entidades;

import java.util.Date;

public class CarAlugar {
	
	private Date retirada;
	private Date devolucao;
	
	private Veiculo veiculo;
	private Fatura fatura;
	
	public CarAlugar(Date retirada, Date devolucao, Veiculo veiculo) {
		super();
		this.retirada = retirada;
		this.devolucao = devolucao;
		this.veiculo = veiculo;
	}

	public Date getRetirada() {
		return retirada;
	}

	public void setRetirada(Date retirada) {
		this.retirada = retirada;
	}

	public Date getDevolucao() {
		return devolucao;
	}

	public void setDevolucao(Date devolucao) {
		this.devolucao = devolucao;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	public Fatura getFatura() {
		return fatura;
	}

	public void setFatura(Fatura fatura) {
		this.fatura = fatura;
	}
	
	
	
	

}
