package br.com.senior.api.entity;

import lombok.Data;

import javax.persistence.Entity;
import java.util.Date;

@Data
public class PagamentoComBoleto extends Pagamento {

    private Date dataVencimento;
    private Date dataPagamento;

}
