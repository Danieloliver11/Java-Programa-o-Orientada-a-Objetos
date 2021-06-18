package Service;

public class BrasilTaxaService implements TaxService{

	//calcula a taxa 
	
	@Override
	public Double tax(Double valor) {
		
		if(valor <=100.0) {
			return valor * 0.2;
			
		}else {
			return valor * 0.15;
		}
		
	}
	
	

}
