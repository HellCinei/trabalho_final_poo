package br.com.projetoPoo.entity;

import br.com.projetoPoo.interfaces.Calculos;

public class Funcionario extends Pessoa implements Calculos {
	private Double salarioBruto;
	private Double descontoInss;
	private Double descontoIR;

	public Funcionario(Double salarioBruto, Double descontoInss, Double descontoIR) {
		super();
		this.salarioBruto = salarioBruto;
		this.descontoInss = descontoInss;
		this.descontoIR = descontoIR;
	}
	public void calcularInss() {
		if (salarioBruto <= 1412.00) {
			descontoInss = salarioBruto * 0.075;
		}
		else if (salarioBruto <= 2666.68) {
			descontoInss = (salarioBruto * 0.09) - 21.18;
		}
		else if (salarioBruto <= 4000.03) {
			descontoInss = (salarioBruto * 0.12) - 101.18;
		}
		else if (salarioBruto <= 7786.02) {
			descontoInss = (salarioBruto * 0.14) - 181.18;
		}
		else if (salarioBruto > 7786.02) {
			descontoInss = (7786.02 * 0.14) - 181.18;
		}
	}
}
