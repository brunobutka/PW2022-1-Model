/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

/**
 *
 * @author 20201PF.CC0033
 */
@Entity
@Table(name = "permissao")
public class Permissao implements Serializable {
    
    @Id
    @NotBlank(message = "O nome deve ser informado")
    @Length(max = 20, message = "O nome não pode ter mais que {max} caracteres")
    @Column(name = "nome", length = 20, nullable = false) 
    private String nome;
    
    @NotBlank(message = "A descrição deve ser informada")
    @Length(max = 30, message = "A descrição não pode ter mais que {max} caracteres")
    @Column(name = "descricao", length = 30, nullable = false) 
    private String descricao;

    @ManyToMany
    @JoinTable(name = "permissoes",
            // se refere a classe Permissao
            joinColumns = 
                    @JoinColumn(name = "permissao", referencedColumnName = "nome",
                            nullable = false),
            // se refere ao tipo da lista <Usuario>
            inverseJoinColumns = 
                    @JoinColumn(name = "nome_usuario", referencedColumnName = "nome_usuario",
                            nullable = false)
            )
    private Set<Usuario> usuarios = new HashSet<>();
    
    public Permissao(){
        
    }
    
    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 73 * hash + Objects.hashCode(this.nome);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Permissao other = (Permissao) obj;
        return Objects.equals(this.nome, other.nome);
    }

    /**
     * @return the usuarios
     */
    public Set<Usuario> getUsuarios() {
        return usuarios;
    }

    /**
     * @param usuarios the usuarios to set
     */
    public void setUsuarios(Set<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
    
    
    
}
