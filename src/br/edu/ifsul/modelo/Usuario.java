/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author T-Gamer
 */
@Entity
@Table(name = "usuario")
public class Usuario implements Serializable {
    
    @Id
    @Length(max = 20, 
            message = "O nome de usuário não pode ter mais que {max} caracteres")
    @NotBlank(message = "O nome de usuário não pode ser em branco")
    @Column(name = "nome_usuario", length = 20, nullable = false)
    private String nomeUsuario;
    @Length(max = 10, 
            message = "A senha não pode ter mais que {max} caracteres")
    @NotBlank(message = "A senha não pode ser em branco")
    @Column(name = "senha", length = 10, nullable = false)    
    private String senha;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "permissoes", 
            joinColumns = 
                    @JoinColumn(name = "nome_usuario", referencedColumnName = "nome_usuario", 
                            nullable = false),
            inverseJoinColumns = 
                    @JoinColumn(name = "permissao", referencedColumnName = "nome", 
                            nullable = false))
    private Set<Permissao> permissoes = new HashSet<>();
    
    public Usuario(){
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Set<Permissao> getPermissoes() {
        return permissoes;
    }

    public void setPermissoes(Set<Permissao> permissoes) {
        this.permissoes = permissoes;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.nomeUsuario);
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
        final Usuario other = (Usuario) obj;
        if (!Objects.equals(this.nomeUsuario, other.nomeUsuario)) {
            return false;
        }
        return true;
    }
    
        
    
}