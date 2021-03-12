package br.com.senior.api.entity;

import lombok.Data;

import javax.persistence.Entity;
import java.io.Serializable;

@Entity
@Data
public class Endereco implements Serializable {

    private Long id;
    private String logradouro;
    private String numero;
    private String complemento;
    private String bairro;
    private String cep;

    private Cliente cliente;
    private Cidade cidade;
}
