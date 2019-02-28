package br.com.opet.rh;

import br.com.opet.modelo.Pessoa;

public class Medico extends Pessoa {

	private String especialidade;

	public String toString() {
		String str = "";
		str = super.toString() + " - " + this.especialidade;

		return str;
	}

	public String getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}
}