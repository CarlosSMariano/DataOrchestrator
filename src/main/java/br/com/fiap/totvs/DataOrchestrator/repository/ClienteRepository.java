package br.com.fiap.totvs.DataOrchestrator.repository;

import br.com.fiap.totvs.DataOrchestrator.model.ClienteEntity;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClienteRepository extends ListCrudRepository<ClienteEntity, Long> {

    Optional<ClienteEntity> findByNome(String nome);
}
