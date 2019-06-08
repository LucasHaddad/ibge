package aed2;

import java.io.IOException;

import aed2.dao.PersonDAO;
import aed2.model.Person;
import aed2.structure.Cell;
import aed2.structure.List;

public class Report {

	static final String ARCHIVE = "\\\\data.txt";
	private int total;

	private void totalPopulation() throws IOException {
		System.out.println("\n--------------------------------");
		System.out.println("   Relatório de categorização   ");
		System.out.println("--------------------------------\n");

		PersonDAO dao = new PersonDAO(ARCHIVE);
		List people = dao.get();
		total = people.size();
		System.out.println("População total: " + total);
		System.out.println("_______________________________________");
	}

	private void sexPorcentage() throws IOException {
		PersonDAO dao = new PersonDAO(ARCHIVE);
		List people = dao.get();
		Cell aux = people.first;
		float Male = 0, Female = 0;
		while (aux!= null) {
			Person person = (Person) aux.item;
			if (person != null) {
				if ("M".equals(person.sex()))
					Male++;
				if ("F".equals(person.sex()))
					Female++;
			}aux=aux.next;
		}
			System.out.println("\nSEXO");
			System.out.print("Feminino: " + Female + " (" + Female * 100 / total + "%)  ");
			System.out.println("\nMasculino: " + Male + " (" + Male * 100 / total + "%)");
	}

	private void Age() throws IOException {
		PersonDAO dao = new PersonDAO(ARCHIVE);
		List people = dao.get();
		Cell aux = people.first;
		float A = 0, B = 0, C = 0, D = 0, E = 0, F = 0, G = 0;
		while (aux!= null) {
			Person person = (Person) aux.item;
			if (person != null) {
				if (person.age() <= 12)
					A++;
				if (person.age() <= 19 && person.age() > 12)
					B++;
				if (person.age() <= 25 && person.age() > 20)
					C++;
				if (person.age() <= 30 && person.age() > 25)
					D++;
				if (person.age() <= 45 && person.age() > 30)
					E++;
				if (person.age() <= 65 && person.age() > 45)
					F++;
				if (person.age() > 65)
					G++;
			}
			aux=aux.next;
		}
			System.out.println("_______________________________________");
			System.out.println("\n Idade \n");
			System.out.println("Ate 12 anos: " + A + " (" + A * 100 / total + "%)");
			System.out.println("De 13 a 19 anos : " + B + " (" + B * 100 / total + "%)");
			System.out.println("De 20 a 25 anos : " + C + " (" + C * 100 / total + "%)");
			System.out.println("De 26 a 30 anos : " + D + " (" + D * 100 / total + "%)");
			System.out.println("De 31 a 45 anos : " + E + " (" + E * 100 / total + "%)");
			System.out.println("De 46 a 65 anos : " + F + " (" + F * 100 / total + "%)");
			System.out.println("Acima 65 anos : " + G + " (" + G * 100 / total + "%)");
		}

	private void Area() throws IOException {
		PersonDAO dao = new PersonDAO(ARCHIVE);
		List people = dao.get();
		Cell aux = people.first;
		float Urban = 0, Rural = 0;
		while (aux!= null) {
			Person person = (Person) aux.item;
			if (person != null) {
				if ("Urban".equals(person.area()))
					Urban++;
				if ("Rural".equals(person.area()))
					Rural++;
			}	aux=aux.next;
		}
		System.out.println("\n Area");
		System.out.print("Urbana: " + Urban + " (" + Urban * 100 / total + "%)  ");
		System.out.println("\nRural: " + Rural + " (" + Rural * 100 / total + "%)");
	}

	private void maritalStatus() throws IOException {
		PersonDAO dao = new PersonDAO(ARCHIVE);
		List people = dao.get();
		Cell aux = people.first;
		float Married = 0, Single = 0, Divorced = 0, Widow = 0;
		while (aux!= null) {
			Person person = (Person) aux.item;
			if (person != null) {
				if ("Married".equals(person.civilStatus()))
					Married++;
				if ("Single".equals(person.civilStatus()))
					Single++;
				if ("Divorced".equals(person.civilStatus()))
					Divorced++;
				if ("Widow".equals(person.civilStatus()))
					Widow++;
			}	aux=aux.next;
		}
		System.out.println("_______________________________________");
		System.out.println("\nESTADO CÍVIL\n");
		System.out.println("Casado(a): " + Married + " (" + Married * 100 / total + "%)");
		System.out.println("Solteiro(a): " + Single + " (" + Single * 100 / total + "%)");
		System.out.println("Divorciado(a): " + Divorced + " (" + Divorced * 100 / total + "%)");
		System.out.println("Viúvo(a): " + Widow + " (" + Widow * 100 / total + "%)");
	}

	private void race() throws IOException {
		PersonDAO dao = new PersonDAO(ARCHIVE);
		List people = dao.get();
		Cell aux = people.first;
		float White = 0, Brown = 0, Black = 0, Native = 0, Asian = 0;
		while (aux!= null) {
			Person person = (Person) aux.item;
			if (person != null) {
				if ("White".equals(person.race()))
					White++;
				if ("Brown".equals(person.race()))
					Brown++;
				if ("Black".equals(person.race()))
					Black++;
				if ("Native".equals(person.race()))
					Native++;
				if ("Asian".equals(person.race()))
					Asian++;
			}	aux=aux.next;
		}
		System.out.println("_______________________________________");
		System.out.println("\nRAÇA\n");
		System.out.println("Parda: " + Brown + " (" + Brown * 100 / total + "%)");
		System.out.println("Preta: " + Black + " (" + Black * 100 / total + "%)");
		System.out.println("Branca: " + White + " (" + White * 100 / total + "%)");
		System.out.println("Amarela: " + Asian + " (" + Asian * 100 / total + "%)");
		System.out.println("Indígena: " + Native + " (" + Native * 100 / total + "%)");
	}

	public static void main(String [] ARGS) throws IOException {
		Report report = new Report();
		report.totalPopulation();
		report.sexPorcentage();
		report.Age();
		report.Area();
		report.maritalStatus();
		report.race();
	}
}
