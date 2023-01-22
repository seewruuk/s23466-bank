package com.example.s23466bank.service;

import com.example.s23466bank.exception.ValidationException;
import com.example.s23466bank.model.Client;
import com.example.s23466bank.repository.ClientRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;


class ClientServiceTest {

    private ClientRepository clientRepository = mock(ClientRepository.class);
    private ClientService clientService = new ClientService(clientRepository);

    @Test
    void shoudlCreateCar() throws Exception {
        Client client = new Client(0, "Prosze", "Otrzy",333);
        assertDoesNotThrow(() -> clientRepository.addClient(client));

    }


    @ParameterizedTest
    @MethodSource("data")
    void shouldThrowValidationException(Client client, String message) {
        ValidationException validationException = assertThrows(ValidationException.class, () -> clientService.addClientToDB(client));
        assertEquals(validationException.getMessage(), message);
    }

    private static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of(new Client(0, null, "surname", 5), "First name is null"),
                Arguments.of(new Client(0, "firstname", null, 10), "Surname is null"),
                Arguments.of(new Client(0, "", "surname", 10), "First name is empty"),
                Arguments.of(new Client(0, "firstname", "", 10), "Surname is empty")
        );
    }


}