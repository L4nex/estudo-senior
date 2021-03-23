package br.com.senior.api.entity;

import lombok.Data;

import javax.persistence.Entity;

@Data
public class PagamentoComCartao extends Pagamento {

    private Integer numeroDeParcelas;
}
