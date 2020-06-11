package br.com.devdojo.javaclient;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import br.com.devdojo.model.PagebleResponse;
import br.com.devdojo.model.Student;

public class JavaSpringClientTest {
    public static void main(String[] args) {

    	RestTemplate restTemplate = new RestTemplateBuilder()
    			.rootUri("http://localhost:8080/v1/protected/students")
    			.basicAuthentication("ana","ana").build();
    	Student student = restTemplate.getForObject("/1", Student.class);
    	ResponseEntity<Student> forEntity = restTemplate.getForEntity("/1", Student.class);
    	System.out.println(student);
    	System.out.println(forEntity.getBody());
//    	Student[] students = restTemplate.getForObject("/1", Student[].class);
//    	System.out.println(Arrays.toString(students));
//    	ResponseEntity<List<Student>> exchange = restTemplate.exchange("/", HttpMethod.GET, null,
//    			new ParameterizedTypeReference<List<Student>>() {});
//    	System.out.println(exchange.getBody());

    	
    	ResponseEntity<PagebleResponse<Student>> exchange = restTemplate.exchange("/", HttpMethod.GET, null,
    			new ParameterizedTypeReference<PagebleResponse<Student>>() {});
    	System.out.println(exchange);
    	
    
    }

}