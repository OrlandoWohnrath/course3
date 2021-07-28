package application;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Company;
import entities.Individual;
import entities.TaxPayer;

public class Program {

	public static void main(String[] args) throws ParseException {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<TaxPayer> list = new ArrayList<>();
		
		System.out.println("Enter the number of tax payers:");
		int n = sc.nextInt();
		
		for (int i = 0; i < n; i++) {
			System.out.println("TAX PAYER #" + (i + 1) + " DATA:");
			System.out.print("Individual or company (i/c)?");
			char type = sc.next().charAt(0);
			System.out.print("Name:");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Anual income:");
			Double income = sc.nextDouble();
			if (type == 'i') {
				System.out.print("Health expenditures:");
				Double healthExpenditures = sc.nextDouble();
				list.add(new Individual(name, income, healthExpenditures));
			}
			else {
				System.out.print("Number of employees:");
				int numberOfEmployees = sc.nextInt();
				list.add(new Company(name, income, numberOfEmployees));
			}
		}
		
		double sum = 0.0;
		System.out.println();
		System.out.println("TAXES PAID:");
		for (TaxPayer tp : list) {
			double tax = tp.tax();
			System.out.println(tp.getName() + ": $ " + String.format("%.2f", tax));
			sum += tax;
		}
		
		System.out.println();
		System.out.println("TOTAL TAXES: $ " + String.format("%.2f", sum));
		sc.close();
	}

}
