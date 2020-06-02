package br.com.devdojo.model;

import javax.persistence.Entity;


/**
 * @author Ana Gabriela
 * 
 */

@Entity
public class Student extends AbstractEntity{

	private static final long serialVersionUID = 5094168224898662783L;
	private String name;
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}


