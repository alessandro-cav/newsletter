package br.com.newsletter.forum.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "TB_ASSINANTE")
public class Assinante {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_ASSINANTE")
	public Long id;
	
	@Column(name = "NOME")
	public String nome ;
	
	@Column(name = "SOBRENOME")
	public String sobrenome;
	
	@Column(name = "NR_CPF")
	public String cpf;
	
	@Column(name = "EMAIL")
	private String email;
	
	@Column(name = "ATIVO")
	private Boolean ativo;
}

