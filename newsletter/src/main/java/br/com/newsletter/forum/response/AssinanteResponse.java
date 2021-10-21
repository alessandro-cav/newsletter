package br.com.newsletter.forum.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AssinanteResponse {

	private String situacao;

	public static AssinanteResponse TransformaEmDto(boolean valor) {
		String situacao = "Assinatura cancelada com sucesso!!!";
		if (valor) {
			situacao = "Assinatura ativada com sucesso!!!";
		}
		return new AssinanteResponse(situacao);
	}

}
