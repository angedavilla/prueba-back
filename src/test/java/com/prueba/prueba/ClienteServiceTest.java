package com.prueba.prueba;

import com.prueba.prueba.Entity.ClienteEntity;
import com.prueba.prueba.Entity.Dto.ClienteDto;
import com.prueba.prueba.Repository.ClienteRepository;
import com.prueba.prueba.Service.Imp.ClienteServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

// Service Test
@ExtendWith(MockitoExtension.class)
public class ClienteServiceTest {

    @Mock
    private ClienteRepository clienteRepository;

    @InjectMocks
    private ClienteServiceImpl clienteService;

    @Test
    public void testGetCliente() {
        // Datos
        ClienteEntity clienteTest = new ClienteEntity();
        clienteTest.setPrimerNombre("Angel");
        clienteTest.setSegundoNombre("David");
        clienteTest.setPrimerApellido("Villamil");
        clienteTest.setSegundoApellido("Mendez");
        clienteTest.setTelefono("321654987");
        clienteTest.setDireccion("Calle 123");
        clienteTest.setCiudadResidencia("Bogotá");

        //Servicio
        ClienteDto response = clienteService.consultarCliente("C", "23445322");

        //respuesta
        assertEquals("Angel", clienteTest.getPrimerNombre());
        assertEquals("David", clienteTest.getSegundoNombre());
        assertEquals("Villamil", clienteTest.getPrimerApellido());
        assertEquals("Mendez", clienteTest.getSegundoApellido());
        assertEquals("321654987", clienteTest.getTelefono());
        assertEquals("Calle 123", clienteTest.getDireccion());
        assertEquals("Bogotá", clienteTest.getCiudadResidencia());
    }

}
