package br.com.senior.api.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Endereco implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String logradouro;
    private String numero;
    private String complemento;
    private String bairro;
    private String cep;

    @JsonBackReference
    @ManyToOne(targetEntity = Cliente.class, fetch = FetchType.LAZY)
    private Cliente cliente;

    @ManyToOne(targetEntity = Cidade.class, fetch = FetchType.LAZY)
    private Cidade cidade;
}
