package com.tpscrum.apirest.services;

import com.tpscrum.apirest.entities.Ingrediente;
import com.tpscrum.apirest.repositories.BaseRepository;
import com.tpscrum.apirest.repositories.IngredienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class IngredienteServiceImpl extends BaseServiceImpl<Ingrediente, Integer>{
    public IngredienteServiceImpl(BaseRepository<Ingrediente, Integer> baseRepository) {
        super(baseRepository);
    }
    
    @Autowired
    private IngredienteRepository ingredienteRepository;
    
    public Page<Ingrediente> search(String filter, Pageable pageable) throws Exception{
        try {
            Page<Ingrediente> entities = ingredienteRepository.search(filter, pageable);
            return entities;
        }catch ( Exception e){
            throw new Exception (e.getMessage());
        }
    }
}
