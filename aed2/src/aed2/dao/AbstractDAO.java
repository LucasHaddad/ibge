package aed2.dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.io.BufferedWriter;
import java.io.IOException;

import aed2.model.Item;
import aed2.structure.*;

/**
 * Implementação de DAO para arquivo.
 */
public abstract class AbstractDAO implements DAO {
	/**
     * Nome do arquivo.
     */
    protected String fileName;
    
    /**
     * Constrói o objeto (no nosso caso Pessoa).
     */
    protected abstract Item factory(java.util.List<String> args);
    
    /**
	 * Construtor.
	 */
    public AbstractDAO(String fileName) {
    	this.fileName = System.getProperty("user.dir") + fileName;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("resource")
	@Override
    public Item get(long id) throws IOException {
        FileReader fileReader = new FileReader(fileName);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line = null;
        while ((line = bufferedReader.readLine()) != null) {
            java.util.List<String> args = new ArrayList<>();
            for (String piece : line.split("\\;")) {
            	args.add(piece);
            }
            if (Long.parseLong(args.get(0)) == id) {
                fileReader.close();
                return factory(args);
            }
        }
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List get() throws IOException {
	    FileReader fileReader = new FileReader(fileName);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        List list = new List();
        String line = null;
        while ((line = bufferedReader.readLine()) != null) {
            java.util.List<String> args = new ArrayList<>();
            for (String piece : line.split("\\;")) {
            	args.add(piece);
            }
            list.append(factory(args));
        }
        fileReader.close();
        return list;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void update(Item item) throws IOException {
        FileReader fileReader = new FileReader(fileName);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        StringBuffer inputBuffer = new StringBuffer();
        String line = null;
        while ((line = bufferedReader.readLine()) != null) {
            java.util.List<String> args = new ArrayList<>();
            for (String piece : line.split(";")) {
            	args.add(piece);
            }
            if (item.id() == Long.parseLong(args.get(0))) {
                inputBuffer.append(item.toData() + "\n");
            } else {
                inputBuffer.append(line + "\n");                
            }
        }
        fileReader.close();
        FileOutputStream fileStream = new FileOutputStream(fileName);
        OutputStreamWriter outputWriter = new OutputStreamWriter(fileStream);
        BufferedWriter bufferredWriter = new BufferedWriter(outputWriter);
        String toWrite = inputBuffer.toString();
        bufferredWriter.write(toWrite, 0, toWrite.length());
        bufferredWriter.newLine();
        fileStream.close();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void save(Item item) throws IOException {
        FileOutputStream fileStream = new FileOutputStream(fileName, true);
        OutputStreamWriter outputWriter = new OutputStreamWriter(fileStream);
        BufferedWriter bufferredWriter = new BufferedWriter(outputWriter);
        bufferredWriter.write(item.toData());
        bufferredWriter.newLine();
        fileStream.close();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void remove(long id) throws IOException {
        FileReader fileReader = new FileReader(fileName);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        StringBuffer inputBuffer = new StringBuffer();
        String line = null;
        while ((line = bufferedReader.readLine()) != null) {
            java.util.List<String> args = new ArrayList<>();
            for (String piece : line.split(";")) {
            	args.add(piece);
            }
            if (id != Long.parseLong(args.get(0))) {
                inputBuffer.append(line + "\n");               
            }
        };
        fileReader.close();
        FileOutputStream fileStream = new FileOutputStream(fileName);
        OutputStreamWriter outputWriter = new OutputStreamWriter(fileStream);
        BufferedWriter bufferredWriter = new BufferedWriter(outputWriter);
        String toWrite = inputBuffer.toString();
        bufferredWriter.write(toWrite, 0, toWrite.length());
        bufferredWriter.newLine();
        fileStream.close();
    }
}