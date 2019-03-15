package br.com.opet.main;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;

import com.opet.util.Reader;

import br.com.opet.modelo.Pessoa;
import br.com.opet.rh.AuxiliarAdministrativo;
import br.com.opet.rh.Enfermeiro;
import br.com.opet.rh.Medico;

public class Aplicacao {

	public static void main(String[] args) throws Exception {

		ArrayList<Pessoa> alPessoa = new ArrayList<Pessoa>();
		HashMap<Integer, String> mapEspecialidade = new HashMap<Integer, String>();

		mapEspecialidade.put(0, "Cardiologista");
		mapEspecialidade.put(1, "Otorrino");
		mapEspecialidade.put(2, "Neuro");
		mapEspecialidade.put(3, "Nefrologista");
		mapEspecialidade.put(4, "Generalista");

		int opc = -1;
		opc = menuPrincipal();
		while (opc != 0) {
			switch (opc) {
			case 1:
				menuSubMenu(opc, alPessoa, mapEspecialidade);
				break;
			case 2:
				menuSubMenu(opc, alPessoa, mapEspecialidade);
				break;
			default:
				System.out.println("Opcao Invalida");
			}
			opc = menuPrincipal();
		}
	}

	public static int menuPrincipal() throws Exception {
		System.out.println("Informe uma opcao");
		System.out.println("===================");
		System.out.println("1 - Pessoa");
		System.out.println("2 - Especialidade");
		System.out.println("0 - Sair");
		System.out.print("===> ");

		int opc = Reader.readInt();
		System.out.println("");

		return opc;
	}

	public static void menuSubMenu(int opc, ArrayList<Pessoa> alPessoa, HashMap<Integer, String> mapEspecialidade)
			throws Exception {
		System.out.println("Informe uma opcao");
		System.out.println("===================");
		System.out.println("1 - Cadastrar");
		System.out.println("2 - Consultar");
		System.out.println("0 - Voltar");
		System.out.print("===> ");

		int opcSub = Reader.readInt();
		System.out.println("");
		int swtc = (opc * 10) + opcSub;

		switch (swtc) {
		case 11:
			cadastrarPessoa(alPessoa, mapEspecialidade);
			break;
		case 12:
			consultarPessoa(alPessoa, mapEspecialidade);
			break;
		case 21:
			cadastrarEspecialidade(mapEspecialidade);
			break;
		case 22:
			consultarEspecialidade(mapEspecialidade);
			break;
		default:
			System.out.println("Opcao Invalida");
		}
	}

	public static int menuCadastrar() throws Exception {
		System.out.println("Informe uma opcao");
		System.out.println("===================");
		System.out.println("1 - Medico");
		System.out.println("2 - Enfermeiro");
		System.out.println("3 - Auxiliar Adm");
		System.out.println("0 - Voltar");
		System.out.print("===> ");

		int opc = Reader.readInt();
		System.out.println("");
		return opc;
	}

	public static void consultarPessoa(ArrayList<Pessoa> alPessoa, HashMap<Integer, String> mapEspecialidade) {
		for (Pessoa p : alPessoa) {
			System.out.println(p.toString());
		}
	}

	public static void cadastrarPessoa(ArrayList<Pessoa> alPessoa, HashMap<Integer, String> mapEspecialidade)
			throws Exception {
		int opc = menuCadastrar();

		while (opc != 0) {
			switch (opc) {
			case 1:
			case 2:
			case 3:
				telaCadastro(alPessoa, mapEspecialidade, opc);
				break;
			default:
				System.out.print("Opcao Invalida");
			}
			opc = menuCadastrar();
		}
	}

	public static void telaCadastro(ArrayList<Pessoa> alPessoa, HashMap<Integer, String> mapEspecialidade, int tipo)
			throws Exception {
		System.out.print("Nome: ");
		String nome = Reader.readString();
		System.out.print("Data de Nascimento: ");
		String dtNasc = Reader.readString();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		System.out.print("CPF: ");
		String cpf = Reader.readString();
		System.out.print("Sexo: ");
		String sexo = Reader.readString();
		System.out.print("Telefone: ");
		String telefone = Reader.readString();

		if (tipo == 1) {
			Medico medico = new Medico();
			medico.setNome(nome);
			medico.setDt_nasc(sdf.parse(dtNasc));
			medico.setCpf(cpf);
			medico.setSexo(sexo);
			medico.setTelefone(telefone);

			System.out.println("Especialidades:\n");
			int esp = -1;
			do {
				for (int i = 0; i < mapEspecialidade.size(); i++) {
					System.out.println(i + " - " + mapEspecialidade.get(i));
				}
				System.out.print("\nInforme uma opcao: ");
				esp = Reader.readInt();
				System.out.println("");
			} while (!mapEspecialidade.containsKey(esp));

			medico.setMapEspecialidade(mapEspecialidade);
			medico.setEspecialidade(esp);
			alPessoa.add(medico);

		} else if (tipo == 2) {
			Enfermeiro enf = new Enfermeiro();
			enf.setNome(nome);
			enf.setDt_nasc(sdf.parse(dtNasc));
			enf.setCpf(cpf);
			enf.setSexo(sexo);
			enf.setTelefone(telefone);

			System.out.print("Carga Horária: ");
			int cargaHoraria = Reader.readInt();
			enf.setCarga_horaria(cargaHoraria);
			alPessoa.add(enf);

		} else {
			AuxiliarAdministrativo aux = new AuxiliarAdministrativo();
			aux.setNome(nome);
			aux.setDt_nasc(sdf.parse(dtNasc));
			aux.setCpf(cpf);
			aux.setSexo(sexo);
			aux.setTelefone(telefone);

			System.out.print("Salario: ");
			double salario = Reader.readDouble();
			aux.setSalario(salario);
			alPessoa.add(aux);
		}
	}

	public static void cadastrarEspecialidade(HashMap<Integer, String> mapEspecialidade) {
		System.out.println("Informe a descricao da nova especialidade");
		String esp = Reader.readString();
		mapEspecialidade.put(mapEspecialidade.size(), esp);
	}

	public static void consultarEspecialidade(HashMap<Integer, String> mapEspecialidade) {
		for (int i = 0; i < mapEspecialidade.size(); i++) {
			System.out.println(i + " - " + mapEspecialidade.get(i));
		}
	}
}