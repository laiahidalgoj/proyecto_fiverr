package com.example.proyecto_fiverrEquipo2;

import com.example.proyecto_fiverrEquipo2.entities.*;
import com.example.proyecto_fiverrEquipo2.repository.*;
import com.example.proyecto_fiverrEquipo2.service.UserServiceImpl;
import org.apache.catalina.Store;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.time.LocalDate;
import java.util.*;

@SpringBootApplication
public class ProyectoFiverrEquipo2Application {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(ProyectoFiverrEquipo2Application.class, args);


		VendedorRepository vendedorRepository = context.getBean(VendedorRepository.class);
		TrabajoRepository trabajoRepository = context.getBean(TrabajoRepository.class);
		CategoriaRepository categoriaRepository = context.getBean(CategoriaRepository.class);
		ReviewRepository reviewRepository = context.getBean(ReviewRepository.class);
		UserRepository userRepository = context.getBean(UserRepository.class);
		RoleRepository roleRepository = context.getBean(RoleRepository.class);

		// CREAMOS TRABAJOS
		Trabajo trabajo1 = new Trabajo(null, "laia_hidalgo", "Desarrollaré un sitio web profesional y una aplicación web para su negocio", 800.50, LocalDate.of(2021, Calendar.OCTOBER, 20), Nivel.Nivel1, Idioma.Español, Pais.España);
		Trabajo trabajo2 = new Trabajo(null, "maria_perez", "Diseñaré con técnicas modernas de ilustración y modelado en 3D para crear objetos en tres dimensiones y crear animaciones", 900.30, LocalDate.of(2021, Calendar.OCTOBER, 20), Nivel.Nivel1, Idioma.Español, Pais.EEUU);
		Trabajo trabajo3 = new Trabajo(null, "luis_callado", "Diseñaré tu web para el posicionamiento y su optimización en motores de búsqueda", 1200.80, LocalDate.of(2021, Calendar.NOVEMBER, 4), Nivel.Nivel2, Idioma.Español, Pais.Italia);
		Trabajo trabajo4 = new Trabajo(null, "marcos_ruiz", "Diseñaré estrategias en medios digitales para despegar tu negocio", 750.50, LocalDate.of(2021, Calendar.JULY, 13),  Nivel.MejorCalificado, Idioma.Frances, Pais.Francia);
		Trabajo trabajo5 = new Trabajo(null, "marcos_ruiz", "Diseñaré tu web UX/UI para una mayor y mejor funcionalidad de usuario", 750.50, LocalDate.of(2021, Calendar.JULY, 13), Nivel.MejorCalificado,  Idioma.Frances, Pais.Francia);
		Trabajo trabajo6 = new Trabajo(null, "lucia_ortiz", "Me encargaré de interactuar con nuevas tecnologías, crear y compartir contenido fascinante", 903.54, LocalDate.of(2021, Calendar.OCTOBER, 20), Nivel.Nivel1, Idioma.Ingles, Pais.UK);
		Trabajo trabajo7 = new Trabajo(null, "laia_hidalgo", "Diseñaré todas las comunicaciones gráficas para transmitir mensajes específicos", 1220.50,LocalDate.of(2021, Calendar.OCTOBER, 20), Nivel.Nivel1, Idioma.Frances, Pais.Francia);
		Trabajo trabajo8 = new Trabajo(null, "maria_perez", "Personalizaré tu logo de forma sencilla y la más atractiva", 1300.50, LocalDate.of(2021, Calendar.JULY, 13), Nivel.Nivel1, Idioma.Ingles, Pais.EEUU);
		Trabajo trabajo9 = new Trabajo(null, "luis_callado", "Diseñaré con técnicas modernas de ilustración y modelado en 3D para crear objetos en tres dimensiones y crear animaciones", 1311.70, LocalDate.of(2021, Calendar.NOVEMBER, 4), Nivel.Nivel2,  Idioma.Español, Pais.España);
		Trabajo trabajo10 = new Trabajo(null, "toni_rubio", "Diseñaré estrategias en medios digitales para despegar tu negocio", 1220.50, LocalDate.of(2021, Calendar.OCTOBER, 20), Nivel.Nivel2, Idioma.Frances, Pais.Francia);
		Trabajo trabajo11 = new Trabajo(null, "marcos_ruiz", "Diseñaré con técnicas modernas de ilustración y modelado en 3D para crear objetos en tres dimensiones y crear animaciones", 1220.50, LocalDate.of(2021, Calendar.JULY, 13), Nivel.MejorCalificado, Idioma.Frances, Pais.Francia);
		Trabajo trabajo12 = new Trabajo(null, "lucia_ortiz", "Planificaré el diseño, implantaré y mantendré tu sitio web", 900.50, LocalDate.of(2021, Calendar.OCTOBER, 20), Nivel.Nivel1, Idioma.Frances, Pais.Francia);
		Trabajo trabajo13 = new Trabajo(null, "laia_hidalgo", "Diseñaré tu web para el posicionamiento y su optimización en motores de búsqueda", 1220.50, LocalDate.of(2021, Calendar.NOVEMBER, 4), Nivel.Nivel1, Idioma.Ingles, Pais.EEUU);
		Trabajo trabajo14 = new Trabajo(null, "maria_perez", "Me encargaré de interactuar con nuevas tecnologías, crear y compartir contenido fascinante", 854.50, LocalDate.of(2021, Calendar.JULY, 13), Nivel.Nivel1, Idioma.Ingles, Pais.UK);
		Trabajo trabajo15 = new Trabajo(null, "luis_callado", "Diseñaré con técnicas modernas de ilustración y modelado en 3D para crear objetos en tres dimensiones y crear animaciones", 1220.50, LocalDate.of(2021, Calendar.OCTOBER, 20), Nivel.Nivel2, Idioma.Frances, Pais.Francia);
		Trabajo trabajo16 = new Trabajo(null, "toni_rubio", "Diseñaré tu web para el posicionamiento y su optimización en motores de búsqueda", 1220.50, LocalDate.of(2021, Calendar.SEPTEMBER, 19), Nivel.Nivel2, Idioma.Español, Pais.España);
		Trabajo trabajo17 = new Trabajo(null, "toni_rubio", "Desarrollaré un sitio web profesional y una aplicación web para su negocio", 1220.50, LocalDate.of(2021, Calendar.SEPTEMBER, 19), Nivel.Nivel2, Idioma.Español, Pais.España);
		Trabajo trabajo18 = new Trabajo(null, "marta_colado", "Diseñaré tu web para el posicionamiento y su optimización en motores de búsqueda", 1220.50, LocalDate.of(2021, Calendar.JULY, 13), Nivel.MejorCalificado,  Idioma.Frances, Pais.Francia);
		Trabajo trabajo19 = new Trabajo(null, "ernesto_garcia", "Personalizaré tu logo de forma sencilla y la más atractiva", 895.50, LocalDate.of(2021, Calendar.JULY, 13), Nivel.Nivel1,  Idioma.Ingles, Pais.UK);
		Trabajo trabajo20 = new Trabajo(null, "veronica_tamiz", "Diseñaré con técnicas modernas de ilustración y modelado en 3D para crear objetos en tres dimensiones y crear animaciones", 984.50, LocalDate.of(2021, Calendar.JULY, 13), Nivel.MejorCalificado,  Idioma.Frances, Pais.Francia);


		// imagen ux/ui
		trabajo5.setImagen("https://image.freepik.com/vector-gratis/fondo-degradado-ui-ux_23-2149065782.jpg");

		// diseño 3d
		trabajo2.setImagen("https://image.freepik.com/vector-gratis/tema-colorido-conjunto-emoji_79603-1264.jpg");
		trabajo9.setImagen("https://image.freepik.com/vector-gratis/tema-colorido-conjunto-emoji_79603-1264.jpg");
		trabajo15.setImagen("https://image.freepik.com/vector-gratis/tema-colorido-conjunto-emoji_79603-1264.jpg");
		trabajo20.setImagen("https://image.freepik.com/vector-gratis/tema-colorido-conjunto-emoji_79603-1264.jpg");

		//social media
		trabajo6.setImagen("https://image.freepik.com/foto-gratis/pila-3d-populares-social-media-logos_1379-881.jpg");
		trabajo14.setImagen("https://image.freepik.com/foto-gratis/pila-3d-populares-social-media-logos_1379-881.jpg");

		// diseño gráfico
		trabajo7.setImagen("https://image.freepik.com/foto-gratis/manos-disenadores-graficos-usan-computadora-portatil-tableta-digital_1170-906.jpg");

		// diseño web
		trabajo12.setImagen("https://image.freepik.com/vector-gratis/logotipos-lujo-o-diseno-coleccion-monogramas-boda_1017-25869.jpg");

		// logo design
		trabajo8.setImagen("https://image.freepik.com/vector-gratis/logotipos-lujo-o-diseno-coleccion-monogramas-boda_1017-25869.jpg");
		trabajo19.setImagen("https://image.freepik.com/vector-gratis/logotipos-lujo-o-diseno-coleccion-monogramas-boda_1017-25869.jpg");

		// marketing
		trabajo4.setImagen("https://image.freepik.com/foto-gratis/escritorio-oficina-concepto-negocio-marketing-online_1134-85.jpg");
		trabajo10.setImagen("https://image.freepik.com/foto-gratis/escritorio-oficina-concepto-negocio-marketing-online_1134-85.jpg");

		//diseño responsive
		trabajo5.setImagen("https://image.freepik.com/psd-gratis/mockup-dispositivos-electronicos_23-2147864572.jpg");

		// desarrollo web
		trabajo1.setImagen("https://image.freepik.com/vector-gratis/desarrolladores-web-dibujados-mano_23-2148815976.jpg");
		trabajo11.setImagen("https://image.freepik.com/vector-gratis/desarrolladores-web-dibujados-mano_23-2148815976.jpg");
		trabajo17.setImagen("https://image.freepik.com/vector-gratis/desarrolladores-web-dibujados-mano_23-2148815976.jpg");

		//diseño SEO
		trabajo3.setImagen("https://image.freepik.com/vector-gratis/optimizacion-seo_24908-55896.jpg");
		trabajo13.setImagen("https://image.freepik.com/vector-gratis/optimizacion-seo_24908-55896.jpg");
		trabajo16.setImagen("https://image.freepik.com/vector-gratis/optimizacion-seo_24908-55896.jpg");
		trabajo18.setImagen("https://image.freepik.com/vector-gratis/optimizacion-seo_24908-55896.jpg");

		// GUARDAMOS TRABAJOS EN EL REPOSITORIO
		trabajoRepository.saveAll(Arrays.asList(trabajo1, trabajo2, trabajo3, trabajo4, trabajo5, trabajo6, trabajo7,
				trabajo8, trabajo9, trabajo10, trabajo11, trabajo12, trabajo13, trabajo14, trabajo15, trabajo16, trabajo17, trabajo18, trabajo19, trabajo20));

		System.out.println("Número de trabajos en base de datos " +  trabajoRepository.findAll().size());

		// CREAMOS VENDEDOR //falta por hacer la correcta descripción
		Vendedor vendedor1 = new Vendedor(null, "laia_hidalgo", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis rhoncus placerat ex. Quisque hendrerit neque magna, eu porttitor dolor accumsan nec. Vivamus aliquam ornare nisl, blandit mollis augue fringilla nec. Pellentesque gravida semper turpis id placerat. Sed ornare sem eu tincidunt interdum. Interdum et malesuada fames ac ante ipsum primis in faucibus. Nulla id ullamcorper justo. Duis commodo, ex eu dapibus semper, quam tellus pharetra nulla, vitae tristique libero tortor et massa. Proin sollicitudin dui mi, in ornare justo eleifend ac.\n" +
				"\n" +
				"Donec mi augue, lobortis ut felis vitae, sollicitudin sollicitudin quam. Nulla ut nisl vitae elit pretium ornare eget non eros. Aliquam erat volutpat. Praesent tristique viverra lacus. Duis eget dolor sollicitudin, vulputate arcu nec, interdum orci. Aenean vel libero in magna rhoncus dictum quis nec quam. Mauris blandit finibus fringilla. Aenean et cursus ex. Mauris sit amet ligula pellentesque metus interdum tristique eu vitae diam. Sed sed eros eget dolor iaculis egestas non id dolor. Cras vulputate ligula vel enim lacinia elementum.\n" +
				"\n" +
				"Donec lacinia semper urna vitae iaculis. Ut tempor leo et velit molestie venenatis. Praesent tempor viverra nunc, in semper ligula rhoncus eu. Nam convallis ligula et finibus porttitor. Cras ornare quam ut mauris efficitur, in scelerisque leo ultrices. Vivamus interdum, justo nec commodo commodo, erat leo tristique arcu, et tempor tortor risus eget magna. In eleifend tincidunt aliquam. Donec molestie lorem sit amet pulvinar pulvinar. Nunc vulputate magna tellus, et accumsan risus maximus ac. Proin finibus nisl sit amet ligula fermentum, a maximus urna pretium.", Nivel.Nivel1, "laia@laia.es", Empresa.Autonomo, Pais.España);
		Vendedor vendedor2 = new Vendedor(null, "maria_perez", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis rhoncus placerat ex. Quisque hendrerit neque magna, eu porttitor dolor accumsan nec. Vivamus aliquam ornare nisl, blandit mollis augue fringilla nec. Pellentesque gravida semper turpis id placerat. Sed ornare sem eu tincidunt interdum. Interdum et malesuada fames ac ante ipsum primis in faucibus. Nulla id ullamcorper justo. Duis commodo, ex eu dapibus semper, quam tellus pharetra nulla, vitae tristique libero tortor et massa. Proin sollicitudin dui mi, in ornare justo eleifend ac.\n" +
				"\n" +
				"Donec mi augue, lobortis ut felis vitae, sollicitudin sollicitudin quam. Nulla ut nisl vitae elit pretium ornare eget non eros. Aliquam erat volutpat. Praesent tristique viverra lacus. Duis eget dolor sollicitudin, vulputate arcu nec, interdum orci. Aenean vel libero in magna rhoncus dictum quis nec quam. Mauris blandit finibus fringilla. Aenean et cursus ex. Mauris sit amet ligula pellentesque metus interdum tristique eu vitae diam. Sed sed eros eget dolor iaculis egestas non id dolor. Cras vulputate ligula vel enim lacinia elementum.\n" +
				"\n" +
				"Donec lacinia semper urna vitae iaculis. Ut tempor leo et velit molestie venenatis. Praesent tempor viverra nunc, in semper ligula rhoncus eu. Nam convallis ligula et finibus porttitor. Cras ornare quam ut mauris efficitur, in scelerisque leo ultrices. Vivamus interdum, justo nec commodo commodo, erat leo tristique arcu, et tempor tortor risus eget magna. In eleifend tincidunt aliquam. Donec molestie lorem sit amet pulvinar pulvinar. Nunc vulputate magna tellus, et accumsan risus maximus ac. Proin finibus nisl sit amet ligula fermentum, a maximus urna pretium.", Nivel.Nivel1, "maria@maria.es", Empresa.Autonomo, Pais.EEUU);
		Vendedor vendedor3 = new Vendedor(null, "luis_callado", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis rhoncus placerat ex. Quisque hendrerit neque magna, eu porttitor dolor accumsan nec. Vivamus aliquam ornare nisl, blandit mollis augue fringilla nec. Pellentesque gravida semper turpis id placerat. Sed ornare sem eu tincidunt interdum. Interdum et malesuada fames ac ante ipsum primis in faucibus. Nulla id ullamcorper justo. Duis commodo, ex eu dapibus semper, quam tellus pharetra nulla, vitae tristique libero tortor et massa. Proin sollicitudin dui mi, in ornare justo eleifend ac.\n" +
				"\n" +
				"Donec mi augue, lobortis ut felis vitae, sollicitudin sollicitudin quam. Nulla ut nisl vitae elit pretium ornare eget non eros. Aliquam erat volutpat. Praesent tristique viverra lacus. Duis eget dolor sollicitudin, vulputate arcu nec, interdum orci. Aenean vel libero in magna rhoncus dictum quis nec quam. Mauris blandit finibus fringilla. Aenean et cursus ex. Mauris sit amet ligula pellentesque metus interdum tristique eu vitae diam. Sed sed eros eget dolor iaculis egestas non id dolor. Cras vulputate ligula vel enim lacinia elementum.\n" +
				"\n" +
				"Donec lacinia semper urna vitae iaculis. Ut tempor leo et velit molestie venenatis. Praesent tempor viverra nunc, in semper ligula rhoncus eu. Nam convallis ligula et finibus porttitor. Cras ornare quam ut mauris efficitur, in scelerisque leo ultrices. Vivamus interdum, justo nec commodo commodo, erat leo tristique arcu, et tempor tortor risus eget magna. In eleifend tincidunt aliquam. Donec molestie lorem sit amet pulvinar pulvinar. Nunc vulputate magna tellus, et accumsan risus maximus ac. Proin finibus nisl sit amet ligula fermentum, a maximus urna pretium.", Nivel.Nivel2, "luis@luis.es", Empresa.Autonomo, Pais.Italia);
		Vendedor vendedor4 = new Vendedor(null, "toni_rubio", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis rhoncus placerat ex. Quisque hendrerit neque magna, eu porttitor dolor accumsan nec. Vivamus aliquam ornare nisl, blandit mollis augue fringilla nec. Pellentesque gravida semper turpis id placerat. Sed ornare sem eu tincidunt interdum. Interdum et malesuada fames ac ante ipsum primis in faucibus. Nulla id ullamcorper justo. Duis commodo, ex eu dapibus semper, quam tellus pharetra nulla, vitae tristique libero tortor et massa. Proin sollicitudin dui mi, in ornare justo eleifend ac.\n" +
				"\n" +
				"Donec mi augue, lobortis ut felis vitae, sollicitudin sollicitudin quam. Nulla ut nisl vitae elit pretium ornare eget non eros. Aliquam erat volutpat. Praesent tristique viverra lacus. Duis eget dolor sollicitudin, vulputate arcu nec, interdum orci. Aenean vel libero in magna rhoncus dictum quis nec quam. Mauris blandit finibus fringilla. Aenean et cursus ex. Mauris sit amet ligula pellentesque metus interdum tristique eu vitae diam. Sed sed eros eget dolor iaculis egestas non id dolor. Cras vulputate ligula vel enim lacinia elementum.\n" +
				"\n" +
				"Donec lacinia semper urna vitae iaculis. Ut tempor leo et velit molestie venenatis. Praesent tempor viverra nunc, in semper ligula rhoncus eu. Nam convallis ligula et finibus porttitor. Cras ornare quam ut mauris efficitur, in scelerisque leo ultrices. Vivamus interdum, justo nec commodo commodo, erat leo tristique arcu, et tempor tortor risus eget magna. In eleifend tincidunt aliquam. Donec molestie lorem sit amet pulvinar pulvinar. Nunc vulputate magna tellus, et accumsan risus maximus ac. Proin finibus nisl sit amet ligula fermentum, a maximus urna pretium.", Nivel.Nivel2, "toni@toni.es", Empresa.Autonomo, Pais.España);
		Vendedor vendedor5 = new Vendedor(null, "marcos_ruiz", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis rhoncus placerat ex. Quisque hendrerit neque magna, eu porttitor dolor accumsan nec. Vivamus aliquam ornare nisl, blandit mollis augue fringilla nec. Pellentesque gravida semper turpis id placerat. Sed ornare sem eu tincidunt interdum. Interdum et malesuada fames ac ante ipsum primis in faucibus. Nulla id ullamcorper justo. Duis commodo, ex eu dapibus semper, quam tellus pharetra nulla, vitae tristique libero tortor et massa. Proin sollicitudin dui mi, in ornare justo eleifend ac.\n" +
				"\n" +
				"Donec mi augue, lobortis ut felis vitae, sollicitudin sollicitudin quam. Nulla ut nisl vitae elit pretium ornare eget non eros. Aliquam erat volutpat. Praesent tristique viverra lacus. Duis eget dolor sollicitudin, vulputate arcu nec, interdum orci. Aenean vel libero in magna rhoncus dictum quis nec quam. Mauris blandit finibus fringilla. Aenean et cursus ex. Mauris sit amet ligula pellentesque metus interdum tristique eu vitae diam. Sed sed eros eget dolor iaculis egestas non id dolor. Cras vulputate ligula vel enim lacinia elementum.\n" +
				"\n" +
				"Donec lacinia semper urna vitae iaculis. Ut tempor leo et velit molestie venenatis. Praesent tempor viverra nunc, in semper ligula rhoncus eu. Nam convallis ligula et finibus porttitor. Cras ornare quam ut mauris efficitur, in scelerisque leo ultrices. Vivamus interdum, justo nec commodo commodo, erat leo tristique arcu, et tempor tortor risus eget magna. In eleifend tincidunt aliquam. Donec molestie lorem sit amet pulvinar pulvinar. Nunc vulputate magna tellus, et accumsan risus maximus ac. Proin finibus nisl sit amet ligula fermentum, a maximus urna pretium.", Nivel.MejorCalificado, "marcos@marcos.es", Empresa.Privada, Pais.Francia);
		Vendedor vendedor6 = new Vendedor(null, "lucia_ortiz", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis rhoncus placerat ex. Quisque hendrerit neque magna, eu porttitor dolor accumsan nec. Vivamus aliquam ornare nisl, blandit mollis augue fringilla nec. Pellentesque gravida semper turpis id placerat. Sed ornare sem eu tincidunt interdum. Interdum et malesuada fames ac ante ipsum primis in faucibus. Nulla id ullamcorper justo. Duis commodo, ex eu dapibus semper, quam tellus pharetra nulla, vitae tristique libero tortor et massa. Proin sollicitudin dui mi, in ornare justo eleifend ac.\n" +
				"\n" +
				"Donec mi augue, lobortis ut felis vitae, sollicitudin sollicitudin quam. Nulla ut nisl vitae elit pretium ornare eget non eros. Aliquam erat volutpat. Praesent tristique viverra lacus. Duis eget dolor sollicitudin, vulputate arcu nec, interdum orci. Aenean vel libero in magna rhoncus dictum quis nec quam. Mauris blandit finibus fringilla. Aenean et cursus ex. Mauris sit amet ligula pellentesque metus interdum tristique eu vitae diam. Sed sed eros eget dolor iaculis egestas non id dolor. Cras vulputate ligula vel enim lacinia elementum.\n" +
				"\n" +
				"Donec lacinia semper urna vitae iaculis. Ut tempor leo et velit molestie venenatis. Praesent tempor viverra nunc, in semper ligula rhoncus eu. Nam convallis ligula et finibus porttitor. Cras ornare quam ut mauris efficitur, in scelerisque leo ultrices. Vivamus interdum, justo nec commodo commodo, erat leo tristique arcu, et tempor tortor risus eget magna. In eleifend tincidunt aliquam. Donec molestie lorem sit amet pulvinar pulvinar. Nunc vulputate magna tellus, et accumsan risus maximus ac. Proin finibus nisl sit amet ligula fermentum, a maximus urna pretium.", Nivel.Nivel1, "lucia@lucia.es", Empresa.Privada, Pais.Francia);
		Vendedor vendedor7 = new Vendedor(null, "marta_colado", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis rhoncus placerat ex. Quisque hendrerit neque magna, eu porttitor dolor accumsan nec. Vivamus aliquam ornare nisl, blandit mollis augue fringilla nec. Pellentesque gravida semper turpis id placerat. Sed ornare sem eu tincidunt interdum. Interdum et malesuada fames ac ante ipsum primis in faucibus. Nulla id ullamcorper justo. Duis commodo, ex eu dapibus semper, quam tellus pharetra nulla, vitae tristique libero tortor et massa. Proin sollicitudin dui mi, in ornare justo eleifend ac.\n" +
				"\n" +
				"Donec mi augue, lobortis ut felis vitae, sollicitudin sollicitudin quam. Nulla ut nisl vitae elit pretium ornare eget non eros. Aliquam erat volutpat. Praesent tristique viverra lacus. Duis eget dolor sollicitudin, vulputate arcu nec, interdum orci. Aenean vel libero in magna rhoncus dictum quis nec quam. Mauris blandit finibus fringilla. Aenean et cursus ex. Mauris sit amet ligula pellentesque metus interdum tristique eu vitae diam. Sed sed eros eget dolor iaculis egestas non id dolor. Cras vulputate ligula vel enim lacinia elementum.\n" +
				"\n" +
				"Donec lacinia semper urna vitae iaculis. Ut tempor leo et velit molestie venenatis. Praesent tempor viverra nunc, in semper ligula rhoncus eu. Nam convallis ligula et finibus porttitor. Cras ornare quam ut mauris efficitur, in scelerisque leo ultrices. Vivamus interdum, justo nec commodo commodo, erat leo tristique arcu, et tempor tortor risus eget magna. In eleifend tincidunt aliquam. Donec molestie lorem sit amet pulvinar pulvinar. Nunc vulputate magna tellus, et accumsan risus maximus ac. Proin finibus nisl sit amet ligula fermentum, a maximus urna pretium.", Nivel.MejorCalificado, "marta@marta.es", Empresa.Autonomo, Pais.España);
		Vendedor vendedor8 = new Vendedor(null, "ernesto_garcia", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis rhoncus placerat ex. Quisque hendrerit neque magna, eu porttitor dolor accumsan nec. Vivamus aliquam ornare nisl, blandit mollis augue fringilla nec. Pellentesque gravida semper turpis id placerat. Sed ornare sem eu tincidunt interdum. Interdum et malesuada fames ac ante ipsum primis in faucibus. Nulla id ullamcorper justo. Duis commodo, ex eu dapibus semper, quam tellus pharetra nulla, vitae tristique libero tortor et massa. Proin sollicitudin dui mi, in ornare justo eleifend ac.\n" +
				"\n" +
				"Donec mi augue, lobortis ut felis vitae, sollicitudin sollicitudin quam. Nulla ut nisl vitae elit pretium ornare eget non eros. Aliquam erat volutpat. Praesent tristique viverra lacus. Duis eget dolor sollicitudin, vulputate arcu nec, interdum orci. Aenean vel libero in magna rhoncus dictum quis nec quam. Mauris blandit finibus fringilla. Aenean et cursus ex. Mauris sit amet ligula pellentesque metus interdum tristique eu vitae diam. Sed sed eros eget dolor iaculis egestas non id dolor. Cras vulputate ligula vel enim lacinia elementum.\n" +
				"\n" +
				"Donec lacinia semper urna vitae iaculis. Ut tempor leo et velit molestie venenatis. Praesent tempor viverra nunc, in semper ligula rhoncus eu. Nam convallis ligula et finibus porttitor. Cras ornare quam ut mauris efficitur, in scelerisque leo ultrices. Vivamus interdum, justo nec commodo commodo, erat leo tristique arcu, et tempor tortor risus eget magna. In eleifend tincidunt aliquam. Donec molestie lorem sit amet pulvinar pulvinar. Nunc vulputate magna tellus, et accumsan risus maximus ac. Proin finibus nisl sit amet ligula fermentum, a maximus urna pretium.", Nivel.MejorCalificado, "marta@marta.es", Empresa.Autonomo, Pais.España);
		Vendedor vendedor9 = new Vendedor(null, "veronica_tamiz", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis rhoncus placerat ex. Quisque hendrerit neque magna, eu porttitor dolor accumsan nec. Vivamus aliquam ornare nisl, blandit mollis augue fringilla nec. Pellentesque gravida semper turpis id placerat. Sed ornare sem eu tincidunt interdum. Interdum et malesuada fames ac ante ipsum primis in faucibus. Nulla id ullamcorper justo. Duis commodo, ex eu dapibus semper, quam tellus pharetra nulla, vitae tristique libero tortor et massa. Proin sollicitudin dui mi, in ornare justo eleifend ac.\n" +
				"\n" +
				"Donec mi augue, lobortis ut felis vitae, sollicitudin sollicitudin quam. Nulla ut nisl vitae elit pretium ornare eget non eros. Aliquam erat volutpat. Praesent tristique viverra lacus. Duis eget dolor sollicitudin, vulputate arcu nec, interdum orci. Aenean vel libero in magna rhoncus dictum quis nec quam. Mauris blandit finibus fringilla. Aenean et cursus ex. Mauris sit amet ligula pellentesque metus interdum tristique eu vitae diam. Sed sed eros eget dolor iaculis egestas non id dolor. Cras vulputate ligula vel enim lacinia elementum.\n" +
				"\n" +
				"Donec lacinia semper urna vitae iaculis. Ut tempor leo et velit molestie venenatis. Praesent tempor viverra nunc, in semper ligula rhoncus eu. Nam convallis ligula et finibus porttitor. Cras ornare quam ut mauris efficitur, in scelerisque leo ultrices. Vivamus interdum, justo nec commodo commodo, erat leo tristique arcu, et tempor tortor risus eget magna. In eleifend tincidunt aliquam. Donec molestie lorem sit amet pulvinar pulvinar. Nunc vulputate magna tellus, et accumsan risus maximus ac. Proin finibus nisl sit amet ligula fermentum, a maximus urna pretium.", Nivel.MejorCalificado, "marta@marta.es", Empresa.Autonomo, Pais.España);

		vendedor1.setImagen("https://image.freepik.com/foto-gratis/mujer-positiva-sonriendo-modelo-divertido-que-presenta-cerca-pared-rosada-estudio_158538-3433.jpg");
		vendedor2.setImagen("https://image.freepik.com/foto-gratis/joven-mujer-hermosa-moda-mujer-ropa-casual-verano-guinando-ojo-modelo-divertido-aislado-pared-azul_158538-7772.jpg");
		vendedor3.setImagen("https://image.freepik.com/foto-gratis/retrato-hombre-guapo-barba-sonrie-felizmente-parte-delantera-muestra-dientes-perfectos-blancos-tiene-buen-humor-siente-satisfecho-vestido-poses-camiseta-rosa-basica-interior_273609-53432.jpg");
		vendedor4.setImagen("https://image.freepik.com/foto-gratis/chico-moderno-joven-guapo-cintura-arriba-cerdas-peinado-desordenado-usar-camiseta-roja-tomarse-manos-lados-posicion-loto-meditar-practicar-yoga-camara-mirada-divertida-labios-doblados-pared-blanca_176420-37087.jpg");
		vendedor5.setImagen("https://image.freepik.com/foto-gratis/retrato-guapo-sonriente-elegante-joven-modelo-vestido-ropa-jeans-hombre-moda_158538-5030.jpg");
		vendedor6.setImagen("https://image.freepik.com/foto-gratis/mujer-tranquila-cabello-tenido-pie-manos-cruzadas-sonrisa-sincera-encantadora-demostrando-sus-dientes-perfectos-posando_273609-7675.jpg");
		vendedor7.setImagen("https://image.freepik.com/foto-gratis/retrato-joven-modelo-elegante-riendo-ropa-casual-verano-colorido-maquillaje-natural-gris_158538-11785.jpg");
		vendedor8.setImagen("https://image.freepik.com/foto-gratis/apuesto-joven-deportista-alegre-tiene-cuerpo-deportivo-brazos-musculosos-viste-camiseta-blanca-simulada-tiene-pelo-corto-oscuro-sonrisa-atractiva-dientes-sobre-pared-purpura-espacio-copia-blanco-lado_273609-26661.jpg");
		vendedor9.setImagen("https://image.freepik.com/foto-gratis/retrato-hermosa-modelo-sonriente-peinado-afro-rizos-vestido-ropa-hipster-verano-chica-despreocupada-sexy-posando-junto-pared-azul-mujer-divertida-positiva-moda_158538-15691.jpg");

		// GUARDAMOS VENDEDORES EN EL REPOSITORIO
		vendedorRepository.saveAll(Arrays.asList(vendedor1, vendedor2, vendedor3, vendedor4, vendedor5, vendedor6, vendedor7, vendedor8, vendedor9));

		System.out.println("Número de vendedores en base de datos " +  vendedorRepository.findAll().size());

		// CREAMOS CATEOGRIAS
		Categoria categoria1 = new Categoria(null, "Desarrollo web");
		Categoria categoria2 = new Categoria(null, "Diseño web");
		Categoria categoria3= new Categoria(null, "SEO");
		Categoria categoria4 = new Categoria(null, "Marketing digital");
		Categoria categoria5 = new Categoria(null, "Diseño UX/UI");
		Categoria categoria6 = new Categoria(null, "Social Media");
		Categoria categoria7 = new Categoria(null, "Packaging");
		Categoria categoria8 = new Categoria(null, "Logo Design");
		Categoria categoria9 = new Categoria(null, "animación 3D");

		List<Categoria> categorias = new ArrayList<>(Arrays.asList(categoria1, categoria2, categoria3,
				categoria4, categoria5, categoria6, categoria7, categoria8, categoria9));
//		categorias.forEach(System.out::println);

		// GUARDAMOS CATEGORIAS EN EL REPOSITORIO
		categoriaRepository.saveAll(categorias);

		List<Categoria> categorias2 = categoriaRepository.findAll();
		for(Categoria categoria : categorias2){
			System.out.println(categoria.getId());
		}

		System.out.println("Número de categorías: " + categoriaRepository.findAll().size());

		//AÑADIMOS CATEGORIAS A CADA TRABAJO
		trabajo1.addCategoria(categoria1);
		trabajo2.addCategoria(categoria9);
		trabajo3.addCategoria(categoria3);
		trabajo4.addCategoria(categoria4);
		trabajo5.addCategoria(categoria5);
		trabajo6.addCategoria(categoria6);
		trabajo7.addCategoria(categoria7);
		trabajo8.addCategoria(categoria8);
		trabajo9.addCategoria(categoria9);
		trabajo10.addCategoria(categoria4);
		trabajo11.addCategoria(categoria1);
		trabajo12.addCategoria(categoria2);
		trabajo13.addCategoria(categoria3);
		trabajo14.addCategoria(categoria6);
		trabajo15.addCategoria(categoria9);
		trabajo16.addCategoria(categoria3);
		trabajo17.addCategoria(categoria1);
		trabajo18.addCategoria(categoria3);
		trabajo19.addCategoria(categoria8);
		trabajo20.addCategoria(categoria7);


		// ASIGNAMOS TRABAJO A VENDEDOR
		trabajo1.addVendedor(vendedor1);
		trabajo2.addVendedor(vendedor2);
		trabajo3.addVendedor(vendedor3);
		trabajo4.addVendedor(vendedor5);
		trabajo5.addVendedor(vendedor5);
		trabajo6.addVendedor(vendedor6);
		trabajo7.addVendedor(vendedor1);
		trabajo8.addVendedor(vendedor2);
		trabajo9.addVendedor(vendedor3);
		trabajo10.addVendedor(vendedor4);
		trabajo11.addVendedor(vendedor5);
		trabajo12.addVendedor(vendedor6);
		trabajo13.addVendedor(vendedor1);
		trabajo14.addVendedor(vendedor2);
		trabajo15.addVendedor(vendedor5);
		trabajo16.addVendedor(vendedor4);
		trabajo17.addVendedor(vendedor4);
		trabajo18.addVendedor(vendedor7);


		// GUARDAMOS TRABAJOS A REPOSITORIO
		trabajoRepository.saveAll(Arrays.asList(trabajo1, trabajo2, trabajo3, trabajo4, trabajo5, trabajo6,
				trabajo7, trabajo8, trabajo9, trabajo10, trabajo11, trabajo12, trabajo13, trabajo14, trabajo15, trabajo16,
				trabajo17, trabajo18));

		List<Categoria> categorias3 = categoriaRepository.findAll();
		for(Categoria categoria : categorias3){
			System.out.println(categoria.getNombre());
			for(Trabajo trabajo : categoria.getTrabajos()){
				System.out.println(trabajo.getId());
			}
		}

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
		Review review11 = new Review(null,5,"Excelente trabajo", trabajo5, vendedor5);
		Review review12 = new Review(null,5,"Excelente trabajo", trabajo7, vendedor5);
		Review review13 = new Review(null,4,"Me gustó bastante", trabajo1, vendedor1);

		// GUARDAMOS REVIEWS
		reviewRepository.saveAll(Arrays.asList(review1, review2, review3, review4, review5, review6, review7, review8, review9, review10, review11, review12, review13));

		//Inicializar usuarios y roles
		BCryptPasswordEncoder bcryptEncoder = null;
		Role role1 = new Role(1,"ADMIN", "Rol Admin");
		Role role2 = new Role(2,"USER", "Rol User");
		roleRepository.save(role1);
		roleRepository.save(role2);
		User user = new User(1,"admin","$2a$10$DTAejq8zVwf.dMadV1SAvuNXAbXjroY.G7dWpS1tzoGolwn7nexTm","","","","");
		Set<Role> useradmin =new HashSet<>();
		useradmin.add(role1);
		useradmin.add(role2);
		user.setRoles(useradmin);
		UserServiceImpl encriptarUser = new UserServiceImpl();
		userRepository.save(user);

	}
}