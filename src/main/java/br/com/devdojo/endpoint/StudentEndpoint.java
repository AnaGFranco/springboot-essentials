package br.com.devdojo.endpoint;

import static java.util.Arrays.asList;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.devdojo.model.Student;
import br.com.devdojo.util.DateUtil;


/**
 * Curso DevDojo - SpringBoot
 * 
 * @author Ana Gabriela Franco
 *
 */

@RestController  
@RequestMapping("students")

public class StudentEndpoint {
	
	private final DateUtil dateUtil;
	
	
	@Autowired
	public StudentEndpoint(DateUtil dateUtil) {
		this.dateUtil = dateUtil;
	}

	
	@RequestMapping(method = RequestMethod.GET,path = "/list")
	public List<Student> listAll(){
		
		//System.out.println("--------" + dateUtil.formatLocalDateTimeToDateBaseStyle(LocalDateTime.now()));
		
		return asList(new Student("Ana"), new Student("Gabriela"));
	}

	
}
