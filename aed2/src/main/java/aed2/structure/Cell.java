package aed2.structure;

import aed2.model.Item;

/**
 * Classe que define a celula.
 */
public class Cell {
		/**
		 * O item da celula.
		 */
		public Item item;
		/**
		 * A próxima célula.
		 */
		public Cell next;
		
		/**
		 * Construtor.
		 * @param item O item.
		 */
		Cell(Item item){
			this.item = item;
			next = null;
		}
}