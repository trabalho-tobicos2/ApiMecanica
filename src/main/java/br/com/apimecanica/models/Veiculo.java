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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Antonio
 */

@Entity
@Table(name = "veiculo", schema = "public")

@NamedQueries({
    @NamedQuery(name = "veiculo.findAll", query = "SELECT p FROM veiculo p"),
    @NamedQuery(name = "veiculo.findByDescricao", query = "SELECT descricao FROM veiculo p where p.descricao LIKE :descricao")
})
public class Veiculo implements Serializable{
    @Id
    @GeneratedValue
    private UUID id;
    
    @Column(nullable = false)
    private String descricao;
    
    @Column(nullable = false)
    private String placa;
    
    @Column(nullable = false)
    private String renavan;
    
    @Column(nullable = false)
    private String marca;
    
    @Column(nullable = false)
    private String cor;
    
    @Column(nullable = false)
    private String modelo;
    
    @Column(nullable = false)
    private String combustivel;

    public Veiculo() {
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

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getRenavan() {
        return renavan;
    }

    public void setRenavan(String renavan) {
        this.renavan = renavan;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getCombustivel() {
        return combustivel;
    }

    public void setCombustivel(String combustivel) {
        this.combustivel = combustivel;
    }
    
    
}
