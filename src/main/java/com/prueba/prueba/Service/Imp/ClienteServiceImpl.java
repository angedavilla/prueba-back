package com.prueba.prueba.Service.Imp;

import com.prueba.prueba.Entity.Dto.ClienteDto;
import com.prueba.prueba.Service.ClienteService;
import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class ClienteServiceImpl implements ClienteService {
    private final Logger logger = LoggerFactory.getLogger(ClienteServiceImpl.class);

    @Override
    public ClienteDto consultarCliente(String tipoDocumento, String numeroDocumento) {
        logger.debug("Consultando cliente con tipoDocumento {} y numeroDocumento {}", tipoDocumento, numeroDocumento);

        if (!tipoDocumento.equals("C") && !tipoDocumento.equals("P")) {
            logger.error("Tipo de documento no válido: {}", tipoDocumento);
            throw new IllegalArgumentException("Tipo de documento no válido");
        }

        if (tipoDocumento.equals("C") && numeroDocumento.equals("23445322")) {
            ClienteDto clienteDTO = new ClienteDto();
            clienteDTO.setPrimerNombre("Angel");
            clienteDTO.setSegundoNombre("David");
            clienteDTO.setPrimerApellido("Villamil");
            clienteDTO.setSegundoApellido("Mendez");
            clienteDTO.setTelefono("321654987");
            clienteDTO.setDireccion("Calle 123");
            clienteDTO.setCiudadResidencia("Bogotá");

            logger.debug("Cliente encontrado: {}", clienteDTO);
            return clienteDTO;
        } else {
            logger.error("Cliente no encontrado con tipoDocumento {} y numeroDocumento {}", tipoDocumento, numeroDocumento);
            throw new IllegalArgumentException("Cliente no encontrado");
        }
    }
}
