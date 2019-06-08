package aed2.structure;

import aed2.model.Item;

/**
 * Define a classe Lista de items do tipo T (no nosso caso será Pessoa).
 */
public class List {
    /**
     * Primeira célula (HEAD) do tipo T. 
     */
	public Cell first;
    /**
     * Ultima célula (ItemAIL) do tipo T.
     */
	public Cell last;

    /**
     * Construtor.
     */
	public List() {
        /** Esta célula é a sentinela. */
		first = new Cell(null);
		last = first;
	}

    /**
     * Adiciona novos itens do tipo T no final da lista.
     * @param newItem O item a ser adicionado.
     */
	public void append(Item newItem) {
		Cell aux = new Cell(newItem);		
		last.next = aux;
		last = last.next;
	}

    /**
     * Remove itens pelo identificador.
     * @param id O identificador.
     * @return O item.
     */
    public Item remove(long id) {
        Cell aux, antecessor;
        antecessor = first;
        aux = first.next;
        Item item = null;

        while (aux != null) {
            if (aux.item.id() == id) {
                antecessor.next = aux.next;
                
                if (aux == last) last = antecessor;
                
                item = aux.item;
            } else {
                antecessor = aux;
                aux = aux.next;
            }
        }

        return item;
    }
    
    /**
     * Encontra um item pelo identificador.
     * @param id O identificador.
     * @return O item.
     */
    public Item get(long id) {
        Cell aux;
        aux = first.next;
        Item item = null;

        while (aux != null) {
            if (aux.item.id() == id) item = aux.item;
            else aux = aux.next;
        }

        return item;
    }

    /**
     * Retorna TRUE se a lista estiver vazia e FALSE se não estiver vazia.
     * @return O estado da lista.
     */
    public Boolean isEmpty() {
        return first == last;
    }

    /**
     * Imprime todos os itens da lista.
     */
    public void print() {
        Cell aux;
        aux = first.next;

        if (aux == null) {
            System.out.println("The list is empty.");
        } else {
            while (aux != null) {
                System.out.println(aux.item);
                aux = aux.next;
            }
        }
    }    
    
    /**
     * Retorna o tamanho da lista.
     * @param O tamanho da lista.
     */
    public int size() {
    	Cell aux;
        aux = first.next;
        int size = 0;
        if (aux != null) {
            while (aux != null) {
                if(aux.item != null) size++;
                aux = aux.next;
            }
        }
        return size;
    }
}