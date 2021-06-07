package entities;

import java.util.Date;

public class HoraContratos {
	
	private Date data;
	private Double valurHora;
	private Integer horaTrabalhada;
	
	public HoraContratos(Date data, Double valurHora, Integer horaTrabalhada) {
		super();
		this.data = data;
		this.valurHora = valurHora;
		this.horaTrabalhada = horaTrabalhada;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Double getValurHora() {
		return valurHora;
	}

	public void setValurHora(Double valurHora) {
		this.valurHora = valurHora;
	}

	public Integer getHoraTrabalhada() {
		return horaTrabalhada;
	}

	public void setHoraTrabalhada(Integer horaTrabalhada) {
		this.horaTrabalhada = horaTrabalhada;
	}
	
	public Double totalValorDia() {
		return this.valurHora * this.horaTrabalhada;
	}
	

}
