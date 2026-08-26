package br.com.nuvvo.nuvvo_api.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record ContatoRequestDTO(

		@NotBlank(message = "O nome é obrigatório") 
		@Size(max = 120, message = "O nome deve ter no máximo 120 caracteres") 
		String nome,

		@NotBlank(message = "O e-mail é obrigatório") 
		@Email(message = "Informe um e-mail válido")
		@Size(max = 250, message = "O e-mail deve conter no máximo 250 caracteres")
		String email,

		@NotBlank(message = "O telefone é obrigatório") 
		@Size(max = 20, message = "O telefone deve ter no máximo 20 caracteres")
		String telefone,
		
		@NotBlank(message = "A cidade é obrigatória") 
		@Size(max = 120, message = "A cidade deve ter no máximo 40 caracteres")
		String cidade
	){

}
