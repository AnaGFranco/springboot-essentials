package br.com.devdojo.endpoint;

import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
@RequestMapping("v1")
@ComponentScan(basePackageClasses = { StudentRepository.class })

public class StudentEndpoint {

	private final StudentRepository studentDAO;

	@Autowired
	public StudentEndpoint(StudentRepository studentDAO) {
		super();
		this.studentDAO = studentDAO;
	}

	@GetMapping(path = "protected/students")
	public ResponseEntity<?> listAll(Pageable pegeable) { // obj Pageable para paginação

		return new ResponseEntity<>(studentDAO.findAll(pegeable), HttpStatus.OK);
	}

	@GetMapping(path = "protected/students/{id}")
	public ResponseEntity<?> getStudantById(@PathVariable("id") Long id) throws JSONException {
		
		verifyIfStudentExists(id);
		
		Student student = studentDAO.findById(id).get();

		return new ResponseEntity<>(student, HttpStatus.OK);
	}

	@GetMapping(path = "protected/students/findByName/{name}")
	public ResponseEntity<?> findStudentByName(@PathVariable String name) {
		return new ResponseEntity<>(studentDAO.findByNameIgnoreCaseContaining(name), HttpStatus.OK);
	}

	@PostMapping(path = "admin/students")
	@Transactional(rollbackOn = Exception.class) //@Valid validar dados preenchidos no body
	public ResponseEntity<?> sasve(@Valid @RequestBody Student student) {
		return new ResponseEntity<>(studentDAO.save(student), HttpStatus.CREATED);
	}

	@DeleteMapping(path = "admin/students/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		verifyIfStudentExists(id);
		studentDAO.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PutMapping(path = "admin/students")
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
