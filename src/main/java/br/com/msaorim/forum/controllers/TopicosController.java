package br.com.msaorim.forum.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.msaorim.forum.entities.Curso;
import br.com.msaorim.forum.entities.Topico;
import br.com.msaorim.forum.entities.dto.TopicoDto;
import br.com.msaorim.forum.repositories.TopicoRepository;

@RestController
@RequestMapping(value = "/topicos")
public class TopicosController {

	@Autowired
	private TopicoRepository topicoRepository;
	
	@GetMapping
	public List<Topico> findAll() {
		return topicoRepository.findAll();
	}

	@GetMapping(value = "/dto")
	public List<TopicoDto> find() { 
		return TopicoDto.toDto(topicoRepository.findAll());
	}
}
