package aed2.model;

public interface Item {
	/**
	 * Formata "Person" para salvar no arquivo.
	 */
	long id();
	
	/**
	 * Formata "Person" para impressão.
	 */
	String toData();
}
