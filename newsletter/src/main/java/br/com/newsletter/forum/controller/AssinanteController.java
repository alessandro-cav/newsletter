package br.com.newsletter.forum.controller;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.newsletter.forum.entity.Assinante;
import br.com.newsletter.forum.request.AssintanteRequest;
import br.com.newsletter.forum.request.CpfAndEmailRequest;
import br.com.newsletter.forum.response.AssinanteResponse;
import br.com.newsletter.forum.service.AssinanteService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api
@RestController
@RequestMapping("/assinantes")
public class AssinanteController {

	private AssinanteService assinanteService;

	public AssinanteController(AssinanteService assinanteService) {
		this.assinanteService = assinanteService;
	}
	
	@ApiOperation(value = "Criar assinatura")
	@PostMapping("/criar/assinatura")
	public ResponseEntity<Assinante> criarAssinatura(@RequestBody @Valid AssintanteRequest assintanteRequest){
		Assinante assinante = this.assinanteService.criarAssinatura(assintanteRequest);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(assinante.getId())
				.toUri();
		return ResponseEntity.created(location).build();
	}
	
	@ApiOperation(value = "Cancelar assinatura")
	@PostMapping("/cancelar/assinatura")
	public ResponseEntity<AssinanteResponse> cancelarAssinatura(@RequestBody @Valid CpfAndEmailRequest cpfAndEmailrequest){
		AssinanteResponse assinanteResponse = this.assinanteService.cancelarAssinatura(cpfAndEmailrequest);
		return ResponseEntity.ok(assinanteResponse);
	}
	
	@ApiOperation(value = "Ativar assinatura")
	@PostMapping("/ativar/assinatura")
	public ResponseEntity<AssinanteResponse> ativarAssinatura(@RequestBody @Valid CpfAndEmailRequest cpfAndEmailrequest){
		AssinanteResponse assinanteResponse = this.assinanteService.ativarAssinatura(cpfAndEmailrequest);
		return ResponseEntity.ok(assinanteResponse);
	}
	
}
