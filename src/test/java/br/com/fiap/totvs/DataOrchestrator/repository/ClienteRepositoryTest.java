package br.com.fiap.totvs.DataOrchestrator.repository;

import br.com.fiap.totvs.DataOrchestrator.model.ClienteEntity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jdbc.test.autoconfigure.DataJdbcTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.Date;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJdbcTest
@ActiveProfiles("test")
class ClienteRepositoryTest {

    @Autowired
    private ClienteRepository clienteRepository;

    @Test
    @DisplayName("Deve retornar um cliente com sucesso ao buscar por um nome existente")
    void findByNomeComSucesso() {
        ClienteEntity cliente = new ClienteEntity(null, "TOTVS SP", new Date());
        clienteRepository.save(cliente);

        Optional<ClienteEntity> resultado = clienteRepository.findByNome("TOTVS SP");

        assertTrue(resultado.isPresent(), "O Cliente deve ter sido encontrado.");
        assertEquals("TOTVS SP", resultado.get().nome(), "O nome do cliente deve ser idêntico.");
        assertNotNull(resultado.get().id(), "O id gerado não deve ser nulo.");

    }

    @Test
    @DisplayName("Deve retornar optional vazio ao não encontrar nehum cliente")
    void findByNomeNaoEncontrado(){

        Optional<ClienteEntity> resultado = clienteRepository.findByNome("Cliente inexistente.");

        assertTrue(resultado.isEmpty(), "Não deveria retornar nenhum cliente para um nome inexistente.");

    }
}