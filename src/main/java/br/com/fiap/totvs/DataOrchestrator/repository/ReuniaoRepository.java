package br.com.fiap.totvs.DataOrchestrator.repository;

import br.com.fiap.totvs.DataOrchestrator.model.ReuniaoEntity;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReuniaoRepository extends ListCrudRepository<ReuniaoEntity, Long> {

    @Modifying
    @Query("DELETE FROM REUNIAO WHERE CLIENTE_ID_CLI = :clienteId")
    void deleteByClienteId(@Param("clienteId") Long clienteId);

    List<ReuniaoEntity> findByClienteId(Long clienteId);
}
