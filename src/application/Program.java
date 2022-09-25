package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.Set;

import entities.Sale;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		//String pathSts = "E:\\Programas para Programação\\workSpaceEclipseTestes\\Enumerações e Composições\\arquivosParaExercicios\\vendas.csv";
		System.out.println("Entre com o caminho do arquivo: ");
		String path = sc.nextLine();
		System.out.println();

		try (BufferedReader br = new BufferedReader(new FileReader(path))) {

			String line = br.readLine();

			List<Sale> sallers = new ArrayList<>();

			while (line != null) {

				String[] full = line.split(",");
				int month = Integer.parseInt(full[0]);
				int year = Integer.parseInt(full[1]);
				String seller = full[2];
				int items = Integer.parseInt(full[3]);
				double total = Double.parseDouble(full[4]);

				sallers.add(new Sale(month, year, seller, items, total));

				line = br.readLine();

			}

			// Varrer a lista detectando os nomes únicos
			Set<String> nomesUnicos = new HashSet<>();
			for (Sale s : sallers) {
				nomesUnicos.add(s.getSaller());
			}

			// Obter a soma das vendas por vendedor(Nome Único)
			System.out.println("Total de vendas por vendedor: ");
			for (String nome : nomesUnicos) {
				double sum = sallers.stream().filter(x -> x.getSaller().equals(nome)).mapToDouble(x -> x.getTotal())
						.sum();
				System.out.println(nome + " - R$ " + String.format("%.2f", sum));
			}

		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		} finally {
			sc.close();
		}

	}

}
