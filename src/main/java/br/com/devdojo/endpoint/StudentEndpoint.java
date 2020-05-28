package br.com.devdojo.endpoint;

import static java.util.Arrays.asList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.devdojo.model.Student;


/**
 * Curso DevDojo - SpringBoot
 * 
 * @author Ana Gabriela Franco
 *
 */

@RestController  
@RequestMapping("student")

public class StudentEndpoint {
	
	@Autowired
	@RequestMapping(method = RequestMethod.GET,path = "/list")
	public List<Student> listAll(){
		
		//System.out.println("--------" + dateUtil.formatLocalDateTimeToDateBaseStyle(LocalDateTime.now()));
		
		return asList(new Student("Ana"), new Student("Gabriela"));
	}

	
}
