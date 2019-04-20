package br.com.opet.model;

import java.util.Date;

import br.com.opet.model.top.Pessoa;

public class Medico extends Pessoa {
	private int especialidade;

	public Medico(int Tipo, String nome, Date dtNascimento, String cpf, String sexo,
			int especialidade) {
		this.Tipo = Tipo;
		this.nome = nome;
		this.dtNascimento = dtNascimento;
		this.cpf = cpf;
		this.Sexo = sexo;
		this.especialidade = especialidade;
	}

	public String toString() {
		String str = "";
		str = super.toString() + " - " + "| " + this.especialidade + " |";

		return str;
	}

	public int getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(int especialidade) {
		this.especialidade = especialidade;
	}
}