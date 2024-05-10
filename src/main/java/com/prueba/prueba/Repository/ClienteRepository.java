package com.prueba.prueba.Repository;

import com.prueba.prueba.Entity.ClienteEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends CrudRepository<ClienteEntity, Long> {

    ClienteEntity findByTipoDocumentoAndNumeroDocumento(String tipoDocumento, String numeroDocumento);
}
