package br.com.devdojo.javaclient;

import java.util.List;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import br.com.devdojo.model.PageableResponse;
import br.com.devdojo.model.Student;

public class JavaClientDAO {
    private RestTemplate restTemplate = new RestTemplateBuilder()
            .rootUri("http://localhost:8080/v1/protected/students")
            .basicAuthentication("ana", "ana")
            .build();
    private RestTemplate restTemplateAdmin = new RestTemplateBuilder()
            .rootUri("http://localhost:8080/v1/admin/students")
            .basicAuthentication("ana", "ana")
            .build();

    public Student findById(long id) {
        return restTemplate.getForObject("/{id}", Student.class, id);
//        ResponseEntity<Student> forEntity = restTemplate.getForEntity("/{id}", Student.class, 1);
    }

    public List<Student> listAll() {
        ResponseEntity<PageableResponse<Student>> exchange = restTemplate.exchange("/", HttpMethod.GET, null,
                new ParameterizedTypeReference<PageableResponse<Student>>() {
                });
        return exchange.getBody().getContent();
    }
    
    public Student save(Student student) {
        ResponseEntity<Student> exchangePost = restTemplateAdmin.exchange("/",
                HttpMethod.POST, new HttpEntity<>(student, createJSONHeader()), Student.class);
        return exchangePost.getBody();
    }



    private static HttpHeaders createJSONHeader() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return headers;
    }
}
