package br.com.msaorim.forum.controllers;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.msaorim.forum.entities.Topico;
import br.com.msaorim.forum.entities.dto.DetalheTopicoDto;
import br.com.msaorim.forum.entities.dto.TopicoDto;
import br.com.msaorim.forum.entities.forms.AtualizacaoTopicoForm;
import br.com.msaorim.forum.entities.forms.TopicoForm;
import br.com.msaorim.forum.repositories.CursoRepository;
import br.com.msaorim.forum.repositories.TopicoRepository;

@RestController
@RequestMapping(value = "/topicos")
public class TopicosController {

	@Autowired
	private TopicoRepository topicoRepository;
	@Autowired
	private CursoRepository cursoRepository;
	
	@GetMapping
	public List<Topico> findAll() {
		return topicoRepository.findAll();
	}

	@GetMapping(value = "/dto")
	public List<TopicoDto> find() { 
		return TopicoDto.toDto(topicoRepository.findAll());
	}
	
	@GetMapping(value = "/curso")
	public List<Topico> findByCurso(String nomeCurso){
		return topicoRepository.findByCursoNome(nomeCurso);
	}
	
	@PostMapping
	@Transactional
	public ResponseEntity<TopicoDto> cadastrar(@RequestBody @Valid TopicoForm form, UriComponentsBuilder uriBuillder) {
		Topico topico = form.converter(cursoRepository);
		topicoRepository.save(topico);
		URI uri = uriBuillder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
		return ResponseEntity.created(uri).body(new TopicoDto(topico));
	}
	@PutMapping(value = "/{id}")
	@Transactional
	public ResponseEntity<TopicoDto> atualizar(@PathVariable long id, @RequestBody @Valid AtualizacaoTopicoForm form){
		Optional<Topico> obj = topicoRepository.findById(id);
		if(obj.isPresent()) {
			Topico topico = form.atualizar(id, topicoRepository);			
			return ResponseEntity.ok(new TopicoDto(topico));
		}
		return ResponseEntity.notFound().build();
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<DetalheTopicoDto> findById(@PathVariable long id){
		Optional<Topico> obj = topicoRepository.findById(id);
		if(obj.isPresent()) {
			return ResponseEntity.ok(new DetalheTopicoDto(obj.get()));
		}
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping(value = "/{id}")
	@Transactional
	public ResponseEntity remover(@PathVariable long id){
		Optional<Topico> obj = topicoRepository.findById(id);
		if(obj.isPresent()) {
		topicoRepository.deleteById(id);
		return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}
}
