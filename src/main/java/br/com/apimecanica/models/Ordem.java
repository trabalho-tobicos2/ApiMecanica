package br.com.apimecanica.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author user
 */
@Entity
@Table(name = "ordem", schema = "public")
public class Ordem implements Serializable {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(name = "data")
    @Temporal(TemporalType.DATE)
    private Date data;

    @OneToOne
    @JoinColumn(name = "id_cliente", referencedColumnName = "id")
    private Cliente cliente;

    @OneToOne
    @JoinColumn(name = "id_veiculo", referencedColumnName = "id")
    private Veiculo veiculo;

    @OneToOne
    @JoinColumn(name = "id_mecanico", referencedColumnName = "id")
    private Mecanico mecanico;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "ordem_peca", schema = "public",
            joinColumns = {
                @JoinColumn(name = "ordem_id")},
            inverseJoinColumns = {
                @JoinColumn(name = "peca_id")}
    )
    private List<Peca> pecas = new ArrayList<>();

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "ordem_servico", schema = "public",
            joinColumns = {
                @JoinColumn(name = "ordem_id")},
            inverseJoinColumns = {
                @JoinColumn(name = "servico_id")}
    )
    private List<Servico> servicos = new ArrayList<>();

    @Column(nullable = false)
    private Float totalServico;

    @Column(nullable = false)
    private Float totalPeca;

    @Column(nullable = false)
    private Float desconto;

    @Column(nullable = false)
    private Float totalBruto;

    @Column(nullable = false)
    private Float totalLiquido;

    public Ordem() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
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

    public Float getTotalPeca() {
        return totalPeca;
    }

    public void setTotalPeca(Float totalPeca) {
        this.totalPeca = totalPeca;
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

    @Override
    public String toString() {
        return this.id.toString();
    }
}
