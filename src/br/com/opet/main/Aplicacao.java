package br.com.opet.main;

import java.text.SimpleDateFormat;

import com.opet.util.Reader;

import br.com.opet.modelo.Pessoa;
import br.com.opet.rh.AuxiliarAdministrativo;
import br.com.opet.rh.Enfermeiro;
import br.com.opet.rh.Medico;

public class Aplicacao {

	public static void main(String[] args) throws Exception {

		Pessoa lPessoa[] = new Pessoa[10];
		int auxPessoa = 0;

		int opc = -1;
		opc = menuPrincipal();

		while (opc != 0) {
			switch (opc) {
			case 1:
				auxPessoa = cadastrar(lPessoa, auxPessoa);
				break;
			case 2:
				consultar(lPessoa, auxPessoa);
				break;
			default:
				System.out.println("Opcao Invalida");
			}
			System.out.println();
			opc = menuPrincipal();
		}
	}

	public static int menuPrincipal() throws Exception {
		System.out.println("Informe uma opcao");
		System.out.println("===================");
		System.out.println("1 - Cadastrar");
		System.out.println("2 - Consultar");
		System.out.println("0 - Sair");
		System.out.print("===> ");

		int opc = Reader.readInt();
		System.out.print("");

		return opc;
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

	public static void consultar(Pessoa lPessoa[], int auxPessoa) {
		for (int i = 0; i < auxPessoa; i++) {
			System.out.println(lPessoa[i].toString());
		}
	}

	public static int cadastrar(Pessoa lPessoa[], int auxPessoa) throws Exception {
		int opc = menuCadastrar();

		while (opc != 0) {
			switch (opc) {
			case 1:
			case 2:
			case 3:
				auxPessoa = telaCadastro(lPessoa, auxPessoa, opc);
				break;
			default:
				System.out.print("Opcao Invalida");
			}
			opc = menuCadastrar();
		}
		return auxPessoa;
	}

	public static int telaCadastro(Pessoa lPessoa[], int auxPessoa, int tipo) throws Exception {

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

			System.out.print("Especialidade: ");
			String especialidade = Reader.readString();
			medico.setEspecialidade(especialidade);

			lPessoa[auxPessoa] = medico;

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

			lPessoa[auxPessoa] = enf;

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

			lPessoa[auxPessoa] = aux;
		}
		auxPessoa++;
		return auxPessoa;
	}
}