package aed2.dao;

import aed2.model.Item;

import aed2.structure.List;

import java.io.IOException;

public interface DAO {
    /**
     * Pega um objeto (Pessoa) pelo identificador.
     * @param id Identificador.
     * @return O objeto.
     * @throws IOException Lançada quando não consegue abrir o arquivo.
     */
    Item get(long id) throws IOException;

    /**
     * Pega todos os objetos.
     * @return A lista de objetos.
     * @throws IOException Lançada quando não consegue abrir o arquivo.
     */
    List get() throws IOException;

    /**
     * Atualiza uma linha do arquivo pelo identificador usando objeto.
     * @param item O objeto.
     * @throws IOException Lançada quando não consegue abrir ou escrever no arquivo.
     */
    void update(Item item) throws IOException;

    /**
     * Adiciona uma nova linha no arquivo usando o objeto.
     * @param item O objeto.
     * @throws IOException Lançada quando não consegue abrir ou escrever no arquivo.
     */
    void save(Item item) throws IOException;

    /**
     * Remove uma linha do arquivo referente ao identificador.
     * @param id O identificador.
     * @throws IOException Lançada quando não consegue abrir ou remover do arquivo.
     */
    void remove(long id) throws IOException;
}