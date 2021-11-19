package com.example.proyecto_fiverrEquipo2;

import com.example.proyecto_fiverrEquipo2.entities.Review;
import com.example.proyecto_fiverrEquipo2.entities.Trabajo;
import com.example.proyecto_fiverrEquipo2.entities.Categoria;
import com.example.proyecto_fiverrEquipo2.entities.Vendedor;
import com.example.proyecto_fiverrEquipo2.repository.ReviewRepository;
import com.example.proyecto_fiverrEquipo2.repository.TrabajoRepository;
import com.example.proyecto_fiverrEquipo2.repository.CategoriaRepository;
import com.example.proyecto_fiverrEquipo2.repository.VendedorRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

@SpringBootApplication
public class ProyectoFiverrEquipo2Application {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(ProyectoFiverrEquipo2Application.class, args);


		VendedorRepository vendedorRepository = context.getBean(VendedorRepository.class);
		TrabajoRepository trabajoRepository = context.getBean(TrabajoRepository.class);
		CategoriaRepository categoriaRepository = context.getBean(CategoriaRepository.class);
		ReviewRepository reviewRepository = context.getBean(ReviewRepository.class);

		// CREAMOS FECHAS DE PUBLICACIÓN
		LocalDate fecha_Publicacion1 = LocalDate.of(2021, Calendar.SEPTEMBER, 19);
		LocalDate fecha_Publicacion2 = LocalDate.of(2021, Calendar.OCTOBER, 20);
		LocalDate fecha_Publicacion3 = LocalDate.of(2021, Calendar.NOVEMBER, 4);
		LocalDate fecha_Publicacion4 = LocalDate.of(2021, Calendar.SEPTEMBER, 9);
		LocalDate fecha_Publicacion5 = LocalDate.of(2021, Calendar.JULY, 13);

		// CREAMOS TRABAJOS
		Trabajo trabajo1 = new Trabajo(null, "Empresa", "Desarrollo software", 800.50, Idioma.Español, Pais.España);
		Trabajo trabajo2 = new Trabajo(null, "Empresa", "Diseños responsive", 900.30, Idioma.Español, Pais.EEUU);
		Trabajo trabajo3 = new Trabajo(null, "Empresa", "Diseños creativos", 1200.80, Idioma.Español, Pais.Italia);
		Trabajo trabajo4 = new Trabajo(null, "Empresa", "Diseños en WordPress", 1500.25, Idioma.Español, Pais.España);
		Trabajo trabajo5 = new Trabajo(null, "Empresa", "Diseñamos lo que quieras", 750.50, Idioma.Frances, Pais.Francia);
		Trabajo trabajo6 = new Trabajo(null, "Empresa", "Diseñamos lo que quieras", 750.50, Idioma.Frances, Pais.Francia);

		// ASIGNAMOS FECHAS A CADA TRABAJO
		trabajo1.setFecha_Publicacion(fecha_Publicacion1);
		trabajo2.setFecha_Publicacion(fecha_Publicacion2);
		trabajo3.setFecha_Publicacion(fecha_Publicacion3);
		trabajo3.setFecha_Publicacion(fecha_Publicacion3);
		trabajo4.setFecha_Publicacion(fecha_Publicacion4);
		trabajo5.setFecha_Publicacion(fecha_Publicacion5);
		trabajo6.setFecha_Publicacion(fecha_Publicacion5);

		// GUARDAMOS TRABAJOS EN EL REPOSITORIO
		trabajoRepository.saveAll(Arrays.asList(trabajo1, trabajo2, trabajo3, trabajo4, trabajo5, trabajo6));

		System.out.println("Número de trabajos en base de datos " +  trabajoRepository.findAll().size());

		// CREAMOS VENDEDOR
		Vendedor vendedor1 = new Vendedor(null, "Laia", "Diseño la lógica de tu web", Nivel.Nivel1, "laia@laia.es", Empresa.Autonomo, Pais.España);
		Vendedor vendedor2 = new Vendedor(null, "Rafa", "Diseño tu web responsive ", Nivel.Nivel1, "rafa@rafa.es", Empresa.Autonomo, Pais.EEUU);
		Vendedor vendedor3 = new Vendedor(null, "Luis", "Diseño tu web creativo y único", Nivel.Nivel2, "luis@luis.es", Empresa.Autonomo, Pais.Italia);
		Vendedor vendedor4 = new Vendedor(null, "Toni", "Diseño tu sitio web con wordpress", Nivel.Nivel2, "toni@toni.es", Empresa.Autonomo, Pais.España);
		Vendedor vendedor5 = new Vendedor(null, "Marcos", "Diseñamos tu web desde 0", Nivel.Nivel1, "marcos@marcos.es", Empresa.Privada, Pais.Francia);
		Vendedor vendedor6 = new Vendedor(null, "Marcos", "Diseñamos tu web desde 0", Nivel.Nivel1, "marcos@marcos.es", Empresa.Privada, Pais.Francia);

		// GUARDAMOS VENDEDORES EN EL REPOSITORIO
		vendedorRepository.saveAll(Arrays.asList(vendedor1, vendedor2, vendedor3, vendedor4, vendedor5, vendedor6));

		System.out.println("Número de vendedores en base de datos " +  vendedorRepository.findAll().size());

		// CREAMOS CATEOGRIAS
		Categoria categoria1 = new Categoria(null, "Desarrollo web");
		Categoria categoria2 = new Categoria(null, "Diseño web");
		Categoria categoria3= new Categoria(null, "Diseño Responsive");
		Categoria categoria4 = new Categoria(null, "Diseño creativo");
		Categoria categoria5 = new Categoria(null, "Diseño 360");

		// GUARDAMOS CATEGORIAS EN EL REPOSITORIO
		categoriaRepository.saveAll(Arrays.asList(categoria1, categoria2, categoria3, categoria4, categoria5));

		System.out.println("Número de categorías: " + categoriaRepository.findAll().size());

		//creamos lista de categorias
		List<Categoria> cat1 = Arrays.asList(categoria1);
		List<Categoria> cat2 = Arrays.asList(categoria1);
		List<Categoria> cat3 = Arrays.asList(categoria1);
		List<Categoria> cat4 = Arrays.asList(categoria1);
		List<Categoria> cat5 = Arrays.asList(categoria1);

		for (Categoria categoria : cat1) {
			trabajo1.addCategoria(categoria);
			}
		for (Categoria categoria : cat2) {
			trabajo2.addCategoria(categoria);
		}
		for (Categoria categoria : cat3) {
			trabajo3.addCategoria(categoria);
		}
		for (Categoria categoria : cat4) {
			trabajo4.addCategoria(categoria);
		}
		for (Categoria categoria : cat5) {
			trabajo5.addCategoria(categoria);
		}

		//AÑADIMOS CATEGORIAS A CADA TRABAJO
		trabajo1.addCategoria(categoria1);
		trabajo2.addCategoria(categoria3);
		trabajo3.addCategoria(categoria4);
		trabajo4.addCategoria(categoria2);
		trabajo5.addCategoria(categoria5);
		trabajo6.addCategoria(categoria1);


		// ASIGNAMOS TRABAJO A VENDEDOR
		trabajo1.addVendedor(vendedor1);
		trabajo2.addVendedor(vendedor2);
		trabajo3.addVendedor(vendedor3);
		trabajo4.addVendedor(vendedor4);
		trabajo5.addVendedor(vendedor5);
		trabajo6.addVendedor(vendedor6);

		// GUARDAMOS TRABAJOS A REPOSITORIO
		trabajoRepository.saveAll(Arrays.asList(trabajo1, trabajo2, trabajo3, trabajo4, trabajo5, trabajo6));

		//CREAMOS REVIEWS
		Review review1 = new Review(null,5,"Excelente trabajo", trabajo1, vendedor1);
		Review review2 = new Review(null,5,"un gusto exquisito en sus trabajos", trabajo2, vendedor2);
		Review review3 = new Review(null,4,"Me encantaron sus diseños, aunque la entrega algo tarde", trabajo3, vendedor3);
		Review review4 = new Review(null,4,"Diseños muy creativos", trabajo4, vendedor4);
		Review review5 = new Review(null,5,"Entrega en su fecha y muy buen diseño", trabajo5, vendedor5);
		Review review6 = new Review(null,4,"Me gustó bastante", trabajo1, vendedor1);
		Review review7 = new Review(null,5,"Excelente el trabajo realizado", trabajo2, vendedor2);
		Review review8 = new Review(null,4,"Me gustó bastante el trabajo realizado", trabajo3, vendedor3);
		Review review9 = new Review(null,4,"Me gustó bastante el trabajo realizado", trabajo4, vendedor4);
		Review review10 = new Review(null,5,"Excelente trabajo", trabajo5, vendedor5);

		// GUARDAMOS REVIEWS
		reviewRepository.saveAll(Arrays.asList(review1, review2, review3, review4, review5, review6, review7, review8, review9, review10));



	}
}