package br.com.senior.api.services;

import br.com.senior.api.entity.Categoria;
import br.com.senior.api.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository repo;

    public Categoria buscar(Long id) {
        Optional<Categoria> obj = repo.findById(id);
        return obj.orElse(null);
    }
}
