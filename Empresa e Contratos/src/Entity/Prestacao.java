package Entity;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Prestacao {
	private static SimpleDateFormat dma = new SimpleDateFormat("dd/MM/yyyy");

	private Date dataPrestacao;
	private Double total;
	
	public Prestacao(Date dataPrestacao, Double total) {
		super();
		this.dataPrestacao = dataPrestacao;
		this.total = total;
	}

	public Date getDataPrestacao() {
		return dataPrestacao;
	}

	public void setDataPrestacao(Date dataPrestacao) {
		this.dataPrestacao = dataPrestacao;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return dma.format(dataPrestacao)  + " - " +  String.format("%.2f",total) ;
	}
	
	

	

}
