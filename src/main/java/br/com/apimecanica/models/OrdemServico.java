/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.apimecanica.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Antonio
 */

@Entity
@Table(name = "ordemServico")

@NamedQueries({
    @NamedQuery(name = "ordemServico.findAll", query = "SELECT l FROM ordemServico l"),
    @NamedQuery(name = "ordemServico.findByCliente", query = "SELECT l FROM ordemServico l where l.cliente.nome LIKE :cliente.nome")
})
public class OrdemServico implements Serializable{
    
    @Id
    @GeneratedValue
    private UUID id;
    
    @OneToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;
    
    @OneToOne
    @JoinColumn(name = "id_veiculo")
    private Veiculo veiculo;
    
    @OneToOne
    @JoinColumn(name = "id_mecanico")
    private Mecanico mecanico;
    
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "ordes", schema = "public",
            joinColumns = { @JoinColumn(name = "ordem_id")},
            inverseJoinColumns = { @JoinColumn(name = "cliente_id")} 
    )
    private List<Peca> pecas = new ArrayList<>();
    
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "ordes", schema = "public",
            joinColumns = { @JoinColumn(name = "ordem_id")},
            inverseJoinColumns = { @JoinColumn(name = "servico_id")} 
        )    
    private List<Servico> servicos = new ArrayList<>();
    
    @Column(nullable = false)
    private Float totalServico;
    
    @Column(nullable = false)
    private Float totalStotalPecas;
    
    @Column(nullable = true)
    private Float desconto;
    
    @Column(nullable = false)
    private Float totalBruto;
    
    @Column(nullable = false)
    private Float totalLiquido;
    
    
    

    public OrdemServico() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public Mecanico getMecanico() {
        return mecanico;
    }

    public void setMecanico(Mecanico mecanico) {
        this.mecanico = mecanico;
    }

    public List<Peca> getPecas() {
        return pecas;
    }

    public void setPecas(List<Peca> pecas) {
        this.pecas = pecas;
    }

    public List<Servico> getServicos() {
        return servicos;
    }

    public void setServicos(List<Servico> servicos) {
        this.servicos = servicos;
    }

    public Float getTotalServico() {
        return totalServico;
    }

    public void setTotalServico(Float totalServico) {
        this.totalServico = totalServico;
    }

    public Float getTotalStotalPecas() {
        return totalStotalPecas;
    }

    public void setTotalStotalPecas(Float totalStotalPecas) {
        this.totalStotalPecas = totalStotalPecas;
    }

    public Float getDesconto() {
        return desconto;
    }

    public void setDesconto(Float desconto) {
        this.desconto = desconto;
    }

    public Float getTotalBruto() {
        return totalBruto;
    }

    public void setTotalBruto(Float totalBruto) {
        this.totalBruto = totalBruto;
    }

    public Float getTotalLiquido() {
        return totalLiquido;
    }

    public void setTotalLiquido(Float totalLiquido) {
        this.totalLiquido = totalLiquido;
    }
    
    
    
}
