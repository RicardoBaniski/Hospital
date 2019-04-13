package br.com.opet.model.top;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Pessoa {

	protected int Tipo;
	protected String nome;
	protected Date dtNascimento;
	protected String cpf;
	protected String Sexo;
	protected String telefone;

	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	public String toString() {
		String str = "";
		String dtNascimento = sdf.format(this.dtNascimento).toString();
		str = this.nome + " - " + dtNascimento + " - " + this.cpf + " - " + this.Sexo + " - " + this.telefone;

		return str;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDtNascimento() {
		return dtNascimento;
	}

	public void setDtNascimento(Date dtNascimento) {
		this.dtNascimento = dtNascimento;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getSexo() {
		return Sexo;
	}

	public void setSexo(String sexo) {
		Sexo = sexo;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public int getTipo() {
		return Tipo;
	}

	public void setTipo(int tipo) {
		Tipo = tipo;
	}
}