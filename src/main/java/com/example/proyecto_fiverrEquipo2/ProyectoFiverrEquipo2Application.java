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

		// CREAMOS FECHAS DE PUBLICACIÓN
		LocalDate fecha_Publicacion1 = LocalDate.of(2021, Calendar.SEPTEMBER, 19);
		LocalDate fecha_Publicacion2 = LocalDate.of(2021, Calendar.OCTOBER, 20);
		LocalDate fecha_Publicacion3 = LocalDate.of(2021, Calendar.NOVEMBER, 4);
		LocalDate fecha_Publicacion4 = LocalDate.of(2021, Calendar.SEPTEMBER, 9);
		LocalDate fecha_Publicacion5 = LocalDate.of(2021, Calendar.JULY, 13);

		// CREAMOS TRABAJOS
		Trabajo trabajo1 = new Trabajo(null, "Empresa1", "Diseño UX/UI", 800.50, Idioma.Español, Pais.España);
		Trabajo trabajo2 = new Trabajo(null, "Empresa2", "Branding & Animación 3D", 900.30, Idioma.Español, Pais.EEUU);
		Trabajo trabajo3 = new Trabajo(null, "Empresa3", "Diseños creativos", 1200.80, Idioma.Español, Pais.Italia);
		Trabajo trabajo4 = new Trabajo(null, "Empresa4", "Diseños SEO optimizado", 1500.25, Idioma.Español, Pais.España);
		Trabajo trabajo5 = new Trabajo(null, "Empresa5", "Diseño Responsive", 750.50, Idioma.Frances, Pais.Francia);
		Trabajo trabajo6 = new Trabajo(null, "Empresa6", "Desarrollo web", 1220.50, Idioma.Frances, Pais.Francia);

		trabajo1.setImagen("https://image.freepik.com/vector-gratis/fondo-degradado-ui-ux_23-2149065782.jpg");
		trabajo2.setImagen("https://image.freepik.com/vector-gratis/tema-colorido-conjunto-emoji_79603-1264.jpg");
		trabajo3.setImagen("https://image.freepik.com/vector-gratis/fondo-abstracto-colorido-diseno-plano_23-2149120550.jpg");
		trabajo4.setImagen("https://image.freepik.com/vector-gratis/optimizacion-seo_24908-55896.jpg");
		trabajo5.setImagen("https://image.freepik.com/psd-gratis/mockup-dispositivos-electronicos_23-2147864572.jpg");
		trabajo6.setImagen("https://image.freepik.com/vector-gratis/desarrolladores-web-dibujados-mano_23-2148815976.jpg");

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
		Vendedor vendedor1 = new Vendedor(null, "laia_hidalgo", "Diseño wirefreames, UX/UI y prototipos", Nivel.Nivel1, "laia@laia.es", Empresa.Autonomo, Pais.España);
		Vendedor vendedor2 = new Vendedor(null, "maria_perez", "Proporciono consultoría, branding y animación 3D ", Nivel.Nivel1, "maria@maria.es", Empresa.Autonomo, Pais.EEUU);
		Vendedor vendedor3 = new Vendedor(null, "luis_callado", "Diseño web creativo y único", Nivel.Nivel2, "luis@luis.es", Empresa.Autonomo, Pais.Italia);
		Vendedor vendedor4 = new Vendedor(null, "toni_rubio", "Diseño web optimizado para SEO 100%", Nivel.Nivel2, "toni@toni.es", Empresa.Autonomo, Pais.España);
		Vendedor vendedor5 = new Vendedor(null, "marcos_ruiz", "Diseñamos tu web profesional responsive", Nivel.Nivel1, "marcos@marcos.es", Empresa.Privada, Pais.Francia);
		Vendedor vendedor6 = new Vendedor(null, "lucia_ortiz", "Diseñamos tu ecommerce a tu medida", Nivel.Nivel1, "lucia@lucia.es", Empresa.Privada, Pais.Francia);

		vendedor1.setImagen("https://image.freepik.com/foto-gratis/mujer-positiva-sonriendo-modelo-divertido-que-presenta-cerca-pared-rosada-estudio_158538-3433.jpg");
		vendedor2.setImagen("https://image.freepik.com/foto-gratis/joven-mujer-hermosa-moda-mujer-ropa-casual-verano-guinando-ojo-modelo-divertido-aislado-pared-azul_158538-7772.jpg");
		vendedor3.setImagen("https://image.freepik.com/foto-gratis/retrato-hombre-guapo-barba-sonrie-felizmente-parte-delantera-muestra-dientes-perfectos-blancos-tiene-buen-humor-siente-satisfecho-vestido-poses-camiseta-rosa-basica-interior_273609-53432.jpg");
		vendedor4.setImagen("https://image.freepik.com/foto-gratis/chico-moderno-joven-guapo-cintura-arriba-cerdas-peinado-desordenado-usar-camiseta-roja-tomarse-manos-lados-posicion-loto-meditar-practicar-yoga-camara-mirada-divertida-labios-doblados-pared-blanca_176420-37087.jpg");

		// GUARDAMOS VENDEDORES EN EL REPOSITORIO
		vendedorRepository.saveAll(Arrays.asList(vendedor1, vendedor2, vendedor3, vendedor4, vendedor5, vendedor6));

		System.out.println("Número de vendedores en base de datos " +  vendedorRepository.findAll().size());

		// CREAMOS CATEOGRIAS
		Categoria categoria1 = new Categoria(null, "Desarrollo web");
		Categoria categoria2 = new Categoria(null, "Diseño web");
		Categoria categoria3= new Categoria(null, "Diseño Responsive");
		Categoria categoria4 = new Categoria(null, "Diseño creativo");
		Categoria categoria5 = new Categoria(null, "Diseño UX/UI");

		List<Categoria> categorias = new ArrayList<Categoria>(Arrays.asList(categoria1, categoria2, categoria3, categoria4, categoria5));
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

		// GUARDAMOS REVIEWS
		reviewRepository.saveAll(Arrays.asList(review1, review2, review3, review4, review5, review6, review7, review8, review9, review10));

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