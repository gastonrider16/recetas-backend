package com.tpscrum.apirest.controllers;

import com.tpscrum.apirest.entities.Base;
import com.tpscrum.apirest.interfaces.BaseController;
import com.tpscrum.apirest.services.BaseServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

public abstract class BaseControllerImpl < E extends Base, S extends BaseServiceImpl<E,Integer>> implements BaseController<E,Integer> {
    @Autowired
    protected S service;

    @Override
    @GetMapping(path = {""})
    public ResponseEntity<?> getAllRecords() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.findAll());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @Override
    @GetMapping(path = {"/page"})
    public ResponseEntity<?> getRecordBy(Pageable pageable, @RequestParam(name = "sort", required = false) String sort) {
        try {
            if (sort != null) {
                pageable = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), Sort.by(sort));
            }
            return ResponseEntity.status(HttpStatus.OK).body(service.findAll(pageable));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @Override
    @GetMapping(path = {"/{id}"})
    public ResponseEntity<?> getRecordById(@PathVariable Integer id) throws Exception {
        // valida la existencia del id
        if (!service.existId(id))
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontró el registro con ese id");

        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.findById(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @Override
    @PostMapping(path = {""})
    public ResponseEntity<?> saveRecord(@Valid @RequestBody E entity, BindingResult result) {
        // valida los campos de la entidad
        if (result.hasErrors())
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result.getFieldError().getDefaultMessage());

        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(service.save(entity));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @Override
    @PutMapping(path = {"/{id}"})
    public ResponseEntity<?> updateRecord(@PathVariable Integer id,@Valid @RequestBody E entity, BindingResult result) throws Exception {
        // valida la existencia del id
        if (!service.existId(id))
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontró el registro con ese id");

        // valida los campos de la entidad
        if (result.hasErrors())
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result.getFieldError().getDefaultMessage());

        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.update(id, entity));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @Override
    @DeleteMapping(path = {"/{id}"})
    public ResponseEntity<?> deleteRecord(@PathVariable Integer id) throws Exception {
        // valida la existencia del id
        if (!service.existId(id))
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontró el registro con ese id");

        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.delete(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}

