package br.com.apimecanica.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 *
 * @author user
 */
@Entity
@Table(name = "servico", schema = "public")

public class Servico implements Serializable {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(nullable = false, unique = true)
    private String descricao;

    @Column(nullable = false)
    private String tipo;

    @Column(nullable = false)
    private String cobranca;

    @Column(nullable = false)
    private Float preco;

    @ManyToMany(mappedBy = "servicos")
    @JsonIgnore
    private List<Ordem> ordens = new ArrayList<>();
    
     public Servico() {
    }
     
     public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
    
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getCobranca() {
        return cobranca;
    }

    public void setCobranca(String cobranca) {
        this.cobranca = cobranca;
    }

    public Float getPreco() {
        return preco;
    }

    public void setPreco(Float preco) {
        this.preco = preco;
    }

    @Override
    public String toString() {
        return this.descricao;
    }
}
