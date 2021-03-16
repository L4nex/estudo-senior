package br.com.senior.api.resources;

import br.com.senior.api.entity.Cliente;
import br.com.senior.api.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api")
public class ClienteResource {

    @Autowired
    private ClienteService service;

    @GetMapping("/clientes/{id}")
    public Cliente find(@PathVariable Long id) {
        return service.buscar(id);
    }
}
