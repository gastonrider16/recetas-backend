package com.tpscrum.apirest.repositories;

import com.tpscrum.apirest.entities.Ingrediente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredienteRepository extends BaseRepository<Ingrediente, Integer>{

    @Query(value = "SELECT a FROM Ingrediente a WHERE UPPER(a.nombre) = UPPER(:filter)")
    Page<Ingrediente> search (@Param("filter") String filter, Pageable pageable);

    /*
    @Query(value = "SELECT a FROM Ingrediente a WHERE a.nombre LIKE %:filter% OR a.descripcion LIKE %:filter%")
    Page<Ingrediente> search (@Param("filter") String filter, Pageable pageable);
    
    @Query (
        value = "SELECT * FROM ingrediente WHERE nombre LIKE %:filter% OR descripcion LIKE %:filter%",
        countQuery = "SELECT count(*) FROM ingrediente",
        nativeQuery = true
     )
    Page<Ingrediente> searchNative (@Param("filter") String filter, Pageable pageable);*/
}
