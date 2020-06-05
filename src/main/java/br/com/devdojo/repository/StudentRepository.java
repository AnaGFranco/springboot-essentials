package br.com.devdojo.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import br.com.devdojo.model.Student;


// retira CrudRepository do extends e extends PagingAndSortingRepository para realizar a paginação, o mesmo tem o extends CrudRepository

public interface StudentRepository extends PagingAndSortingRepository<Student,Long>{
	
	List<Student> findByNameIgnoreCaseContaining(String name);
}
