package br.com.senior.api.resources;

import br.com.senior.api.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api")
public class CategoriaResource {

    @Autowired
    private CategoriaService service;

    @GetMapping("/categorias/{id}")
    public ResponseEntity<?> find(@PathVariable Long id) {
        return ResponseEntity.ok().body(service.buscar(id));
    }
}
