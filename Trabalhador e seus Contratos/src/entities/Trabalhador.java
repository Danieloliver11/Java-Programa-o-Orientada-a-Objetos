package entities;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Trabalhador {
	
	private String nome;
	private NivelTrabalhador nivel;
	private double salarioBase;
	
	private List<HoraContratos> contratos = new ArrayList<>();
	
	private Departamento departamento;
	
	
	

	public Trabalhador(String nome, NivelTrabalhador nivel, double salarioBase, 
			Departamento departamento) {
		super();
		this.nome = nome;
		this.nivel = nivel;
		this.salarioBase = salarioBase;
		this.departamento = departamento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public NivelTrabalhador getNivel() {
		return nivel;
	}

	public void setNivel(NivelTrabalhador nivel) {
		this.nivel = nivel;
	}

	public double getSalarioBase() {
		return salarioBase;
	}

	public void setSalarioBase(double salarioBase) {
		this.salarioBase = salarioBase;
	}

	public List<HoraContratos> getContratos() {
		return contratos;
	}

	

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}
	
	public void addContrato(HoraContratos contrato) {
		
		this.contratos.add(contrato);
		
	}
	
	public void removeContrato(HoraContratos contrato) {
		
		this.contratos.remove(contrato);
	}
	
	public Double renda(Integer mes, Integer ano ) {
		Double resul= this.salarioBase;
		Calendar car = Calendar.getInstance(); 
		for(HoraContratos x: contratos) {
			 car.setTime(x.getData());
			 int iMes = 1 + car.get(Calendar.MONTH);
			 int iAno = car.get(Calendar.YEAR);
			 
			 if(mes == iMes && ano == iAno) {
				 
				 resul += x.totalValorDia();
				 
			 }
			
		}
		
		return resul;
		
	}
	

}
