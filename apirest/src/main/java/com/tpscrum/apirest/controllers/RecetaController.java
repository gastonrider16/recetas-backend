package com.tpscrum.apirest.controllers;

import com.tpscrum.apirest.entities.Receta;
import com.tpscrum.apirest.services.RecetaSerciceImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/api/v1/recetas")
public class RecetaController extends BaseControllerImpl<Receta, RecetaSerciceImpl> {

    @GetMapping(path = {"/search"})
    public ResponseEntity<?> getRecordBy(Pageable pageable, @RequestParam(name = "filtrar", required = false) List<String> filters) {
        try {
            if (filters == null || filters.isEmpty())
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(("{\"error\": \"Debe ingresar un filtro\"}"));
            return ResponseEntity.status(HttpStatus.OK).body(service.search(filters, pageable));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}