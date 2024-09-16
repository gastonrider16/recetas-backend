package com.tpscrum.apirest.controllers;

import com.tpscrum.apirest.entities.Ingrediente;
import com.tpscrum.apirest.services.IngredienteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/api/v1/ingredientes")
public class IngredienteController extends BaseControllerImpl<Ingrediente, IngredienteServiceImpl>{
    @Autowired
    private IngredienteServiceImpl ingredienteServiceImpl;


    @GetMapping("/search")
    public ResponseEntity<?> search(@RequestParam(name = "filtrar", required = false) String filter, Pageable pageable){
        try {
            if (filter == null)
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(("{\"error\": \"Debe ingresar un filtro\"}"));

            return ResponseEntity.status(HttpStatus.OK).body(ingredienteServiceImpl.search(filter, pageable));
        }catch ( Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" + e.getMessage() + "\"}"));
        }
    }
}
