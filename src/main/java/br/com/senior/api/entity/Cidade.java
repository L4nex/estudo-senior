package br.com.senior.api.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
public class Cidade implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;


    @JsonBackReference
    @ManyToOne(targetEntity = Estado.class, fetch = FetchType.LAZY)
    private Estado estado;

}
