package Entidade;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Order {
	
	private static final SimpleDateFormat dma = new SimpleDateFormat("dd/MM/yyyy");

	private LocalDate momento;
	
	private StatusOrder status;
	
	
	private List<OrderItem> orderItens = new ArrayList<>();
	
	private Cliente cliente;

	public Order(LocalDate momento, StatusOrder status, Cliente cliente) {
		super();
		this.momento = momento;
		this.status = status;
		this.cliente = cliente;
	}

	public LocalDate getMomento() {
		return momento;
	}

	public void setMomento(LocalDate momento) {
		this.momento = momento;
	}

	public StatusOrder getStatus() {
		return status;
	}

	public void setStatus(StatusOrder status) {
		this.status = status;
	}

	public List<OrderItem> getOrderItens() {
		return orderItens;
	}


	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public void addItens (OrderItem orderItens) {
		this.orderItens.add(orderItens);
	}
	
	public void removeItens (OrderItem orderIten) {
		this.orderItens.remove(orderIten);
	}
	
	public Double total() {
		Double total = 0.0;
		for(OrderItem x: orderItens) {
			
			total +=  x.subTotal();
		}
		
		return total;
	}
	
	@Override
	public String toString() {
		
		StringBuilder st = new StringBuilder();
		
		st.append("Resumo do pedido\n");
		st.append("Momento do pedido "+this.momento );
		st.append("\nStatus do pedido; "+this.status);
		st.append("\nCliente: "+this.cliente.getName()+" "+dma.format(cliente.getDataNascimento())+" - "+this.cliente.getEmail());
		st.append("\nOrdem de  Itens\n");
		
		for(OrderItem x: orderItens) {
			st.append(x.toString());
			
		}
		st.append("\nTotal :"+this.total());
		
		return st.toString();
	}
	
	
	
	
	
}
