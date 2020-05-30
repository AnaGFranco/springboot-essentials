package br.com.devdojo.model;

import static java.util.Arrays.asList;

import java.util.ArrayList;
import java.util.List;

public class Student {

	private int id;
	private String name;
	public static List<Student> studentList;
	
	static{
		studentRepository();
	}
	
	
	public Student(int id, String name) {
		this.setId(id);
		this.name = name;
	}

	public Student() {
	}
	
	private static void studentRepository() {
		studentList = new ArrayList<>(asList(new Student(1,"Ana"), new Student(2,"Gabriela")));
	}
	
	public Student(String name) {
		this.name = name;	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}

