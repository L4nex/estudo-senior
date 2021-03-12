package br.com.senior.api.repositories;

import br.com.senior.api.entity.Estado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstadoRepository extends JpaRepository<Estado, Long> {
}
