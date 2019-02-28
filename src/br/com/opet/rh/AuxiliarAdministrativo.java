package br.com.opet.rh;

import br.com.opet.modelo.Pessoa;

public class AuxiliarAdministrativo extends Pessoa {

	private double salario;

	public String toString() {
		String str = "";
		str = super.toString() + " - " + this.salario;

		return str;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}
}