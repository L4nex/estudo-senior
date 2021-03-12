package br.com.senior.api.entity;

import br.com.senior.api.entity.enums.TipoCliente;
import lombok.Data;

import javax.persistence.Entity;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
public class Cliente implements Serializable {

    private Long id;
    private String nome;
    private String email;
    private String cpfOuCnpj;
    private Integer tipo;

    private List<Endereco> enderecos;
    private Set<String> telefones = new HashSet<>();

    public Cliente(TipoCliente tipo) {
        this.tipo = tipo.getCod();
    }

    public void setTipo(TipoCliente tipo) {
        this.tipo = tipo.getCod();
    }

    public TipoCliente getTipo() {
        return TipoCliente.toEnum(tipo);
    }
}
