package br.com.newsletter.forum.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.br.CPF;

import br.com.newsletter.forum.entity.Assinante;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AssintanteRequest {

	public Long id;

	@NotBlank(message = "Nome não deve estar em branco")
	@NotNull(message = "Nome é obrigatório")
	public String nome;

	@NotBlank(message = "Sobrenome não deve estar em branco")
	@NotNull(message = "Sobrenome é obrigatório")
	public String sobrenome;

	@NotBlank(message = "Cpf não deve estar em branco")
	@NotNull(message = " Cpf é obrigatório")
	@CPF(message = "CPF é invalido.")
	public String cpf;

	@NotBlank(message = "Email não deve estar em branco")
	@NotNull(message = " Email é obrigatório")
	@Email(message = "Email é invalido.")
	private String email;

	public static Assinante TransformaEmDto(AssintanteRequest assintanteRequest) {
		return new Assinante(assintanteRequest.getId(), assintanteRequest.getNome(), assintanteRequest.getSobrenome(),
				assintanteRequest.getCpf(), assintanteRequest.getEmail(), true);
	}

}

