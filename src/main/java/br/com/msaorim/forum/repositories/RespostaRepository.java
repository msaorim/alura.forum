package br.com.msaorim.forum.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.msaorim.forum.entities.Resposta;

@Repository
public interface RespostaRepository extends JpaRepository<Resposta, Long> {

}
