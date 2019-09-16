package aed2.dao;

import aed2.model.Person;

public class PersonDAO extends AbstractDAO {
	/**
	 * Construtor.
	 */
    public PersonDAO(String fileName) {
		super(fileName);
	}

	/**
     * {@inheritDoc}
     */
    @Override
    protected Person factory(java.util.List<String> args) {
        return new Person(
            Long.parseLong((String) args.get(0)),
            (String) args.get(1), 
            (String) args.get(2), 
            Integer.parseInt((String) args.get(3)), 
            (String) args.get(4), 
            (String) args.get(5), 
            (String) args.get(6)
        );
    }

}