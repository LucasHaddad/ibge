package aed2.model;

import aed2.model.enumeration.Area;
import aed2.model.enumeration.CivilStatus;
import aed2.model.enumeration.Race;
import aed2.model.enumeration.Sex;

/**
 * Define uma pessoa.
 */
public class Person implements Item {
	/**
	 * Identificador de pessoa.
	 */
	private long id; 
	/**
	 * Nome de pessoa.
	 */
	private String name; 
	/**
	 * Sexo de pessoa.
	 */
	private Sex sex;
	/**
	 * Idade de pessoa.
	 */
	private int age;
	/**
	 * Ã�rea (Rural ou Urbana) de pessoa.
	 */
	private Area area; 
	/**
	 * Estado civil de pessoa.
	 */
	private CivilStatus civilStatus;
	/**
	 * Etnia de pessoa.
	 */
	private Race race;
	
	public Person(long id, String name, String sex, int age, String area, String civilStatus, String race) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.sex = Sex.fromString(sex);
		this.area = Area.fromString(area);
		this.civilStatus = CivilStatus.fromString(civilStatus);
		this.race = Race.fromString(race);
	}

	@Override
	public long id() {
		return id; 
	} 

	public String name() {
		return name; 
	} 

	public String sex() {
		return sex.sex;
	}

	public int age() {
		return age;
	}

	public String area() {
		return area.area; 
	} 

	public String civilStatus() {
		return civilStatus.status;
	}

	public String race() {
		return race.race;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toData() {
		return id + ";" + name + ";" + sex + ";" + age + ";" + civilStatus + ";" + race;
	}

	/**
	 * {@inheritDoc}
	 */
	public String toString() {
		return "ID: " + id + ", NAME: " + name + ", SEX: " + sex + ", AGE: " + age + ", CIVIL STATUS: " + civilStatus + ", RACE: " + race;
	}
}
