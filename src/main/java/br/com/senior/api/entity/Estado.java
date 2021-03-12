package br.com.senior.api.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
public class Estado implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    @JsonManagedReference
    @OneToMany(targetEntity = Cidade.class, fetch = FetchType.LAZY, mappedBy = "estado")
    private List<Cidade> cidades;
}
