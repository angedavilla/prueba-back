package com.prueba.prueba.Service;


import com.prueba.prueba.Entity.Dto.ClienteDto;
import org.springframework.http.ResponseEntity;

public interface ClienteService {

   ClienteDto consultarCliente(String tipoDocumento, String numeroDocumento);

}
