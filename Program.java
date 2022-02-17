package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.Contribuinte;
import entities.PessoaFisica;
import entities.PessoaJuridica;

public class Program {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		List<Contribuinte> lista = new ArrayList<Contribuinte>();

		System.out.println("+------------------------------+");
		System.out.println("| ---- CÁLCULO DE IMPOSTO ---- |");
		System.out.println("+------------------------------+");

		System.out.print("| Quantidade de cadastros: ");
		int n = sc.nextInt();
		sc.nextLine();

		for (int i = 0; i < n; i++) {

			System.out.println("+------------------------------+");
			System.out.println("| Cadastro #" + (i+1));
			System.out.print("| Contribuinte físico ou jurídico (f/j)? ");
			char resposta = sc.next().toLowerCase().charAt(0);

			System.out.print("| Nome: ");
			sc.nextLine();
			String nome = sc.nextLine();

			System.out.print("| Renda anual: ");
			double rendaAnual = sc.nextDouble();
			sc.nextLine();

			if (resposta == 'f') {
				System.out.print("| Total de gastos com saúde: ");
				double gastosComSaude = sc.nextDouble();
				sc.nextLine();

				Contribuinte pessoaFisica = new PessoaFisica(nome, rendaAnual, gastosComSaude);
				lista.add(pessoaFisica);
			} else if (resposta == 'j') {
				System.out.print("| Quantidade de funcionários: ");
				int numeroDeFuncionarios = sc.nextInt();
				sc.nextLine();

				Contribuinte pessoaJuridica = new PessoaJuridica(nome, rendaAnual, numeroDeFuncionarios);
				lista.add(pessoaJuridica);
			}
		}

		System.out.println("+------------------------------+");

		double somaTotalDeImpostos = 0;
		for (Contribuinte pessoa : lista) {
			somaTotalDeImpostos += pessoa.impostoFinal();
			System.out.println("| " + pessoa.getNome() + ": $ " + String.format("%.2f", pessoa.impostoFinal()));
		}
		System.out.println("+------------------------------+\n|");
		System.out.println("| TOTAL DE IMPOSTO ARRECADADO: $ " + String.format("%.2f", somaTotalDeImpostos));
		
		sc.close();
	}
}
