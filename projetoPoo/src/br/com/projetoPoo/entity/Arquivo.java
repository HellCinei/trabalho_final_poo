package br.com.projetoPoo.entity;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.com.projetoPoo.enums.Parentesco;

public class Arquivo {
	private Verify v = new Verify();
	private List<Funcionario> funcionarios = new ArrayList<>();

	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}

	public void lerArquivo() {
		try {
			Scanner ler = new Scanner(System.in);
			System.out.println("Digite o nome do arquivo: ");
			String nomeArquivo = ler.next();
			ler.close();
			Scanner sc = new Scanner(new File(nomeArquivo));

			while (sc.hasNext()) {
				String linha = sc.nextLine();

				if (!linha.isEmpty()) {
					linha = linha.trim();
					String[] dadosDaLinha = linha.split(";");

					String dado = dadosDaLinha[0];
					String dado1 = dadosDaLinha[1];
					String dado2 = dadosDaLinha[2];
					String dado3 = dadosDaLinha[3];
					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");

					try {

						funcionarios.add(new Funcionario(dado, dado1, LocalDate.parse(dado2, formatter),
								Double.parseDouble(dado3)));
						v.validCpf(dado1);

					} catch (NumberFormatException e) {

						v.validCpf(dado1);
						v.validAge(LocalDate.parse(dado2, formatter));
						Dependente dependente = new Dependente(dado, dado1, LocalDate.parse(dado2, formatter),
								Parentesco.valueOf(dado3));
						if (!funcionarios.isEmpty()) {
							Funcionario ultimoFuncionario = funcionarios.get(funcionarios.size() - 1);
							ultimoFuncionario.adicionarDependente(dependente);

						}

					}

				}

			}

			sc.close();
			/*
			 * for (Funcionario funcionario : funcionarios) {
			 * System.out.println(funcionario); }
			 */

		} catch (IOException e) {
			System.err.println("Arquivo não encontrado!");
		} catch (DependenteException e) {
			System.err.println(e.getMessage());
		} catch (Exception e) {
			System.err.println(e.getMessage() + "Erro!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
			e.printStackTrace();
		}
	}

	public void DigitarArquivo() {
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(
					"C:\\Users\\Win\\Documents\\trabalho_final_poo\\projetoPoo\\src\\br\\com\\projetoPoo\\testemain\\planilhas\\saidafuncionario.csv"));

			for (Funcionario f : funcionarios) {
				bw.write(f.toString());
			}
			bw.close();
		} catch (IOException e) {
			System.err.println("O Arquivo não foi encontrado!");
			e.printStackTrace();
		} catch (Exception e) {
			System.err.println("Erro!!!!");
			e.printStackTrace();
		}
	}

}
