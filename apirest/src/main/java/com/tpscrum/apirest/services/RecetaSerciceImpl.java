package com.tpscrum.apirest.services;

import com.tpscrum.apirest.entities.Ingrediente;
import com.tpscrum.apirest.entities.Receta;
import com.tpscrum.apirest.repositories.BaseRepository;
import com.tpscrum.apirest.repositories.RecetaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecetaSerciceImpl extends BaseServiceImpl<Receta, Integer> {
    public RecetaSerciceImpl(BaseRepository<Receta, Integer> baseRepository) {
        super(baseRepository);
    }

    @Autowired
    private RecetaRepository recetaRepository;

    public Page<Receta> search(List<String> filters, Pageable pageable) throws Exception{
        try {
            Page<Receta> entities = recetaRepository.findByIngredientesNombreIn(filters, pageable);
            return entities;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}