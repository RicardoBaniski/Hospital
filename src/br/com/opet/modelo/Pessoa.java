package br.com.opet.modelo;

import java.util.Date;

public class Pessoa {

	protected String nome;
	protected Date dt_nasc;
	protected String cpf;
	protected String sexo;
	protected String telefone;

	public String toString() {
		String str = "";
		str = this.nome + " - " + this.dt_nasc + " - " + this.cpf + " - " + this.sexo + " - " + this.telefone;

		return str;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDt_nasc() {
		return dt_nasc;
	}

	public void setDt_nasc(Date dt_nasc) {
		this.dt_nasc = dt_nasc;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

}