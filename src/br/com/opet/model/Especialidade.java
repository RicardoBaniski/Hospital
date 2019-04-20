package br.com.opet.model;

import java.util.HashMap;

import br.com.opet.model.dao.EspecialidadeDAO;

public class Especialidade extends EspecialidadeDAO {

	private int id;
	private String descricao;

	public Especialidade() {
	}

	public Especialidade(String descricao) {
		this.descricao = descricao;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public boolean salvar() {
		return super.salvar(this);
	}

	public boolean atualizar() {
		return super.atualizar(this);
	}

	public boolean excluir() {
		return super.excluir(this.id);
	}

	public boolean recuperar() {
		Especialidade eTMP = super.recuperar(this.id);
		if (eTMP == null)

			this.id = eTMP.getId();
		this.descricao = eTMP.getDescricao();
		return false;

	}

	@Override
	public HashMap<Integer, Especialidade> list() {
		return super.list();
	}
}