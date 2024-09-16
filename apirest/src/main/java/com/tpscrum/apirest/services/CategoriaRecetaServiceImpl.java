package com.tpscrum.apirest.services;

import com.tpscrum.apirest.entities.CategoriaReceta;
import com.tpscrum.apirest.repositories.BaseRepository;
import org.springframework.stereotype.Service;

@Service
public class CategoriaRecetaServiceImpl extends BaseServiceImpl<CategoriaReceta, Integer>{
    public CategoriaRecetaServiceImpl(BaseRepository<CategoriaReceta, Integer> baseRepository) {
        super(baseRepository);
    }
}
