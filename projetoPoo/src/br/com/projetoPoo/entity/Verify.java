package br.com.projetoPoo.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public final class Verify {
	
	private List<String> cpflist = new ArrayList<>();

	public void validCpf(String cpf) {

		if (cpf.length() != 11) {
			throw new DependenteException("CPF Inválido");
		} else if (cpflist.contains(cpf)) {
			throw new DependenteException("CPF Já existente");
		} else {
			cpflist.add(cpf);
		}
	}

	public void validAge(LocalDate dataNascimento) {
		if (LocalDate.now().getYear() - dataNascimento.getYear() >= 18) {
			throw new DependenteException("Está Pessoa já é Idependente!");
		}
	}

}
