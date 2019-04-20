package br.com.opet.view;

import com.opet.util.Reader;

import br.com.opet.model.Especialidade;

public class TelaEspecialidade {

	public int showSubMenuEspecialidade() throws Exception {
		System.out.println("Informe uma opcao");
		System.out.println("=================");
		System.out.println("1 - Cadastrar");
		System.out.println("2 - Listar");
		System.out.println("3 - Alterar");
		System.out.println("4 - Excluir");
		System.out.println("0 - Voltar");

		int opcSub;
		try {
			opcSub = Reader.readInt();
		} catch (Exception e) {
			return -1;
		}
		return opcSub;
	}

	public Especialidade showCadastrar() {
		System.out.println("Informe o nome da nova ESPECIALIDADE: ");
		String esp = Reader.readString();
		Especialidade espTMP = new Especialidade(esp);

		return espTMP;
	}

	public void showListarEspecialidade(Especialidade pEsp) {
		System.out.println(pEsp.getId() + " - " + pEsp.getDescricao());
	}

	public int showGetIDEspecialidade() {
		System.out.println("Informe o ID da Especialidade:");
		int id;
		do {
			try {
				id = Reader.readInt();
			} catch (Exception e) {
				id = -1;
				System.out.println("ID inválido!");
			}
			if (id < 0) {
				System.out.println("ID inválido!");
			}
		} while (id < 0);
		return id;
	}

	public void showEspecialidade(Especialidade pESP) {
		System.out.println(pESP.getId() + " - " + pESP.getDescricao());
	}
}