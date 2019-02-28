package br.com.opet.rh;

import br.com.opet.modelo.Pessoa;

public class Enfermeiro extends Pessoa {

	private int carga_horaria;

	public String toString() {
		String str = "";
		str = super.toString() + " - " + this.carga_horaria;

		return str;
	}

	public int getCarga_horaria() {
		return carga_horaria;
	}

	public void setCarga_horaria(int carga_horaria) {
		this.carga_horaria = carga_horaria;
	}
}