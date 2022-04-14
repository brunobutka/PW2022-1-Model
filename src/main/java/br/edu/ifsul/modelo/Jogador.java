/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 *
 * @author 20201PF.CC0033
 */
@Entity
@Table(name = "jogador")
public class Jogador extends Pessoa implements Serializable {
    
    @Min(value = 0, message = "O peso não pode ser negativo")
    @NotNull(message = "O peso deve ser informado")
    @Column(name = "peso", nullable = false, columnDefinition = "decimal(6,3)")
    private Double peso;
    
    @Min(value = 0, message = "A altura não pode ser negativa")
    @NotNull(message = "A altura deve ser informada")
    @Column(name = "altura", nullable = false, columnDefinition = "decimal(4,2)")
    private Double altura;
    
    @NotNull(message = "A posição deve ser informada")
    @ManyToOne
    @JoinColumn(name = "posicao", referencedColumnName = "id", nullable = false)
    private Posicao posicao;
    
    @NotNull(message = "O time deve ser informado")
    @ManyToOne
    @JoinColumn(name = "time_id", referencedColumnName = "id", nullable = false)
    private Time time;

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public Double getAltura() {
        return altura;
    }

    public void setAltura(Double altura) {
        this.altura = altura;
    }

    public Posicao getPosicao() {
        return posicao;
    }

    public void setPosicao(Posicao posicao) {
        this.posicao = posicao;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }
    
    
}
