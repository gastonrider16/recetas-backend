package com.tpscrum.apirest.controllers;

import com.tpscrum.apirest.entities.CategoriaReceta;
import com.tpscrum.apirest.services.CategoriaRecetaServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/api/v1/categoria-receta")
public class CategoriaRecetaController extends BaseControllerImpl<CategoriaReceta, CategoriaRecetaServiceImpl>{
}
