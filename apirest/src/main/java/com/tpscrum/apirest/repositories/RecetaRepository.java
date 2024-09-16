package com.tpscrum.apirest.repositories;

import com.tpscrum.apirest.entities.Receta;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecetaRepository extends BaseRepository<Receta, Integer>{

    @Query("SELECT r FROM Receta r WHERE NOT EXISTS (SELECT i FROM Ingrediente i WHERE i.nombre NOT IN :filters AND i MEMBER OF r.ingredientes)")
    Page<Receta> findByIngredientesNombreIn(@Param("filters") List<String> filters, Pageable pageable);

}
