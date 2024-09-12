package br.com.projetoPoo.entity;

public class Funcionario extends Pessoa {
	private Double salarioBruto;
	private Double descontoInss;
	private Double descontoIR;

	public Funcionario(Double salarioBruto, Double descontoInss, Double descontoIR) {
		super();
		this.salarioBruto = salarioBruto;
		this.descontoInss = descontoInss;
		this.descontoIR = descontoIR;
	}

}
