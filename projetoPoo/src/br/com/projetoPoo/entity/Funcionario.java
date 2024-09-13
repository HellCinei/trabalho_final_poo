package br.com.projetoPoo.entity;

import br.com.projetoPoo.interfaces.Calculos;

public class Funcionario extends Pessoa implements Calculos {
	private Double salarioBruto;
	private Double descontoInss;
	private Double descontoIR;
	private Integer dependentes;

	public Funcionario(Double salarioBruto, Integer dependentes) {
		this.salarioBruto = salarioBruto;
		this.dependentes = dependentes;
	}

	public Double getSalarioBruto() {
		return salarioBruto;
	}

	public void setSalarioBruto(Double salarioBruto) {
		this.salarioBruto = salarioBruto;
	}

	public Double getDescontoInss() {
		return descontoInss;
	}

	public void setDescontoInss(Double descontoInss) {
		this.descontoInss = descontoInss;
	}

	public Double getDescontoIR() {
		return descontoIR;
	}

	public void setDescontoIR(Double descontoIR) {
		this.descontoIR = descontoIR;
	}

	public Integer getDependentes() {
		return dependentes;
	}

	public void setDependentes(Integer dependentes) {
		this.dependentes = dependentes;
	}

	public void calcularInss() {
		if (salarioBruto <= 1412.00) {
			descontoInss = salarioBruto * 0.075;
		} else if (salarioBruto <= 2666.68) {
			descontoInss = (salarioBruto * 0.09) - 21.18;
		} else if (salarioBruto <= 4000.03) {
			descontoInss = (salarioBruto * 0.12) - 101.18;
		} else if (salarioBruto <= 7786.02) {
			descontoInss = (salarioBruto * 0.14) - 181.18;
		} else if (salarioBruto > 7786.02) {
			descontoInss = (7786.02 * 0.14) - 181.18;
		}
	}

	public void calcularIR() {
		Double aliquota;
		Double deducaoParcela;

		if (salarioBruto <= 2259.0) {
			aliquota = 1.;
			deducaoParcela = 0.;
		} else if (salarioBruto > 2259.0 && salarioBruto <= 2826.65) {
			aliquota = 0.075;
			deducaoParcela = 169.44;
		} else if (salarioBruto > 2826.65 && salarioBruto <= 3751.05) {
			aliquota = 0.15;
			deducaoParcela = 381.44;
		} else if (salarioBruto > 3751.05 && salarioBruto <= 4664.68) {
			aliquota = 0.225;
			deducaoParcela = 662.77;
		} else {
			aliquota = 0.275;
			deducaoParcela = 896.00;
		}
		descontoIR = ((salarioBruto - (dependentes * 189.59) - descontoInss) * aliquota) - deducaoParcela;
	}
}
