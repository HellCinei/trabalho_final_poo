package br.com.projetoPoo.testemain;

import br.com.projetoPoo.entity.Arquivo;
import br.com.projetoPoo.entity.Funcionario;

//C:\Users\angel\Downloads\listaFuncionarios.csv
public class Main {

	public static void main(String[] args) {

		try {
			Arquivo a = new Arquivo();

			a.lerArquivo();

			for (Funcionario f : a.getFuncionarios()) {

				f.calcularInss();
				f.calcularIR();

			}
			a.DigitarArquivo();
		} catch (NullPointerException e) {
			System.err.println("Valor nulo!");
			e.printStackTrace();
		} catch (Exception e) {
			System.err.println("Erro!!!!");
			e.printStackTrace();
		}

	}

}
