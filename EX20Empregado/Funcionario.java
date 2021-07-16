package EX20Empregado;

public class Funcionario {
	
	private String nome;
	private String email;
	private Double preco;

	
	public Funcionario(String nome, String email, Double preco) {
		super();
		this.nome = nome;
		this.email = email;
		this.preco = preco;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Double getPreco() {
		return preco;
	}
	public void setPreco(Double preco) {
		this.preco = preco;
	}

	@Override
	public String toString() {
		return "Funcionario [nome=" + nome + ", email=" + email + ", preco=" + String.format("%.2f", preco) + "]";
	}
	
	
	

}
