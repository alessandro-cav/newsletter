package br.com.newsletter.forum.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.br.CPF;

import lombok.Data;

@Data
public class CpfAndEmailRequest {

	@NotBlank(message = "Cpf não deve estar em branco")
	@NotNull(message = " Cpf é obrigatório")
	@CPF(message = "CPF é invalido.")
	public String cpf;

	@NotBlank(message = "Email não deve estar em branco")
	@NotNull(message = " Email é obrigatório")
	@Email(message = "Email é invalido.")
	private String email;

}
