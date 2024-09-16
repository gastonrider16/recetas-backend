package com.tpscrum.apirest.services;

import com.tpscrum.apirest.entities.CategoriaIngrediente;
import com.tpscrum.apirest.repositories.BaseRepository;
import org.springframework.stereotype.Service;

@Service
public class CategoriaIngredienteServiceImpl extends BaseServiceImpl<CategoriaIngrediente, Integer>{
    public CategoriaIngredienteServiceImpl(BaseRepository<CategoriaIngrediente, Integer> baseRepository) {
        super(baseRepository);
    }
}
