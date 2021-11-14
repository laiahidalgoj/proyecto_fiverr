package com.example.proyecto_fiverrEquipo2;

import com.example.proyecto_fiverrEquipo2.entities.Vendedor;
import com.example.proyecto_fiverrEquipo2.repository.PaquetesRepository;
import com.example.proyecto_fiverrEquipo2.repository.VendedorRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class ProyectoFiverrEquipo2Application {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(ProyectoFiverrEquipo2Application.class, args);


		VendedorRepository vendedorRepository = context.getBean(VendedorRepository.class);
		PaquetesRepository paquetesRepository = context.getBean(PaquetesRepository.class);

		Vendedor vendedor1 = new Vendedor(null, "Diseño web UX/UI", "Laia Hidalgo", 3, "hola soy laia, tengo 3 años de experiencia, he completado más de 2000 proyectos. Puedo crear su web con una gran calidad", "laia@laia.com", "Top", "Español", "Barcelona", "Ecommerce", "archivo fuente", "wordpress");

		Vendedor vendedor2 = new Vendedor(null, "Diseño web UX/UI", "Laia Hidalgo", 3, "hola soy laia, tengo 3 años de experiencia, he completado más de 2000 proyectos. Puedo crear su web con una gran calidad", "laia@laia.com", "Top", "Español", "Barcelona", "Ecommerce", "archivo fuente", "wordpress");

		Vendedor vendedor3 = new Vendedor(null, "Diseño web UX/UI", "Laia Hidalgo", 3, "hola soy laia, tengo 3 años de experiencia, he completado más de 2000 proyectos. Puedo crear su web con una gran calidad", "laia@laia.com", "Top", "Español", "Barcelona", "Ecommerce", "archivo fuente", "wordpress");

		Vendedor vendedor4 = new Vendedor(null, "Diseño web UX/UI", "Laia Hidalgo", 3, "hola soy laia, tengo 3 años de experiencia, he completado más de 2000 proyectos. Puedo crear su web con una gran calidad", "laia@laia.com", "Top", "Español", "Barcelona", "Ecommerce", "archivo fuente", "wordpress");

		System.out.println("Número de vendedores " + vendedorRepository.findAll().size());


//		for(int i = 0; i < Vendedor.; i++){
//	}
	}
}