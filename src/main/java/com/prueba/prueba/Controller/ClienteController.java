package com.prueba.prueba.Controller;

import com.prueba.prueba.Entity.Dto.ClienteDto;
import com.prueba.prueba.Service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/clientes")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ClienteController {

    private static final Logger logger = LoggerFactory.getLogger(ClienteController.class);

    @Autowired
    private ClienteService clienteService;

    @GetMapping("/{tipoDocumento}/{numeroDocumento}")
    public ResponseEntity<ClienteDto> getCliente(@PathVariable String tipoDocumento, @PathVariable String numeroDocumento) {
        try {
            logger.debug("Recibida solicitud para consultar cliente con tipoDocumento {} y numeroDocumento {}", tipoDocumento, numeroDocumento);
            ClienteDto cliente = clienteService.consultarCliente(tipoDocumento, numeroDocumento);

            if (cliente == null) {
                logger.debug("Cliente no encontrado con tipoDocumento {} y numeroDocumento {}", tipoDocumento, numeroDocumento);
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente no encontrado");
            }

            logger.debug("Cliente encontrado: {}", cliente);
            return new ResponseEntity<>(cliente, HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            logger.error("Error en la solicitud: {}", e.getMessage());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Error en la solicitud", e);
        } catch (Exception e) {
            logger.error("Error interno del servidor: {}", e.getMessage());
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error interno del servidor", e);
        }
    }

}
