package br.com.devdojo.adpater;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.List;

/**
 * @author Ana Gabriela
 * 
 * Class responsavel pela mudança de pagição
 */
@Configuration
public class SpringBootEssentialsAdapter  implements  WebMvcConfigurer {

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        PageableHandlerMethodArgumentResolver phmar = new PageableHandlerMethodArgumentResolver();
       
        phmar.setFallbackPageable(PageRequest.of(0, 5)); // quantidade de paginas e conteudo
        argumentResolvers.add(phmar);
    }
}

// http://localhost:8080/students?sort=name,asc -> buscar e ordem alfabetica pelo compo "nome"
// http://localhost:8080/students?page=1 -> percorrer paginas