package com.example.proyecto_fiverrEquipo2.controllers;

import com.example.proyecto_fiverrEquipo2.entities.Trabajo;
import com.example.proyecto_fiverrEquipo2.entities.Vendedor;
import com.example.proyecto_fiverrEquipo2.repository.TrabajoRepository;
import com.example.proyecto_fiverrEquipo2.repository.VendedorRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
public class VendedorController {

    private final Logger log = LoggerFactory.getLogger(VendedorController.class);

    private VendedorRepository vendedorRepository;
    private TrabajoRepository trabajoRepository;

    public VendedorController(VendedorRepository vendedorRepository, TrabajoRepository trabajoRepository) {
        this.vendedorRepository = vendedorRepository;
        this.trabajoRepository = trabajoRepository;
    }

    /**
     * Buscar todos los vendedores en BBDD
     */
    @CrossOrigin
    @GetMapping("/api/vendedor")
    public List<Vendedor> findAll() {
        return vendedorRepository.findAll();
    }

    /**
     * Buscar vendedor por  id
     * Request
     * Response
     */
    @CrossOrigin
    @GetMapping("/api/vendedor/{id}")
    public ResponseEntity<Vendedor> findById(@PathVariable Long id) {
        Optional<Vendedor> vendedorOpt = vendedorRepository.findById(id);
        if (vendedorOpt.isPresent()) {
            return ResponseEntity.ok(vendedorOpt.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Crear vendedor en la bbdd.
     *
     */
    @CrossOrigin
//    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @PostMapping("/api/vendedor")
    public ResponseEntity<Vendedor> create(@RequestBody Vendedor vendedor) {
        if (vendedor.getId() != null) {
            log.warn("Intentando crear un vendedor con id");
            return ResponseEntity.badRequest().build();
        }
        List<Vendedor> vendedores = vendedorRepository.findAll();
        for (Vendedor vendedorExistente : vendedores) {
            if (vendedorExistente.getNombre().equals(vendedor.getNombre())) {
                log.warn("Intentando crear un vendedor ya existente");
                return ResponseEntity.badRequest().build();
            }
        }
        Vendedor result = vendedorRepository.save(vendedor);
        return ResponseEntity.ok(result);
    }

    /**
     * Actualizar un vendedor en la bbdd.
     */
    @CrossOrigin
//    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @PutMapping("/api/vendedor")
    public ResponseEntity<Vendedor> update(@RequestBody Vendedor vendedor) {
        if (vendedor.getId() == null) {
            log.warn("Intentando actualizar un vendedor sin añadir el id");
            return ResponseEntity.badRequest().build();
        }
        if (!vendedorRepository.existsById(vendedor.getId())) {
            log.warn("Intentando actualizar un vendedor con id inexistente");
            return ResponseEntity.notFound().build();
        }

        Vendedor result = vendedorRepository.save(vendedor);
        return ResponseEntity.ok(result);
    }

    // TODO

    /**
     * Eliminar un vendedor de la bbdd.
     *
     * @param id
     * @return
     */
    @CrossOrigin
//    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @DeleteMapping("/api/vendedor/{id}")
    public ResponseEntity<Vendedor> delete(@PathVariable Long id) {

        if (!vendedorRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        Optional<Vendedor> vendedorOpt = vendedorRepository.findById(id);
        if (vendedorOpt.isPresent()) {
            Vendedor vendedor = vendedorOpt.get();
            Set<Trabajo> trabajos =vendedor.getTrabajo();
            for (Trabajo trabajo : trabajos) {
                trabajo.removeVendedor(vendedor, false);
                trabajoRepository.save(trabajo);
            }
        }

        vendedorRepository.deleteById(id);

        return ResponseEntity.noContent().build();
    }

    /**
     * Eliminar todos los vendedores de la base de datos
     * @return
     */
    @CrossOrigin
//    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @DeleteMapping("/api/vendedor")
    public ResponseEntity<Vendedor> deleteAll() {
        List<Vendedor> vendedores = vendedorRepository.findAll();

        for (Vendedor vendedor: vendedores) {
            Set<Trabajo> trabajos = vendedor.getTrabajo();
            for (Trabajo trabajo: trabajos) {
                trabajo.removeVendedor(vendedor, false);
                trabajoRepository.save(trabajo);
            }
        }

        vendedorRepository.deleteAll();

        return ResponseEntity.noContent().build();
    }

}
