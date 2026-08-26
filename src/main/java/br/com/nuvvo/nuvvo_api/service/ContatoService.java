package br.com.nuvvo.nuvvo_api.service;

import org.springframework.stereotype.Service;

import br.com.nuvvo.nuvvo_api.dto.ContatoRequestDTO;
import br.com.nuvvo.nuvvo_api.dto.ContatoResponseDTO;
import br.com.nuvvo.nuvvo_api.model.Contato;
import br.com.nuvvo.nuvvo_api.repository.ContatoRepository;

@Service
public class ContatoService {

	private ContatoRepository contatoRepository;

	public ContatoService(ContatoRepository contatoRepository) {
		this.contatoRepository = contatoRepository;
	}

	public ContatoResponseDTO salvar(ContatoRequestDTO request) {
		Contato contato = new Contato
				(request.nome(),
				 request.telefone(), 
				 request.email(),
				request.cidade());		
		Contato contatoSalvo = contatoRepository.save(contato);
		
		return new ContatoResponseDTO(
				contatoSalvo.getId(),
				contatoSalvo.getNome(),
				contatoSalvo.getTelefone(),
				contatoSalvo.getEmail(),
				contatoSalvo.getCidade());
	}
}
