package Service;

public class PaypalService implements TaxaService{
	
	private static final double JUROS_SIMPLES = 0.02;
	private static final double JUROS_MES = 0.01;


	@Override
	public Double taxaDePagamento(Double valor) {
		
		return JUROS_SIMPLES * valor;
	}

	@Override
	public Double juros(double valor, int meses) {
		return valor * JUROS_MES * meses ;
	}
	
	

}
