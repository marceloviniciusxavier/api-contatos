package br.com.nuvvo.nuvvo_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.nuvvo.nuvvo_api.model.Contato;


public interface ContatoRepository extends JpaRepository<Contato, Long>{

}
