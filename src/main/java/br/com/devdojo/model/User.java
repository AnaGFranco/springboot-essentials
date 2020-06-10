package br.com.devdojo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * 
 * @author Ana Gabriela
 *
 */

@Entity   //@Entity serve para criar a tabela no banco de dados
public class User extends AbstractEntity {

	
	private static final long serialVersionUID = -3282043880381124181L;
	
	@NotEmpty
	@Column(unique = true)
	private String username;
	@NotEmpty
	@JsonIgnore // password não ficar navegandosword
	private String password;
	@NotEmpty
	private String name;
	@NotEmpty
	private boolean admin;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isAdmin() {
		return admin;
	}
	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	
}
