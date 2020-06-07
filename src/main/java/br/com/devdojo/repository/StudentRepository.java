package br.com.devdojo.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import br.com.devdojo.model.Student;


// retira CrudRepository do extends e extends PagingAndSortingRepository para realizar a paginação, o mesmo tem o extends CrudRepository

public interface StudentRepository extends PagingAndSortingRepository<Student,Long>{
	
	List<Student> findByNameIgnoreCaseContaining(String name);
}


/** PagingAndSortingRepository
 * 
 *   Sorting -> Listar  informação de forma ordenada
 * 
	Sorting: http://localhost:8080/students?sort=name,asc -> buscar e ordem alfabetica pelo compo "nome"
	Exemplo com mais de um campo: http://localhost:8080/students?sort=name,desc&students?sort=email,asc 

 *
 * Paging -> realiza a paginação de conteudo
 * 
 	Paging:  http://localhost:8080/students?page=1 -> percorrer paginas
 
 *
 **/
