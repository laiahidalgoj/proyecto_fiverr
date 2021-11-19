package com.example.proyecto_fiverrEquipo2.controllers;

import com.example.proyecto_fiverrEquipo2.Dto.TrabajoDto;
import com.example.proyecto_fiverrEquipo2.entities.Categoria;
import com.example.proyecto_fiverrEquipo2.entities.Review;
import com.example.proyecto_fiverrEquipo2.entities.Trabajo;
import com.example.proyecto_fiverrEquipo2.entities.Vendedor;
import com.example.proyecto_fiverrEquipo2.repository.CategoriaRepository;
import com.example.proyecto_fiverrEquipo2.repository.ReviewRepository;
import com.example.proyecto_fiverrEquipo2.repository.TrabajoRepository;
import com.example.proyecto_fiverrEquipo2.repository.VendedorRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class TrabajoController {

    private final Logger log = LoggerFactory.getLogger(TrabajoController.class);

    private TrabajoRepository trabajoRepository;
    private CategoriaRepository categoriaRepository;
    private VendedorRepository vendedorRepository;
    private ReviewRepository reviewRepository;

    public TrabajoController(TrabajoRepository trabajoRepository, CategoriaRepository categoriaRepository, VendedorRepository vendedorRepository, ReviewRepository reviewRepository) {
        this.trabajoRepository = trabajoRepository;
        this.categoriaRepository = categoriaRepository;
        this.vendedorRepository = vendedorRepository;
        this.reviewRepository = reviewRepository;
    }


    /**
     * Buscar todos los trabajos en BBDD
     */
    @CrossOrigin
    @GetMapping("/api/trabajos")
    public List<Trabajo> findAll() {
        return trabajoRepository.findAll();
    }

    @CrossOrigin
    @GetMapping("/api/trabajo")
    public List<TrabajoDto> findAllJobs() {

        List<Trabajo> trabajos = trabajoRepository.findAll();
        List<Review> reviews = reviewRepository.findAll();
        List<TrabajoDto> trabajoDto =new ArrayList<TrabajoDto>();

        // CREAMOS DATOS TRABAJO
        TrabajoDto trabajosDto = new TrabajoDto();

        // ITERAMOS SOBRE EL TRABAJO
        for(int i=0; i<trabajos.size();i++){
            trabajosDto = new TrabajoDto(trabajos.get(i).getId(),trabajos.get(i).getNombre(),trabajos.get(i).getImagen(),
                    trabajos.get(i).getDescripcion(), trabajos.get(i).getPrecio(), trabajos.get(i).getCategorias(),
                    trabajos.get(i).getVendedores(),trabajos.get(i).getFecha_Publicacion(),trabajos.get(i).getPaises(),
                    trabajos.get(i).getIdiomas());

            // SUMAMOS Y HACEMOS PROMEDIO REVIEWS
            int sumReview=0, cantReview=0;

            double promedio=0;
            for (int j=0;j<reviews.size();j++) {
                if ((reviews.get(j).getTrabajos()) == (trabajos.get(i))) {
                    cantReview++;
                    sumReview = sumReview + reviews.get(j).getPuntuacion();
                }
            }
            if (cantReview>0){
                trabajosDto.setReviews(cantReview);
                promedio = sumReview/cantReview;
                trabajosDto.setPromedio(promedio);
            }
            trabajoDto.add(trabajosDto);
        }

        return trabajoDto;
    }

    /**
     * Buscar trabajos según id
     * Request
     * Response
     */

    @CrossOrigin
//    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @GetMapping("/api/trabajos/{id}")
    public ResponseEntity<Trabajo> findByIdJobs(@PathVariable Long id) {
        Optional<Trabajo> trabajosOpt = trabajoRepository.findById(id);
        if (trabajosOpt.isPresent()) {
            return ResponseEntity.ok(trabajosOpt.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @CrossOrigin
    @GetMapping("/api/trabajo/{id}")
    public ResponseEntity<Trabajo> findById(@PathVariable Long id) {
        Optional<Trabajo> trabajosOpt = trabajoRepository.findById(id);
        if (trabajosOpt.isPresent()) {
            return ResponseEntity.ok(trabajosOpt.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Crear un nuevo trabajo en la BBDD
     *
     * @param trabajo
     * @return
     */
    @CrossOrigin
//    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @PostMapping("/api/trabajo")
    public ResponseEntity<Trabajo> create(@RequestBody Trabajo trabajo) {
        if(trabajo.getId() != null) {
            log.warn("Intentando crear un trabajo con id");
            return ResponseEntity.badRequest().build();
        }

        Set<Vendedor> vendedor = trabajo.getVendedores();

        for (Vendedor vendedores: vendedor) {
            if(vendedores.getId() == null) {
                log.info("Creando vendedor inexistente: " + vendedores.getNombre());
                vendedorRepository.save(vendedores);
            }
        }

        Set<Categoria> categorias = trabajo.getCategorias();

        for (Categoria categoria: categorias) {
            if(categoria.getId() == null) {
                log.info("Creando categoría inexistente: " + categoria.getNombre());
                categoriaRepository.save(categoria);
            }
        }

        Trabajo trabajoAGuardar = new Trabajo(

                null,
                trabajo.getNombre(),
                trabajo.getDescripcion(),
                trabajo.getImagen(),
                trabajo.getPrecio(),
                trabajo.getFecha_Publicacion(),
                trabajo.getIdiomas(),
                trabajo.getPaises()
        );

        List<Categoria> categorias2 = new ArrayList<>(trabajo.getCategorias());
        List<Vendedor> vendedores2 = new ArrayList<>(trabajo.getVendedores());


        for (Vendedor vendedores: vendedores2) {
            trabajoAGuardar.addVendedor(vendedores);
        }
        for (Categoria categoria: categorias2) {
            trabajoAGuardar.addCategoria(categoria);
        }

        Trabajo result = trabajoRepository.save(trabajoAGuardar);
        return ResponseEntity.ok(result);
    }

    /**
     * Actualizar un trabajo en BBDD
     *
     */
    @CrossOrigin
//    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @PutMapping("/api/trabajo")
    public ResponseEntity<Trabajo> update(@RequestBody Trabajo trabajo) {
        if (trabajo.getId() == null) {
            log.warn("Intentando actualizar un trabajo inexistente");
            return ResponseEntity.badRequest().build();
        }
        if (!trabajoRepository.existsById(trabajo.getId())) {
            log.warn("Intentando actualizar un trabajo inexistente");
            return ResponseEntity.notFound().build();
        }

        Set<Categoria> categorias = trabajo.getCategorias();

        for (Categoria categoria: categorias) {
            if(categoria.getId() == null) {
                log.info("Creando categoría inexistente: " + categoria.getNombre());
                categoriaRepository.save(categoria);
            }
        }

        Set<Vendedor> vendedores = trabajo.getVendedores();

        for (Vendedor vendedor: vendedores) {
            if(vendedor.getId() == null) {
                log.info("Creando vendedor inexistente: " + vendedor.getNombre());
                vendedorRepository.save(vendedor);
            }
        }

        Optional<Trabajo> trabajoOpt = trabajoRepository.findById(trabajo.getId());
        if (trabajoOpt.isPresent()) {
            Trabajo trabajoOld = trabajoOpt.get();
            eliminarCategorias(trabajoOld);
            eliminarVendedores(trabajoOld);
        }

        Trabajo trabajoAGuardar = new Trabajo(

                trabajo.getId(),
                trabajo.getNombre(),
                trabajo.getDescripcion(),
                trabajo.getImagen(),
                trabajo.getPrecio(),
                trabajo.getFecha_Publicacion(),
                trabajo.getIdiomas(),
                trabajo.getPaises()
        );

        for (Vendedor vendedor: trabajo.getVendedores()) {
            trabajoAGuardar.addVendedor(vendedor);
        }
        for (Categoria categoria: trabajo.getCategorias()) {
            trabajoAGuardar.addCategoria(categoria);
        }

        Trabajo result = trabajoRepository.save(trabajoAGuardar);
        log.info("Actualizando trabajo: " + trabajoAGuardar.getId());
        return ResponseEntity.ok(result);
    }

    /**
     * Método que elimina cada trabajo de las categorias.
     */
    private void eliminarCategorias(Trabajo trabajo) {
        Set<Categoria> categoriasEliminar = new HashSet<>(trabajo.getCategorias());
        for (Categoria categoria : categoriasEliminar) {
            trabajo.removeCategoria(categoria, true);
        }
    }

    /**
     * Método que elimina cada trabajo de los vendedores.
     */
    private void eliminarVendedores(Trabajo trabajo) {
        Set<Vendedor> vendedoresEliminar = new HashSet<>(trabajo.getVendedores());
        for (Vendedor vendedor: vendedoresEliminar) {
            trabajo.removeVendedor(vendedor, true);
        }
    }

    // TODO

    /**
     * Eliminar un trabajo de la bbdd.
     *
     * @param id
     * @return
     */
    @CrossOrigin
//    @PreAuthorize("hasAnyRole('ADMIN')")
    @DeleteMapping("/api/trabajo/{id}")
    public ResponseEntity<Trabajo> delete(@PathVariable Long id) {

        if (!trabajoRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        Optional<Trabajo> trabajoOpt = trabajoRepository.findById(id);
        if (trabajoOpt.isPresent()) {
            Trabajo trabajoAnti = trabajoOpt.get();
            eliminarCategorias(trabajoAnti);
            eliminarVendedores(trabajoAnti);
        }

        trabajoRepository.deleteById(id);
        log.info("Eliminando trabajo: " + id);
        return ResponseEntity.noContent().build();
    }

    /**
     * Eliminar todos los trabajos de la base de datos.
     *
     * @return
     */
    @CrossOrigin
//    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @DeleteMapping("/api/trabajos")
    public ResponseEntity<Trabajo> deleteAll() {

        List<Trabajo> trabajos = trabajoRepository.findAll();
        for (Trabajo trabajo : trabajos) {
            eliminaCategorias(trabajo);
            eliminaVendedores(trabajo);

        }

        List<Categoria> categorias = categoriaRepository.findAll();
        List<Vendedor> vendedores = vendedorRepository.findAll();

        vendedorRepository.deleteAll();
        log.info("Eliminando todos los trabajos");
        return ResponseEntity.noContent().build();
    }

    /**
     * Método que desvincula cada trabajo de ls categorias que están ligadas a ellos.
     *
     * @param trabajo
     */
    private void eliminaCategorias(Trabajo trabajo) {
        Set<Categoria> categoriasABorrar = new HashSet<>(trabajo.getCategorias());
        for (Categoria categoria : categoriasABorrar) {
            trabajo.removeCategoria(categoria, true);
        }
    }

    /**
     * Método que desvincula cada trabajo de los vendedores.
     *
     * @param trabajo
     */
    private void eliminaVendedores(Trabajo trabajo) {
        Set<Vendedor> vendedorABorrar = new HashSet<>(trabajo.getVendedores());
        for (Vendedor vendedor: vendedorABorrar) {
            trabajo.removeVendedor(vendedor, true);
        }
    }

}
