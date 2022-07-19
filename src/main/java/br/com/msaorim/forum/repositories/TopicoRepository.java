package br.com.msaorim.forum.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.msaorim.forum.entities.Topico;

@Repository
public interface TopicoRepository extends JpaRepository<Topico, Long> {

	List<Topico> findByCursoNome(String string);

}
