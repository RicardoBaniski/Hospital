package br.com.opet.view;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;

import com.opet.util.Reader;

import br.com.opet.controller.ControllerEspecialidade;
import br.com.opet.model.AuxiliarAdministrativo;
import br.com.opet.model.Enfermeiro;
import br.com.opet.model.Especialidade;
import br.com.opet.model.Medico;
import br.com.opet.model.dao.EspecialidadeDAO;
import br.com.opet.model.top.Pessoa;

public class TelaPessoa {

	ControllerEspecialidade cEspecialidade = new ControllerEspecialidade();

	public int showSubMenuPrincipal() throws Exception {
		System.out.println("Informe uma opcao");
		System.out.println("=================");
		System.out.println("1 - Cadastrar");
		System.out.println("2 - Consultar");
		System.out.println("0 - Sair");

		int opc = Reader.readInt();

		return opc;
	}

	public int showSubMenuCadastrar() {
		System.out.println("Informe uma opcao");
		System.out.println("=================");
		System.out.println("1 - Medico");
		System.out.println("2 - Enfermeiro");
		System.out.println("3 - Auxiliar Administrativo");
		System.out.println("0 - Voltar");

		int opc = -1;
		try {
			opc = Reader.readInt();
		} catch (Exception e) {
			System.out.println("O valor informado deve ser um numero inteiro");
		}

		return opc;
	}

	public Pessoa showCadastrar() {

		int opc = showSubMenuCadastrar();

		System.out.print("Nome: ");
		String nome = Reader.readString();

		System.out.print("Data de Nascimento (DD/MM/YYYY): ");
		String dtNascimento = Reader.readString();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.print("CPF: ");
		String cpf = Reader.readString();

		System.out.print("Sexo: ");
		String sexo = Reader.readString();

		System.out.print("Telefone: ");
		String telefone = Reader.readString();

		Pessoa p = null;

		if (opc == 1) {
			int esp = -1;
			HashMap<Integer, Especialidade> idEspecialidade = cEspecialidade.getMapEspecialidade();
			System.out.println("Especialidade: ");
			do {
				System.out.println("informe uma opcao:");
				cEspecialidade.getMapEspecialidade();
				try {
					esp = Reader.readInt();
				} catch (Exception e) {
					System.out.println("O valor informado deve ser um numero inteiro");
				}
			} while (!idEspecialidade.containsKey(idEspecialidade));

			try {
				p = new Medico(opc, nome, sdf.parse(dtNascimento), cpf, sexo, telefone, esp);
			} catch (ParseException e) {
				System.out.println("O formato da data de nascimento deve ser dd/MM/yyyy");
			}

		} else if (opc == 2) {
			System.out.println("Carga Horaria: ");
			int cargaHoraria = -1;
			try {
				cargaHoraria = Reader.readInt();
			} catch (Exception e) {
				System.out.println("O valor informado deve ser um numero inteiro");
			}
			try {
				p = new Enfermeiro(opc, nome, sdf.parse(dtNascimento), cpf, sexo, telefone, cargaHoraria);
			} catch (ParseException e) {
				System.out.println("O formato da data de nascimento deve ser dd/MM/yyyy");
			}

		} else {
			System.out.println("Salario: ");
			double salario = -1;
			try {
				salario = Reader.readDouble();
			} catch (Exception e) {
				System.out.println("O valor informado deve ser no formato 9.99");
			}
			try {
				p = new AuxiliarAdministrativo(opc, nome, sdf.parse(dtNascimento), cpf, sexo, telefone, salario);
			} catch (ParseException e) {
				System.out.println("O formato da data de nascimento deve ser dd/MM/yyyy");
			}
		}
		return p;
	}

	public void showPessoa(Pessoa p) {
		System.out.println(p);
	}
}