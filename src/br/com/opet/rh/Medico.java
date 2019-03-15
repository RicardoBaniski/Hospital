package br.com.opet.rh;

import java.util.HashMap;

import br.com.opet.modelo.Pessoa;

public class Medico extends Pessoa {

	private int especialidade;
	HashMap<Integer, String> mapEspecialidade = new HashMap<Integer, String>();

	public String toString() {
		String str = "";
		str = super.toString() + " - " + this.mapEspecialidade.get(this.especialidade);

		return str;
	}

	public int getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(int especialidade) {
		this.especialidade = especialidade;
	}

	public HashMap<Integer, String> getMapEspecialidade() {
		return mapEspecialidade;
	}

	public void setMapEspecialidade(HashMap<Integer, String> mapEspecialidade) {
		this.mapEspecialidade = mapEspecialidade;
	}

}