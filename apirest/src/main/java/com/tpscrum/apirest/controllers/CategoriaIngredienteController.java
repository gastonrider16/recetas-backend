package com.tpscrum.apirest.controllers;

import com.tpscrum.apirest.entities.CategoriaIngrediente;
import com.tpscrum.apirest.services.CategoriaIngredienteServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/api/v1/categoria-ingrediente")
public class CategoriaIngredienteController extends BaseControllerImpl<CategoriaIngrediente, CategoriaIngredienteServiceImpl>{
}
