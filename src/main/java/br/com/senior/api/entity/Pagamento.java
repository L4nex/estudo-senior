package br.com.senior.api.entity;

import br.com.senior.api.entity.enums.EstadoPagamento;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Pagamento implements Serializable {

    @Id
    private Long id;

    private EstadoPagamento estado;

    @OneToOne
    @JoinColumn(name="pedido_id")

    @MapsId
    private Pedido pedido;


}
