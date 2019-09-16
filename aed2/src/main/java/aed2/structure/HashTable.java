package aed2.structure;

import aed2.model.Item;

public class HashTable {
	/**
	 * O tamanho da Hash Table.
	 */
	private int size;
	/**
	 * A lista do tipo T.
	 */
	private List[] lists;

	/**
	 * Construtor.
	 * @param size O tamanho da lista.
	 */
	public HashTable(int size){
		this.size = size;
		lists = new List[size];
		while(--size >= 0) lists[size] = new List();	
	}

	/**
	 * Função hash que gera a chave da tabela.
	 * @param id O identificador do item.
	 * @return A chave da tabela.
	 */
	private long hash(long id){ 
		return id%size;
	}

	/**
	 * Adiciona o item na tabela.
	 * @param newItem O item.
	 * @return A hash da tabela.
	 */
	public long put(Item newItem){
		long id = newItem.id();
		long hash = hash(id);
		List list = lists[(int) id];

		if(list.get(id) == null) {
			list.append(newItem);
			return hash;
		}

		return -1;
	}

	/**
	 * Retorna um item pelo identificador.
	 * @param id O identificador do item.
	 * @return O item.
	 */
	public Item get(long id){
		Item aux = null;
		List list = lists[(int) hash(id)];

		if(!list.isEmpty()) aux = list.get(id);

		return aux;
	}

	/**
	 * Imprime todos os items das listas que estão na tabela.
	 */
	public void print(){
		for(int i=0; i<size; i++) {
			lists[i].print();
		}
	}
}