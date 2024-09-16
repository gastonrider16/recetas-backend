package com.tpscrum.apirest.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter @Setter
@Entity
@Table(name = "recetas")
public class Receta extends Base {
    @NotBlank(message = "El nombre no puede estar vacío")
    private String nombre;

    @NotBlank(message = "La imagen no puede estar vacía")
    private String imagen;

    @NotBlank(message = "La descripción no puede estar vacía")
    private String descripcion;

    private Date createdAt;

    @ManyToMany
    @JoinTable(
            name = "recetas_ingredientes",
            joinColumns = @JoinColumn(name = "receta_id"),
            inverseJoinColumns = @JoinColumn(name = "ingrediente_id")
    )
    private List<Ingrediente> ingredientes = new ArrayList<>();

    public void agregarIngrediente(Ingrediente ingrediente){
        this.ingredientes.add(ingrediente);
    }

    public Receta() {
        super();
        this.createdAt = new Date();
    }

    public Receta(String nombre, String descripcion, String imagen) {
        this();
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.imagen = imagen;
    }

}
