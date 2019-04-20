package br.com.opet.controller;

import java.util.HashMap;

import br.com.opet.model.Especialidade;
import br.com.opet.view.TelaEspecialidade;

public class ControllerEspecialidade {

	TelaEspecialidade te = new TelaEspecialidade();
	Especialidade especialidade = new Especialidade();

	public void menuEspecialidade() throws Exception {
		int opc = te.showSubMenuEspecialidade();
		int id = -1;

		while (opc != 0) {
			switch (opc) {
			case 1:
				especialidade = te.showCadastrar();
				if (!especialidade.salvar())
					System.out.println("Falha ao salvar Especialidade!");
				break;
			case 2:
				showListaEspecialidades();
				break;
			case 3:
				id = manutencaoEspecialidade();
				especialidade = te.showCadastrar();
				especialidade.setId(id);
				if (!especialidade.atualizar())
					System.err.println("Falha ao Atualizar Especialidade!");
				break;
			case 4:
				id = manutencaoEspecialidade();
				if (especialidade.excluir(id))
					System.err.println("Falha aio Atualizar Especialidade!");
				break;
			default:
				System.out.println("Opção inválida!");
			}
			opc = te.showSubMenuEspecialidade();
		}
	}

	private void showListaEspecialidades() {
		for (Especialidade espTMP : getMapEspecialidade().values()) {
			te.showEspecialidade(espTMP);
		}
	}

	public HashMap<Integer, Especialidade> getMapEspecialidade() {
		return especialidade.list();
	}

	public int manutencaoEspecialidade() {
		showListaEspecialidades();
		int id = -1;

		boolean isFilled = false;
		do {
			id = te.showGetIDEspecialidade();
			especialidade.setId(id);
			isFilled = especialidade.recuperar();
			if (!isFilled)
				System.out.println("Especialidade inválida!");
		} while (!isFilled);

		return id;
	}
}