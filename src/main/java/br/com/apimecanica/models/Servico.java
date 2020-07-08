/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.apimecanica.models;

import java.io.Serializable;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Antonio
 */

@ Entity
@Table(name = "servico", schema ="public")

@NamedQueries({
    @NamedQuery(name = "Servico.findAll", query = "SELECT p FROM Servico p"),
    @NamedQuery(name = "Servico.findByDescricao", query = "SELECT preco FROM Servico p where p.descricao LIKE :descricao")
})
public class Servico implements Serializable{
    
    @Id
    @GeneratedValue
    private UUID id;
    
    @Column(nullable = false, unique = true)
    private String descricao;
    
    @Column(nullable = false)
    private String tipo;
    
    @OneToOne
    @JoinColumn(name = "id_mecanico")
    private Mecanico tecnico;
    
    @Column(nullable = false)
    private String cobraca;
    
    @Column(nullable = false)
    private Float preco;

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

    public Mecanico getTecnico() {
        return tecnico;
    }

    public void setTecnico(Mecanico tecnico) {
        this.tecnico = tecnico;
    }

    public String getCobraca() {
        return cobraca;
    }

    public void setCobraca(String cobraca) {
        this.cobraca = cobraca;
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
