package aed2;

import java.util.Scanner;
import java.lang.ClassLoader;
import java.io.File;

import aed2.report.Report;
import aed2.dao.PersonDAO;
import aed2.model.Person;

class Menu {
    
    /**
     * The Report instance.
     */
    private final Report report = new Report(); 

    /**
     * The scanner instance.
     */
    private final Scanner scan = new Scanner(System.in);

    /**
     * The person dao instance.
     */
    private final PersonDAO dao = new PersonDAO(ClassLoader.getResource().toString() + File.separator + "data.txt");

    /**
     * Prints the menu.
     */
    private void printMenu() {
        System.out.println("Seja bem-vindo ao sistema do IBGE.");
        System.out.println("Para continuar, escolha uma opção:");
        System.out.println("0 - Sair");
        System.out.println("1 - Adicionar pessoa.");
        System.out.println("2 - Ler pessoa.");
        System.out.println("3 - Atualizar pessoa.");
        System.out.println("4 - Apagar pessoa.");
        System.out.println("5 - Listar pessoas.");
        System.out.println("6 - Imprimir relatórios.");
    }

    /**
     * Starts the menu process.
     */
    public void start() {
        int option = 0;
        do {
            printMenu();
            option = scan.nextInt();
            if (option == 1) addPerson();
            else if (option == 2) getPerson(); 
            else if (option == 3) updatePerson(); 
            else if (option == 4) removePerson(); 
            else if (option == 5) listPeople(); 
            else if (option == 6) printReports(); 
        } while (option == 0);
    }

    /**
     * Adds a person.
     */
    private void addPerson() {
        System.out.println("Enter the person data");
        System.out.print("Name: ");
        String name = scan.nextLine();
        System.out.println("");
        System.out.print("Age: ");
        String age = scan.nextLine();
        System.out.println("");
        System.out.print("Sex: ");
        String sex = scan.nextLine();
        System.out.println("");
        System.out.print("Area: ");
        String area = scan.nextLine();
        System.out.print("Civil Status: ");
        String civilStatus = scan.nextLine();
        System.out.println("");
        System.out.print("Race: ");
        String race = scan.nextLine();
        System.out.println("");
        Person person = PersonDAO.factory(name, age, sex, area, civilStatus, race);
        dao.save(person);
    }   
    
    /**
     * Removes a person.
     */
    private void removePerson() {
        System.out.print("Enter the person id: ");
        System.out.print("");
        long id = scan.nextLong();
        dao.remove(id);
    }

    /**
     * Updates a person.
     */
    private void updatePerson() {
        System.out.println("Enter the person data");
        System.out.print("ID: ");
        String id = scan.nextLine();
        System.out.println("");
        System.out.print("Name: ");
        String name = scan.nextLine();
        System.out.println("");
        System.out.print("Age: ");
        String age = scan.nextLine();
        System.out.println("");
        System.out.print("Sex: ");
        String sex = scan.nextLine();
        System.out.println("");
        System.out.print("Area: ");
        String area = scan.nextLine();
        System.out.print("Civil Status: ");
        String civilStatus = scan.nextLine();
        System.out.println("");
        System.out.print("Race: ");
        String race = scan.nextLine();
        System.out.println("");
        Person person = PersonDAO.factory(id, name, age, sex, area, civilStatus, race);
        dao.update(person);
    }

    /**
     * Gets a person.
     */
    private void getPerson() {
        System.out.print("Enter the person id: ");
        long id = scan.nextLong();
        System.out.print("");
        Person person = dao.get(id);
        System.out.println(person.toString());
    }

    /**
     * List all people.
     */
    private void listPeople() {
        dao.get().print();
    }

    /**
     * Prints the reports.
     */
    private void printReports() {
        report.print();
    }
}

public class App {
    public static void main (String ...args) {
        new Menu().start();
    }
}