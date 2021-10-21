package br.com.newsletter.forum.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.newsletter.forum.entity.Assinante;

public interface AssinanteRepository extends JpaRepository<Assinante, Long> {

	Optional<Assinante> findByCpfAndEmail(String cpf, String email);

}
