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
 * @author user
 */
@Entity
@Table(name = "peca", schema = "public")

@NamedQueries({
    @NamedQuery(name = "Peca.findAll", query = "SELECT p FROM Peca p"),
    @NamedQuery(name = "Peca.findByDescricao", query = "SELECT preco FROM Peca p where p.descricao LIKE :descricao")
})
public class Peca implements Serializable {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(nullable = false, unique = true)
    private String descricao;

    @Column(nullable = false)
    private String tipo;
    
    @Column(nullable = false)
    private String marca;
    
    @Column(nullable = false)
    private String cor;
    
    @Column(nullable = false)
    private Float preco;
    
    @Column(name = "imagem_url", nullable = false)
    private String imagemUrl;

    public Peca() {
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

    public Float getPreco() {
        return preco;
    }

    public void setPreco(Float preco) {
        this.preco = preco;
    }

    public String getImagemUrl() {
        return imagemUrl;
    }

    public void setImagemUrl(String imagemUrl) {
        this.imagemUrl = imagemUrl;
    }

    @Override
    public String toString() {
        return this.descricao;
    }
    
}
