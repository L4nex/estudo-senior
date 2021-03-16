package br.com.senior.api.services;

import br.com.senior.api.entity.Cliente;
import br.com.senior.api.repositories.ClienteRepository;
import br.com.senior.api.services.excepetions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

    public Cliente buscar(Long id) {
        Optional<Cliente> cliente = repository.findById(id);

        return cliente.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName()));
    }
}



