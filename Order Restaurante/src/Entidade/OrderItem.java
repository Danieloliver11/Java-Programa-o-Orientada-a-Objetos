package Entidade;

public class OrderItem {

	private Integer quantidade;
	private Double preco;
	
	private Produto produto;

	public OrderItem(Integer quantidade, Double preco, Produto produto) {
		super();
		this.quantidade = quantidade;
		this.preco = preco;
		this.produto = produto;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
	
	public Double subTotal() {
		
		return this.quantidade * this.preco;
	}
	
	@Override
	public String toString() {
		
		return "\n"+ produto.getNome()+", Quantidade "+ this.getQuantidade()+", $"+produto.getPreco()+"\nSubtotal: $"+this.subTotal();
	}
}
