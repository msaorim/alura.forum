package br.com.msaorim.forum.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.msaorim.forum.entities.Topico;

@Repository
public interface TopicoRepository extends JpaRepository<Topico, Long> {

}
