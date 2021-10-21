package br.com.newsletter.forum.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.newsletter.forum.entity.Assinante;
import br.com.newsletter.forum.repository.AssinanteRepository;
import br.com.newsletter.forum.request.AssintanteRequest;
import br.com.newsletter.forum.request.CpfAndEmailRequest;
import br.com.newsletter.forum.response.AssinanteResponse;
import br.com.newsletter.handler.AssinanteNotFoundException;

@Service
public class AssinanteService {

	private AssinanteRepository assinanteRepository;

	public AssinanteService(AssinanteRepository assinanteRepository) {
		this.assinanteRepository = assinanteRepository;
	}

	public Assinante criarAssinatura(AssintanteRequest assintanteRequest) {
		this.verificacaoDuplicidadeAssinante(assintanteRequest.getCpf(), assintanteRequest.getEmail());
		Assinante assinante = AssintanteRequest.TransformaEmDto(assintanteRequest);
		return this.assinanteRepository.save(assinante);
	}

	public AssinanteResponse cancelarAssinatura(CpfAndEmailRequest cpfAndEmailrequest) {
		Optional<Assinante> assinanteOptional = this.validacaoCpfAndEmail(cpfAndEmailrequest);

		if (assinanteOptional.get().getAtivo() == false) {
			throw new AssinanteNotFoundException("Essa assinatura já esta cancelada");
		}
		AssinanteResponse assinanteResponse = AssinanteResponse.TransformaEmDto(false);
		assinanteOptional.get().setAtivo(false);
		this.assinanteRepository.saveAndFlush(assinanteOptional.get());

		return assinanteResponse;
	}

	public AssinanteResponse ativarAssinatura(CpfAndEmailRequest cpfAndEmailrequest) {
		Optional<Assinante> assinanteOptional = this.validacaoCpfAndEmail(cpfAndEmailrequest);

		if (assinanteOptional.get().getAtivo() == true) {
			throw new AssinanteNotFoundException("Essa assinatura já esta ativada");
		}
		AssinanteResponse assinanteResponse = AssinanteResponse.TransformaEmDto(true);
		assinanteOptional.get().setAtivo(true);
		this.assinanteRepository.saveAndFlush(assinanteOptional.get());

		return assinanteResponse;
	}

	private Optional<Assinante> validacaoCpfAndEmail(CpfAndEmailRequest cpfAndEmailrequest) {
		Optional<Assinante> assinanteOptional = this.assinanteRepository.findByCpfAndEmail(cpfAndEmailrequest.getCpf(),
				cpfAndEmailrequest.getEmail());
		if (!assinanteOptional.isPresent()) {
			throw new AssinanteNotFoundException("Não foi possivel encontrar assinatura  para esse cpf: "
					+ cpfAndEmailrequest.getCpf() + " e com esse email: " + cpfAndEmailrequest.getEmail());
		}
		return assinanteOptional;
	}

	private void verificacaoDuplicidadeAssinante(String cpf, String email) {
		Optional<Assinante> assinanteOptional = this.assinanteRepository.findByCpfAndEmail(cpf, email);
		if (!assinanteOptional.isPresent()) {
			throw new AssinanteNotFoundException("Não foi possivel criar assinatura: cpf: " + cpf + " e email: " + email + "já estão sendo usando por outro assinante");
		}

	}
}

