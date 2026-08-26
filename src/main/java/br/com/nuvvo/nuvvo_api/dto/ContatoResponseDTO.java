package br.com.nuvvo.nuvvo_api.dto;

public record ContatoResponseDTO(
    Long id,
    String nome,
    String email,
    String telefone,
    String cidade
) {
}