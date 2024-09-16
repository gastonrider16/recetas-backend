package com.tpscrum.apirest;

import com.tpscrum.apirest.entities.CategoriaIngrediente;
import com.tpscrum.apirest.entities.CategoriaReceta;
import com.tpscrum.apirest.entities.Ingrediente;
import com.tpscrum.apirest.entities.Receta;
import com.tpscrum.apirest.repositories.CategoriaIngredienteRepository;
import com.tpscrum.apirest.repositories.CategoriaRecetaRepository;
import com.tpscrum.apirest.repositories.IngredienteRepository;
import com.tpscrum.apirest.repositories.RecetaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ApirestApplication {

	@Autowired private RecetaRepository recetaRepository;
	@Autowired private CategoriaRecetaRepository categoriaRecetaRepository;
	@Autowired private CategoriaIngredienteRepository categoriaIngredienteRepository;
	@Autowired private IngredienteRepository ingredienteRepository;

	public static void main(String[] args) {
		SpringApplication.run(ApirestApplication.class, args);
	}

	@Bean
	public CommandLineRunner init() {
		return (args) -> {


			// Guardo algunas categorias de recetas en la base de datos
			CategoriaReceta CategoriaReceta1 = new CategoriaReceta("Comidas", "Comidas");
			categoriaRecetaRepository.save(CategoriaReceta1);

			CategoriaReceta CategoriaReceta2 = new CategoriaReceta("Postres", "Postres");
			categoriaRecetaRepository.save(CategoriaReceta2);

			CategoriaReceta CategoriaReceta3 = new CategoriaReceta("Merienda", "Merienda");
			categoriaRecetaRepository.save(CategoriaReceta3);


			// Guardo algunas categorias de ingredientes en la base de datos
			CategoriaIngrediente categoriaIngrediente1 = new CategoriaIngrediente("Carne", "Carne");
			categoriaIngredienteRepository.save(categoriaIngrediente1);

			CategoriaIngrediente categoriaIngrediente2 = new CategoriaIngrediente("Verdura", "Verdura");
			categoriaIngredienteRepository.save(categoriaIngrediente2);

			CategoriaIngrediente categoriaIngrediente3 = new CategoriaIngrediente("Fruta", "Fruta");
			categoriaIngredienteRepository.save(categoriaIngrediente3);

			CategoriaIngrediente categoriaIngrediente4 = new CategoriaIngrediente("Legumbre", "Legumbre");
			categoriaIngredienteRepository.save(categoriaIngrediente4);

			CategoriaIngrediente categoriaIngrediente5 = new CategoriaIngrediente("Panaderia", "Alimentos de panaderia");
			categoriaIngredienteRepository.save(categoriaIngrediente5);

			// Guardo algunos ingredientes en la base de datos
			Ingrediente ingrediente1 = new Ingrediente("Bola de lomo", "Feteada fina", 1);
			ingrediente1.setCategoria(categoriaIngrediente1);
			ingredienteRepository.save(ingrediente1);

			Ingrediente ingrediente2 = new Ingrediente("Salmon", "Salmon rosado", 1);
			ingrediente2.setCategoria(categoriaIngrediente1);
			ingredienteRepository.save(ingrediente2);

			Ingrediente ingrediente3 = new Ingrediente("Cebolla de verdeo", "Verdura", 1);
			ingrediente3.setCategoria(categoriaIngrediente2);
			ingredienteRepository.save(ingrediente3);

			Ingrediente ingrediente4 = new Ingrediente("Limon", "Jugo de limon", 1);
			ingrediente4.setCategoria(categoriaIngrediente3);
			ingredienteRepository.save(ingrediente4);

			Ingrediente ingrediente5 = new Ingrediente("Champignon", "champignon", 6);
			ingrediente5.setCategoria(categoriaIngrediente2);
			ingredienteRepository.save(ingrediente5);

			Ingrediente ingrediente6 = new Ingrediente("Papa", "Papa frita", 2);
			ingrediente6.setCategoria(categoriaIngrediente2);
			ingredienteRepository.save(ingrediente6);

			Ingrediente ingrediente7 = new Ingrediente("Pan rallado", "Pan rallado fino",1);
			ingrediente6.setCategoria(categoriaIngrediente5);
			ingredienteRepository.save(ingrediente7);

			Ingrediente ingrediente8 = new Ingrediente("Pollo", "Deshuesado", 3);
			ingrediente1.setCategoria(categoriaIngrediente1);
			ingredienteRepository.save(ingrediente8);


			// Guardo algunas recetas en la base de datos
			Receta receta1 = new Receta("Milanesa con papas fritas", "Milanesa de lomo con papas fritas","https://astelus.com/wp-content/viajes/Plato-de-milanesa-con-papas-ti%CC%81pico-de-Argentina.jpg");
			receta1.agregarIngrediente(ingrediente1);
			receta1.agregarIngrediente(ingrediente6);
			receta1.agregarIngrediente(ingrediente7);
			recetaRepository.save(receta1);

			Receta receta2 = new Receta("Pollo con papas fritas", "Pollo con papas fritas", "https://elorigendelsabor.com.ar/wp-content/uploads/2022/06/pollo1.jpg");
			receta2.agregarIngrediente(ingrediente8);
			receta2.agregarIngrediente(ingrediente6);
			recetaRepository.save(receta2);

			Receta receta3 = new Receta("Pollo al champignon", "Pollo al champignon", "https://assets.unileversolutions.com/recipes-v2/210719.jpg");
			receta3.agregarIngrediente(ingrediente8);
			receta3.agregarIngrediente(ingrediente5);
			recetaRepository.save(receta3);

		};
	}
}