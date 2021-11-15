package com.example.proyecto_fiverrEquipo2;

//import com.example.proyecto_fiverrEquipo2.entities.Paquetes;
import com.example.proyecto_fiverrEquipo2.entities.Trabajos;
import com.example.proyecto_fiverrEquipo2.entities.TipoWeb;
import com.example.proyecto_fiverrEquipo2.entities.Vendedor;
//import com.example.proyecto_fiverrEquipo2.repository.PaquetesRepository;
import com.example.proyecto_fiverrEquipo2.repository.PaquetesRepository;
import com.example.proyecto_fiverrEquipo2.repository.TrabajoRepository;
import com.example.proyecto_fiverrEquipo2.repository.TipoWebRepository;
import com.example.proyecto_fiverrEquipo2.repository.VendedorRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class ProyectoFiverrEquipo2Application {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(ProyectoFiverrEquipo2Application.class, args);


		VendedorRepository vendedorRepository = context.getBean(VendedorRepository.class);
		PaquetesRepository paquetesRepository = context.getBean(PaquetesRepository.class);
		TrabajoRepository trabajoRepository = context.getBean(TrabajoRepository.class);
		TipoWebRepository tipoWebRepository = context.getBean(TipoWebRepository.class);

		// CREAMOS SERVICIOS
		Trabajos tipoWeb = new Trabajos("Tipo web");
		Trabajos plataformasHerramientas = new Trabajos("Plataforma y herramientas");
		Trabajos serviciosIncluidos = new Trabajos("Servicios incluidos");

		System.out.println("Número de servicios en base de datos " +  trabajoRepository.findAll().size());
		System.out.println("Número de vendedores en base de datos: " + vendedorRepository.findAll().size());

		// GUARDAMOS SERVICIOS EN EL REPOSITORIO
		trabajoRepository.saveAll(Arrays.asList(tipoWeb, plataformasHerramientas, serviciosIncluidos));

		// CREAMOS TIPOS WEB
		TipoWeb ecommerce = new TipoWeb("Ecommerce");
		TipoWeb blog = new TipoWeb("Blog");
		TipoWeb businessPromotion = new TipoWeb("Promotion");
		TipoWeb productServiceMkt = new TipoWeb("Producto & servicio Marketing");

		System.out.println("Número de tipos web: " + tipoWebRepository.findAll().size());

		tipoWebRepository.saveAll(Arrays.asList(ecommerce, blog, businessPromotion, productServiceMkt));

		Vendedor vendedor1 = new Vendedor(null, "Diseño web únicamente responsive", "Laia Hidalgo", 3, "Llevo en el sector 3 años, he completado más de 2000 proyectos...", "laia@laia.com", "nivel2", "español", "Barcelona");

		Vendedor vendedor2 = new Vendedor(null, "Diseño web únicamente responsive", "Laia Hidalgo", 3, "Llevo en el sector 3 años, he completado más de 2000 proyectos...", "laia@laia.com", "nivel2", "español", "Barcelona");

		Vendedor vendedor3 = new Vendedor(null, "Diseño web únicamente responsive", "Laia Hidalgo", 3, "Llevo en el sector 3 años, he completado más de 2000 proyectos...", "laia@laia.com", "nivel2", "español", "Barcelona");

		Vendedor vendedor4 = new Vendedor(null, "Diseño web únicamente responsive", "Laia Hidalgo", 3, "Llevo en el sector 3 años, he completado más de 2000 proyectos...", "laia@laia.com", "nivel2", "español", "Barcelona");

		vendedorRepository.saveAll(Arrays.asList(vendedor1, vendedor2, vendedor3, vendedor4));

		List<Trabajos> serv1 = Arrays.asList(tipoWeb, plataformasHerramientas, serviciosIncluidos);
		List<Trabajos> serv2 = Arrays.asList(tipoWeb, plataformasHerramientas, serviciosIncluidos);
		List<Trabajos> serv3 = Arrays.asList(tipoWeb, plataformasHerramientas, serviciosIncluidos);
		List<Trabajos> serv4 = Arrays.asList(tipoWeb, plataformasHerramientas, serviciosIncluidos);

		//creamos lista de tipoweb
		List<TipoWeb> tipoWeb1 = Arrays.asList(ecommerce, blog, businessPromotion, productServiceMkt);

		for (Trabajos trabajos : serv1) {
			vendedor1.addServicio(trabajos);
			}
		for (Trabajos trabajos : serv2) {
			vendedor2.addServicio(trabajos);
		}
		for (Trabajos trabajos : serv3) {
			vendedor3.addServicio(trabajos);
		}
		for (Trabajos trabajos : serv4) {
			vendedor4.addServicio(trabajos);
		}

		vendedorRepository.saveAll(Arrays.asList(vendedor1, vendedor2, vendedor3, vendedor4));



		System.out.println("Número de vendedores " + vendedorRepository.findAll().size());
		System.out.println("Número de servicios " + trabajoRepository.findAll().size());

		List<Vendedor> vendedores = vendedorRepository.findAll();

		for(Vendedor vendedor : vendedores){
			List<Trabajos> trabajos = vendedor.getServicios();
			StringBuilder idServicios = new StringBuilder();
				for(Trabajos trabajos : trabajos){
					idServicios.append(trabajos.getId()).append(" ");
				}
			System.out.println("Id Vendedor: " + vendedor.getId() + " Id Servicio: " + idServicios);
		}

	}
}