package br.com.nuvvo.nuvvo_api.controller;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.nuvvo.nuvvo_api.dto.ContatoRequestDTO;
import br.com.nuvvo.nuvvo_api.dto.ContatoResponseDTO;
import br.com.nuvvo.nuvvo_api.service.ContatoService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/contatos")
public class ContatoController {

    private final ContatoService contatoService;

    public ContatoController(ContatoService contatoService) {
        this.contatoService = contatoService;
    }

    @PostMapping
    public ResponseEntity<ContatoResponseDTO> salvar(
        @Valid @RequestBody ContatoRequestDTO request
    ) {
        ContatoResponseDTO response = contatoService.salvar(request);

        URI location = ServletUriComponentsBuilder
            .fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(response.id())
            .toUri();

        return ResponseEntity.created(location).body(response);
    }
}
