package br.com.msaorim.forum.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.msaorim.forum.entities.Curso;
import br.com.msaorim.forum.entities.Topico;

@RestController
@RequestMapping(value = "/topicos")
public class TopicosController {
	
	@GetMapping
	public List<Topico> findAll(){
		
		var tp1 = new Topico("Dúvida", "Dúvida com Spring", new Curso("Spring", "Programação"));
		var tp2 = new Topico("Entidade", "Dúvida com Anotations", new Curso("Spring", "Programação"));
		
		List<Topico> lista = new ArrayList<>();
		lista.add(tp1);
		lista.add(tp2);
		
		return lista;
		
	}

}
