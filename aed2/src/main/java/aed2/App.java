package aed2;

import java.util.Scanner;
import aed2.report.Report;

class Menu {
    /**
     * 
     */
    private final Report report = new Report(); 

    /**
     * 
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
     * 
     */
    public void start() {
        Scanner scan = new Scanner(System.in);
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
     * 
     */
    private void addPerson() {
        
    }   
    
    /**
     * 
     */
    private void removePerson() {

    }

    /**
     * 
     */
    private void updatePerson() {

    }

    /**
     * 
     */
    private void getPerson() {

    }

    /**
     * 
     */
    private void listPeople() {

    }

    /**
     * 
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