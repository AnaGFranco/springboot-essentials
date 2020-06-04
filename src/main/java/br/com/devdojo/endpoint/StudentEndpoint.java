package br.com.devdojo.endpoint;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jayway.jsonpath.internal.JsonContext;

import br.com.devdojo.error.ResourceNotFoundException;
import br.com.devdojo.model.Student;
import br.com.devdojo.repository.StudentRepository;

/**
 * Curso DevDojo - SpringBoot
 * 
 * @author Ana Gabriela Franco
 *
 */

@RestController
@RequestMapping("students")
@ComponentScan(basePackageClasses = { StudentRepository.class })

public class StudentEndpoint {

	private final StudentRepository studentDAO;

	@Autowired
	public StudentEndpoint(StudentRepository studentDAO) {
		super();
		this.studentDAO = studentDAO;
	}

	@GetMapping
	public ResponseEntity<?> listAll() {

		return new ResponseEntity<>(studentDAO.findAll(), HttpStatus.OK);
	}

	@GetMapping(path = "/{id}")
	public ResponseEntity<?> getStudantById(@PathVariable("id") Long id) throws JSONException {
		
		verifyIfStudentExists(id);
		
		Student student = studentDAO.findById(id).get();

		return new ResponseEntity<>(student, HttpStatus.OK);
	}

	@GetMapping(path = "/findByName/{name}")
	public ResponseEntity<?> findStudentByName(@PathVariable String name) {
		return new ResponseEntity<>(studentDAO.findByNameIgnoreCaseContaining(name), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<?> save(@RequestBody Student student) {
		return new ResponseEntity<>(studentDAO.save(student), HttpStatus.CREATED);
	}

	@DeleteMapping(path = "/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		verifyIfStudentExists(id);
		studentDAO.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);

	}

	@PutMapping
	public ResponseEntity<?> update(@RequestBody Student student) {
		verifyIfStudentExists(student.getId());
		studentDAO.save(student);
		return new ResponseEntity<>(HttpStatus.OK);

	}

	private void verifyIfStudentExists(Long id) {
		Optional<Student> student = studentDAO.findById(id);
		if (!student.isPresent()) {
		       throw new ResourceNotFoundException("Student not found id: " + id);

		}
	}
}
