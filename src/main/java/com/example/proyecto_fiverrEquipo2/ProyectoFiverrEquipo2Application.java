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
		Trabajo trabajo1 = new Trabajo(null, "laia_hidalgo", "Diseño UX/UI", 800.50, LocalDate.of(2021, Calendar.OCTOBER, 20), Idioma.Español, Pais.España);
		Trabajo trabajo2 = new Trabajo(null, "maria_perez", "Branding & Animación 3D", 900.30, LocalDate.of(2021, Calendar.OCTOBER, 20), Idioma.Español, Pais.EEUU);
		Trabajo trabajo3 = new Trabajo(null, "luis_callado", "Diseños creativos", 1200.80, LocalDate.of(2021, Calendar.NOVEMBER, 4), Idioma.Español, Pais.Italia);
		Trabajo trabajo4 = new Trabajo(null, "marcos_ruiz", "Diseño Responsive", 750.50, LocalDate.of(2021, Calendar.JULY, 13), Idioma.Frances, Pais.Francia);
		Trabajo trabajo5 = new Trabajo(null, "marcos_ruiz", "Diseño Responsive", 750.50, LocalDate.of(2021, Calendar.JULY, 13), Idioma.Frances, Pais.Francia);
		Trabajo trabajo6 = new Trabajo(null, "lucia_ortiz", "Desarrollo web", 903.54, LocalDate.of(2021, Calendar.OCTOBER, 20),Idioma.Ingles, Pais.ReinoUnido);
		Trabajo trabajo7 = new Trabajo(null, "laia_hidalgo", "Diseño UX/UI", 1220.50,LocalDate.of(2021, Calendar.OCTOBER, 20), Idioma.Frances, Pais.Francia);
		Trabajo trabajo8 = new Trabajo(null, "maria_perez", "Desarrollo web", 1300.50, LocalDate.of(2021, Calendar.JULY, 13), Idioma.Ingles, Pais.EEUU);
		Trabajo trabajo9 = new Trabajo(null, "luis_callado", "Branding & Animación 3D", 1311.70, LocalDate.of(2021, Calendar.NOVEMBER, 4), Idioma.Español, Pais.España);
		Trabajo trabajo10 = new Trabajo(null, "toni_rubio", "Desarrollo web", 1220.50, LocalDate.of(2021, Calendar.OCTOBER, 20),Idioma.Frances, Pais.Francia);
		Trabajo trabajo11 = new Trabajo(null, "marcos_ruiz", "Diseños SEO optimizado", 1220.50, LocalDate.of(2021, Calendar.JULY, 13), Idioma.Frances, Pais.Francia);
		Trabajo trabajo12 = new Trabajo(null, "lucia_ortiz", "Desarrollo web", 900.50, LocalDate.of(2021, Calendar.OCTOBER, 20),Idioma.Frances, Pais.Francia);
		Trabajo trabajo13 = new Trabajo(null, "laia_hidalgo", "Diseño UX/UI", 1220.50, LocalDate.of(2021, Calendar.NOVEMBER, 4),Idioma.Ingles, Pais.EEUU);
		Trabajo trabajo14 = new Trabajo(null, "maria_perez", "Desarrollo web", 854.50, LocalDate.of(2021, Calendar.JULY, 13),Idioma.Ingles, Pais.EEUU);
		Trabajo trabajo15 = new Trabajo(null, "luis_callado", "Diseño Responsive", 1220.50, LocalDate.of(2021, Calendar.OCTOBER, 20),Idioma.Frances, Pais.Francia);
		Trabajo trabajo16 = new Trabajo(null, "toni_rubio", "Desarrollo web", 1220.50, LocalDate.of(2021, Calendar.SEPTEMBER, 19), Idioma.Español, Pais.España);
		Trabajo trabajo17 = new Trabajo(null, "toni_rubio", "Branding & Animación 3D", 1220.50, LocalDate.of(2021, Calendar.SEPTEMBER, 19), Idioma.Español, Pais.España);
		Trabajo trabajo18 = new Trabajo(null, "marta_colado", "Diseños SEO optimizado", 1220.50, LocalDate.of(2021, Calendar.JULY, 13), Idioma.Frances, Pais.Francia);


		trabajo1.setImagen("https://image.freepik.com/vector-gratis/fondo-degradado-ui-ux_23-2149065782.jpg");
		trabajo2.setImagen("https://image.freepik.com/vector-gratis/tema-colorido-conjunto-emoji_79603-1264.jpg");
		trabajo3.setImagen("https://image.freepik.com/vector-gratis/fondo-abstracto-colorido-diseno-plano_23-2149120550.jpg");
		trabajo4.setImagen("https://image.freepik.com/vector-gratis/optimizacion-seo_24908-55896.jpg");
		trabajo5.setImagen("https://image.freepik.com/psd-gratis/mockup-dispositivos-electronicos_23-2147864572.jpg");
		trabajo6.setImagen("https://image.freepik.com/vector-gratis/desarrolladores-web-dibujados-mano_23-2148815976.jpg");

		// GUARDAMOS TRABAJOS EN EL REPOSITORIO
		trabajoRepository.saveAll(Arrays.asList(trabajo1, trabajo2, trabajo3, trabajo4, trabajo5, trabajo6, trabajo7,
				trabajo8, trabajo9, trabajo10, trabajo11, trabajo12, trabajo13, trabajo14, trabajo15, trabajo16, trabajo17, trabajo18));

		System.out.println("Número de trabajos en base de datos " +  trabajoRepository.findAll().size());

		// CREAMOS VENDEDOR
		Vendedor vendedor1 = new Vendedor(null, "laia_hidalgo", "Diseño wirefreames, UX/UI y prototipos", Nivel.Nivel1, "laia@laia.es", Empresa.Autonomo, Pais.España);
		Vendedor vendedor2 = new Vendedor(null, "maria_perez", "Proporciono consultoría, branding y animación 3D ", Nivel.Nivel1, "maria@maria.es", Empresa.Autonomo, Pais.EEUU);
		Vendedor vendedor3 = new Vendedor(null, "luis_callado", "Diseño web creativo y único", Nivel.Nivel2, "luis@luis.es", Empresa.Autonomo, Pais.Italia);
		Vendedor vendedor4 = new Vendedor(null, "toni_rubio", "Diseño web optimizado para SEO 100%", Nivel.Nivel2, "toni@toni.es", Empresa.Autonomo, Pais.España);
		Vendedor vendedor5 = new Vendedor(null, "marcos_ruiz", "Diseñamos tu web profesional responsive", Nivel.Nivel1, "marcos@marcos.es", Empresa.Privada, Pais.Francia);
		Vendedor vendedor6 = new Vendedor(null, "lucia_ortiz", "Diseñamos tu ecommerce a tu medida", Nivel.Nivel1, "lucia@lucia.es", Empresa.Privada, Pais.Francia);
		Vendedor vendedor7 = new Vendedor(null, "marta_colado", "Diseñamos tu ecommerce a tu medida", Nivel.MejorCalificado, "marta@marta.es", Empresa.Autonomo, Pais.España);

		vendedor1.setImagen("https://image.freepik.com/foto-gratis/mujer-positiva-sonriendo-modelo-divertido-que-presenta-cerca-pared-rosada-estudio_158538-3433.jpg");
		vendedor2.setImagen("https://image.freepik.com/foto-gratis/joven-mujer-hermosa-moda-mujer-ropa-casual-verano-guinando-ojo-modelo-divertido-aislado-pared-azul_158538-7772.jpg");
		vendedor3.setImagen("https://image.freepik.com/foto-gratis/retrato-hombre-guapo-barba-sonrie-felizmente-parte-delantera-muestra-dientes-perfectos-blancos-tiene-buen-humor-siente-satisfecho-vestido-poses-camiseta-rosa-basica-interior_273609-53432.jpg");
		vendedor4.setImagen("https://image.freepik.com/foto-gratis/chico-moderno-joven-guapo-cintura-arriba-cerdas-peinado-desordenado-usar-camiseta-roja-tomarse-manos-lados-posicion-loto-meditar-practicar-yoga-camara-mirada-divertida-labios-doblados-pared-blanca_176420-37087.jpg");

		// GUARDAMOS VENDEDORES EN EL REPOSITORIO
		vendedorRepository.saveAll(Arrays.asList(vendedor1, vendedor2, vendedor3, vendedor4, vendedor5, vendedor6, vendedor7));

		System.out.println("Número de vendedores en base de datos " +  vendedorRepository.findAll().size());

		// CREAMOS CATEOGRIAS
		Categoria categoria1 = new Categoria(null, "Desarrollo web");
		Categoria categoria2 = new Categoria(null, "Diseño web");
		Categoria categoria3= new Categoria(null, "Diseño Responsive");
		Categoria categoria4 = new Categoria(null, "Diseño creativo");
		Categoria categoria5 = new Categoria(null, "Diseño UX/UI");
		Categoria categoria6 = new Categoria(null, "Social Media");
		Categoria categoria7 = new Categoria(null, "Packaging design");
		Categoria categoria8 = new Categoria(null, "Logo Design");
		Categoria categoria9 = new Categoria(null, "Branding");

		List<Categoria> categorias = new ArrayList<Categoria>(Arrays.asList(categoria1, categoria2, categoria3,
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
		trabajo1.addCategoria(categoria5);
		trabajo2.addCategoria(categoria9);
		trabajo3.addCategoria(categoria4);
		trabajo4.addCategoria(categoria3);
		trabajo5.addCategoria(categoria3);
		trabajo6.addCategoria(categoria1);
		trabajo7.addCategoria(categoria1);
		trabajo8.addCategoria(categoria1);
		trabajo9.addCategoria(categoria9);
		trabajo10.addCategoria(categoria1);
		trabajo11.addCategoria(categoria2);
		trabajo12.addCategoria(categoria1);
		trabajo13.addCategoria(categoria5);
		trabajo14.addCategoria(categoria1);
		trabajo15.addCategoria(categoria3);
		trabajo16.addCategoria(categoria1);
		trabajo17.addCategoria(categoria9);
		trabajo18.addCategoria(categoria2);


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